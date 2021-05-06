package work2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:circle
 * @description:
 * @date:2021/3/2420:24
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class circle extends shape implements countArea,countPerimeter {
    private double radius;
    public void show(){
        System.out.println("我是圆形");
    }
    public double countArea(){
        return radius*radius*3.14;
    }
    public double countPerimeter(){
        return 3.14*2*radius;
    }
}
