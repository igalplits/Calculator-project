package com.example.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainActivityTests {

    private calculator calculator;

    @Before
    public void setUp() {
        calculator = new calculator();
    }

    @Test
    public void testAddition() {
        calculator.setFirstNumber(5.0);
        calculator.setOperator('+');
        double result = calculator.calculate(3.0);
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testSubtraction() {
        calculator.setFirstNumber(5.0);
        calculator.setOperator('-');
        double result = calculator.calculate(3.0);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testMultiplication() {
        calculator.setFirstNumber(5.0);
        calculator.setOperator('*');
        double result = calculator.calculate(3.0);
        assertEquals(15.0, result, 0.001);
    }

    @Test
    public void testDivision() {
        calculator.setFirstNumber(6.0);
        calculator.setOperator('/');
        double result = calculator.calculate(3.0);
        assertEquals(2.0, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.setFirstNumber(6.0);
        calculator.setOperator('/');
        calculator.calculate(0.0);
    }

    @Test
    public void testClear() {
        calculator.setFirstNumber(10.0);
        calculator.setOperator('+');
        calculator.clear();
        assertEquals(0.0, calculator.getFirstNumber(), 0.001);
        assertEquals('\u0000', calculator.getOperator());
    }
}
