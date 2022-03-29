package errors.examples;

public class StackOverflowErrorExamples {
/*
StackOverflowError из за рекурсии метода
 */
    public static int calculateFactorial(int number) {
        return number * calculateFactorial(number - 1);
    }
    /*
    StackOverflowError из за цикличной связи между классами
     */
    public void whenInstanceClassOne_thenThrowsException() {
        ClassOne obj = new ClassOne();
    }
    /*
    StackOverflowError из за цикличного вызова конструктора класса
     */
    public void whenInstanceAccountHolder_thenThrowsException() {
        AccountHolder holder = new AccountHolder();
    }

    /*
    Рабочие классы для примеров ошибки
     */
    public class AccountHolder {
        private String firstName;
        private String lastName;

        AccountHolder jointAccountHolder = new AccountHolder();
    }
    public class ClassOne {
        private int oneValue;
        private ClassTwo clsTwoInstance = null;

        public ClassOne() {
            oneValue = 0;
            clsTwoInstance = new ClassTwo();
        }

        public ClassOne(int oneValue, ClassTwo clsTwoInstance) {
            this.oneValue = oneValue;
            this.clsTwoInstance = clsTwoInstance;
        }
    }

    public class ClassTwo {
        private int twoValue;
        private ClassOne clsOneInstance = null;

        public ClassTwo() {
            twoValue = 10;
            clsOneInstance = new ClassOne();
        }

        public ClassTwo(int twoValue, ClassOne clsOneInstance) {
            this.twoValue = twoValue;
            this.clsOneInstance = clsOneInstance;
        }
    }
}
