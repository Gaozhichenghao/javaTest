package zhujie;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class ServiceLogAspect {
	  public ThreadLocal<Long> local = new ThreadLocal<Long>();
	    
	   @Pointcut("@annotation(com.test.XXX.ServiceLong)")
	   public void pointCut() {
	     
	   }
	 
	   @Before("pointCut()")
	   public void before(JoinPoint point) {
	    String methodName = point.getTarget().getClass().getName()+"."+point.getSignature().getName();
	    local.set(System.currentTimeMillis());
	   }
	 
	  @After("pointCut()")
	   public void after(JoinPoint point) {
	    long start = local.get();
	    String methodName = point.getTarget().getClass().getName()+"."+point.getSignature().getName();
	    System.out.println(System.currentTimeMillis()-start);
	    }
	    
	  @AfterThrowing(pointcut="pointCut()",throwing="error")
	   public void throwing(JoinPoint point,Throwable error) {
	    System.out.println("error");
	    }
}
