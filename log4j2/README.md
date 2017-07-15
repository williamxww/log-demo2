# 线程栈

## 初始化
at com.bow.log4j2.appender.ArchiveRollingFileAppender.createAppender(ArchiveRollingFileAppender.java:94)
at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:498)
at org.apache.logging.log4j.core.config.plugins.util.PluginBuilder.build(PluginBuilder.java:132)
at org.apache.logging.log4j.core.config.AbstractConfiguration.createPluginObject(AbstractConfiguration.java:942)
at org.apache.logging.log4j.core.config.AbstractConfiguration.createConfiguration(AbstractConfiguration.java:882)
at org.apache.logging.log4j.core.config.AbstractConfiguration.createConfiguration(AbstractConfiguration.java:874)
at org.apache.logging.log4j.core.config.AbstractConfiguration.doConfigure(AbstractConfiguration.java:498)
at org.apache.logging.log4j.core.config.AbstractConfiguration.initialize(AbstractConfiguration.java:227)
at org.apache.logging.log4j.core.config.AbstractConfiguration.start(AbstractConfiguration.java:239)
at org.apache.logging.log4j.core.LoggerContext.setConfiguration(LoggerContext.java:530)
at org.apache.logging.log4j.core.LoggerContext.start(LoggerContext.java:258)
at org.apache.logging.log4j.core.impl.Log4jContextFactory.getContext(Log4jContextFactory.java:178)
at org.apache.logging.log4j.core.config.Configurator.initialize(Configurator.java:85)
at org.apache.logging.log4j.core.config.Configurator.initialize(Configurator.java:67)
at com.bow.log4j2.appender.ConfigTest.main(ConfigTest.java:24)

## 加载组件
at org.apache.logging.log4j.core.config.plugins.util.PluginManager.collectPlugins(PluginManager.java:128)
at org.apache.logging.log4j.core.pattern.PatternParser.<init>(PatternParser.java:131)
at org.apache.logging.log4j.core.pattern.PatternParser.<init>(PatternParser.java:112)
at org.apache.logging.log4j.core.layout.PatternLayout.createPatternParser(PatternLayout.java:209)
at org.apache.logging.log4j.core.layout.PatternLayout.createSerializer(PatternLayout.java:123)
at org.apache.logging.log4j.core.layout.PatternLayout.<init>(PatternLayout.java:111)
at org.apache.logging.log4j.core.layout.PatternLayout.<init>(PatternLayout.java:58)
at org.apache.logging.log4j.core.layout.PatternLayout$Builder.build(PatternLayout.java:494)
at org.apache.logging.log4j.core.config.AbstractConfiguration.setToDefault(AbstractConfiguration.java:567)
at org.apache.logging.log4j.core.config.DefaultConfiguration.<init>(DefaultConfiguration.java:47)
at org.apache.logging.log4j.core.LoggerContext.<init>(LoggerContext.java:81)
at org.apache.logging.log4j.core.selector.ClassLoaderContextSelector.createContext(ClassLoaderContextSelector.java:171)
at org.apache.logging.log4j.core.selector.ClassLoaderContextSelector.locateContext(ClassLoaderContextSelector.java:145)
at org.apache.logging.log4j.core.selector.ClassLoaderContextSelector.getContext(ClassLoaderContextSelector.java:74)
at org.apache.logging.log4j.core.impl.Log4jContextFactory.getContext(Log4jContextFactory.java:169)
at org.apache.logging.log4j.core.config.Configurator.initialize(Configurator.java:85)
at org.apache.logging.log4j.core.config.Configurator.initialize(Configurator.java:67)
at com.bow.log4j2.appender.ConfigTest.main(ConfigTest.java:26)


## 输出日志
at org.apache.logging.log4j.core.appender.AbstractOutputStreamAppender.append(AbstractOutputStreamAppender.java:160)
at org.apache.logging.log4j.core.config.AppenderControl.tryCallAppender(AppenderControl.java:156)
at org.apache.logging.log4j.core.config.AppenderControl.callAppender0(AppenderControl.java:129)
at org.apache.logging.log4j.core.config.AppenderControl.callAppenderPreventRecursion(AppenderControl.java:120)
at org.apache.logging.log4j.core.config.AppenderControl.callAppender(AppenderControl.java:84)
at org.apache.logging.log4j.core.config.LoggerConfig.callAppenders(LoggerConfig.java:447)
at org.apache.logging.log4j.core.config.LoggerConfig.processLogEvent(LoggerConfig.java:432)
at org.apache.logging.log4j.core.config.LoggerConfig.log(LoggerConfig.java:416)
at org.apache.logging.log4j.core.config.LoggerConfig.log(LoggerConfig.java:402)
at org.apache.logging.log4j.core.config.AwaitCompletionReliabilityStrategy.log(AwaitCompletionReliabilityStrategy.java:63)
at org.apache.logging.log4j.core.Logger.logMessage(Logger.java:146)
at org.apache.logging.log4j.spi.AbstractLogger.logMessageSafely(AbstractLogger.java:2091)
at org.apache.logging.log4j.spi.AbstractLogger.logMessage(AbstractLogger.java:1988)
at org.apache.logging.log4j.spi.AbstractLogger.logIfEnabled(AbstractLogger.java:1960)
at org.apache.logging.log4j.spi.AbstractLogger.info(AbstractLogger.java:1297)
at com.bow.log4j2.appender.ConfigTest.main(ConfigTest.java:29)


# 常见问题

## plugin注解在什么地方读取
PluginManager.addPackage("com.bow.log4j2.appender");
org.apache.logging.log4j.core.config.plugins.util.PluginRegistry#loadFromPackage


## 怎么把框架日志输出
<configuration monitorInterval="60" status="TRACE">

## TimeBasedTriggeringPolicy
基于时间的触发策略。该策略主要是完成周期性的log文件封存工作。
有两个参数：
interval，integer型，指定两次封存动作之间的时间间隔。
modulate，boolean型，说明是否对封存时间进行调制。
若modulate=true，则封存时间将以0点为边界进行偏移计算。
比如，modulate=true，interval=4hours，那么假设上次封存日志的时间为03:00，则下次封存日志的时间为04:00，
之后的封存时间依次为08:00，12:00，16:00

## logger配置 additivity="false" includeLocation="true" 的作用
additivity如果为true则既会在本次logger中输出，又会在root logger中输出 
includeLocation 暂不知道。。。。。。