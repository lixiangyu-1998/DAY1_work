package work2;

import java.io.File;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:io2
 * @description:
 * @date:2021/3/3120:55
 * @version:0.1
 * @since:1.8
 */
public class io2 {
    public static void path(String path){
        File f1=new File(path);
        if(!f1.exists()){//查询是否存在路径
            System.out.println("不存在该路径");
            return;
        }
        File[] f2=f1.listFiles();
        for(File f:f2){//增强for循环遍历文件类型数组 然后输出显示
            System.out.println("文件夹或文件的名字分别是："+f.getName());
        }

    }
    public static void main(String[] args) {
        //2. 使用IO技术，开发出一个控制台的资源管理器！
        // 要求：从命令行输入一个路径！如果存在,将该目录下所有的文件和文件夹列举出来，
        // 如果不存在则输出不存在该路径。
        Scanner input=new Scanner(System.in);
        System.out.println("请输入想要查询的路径：");
        String path=input.next();
        if (!path.matches("[\\w\\-]+\\:[\\w\\.\\\\\\-]+\\.[\\w]+")) {//正则判断输入路径是否合法
            System.out.println("请输入正确的路径");
            return;
        }
        path(path);


    }
}
