# spring 示例、原理、使用场景
## 1.IOC
**ioc也被称为DI，即对象之间的依赖关系只能通过构成方法、工厂方法、或者之后的set 属性来创建。**  
**Spring IOC 基于beans和context两个包实现，主要的由BeanFactory接口及其子接口ApplicationContext实现**  
ApplicationContext表示Spring IOC，并负责对象的实例化、装配；spring容器通过获取对象的元数据(通过XML、注解、javaCode)而获取到对象是结构  
GenericApplicationContext AnnotationConfigApplicationContext 
**配置元数据有三种方式:**    
1、XML  
2、Annotation-based configuration（spring2.5）  
3、Java code(spring3.0)[@Configuration, @Bean, @Import, and @DependsOn]  
### bean lifecycle  
InitializingBean DisposableBean  
@PostConstruct and @PreDestroy  
init-method and destroy-method
### Bean  
**bean的定义是通过Spring 容器的BeanDefinition**
<table>
<thead>
<tr>
<td>Property</td>
<td>Explained in…​</td>
</tr>
</thead>
<tbody>
<tr>
<td>Class</td>
<td>Instantiating Beans​</td>
</tr>
<tr>
<td>Name</td>
<td>Naming Beans​</td>
</tr>
<tr>
<td>Scope</td>
<td>Bean Scopes​</td>
</tr>
<tr>
<td>Constructor arguments</td>
<td>Dependency Injection​</td>
</tr>
<tr>
<td>Properties</td>
<td>Dependency Injection</td>
</tr>
<tr>
<td>Autowiring mode</td>
<td>Autowiring Collaborators</td>
</tr>
<tr>
<td>Lazy initialization mode</td>
<td>Lazy-initialized Beans</td>
</tr>
<tr>
<td>Initialization method</td>
<td>Initialization Callbacks</td>
</tr>
<tr>
<td>Destruction method</td>
<td>Destruction Callbacks</td>
</tr>
</tbody>
</table>    

**Bean Scope**
<table>
<thead>
<tr>
<td>Scope</td><td>Description</td>
</tr>
</thead>
<tbody>
<tr>
<td>singleton</td>
<td>(Default) Scopes a single bean definition to a single object instance for each Spring IoC container.</td>
</tr>
<tr>
<td>prototype</td>
<td>Scopes a single bean definition to any number of object instances.</td>
</tr>
<tr>
<td>request</td>
<td>Scopes a single bean definition to the lifecycle of a single HTTP request. That is, each HTTP request has its own instance of a bean created off the back of a single bean definition. Only valid in the context of a web-aware Spring ApplicationContext.
</td>
</tr>
<tr>
<td>session</td>
<td>Scopes a single bean definition to the lifecycle of an HTTP Session. Only valid in the context of a web-aware Spring ApplicationContext.
</td>
</tr>
<tr>
<td>application</td>
<td>Scopes a single bean definition to the lifecycle of a ServletContext. Only valid in the context of a web-aware Spring ApplicationContext.
</td>
</tr>
<tr>
<td>websocket</td>
<td>Scopes a single bean definition to the lifecycle of a WebSocket. Only valid in the context of a web-aware Spring ApplicationContext.</td>
</tr>
</tbody>
</table>

