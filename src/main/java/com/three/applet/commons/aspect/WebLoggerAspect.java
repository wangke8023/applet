package com.three.applet.commons.aspect;

import com.alibaba.fastjson.JSONObject;
import com.three.applet.commons.annotation.WebLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class WebLoggerAspect {
	@Pointcut("@annotation(com.three.applet.commons.annotation.WebLogger)")
	public void log() {}

	@Around("log()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime=System.currentTimeMillis();

		Object result=joinPoint.proceed();
		System.out.println("Response："+ JSONObject.toJSONString(result));
		System.out.println("耗时："+(System.currentTimeMillis()-startTime));

		return result;
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		System.out.println("==================Start=================");
		System.out.println("URL：" + request.getRequestURL().toString());
		System.out.println("Description：" + getLogValue(joinPoint));
		System.out.println("Method：" + request.getMethod().toString());

		//打印controller全路径及method
		System.out.println("Class Method：" + joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
		System.out.println("客户端IP：" + request.getRemoteAddr());

		System.out.println("请求参数：" + JSONObject.toJSONString(joinPoint.getArgs()));

	}

	private String getLogValue(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();

		WebLogger webLogger = method.getAnnotation(WebLogger.class);
		return webLogger.value();
	}

	@After("log()")
	public void doAfter() {
		System.out.println("==================End=================");
	}
}
