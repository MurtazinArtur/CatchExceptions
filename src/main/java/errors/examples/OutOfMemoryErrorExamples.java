package errors.examples;

import javassist.ClassPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class OutOfMemoryErrorExamples {
    /*
    Ловим OutOfMemoryError: Java heap space загоняя заполнение листа в бесконечный цикл заполнения его массивами по 1Мб
     */
    public static void eatJavaMemoryFilingCollection() {
        List list = new ArrayList<>();
        int index = 1;
        while (true) {
            byte[] b = new byte[1048576];
            list.add(b);
            Runtime rt = Runtime.getRuntime();
            System.out.printf("[%d] free memory: %s%n", index++, rt.freeMemory());
        }
    }

    /*
 ловим java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler область постоянного поколения в памяти исчерпана.
 */
    public static void generateClassesForPermGem() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        for (int i = 0; i < 1000000000; i++) {
            Class c = pool.makeClass("com.saket.demo.Permgen" + i).toClass();
            System.out.println(c.getName());
        }
    }

    /*
 ловим java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler когда объем встроенной памяти, необходимый для метаданных класса переполнится.
 */
    public static void generateMetaspaceForClasses() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        for (int i = 0; i < 1000000; i++) {
            Class c = pool.makeClass(
                            "com.saket.demo.Metaspace" + i)
                    .toClass();
            System.out.println(c.getName());
        }
    }

}
