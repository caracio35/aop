package model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class RegistroAspecteado {
    @Before("execution(@log * *(..))")
    public void registrar(JoinPoint joinPoint) {
        String nombre = joinPoint.getSignature().getName();
        System.out.println("Registro de " + nombre);
    }

}
