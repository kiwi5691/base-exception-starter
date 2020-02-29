
# Bean
@Bean注解告诉方法:
产生一个Bean对象，然后这个Bean对象交给Spring管理。产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中。

需要在@Configuration注解下进行创建

@Scope("prototype")
prototype 是多例的，即每一次调用都会生成一个新的实例。
@DependsOn 指当前bean所依赖的bean。
```java
    @Bean("firstBean")
    @Scope("prototype")
    @DependsOn(value = {
            "secondBean",
            "thirdBean"
    })
    public FirstBean firstBean() {
        return new FirstBean();
    }
```
@Primary (先注册)的两种使用方式

- 与@Bean 一起使用，定义在方法上，方法级别的注解
- 与@Component 一起使用，定义在类上，类级别的注解

@Lazy  表明一个bean 是否延迟加载，可以作用在方法上，表示这个方法被延迟加载
# Conditional
```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) 
@Documented
public @interface Conditional {
    Class<? extends Condition>[] value();
}
```
需要传入一个Class数组，并且需要继承Condition接口
```java
public interface Condition {
    boolean matches(ConditionContext var1, AnnotatedTypeMetadata var2);
}
```

#### WindowsCondition类
```java
public class WindowsCondition implements Condition {
 
    /**
     * @param conditionContext:判断条件能使用的上下文环境
     * @param annotatedTypeMetadata:注解所在位置的注释信息
     * */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取ioc使用的beanFactory
//        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //获取类加载器
//        ClassLoader classLoader = conditionContext.getClassLoader();
        //获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //获取bean定义的注册类
//        BeanDefinitionRegistry registry = conditionContext.getRegistry();
 
        //获得当前系统名
        String property = environment.getProperty("os.name");
        //包含Windows则说明是windows系统，返回true
        if (property.contains("Windows")){
            return true;
        }
        return false;
    }
}
```
#### LinuxCondition类
```java
public class LinuxCondition implements Condition {
 
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
 
        Environment environment = conditionContext.getEnvironment();
 
        String property = environment.getProperty("os.name");
        if (property.contains("Linux")){
            return true;
        }
        return false;
    }
}
```

#### BeanConfig
```java

@Configuration
public class BeanConfig {
 
    //只有一个类时，大括号可以省略
    //如果WindowsCondition的实现方法返回true，则注入这个bean    
    @Conditional({WindowsCondition.class})
    @Bean(name = "bill")
    public Person person1(){
        return new Person("Bill Gates",62);
    }
 
    //如果LinuxCondition的实现方法返回true，则注入这个bean
    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person2(){
        return new Person("Linus",48);
    }
}
```
#### 多个条件类
@Conditional注解传入的是一个Class数组，存在多种条件类的情况

相当于短路运算符

```java
@Conditional({WindowsCondition.class,ObstinateCondition.class})
```


# @ConditionalOnBean、@ConditionalOnMissingBean
@Conditional注解后，又基于此注解推出了很多派生注解，比如@ConditionalOnBean、@ConditionalOnMissingBean、@ConditionalOnExpression、@ConditionalOnClass......动态注入bean变得更方便


#### ConditionalOnMissingBean
如果当前容器中已经有电脑bean了，就不注入备用电脑，如果没有，则注入备用电脑，这里需要使用到@ConditionalOnMissingBean 
```java
@Configuration
public class BeanConfig {
 
    @Bean(name = "notebookPC")
    public Computer computer1(){
        return new Computer("笔记本电脑");
    }
 
    @ConditionalOnMissingBean(Computer.class)
    @Bean("reservePC")
    public Computer computer2(){
        return new Computer("备用电脑");
    }
}
```
- @ConditionalOnBean         
- @ConditionalOnMissingBean     
- @ConditionalOnClass           
- @ConditionalOnMissingClass    
- @ConditionalOnProperty  

- @Autowired(required=false) //required=false 的意思就是允许当前的Bean对象为null。
 
 
 # @Import
 在应用中，有时没有把某个类注入到IOC容器中，但在运用的时候需要获取该类对应的bean，此时就需要用到@Import注解。也可以导入一个配置类 
 