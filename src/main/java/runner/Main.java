package runner;

import errors.examples.StackOverflowErrorExamples;

import static errors.examples.OutOfMemoryErrorExamples.*;
import static errors.examples.StackOverflowErrorExamples.calculateFactorial;

public class Main {
    public static void main(String[] args) throws Exception {
        StackOverflowErrorExamples stackOverflowError = new StackOverflowErrorExamples();
        /*
        StackOverflowErrorExamples
         */

        //1
        stackOverflowError.whenInstanceClassOne_thenThrowsException();
        //2
        System.out.println(calculateFactorial(5));
        //3
        stackOverflowError.whenInstanceAccountHolder_thenThrowsException();

        /*
        OutOfMemoryErrorExamples
         */

        //1
        eatJavaMemoryFilingCollection();
        //2
        generateClassesForPermGem();
        //3
        generateMetaspaceForClasses();

    }
}
