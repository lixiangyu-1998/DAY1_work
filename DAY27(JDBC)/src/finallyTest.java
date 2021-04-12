import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Queue;

/**
 * @author:LXY
 * @className:finallyTest
 * @description:
 * @date:2021/4/1011:04 上午
 * @version:0.1
 * @since:1.8
 */
public class finallyTest {
    public static void main(String[] args) throws Exception {
        //Connection conn = JDBCUtils.getConnection();
        List<score> list = JDBCUtils.query(score.class, "select * from score");
        list.forEach(System.out::println);

    }
}
