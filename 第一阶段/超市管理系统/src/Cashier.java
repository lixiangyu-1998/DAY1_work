import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:LXY
 * @className:Cashier
 * @description:
 * @date:2021/4/149:39 下午
 * @version:0.1
 * @since:1.8
 */
public class Cashier {
    //static AtomicInteger ai =new AtomicInteger(1);
    private static final String USER="sunxiaochuan";
    private static final int PASSWORD=6324;
    Scanner input=new Scanner(System.in);
    String user;
    String str;
    int password;
    int id;
    int num;
    int commodity_num=0;
    boolean flag=true;
    float total_fee=0;
    public boolean isCashier(){//收银员登陆功能模块
        System.out.println("请输入收银员用户名密码：");
        System.out.println("用户名：");
        user=input.next();
        System.out.println("密码：");
        password=input.nextInt();
        if(!(user.equals(Cashier.USER)&&password==Cashier.PASSWORD)){
            System.out.println("用户名或密码不正确");
            return false;
        }
        System.out.println("登录成功");
        return true;
    }
    public void PurchaseManagement(HashMap<Integer, Shopping_cart> shopping_cartHashMap,
                                   Shopping_cart shopping_cart){

        do {
            System.out.println("进入商品购买页面");
            System.out.println("商品信息查询成功！");
            List<commodity_management> list0 = JDBCUtils.query(commodity_management.class,
                    "select * from commodity_management");
            list0.forEach(System.out::println);
            System.out.println("请输入想要购买的商品id");
            id=input.nextInt();
            List<commodity_management> list = JDBCUtils.query(commodity_management.class,
                    "select * from commodity_management where id = ?", id);
            list.forEach(System.out::println);
            if(list.get(0).commodity_state!=1){
                System.out.println("您选择的商品无法购买 请重新选择");
                System.out.println("----------------------------");
            }else {
                commodity_num=list.get(0).getCommodity_num();//取商品数量
                System.out.println("请输入要购买的数量：");
                num=input.nextInt();
                if(num>commodity_num){
                    System.out.println("数量不足,请重新购买");
                    System.out.println("----------------------------");

                }else{
                    Shopping_cart shopping_cart1 = new Shopping_cart();
                    shopping_cart1.setName(list.get(0).getName());//购买的商品信息
                    shopping_cart1.setNum(num);
                    shopping_cart1.setPrice(list.get(0).getCommodity_price());

                    shopping_cartHashMap.put(list.get(0).getId(),shopping_cart1);//放入hashMap k为商品id 主键
                    commodity_num=commodity_num-num;//数量足够时 购买后 库存相应更新 修改时间也更新
                    JDBCUtils.update("update commodity_management set commodity_num=? ," +
                            "Modify_time=now() where id = ?",commodity_num,id);
                    System.out.println("添加购物车完毕，是否继续购物(y/n)");
                    str=input.next();
                    if("y".equals(str)){

                    }else{
                        flag=false;
                    }
                }
            }

        }while (flag);//flag是 true 就一直循环买的过程

        System.out.println("您购物车中的商品如下：");
        Set<Map.Entry<Integer, Shopping_cart>> entrySet = shopping_cartHashMap.entrySet();
        Iterator<Map.Entry<Integer, Shopping_cart>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()){//遍历hashMap
            Map.Entry<Integer, Shopping_cart> entry = entryIterator.next();
            System.out.println("商品id："+entry.getKey()+"商品名："+entry.getValue().getName()
                    +"购买数量："+entry.getValue().getNum()+"商品单价："+entry.getValue().getPrice());
            total_fee=total_fee+entry.getValue().getNum()*entry.getValue().getPrice();
        }
        System.out.println("本次购物总金额是："+total_fee);
        BigDecimal total_fee1 = new BigDecimal(total_fee);
        System.out.println("是否用会员卡支付？(y/n)");
        str=input.next();
        if("y".equals(str)){
            System.out.println("请输入会员卡号：");
            id=input.nextInt();
            List<member_management> list = JDBCUtils.query(member_management.class,
                    "select * from member_management where id=?", id);
            if(!list.isEmpty()){
                //list.get(0).getBalance().subtract(total_fee1).doubleValue()
                if(list.get(0).getBalance().subtract(total_fee1).doubleValue()>0){//也就是说余额足够
                    System.out.println("购买成功，会员卡余额剩余金额为："+
                            list.get(0).getBalance().subtract(total_fee1).doubleValue());
                    //更新会员余额 和时间
                    JDBCUtils.update("update member_management set Balance=?,Modify_time=now() where id=? ",
                            list.get(0).getBalance().subtract(total_fee1).doubleValue(),id);
                    str=list.get(0).getName();
                    //记录简要订单信息
                    JDBCUtils.update("insert into order_information(user_id,orders_total_fee," +
                            "order_time,order_type) values (?,?,now(),1)",str,total_fee);
                    List<order_information> list1 = JDBCUtils.query(order_information.class,
                            "select order_id from order_information where user_id=?", str);
                    Iterator<Map.Entry<Integer, Shopping_cart>> entryIterator1 = entrySet.iterator();
                    while (entryIterator1.hasNext()){//遍历hashMap 这次是为了循环往订单详细信息里放信息
                        Map.Entry<Integer, Shopping_cart> entry = entryIterator1.next();
                        JDBCUtils.update("insert into order_details(order_id_fk,Id,Purchase_quantity) values(" +
                                "?,?,?)",list1.get(0).getOrder_id(),entry.getKey(),entry.getValue().getNum());
                    }
                    return;
                }else{
                    System.out.println("余额不足请使用现金支付");
                }
            }else{
                System.out.println("不存在此会员号，请使用现金支付。");
            }
//            System.out.println("请输入用户id");
//            id=input.nextInt();
//            System.out.println("现金支付成功！");
//            JDBCUtils.update("insert into order_information(user_id=?,orders_total_fee=?," +
//                    "order_time datetime=now(),order_type=0)",id,total_fee);
        }
            System.out.println("请输入用户id");
            str=input.next();
            System.out.println("现金支付成功！");
            //记录简要订单信息
            JDBCUtils.update("insert into order_information(user_id,orders_total_fee," +
                    "order_time,order_type) values (?,?,now(),0)",str,total_fee);
        List<order_information> list = JDBCUtils.query(order_information.class,
                "select order_id from order_information where user_id=?",str);
        Iterator<Map.Entry<Integer, Shopping_cart>> entryIterator2 = entrySet.iterator();
        while (entryIterator2.hasNext()){//遍历hashMap 这次是为了循环往订单详细信息里放信息
            Map.Entry<Integer, Shopping_cart> entry = entryIterator2.next();
            JDBCUtils.update("insert into order_details(order_id_fk,Id,Purchase_quantity) values(" +
                    "?,?,?)",list.get(0).getOrder_id(),entry.getKey(),entry.getValue().getNum());
        }


    }
    public void order_select(){
        System.out.println("请选择想要查询的数据类型：");
        System.out.println("1.会员编号");
        System.out.println("2.商品编号");
        num=input.nextInt();
        if(num==1){
            System.out.println("请输入要查询的会员编号：");
            num=input.nextInt();
            List<order_information> list = JDBCUtils.query(order_information.class,
                    "select * from order_information where user_id=?", num);//简要表
            list.forEach(System.out::println);
            num=list.get(0).getOrder_id();
            List<order_details> list1 = JDBCUtils.query(order_details.class,
                    "select * from order_details where order_id_fk=?", num);//详情表
            list1.forEach(System.out::println);

        }else if(num==2){
            System.out.println("请输入想要查询的商品编号");
            num=input.nextInt();
            List<order_details> list = JDBCUtils.query(order_details.class,//详细表
                    "select * from order_details where id=?", num);
            num=list.get(0).getOrder_id_fk();
            List<order_information> list1 = JDBCUtils.query(order_information.class, //简要表
                    "select * from order_information where order_id=?", num);
            list1.forEach(System.out::println);
            list.forEach(System.out::println);

        }else{
            System.out.println("请选择正确的菜单");
        }

    }
    public void rank(){
        System.out.println("进入销售排行统计页面");
        System.out.println("请选择要查询的项目：");
        System.out.println("1按商品类别统计销量前10的商品");
        System.out.println("2按商品类别统计总销量");
        num=input.nextInt();
        if(num==1){
            System.out.println("按商品类别统计销量前10的商品");
            List<top_10> top_10s = JDBCUtils.query(top_10.class, "Select \n" +
                    "a.commodity_type,a.Name,b.purchase_quantity\n" +
                    "From \n" +
                    "commodity_management a\n" +
                    "Join\n" +
                    "order_details b\n" +
                    "On\n" +
                    "a.Id=b.Id        \n" +
                    "order by\n" +
                    "b.purchase_quantity desc\n" +
                    "limit 0,10");
            top_10s.forEach(System.out::println);
        }else if(num==2){
            System.out.println("按商品类别统计总销量");
            List<Total_sales> total_sales = JDBCUtils.query(Total_sales.class, "Select \n" +
                    "a.commodity_type,sum(b.purchase_quantity) sum\n" +
                    "From \n" +
                    "commodity_management a\n" +
                    "Join\n" +
                    "order_details b\n" +
                    "On\n" +
                    "a.Id=b.Id\n" +
                    "Group by \n" +
                    "a.commodity_type");
            total_sales.forEach(System.out::println);
        }else{
            System.out.println("请选择正确的菜单");
        }


    }

}
