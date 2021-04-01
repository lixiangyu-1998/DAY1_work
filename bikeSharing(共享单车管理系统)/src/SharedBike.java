import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:SharedBike
 * @description:
 * @date:2021/3/2219:26
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SharedBike {//
     private int id;//编号
     private String bikeName;//名字
     private String bikeState;//借出状态
     private String borrowTime;//借出时间


}
