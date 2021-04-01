package work3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:richStudent
 * @description:
 * @date:2021/3/2421:42
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter

public class richStudent extends student implements earnMoney {
    public void earnMoney(){
        System.out.println(this.getName()+":我还会赚钱");
    }

    public richStudent() {
    }

    public richStudent(String name, int id) {
        super(name, id);
    }
}
