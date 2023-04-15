package org.example.calculator.domain;

import org.example.calculator.tobe.*;

import java.util.List;

public class Calculator {
    /**
     * Refactoring 하기 전 코드
     */
//    public static int calculate(int operand1, String operator, int operand2) {
//        return ArithmeticOperator.calculate(operand1, operator, operand2);
//    }

    /**
     * Refactoring 후의 코드
     * 1. interface로 선언
     * 2. 4개의 구현체를 list로 받는다
     */
    private static final List<NewArithmeticOperator> arithmeticOperator = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    /**
     * 나눗셈에서	0을 나누는 경우 IllegalArgument 예외를 발생시킨다. 라는 조건 때문에 int -> PositiveNumber 으로 변경
     */
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperator.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));
    }
}
