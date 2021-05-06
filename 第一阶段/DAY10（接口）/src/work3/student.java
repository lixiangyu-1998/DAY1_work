package work3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:student
 * @description:
 * @date:2021/3/2421:38
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class student {
private String name;
private int id;
    public void study(){
        System.out.println(this.getName()+":我在学习");
    }
}
interface earnMoney{
    void earnMoney();
}
