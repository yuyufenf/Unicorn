package com.gundam.unicorn.config.intercepter;

import com.gundam.unicorn.utils.StringUtils;
import com.gundam.unicorn.utils.annotation.ValueNotBlank;
import com.gundam.unicorn.utils.exception.IsNullException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 拦截传递值进行非空判断
 * @author kampf
 * @date 2019/8/21 10:38
 */
@Aspect
@Component
public class ValueNotBlankCheck {
    private Logger log = LoggerFactory.getLogger(ValueNotBlankCheck.class);

    @Pointcut("execution(public * com.gundam.unicorn.main.controller..*.*(..))")
    public void pointCut(){
    }

    /**
     * 前置通知，在连接点之前执行的通知
     * @param
     */
    //TODO 作为后期开发时参考。现已无用
//    @Before("pointCut()")
//    public void doBefore(JoinPoint joinPoint){
//        log.debug("############Check Start############");
//    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        log.debug("############Check Start############");

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();

        //得到连接方法
        Method method = signature.getMethod();

        //获得方法注解，返回二维数组是为预防参数可能存在对位注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        //判断注解是否为空,为空则跳出
        if(parameterAnnotations == null || parameterAnnotations.length == 0){
            return proceedingJoinPoint.proceed();
        }

        //获取方法参数名
        //TODO 后期开发参考,现阶段无用
//        String[] paramNames = signature.getParameterNames();

        //获取参数值
        Object[] paramValues = proceedingJoinPoint.getArgs();

        //获取方法参数类型
        //TODO 后期开发参考,现阶段无用
//        Class<?>[] parameterTypes = method.getParameterTypes();

        //遍历所有方法注解，获取需要的注解
        for (int i = 0; i < parameterAnnotations.length; i++){
            for (int j = 0; j < parameterAnnotations[i].length; j++){
                //如果该参数前面的注解是ParamCheck的实例，并且notNull()=true,则进行非空校验
                if(parameterAnnotations[i][j] != null
                        && parameterAnnotations[i][j] instanceof ValueNotBlank
                        && ((ValueNotBlank) parameterAnnotations[i][j]).notNull()){
                    //根据自己需求只传输参数值以及注解自定义信息
                    paramIsNull(paramValues[i], ((ValueNotBlank) parameterAnnotations[i][j]).message());
                    break;
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     * @param joinPoint
     */
    //TODO 作为后期开发时参考。现已无用
//    @AfterReturning("pointCut()")
//    public void doAfter(JoinPoint joinPoint){
//        log.debug("############Check End############");
//    }

    /**
     * 参数非空校验，如果参数为空，则抛出ParamIsNullException异常
     * @param value
     */
    private void paramIsNull(Object value, String msg){
        if(StringUtils.isBlank(value)){
            throw new IsNullException(msg);
        }
    }
}
