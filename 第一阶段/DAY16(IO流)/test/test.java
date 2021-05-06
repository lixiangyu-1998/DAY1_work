import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author:LXY
 * @className:test
 * @description:
 * @date:2021/4/121:36
 * @version:0.1
 * @since:1.8
 */
public class test {
    public static void main(String[] args) throws IOException {
        char[] c=new char[5];
        c[0]='0';
        c[1]='0';
        c[2]='0';
        c[3]='0';
        c[4]='0';
        File f1=new File("D:\\file1\\test9.txt");
        FileWriter fw=new FileWriter(f1);
        fw.flush();
        System.out.println(c);
        fw.write(97);
    }
}
