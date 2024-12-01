package com.example.calculator;

public class calculator {
    private double firstNumber;
    private char operator;

    public void Calculator() {
        firstNumber = 0.0;
        operator = '\u0000';
    }

    public void setFirstNumber(double number) {
        this.firstNumber = number;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    public double calculate(double secondNumber) {
        switch (operator) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return firstNumber / secondNumber;
            default:
                throw new IllegalStateException("No valid operator set");

        }

    }

    public void clear() {
        firstNumber = 0.0;
        operator = '\u0000';
    }
}
