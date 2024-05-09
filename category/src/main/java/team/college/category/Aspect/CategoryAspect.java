package team.college.category.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CategoryAspect {
    @Around("execution(* team.college.category.service.CategoryService.removeCategory(Integer)) && args(categoryId)")
    public Object aroundRemoveCategory(ProceedingJoinPoint joinPoint, Integer categoryId) throws Throwable {
        System.out.println("Before removing category with ID: " + categoryId);

        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("Category with ID " + categoryId + " removed successfully");
        } catch (Exception ex) {
            System.out.println("Exception occurred while removing category with ID: " + categoryId);
            // System.out.println("Exception message: " + ex.getMessage());
            // throw ex;
        }
        return result;
    }

    @Around("execution(* team.college.category.service.CategoryService.getCategory(Integer)) && args(categoryId)")
    public Object aroundGetCategory(ProceedingJoinPoint joinPoint, Integer categoryId) throws Throwable {
        System.out.println("Before retrieving category with ID: " + categoryId);

        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("Category with ID " + categoryId + " retrieved successfully");
        } catch (Exception ex) {
            System.out.println("Exception occurred while retrieving category with ID: " + categoryId);
            // System.out.println("Exception message: " + ex.getMessage());
            // throw ex;
        }
        return result;
    }
}
