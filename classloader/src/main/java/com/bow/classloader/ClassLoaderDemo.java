package com.bow.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 *
 * 1. BootStrap ClassLoader负责加载java基础类，主要是 %JRE_HOME/lib/
 * 目录下的rt.jar、resources.jar、charsets.jar和class等<br/>
 *
 * 2. Extension ClassLoader负责加载java扩展类，主要是 %JRE_HOME/lib/ext 目录下的jar和class<br/>
 * 
 * 3. App ClassLoader负责加载当前java应用的classpath中的所有类<br/>
 *
 * 4. 通过URLClassLoader可以加载指定地址的class<br/>
 *
 * 由于classloader
 * 加载类用的是全盘负责委托机制。所谓全盘负责，即是当一个classloader加载一个Class的时候，这个Class所依赖的和引用的所有
 * Class也由这个classloader负责载入，除非是显式的使用另外一个classloader载入。
 * 所以，当我们自定义的classloader加载成功了com.company.MyClass以后，
 * MyClass里所有依赖的class都由这个classLoader来加载完成
 * 
 * @author vv
 * @since 2017/4/14.
 */
public class ClassLoaderDemo {

    /**
     * 获取BootStrap ClassLoader 加载类的地址
     */
    public static void printBootstrapPath() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
        // 通过下面方法也可以获取引导类加载器加载的地址
        System.out.println(System.getProperty("sun.boot.class.path"));
    }

    /**
     * 运行结果如下 <br/>
     * sun.misc.Launcher$AppClassLoader@330bedb4
     * sun.misc.Launcher$ExtClassLoader@5cad8086
     * 
     * 1.说明此类是由AppClassLoader加载的<br/>
     * 2.因为Bootstrap ClassLoader不是一个普通的Java类因此这里没有打印出
     *
     * 此类放到Extension
     * ClassLoader的加载目录下（JAVA_HOME/jre/lib/ext），则其会被ExtClassLoader加载
     *
     * 将ClassLoaderDemo.class放到JAVA_HOME/jre/classes目录下运行，会发现其被Bootstrap
     * ClassLoader加载
     *
     */
    public static void printAllClassLoader() {
        // 获得加载这个类的类加载器
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            // 获得父载器
            loader = loader.getParent();
        }
        System.out.println(loader);
    }

    public static void printCurrentLoader() {
        // 使用当前类的ClassLoader
        ClassLoader loader1 = ClassLoaderDemo.class.getClassLoader();
        // 使用当前线程的ClassLoader
        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        // 使用系统ClassLoader，即系统的入口点所使用的ClassLoader
        ClassLoader loader3 = ClassLoader.getSystemClassLoader();
        System.out.println("current class load by " + loader1);
        System.out.println("currentThread classLoader " + loader2);
        System.out.println("system classLoader" + loader3);
    }

    public static void findClassInClassPath() {
        // 通过AppClassLoader在classpath中找到所有的ClassLoaderDemo.class
        // file:/D:/repository/log-demo/target/classes/com/bow/log/classloader/ClassLoaderDemo.class
        URL currentClassPath = ClassLoader.getSystemResource("com/bow/log/classloader/ClassLoaderDemo.class");
        Enumeration<URL> paths = null;
        try {
            paths = ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (paths.hasMoreElements()) {
            System.out.println(paths.nextElement());
        }

    }

    public static void main(String[] args) {
        findClassInClassPath();
    }
}
