package pl.filiphagno.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* pl.filiphagno.DAO.CustomerDAOImpl.*(..))")
    private void DAOPackage() {
    }

    @Pointcut("execution(* pl.filiphagno.service.CustomerServiceImpl.*(..))")
    private void servicePackage() {
    }

    @Pointcut("DAOPackage() || servicePackage()")
    public void forAppFlow() {
    }

    @Pointcut("execution(* pl.filiphagno.api.*.*(..))")
    public void restFlow() {

    }

    @Before("forAppFlow() || restFlow()")
    public void beforeMethod(JoinPoint joinpoint) {
        MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();

        Object[] args = joinpoint.getArgs();

        log.info("Calling: {}", methodSignature);

        for(Object arg: args){
            log.info("with argument: {}", arg.toString());
        }
    }

    @AfterReturning(pointcut = "forAppFlow() || restFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        log.info("Returning from: {} with value {}", methodSignature, result);
    }
}