### JSR330
<table>
<thead>
<td>Spring</td>
<td>javax.inject.*</td>
<td>javax.inject restrictions / comments</td>
</thead>
<tbody>
<tr>
<td>@Autowired</td>
<td>@Inject</td>
<td>@Inject has no 'required' attribute. Can be used with Java 8’s Optional instead.</td>
</tr>
<tr>
<td>@Component</td>
<td>@Named / @ManagedBean</td>
<td>JSR-330 does not provide a composable model, only a way to identify named components.
</td>
</tr>
<tr>
<td>@Scope("singleton")</td>
<td>@Singleton</td>
<td>The JSR-330 default scope is like Spring’s prototype. However, in order to keep it consistent with Spring’s general defaults, a JSR-330 bean declared in the Spring container is a singleton by default. In order to use a scope other than singleton, you should use Spring’s @Scope annotation. javax.inject also provides a @Scope annotation. Nevertheless, this one is only intended to be used for creating your own annotations.
</td>
</tr>
<tr>
<td>@Qualifier</td>
<td>@Qualifier / @Named</td>
<td>javax.inject.Qualifier is just a meta-annotation for building custom qualifiers. Concrete String qualifiers (like Spring’s @Qualifier with a value) can be associated through javax.inject.Named.</td>
</tr>
<tr>
<td>@Value</td>
<td>-</td>
<td>no equivalent.</td>
</tr>
<tr>
<td>@Required</td>
<td>-</td>
<td>no equivalent.</td>
</tr>
<tr>
<td>@Lazy</td>
<td>-</td>
<td>no equivalent.</td>
</tr>
<tr>
<td>ObjectFactory</td>
<td>Provider</td>
<td>javax.inject.Provider is a direct alternative to Spring’s ObjectFactory, only with a shorter get() method name. It can also be used in combination with Spring’s @Autowired or with non-annotated constructors and setter methods.</td>
</tr>
</tbody>
</table>

