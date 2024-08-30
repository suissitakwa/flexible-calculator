package com.example.calculator;
import com.example.calculator.operations.AddOperation;
import com.example.calculator.operations.SubtractOperation;
import com.example.calculator.operations.MultiplyOperation;
import com.example.calculator.operations.DivideOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        Map<Operation, OperationStrategy> operations = new HashMap<>();
        operations.put(Operation.ADD, new AddOperation());
        operations.put(Operation.SUBTRACT, new SubtractOperation());
        operations.put(Operation.MULTIPLY, new MultiplyOperation());
        operations.put(Operation.DIVIDE, new DivideOperation());
        calculator = new Calculator(operations);
    }

    @Test
    public void testAddition() {
        assertEquals(5.0, calculator.calculate(Operation.ADD, 2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1.0, calculator.calculate(Operation.SUBTRACT, 3, 2));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6.0, calculator.calculate(Operation.MULTIPLY, 2, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.calculate(Operation.DIVIDE, 6, 3));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 6, 0);
        });
    }
}
