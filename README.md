# MySpring5

## Spring框架概述

 
## 第一部分 IOC容器
Inversion of Control（控制反转）

***降低耦合度***，创建对象和对象之间的调用交给Spring管理
### 一. 底层原理
xml解析，工厂模式，反射

1. xml解析获得class属性的值， 全类名
2. 工厂类的getBean方法，通过反射创建对象
3. 底层就是对象工厂

### 二. 接口
spring提供的IOC容器的两种实现方式，

1. BeanFactory
    - spring内部使用的接口， 
    - 加载配置文件时不创建对象，使用的时候才创建，（懒汉式）
2. ApplicationContext
    - BeanFactory的自接口，提供更多的功能，供开发人员使用
 
3. 两个主要的实现类
    - ClassPathXmlApplicationContext
        - 路径从src开始
    - FileSystemXmlApplicationContext
        - 全路径，从根目录开始写，
 

### 三. IOC操作Bean管理
1. spring创建对象
2. spring属性注入
####  3. 基于xml方式
1. 创建对象
```xml
<bean id="user" class="com.lcy.spring5.User"></bean>
```
    * id： bean的别名
    * class： 全类名
2. 注入属性
DI：依赖注入，（注入属性）
    - set方法
        ```xml
            <bean id="user" class="com.lcy.spring5.User">
                <property name="age" value="13"></property>
                <property name="name" value="Xn"></property>
            </bean>
        ```
    - 参数构造注入
         ```xml
            <!--        3. 参数构造,注入属性-->
                <bean id="order" class="com.lcy.spring5.Order">
                    <constructor-arg name="id" value="1"></constructor-arg>
                    <constructor-arg name="price" value="100.0"></constructor-arg>
                </bean>
         ```
    - 可以注入null
         ```xml
            <property name="address">
                <null></null>
            </property>
         ```
    - 注入特殊符号
         ```xml
             <property name="id">
                 <value><![CDATA[<南京>]]></value>
             </property>  
         ```
         > value标签中中空格的话也会输出的，
         > 不注入属性值就为null

3. 类内部属性是一个外部bean
```xml
    <bean id="userService" class="com.lcy.service.UserService">
        <property name="userDAO" ref="userDAOimpl"></property>
    </bean>

    <bean id="userDAOimpl" class="com.lcy.dao.impl.UserDAOimpl"></bean>
```

> service里面有个属性dao， 用ref属性完成注入

4. 内部bean， 级联注入
员工属于部门， 一个部门多个员工，
```xml
   <!--        内部bean，property中，嵌套一层bean配置-->
    <bean id="emp" class="com.lcy.bean.Emp">
        <property name="name" value="Jack"></property>
        <property name="gender" value="Female"></property>
        <property name="dep">
            <bean id="dep" class="com.lcy.bean.Dep">
                <property name="name" value="IT"></property>
            </bean>
        </property>
    </bean>
```
> 使用内部bean的话，context不能获得内部嵌套的bean， 即无法getBean获得dep
> 用外部bean也可以实现，***不是只内部类的意思***

```xml
    <bean id="emp" class="com.lcy.bean.Emp">
        <property name="name" value="Jack"></property>
        <property name="gender" value="Female"></property>
        <property name="dep" ref="dep"></property>
    </bean>
    <bean id="dep" class="com.lcy.bean.Dep">
        <property name="name" value="IOT"></property>
    </bean>
```
```xml
        <bean id="dep" class="com.lcy.bean.Dep">
            <property name="name" value="IOT"></property>
        </bean>
<!--      下面这种，也是将所有的Dep都改了，不只是单独修改内部的dep-->
    <bean id="emp" class="com.lcy.bean.Emp">
        <property name="name" value="Jack"></property>
        <property name="gender" value="Female"></property>
        <property name="dep" ref="dep"></property>
        <property name="dep.name" value="IT"></property>
    </bean>
```

5. 注入集合类型属性
数组，List，Map
```java
    private String[] strArr;
    private List<Integer> list;
    private Map map;
```

```xml
    <bean id="collection" class="com.lcy.bean.CollectionInjection">
        <property name="strArr">
            <array>
                <value>aaa</value>
                <value>bbb</value>
            </array>
        </property>
        <property name="list">
            <list>
                <value>123</value>
                <value>456</value>
                <value>789</value>
            </list>
        </property>
        <property name="map">
            <map>
                <entry key="username" value="lcy"></entry>
                <entry key="password" value="123456"></entry>
            </map>
        </property>
    </bean>
```
> value用相对应的标签，
> 数组中注入整型？
> List中注入Integer？
> List中注入对象

`private List<Course> courseList;`
    
```xml
        <property name="courseList">
            <list>
                <ref bean="course1"></ref>
                <ref bean="course2"></ref>
            </list>
        </property>
    </bean>

    <bean id="course1" class="com.lcy.bean.Course">
        <property name="name" value="java"></property>
    </bean>
    <bean id="course2" class="com.lcy.bean.Course">
        <property name="name" value="js"></property>
    </bean>
```

