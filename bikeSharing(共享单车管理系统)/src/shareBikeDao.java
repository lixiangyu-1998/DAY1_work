import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

/**
 * @author:LXY
 * @className:shareBikeDao
 * @description:
 * @date:2021/3/2318:32
 * @version:0.1
 * @since:1.8
 */
public class shareBikeDao {
    public static void putBike(ShareBikeCompany company[]) {
        int a;
        int b = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("1.mobaiBike");
        System.out.println("2.ofoBike");
        System.out.println("3.haloBike");
        System.out.println("请选择要投放的单车品牌：");
        a = input.nextInt();
        if (a > 3 || a < 1) {
            System.out.println("请输入正确的选项");
        } else {
            System.out.println("请选择投放数量");
            b = input.nextInt();
            if (a == 1) {
                int j=1;
                System.out.println(b + "辆mobai单车投放成功");
                int len = company[0].getSharedBikes().length;//记录原来自行车数量
                company[0].setSun(len+b);
                SharedBike[] bike;
                bike = Arrays.copyOf(company[0].getSharedBikes(), b + len);//扩容+录入原来自行车的信息
                company[0].setSharedBikes(bike);//扩容后的新数组替换原数组
                for (int i = len; i < b + len; i++) {//循环产生新的对象 逐个放入新数组
                    SharedBike mobaiBike = new SharedBike(len + j++, "mobaiBike", "可借", "");
                    company[0].getSharedBikes()[i] = mobaiBike;
                }
            } else if (a == 2) {
                int j=1;
                System.out.println(b + "辆ofo单车投放成功");
                int len = company[1].getSharedBikes().length;//记录原来自行车数量
                company[1].setSun(len+b);
                SharedBike[] bike;
                bike = Arrays.copyOf(company[1].getSharedBikes(), b + len);//扩容+录入原来自行车的信息
                company[1].setSharedBikes(bike);//扩容后的新数组替换原数组
                for (int i = len; i < b + len; i++) {//循环产生新的对象 逐个放入新数组
                    SharedBike ofoBike = new SharedBike(len + j++, "ofoBike", "可借", "");
                    company[1].getSharedBikes()[i] = ofoBike;
                }
                }else if (a == 3) {
                int j=1;
                System.out.println(b+"辆halo单车投放成功");
                int len=company[2].getSharedBikes().length;//记录原来自行车数量
                company[2].setSun(len+b);
                SharedBike[] bike;
                bike=Arrays.copyOf(company[2].getSharedBikes(),b+len);//扩容+录入原来自行车的信息
                company[2].setSharedBikes(bike);//扩容后的新数组替换原数组
                for(int i=len;i<b+len;i++){//循环产生新的对象 逐个放入新数组
                    SharedBike haloBike=new SharedBike(len+j++,"haloBike","可借","");
                    company[2].getSharedBikes()[i]=haloBike;
                }
            }
        }
    }
    public static void deleteBike(ShareBikeCompany company[]){
        Scanner input=new Scanner(System.in);
        int a;
        int id;
        System.out.println("1.mobaiBike");
        System.out.println("2.ofoBike");
        System.out.println("3.haloBike");
        System.out.println("请选择要删除的品牌：");
        a=input.nextInt();
        if(a==1){
            System.out.println("此mobai单车有共享单车如下");
            System.out.println("单车序号    单车品牌    单车状态    借出时间");
            int len=company[0].getSharedBikes().length;
                for (int index = 0; index < len; index++) {
                    System.out.println(company[0].getSharedBikes()[index].getId() + "        " +
                            company[0].getSharedBikes()[index].getBikeName() + "        " +
                            company[0].getSharedBikes()[index].getBikeState()
                            + "        " + company[0].getSharedBikes()[index].getBorrowTime());
                }
            System.out.println("请输入要删除的单车编号：");
                id=input.nextInt();
                if(id>len||id<=0){//检查编号合法性
                    System.out.println("不存在此编号的单车");
                }else{if(company[0].getSharedBikes()[id-1].getBikeState().equals("已借出")){
                    System.out.println("不允许删除借出状态的共享单车");//检查单车状态
                }else{if(id==len){
                    if(id==1){
                        System.out.println("只有最后一辆单车了 不允许删除。");
                    }else {
                        //company[0].getSharedBikes()[len - 1] = null; 会报错 不可取
                        SharedBike[] bike;
                        bike= Arrays.copyOf(company[0].getSharedBikes(),len-1);
                        company[0].setSharedBikes(bike);
                        System.out.println("删除单车成功");
                    }
                }else{
                    for(id-=1;id<len;id++){
                        if(id+1==len){
                            break;//不加这个判断会数组越界
                        }
                        company[0].getSharedBikes()[id]=company[0].getSharedBikes()[id+1];//移位单车
                        company[0].getSharedBikes()[id+1].setId(company[0].getSharedBikes()[id+1].getId()-1);//更改相应id 也要-1
                    }
                    //company[1].getSharedBikes()[len-1]=null;//如果最后一位赋空 有null很多地方会报错
                    SharedBike[] bike;
                    bike= Arrays.copyOf(company[0].getSharedBikes(),len-1);
                    company[0].setSharedBikes(bike);
                    System.out.println("删除单车成功");
                }
                }
                }
        }else if(a==2){
            System.out.println("此mobai单车有共享单车如下");
            System.out.println("单车序号    单车品牌    单车状态    借出时间");
            int len=company[1].getSharedBikes().length;
            for (int index = 0; index < len; index++) {
                System.out.println(company[1].getSharedBikes()[index].getId() + "        " +
                        company[1].getSharedBikes()[index].getBikeName() + "        " +
                        company[1].getSharedBikes()[index].getBikeState()
                        + "        " + company[1].getSharedBikes()[index].getBorrowTime());
            }
            System.out.println("请输入要删除的单车编号：");
            id=input.nextInt();
            if(id>len||id<=0){//检查编号合法性
                System.out.println("不存在此编号的单车");
            }else{if(company[1].getSharedBikes()[id-1].getBikeState().equals("已借出")){
                System.out.println("不允许删除借出状态的共享单车");//检查单车状态
            }else{if(id==len){
                if(id==1){
                    System.out.println("只有最后一辆单车了 不允许删除。");
                }else {
                    //company[1].getSharedBikes()[len - 1] = null; 会报错 不可取
                    SharedBike[] bike;
                    bike= Arrays.copyOf(company[1].getSharedBikes(),len-1);
                    company[1].setSharedBikes(bike);
                    System.out.println("删除单车成功");
                }
            }else{
                for(id-=1;id<len;id++){
                    if(id+1==len){
                        break;//不加这个判断会数组越界
                    }
                    company[1].getSharedBikes()[id]=company[1].getSharedBikes()[id+1];//移位单车
                    company[1].getSharedBikes()[id+1].setId(company[1].getSharedBikes()[id+1].getId()-1);//更改相应id 也要-1
                }
                //company[1].getSharedBikes()[len-1]=null;//如果最后一位赋空 有null很多地方会报错
                SharedBike[] bike;
                bike= Arrays.copyOf(company[1].getSharedBikes(),len-1);
                company[1].setSharedBikes(bike);
                System.out.println("删除单车成功");
            }
            }
            }
        }else if(a==3){
            System.out.println("此mobai单车有共享单车如下");
            System.out.println("单车序号    单车品牌    单车状态    借出时间");
            int len=company[2].getSharedBikes().length;
            for (int index = 0; index < len; index++) {
                System.out.println(company[2].getSharedBikes()[index].getId() + "        " +
                        company[2].getSharedBikes()[index].getBikeName() + "        " +
                        company[2].getSharedBikes()[index].getBikeState()
                        + "        " + company[2].getSharedBikes()[index].getBorrowTime());
            }
            System.out.println("请输入要删除的单车编号：");
            id=input.nextInt();
            if(id>len||id<=0){//检查编号合法性
                System.out.println("不存在此编号的单车");
            }else{if(company[2].getSharedBikes()[id-1].getBikeState().equals("已借出")){
                System.out.println("不允许删除借出状态的共享单车");//检查单车状态
            }else{if(id==len){
                if(id==1){
                    System.out.println("只有最后一辆单车了 不允许删除。");
                }else {
                    //company[2].getSharedBikes()[len - 1] = null; 会报错 不可取
                    SharedBike[] bike;
                    bike= Arrays.copyOf(company[2].getSharedBikes(),len-1);
                    company[2].setSharedBikes(bike);
                    System.out.println("删除单车成功");
                }
            }else{
                for(id-=1;id<len;id++){
                    if(id+1==len){
                        break;//不加这个判断会数组越界
                    }
                    company[2].getSharedBikes()[id]=company[2].getSharedBikes()[id+1];//移位单车
                    company[2].getSharedBikes()[id].setId(company[2].getSharedBikes()[id].getId()-1);//更改相应id 也要-1
                }
                //company[2].getSharedBikes()[len-1]=null;//如果最后一位赋空 有null很多地方会报错
                SharedBike[] bike;
                bike= Arrays.copyOf(company[2].getSharedBikes(),len-1);
                company[2].setSharedBikes(bike);
                System.out.println("删除单车成功");
              }
             }
            }
         }
        }
        public static void retornBike(ShareBikeCompany company[])throws ParseException {
        Scanner input=new Scanner(System.in);
        int a;
        int id;
        String time1;
        String time2;
        long money;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式
        System.out.println("1.mobaiBike");
        System.out.println("2.ofoBike");
        System.out.println("3.haloBike");
        System.out.println("请选择要归还的单车品牌：");
        a=input.nextInt();
        if(a==1){
            int len=company[0].getSharedBikes().length;
            System.out.println("请录入要归还的单车编号：");
            id=input.nextInt();
            if(id<=0||id>len){
                System.out.println("请输入正确的单车编号");
            }else if(company[0].getSharedBikes()[id-1].getBikeState().equals("可借")){
                System.out.println("请录入正确的单车编号：");
            }else{
                System.out.println("请录入归还时间(yyyy-MM-dd HH:mm:ss)：");
                input.nextLine();
                time1=input.next();
                System.out.println("您的借车时间为："+company[0].getSharedBikes()[id-1].getBorrowTime());
                time2=company[0].getSharedBikes()[id-1].getBorrowTime();
                Date d1=sdf.parse(time1);//解析
                Date d2=sdf.parse(time2);
                money=((d1.getTime()-d2.getTime())/(24*60*60*1000))*2;
                System.out.println("您的用车时间为"+(d1.getTime()-d2.getTime())+"小时，需要支付"+money+"元");
            }
        }else if(a==2){
            int len=company[1].getSharedBikes().length;
            System.out.println("请录入要归还的单车编号：");
            id=input.nextInt();
            if(id<=0||id>len){
                System.out.println("请输入正确的单车编号");
            }else if(company[1].getSharedBikes()[id-1].getBikeState().equals("可借")){
                System.out.println("请录入正确的单车编号：");
            }else{
                System.out.println("请录入归还时间(yyyy-MM-dd HH:mm:ss)：");
                input.nextLine();
                time1=input.nextLine();
                System.out.println("您的借车时间为："+company[1].getSharedBikes()[id-1].getBorrowTime());
                time2=company[1].getSharedBikes()[id-1].getBorrowTime();
                System.out.println(time2);
                Date d1=sdf.parse(time1);//解析
                Date d2=sdf.parse(time2);
                money=((d1.getTime()-d2.getTime())/(24*60*60*1000))*2;
                System.out.println("您的用车时间为"+(d1.getTime()-d2.getTime())+"小时，需要支付"+money+"元");
            }
        }else if(a==3){
            int len=company[2].getSharedBikes().length;
            System.out.println("请录入要归还的单车编号：");
            id=input.nextInt();
            if(id<=0||id>len){
                System.out.println("请输入正确的单车编号");
            }else if(company[2].getSharedBikes()[id-1].getBikeState().equals("可借")){
                System.out.println("请录入正确的单车编号：");
            }else{
                System.out.println("请录入归还时间(yyyy-MM-dd HH:mm:ss)：");
                input.nextLine();
                time1=input.next();
                System.out.println("您的借车时间为："+company[2].getSharedBikes()[id-1].getBorrowTime());
                time2=company[2].getSharedBikes()[id-1].getBorrowTime();
                Date d1=sdf.parse(time1);//解析
                Date d2=sdf.parse(time2);
                money=((d1.getTime()-d2.getTime())/(24*60*60*1000))*2;
                System.out.println("您的用车时间为"+(d1.getTime()-d2.getTime())+"小时，需要支付"+money+"元");
            }
        }
        }
        public static void borrowBike(ShareBikeCompany company[]){
        int a;
        int id;
        String time;
        Scanner input=new Scanner(System.in);
            System.out.println("1.mobaiBike");
            System.out.println("2.ofoBike");
            System.out.println("3.haloBike");
            System.out.println("请选择要借出的单车品牌：");
            a=input.nextInt();
            if(a<=0||a>3){
               System.out.println("请输入正确的编号：");
            }else if(a==1){
                System.out.println("此mobai单车有共享单车如下");
                System.out.println("单车序号    单车品牌    单车状态    借出时间");
                int len=company[0].getSharedBikes().length;
                for (int index = 0; index < len; index++) {
                    System.out.println(company[0].getSharedBikes()[index].getId() + "        " +
                            company[0].getSharedBikes()[index].getBikeName() + "        " +
                            company[0].getSharedBikes()[index].getBikeState()
                            + "        " + company[0].getSharedBikes()[index].getBorrowTime());
                }
                    id=input.nextInt();
                    if(id<=0||id>len){
                        System.out.println("请输入正确的编号：");
                    }else{
                        if(company[0].getSharedBikes()[id-1].getBikeState().equals("已借出")){
                            System.out.println("请输入未借出的单车编号");
                        }else{
                            System.out.println("请输入借出单车的日期（yyyy-mm-dd hh:mm:ss）：");
                            time=input.next();
                            System.out.println("借出单车成功");
                            company[0].getSharedBikes()[id-1].setBorrowTime(time);
                            company[0].getSharedBikes()[id-1].setBikeState("已借出");//借出后更改状态
                            company[0].setCount(company[0].getCount()+1);//借出后次数+1
                        }
                    }
            }else if(a==2){
                System.out.println("此mobai单车有共享单车如下");
                System.out.println("单车序号    单车品牌    单车状态    借出时间");
                int len=company[1].getSharedBikes().length;
                for (int index = 0; index < len; index++) {
                    System.out.println(company[1].getSharedBikes()[index].getId() + "        " +
                            company[1].getSharedBikes()[index].getBikeName() + "        " +
                            company[1].getSharedBikes()[index].getBikeState()
                            + "        " + company[1].getSharedBikes()[index].getBorrowTime());
                }
                    System.out.println("请录入要选择借出的单车编号：");
                    id=input.nextInt();
                    if(id<=0||id>len){
                        System.out.println("请输入正确的编号：");
                    }else{
                        if(company[1].getSharedBikes()[id-1].getBikeState().equals("已借出")){
                            System.out.println("请输入未借出的单车编号");
                        }else{
                            System.out.println("请输入借出单车的日期（yyyy-mm-dd hh:mm:ss）：");
                            time=input.next();
                            System.out.println("借出单车成功");
                            company[1].getSharedBikes()[id-1].setBorrowTime(time);
                            company[1].getSharedBikes()[id-1].setBikeState("已借出");//借出后更改状态
                            company[1].setCount(company[1].getCount()+1);//借出后次数+1
                        }
                    }
            }else if(a==3){
                System.out.println("此mobai单车有共享单车如下");
                System.out.println("单车序号    单车品牌    单车状态    借出时间");
                int len=company[2].getSharedBikes().length;
                for (int index = 0; index < len; index++) {
                    System.out.println(company[2].getSharedBikes()[index].getId() + "        " +
                            company[2].getSharedBikes()[index].getBikeName() + "        " +
                            company[2].getSharedBikes()[index].getBikeState()
                            + "        " + company[2].getSharedBikes()[index].getBorrowTime());
                }
                    System.out.println("请录入要选择借出的单车编号：");
                    id=input.nextInt();
                    if(id<=0||id>len){
                        System.out.println("请输入正确的编号：");
                    }else{
                        if(company[2].getSharedBikes()[id-1].getBikeState().equals("已借出")){
                            System.out.println("请输入未借出的单车编号");
                        }else{
                            System.out.println("请输入借出单车的日期（yyyy-mm-dd hh:mm:ss）：");
                            time=input.next();
                            System.out.println("借出单车成功");
                            company[2].getSharedBikes()[id-1].setBorrowTime(time);
                            company[2].getSharedBikes()[id-1].setBikeState("已借出");//借出后更改状态
                            company[2].setCount(company[2].getCount()+1);//借出后次数+1
                        }
                    }
                }
            }
            public static void rank(ShareBikeCompany company[]){
              int[] rank=new int[3];
              String[] companyName=new String[3];
              rank[0]=company[0].getCount();
              rank[1]=company[1].getCount();
              rank[2]=company[2].getCount();
              Arrays.sort(rank);
                System.out.println("公司名称         借出总数");
              for(int index=2;index>=0;index--){
                  if(rank[index]==company[0].getCount()){
                      companyName[index]="mobaiBike";
                  }else if(rank[index]==company[1].getCount()){
                      companyName[index]="ofoBike";
                  }else if(rank[index]==company[2].getCount()){
                      companyName[index]="haloBike";
                  }
                  System.out.println(companyName[index]+"           "+rank[index]);
              }
            }
        }






