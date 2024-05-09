package team.college.database.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class HandlingExceptionError {

    @Around("execution(* team.college.database.Aspect.PointcutAspect.forAnyMethodWithArgsId(..))")
    public void handleMethodWithArgsId(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = null;
        try {
            method = proceedingJoinPoint.getSignature().toShortString();
            proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("The Id of " + method + "method is Invalid :(");
        }
    }

    @Around("execution(* team.college.database.Aspect.PointcutAspect.forAnyMethodWithArgsCategory(..))")
    public void handleMethodWithArgsCategory(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = null;
        try {
            method = proceedingJoinPoint.getSignature().toShortString();
            proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("Error in Category of this " + method + "method :(");
        }
    }

    @Around("execution(* team.college.database.Aspect.PointcutAspect.forAnyMethodWithArgsOrder(..))")
    public void handleMethodWithArgsOrder(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = null;
        try {
            method = proceedingJoinPoint.getSignature().toShortString();
            proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("Error in Order of this " + method + "method :(");
        }
    }

    @Around("execution(* team.college.database.Aspect.PointcutAspect.forAnyMethodWithArgsPayment(..))")
    public void handleMethodWithArgsPayment(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = null;
        try {
            method = proceedingJoinPoint.getSignature().toShortString();
            proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("Error in Payment of this " + method + "method :(");
        }
    }

    @Around("execution(* team.college.database.Aspect.PointcutAspect.forAnyMethodWithArgsProduct(..))")
    public void handleMethodWithArgsProdduct(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = null;
        try {
            method = proceedingJoinPoint.getSignature().toShortString();
            proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("Error in Product of this " + method + "method :(");
        }
    }

    @Around("execution(* team.college.database.Aspect.PointcutAspect.forBuyProduct(..))")
    public void handleBuyProductMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = null;
        try {
            method = proceedingJoinPoint.getSignature().toShortString();
            System.out.println("Before buyProduct execution");
            proceedingJoinPoint.proceed();
            System.out.println("After buyProduct execution");

        } catch (Exception ex) {
            System.out.println("Exception occurred in " + method + "method");
        }
    }

    @Around("execution(* team.college.database.Aspect.PointcutAspect.forCancelProduct(..))")
    public void handleCancelProductMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = null;
        try {
            method = proceedingJoinPoint.getSignature().toShortString();
            System.out.println("Before cancel Product execution");
            proceedingJoinPoint.proceed();
            System.out.println("After cencel Product execution");

        } catch (Exception ex) {
            System.out.println("Exception occurred in " + method + "method");
        }
    }

    @Around("execution(* team.college.database.Aspect.PointcutAspect.forAnyMethodWithArgsUser(..))")
    public void handleMethodWithArgsUser(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = null;
        try {
            method = proceedingJoinPoint.getSignature().toShortString();
            proceedingJoinPoint.proceed();

        } catch (Exception ex) {
            System.out.println("Exception occurred in " + method + "method");
        }
    }

    @Around("execution(* team.college.database.Aspect.PointcutAspect.forReturnGetAllUser())")
    public void handleReturnAllUserMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = null;
        try {
            method = proceedingJoinPoint.getSignature().toShortString();
            proceedingJoinPoint.proceed();

        } catch (Exception ex) {
            System.out.println("Exception occurred in " + method + "method");
        }
    }

}
