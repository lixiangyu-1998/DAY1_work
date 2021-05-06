package work9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:student
 * @description:
 * @date:2021/4/121:46
 * @version:0.1
 * @since:1.8
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class student implements Comparable{
    private String name;
    private int age;
    private int score;

    @Override
    public int compareTo(Object o) {//重写比较方法
        student s=(student)o;
        if(this.score>s.score){
            return -1;
        }else if(this.score<s.score){
            return 1;
        }else if(this.age>s.age){
            return -1;
        }else{
            return 1;
        }

    }
}
