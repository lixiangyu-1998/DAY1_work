# Util常用工具类

> java.util.*

# 1. 日期/日历类

## 1.1 ==Date==

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



## 1.2 Calendar

> 特定的日历时间。

```java
public static void main(String[] args) {

        //1.创建Calendar的对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        //2.get(int filed);

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DATE));

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));//5

        //3.与date之间相互转换
        //Calendar 转 date
//        Date time = calendar.getTime();
        //Date 转 Calendar

//        Date date = new Date();
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.setTime(date);

        //2. 修改时间单位的数据 calendar.set()
        //calendar.set(2021,Calendar.MARCH,1,12,30,30);
        // +10
//        calendar.add(Calendar.DAY_OF_MONTH,10);
       // calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+10);

        //System.out.println(calendar.get(Calendar.DAY_OF_MONTH));


        //自己写一个日历信息  2021-4-1
        //获得特定月份最大的天数  30  31   28/29
//        calendar.add(Calendar.MONTH,1);
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("日\t1\t2\t3\t4\t5\t6");
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        System.out.println("\t\t\t\t"+1);

    }
```





## 1.3 ==LocalDate/LocalDateTime==

> java.time.*  里面维护的都是与日期和时间相关类或者接口。 线程安全  值不可变

```java
Instant 时间瞬时点  UTC 
LocalDate/LocalDateTime/LocalTime 获得本地系统时间  
mysql: 8+     Mybatis-plus.jar  
```



> LocalDate

```java
public final class LocalDate
extends Object
implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable
```

```java
 public LocalDate plus(long amountToAdd, TemporalUnit unit)
      TemporalUnit:标识时间单位  ChronoUnit
 Temporal plus(TemporalAmount amount)
        TemporalAmount:   间隔  Duration Period
```



```java
public static void main(String[] args) {

        //1.获得LocalDate实例
//        LocalDate.now();
//        LocalDate.of(year,month,day);

        LocalDate now = LocalDate.now();

        LocalDate localDate = LocalDate.of(2022, Month.MAY, 20);
        System.out.println(localDate);
        System.out.println(now);

//        Period period = now.until(localDate);
//        System.out.println(period.toString());//P-1M
//        System.out.println(period.getYears());
//        System.out.println(period.getMonths());
//        System.out.println(period.getDays());

        long days = now.until(localDate, ChronoUnit.YEARS);
        System.out.println(days);
        
//
//        System.out.println(now.getYear());
//        System.out.println(now.getMonth());
//        System.out.println(now.getMonthValue());
//        System.out.println(now.getDayOfMonth());

        //修改
//        now = now.plusDays(20);
//        now = now.plusYears(1);

//        now =  now.plus(20,ChronoUnit.DAYS);
//        now = now.plus(Period.ofYears(1));


    }
```





# 2. 格式化类 Format

## 2.1  格式化日期类 DateFormat

### 1. ==SimpleDateFormat== 

>  线程不安全类。

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





### 2. ==DateTimeFormatter==

```java
 private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);//2021-04-01T10:52:13.216

        //localDateTime 转  String
//        String format = FORMATTER.format(localDateTime);
//        System.out.println(format);

        String create_time = "2007-12-03 10:15:30";
        Emp emp = new Emp();


        //字符串转哪一个Local对象 就调用这个类里面的parse方法
        LocalDateTime localDateTime1 = LocalDateTime.parse(create_time, FORMATTER);
        System.out.println(localDateTime1);

        emp.setCreate_time(localDateTime1);
        
        String birthday = "2021-01-01";
        emp.setBirthday(LocalDate.parse(birthday));
        System.out.println(emp);
    }
```









## 2.2 格式化数字  NumberFormat

> 格式化最后结果都是字符串类型。  DecimalFormat

```java
1. 保留小数点后面几位    
2. 将小数转换成百分数    
3. 格式化金钱     
```

```java

    public static void main(String[] args) {

//        long round = Math.round(1.56789);
//        System.out.println(round);

        //1.保留2位数字
//        double num = 100.56789865;
//        NumberFormat numberFormat = new DecimalFormat("##.###");
//        String result = numberFormat.format(num);
//        System.out.println(result);

        //2.百分数
//        double num = 0.56788865;
//        NumberFormat numberFormat = new DecimalFormat(".###%");
//        String result = numberFormat.format(num);
//        System.out.println(result);
//
        //3.格式化金钱
        double money = 187346343763.5325647;
        NumberFormat numberFormat = new DecimalFormat("#,###.####");
        String result = numberFormat.format(money);
        System.out.println(result);
        

    }
```

