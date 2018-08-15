package javaTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import javaTestEntry.MD5Utils;
public class fileInputStreamTest {
	public static void main(String[] args) throws Exception {
 
		 File myfile= new File("E:/Download", "工具文件.zip");
		FileInputStream fileInputStream = new FileInputStream(myfile);
		 String filePath="E:/test1/工具文件.zip";
		 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        byte[] containter = new byte[1024];
	        int count = 0;
	        while ((count = fileInputStream.read(containter)) > 0) {
	        	byteArrayOutputStream.write(containter, 0, count);
	        }
	        ByteArrayInputStream byteArrayOutputStream1 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream1.mark(byteArrayOutputStream1.available() + 1);
            String md5= MD5Utils.generateFileMD5(byteArrayOutputStream1);
            byteArrayOutputStream1.reset();
            FileOutputStream out = new FileOutputStream(filePath);
            while ((count = byteArrayOutputStream1.read(containter)) > 0) {
	        	out.write(containter, 0, count);
	        }
            out.flush();
            out.close();
            byteArrayOutputStream.flush();
	        byteArrayOutputStream.close();
		System.out.println(md5);  
//		download("E:/Download/spring-tool-suite-3.9.1.RELEASE-e4.7.1a-win32-x86_64.zip","spring-tool",3600*1000);
	}
	
	
	
	
	 /**
     * 下载文件到本地
     *
     * @param urlString
     *          被下载的文件地址
     * @param filename
     *          本地文件名
     * @param timeout
     *          超时时间毫秒
     * @throws Exception
     *           各种异常
     */
    public static boolean download(String urlString, String filename,int timeout){
        boolean ret = false;
        File file = new File(filename);
        try {
            if(file.exists()){
                ret = true;
            }else{
                // 构造URL
                URL url = new URL(urlString);
                // 打开连接
                HttpURLConnection con = (HttpURLConnection )url.openConnection();
                con.setConnectTimeout(timeout);
                con.setReadTimeout(timeout);
                con.connect();
                int contentLength = con.getContentLength();
                // 输入流
                InputStream is = con.getInputStream();
                // 1K的数据缓冲
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                int len;
                // 输出的文件流

                File file2=new File("E:/test1");
                file2.mkdirs();
                if(file.isDirectory()){

                }else{
                    file.createNewFile();//创建文件
                }
                OutputStream os = new FileOutputStream(file);
                // 开始读取
                while ((len = is.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
                // 完毕，关闭所有链接
                os.close();
                is.close();
                if(contentLength != file.length()){
                    file.delete();
                    ret = false;
                }else{
                    ret = true;
                }
            }
        } catch (IOException e) {
            file.delete();
            ret = false;
           System.out.println("[VideoUtil:download]:\n" + " VIDEO URL：" + urlString + " \n NEW FILENAME:" + filename + " DOWNLOAD FAILED!! ");
        }finally {
            return ret;
        }
    }

    /**
     * 断点续传
     * @param urlString
     * @param filename
     * @param timeout
     * @return
     */
    public static boolean resumeDownload(String urlString, String filename,int timeout) throws Exception{
        boolean ret = false;
        File fileFinal = new File(filename);
        String tmpFileName = filename+".tmp";
        File file = new File(tmpFileName);

        try {
            if(fileFinal.exists()){
                ret = true;
            }else{
                long contentStart = 0;
                File file2=new File(file.getParent());

                if(file.exists()){
                    contentStart = file.length();
                }else{
                    file2.mkdirs();
                }
                // 构造URL
                URL url = new URL(urlString);
                // 打开连接
                HttpURLConnection con = (HttpURLConnection )url.openConnection();
                con.setConnectTimeout(timeout);
                con.setReadTimeout(timeout);
                //设置续传的点
                if(contentStart>0){
                    con.setRequestProperty("RANGE","bytes="+contentStart+"-");
                }
                con.connect();
                int contentLength = con.getContentLength();
                // 输入流
                InputStream is = con.getInputStream();
                // 100Kb的数据缓冲
                byte[] bs = new byte[100*1024];
                // 读取到的数据长度
                int len;
                RandomAccessFile oSavedFile = new RandomAccessFile(tmpFileName,"rw");
                oSavedFile.seek(contentStart);
                // 开始读取
                while ((len = is.read(bs)) != -1) {
                    oSavedFile.write(bs, 0, len);
                }
                // 完毕，关闭所有链接
                oSavedFile.close();
                is.close();
                file.renameTo(fileFinal);
                ret = true;
            }
        } catch (IOException e) {
            file.delete();
            ret = false;
            System.out.println("[VideoUtil:download]:\n" + " VIDEO URL：" + urlString + " \n NEW FILENAME:" + filename + " DOWNLOAD FAILED!! ");
            throw new Exception(e);
        }finally {
            return ret;
        }
    }

}
