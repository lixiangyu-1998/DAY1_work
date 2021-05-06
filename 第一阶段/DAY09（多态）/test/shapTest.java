import work5.circle;
import work5.line;
import work5.rectangle;
import work5.shape;

import java.awt.*;
import java.util.Random;

/**
 * @author:LXY
 * @className:shapTest
 * @description:
 * @date:2021/3/2219:03
 * @version:0.1
 * @since:1.8
 */
public class shapTest {
    public static void drawTest(shape shape){
        if(shape instanceof circle){
            circle circle=(circle)shape;
            circle.draw();
        }else if(shape instanceof line){
            line line=(line)shape;
            line.draw();
        }else if(shape instanceof rectangle){
            rectangle rectangle=(rectangle)shape;
            rectangle.draw();
        }
    }
    public static void main(String[] args) {
        shape[] shape=new shape[3];
        shape[0]=new circle();
        shape[1]=new line();
        shape[2]=new rectangle();
        int len=shape.length;
        for(int index=0;index<len;index++){
           drawTest(shape[index]);
        }
    }
}
