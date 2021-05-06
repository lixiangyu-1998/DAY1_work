package work2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:commodity
 * @description:
 * @date:2021/3/2513:48
 * @version:0.1
 * @since:1.8
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class commodity {
     static  commodity[] initialize() {
         commodity commodity1 = new commodity("可乐", 1, 50, 3);
         commodity commodity2 = new commodity("薯片", 2, 0, 5);
         commodity commodity3 = new commodity("面包", 3, 27, 3);
         commodity[] commodity = new commodity[3];
         commodity[0] = commodity1;
         commodity[1] = commodity2;
         commodity[2] = commodity3;
         return commodity;
     }
    private String name;
    private int id;
    private int num;
    private double price;
    public static void startShop(commodity[] commodity){
        System.out.println("欢迎光临超市，以下是商品信息：");
        System.out.println("商品名称  商品编号 库存数量 商品单价");
        int len=commodity.length;
        for(int index=0;index<len;index++){
            System.out.println(commodity[index].getName()+"        "+commodity[index].getId()+"        "+
                    commodity[index].getNum()+"        "+commodity[index].getPrice());
        }
    }
    public static void buy(commodity[] commodity) throws myException{
        Scanner input =new Scanner(System.in);
        int id;
        int num;
        System.out.println("请输入想要购买的商品编号");
        try{
            id=input.nextInt();
        }catch(ArrayIndexOutOfBoundsException exception1){
            System.out.println("请输入正确的商品编号");
            return;
        }
        System.out.println("请输入想购买的数量：");
        num= input.nextInt();

        if(commodity[id-1].getNum()<num){
            int lack=num-commodity[id-1].getNum();
            throw new myException(lack);

        }else{
            System.out.println("购买成功");
            commodity[id-1].setNum(commodity[id-1].getNum()-num);
        }

    }
}

