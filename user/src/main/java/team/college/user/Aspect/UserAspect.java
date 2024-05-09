package team.college.user.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import team.college.user.model.User;

@Aspect
@Component
public class UserAspect {

    @Around("execution(* team.college.user.service.UserService.loginUser(..)) && args(user)")
    public Object aroundLoginUser(ProceedingJoinPoint joinPoint, User user) throws Throwable {
        System.out.println("Before logging in user: " + user.getEmail());

        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("After logging in user: " + user.getEmail());
        } catch (Exception ex) {
            System.out.println("Exception occurred while logging in user: " + user.getEmail());
            // System.out.println("Exception message: " + ex.getMessage());
            // throw ex;
        }
        return result;
    }

    // @Around("execution(* team.college.user.service.UserService.userPayments(Integer)) && args(user_id)")
    // public Object aroundUserPayments(ProceedingJoinPoint joinPoint, Integer user_id) throws Throwable {
    //     System.out.println("Before retrieving payments for user with ID: " + user_id);

    //     Object result = null;
    //     try {
    //         result = joinPoint.proceed();
    //         System.out.println("After retrieving payments for user with ID: " + user_id);
    //     } catch (Exception ex) {
    //         System.out.println("Exception occurred while retrieving payments for user with ID: " + user_id);
    //         // System.out.println("Exception message: " + ex.getMessage());
    //         // throw ex;
    //     }
    //     return result;
    // }

    @Around("execution(* team.college.user.service.UserService.getUser(Integer)) && args(user_id)")
    public Object aroundGetUser(ProceedingJoinPoint joinPoint, Integer user_id) throws Throwable {
        System.out.println("Before retrieving user with ID: " + user_id);

        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("After retrieving user with ID: " + user_id);
        } catch (Exception ex) {
            System.out.println("Exception occurred while retrieving user with ID: " + user_id);
            // System.out.println("Exception message: " + ex.getMessage());
            // throw ex;
        }
        return result;
    }
}
