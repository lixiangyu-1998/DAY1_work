import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:LXY
 * @className:start
 * @description:
 * @date:2021/3/2219:59
 * @version:0.1
 * @since:1.8
 */
public class start {
    public static void returnMain(ShareBikeCompany company[])throws ParseException{
        startMenu(company);
    }
    public static void startMenu(ShareBikeCompany company[]) throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("*********************************************");
        System.out.println("********欢迎使用迷你共享单车管理系统********");
        System.out.println("                1.投放单车");
        System.out.println("                2.查看单车");
        System.out.println("                3.删除单车");
        System.out.println("                4.借出单车");
        System.out.println("                5.归还单车");
        System.out.println("                6.单车排行榜");
        System.out.println("                7. 退  出");
        System.out.println("*********************************************");
        System.out.println("请选择：");
        int a;
        a = input.nextInt();
        int b;
        do {
            switch (a) {
                case 1:
                    System.out.println("--------》 1.投放单车");
                    shareBikeDao.putBike(company);
                    break;
                case 2:
                    System.out.println("--------》 2.查看单车");
                    int len1=company.length;
                    int i=0;
                    int len2;
                    System.out.println("公司序号    公司名称    公司单车数量    公司单车借出次数");
                    for(int index=0;index<len1;index++){
                        System.out.println(company[index].getBikeCompanyId()+"            "+company[index].getBikeCompanyName()
                        +"            "+company[index].getSun()+"            "+company[index].getCount());
                    }
                    i=0;
                    System.out.println("单车序号    单车品牌    单车状态    借出时间");
                    for(;i<3;i++) {
                        len2 = company[i].getSharedBikes().length;

                        for (int index = 0; index < len2; index++) {
                            System.out.println(company[i].getSharedBikes()[index].getId() + "        " +
                                    company[i].getSharedBikes()[index].getBikeName() + "        " +
                                    company[i].getSharedBikes()[index].getBikeState()
                                    + "        " + company[i].getSharedBikes()[index].getBorrowTime());
                        }
                    }
                    break;
                case 3:
                    System.out.println("--------》 3.删除单车");
                    shareBikeDao.deleteBike(company);
                    break;
                case 4:
                    System.out.println("--------》 4.借出单车");
                    shareBikeDao.borrowBike(company);
                    break;
                case 5:
                    System.out.println("--------》 5.归还单车");
                    shareBikeDao.retornBike(company);
                    break;
                case 6:
                    System.out.println("--------》 6.单车排行榜");
                    shareBikeDao.rank(company);
                    break;
                case 7:
                    System.out.println("--------》 7. 退  出");
                    break;
            }
            System.out.println("输入0返回首页：");
            b = input.nextInt();
            if (b == 0) {
                returnMain(company);
            } else {
                System.out.println("请输入正确的语句：");
            }
        } while (b == 7);

    }         //差一个 识别输入非数字报错的部分
    public static void main(String[] strs)throws ParseException {
       ShareBikeMgr initial=new ShareBikeMgr();
        ShareBikeCompany company[]=initial.initial();
        startMenu(company);



    }
}
