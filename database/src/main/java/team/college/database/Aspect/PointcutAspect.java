package team.college.database.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutAspect {

    @Pointcut("execution(* team.college.database.*.*.*(..)) && args(Integer)")
    public void forAnyMethodWithArgsId(){}

    @Pointcut("execution(* team.college.database.service.CategoryService.*(..)) && args(Category)")
    public void forAnyMethodWithArgsCategory(){}

    @Pointcut("execution(* team.college.database.service.OrderService.*(..)) && args(Order)")
    public void forAnyMethodWithArgsOrder(){}

    @Pointcut("execution(* team.college.database.service.PaymentService.*(..)) && args(Payment)")
    public void forAnyMethodWithArgsPayment(){}

    @Pointcut("execution(* team.college.database.service.ProductService.*(..)) && args(Product)")
    public void forAnyMethodWithArgsProduct(){}

    @Pointcut("execution(* team.college.database.service.ProductService.buyProduct(..))")
    public void forBuyProduct(){}

    @Pointcut("execution(* team.college.database.service.ProductService.cancelProduct(..))")
    public void forCancelProduct(){}

    @Pointcut("execution(* team.college.database.service.UserService.loginUser(..))")
    public void forAnyMethodWithArgsUser(){}

    @Pointcut("execution(* team.college.database.service.UserService.getAll())")
    public void forReturnGetAllUser(){}

}
