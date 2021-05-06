package work1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:employee
 * @description:
 * @date:2021/3/2713:09
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class employee {
    private String name;
    private int id;
    private int age;
}
interface showDao{
    void show();
}