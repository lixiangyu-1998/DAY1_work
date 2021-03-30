package work2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import work1.employee;

/**
 * @author:LXY
 * @className:projectManager
 * @description:
 * @date:2021/3/2713:10
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class projectManager extends employee{
    private int Offensive;

    public projectManager(String name, int id, int age, int offensive) {
        super(name, id, age);
        Offensive = offensive;
    }

    public void show( ) {
        System.out.println("员工姓名:"+this.getName()+"  员工id:"+this.getId()+
                "  年龄:"+this.getAge()+"  攻击性:"+this.getOffensive());
    }
}
