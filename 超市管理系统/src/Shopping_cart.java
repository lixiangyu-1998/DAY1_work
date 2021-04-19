import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author:LXY
 * @className:Shopping_cart
 * @description:
 * @date:2021/4/1410:34 下午
 * @version:0.1
 * @since:1.8
 */
@ToString
@Data
public class Shopping_cart {
    String name;
    int num;
   float price;
}
