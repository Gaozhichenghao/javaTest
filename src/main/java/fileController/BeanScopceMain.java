//package fileController;
//import org.springframework.context.ApplicationContext; 
//import org.springframework.context.support.ClassPathXmlApplicationContext; 
// 
//public class BeanScopceMain 
//{ 
//    public static void main(String[] args) 
//    { 
//        String springConfig = "beanscope/spring-config.xml"; 
//        //创建一个SpringContainer 
//        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig); 
//         
//        //通过SpringContainer取得runnerBeanOne 
//        RunnerBeanRefToSingletonBean runnerBeanOne =  
//               context.getBean("runnerBeanOne", RunnerBeanRefToSingletonBean.class); 
//        //通过SpringContainer取得runnerBeanTwo 
//        RunnerBeanRefToSingletonBeanTwo runnerBeanTwo =  
//               context.getBean("runnerBeanTwo", RunnerBeanRefToSingletonBeanTwo.class);   
//        //通过SpringContainer取得singletonBean 
//        SingletonBean singletonBean =  
//               context.getBean("singletonBean", SingletonBean.class);       
//         
//        //输出上一次操作singltonBean的Bean名称， 
//        //因为在这之前没有对singletonBean的lastOperatedBy属性进行初始化，所以这里应该会输出none 
//        singletonBean.showLastOperateBean(); 
//         
//        //设置runnerBeanOne中singletonBean对象的上一次操作者信息为runnerBeanOne 
//        runnerBeanOne.setMyNameToSingletonBean(); 
//        //通过singletonBean输出上一次操作者信息 
//        singletonBean.showLastOperateBean(); 
//        //输出runnerBeanTwo中应用的singletonBean对象的上一次操作者信息 
//        runnerBeanTwo.showLastOprBeanOfSingletonBean(); 
//         
//       //设置runnerBeanOne中singletonBean对象的上一次操作者信息为runnerBeanTwo 
//       runnerBeanTwo.setMyNameToSingletonBean(); 
//       //通过singletonBean输出上一次操作者信息 
//        singletonBean.showLastOperateBean(); 
//       //输出runnerBeanOne中应用的singletonBean对象的上一次操作者信息 
//        runnerBeanOne.showLastOprBeanOfSingletonBean(); 
//    } 
// 
//} 