# 3. 随机数类 Random

> ThreadLocalRandom  随机数

```java
Random() 
Random(long seed)     
```

```java
public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();//seed: 当前纳秒数
            for (int j = 0; j < 5; j++) {
                int num = random.nextInt(100);
                System.out.print(num + ", ");
            }
            System.out.println();
        }

        System.out.println("---------------------------");

        //伪随机
        for (int i = 0; i < 5; i++) {
            Random random = new Random(100);
            for (int j = 0; j < 5; j++) {
                int num = random.nextInt(100);
                System.out.print(num + ", ");
            }
            System.out.println();
        }

        //Random 类线程安全类  性能降低: 多个线程使用同一个种子计算随机数值
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int anInt = random.nextInt(1000, 10000);
    }
```





# 4. 编码/解码类

> 编码:   加密   将看的懂的数据转换成看不懂的内容

> 解码： 解密   将看不懂的内容转换成看的懂的数据

```java
路径, 参数，用户基本信息
```

## 1. Base64

```java
public class Base64Demo {

    private static final String ENCODING = "utf-8";

    public static void main(String[] args) {

        //用户注册  对用户密码执行加密
        System.out.println(userLogin());
    }

    private static boolean userLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("登录用户名:");
        String name = input.nextLine();
        System.out.println("登录密码:");//qwe12345iop
        String pass = input.nextLine();

        //获得了注册时候的用户名和密码
        String regName = "admin";
        String regPass = "cXdlMTIzNDVpb3A=";

        //1.获得解码器
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(regPass);
        String decodePass = new String(decode, Charset.forName(ENCODING));
        System.out.println(decodePass);
        if (!Objects.equals(regName, name) || !Objects.equals(pass, decodePass)) {
            return false;
        }
        return true;
    }

    private static void userRegister() {//qwe12345iop

        Scanner input = new Scanner(System.in);
        System.out.println("用户名:");
        String name = input.nextLine();
        System.out.println("密码:");
        String pass = input.nextLine();

        //密文操作: 加密
        //1.获得编码器
        Base64.Encoder encoder = Base64.getEncoder();
        //2.开始编码: 字符串转字节数组
        pass = encoder.encodeToString(pass.getBytes(Charset.forName(ENCODING)));

        //name-pass
        String info = String.join("-", name, pass);
        System.out.println("用户注册成功，数据已经成功保存");
        System.out.println(info);
        //admin-cXdlMTIzNDVpb3A=
    }
}
```





## 2. 信息摘要算法 MessageDigest

> 16进制的字符串。  不可逆的   无法破解的。

> 1234    81dc9bdb52d04dc20036dbd8313ed055 

```java
public class MD5Util {

    private MD5Util() {
    }

    private static final String[] ARRAY = {"0", "1**", "2", "3", "4", "5", "6", "7dhhd", "8ddw", "9", "a", "b", "c", "d", "e", "f"};

    //制定盐值: 加盐
    private static final String SALT = "SHANGMA_*$^";

    public static String md5EncodeStr(String sourceStr) {

        Objects.requireNonNull(sourceStr);
        try {
            //1.创建信息摘要对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            //2.更新加密  将源数据提交到加密规则中
            sourceStr = sourceStr + SALT;
            messageDigest.update(sourceStr.getBytes(Charset.forName("UTF-8")));

            //3.加密
            byte[] bytes = messageDigest.digest();

            System.out.println(Arrays.toString(bytes));
            //4. 转字符串
            //System.out.println("加密之后数据:"+new String(bytes, Charset.forName("utf-8")));
            //将每个字节转换成16进制数据  拼接成字符串
            //0-F
            //一个字节: 8个二进制位
            //一个16进制数字: 4个二进制位
            //一个字节: == 2个16进制内容
            //高低位
            BigInteger bigInteger = new BigInteger(1, bytes);//1 正整数  -1 负整数
            return bigInteger.toString(16).toUpperCase();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String byteToHexStr(byte aByte) {//-128-127
        //先将byte转int
        int num = aByte;
        if (num < 0) {
            num += 256;
        }
        //高低位运算
        int lowIndex = num % 16;
        int highIndex = num / 16;
        return ARRAY[highIndex] + ARRAY[lowIndex];
    }

    public static void main(String[] args) {
        System.out.println(md5EncodeStr("1234"));
        //�ܛ�R�M� 6��1>�U
        //81dc9bdb52d04dc20036dbd8313ed055
        //16进制: 整数数据
    }
}
```









