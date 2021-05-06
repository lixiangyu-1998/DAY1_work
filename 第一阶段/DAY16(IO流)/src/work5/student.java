package work5;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:LXY
 * @className:student
 * @description:
 * @date:2021/4/113:12
 * @version:0.1
 * @since:1.8
 */
@lombok.Getter
@lombok.Setter
@AllArgsConstructor
@NoArgsConstructor
public class student implements Serializable {
    //创建一个学生类，包含属性：学号、姓名、性别，包含show（）方法用于显示学生的详细信息。
    private Integer id;
    private String name;
    private String sex;
    public void show(){
        System.out.println("学生id是："+this.id+"学生姓名是："+this.name+"学生的性别是："+this.sex);
    }
}
