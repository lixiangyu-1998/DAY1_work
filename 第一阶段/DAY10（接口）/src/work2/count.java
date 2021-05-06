package work2;

/**
 * @author:LXY
 * @className:count
 * @description:
 * @date:2021/3/2420:25
 * @version:0.1
 * @since:1.8
 */
public class count {
   public static shape count(shape shape){
                 if(shape instanceof circle){
                     circle circle=(circle)shape;
                     System.out.println("圆形的面积是："+circle.countArea()+"周长是："+ circle.countPerimeter());
                     return circle;
                 }else if(shape instanceof rectangle){
                     rectangle rectangle=(work2.rectangle)shape;
                     System.out.println("圆形的面积是："+rectangle.countArea()+"周长是："+ rectangle.countPerimeter());
                     return rectangle;
                 }
                 return shape;
             }
}
