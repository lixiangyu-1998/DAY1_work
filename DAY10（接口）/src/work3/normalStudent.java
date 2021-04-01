package work3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:normalStudent
 * @description:
 * @date:2021/3/2421:41
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter

public class normalStudent extends student{
    public normalStudent() {
    }

    public normalStudent(String name, int id) {
        super(name, id);
    }
}
