import lombok.Data;
import lombok.ToString;

/**
 * @author:LXY
 * @className:order_details
 * @description:
 * @date:2021/4/155:03 下午
 * @version:0.1
 * @since:1.8
 */
@Data
@ToString
public class order_details {
    int order_detail_id;
    int order_id_fk;
    int Id;
    int Purchase_quantity;
}
