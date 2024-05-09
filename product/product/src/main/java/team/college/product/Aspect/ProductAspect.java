package team.college.product.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductAspect {
    @Around("execution(* team.college.product.service.ProductService.buyProduct(Integer, Integer, Integer)) && args(product_id, order_id, amount)")
    public Object aroundBuyProduct(ProceedingJoinPoint joinPoint, Integer product_id, Integer order_id, Integer amount) throws Throwable {
        System.out.println("Before buying product with ID: " + product_id + " for order ID: " + order_id + " and amount: " + amount);

        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("Product with ID " + product_id + " bought successfully");
        } catch (Exception ex) {
            System.out.println("Exception occurred while buying product with ID: " + product_id);
            // System.out.println("Exception message: " + ex.getMessage());
            // throw ex;
        }
        return result;
    }

    @Around("execution(* team.college.product.service.ProductService.cancelProduct(Integer, Integer)) && args(product_id, order_id)")
    public Object aroundCancelProduct(ProceedingJoinPoint joinPoint, Integer product_id, Integer order_id) throws Throwable {
        System.out.println("Before canceling product with ID: " + product_id + " from order ID: " + order_id);

        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("Product with ID " + product_id + " canceled successfully from order ID: " + order_id);
        } catch (Exception ex) {
            System.out.println("Exception occurred while canceling product with ID: " + product_id + " from order ID: " + order_id);
            // System.out.println("Exception message: " + ex.getMessage());
            // throw ex;
        }
        return result;
    }
}
