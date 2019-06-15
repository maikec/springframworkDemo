# spring 示例、原理、使用场景
## IOC
<b>ioc也被称为DI，对象之间的依赖关系通过构成方法、工厂方法、或者之后的set 属性来创建。</b><br>
<b>Spring IOC 基于beans和context两个包实现，主要的由BeanFactory接口及其子接口ApplicationContext实现</b><br>
ApplicationContext表示Spring IOC，并负责对象的实例化、装配；spring容器通过获取对象的元数据(通过XML、注解、javaCode)
而获取到对象是结构<br>
配置元数据有三种方式:  
1、XML  
2、Annotation-based configuration（spring2.5）  
3、Java code(spring3.0)[@Configuration, @Bean, @Import, and @DependsOn]  
