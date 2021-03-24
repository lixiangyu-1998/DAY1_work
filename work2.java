/**
 * @author:LXY
 * @className:work2
 * @description:
 * @date:2021/3/2011:00
 * @version:0.1
 * @since:1.8
 */
public class work2 {
    public static class rectangle{
        static int height;
        static int width;
        public rectangle(int height, int width) {
            this.height = height;
            this.width = width;
        }
        public  void area(){
            System.out.println("矩形的面积是"+this.height*this.width);
        }
        public  void perimeter(){
            System.out.println("矩形的周长是"+(this.height*2+this.width*2));
        }
    }
public static void main(String[] strs){
        rectangle r1=new rectangle(3,3);
        r1.area();
        r1.perimeter();
}

}