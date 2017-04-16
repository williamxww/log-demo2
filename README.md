# log-demo

> 通过此项目从源码层次识别各个日志框架的优缺点

***

1. 研究日志源码.

    
    
2. 对比以下几种日志组件.

    * slf4j
    * slf4j-simple
    * log4j
    * log4j2
    * logback
    * Flume

3. 加强理解classLoader.

    `com.bow.log.classloader.ClassLoaderDemo`
    
    ```java
    package com.bow;
    
    public interface FooService {
        public String hello(String name);
    }
    ```
    
    ```xml
    <beans>
       <bean></bean>
    </beans>
    ```
