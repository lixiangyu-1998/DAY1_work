import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author:LXY
 * @className:order_information
 * @description:
 * @date:2021/4/155:01 下午
 * @version:0.1
 * @since:1.8
 */
@Data
@ToString
public class order_information {
    int order_id;
    int user_id;
    BigDecimal orders_total_fee;
    Date order_time;
    int order_type;
}