![Aaron Swartz](https://docs.spring.io/spring/docs/5.1.8.RELEASE/spring-framework-reference/images/singleton.png)

![Aaron Swartz](https://docs.spring.io/spring/docs/5.1.8.RELEASE/spring-framework-reference/images/prototype.png)

@PostConstruct and @PreDestroy.  
Annotation-based Container Configuration  
ComponentScan <=> <context:annotation-config>  <context:annotation-config>(相同的容器)  
@Require @Autowired @Bean @Order @Qualifier  @DependsOn @Primary @Profile @Value @PropertySource   
ClassPathXmlApplicationContext -> AnnotationConfigApplicationContext. AnnotationConfigWebApplicationContext  
@ComponentScan <=> \<context:component-scan> 
```
@Bean
@Profile("development") 
//@Profile("default")
public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.HSQL)
        .addScript("my-schema.sql")
        .addScript("my-test-data.sql")
        .build();
}  

AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
ctx.getEnvironment().setActiveProfiles("development");
ctx.register(SomeConfig.class, StandaloneDataConfig.class, JndiDataConfig.class);
ctx.refresh();

-Dspring.profiles.active="profile1,profile2"
```
**@PropertySource**
```
@Configuration
@PropertySource("classpath:/com/myco/app.properties")
public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setName(env.getProperty("testbean.name"));
        return testBean;
    }
}
```
### Standard and Custom Events @EventListener(4.2支持)
<table>
<thead>
<td>Event</td>
<td>Explanation</td>
</thead>
<tbody>
<tr>
<td>ContextRefreshedEvent</td>
<td>Published when the ApplicationContext is initialized or refreshed 
(for example, by using the refresh() method on the ConfigurableApplicationContext interface).
 Here, “initialized” means that all beans are loaded, post-processor beans are detected 
 and activated, singletons are pre-instantiated, 
 and the ApplicationContext object is ready for use. 
 As long as the context has not been closed, 
 a refresh can be triggered multiple times, 
 provided that the chosen ApplicationContext actually supports such “hot” refreshes. 
 For example, XmlWebApplicationContext supports hot refreshes, 
 but GenericApplicationContext does not.
</td>
</tr>
<tr>
<td>ContextStartedEvent</td>
<td>Published when the ApplicationContext is started by using the start() method on the ConfigurableApplicationContext interface. 
Here, “started” means that all Lifecycle beans receive an explicit start signal. 
Typically, this signal is used to restart beans after an explicit stop, 
but it may also be used to start components that have not been configured for autostart 
(for example, components that have not already started on initialization).
</td>
</tr>
<tr>
<td>ContextStoppedEvent</td>
<td>Published when the ApplicationContext is stopped by using the stop() method on the ConfigurableApplicationContext interface. 
Here, “stopped” means that all Lifecycle beans receive an explicit stop signal.
 A stopped context may be restarted through a start() call.
</td>
</tr>
<tr>
<td>ContextClosedEvent</td>
<td>Published when the ApplicationContext is closed by using the close() method on the ConfigurableApplicationContext interface. 
Here, “closed” means that all singleton beans are destroyed.
 A closed context reaches its end of life. It cannot be refreshed or restarted.
</td>
</tr>
<tr>
<td>RequestHandledEvent</td>
<td>A web-specific event telling all beans that an HTTP request has been serviced. T
his event is published after the request is complete.
 This event is only applicable to web applications that use Spring’s DispatcherServlet.
</td>
</tr>
</tbody>
</table>

**异步监听事件**
```
@EventListener
@Async
public void processBlackListEvent(BlackListEvent event) {
    // BlackListEvent is processed in a separate thread
}
```
**BeanFactory vs ApplicationContext**
<table>
<thead>
<td>Feature</td>
<td>BeanFactory</td>
<td>ApplicationContext</td>
</thead>
<tbody>
<tr>
<td>Bean instantiation/wiring</td>
<td>Yes</td>
<td>Yes</td>
</tr>
<tr>
<td>Integrated lifecycle management</td>
<td>No</td>
<td>Yes</td>
</tr>
<tr>
<td>Automatic BeanPostProcessor registration</td>
<td>No</td>
<td>Yes</td>
</tr>
<tr>
<td>Automatic BeanFactoryPostProcessor registration</td>
<td>No</td>
<td>Yes</td>
</tr>
<tr>
<td>Convenient MessageSource access (for internalization)</td>
<td>No</td>
<td>Yes</td>
</tr>
<tr>
<td>Built-in ApplicationEvent publication mechanism</td>
<td>No</td>
<td>Yes</td>
</tr>
</tbody>
<table>

## 2.Resources
Resource InputStreamSource  
ResourceLoader ResourceLoaderAware  
<table>
<thead>
<td>Prefix</td>
<td>Example</td>
<td>Explanation</td>
</thead>
<tbody>
<tr>
<td>classpath:</td>
<td>classpath:com/myapp/config.xml</td>
<td>Loaded from the classpath.</td>
</tr>
<tr>
<td>file:</td>
<td>file:///data/config.xml</td>
<td>Loaded as a URL from the filesystem. See also FileSystemResource Caveats.</td>
</tr>
<tr>
<td>http:</td>
<td>https://myserver/logo.png</td>
<td>Loaded as a URL.</td>
</tr>
<tr>
<td>(none)</td>
<td>/data/config.xml</td>
<td>Depends on the underlying ApplicationContext.</td>
</tr>
</tbody>
</table>

## 3.Validation, Data Binding, and Type Conversion
BeanWrapper DataBinder...
## 4.SpEL
*The expression language supports the following functionality:*
* Literal expressions
* Boolean and relational operators
* Regular expressions
* Class expressions
* Accessing properties, arrays, lists, and maps
* Method invocation
* Relational operators
* Assignment
* Calling constructors
* Bean references
* Array construction
* Inline lists
* Inline maps
* Ternary operator
* Variables
* User-defined functions
* Collection projection
* Collection selection
* Templated expressions

@Value("#{ systemProperties['user.region'] }")
    private String defaultLocale;
    
 @Value("#{ systemProperties['user.region'] }")
    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }    
    
## 5.Aspect Oriented Programming with Spring
**The key unit of modularity in OOP is the class, whereas in AOP the unit of modularity is the aspect**
* AOP Concepts  
**1.Aspect(@Aspect,**
**``` <aop:config>
       <aop:aspect id="myAspect" ref="aBean">
           ...
       </aop:aspect>
   </aop:config> ```
)**    
A modularization of a concern that cuts across multiple classes. 
Transaction management is a good example of a crosscutting concern in enterprise Java applications.  
**2.Join point**
 A point during the execution of a program, such as the execution of a method or the handling of an exception. 
 In Spring AOP, a join point always represents a method execution
**3.Advice**
Action taken by an aspect at a particular join point. 
Different types of advice include “around”, “before” and “after” advice. (Advice types are discussed later.) 
Many AOP frameworks, including Spring, model an advice as an interceptor 
and maintain a chain of interceptors around the join point. 
**4.Pointcut**
A predicate that matches join points.
Advice is associated with a pointcut expression and runs at any join point matched by the pointcut 
(for example, the execution of a method with a certain name)
**5.Target object**
 An object being advised by one or more aspects
**6.AOP proxy** 
 An object created by the AOP framework in order to implement the aspect contracts (advise method executions and so on).
  In the Spring Framework, an AOP proxy is a JDK dynamic proxy or a CGLIB proxy
 **7.Weaving**
 linking aspects with other application types or objects to create an advised object. This can be done at compile time
  (using the AspectJ compiler, for example), load time, or at runtime. Spring AOP,
   like other pure Java AOP frameworks, performs weaving at runtime.
 * Spring AOP advice
 <table>
 <thead>
 <td>advice type</td>
 <td>描述</td>
 </thead>
 <tbody>
 <tr>
 <td> Before advice</td>
 <td>Advice that runs before a join point but that does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).
 </td>
 </tr>
