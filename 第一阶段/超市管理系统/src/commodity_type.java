import lombok.ToString;

import java.util.Date;

/**
 * @author:LXY
 * @className:commodity_type
 * @description:
 * @date:2021/4/145:18 下午
 * @version:0.1
 * @since:1.8
 */
@ToString
public class commodity_type {
    int ID;
    int pid;
    String Type_nmae;
    boolean Is_superType;
    int Directory;
    Date Creation_time;
    Date Modify_time;
}
