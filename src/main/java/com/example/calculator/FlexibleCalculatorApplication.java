package com.example.calculator;
import com.example.calculator.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class FlexibleCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlexibleCalculatorApplication.class, args);

        // Example usage of Calculator bean after context is initialized
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = context.getBean(Calculator.class);

        // Example calculation
        Number result = calculator.calculate(Operation.MULTIPLY, 5, 10);
        System.out.println("Result of 5 * 10 = " + result);
    }
}
