import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:ShareBikeCompany
 * @description:
 * @date:2021/3/2219:26
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@NoArgsConstructor
public class ShareBikeCompany {//共享单车公司
     private int bikeCompanyId;//公司id
     private String bikeCompanyName;//公司名
     private SharedBike[] sharedBikes;
     private int sun;//单车总数
     private int count;//借出单车总数

     public ShareBikeCompany(int bikeCompanyId, String bikeCompanyName, int sun, int count) {
          this.bikeCompanyId = bikeCompanyId;
          this.bikeCompanyName = bikeCompanyName;
          this.sun = sun;
          this.count = count;
     }
}

