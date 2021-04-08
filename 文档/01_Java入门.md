Java入门

# 1.svn/git(github/码云)

> subversion 项目版本管理工具。 服务与企业项目。 协同开发。

```java
在计算机上  安装svn客户端程序。
  拉取/下载/同步  本地与服务器之间的资源。  服务器路径: svn://ip地址/资源    用户名/密码
  1.checkout 检测出
  绿色对勾: 代表着本地的资源的版本与服务里面资源版本是一致的。
      
  2. 将本地的资源上传到svn服务里面
     +标志: 标识着资源是我们新增的资源。  svn--->add--->commit
         
  3. 删除服务里面资源
      标识文件资源状态  删除状态
      删除或者修改: 红色的感叹号   标识本地资源的版本肯定与服务的版本不一致的。
          svn--->delete--->commit
```





# 2. Java基础

## 1. java是什么

> java是一门编程语言。

```java
1.机器语言  
2.汇编语言 命名+二进制  病毒软件
3.高级语言 java  C  C++ python ...
```



```java
1995--2021  sun 
2009年 oracle公司给收购。---> java  mysql oracle
jdk1.0--jdk1.16   
1. jdk1.6 
2. jdk1.7 老项目
3. jdk1.8 
4. jdk1.11  LTS  long time served    
```





## 2. 能做什么

> 学习任意一门编程语言，开发软件。

```java
软件：
   1. 系统软件  windows  linux  mac  C
   2. 应用软件  
      1. 基于pc: ev  typroa
      2. 基于browser: 淘宝  京东
      3. 基于移动端: android  ios   app       
```

```java
3大开发版本:
 1.JAVASE  java基础班  基于pc   swing/gui  javafx
 2.JAVAEE  java企业版 企业开发技术  web开发  基于browser
 3.JAVAME  java微型版  app开发+嵌入式开发
 4.JavaCard  sim卡       
```



## 3. 优势

> 相对于其它编程语言而言:  C++  

```java
1.语法简单。
2.面向对象语言。封装  继承  多态    
3.具有健壮性。 1. GC  垃圾回收对象。  2.异常处理机制 (一段程序出现异常  不影响其它程序的正常执行)   
4.多线程(jvm支持多线程开发)
5.分布式(RMI---> 远程接口访问  URL  Socket)
6.动态性(反射的机制)  java不是一门动态的语言。 C语言是动态语言(程序执行期间 动态更改类结构)
   程序运行期间  动态的操作类组成部分。(内省) 
7.可移植性/跨平台(一次编译  到处运行)       
```



## 4. 入门案例  HelloWorld.java

### 1. 术语

```java
1.jdk: java development kit java开发工具包        只要写代码  必须依赖jdk
2.jre: java runtime environment  java运行环境     只要想运行java程序  必须依赖jre
3.jvm: java virtual machine  java虚拟机   程序的真正的运行是在jvm里面(jvm里面 只认识class文件)  
```

```java
为什么java语言提供jvm运行程序?
  1.编译型语言   自己可以编译  C  本机执行
  2.解释型语言  html css  js  在浏览器上解释运行的。
    
 java语言既不属于编译型语言又不属于解释型语言。
 任意一个程序执行  必须提前编译。 程序员自己编译java程序。
```



### 2. 安装/配置

> 提前检测本机是否具备开发的环境:    java / javac/  jar / javadoc

![1615776016568](pic\javase_0315_.png)

> 编写java程序

```java
/**
 *@author: Lisa
 *@className:
 *@description:
 *@date:2021-03-15 12:00:00
 *@version:0.1
 *@since: 1.8
*/
public class HelloWorld{
	
	//注释:解释说明  单行注释  程序里面严格区分大小写
   //类名: 与文件名保持一致   大小驼峰 
   //注释不参与编译
	//程序的入口: 程序都是在jvm里面执行的
	/**
	*@description:
	*@param: strs
	*@param: strs
	*@return:
	*@throws:
	*/
	public static void main(String[] strs){	
		//功能实现
		//简单打印
		System.out.println("尚马教育\n");
		System.out.println(100);
		/*System.out.println(200);
		System.out.println(300);*/
	}
}
```



> ==配置运行环境==

```java
1. 直接方式
    path: C:\Program Files\Java\jdk1.8.0_261\bin    
2. 间接方式
    1. JAVA_HOME : jdk的根目录  C:\Program Files\Java\jdk1.8.0_261
        后面的很多工具是依赖于变量  tomcat        
    2. path:  jdk的bin目录  动态获得JAVA_HOME变量的数据   %JAVA_HOME%\bin
```





> 运行程序

```java
1. 先编译  编译出来class文件  javac 文件名称    javac HelloWorld.java
 dir: 查看当前路径下所有的子目录和子文件
 cd: 切换路径
2. 执行编译之后的class的文件
   java class文件的名称
          
  乱码:  编码格式不一致   unicide  GBK
  
```



> 注释

