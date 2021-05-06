/**
 * @author lixiangyu
 * @title: Tomcat
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/64:43 下午
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Tomcat是WebServer
 * Web容器
 * Web Container
 * Web服务器
 *
 *
 * Web容器面向Servlet接口调用
 */
public class Tomcat {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner input = new Scanner(System.in);
        System.out.println("服务器启动成功");
        System.out.println("请在浏览器上输入请求路径");
        //用户输入路径
        String requestPath=input.next();
        //输入什么访问什么就好了 但是有一个问题 路径和资源 怎么对应？  是 web.xml 来维护路径和servlet的关系
        System.out.println("您访问的资源路径是："+requestPath);

        //Tomcat 读取 web.xml 文件
        FileReader fileReader = new FileReader("web.xml");
        Properties properties = new Properties();
        properties.load(fileReader);
        fileReader.close();
        //通过用户输入的路径  获取到了 一一对应的 类名
        String property = properties.getProperty(requestPath);
        //通过反射拿类 拿 对象
        Class<?> clazz = Class.forName("property");
        //因为 所有xml中对应的类 都实现了servlet接口 所以可以大胆的进行强制类型转换
        servlet servlet = (servlet)clazz.newInstance();
        //面向Servlet接口 调用方法即可
        servlet.service();


    }
}
