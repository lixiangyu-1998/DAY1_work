package work2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import work1.employee;

/**
 * @author:LXY
 * @className:programmer
 * @description:
 * @date:2021/3/2713:10
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class programmer extends employee{
    private int hot;

    public programmer(String name, int id, int age, int hot) {
        super(name, id, age);
        this.hot = hot;
    }
    public void show() {
        System.out.println("员工姓名:"+this.getName()+"  员工id:"+this.getId()+
                "  年龄:"+this.getAge()+"  关注度:"+this.getHot());
    }
}
