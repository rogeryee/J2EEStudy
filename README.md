####### 项目介绍 #######
1. 本工程包含了学习J2EE的多个例子，并集成了Typescript作为开发的环境。
2. 本工程的JAVA开发环境为JDK1.7
3. 工程采用Maven作为发布工具：
   1）clean ：清除Maven打包是的临时文件，本项目中还包括web/WEB-INF目录下的classes和lib目录
   2）package ： 生成war包，并且编译所有src目录下的java文件并复制到web/WEB-INF目录下的classes；
                另外，还会从maven的repository下将项目运行需要的JAR包复制到web/WEB-INF目录下的lib目录下
                注意：使用maven-dependency-plugin来复制jar包，并将includeScope设置为runtime，这样就会将scope＝provided或者test的dependency过滤。


#################
### Javascript ### 
#################

    Base : webapp/js_samples

	#### variable_test.html ####
	介绍：本例列举了javascript的变量使用的测试例子
	
	#### this_test.html ####
	介绍：本例列举了javascript中"this"关键字使用的例子
	
	
##################
####  Jersey   ### 
##################

	#### HelloWorldResource.java ####
	介绍：本例为入门的Hello Wolrd例子，展现了如何采用Jersey2.8+Tomcat8集成搭建RESTFul的架构，可以通过以下的URL来访问相应的服务：
	http://localhost:8888/jersey/services/helloworld
	http://localhost:8888/jersey/services/helloworld/user/Roger
	http://localhost:8888/jersey/services/helloworld/user?name=Roger
	
	
	#### JsonSupportResource.java ####
	介绍：本例展示了在Jersey服务中使用JSON对象，可以通过以下的URL来访问相应的服务：
	基于Jaxb的JSON支持 - http://localhost:8080/jersey/services/json/jaxb
	基于Jackson的JSON支持 - http://localhost:8080/jersey/services/json/jackson
	基于JSON Processing的JSON支持 - http://localhost:8080/jersey/services/json/jsonp
	
	
	#### RequestFilter.java ####
	介绍：本例展示了在Jersey服务中使用Filter，RequestFilter类可以捕获在request发送到server之前以及response返回给client之前。通过Filter可以进行用户验证、日志等操作。
	
	
	#### Logged.java ####
	介绍：本例展示了在Jersey服务中如何自定义的将Filter或Interceptor与具体的类或方法绑定。本例中创建了一个自定义的注释Logged，并对其添加了Namebinding的注释，这样可以给对应的Resource类和Filter类添加@Logged注释，
	这样只有添加了@Logged注释的方法才会触发Filter

	注意：在pom.xml中将hadoop1.2.1的dependency设置为provided，这样打包时不会用到hadoop1.2.1相关的jar包，否则会导致jersey的servlet无法正常启动。
	
##################
####  SLF4J    ### 
##################

	#### HelloWorld.java ####
	介绍：本例采用了SLF4J的框架+SLF4J-Simple实现了简单的日志输出.
	注意：确保classpath下只有 SLF4J-Simple的jar，而无logback的jar包，否则SLF4J会自动加载其中任一个。
	
	
	#### LogbackHelloWorld.java ####
	介绍：本例采用了SLF4J的框架+logback实现了简单的日志输出	
	注意：确保classpath下只有 logback的jar，而无SLF4J-Simple的jar包，否则SLF4J会自动加载其中任一个。


