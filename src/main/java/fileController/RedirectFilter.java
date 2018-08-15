//package fileController;
//public class RedirectFilter implements Filter {
//    public void doFilter(ServletRequest request, ServletResponse response,
//           FilterChain filterChain) throws IOException, ServletException {
// // 获取URL
//Long startTime = null;
//     if (log.isDebugEnabled())
//     {
//         startTime = System.currentTimeMillis();
//     }
//           HttpServletRequest httpRequest = (HttpServletRequest) request;
//                       String url = httpRequest.getRequestURL().toString();
//                   if (url == null || url.trim().length() == 0) {
//                                 return;
//                                                }
//                  if (url.indexOf(luceneCreateMapping) != -1
//                               || url.indexOf(luceneSearchMapping) != -1) {
//                            doFilterForxxx(request, response, url);
//                            } else {
//                                  doxxxx(request, response, url);
//                                 }
//      if (log.isDebugEnabled())
//     {
//         long endTime = System.currentTimeMillis();
//         Thread currentThread = Thread.currentThread();
//         String threadName = currentThread.getName();
//         log.debug("[" + threadName + "]" + "< "
//                 + this.getClass().getName() + " " + url + " "
//                 + (endTime - startTime) + " ms");
//     }
////激活下一个Filter
//filterChain.doFilter(request, response);
//
//     }
//}