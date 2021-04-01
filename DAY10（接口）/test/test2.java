import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import work2.circle;
import work2.count;
import work2.rectangle;

/**
 * @author:LXY
 * @className:test2
 * @description:
 * @date:2021/3/2421:01
 * @version:0.1
 * @since:1.8
 */
public class test2 {
    public static void main(String[] args) {
        circle circle=new circle(5);
        rectangle rectangle=new rectangle(5 ,10);
        count.count(circle);
        count.count(rectangle);
    }
}
