package com.example.calculator.config;

import com.example.calculator.*;
import com.example.calculator.operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<Operation, OperationStrategy> operationsMap() {
        Map<Operation, OperationStrategy> operations = new HashMap<>();
        operations.put(Operation.ADD, new AddOperation());
        operations.put(Operation.SUBTRACT, new SubtractOperation());
        operations.put(Operation.MULTIPLY, new MultiplyOperation());
        operations.put(Operation.DIVIDE, new DivideOperation());
        return operations;
    }

    @Bean
    public Calculator calculator(Map<Operation, OperationStrategy> operationsMap) {
        return new Calculator(operationsMap);
    }
}