##################
####  Shiro    ### 
##################

	#### authentication\AuthenticationSample ####
	介绍：本例展示了用Shiro作为框架构建的登录/登出的验证。
	注意：使用ini配置文件时，如果用"classpath:xxxx.ini"的方式，则需要将该xxxx.ini文件放在根目录下，否则要使用绝对路径获取文件
	
	1. testLoginFromIniFile通过读取ini文件中的用户凭证，来验证用户信息
	2. testLoginFromCustomMutilpleRealm方法读取了ini的配置信息，但是该ini文件并不存放用户信息，而是指向了MyRealm1和MyRealm2这两个自定义的Realm的实现。
	3. testLoginFromJDBCRealm方法展示了如何采用JDBC的方式获取用户验证：
	   1) 需要在ini文件中配置jdbc数据源，并配置org.apache.shiro.realm.jdbc.JdbcRealm为Realm的实现类
	   2) JdbcRealm中默认查询语句为"select password from users where username = ?"，当然用户也可以继承JdbcRealm并override相应的方法，达到定制化查询语句的目的。

	4. testLoginFromCustomMutilpleRealmWithStrategy继承了验证的策略，在allSuccessful.ini文件中配置验证策略，本例用的是AllSuccessfulStrategy，即所有Realm验证成功才算成功，且返回所有Realm身份验证成功的
认证信息，Shiro还提供如下策略：
		FirstSuccessfulStrategy：只要有一个Realm验证成功即可，只返回第一个Realm身份验证成功的认证信息，其他的忽略；
		AtLeastOneSuccessfulStrategy：只要有一个Realm验证成功即可，和FirstSuccessfulStrategy不同，返回所有Realm身份验证成功的认证信息；


	#### authorization\AuthorizationSample ####
	介绍：本例展示了用Shiro作为框架构建的用户角色权限的验证。
	
	1. testRoles通过读取ini文件中的用户角色信息，来验证用户是否拥有角色
	2. testPermissions通过读取ini文件中的用户角色权限信息，来验证用户是否拥有权限
	3. testCustomPermission展示了如何使用自定义的权限和角色配置
	
	
	#### cryptography\CryptographySample ####
	介绍：本例展示了用Shiro进行加密解密的功能
	
	1. testBase64展现如何使用Base64进行加解密的过程。
	2. testHex展现如何使用16进制进行加解密的过程。
	3. testMd5展现如何使用MD5算法进行加解密的过程。
	4. testHash展现如何使用散列算法(sha1,sha256,sha384)进行加解密的过程。
	
	
#####################
####  Concurrency ### 
#####################

	#### ThreadInterruptTest.java ####	
	展示了如何使用Thread.interrupt()方法以及子线程如何使用Thread.isInterrupted()方法来判断当前线程的状态
	
	#### ProducerConsumerTest.java ####	
	展示了采用wait和notifyAll的方法来实现多线程中的消费者与生产者模式
	
	#### ProducerConsumerTest2.java ####	
	展示了采用BlockingQueue来实现多线程中的消费者与生产者模式
	
	#### ProducerConsumerTest3.java ####	
	展示了采用Lock和Condition来实现多线程中的消费者与生产者模式
	
	#### WaitNotifyTest.java ####	
	展示了wait和notify的使用，如果两个线程对于不同对象采用wait和notify，那么他们之间是不会产生影响的。

	#### ReentrantLockTest.java ####	
	展示了如何使用ReentrantLock来替代synchronized关键字的例子

	#### ReentrantReadWriteLockTest.java ####	
	展示了如何使用ReentrantReadWriteLockTest来分别获取读锁与写锁并保证线程互斥的操作。

	#### ConditionTest.java ####	
	展示了如何使用Condition来完成线程之间的通讯。
	
	#### SemaphoreTest.java ####	
	展示了如何使用Semaphore的功能
	
	#### CountDownLatchTest.java ####	
	展示了如何使用CountDownLatch的功能

	#### CyclicBarrierTest.java ####	
	展示了如何使用CyclicBarrier的功能

	#### PhaserTest.java ####	
	展示了如何使用Phaser的功能

	### ExecutorTest.java ####	
	展示了如何使用Executor框架创建线程池并执行任务
	
	### CallableAndRunnableTest.java ####	
	展示了Callable与Runnable的区别
	
	## ForkJoinTest.java ####	
	展示了如何使用Fork/Join框架以及RecursiveTask来进行并发计算的例子
	
	## ConcurrentLinkedDequeTest.java ####	
	展示了如何使用ConcurrentLinkedDeque例子，该集合为non-blocking

    ## StatementTest.java ####
    该例子实现了以下的并发情形：
    1. 若干个读数据的线程，从数组中读取数据
    2. 只有1个写数据线程，负责将数据按照原有的顺序写
    这样会产生多个读线程完成后，需要同步等待写线程的情况