6. 提取集合的公共部分， 
```xml
<!--        提取list集合，-->
<util:list id="courseList2">
    <ref bean="course1"></ref>
    <ref bean="course2"></ref>
</util:list>

    <bean id="course1" class="com.lcy.bean.Course">
        <property name="name" value="HTML"></property>
    </bean>
    <bean id="course2" class="com.lcy.bean.Course">
        <property name="name" value="spring5"></property>
    </bean>

<!--    将抽取出来的公共list，注入到CollectionInjection类对象collection2中-->
    <bean id="collection2" class="com.lcy.bean.CollectionInjection">
        <property name="list" ref="courseList2"></property>
    </bean>
```

> 只有注入集合中的对象元素时用 ref bean="xxx", 剩下都直接ref="id"

##### 3.2 FactoryBean
配置文件中定义的类型，和返回的对象类型可以不同，

```java
    // 返回的时Course类型， 配置的时Mybean类型，
    // 即配置一个工厂Bean，获取时传上面type的参数，就获取什么类型的对象
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("factorybean.xml");
    Course mybean = context.getBean("mybean", Course.class);
    // <bean id="mybean" class="com.lcy.factorybean.MyBean"></bean>
    System.out.println(mybean);
   
```

##### 3.3 bean的作用域
1. 可以设置，单实例还是多实例，默认是单实例对象
    - bean标签的scope属性，默认是singleton， 多实例：prototype
    - 设置成prototype后，不是在加载配置文件时创建对象，而是getbean时才创建
    
##### 3.4 bean的生命周期
1. 空参构造器 
2. set方法，
3. 配置初始化方法，bean标签里的init-method属性
4. 获得了bean对象
5. 销毁 ， 配置destroy-methid属性

> 初始化前后还有两个步骤，可以创建一个类实现 BeanPostProcessor接口，
> 完成接口中的分别在init前后执行的方法，
> 在配置文件汇总配置这个类即可， 这样配置文件中所有的类都会在init前后执行
   `<bean id="myBeanPostProcessor" class="com.lcy.bean.MyBeanPostProcessor"></bean>`

以Emp中有个Dep为例：

    dep 空参构造器
    dep setNameIOT
    postProcessBeforeInitialization
    dep init!
    postProcessAfterInitialization
    emp 空参构造器！
    emp setName
    emp setDep
    dep setNameIT
    postProcessBeforeInitialization
    emp init!
    postProcessAfterInitialization
    Emp{name='Jack', gender='Female', dep=Dep{name='IT'}}

##### 3.5 自动装配，（开发中一般用注解做）
1. bean标签的autowire属性，
2. byName根据名称，属性和id要一样， 
    - Emp里有个属性是dep， 则外部bean的id为dep，这样才可以     
3. byType是根据类型
    - 有歧义会报错，如外部bean有两个类型一样的，
    
##### 3.6 引入外部注入文件
1. 先引入context空间，
2. 导入外部配置文件
```xml
    <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${driverClassName}"></property>
        <property name="username" value="${username}"></property>
        <property name="password" value="${password}"></property>
        <property name="url" value="${url}"></property>
    </bean>
```    

####  4. 基于注解的方式   

##### 4.1 创建对象的注解
    - @Component
    - @Service
    - @Controller
    - @Repository
      
1. 引入依赖
aop.jar
2. 开启组建扫描
    ```xml
       <!--  先引入context名称空间， 然后指定扫描哪些类，看哪里有注解-->
        <context:component-scan base-package="com.lcy"></context:component-scan>
    ```
3. 给类上面加上注解即可
```java
//@Component(value = "userService")
//@Component("userService")
@Service
```
> 都可以，不写值的话，默认的是类名第一个字母小写
> 4个注解功能是一样的，只是给开发人员区分业务逻辑用的

4. 开启组建扫描的细节问题
    -   可以配置哪些需要扫描，和哪些不需要扫描
    -   配置只扫描@Service的
    -   配置除去@Repository的都扫描

```xml
    <context:component-scan base-package="com.lcy" use-default-filters="false">
            <context:include-filter type="annotation"
                                 expression="org.springframework.stereotype.Service"/>
    </context:component-scan>

    <context:component-scan base-package="com.lcy">
            <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
    </context:component-scan>
```


##### 4.2 属性注入
    - @AutoWired，  根据属性类型进行自动注入  （xml 中的 byType）
    - @Qualifier    叠加AutoWired使用， 根据属性名称, 可以找指定的， 同一个类型对象可能有多个
    - @Resource     类型和名称都可以， 默认值是根据类型， 加上name根据名称
    - @Value        注入普通类型属性

###### 4.2.1 @AutoWired
```java
    @Service
    public class UserService {
        @Autowired
        private UserDAO userDAO;
    }
```

###### 4.2.2 @Qualifier
```java
@Service
public class UserService {
    @Autowired
    @Qualifier("userDAOimpl")
    private UserDAO userDAO;
}
```
> 用@Qualifier，上面必须加上@AutoWired， 否则可以用Resource

###### 4.2.3 @Resource 
```java
@Service
public class UserService {
//    @Autowired
//    @Qualifier("userDAOimpl")
      @Resource(name = "userDAOimpl")
    private UserDAO userDAO;
```

###### 4.2.4 @Value 
```java
    @Value("defaultName")
    private String name;
```

##### 4.3 可以纯注解开发
省去配置文件，xml
```java
    @Configuration
    @ComponentScan(basePackages = {"com.lcy"})
    public class SpringConfig {
    }
```

## 第二部分 AOP