<tr>
<td> After returning advice</td>
<td>Advice to be run after a join point completes normally (for example, if a method returns without throwing an exception).
</td>
</tr>
<tr>
<td>After throwing advice</td>
<td>Advice to be executed if a method exits by throwing an exception.</td>
</tr>
<tr>
<td>After (finally) advice</td>
<td>Advice to be executed regardless of the means by which a join point exits (normal or exceptional return).
</td>
</tr>
<tr>
<td> Around advice</td>
<td>Advice that surrounds a join point such as a method invocation. This is the most powerful kind of advice. Around advice can perform custom behavior before and after the method invocation. It is also responsible for choosing whether to proceed to the join point or to shortcut the advised method execution by returning its own return value or throwing an exception
</td>
</tr>
</tbody>
</table>

* Spring AOP Capabilities and Goals
Spring AOP is implemented in pure Java (纯Java实现) 
Spring AOP currently supports only method execution join points (advising the execution of methods on Spring beans)
* AOP Proxies
Spring AOP defaults to using standard JDK dynamic proxies for AOP proxies.
 This enables any interface (or set of interfaces) to be proxied
* @AspectJ support
@EnableAspectJAutoProxy @Aspect @Pointcut    

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

<aop:aspectj-autoproxy/>

**Spring AOP supports the following AspectJ pointcut designators (PCD) for use in pointcut expressions:**

* execution: For matching method execution join points. This is the primary pointcut designator to use when working with Spring AOP.

* within: Limits matching to join points within certain types (the execution of a method declared within a matching type when using Spring AOP).

* this: Limits matching to join points (the execution of methods when using Spring AOP) where the bean reference (Spring AOP proxy) is an instance of the given type.

* target: Limits matching to join points (the execution of methods when using Spring AOP) where the target object (application object being proxied) is an instance of the given type.

* args: Limits matching to join points (the execution of methods when using Spring AOP) where the arguments are instances of the given types.

* @target: Limits matching to join points (the execution of methods when using Spring AOP) where the class of the executing object has an annotation of the given type.

* @args: Limits matching to join points (the execution of methods when using Spring AOP) where the runtime type of the actual arguments passed have annotations of the given types.

* @within: Limits matching to join points within types that have the given annotation (the execution of methods declared in types with the given annotation when using Spring AOP).

* @annotation: Limits matching to join points where the subject of the join point (the method being executed in Spring AOP) has the given annotation