#####################
#######   NIO  ######
#####################

	#### CopyFile.java ####
	展示了如何使用Channel和Buffer来读写文件

    #### NIOServer.java/NIOClient.java ####
    展示了如何使用SocketChannel和Selector来实现Server与Client之间无阻塞的通信

#####################
#######   Core  ######
#####################

	#### AutoCloseSample.java ####
	展示了如何使用试用JDK7中AutoCloseable接口

    #### DateTest.java ####
    展示了如何使用java.util.Date的方法，在JDK1.1以后，推荐使用Calendar来操作日期.

    #### SimpleDateFormatTest.java ####
    展示了如何使用DateFormat对日期进行格式化

    #### CalendarTest.java ####
    展示了如何使用Calendar对日期进行处理

    #### ServletTest.java ####
    展示了如何使用Servlet的例子
    在Servlet中可以通过getServletContext().getInitParameter("ContextParams")来获取在web.xml中定义的<context-param/>
    而定义在Servlet中的<init-param>可以通过config.getInitParameter("ServletInitParams")来获取（config为ServletConfig）

    #### ListenerTest.java ####
    展示了如何使用Listener和Context-param配合使用的例子

    #### FilterTest.java ####
    展示了如何使用Filter使用的例子

###########################
##### Design Pattern ######
###########################

	#### designpattern/factory/simpleFactory ####
	简单工厂的使用

    #### designpattern/factory/factoryMethod ####
    工厂方法的使用

    #### designpattern/factory/abstractFactory ####
    抽象工厂的使用

    #### designpattern/template ####
    模版模式的使用

    #### designpattern/Singleton ####
    单例模式的使用

    #### designpattern/decorator ####
    装饰模式的使用

    #### designpattern/adapter ####
    适配器模式的使用

######################
####### JUnit ########
######################

	#### CalculatorTest.java ####
	展示了一个最基础的使用JUnit4的例子


######################
####### Spring #######
######################

	#### spring/ioc/SampleBeanClient ####
	展示用spring产生Bean的各种例子。

	#### spring/ioc/BeanWithRequiredAnnotationClient ####
    展示如何使用@Required的例子

    #### spring/ioc/BeanWithAutowiredAnnotationClient ####
    展示如何使用@Autowired的例子

    #### spring/ioc/BeanConfigClient ####
    展示如何使用AnnotationConfigApplicationContext加载@Configuration，@Component以及使用Environment加载properties文件的例子

    #### spring/aop/annotation/AopClient ####
    展示用annoation来实现AOP的各种例子。

    #### spring/aop/annotation/AopClient ####
    展示用XML来实现AOP的各种例子。

######################
####### Hadoop #######
######################

	#### com.yee.study.hadoop.wordcount ####
	本Package中一共包含两个WordCount的程序，其中WordCount.java是采用旧版API编写，
	而WordCountNew.java是采用新版API编写。

	其中的output目录是临时存放编译完成的classes的目录，再每次重新编译前需要手动的清空。

	具体的操作指南可以参考包中的HowToRun文件

    #### com.yee.study.hadoop.stream.usingbash ####
    本例展示了如何使用hadoop streaming来执行任务，本例是利用hadoop streaming执行了shell脚本


######################
##### Utilities ######
######################

	#### CircularQueueTest.java ####
	展示了一个循环队列的例子

	#### timeout\* ####
    设置一个方法的执行超时，用Annotation和动态代理来实现。

    设计原则：将需要超时的方法标记为@Timeout("5000"),表示该方法执行超过5000MS时，将抛出超时异常。

    在系统加载类时，通过指定package或目录扫描类，找出有@Timeout标记的方法，将其类动态代理。在调用该方法时通过代理类来执行达到超时的效果。


