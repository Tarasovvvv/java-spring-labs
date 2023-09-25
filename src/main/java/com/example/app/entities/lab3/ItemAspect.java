package com.example.app.entities.lab3;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ItemAspect {
    @Before("execution(* com.example.app.entities.lab3.Addable.send(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Before " + methodName + " method.(Сработал Before) Args: " + Arrays.toString(args));
    }

    @AfterReturning(pointcut = "execution(* com.example.app.entities.lab3.Addable.send(..))", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName(); // Получение имени метода
        Object[] args = joinPoint.getArgs(); // Получение аргументов метода
        System.out.println("Метод " + methodName + " выполнен успешно.(Сработал AfterThrowing)");
        System.out.println("Аргументы: " + Arrays.toString(args));
        System.out.println("Результат: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.app.entities.lab3.Addable.send(..))", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After throwing from " + methodName + " method.(Сработал AfterThrowing) Exception: " + exception);
    }

    @After("execution(* com.example.app.entities.lab3.Addable.send(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("After " + methodName + " method.(Сработал After)");
        System.out.println("Аргументы: " + Arrays.toString(args));
    }

    @Around("execution(* com.example.app.entities.lab3.Addable.send(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Before " + methodName + " method.(Сработал Around)");
        Object result = joinPoint.proceed();
        System.out.println("After " + methodName + " method.(Сработал Around)");
        return result;
    }
}
