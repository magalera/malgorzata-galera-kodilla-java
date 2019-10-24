package com.kodilla.stream;

import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> (a + b));
        expressionExecutor.executeExpression(10, 5, (a, b) -> (a - b));
        expressionExecutor.executeExpression(10, 5, (a, b) -> (a * b));
        expressionExecutor.executeExpression(10, 5, (a, b) -> (a / b));

        expressionExecutor.executeExpression(20, 10, (FunctionalCalculator::addAToB));
        expressionExecutor.executeExpression(20, 10, (FunctionalCalculator::divideAByB));
        expressionExecutor.executeExpression(20, 10, (FunctionalCalculator::multiplyAByB));
        expressionExecutor.executeExpression(20, 10, (FunctionalCalculator::subBFromA));

        //Processor processor = new Processor();
        //Executor codeToExecute = ()-> System.out.println("This is an example text.");
        //processor.execute(codeToExecute);
        // albo bez tworzenia zmiennej:
        // processor.execute(()-> System.out.println("This is an example text."););
    }
}
