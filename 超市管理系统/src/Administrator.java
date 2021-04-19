import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:LXY
 * @className:Administrator
 * @description:
 * @date:2021/4/138:05 下午
 * @version:0.1
 * @since:1.8
 */
@Data
public class Administrator {
    String image;
    String Phone_number;
    float score;
    BigDecimal balance;
    BigDecimal addBalance;
    String sql;
    int ID;
    int pid;
    String Type_nmae;
    int Is_superType;
    int Directory;
    String name;
    String commodity_type;
    int commodity_num;
    float commodity_price;
    int commodity_state;
    float Discount;
    String Name;
    int id;
    String num;
    String user;
    int password;
    Scanner input=new Scanner(System.in);
    public static final String USER="ligan";
    public static final int PASSWORD=6324;
    public boolean isAdministrator(){//管理员登陆功能模块
        System.out.println("请输入管理员用户名密码：");
        System.out.println("用户名：");
        user=input.next();
        System.out.println("密码：");
        password=input.nextInt();
        if(!(user.equals(Administrator.USER)&&password==Administrator.PASSWORD)){
            System.out.println("用户名或密码不正确");
            return false;
        }
        System.out.println("登录成功");
        return true;
    }
    public void commodity_type(){//商品类型管理模块
        System.out.println("---------------欢迎进入超市管理系统---------------");
        System.out.println("                1.添加商品类型信息");
        System.out.println("                2.修改商品类型信息");
        System.out.println("                3.查询商品类型信息");
        System.out.println("                4.删除商品类型信息");
        System.out.println("---------------欢迎进入超市管理系统---------------");
        System.out.println("请选择菜单进入:");
        num=input.next();
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(num);
        if(!(matcher.matches()&&Integer.parseInt(num)<=4&&Integer.parseInt(num)>=1)){//判断输入菜单序号合法
            System.out.println("请输入正确菜单序号");
        }else {
            switch (Integer.parseInt(num)){
                case 1://添加商品类型信息
                    System.out.println("进入添加商品类型页面");
                    System.out.println("请输入要添加种类的目录等级，0为一级目录，1为2级目录");
                    pid=input.nextInt();
                    System.out.println("请输入要添加种类的名称");
                    Type_nmae=input.next();
                    System.out.println("要添加的种类是否为父类型？，1代表是父类型，0代表不是");
                    Is_superType=input.nextInt();
                    System.out.println("请输入要添加种类的目录等级，1为一级目录，2为2级目录");
                    Directory=input.nextInt();
                    sql="Insert into commodity_type" +
                            "(pid,Type_nmae,Is_superType,Directory,Creation_time) values(?,?,?,?,now())";
                    JDBCUtils.update(sql,pid,Type_nmae,Is_superType,Directory);
                    System.out.println("商品类型添加成功！");
                    break;
                case 2://修改商品类型信息
                    System.out.println("进入修改商品类型信息页面");
                    System.out.println("请输入要修改的数据所属ID");
                    ID=input.nextInt();
                    System.out.println("请输入修改后的目录等级，0为一级目录，1为2级目录");
                    pid=input.nextInt();
                    System.out.println("请输入修改后的种类名称");
                    Type_nmae=input.next();
                    System.out.println("修改后是否为父类型？，1代表是父类型，0代表不是");
                    Is_superType=input.nextInt();
                    System.out.println("请输入修改后的目录等级，1为一级目录，2为2级目录");
                    Directory=input.nextInt();
                    sql=" update commodity_type set pid=?,Type_nmae=?,Is_superType=?,Directory=?, Modify_time=now() where ID=?";
                    JDBCUtils.update(sql,pid,Type_nmae,Is_superType,Directory,ID);
                    System.out.println("商品类型修改成功！");
                    break;
                case 3://查询商品类型信息
                    System.out.println("商品类型信息查询成功！");
                    List<commodity_type> list = JDBCUtils.query(commodity_type.class, "select * from Commodity_type");
                    list.forEach(System.out::println);
                    break;
                case 4://删除商品类型信息
                    System.out.println("进入商品删除界面");
                    System.out.println("请输入要删除的商品所属ID");
                    ID=input.nextInt();
                    sql="delete from commodity_type where ID=?";
                    JDBCUtils.update(sql,ID);
                    System.out.println("商品删除成功！");
            }
        }
    }

