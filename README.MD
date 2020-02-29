# base-exception-starter

在spring-boot-autoconfigure的基础之上，徒手写一个全局处理异常的starter

```java
   <dependency>
           <groupId>cn.kiwi.exception</groupId>
           <artifactId>base-exception-starter</artifactId>
           <version>0.0.1</version>
    </dependency>
     
```

# 处理

- 基于工厂模式的exception实例化全局管理
- 基于责任链模式的判定exception的等级，从而处理日志的警告去向
- 能够自由的扩展，更完善的处理未处理的情况

# 步骤
#### 初步
完成所有Configuration的自动化配置
- 基于springboot为先决容器
- DEBUG->DefaultListableBeanFactory中 beanDefinitionNames的beanName
- DEBUG->其抽象父类AbstractAutowireCapableBeanFactory中 doCreateBean 保证加载顺序的正确

#### 