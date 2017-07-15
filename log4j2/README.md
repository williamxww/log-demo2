
_初始化_
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

**加载组件**
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


`输出日志`
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


框架日志
2017-07-15 23:31:01,321 main DEBUG Loaded configuration from stream (1379 bytes, unknown location)
2017-07-15 23:31:01,325 main DEBUG Starting LoggerContext[name=266474c2] from configuration stream (1379 bytes, unknown location)
2017-07-15 23:31:01,326 main DEBUG Starting LoggerContext[name=266474c2, org.apache.logging.log4j.core.LoggerContext@2a5ca609] with configuration XmlConfiguration[location=stream (1379 bytes, unknown location)]...
2017-07-15 23:31:01,327 main DEBUG Shutdown hook enabled. Registering a new one.
2017-07-15 23:31:01,346 main DEBUG Initializing configuration XmlConfiguration[location=stream (1379 bytes, unknown location)]
2017-07-15 23:31:01,352 main DEBUG Installed script engines
2017-07-15 23:31:01,959 main DEBUG Oracle Nashorn Version: 1.8.0_111, Language: ECMAScript, Threading: Not Thread Safe, Compile: true, Names: {nashorn, Nashorn, js, JS, JavaScript, javascript, ECMAScript, ecmascript}
2017-07-15 23:31:01,960 main DEBUG PluginManager 'Core' found 110 plugins
2017-07-15 23:31:01,961 main DEBUG PluginManager 'Level' found 0 plugins
2017-07-15 23:31:01,969 main DEBUG 1 starting Log4j2 ConfigurationScheduler threads
2017-07-15 23:31:01,971 main DEBUG PluginManager 'Lookup' found 13 plugins
2017-07-15 23:31:01,973 main DEBUG Building Plugin[name=layout, class=org.apache.logging.log4j.core.layout.PatternLayout].
2017-07-15 23:31:01,990 main TRACE TypeConverterRegistry initializing.
2017-07-15 23:31:01,990 main DEBUG PluginManager 'TypeConverter' found 23 plugins
2017-07-15 23:31:02,012 main DEBUG PatternLayout$Builder(pattern="%d{HH:mm:ss.SSS} %-5level %class{36} %L %M - %msg%xEx%n", PatternSelector=null, Configuration, Replace=null, charset="null", alwaysWriteExceptions="null", noConsoleNoAnsi="null", header="null", footer="null")
2017-07-15 23:31:02,013 main DEBUG PluginManager 'Converter' found 41 plugins
2017-07-15 23:31:02,015 main DEBUG Building Plugin[name=appender, class=org.apache.logging.log4j.core.appender.ConsoleAppender].
2017-07-15 23:31:02,028 main DEBUG ConsoleAppender$Builder(target="SYSTEM_OUT", follow="null", direct="null", bufferedIo="null", bufferSize="null", immediateFlush="null", ignoreExceptions="null", PatternLayout(%d{HH:mm:ss.SSS} %-5level %class{36} %L %M - %msg%xEx%n), name="Console", Filter=null)
2017-07-15 23:31:02,029 main DEBUG Jansi is not installed, cannot find org.fusesource.jansi.WindowsAnsiOutputStream
2017-07-15 23:31:02,029 main DEBUG Starting OutputStreamManager SYSTEM_OUT.false.false
2017-07-15 23:31:02,030 main DEBUG Building Plugin[name=layout, class=org.apache.logging.log4j.core.layout.PatternLayout].
2017-07-15 23:31:02,031 main DEBUG PatternLayout$Builder(pattern="%d %p %C{1.} [%t] %m%n", PatternSelector=null, Configuration, Replace=null, charset="null", alwaysWriteExceptions="null", noConsoleNoAnsi="null", header="null", footer="null")
2017-07-15 23:31:02,062 main DEBUG Building Plugin[name=LineBasedTriggeringPolicy, class=com.bow.log4j2.appender.LineBasedTriggeringPolicy].
2017-07-15 23:31:02,074 main DEBUG createPolicy(size="10", maxElapsedTime="10")
2017-07-15 23:31:02,075 main DEBUG Building Plugin[name=Policies, class=org.apache.logging.log4j.core.appender.rolling.CompositeTriggeringPolicy].
2017-07-15 23:31:02,076 main DEBUG createPolicy(={SizeBasedTriggeringPolicy(size=10)})
2017-07-15 23:31:02,077 main DEBUG Building Plugin[name=DefaultArchiveRolloverStrategy, class=com.bow.log4j2.appender.DefaultArchiveRolloverStrategy].
2017-07-15 23:31:02,079 main DEBUG createStrategy(max="5", min="null", fileIndex="null", compressionLevel="null", Configuration)
2017-07-15 23:31:02,083 main DEBUG Building Plugin[name=appender, class=com.bow.log4j2.appender.ArchiveRollingFileAppender].
2017-07-15 23:31:02,089 main DEBUG createAppender(fileName="./test.log.gz", filePattern="./test-${date:MM-dd-yyyy}-%i.log.gz", append="null", name="archiveLog", bufferedIO="null", bufferSize="null", immediateFlush="null", Policies(CompositeTriggeringPolicy(policies=[SizeBasedTriggeringPolicy(size=10)])), DefaultArchiveRolloverStrategy(DefaultArchiveRolloverStrategy(min=1, max=5)), PatternLayout(%d %p %C{1.} [%t] %m%n), Filter=null, ignoreExceptions="null", advertise="null", advertiseURI="null", Configuration)
2017-07-15 23:31:02,095 main TRACE New file './test.log.gz' created = false
2017-07-15 23:31:02,096 main DEBUG Starting ArchiveRollingFileManager ./test.log.gz
2017-07-15 23:31:02,098 main DEBUG PluginManager 'FileConverter' found 2 plugins
2017-07-15 23:31:02,099 main DEBUG Building Plugin[name=appenders, class=org.apache.logging.log4j.core.config.AppendersPlugin].
2017-07-15 23:31:02,100 main DEBUG createAppenders(={Console, archiveLog})
2017-07-15 23:31:02,101 main DEBUG Building Plugin[name=AppenderRef, class=org.apache.logging.log4j.core.config.AppenderRef].
2017-07-15 23:31:02,102 main DEBUG createAppenderRef(ref="Console", level="null", Filter=null)
2017-07-15 23:31:02,103 main DEBUG Building Plugin[name=AppenderRef, class=org.apache.logging.log4j.core.config.AppenderRef].
2017-07-15 23:31:02,104 main DEBUG createAppenderRef(ref="archiveLog", level="null", Filter=null)
2017-07-15 23:31:02,104 main DEBUG Building Plugin[name=logger, class=org.apache.logging.log4j.core.config.LoggerConfig].
2017-07-15 23:31:02,108 main DEBUG createLogger(additivity="false", level="TRACE", name="com.bow.log4j2", includeLocation="true", ={Console, archiveLog}, ={}, Configuration, Filter=null)
2017-07-15 23:31:02,111 main DEBUG Building Plugin[name=logger, class=org.apache.logging.log4j.core.config.LoggerConfig].
2017-07-15 23:31:02,116 main DEBUG createLogger(additivity="true", level="TRACE", name="com.apache", includeLocation="null", ={}, ={}, Configuration, Filter=null)
2017-07-15 23:31:02,118 main DEBUG Building Plugin[name=AppenderRef, class=org.apache.logging.log4j.core.config.AppenderRef].
2017-07-15 23:31:02,119 main DEBUG createAppenderRef(ref="Console", level="null", Filter=null)
2017-07-15 23:31:02,120 main DEBUG Building Plugin[name=root, class=org.apache.logging.log4j.core.config.LoggerConfig$RootLogger].
2017-07-15 23:31:02,123 main DEBUG createLogger(additivity="null", level="DEBUG", includeLocation="null", ={Console}, ={}, Configuration, Filter=null)
2017-07-15 23:31:02,123 main DEBUG Building Plugin[name=loggers, class=org.apache.logging.log4j.core.config.LoggersPlugin].
2017-07-15 23:31:02,125 main DEBUG createLoggers(={com.bow.log4j2, com.apache, root})
2017-07-15 23:31:02,126 main DEBUG Configuration XmlConfiguration[location=stream (1379 bytes, unknown location)] initialized
2017-07-15 23:31:02,128 main DEBUG Starting configuration XmlConfiguration[location=stream (1379 bytes, unknown location)]
2017-07-15 23:31:02,132 main DEBUG Started configuration XmlConfiguration[location=stream (1379 bytes, unknown location)] OK.
2017-07-15 23:31:02,133 main TRACE Stopping org.apache.logging.log4j.core.config.DefaultConfiguration@4ee285c6...
2017-07-15 23:31:02,134 main TRACE DefaultConfiguration notified 1 ReliabilityStrategies that config will be stopped.
2017-07-15 23:31:02,134 main TRACE DefaultConfiguration stopping root LoggerConfig.
2017-07-15 23:31:02,135 main TRACE DefaultConfiguration notifying ReliabilityStrategies that appenders will be stopped.
2017-07-15 23:31:02,135 main TRACE DefaultConfiguration stopping remaining Appenders.
2017-07-15 23:31:02,136 main DEBUG Shutting down OutputStreamManager SYSTEM_OUT.false.false-1
2017-07-15 23:31:02,137 main DEBUG Shut down OutputStreamManager SYSTEM_OUT.false.false-1, all resources released: true
2017-07-15 23:31:02,137 main TRACE DefaultConfiguration stopped 1 remaining Appenders.
2017-07-15 23:31:02,137 main TRACE DefaultConfiguration cleaning Appenders from 1 LoggerConfigs.
2017-07-15 23:31:02,138 main DEBUG Stopped org.apache.logging.log4j.core.config.DefaultConfiguration@4ee285c6 OK
2017-07-15 23:31:02,215 main TRACE Reregistering MBeans after reconfigure. Selector=org.apache.logging.log4j.core.selector.ClassLoaderContextSelector@436813f3
2017-07-15 23:31:02,216 main TRACE Reregistering context (1/1): '266474c2' org.apache.logging.log4j.core.LoggerContext@2a5ca609
2017-07-15 23:31:02,220 main TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2'
2017-07-15 23:31:02,220 main TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2,component=StatusLogger'
2017-07-15 23:31:02,221 main TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2,component=ContextSelector'
2017-07-15 23:31:02,223 main TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2,component=Loggers,name=*'
2017-07-15 23:31:02,224 main TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2,component=Appenders,name=*'
2017-07-15 23:31:02,225 main TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2,component=AsyncAppenders,name=*'
2017-07-15 23:31:02,225 main TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2,component=AsyncLoggerRingBuffer'
2017-07-15 23:31:02,226 main TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2,component=Loggers,name=*,subtype=RingBuffer'
2017-07-15 23:31:02,229 main DEBUG Registering MBean org.apache.logging.log4j2:type=266474c2
2017-07-15 23:31:02,233 main DEBUG Registering MBean org.apache.logging.log4j2:type=266474c2,component=StatusLogger
2017-07-15 23:31:02,235 main DEBUG Registering MBean org.apache.logging.log4j2:type=266474c2,component=ContextSelector
2017-07-15 23:31:02,237 main DEBUG Registering MBean org.apache.logging.log4j2:type=266474c2,component=Loggers,name=
2017-07-15 23:31:02,243 main DEBUG Registering MBean org.apache.logging.log4j2:type=266474c2,component=Loggers,name=com.bow.log4j2
2017-07-15 23:31:02,245 main DEBUG Registering MBean org.apache.logging.log4j2:type=266474c2,component=Loggers,name=com.apache
2017-07-15 23:31:02,246 main DEBUG Registering MBean org.apache.logging.log4j2:type=266474c2,component=Appenders,name=Console
2017-07-15 23:31:02,247 main DEBUG Registering MBean org.apache.logging.log4j2:type=266474c2,component=Appenders,name=archiveLog
2017-07-15 23:31:02,249 main TRACE Using default SystemClock for timestamps.
2017-07-15 23:31:02,250 main TRACE Using DummyNanoClock for nanosecond timestamps.
2017-07-15 23:31:02,250 main DEBUG LoggerContext[name=266474c2, org.apache.logging.log4j.core.LoggerContext@2a5ca609] started OK with configuration XmlConfiguration[location=stream (1379 bytes, unknown location)].
23:31:02.259 INFO  com.bow.log4j2.appender.ConfigTest 29 main - ------------------
2017-07-15 23:31:02,262 pool-1-thread-1 DEBUG Stopping LoggerContext[name=266474c2, org.apache.logging.log4j.core.LoggerContext@2a5ca609]
2017-07-15 23:31:02,263 pool-1-thread-1 DEBUG Stopping LoggerContext[name=266474c2, org.apache.logging.log4j.core.LoggerContext@2a5ca609]...
2017-07-15 23:31:02,264 pool-1-thread-1 TRACE Unregistering 1 MBeans: [org.apache.logging.log4j2:type=266474c2]
2017-07-15 23:31:02,266 pool-1-thread-1 TRACE Unregistering 1 MBeans: [org.apache.logging.log4j2:type=266474c2,component=StatusLogger]
2017-07-15 23:31:02,266 pool-1-thread-1 TRACE Unregistering 1 MBeans: [org.apache.logging.log4j2:type=266474c2,component=ContextSelector]
2017-07-15 23:31:02,267 pool-1-thread-1 TRACE Unregistering 3 MBeans: [org.apache.logging.log4j2:type=266474c2,component=Loggers,name=com.bow.log4j2, org.apache.logging.log4j2:type=266474c2,component=Loggers,name=, org.apache.logging.log4j2:type=266474c2,component=Loggers,name=com.apache]
2017-07-15 23:31:02,269 pool-1-thread-1 TRACE Unregistering 2 MBeans: [org.apache.logging.log4j2:type=266474c2,component=Appenders,name=Console, org.apache.logging.log4j2:type=266474c2,component=Appenders,name=archiveLog]
2017-07-15 23:31:02,269 pool-1-thread-1 TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2,component=AsyncAppenders,name=*'
2017-07-15 23:31:02,270 pool-1-thread-1 TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2,component=AsyncLoggerRingBuffer'
2017-07-15 23:31:02,270 pool-1-thread-1 TRACE Unregistering but no MBeans found matching 'org.apache.logging.log4j2:type=266474c2,component=Loggers,name=*,subtype=RingBuffer'
2017-07-15 23:31:02,271 pool-1-thread-1 TRACE Stopping XmlConfiguration[location=stream (1379 bytes, unknown location)]...
2017-07-15 23:31:02,271 pool-1-thread-1 TRACE XmlConfiguration notified 4 ReliabilityStrategies that config will be stopped.
2017-07-15 23:31:02,271 pool-1-thread-1 TRACE XmlConfiguration stopping 3 LoggerConfigs.
2017-07-15 23:31:02,272 pool-1-thread-1 TRACE XmlConfiguration stopping root LoggerConfig.
2017-07-15 23:31:02,272 pool-1-thread-1 TRACE XmlConfiguration notifying ReliabilityStrategies that appenders will be stopped.
2017-07-15 23:31:02,272 pool-1-thread-1 TRACE XmlConfiguration stopping remaining Appenders.
2017-07-15 23:31:02,272 pool-1-thread-1 DEBUG Shutting down ArchiveRollingFileManager ./test.log.gz
2017-07-15 23:31:02,273 pool-1-thread-1 DEBUG Shut down ArchiveRollingFileManager ./test.log.gz, all resources released: true
2017-07-15 23:31:02,274 pool-1-thread-1 DEBUG Shutting down OutputStreamManager SYSTEM_OUT.false.false
2017-07-15 23:31:02,275 pool-1-thread-1 DEBUG Shut down OutputStreamManager SYSTEM_OUT.false.false, all resources released: true
2017-07-15 23:31:02,275 pool-1-thread-1 TRACE XmlConfiguration stopped 2 remaining Appenders.
2017-07-15 23:31:02,276 pool-1-thread-1 TRACE XmlConfiguration cleaning Appenders from 4 LoggerConfigs.
2017-07-15 23:31:02,277 pool-1-thread-1 DEBUG Log4j2 ConfigurationScheduler shutting down threads in java.util.concurrent.ScheduledThreadPoolExecutor@5c4ffbd5[Running, pool size = 1, active threads = 0, queued tasks = 1, completed tasks = 0]
2017-07-15 23:31:02,278 pool-1-thread-1 DEBUG Stopped XmlConfiguration[location=stream (1379 bytes, unknown location)] OK
2017-07-15 23:31:02,280 pool-1-thread-1 DEBUG Stopped LoggerContext[name=266474c2, org.apache.logging.log4j.core.LoggerContext@2a5ca609]...

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