```java
1. 单行注释:  // 
2. 多行注释  /*  */
3. 文档注释   一般是对类/接口/枚举类/方法。   
    /**
    *@author: Lisa
    *@className:
    *@description:
    *@date:2021-03-15 12:00:00
    *@version:0.1
    *@since: 1.8
    */
```



# 3. IDE

> 集成开发环境。

```java
1. Eclipse
2. IDEA 
3. MyEclipse
4. NetBeans    
```



> 修改字体:  File--->settting

![1615779199019](pic\1615779199019.png)



> 修改编码格式:  	GBK/UTF-8   避免出现乱码

![1615779305065](pic\1615779305065.png)





> 代码智能补全

![1615779468149](pic\1615779468149.png)





> 更改注释颜色

![1615779827839](pic\1615779827839.png)



> 更改文档注释模板

![1615780165318](pic\1615780165318.png)

```java
/**
 *@author: ${USER}
 *@className: ${NAME}
 *@description:
 *@date: ${DATE} ${TIME}
 *@version:0.1
 *@since: 1.8
*/
```



> 包名

```java
//包名区分文件
//规范： 全部都是小写  公司域名的后缀名+公司名称+项目名称+其它
//www.baidu.com
//com/org/cn.baidu.demo.
//1.区分重名的文件
//2.分层开发
```



> module

```java
在empty project下面创建module
```



# ==4. 数据类型==

> 通过java程序表示学生的基本信息(在jvm内存里面存储学生的基本信息)

```java
学生:
   性别  男  char
   学号  1001 int
   年龄  20  byte
   姓名  张三   字符串 String  
   成绩  80.5  double
   是否是有个好学生  真  假  boolean
```



## 1. 分类

> 1. 引用数据类型     class  interface  数组  枚举类   ==默认值null==

> 2. 基本的数据类型   四类八种

> 1. 整数类型

| 类型                   | 所占内存      | 取值范围 | 默认值 |
| ---------------------- | ------------- | -------- | ------ |
| byte(字节)             | 1个字节  8位  | -128-127 | 0      |
| short(短整型)          | 2个字节  16位 |          | 0      |
| ==int(整型) 默认类型== | 4个字节  32位 |          | 0      |
| ==long(长整型)==       | 8个字节       |          | 0      |



> 2. 小数类型(几乎不使用   BigDecimal)

| 类型                        | 内存    | 取值范围 | 默认值 |
| --------------------------- | ------- | -------- | ------ |
| float(单精度)               | 4个字节 |          | 0.0F   |
| ==double(双精度) 默认类型== | 8个字节 |          | 0.0    |



> 3. 单字符类型   char    ‘男’    \u0000   65535  \u0000-\uffff   uincode字符(ASCII  0-127)

```java
所占内存与编码格式有关系.
    UTF-8: 字母或者数字  1个字节     汉字: 3个字节
    GBK: 2个字节
```



> 4. 布尔类型   boolean   true  ==false==   1个位   



## 2. 变量

> 通过变量标识不同类型的数据。是内存里面数据的标识。 代表一个数据。

```java
1. 全局变量
   [访问权限修饰符] [普通修饰符] 数据类型 变量名称 = 数据; 
2. 局部变量
    [普通修饰符] 数据类型 变量名称 = 数据; 
变量名称: 小写驼峰 
```



```java
public static void main(String[] args) {

        //通过变量维护不同的类型的数据
        //1.整数类型
        byte a = 100;

        short sh = 200;

        int num = 200;

        long lon = 200L;

        //2.小数类型
        float f = 10.0F;
        System.out.println(f);

        double dou = 10D;
        System.out.println(dou);

        //3.单字符
        char c1 = 'a';
        char c2 = 97;//ASCII
        char c3 = '\u0061';
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        //4.布尔类型
        boolean flag = false;//初始化一个变量

        //引用类型
        String str = "hello";

        System.out.println(flag);

        //1.声明一个变量
        int num1;
        //2.数据
        num1 = 100;
        System.out.println(num1);

    }
```



## 3. 变量内存存储

> 局部变量

> jvm内存存储划分:   栈  堆  元空间(方法区)  本地方法栈  寄存器

```java
栈内存的数据是共享。所有的局部变量的变量名称(引用)存储在栈内存。(基本类型+引用)--->变量名都在栈内存
    基本类型的数据存储在栈内存。
    
堆: 对象 。 常量池: 维护常量 
```



![](pic\内存存储 .png)

## 4. 数据类型转换

> 适合于基本类型转换。 相似类型的转换。

```java
一般都是与数值型的类型进行操作:
  byte-->short-->char--->int--->long--->float--->double
```

> 1.  自动转换(隐式转换)

```java
前提: 精度低的数据类型转换成精度高的数据类型
//1.自动转换
int num = 100;
long lon = num;//类型自动转换

System.out.println(lon);
double dou = num;
System.out.println(dou);    
```



> 2.  强制转换(需要程序员实现)

```java
前提: 精度高的数据类型转换成精度低的数据类型。 数据丢失(溢出)。
//2. 强制转换  目标类型  变量名 = (目标类型)源类型;
double d1 = 123.789;
int num1 = (int) d1;
System.out.println(num1);     
```



