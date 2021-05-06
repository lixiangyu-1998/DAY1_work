import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author:LXY
 * @className:member_management
 * @description:
 * @date:2021/4/148:40 下午
 * @version:0.1
 * @since:1.8
 */
@ToString
@Data
public class member_management {
    int Id;
    String Name;
    String Password;
    String image;
    String Phone_number;
    float Score;
    BigDecimal Balance;
    Date Creation_time;
    Date Modify_time;
}
