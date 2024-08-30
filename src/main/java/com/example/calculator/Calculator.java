package com.example.calculator;

import com.example.calculator.exception.UnsupportedOperationException;
import java.util.Map;

public class Calculator {

    private final Map<Operation, OperationStrategy> operations;

    public Calculator(Map<Operation, OperationStrategy> operations) {
        this.operations = operations;
    }

    public Number calculate(Operation operation, Number num1, Number num2) {
        OperationStrategy strategy = operations.get(operation);
        if (strategy == null) {
            throw new UnsupportedOperationException("Operation not supported: " + operation);
        }
        return strategy.calculate(num1, num2);
    }

    public Number chainOperations(Number initial, Operation... operations) {
        Number result = initial;
        for (Operation operation : operations) {
            result = calculate(operation, result, initial);
        }
        return result;
    }
}