    public void commodity_management(){
        System.out.println("---------------欢迎进入超市管理系统---------------");
        System.out.println("                1.添加商品信息");
        System.out.println("                2.修改商品信息");
        System.out.println("                3.查询商品信息");
        System.out.println("                4.删除商品信息");
        System.out.println("---------------欢迎进入超市管理系统---------------");
        System.out.println("请选择菜单进入:");
        num=input.next();
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(num);
        if(!(matcher.matches()&&Integer.parseInt(num)<=4&&Integer.parseInt(num)>=1)){//判断输入菜单序号合法
            System.out.println("请输入正确菜单序号");
        }else {
            switch (Integer.parseInt(num)){
                case 1://添加商品信息
                    System.out.println("进入添加商品信息页面");
                    System.out.println("请输入想要添加商品的名字：");
                    name=input.next();
                    System.out.println("请输入想要添加商品的类型：");
                    commodity_type=input.next();
                    System.out.println("请输入想要添加商品的数量：");
                    commodity_num=input.nextInt();
                    System.out.println("请输入想要添加商品的价格：");
                    commodity_price=input.nextInt();
                    System.out.println("请输入想要添加商品的状态(1-正常 2-下架 3-删除)：");
                    commodity_state=input.nextInt();
                    System.out.println("请输入想要添加商品的折扣：");
                    Discount=input.nextInt();
                    sql="insert into commodity_management(name,commodity_type,commodity_num,commodity_price," +
                            "commodity_state,Discount,Creation_time) values(?,?,?,?,?,?,now())";
                    JDBCUtils.update(sql,name,commodity_type,commodity_num,commodity_price,commodity_state,Discount);
                    System.out.println("商品添加成功！");
                    break;
                case 2://修改商品信息
                    System.out.println("进入修改商品信息页面");
                    System.out.println("请输入要修改的商品id：");
                    id=input.nextInt();
                    System.out.println("请输入修改后的商品名字：");
                    Name=input.next();
                    System.out.println("请输入修改后的商品类型：");
                    commodity_type=input.next();
                    System.out.println("请输入修改后的商品数量：");
                    commodity_num=input.nextInt();
                    System.out.println("请输入修改后的商品价格：");
                    commodity_price=input.nextInt();
                    System.out.println("请输入修改后的商品状态(1-正常 2-下架 3-删除)：");
                    commodity_state=input.nextInt();
                    System.out.println("请输入修改后的商品折扣：");
                    Discount=input.nextInt();
                    sql="update commodity_management set Name=?,commodity_type=?,commodity_num=?,commodity_price=?," +
                            "commodity_state=?,Discount=?,Modify_time=now() where id=?";
                    JDBCUtils.update(sql,Name,commodity_type,commodity_num,commodity_price,commodity_state,Discount,id);
                    System.out.println("修改商品信息成功！");
                case 3://查询商品信息
                    System.out.println("商品信息查询成功！");
                    List<commodity_management> list = JDBCUtils.query(commodity_management.class,
                            "select * from commodity_management");
                    list.forEach(System.out::println);
                    break;
                case 4://删除商品信息
                    System.out.println("进入商品删除页面");
                    System.out.println("请输入想删除的商品id：");
                    id=input.nextInt();
                    sql="delete from commodity_management where id=?";
                    JDBCUtils.update(sql,id);
                    System.out.println("商品删除成功！");
                    break;
            }

        }
    }

    public void member_management(){
        System.out.println("---------------欢迎进入超市管理系统---------------");
        System.out.println("                1.添加会员信息");
        System.out.println("                2.修改会员信息");
        System.out.println("                3.查询会员信息");
        System.out.println("                4.删除会员信息");
        System.out.println("                5.会员余额充值");
        System.out.println("---------------欢迎进入超市管理系统---------------");
        System.out.println("请选择菜单进入:");
        num=input.next();
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(num);
        if(!(matcher.matches()&&Integer.parseInt(num)<=5&&Integer.parseInt(num)>=1)){//判断输入菜单序号合法
            System.out.println("请输入正确菜单序号");
        }else {
            switch (Integer.parseInt(num)){
                case 1://添加会员信息
                    System.out.println("进入添加会员信息页面");
                    System.out.println("请输入会员名");
                    name=input.next();
                    System.out.println("请输入会员密码");
                    password=input.nextInt();
                    System.out.println("请上传会员头像");
                    image=input.next();
                    System.out.println("请输入会员联系方式");
                    Phone_number=input.next();
                    System.out.println("请输入会员积分");
                    score=input.nextInt();
                    System.out.println("请输入会员余额");
                    balance=BigDecimal.valueOf(input.nextInt());
                    sql="insert into member_management(name,password,image,Phone_number,score,balance,Creation_time) " +
                            "values(?,?,?,?,?,?,now())";
                    JDBCUtils.update(sql,name,password,image,Phone_number,score,balance);
                    System.out.println("添加会员信息成功！");
                    break;
                case 2://修改会员信息
                    System.out.println("进入修改会员信息页面");
                    System.out.println("请输入修改后的会员名：");
                    name=input.next();
                    System.out.println("请输入修改后的会员密码：");
                    password=input.nextInt();
                    System.out.println("请输入修改后的会员头像：");
                    image=input.next();
                    System.out.println("请输入修改后的会员联系方式：");
                    Phone_number=input.next();
                    System.out.println("请输入修改后的会员积分：");
                    score=input.nextInt();
                    System.out.println("请输入修改后的会员余额：");
                    balance=BigDecimal.valueOf(input.nextInt());
                    sql="update member_management set name=?,password=?,image=?,Phone_number=?," +
                            "score=?,balance=?,Modify_time=now()";
                    JDBCUtils.update(sql,name,password,image,Phone_number,score,balance);
                    System.out.println("修改会员信息成功！");
                    break;
                case 3://查询会员信息
                    System.out.println("会员信息查询成功！");
                    List<member_management> list = JDBCUtils.query(member_management.class, "select * from member_management");
                    list.forEach(System.out::println);
                    break;
                case 4://删除会员信息
                    System.out.println("进入删除会员信息页面");
                    System.out.println("请输入要删除的会员ID：");
                    id=input.nextInt();
                    sql="delete from member_management where id = ?";
                    JDBCUtils.update(sql,id);
                    System.out.println("会员信息删除成功！");
                    break;
                case 5://会员余额充值
                    System.out.println("进入会员余额充值界面");
                    System.out.println("请输入要充值余额的会员id：");
                    id=input.nextInt();
                    System.out.println("请输入要充值的数值：");
                    addBalance=BigDecimal.valueOf(input.nextInt());
                    //UPDATE 表 SET 余额= (充值金额+余额) WHERE 会员ID = ？
                    JDBCUtils.update("update member_management set balance=balance+? where id=?",addBalance,id);
                    System.out.println("会员余额充值成功！");
            }
        }
    }

}