# ==5. 运算符==

## 1. 赋值运算符

| =                           | +=   | -=   | *=   | /=   | %=   |
| --------------------------- | ---- | ---- | ---- | ---- | ---- |
| =右边的数据 赋值给=左边变量 |      |      |      |      |      |



## 2. 算术运算符

| +    | -    | *    | /    | %           | ++     | --     | +    |
| ---- | ---- | ---- | ---- | ----------- | ------ | ------ | ---- |
| 加法 |      |      | 商   | 余数 模运算 | 自增+1 | 自减-1 | 拼接 |



```java
public static void main(String[] args) {

        //算术/赋值运算符
        int a = 10; // 将10赋值给a变量
        int b = 20;

//        System.out.println(a + b);//30
//        System.out.println(a - b);//-10
//        System.out.println(a * b);//200
//        System.out.println(a / b);//0
//        System.out.println(a % b);//10

//        a += b;//  a = a+b;
//        System.out.println(a);//30
//        a -= b;
//        System.out.println(a);//10
//        a *= b;
//        System.out.println(a);//200
//        a /= b;
//        System.out.println(a);//10
//        a %= b;
//        System.out.println(a);//10

        //++  --  也只有当前使用  在企业里面开发中 禁止使用  并不能够保证原子性
        int m = 100;
        int n = m--;// 先赋值 n=100 m自增+1

        System.out.println(m);//99
        System.out.println(n);//100

        n = --m;// m先自增+1  再赋值n
        System.out.println(m);//98
        System.out.println(n);//98

        System.out.println("-----------------------------------");
        int num = 100;
        num = num++;
        System.out.println(num);//100
//        //变量缓存机制
//        int temp = num;
//        num++;
//        num = temp;
        //+ 拼接
        String name = "张三";
        System.out.println("学生的姓名:"+name);

        System.out.println(10+20+30+"a"+30+40+50);//60a304050
        System.out.println("a:"+(10+20+30+40));//
 }
```



## 3. 比较运算符 boolean

| >    | <    | >=   | <=   | ==                          | !=   |
| ---- | ---- | ---- | ---- | --------------------------- | ---- |
|      |      |      |      | 比较2个变量的地址值是否相等 |      |

```java
 public static void main(String[] args) {

        //比较运算符
        int a = 10;
        int b = 10;
        System.out.println(a == b);//true

        String str1 = "hello";
        String str2 = "hello";

        String str3 = new String("hello");
        System.out.println(str3);
        System.out.println(str2);

        System.out.println(str1 == str2);//true
        System.out.println(str2==str3);//false

        //比较数据 equals()  字符串1.equals(字符串2);
        System.out.println(str2.equals(str3));
        System.out.println(str2!=str3);
    }
```

## 4. 逻辑运算符 boolean

| &&     | &      | \|\|   | \|     | ^        | !            |
| ------ | ------ | ------ | ------ | -------- | ------------ |
| 逻辑与 | 逻辑与 | 逻辑或 | 逻辑或 | 相同为假 | 取相反的结果 |



```java
位运算符: 转换成二进制  0  1
  &: 都为1  为1
  |: 有一个为1  为1 
  ^: 0 1 为1  
```

```java
public static void main(String[] args) {

        //逻辑运算符:  && vs  &
        //第一个表达式true 后面肯定要运算 这个时候使用&& 或者 & 没有区别的
        System.out.println((10 < 20) && (10 < 5));
        System.out.println((10 < 20) & (10 < 5));

        //第一个表达式false 后面就没有必要执行  && 短路与   推荐
        //&: 后面还是要运算
        System.out.println((10 > 20) && (10 > 5));
        System.out.println((10 > 20) & (10 > 5));


        System.out.println("--------------------------------");
        // 第一个表达式true  后面就没有必要执行 || 短路或   推荐
        // | : 后面逻辑正常执行
        System.out.println((10 < 20) || (10 < 5));
        System.out.println((10 < 20) | (10 < 5));

        //第一个表达式false  后面肯定要运算   这个时候使用&& 或者 & 没有区别的
        System.out.println((10 > 20) || (10 > 5));
        System.out.println((10 > 20) | (10 > 5));

        System.out.println(!true);

        System.out.println(true ^ true);


        System.out.println("----------------------------");
        System.out.println(56 ^ 78);//4
        // 2个为都为1 结果为1
        //0100
        //0111
        //0011
    }
```





## 5. 三元运算符

```java
语法:
   数据类型 变量 = (表达式boolean)?表达式1:表达式2;
   变量的类型肯定与表达式1/表达式2相似或者一致的类型。
```

```java
 public static void main(String[] args) {
        //获得任意3个整数最值
        //三元运算符
        //数据类型 变量 = (表达式boolean)?表达式1:表达式2;
        int a = 1000, b = 300, c = 30;

        long max = (a >= b) ? a : b;
        max = ((max >= c) ? max : c);
        System.out.println("最大值:" + max);
    }
```









