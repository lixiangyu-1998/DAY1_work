# Util常用工具类

> java.util.*

# 1. 日期类

## 1.1 Date

> 代表特定的日期。  jdk1.8   Date算是一个过时类。

```java
public class Date
extends Object
implements Serializable, Cloneable, Comparable<Date>
```

> 常用构造

```java
Date() 
Date(long date)  将特定毫秒数时间转换Date对象
```



> 常用方法

```java
long getTime()  
static Date from(Instant instant)  
Instant toInstant()     
```



```java
 Date date = new Date();//获得系统此刻的时间
System.out.println(date);//Wed Mar 31 16:05:13 CST 2021

System.out.println(date.getTime());
System.out.println(date.getYear()+1900);//121
System.out.println(date.getMonth()+1);//1-12  0-11
System.out.println(date.getDay());//这周的第几天
System.out.println(date.getDate());
System.out.println(date.getHours());
```















# 2. 格式化类 Format

## 2.1  格式化日期类 DateFormat

> SimpleDateFormat  线程不安全类。

> 字符串日期  与  Date   之间相互转换

```java
public class DateUtil {

    private DateUtil() {
    }

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    //肯定给用户看的
    public static String dateToStr(Date date) {
        Objects.requireNonNull(date);
        DateFormat dateFormat = new SimpleDateFormat(PATTERN);
        return dateFormat.format(date);
    }

    //肯定程序执行运算
    public static Date strToDate(String dateStr) {
        Objects.requireNonNull(dateStr);
        DateFormat dateFormat = new SimpleDateFormat(PATTERN);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
```



```java
//如何解决?  根本原因: 多个线程共用了同一个格式化日期对象
//1. 作为局部使用  弊端: 每调用一次方法 都会创建一个 20  浪费堆内存  占据很多空间
//2. 作为成员变量使用  只创建一个对象 占据1份堆内存   synchronized   弊端: 不符合并发的  效率很低
//3. 使用ThreadLocal解决: 目的: 为每个线程都创建一个自己的格式化日期对象
//2个日期对象 属于并发   以空间换时间
```



```java
public class DateUtil {

    private DateUtil() {
    }

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final ThreadLocal<DateFormat> THREAD_LOCAL = new ThreadLocal() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(PATTERN);
        }
    };
    
    //只是创建了一个THREAD_LOCAL常量 维护或者管理DateFormat对象的创建 销毁或者修改。  默认调用initialValue()

    //肯定给用户看的
    public static synchronized String dateToStr(Date date) {
        Objects.requireNonNull(date);
        return THREAD_LOCAL.get().format(date);
    }

    //肯定程序执行运算
    public static synchronized Date strToDate(String dateStr) {
        Objects.requireNonNull(dateStr);

        try {
            return THREAD_LOCAL.get().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
```











## 2.2 格式化数字  NumberFormat





