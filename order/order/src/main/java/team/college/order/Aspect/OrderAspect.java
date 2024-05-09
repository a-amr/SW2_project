package team.college.order.Aspect;


import org.aspectj.lang.annotation.AfterThrowing;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderAspect {

    @AfterThrowing(
            pointcut = "execution(* team.college.order.service.OrderService.*(..))",
            throwing = "ex"
    )
    public void afterMethodThrowing(Exception ex) {
        System.out.println("Exception occurred: Order is not found");
    }

}
