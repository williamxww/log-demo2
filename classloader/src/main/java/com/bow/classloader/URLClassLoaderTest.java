package com.bow.classloader;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 此类可以加载指定路径下的类classloader\class\com\bow\log\classloader\DemoService.class
 * 
 * @author vv
 * @since 2017/4/15.
 */
public class URLClassLoaderTest {

    /**
     * 通过URLClassLoader加载DemoService.class
     * 
     * @throws Exception e
     */
    public static void loadWithURLClassLoader() throws Exception {
        // 指定一个class path 路径，其下的class也可被载入，注意以分隔符/结尾
        String anotherClassPath = "D:/repository/log-demo/class/";
        URL[] urls = null;
        try {
            urls = new URL[] { new URL("file:" + anotherClassPath) };
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ClassLoader appClassLoader = URLClassLoaderTest.class.getClassLoader();
        URLClassLoader ucl = new URLClassLoader(urls, appClassLoader);
        Class clazz = ucl.loadClass("com.bow.log.classloader.DemoService");
        System.out.println(clazz.getClassLoader());
        Method method = clazz.getMethod("printCurrentLoader");
        method.invoke(null);
    }

    public static void main(String[] args) throws Exception {
        loadWithURLClassLoader();
    }

}
