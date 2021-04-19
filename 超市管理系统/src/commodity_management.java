import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author:LXY
 * @className:commodity_management
 * @description:
 * @date:2021/4/147:38 下午
 * @version:0.1
 * @since:1.8
 */
@ToString
@Data
public class commodity_management {
    int Id;
    String Name;
    String commodity_type;
    int commodity_num;
    float commodity_price;
    int commodity_state;
    float Discount;
    Date Creation_time;
    Date Modify_time;

}
