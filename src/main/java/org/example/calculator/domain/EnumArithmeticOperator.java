package org.example.calculator.domain;

import java.util.Arrays;

public enum EnumArithmeticOperator {
    ADDITION("+"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    EnumArithmeticOperator(String operator) {
        this.operator = operator;
    }

    // 외부에 노출되는 public interface
    public static int calculate(int operand1, String operator, int operand2) {

        EnumArithmeticOperator arithmeticOperator = Arrays.stream(values())// values() -> 모든 값을 가져온다
                .filter(v -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }


    // 추상메쏘드
    public abstract int arithmeticCalculate(final int operand1, final int operand2);
}
