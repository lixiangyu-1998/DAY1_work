import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author:LXY
 * @className:test2
 * @description:
 * @date:2021/4/97:58 下午
 * @version:0.1
 * @since:1.8
 */
public class test2 {
    public static void main(String[] args) throws Exception {
        //获取连接
        Connection conn = JDBCUtils.getConnection();
        //预编译sql
        String sql="";
        PreparedStatement ps = conn.prepareStatement(sql);
        //填充占位符
        ps.setString(1,"");
        //执行sql语句
        ps.execute();
        //关闭资源
        JDBCUtils.closeResource(conn,ps);
    }
}
