package com.bow.log.classloader;

/**
 * 在此目录下编译 javac DemoService.java  -encoding utf-8 -d .
 * 
 * @author vv
 * @since 2017/4/15.
 */
public class DemoService {

    public static void printCurrentLoader() {
        // 使用当前类的ClassLoader
        ClassLoader loader1 = DemoService.class.getClassLoader();
        // 使用当前线程的ClassLoader
        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        // 使用系统ClassLoader，即系统的入口点所使用的ClassLoader
        ClassLoader loader3 = ClassLoader.getSystemClassLoader();
        System.out.println("current class load by " + loader1);
        System.out.println("currentThread classLoader " + loader2);
        System.out.println("system classLoader" + loader3);
    }
}
