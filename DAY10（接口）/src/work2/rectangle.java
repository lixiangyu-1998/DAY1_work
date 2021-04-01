package work2;

import jdk.internal.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:rectangle
 * @description:
 * @date:2021/3/2420:24
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class rectangle extends shape implements countArea,countPerimeter{
    private double sideSength1;
    private double sideSength2;
    public void show(){
        System.out.println("我是矩形");
    }
    public double countArea(){
        return sideSength1*sideSength2;
    }
    public double countPerimeter(){
        return sideSength1*2+sideSength2*2;
    }

    }

