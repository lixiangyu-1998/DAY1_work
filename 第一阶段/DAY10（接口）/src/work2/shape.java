package work2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:shape
 * @description:
 * @date:2021/3/2420:24
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class shape {
   private double area;
   private double perimeter;
}
interface countArea{
    double countArea();
}
interface countPerimeter{
    double countPerimeter();
}
