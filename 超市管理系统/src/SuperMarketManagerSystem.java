import java.sql.Connection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:LXY
 * @className:SuperMarketManagerSystem
 * @description:
 * @date:2021/4/138:16 下午
 * @version:0.1
 * @since:1.8
 */
public class SuperMarketManagerSystem {

    Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<Integer, Shopping_cart> shopping_cartHashMap = new HashMap<>(16);
        Shopping_cart shopping_cart = new Shopping_cart();
        String num;
        Cashier cashier = new Cashier();
        Administrator administrator = new Administrator();
        Scanner input=new Scanner(System.in);
        do {
            Start.showMenu();
            num=input.next();
            Pattern pattern = Pattern.compile("^[0-9]*$");
            Matcher matcher = pattern.matcher(num);
            if(!(matcher.matches()&&Integer.parseInt(num)<=6&&Integer.parseInt(num)>=1)){//判断输入菜单序号合法
                System.out.println("请输入正确菜单序号");
            }else {
                switch (Integer.parseInt(num)){
                    case 1:
                        if(administrator.isAdministrator()){
                            administrator.commodity_type();
                    }
                        break;
                    case 2:
                        if(administrator.isAdministrator()){
                            administrator.commodity_management();
                        }
                        break;
                    case 3:
                        if(administrator.isAdministrator()){
                            administrator.member_management();
                        }
                        break;
                    case 4:
                        if(cashier.isCashier()){
                            cashier.PurchaseManagement(shopping_cartHashMap,shopping_cart);
                        }
                        break;
                    case 5:
                        if(cashier.isCashier()){
                            cashier.order_select();
                        }
                        break;
                    case 6:
                        if(cashier.isCashier()){
                            cashier.rank();
                        }
                        break;
                }
            }
            System.out.println("是否退出系统？Y/N");
            num=input.next();
        }while("n".equals(num));
    }
}

