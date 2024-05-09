package team.college.payment.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PaymentAspect {
    @Around("execution(* team.college.payment.service.PaymentService.removePayment(Integer)) && args(payment_id)")
    public Object aroundRemovePayment(ProceedingJoinPoint joinPoint, Integer payment_id) throws Throwable {
        System.out.println("Before removing payment with ID: " + payment_id);
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("Payment with ID " + payment_id + " removed successfully");
        } catch (Exception ex) {
            System.out.println("Exception occurred while removing payment with ID: " + payment_id);
            // System.out.println("Exception message: " + ex.getMessage());
            // throw ex;
        }
        return result;
    }
}
