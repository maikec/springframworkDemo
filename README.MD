# spring 示例、原理、使用场景
## IOC
**ioc也被称为DI，即对象之间的依赖关系只能通过构成方法、工厂方法、或者之后的set 属性来创建。**  
**Spring IOC 基于beans和context两个包实现，主要的由BeanFactory接口及其子接口ApplicationContext实现**  
ApplicationContext表示Spring IOC，并负责对象的实例化、装配；spring容器通过获取对象的元数据(通过XML、注解、javaCode)而获取到对象是结构  
**配置元数据有三种方式:**    
1、XML  
2、Annotation-based configuration（spring2.5）  
3、Java code(spring3.0)[@Configuration, @Bean, @Import, and @DependsOn]  
## Bean  
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

![Aaron Swartz](https://docs.spring.io/spring/docs/5.1.8.RELEASE/spring-framework-reference/images/singleton.png)

![Aaron Swartz](https://docs.spring.io/spring/docs/5.1.8.RELEASE/spring-framework-reference/images/prototype.png)

@PostConstruct and @PreDestroy.

