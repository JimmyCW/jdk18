package com.wx.jdk18.run;

import java.io.File;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author weixing
 * @date 2018/10/20
 **/
public class RunMethod {
    public static void main(String[] args) {
        new Thread(() ->{
            System.out.println("a");
        }).start();
        File file = new File("e:/");
        String type = ".txt";
        String[] a = file.list((File dir, String name) -> dir.getName().endsWith(name));

        new Thread(uncheck(() -> {
            System.out.println("a");
        })).start();

        int[][] arrs = new int[1][];
    }
    /*
    * 你是否讨厌在Runnable实现中处理检查器异常？编写一个捕获所有异常的uncheck方法，再将它改造为不需要检查异常的方法。例如:
        new Thread(uncheck(
            () -> {
                System.out.println("Zzz");
                Thread.sleep(1000);
            })).start();
        //看，不需要catch(InterruptedException);
*/

    /**
     * @FunctionalInterface标记在接口上，“函数式接口”是指仅仅只包含一个抽象方法的接口。
     */
    @FunctionalInterface
    interface RunNotException {
        public abstract void run() throws Exception;
    }

    public static Runnable uncheck(RunNotException runNotExp) {
        return () -> {
            try {
                runNotExp.run();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        };
    }
    /*
    * 编写一个静态方法andThen,它接受两个Runnable实例作为参数，
    * 并返回一个分别运行这两个实例的Runnable对象。在main方法中
    * ，向andThen方法传递两个lambda表达式，并运行返回的实例。
    * */
    public static Runnable andThen(Runnable and, Runnable then) {
        return () -> {
            and.run();
            then.run();
        };
    }

    interface Collection2<T> {
        //用来将action应用到所有filter返回true的元素上。你能够如何使用它？
        default void forEachIf(Consumer<T> action, Predicate<T> filter) {
//            forEach(item -> {filter.test(item) ? action.accept(item);});
        }
    }
}
