//package fileController;
//public class FilterIPActionInterceptor extends AbstractInterceptor{
//    /** 日志控制. */
//    private final Log log = LogFactory.getLog(getClass());
// 
//    /**
//     * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
//     */
//    @Override
//    @SuppressWarnings("unchecked")
//    public String intercept(ActionInvocation invocation) throws Exception
//    {
//        String result = null;
//        // 获得当前方法名.
//        String methodName = invocation.getInvocationContext().getName();
//        String currIp = null;
//        try
//        {
//            if (invocation.getAction() instanceof PortletAction)
//            {
//                PortletAction action = (PortletAction) invocation.getAction();
//                currIp = action.getRequest().getRemoteAddr();
//            }
//            String ip = ApplicationResource.getHotValue("ALLOW_CACHE_IP");
// 
//            if (StringUtils.isBlank(ip) || StringUtils.isBlank(currIp))
//            {
//                log.error("允许刷新的IP不存在或当前请求的IP非法.");
//                throw new NoAllowIPException();
//            }
//            else
//            {
//                String[] ips = ip.split(",");
//                boolean errorIp = true;
//                for (String s : ips)
//                {
//                    if (s.equals(currIp))
//                        errorIp = false;
//                }
//                // 判断IP
//                if (errorIp)
//                    throw new NoAllowIPException();
//            }
//            result = invocation.invoke();//调用被拦截的方法
//        }
//        catch (Exception e)
//        {
//            log.error("异常类名:" + invocation.getAction().getClass());
//            log.error("异常方法:" + methodName, e);
//            throw e;
//        }
// 
//        return result;
//    }
// 
//}
