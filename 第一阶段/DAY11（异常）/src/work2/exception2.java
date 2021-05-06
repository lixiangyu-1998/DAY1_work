package work2;

/**
 * @author:LXY
 * @className:exception2
 * @description:
 * @date:2021/3/2422:46
 * @version:0.1
 * @since:1.8
 */
public class exception2 {
    //	模拟实现用户购买商品的功能，使用数组模拟商品列表，
    // 当购买的商品不存在或者商品库存为0时，抛出自定义异常。
    // 用户购买某一个商品时，对异常进行处理，并对库存进行改变。
    public static void main(String[] args) {
        commodity commodity1[]=commodity.initialize();
        commodity.startShop(commodity1);
        try{
            commodity.buy(commodity1);
        }catch (myException exception){
            System.out.println("库存不足");
        }
        
    }
}
