

/**
 * @author:LXY
 * @className:ShareBikeMgr
 * @description:
 * @date:2021/3/2219:27
 * @version:0.1
 * @since:1.8
 */
public class ShareBikeMgr {
    public ShareBikeCompany[] initial() {
        ShareBikeCompany mobai = new ShareBikeCompany(63, "mobai", 1, 133);
        ShareBikeCompany ofo = new ShareBikeCompany(46, "ofo", 2, 261);
        ShareBikeCompany halo = new ShareBikeCompany(22, "halo", 3, 437);
        SharedBike mobaiBike = new SharedBike(1, "mobaiBike", "可借", "");
        SharedBike ofoBike1 = new SharedBike(1, "ofoBike", "已借出", "2021-03-10 12:12:12");
        SharedBike ofoBike2 = new SharedBike(2, "ofoBike", "可借", "");
        SharedBike haloBike1 = new SharedBike(1, "haloBike", "已借出", "2021-03-01 12:12:12");
        SharedBike haloBike2 = new SharedBike(2, "haloBike", "可借", "");
        SharedBike haloBike3 = new SharedBike(3, "haloBike", "已借出", "2021-02-00 12:12:12");
        ShareBikeCompany company[] = new ShareBikeCompany[3];
        SharedBike[] bike1=new SharedBike[1];
        SharedBike[] bike2=new SharedBike[2];
        SharedBike[] bike3=new SharedBike[3];
        bike1[0]=mobaiBike;
        bike2[0]=ofoBike1;
        bike2[1]=ofoBike2;
        bike3[0]=haloBike1;
        bike3[1]=haloBike2;
        bike3[2]=haloBike3;
        company[0]=mobai;
        company[1]=ofo;
        company[2]=halo;
        company[0].setSharedBikes(bike1);
        company[1].setSharedBikes(bike2);
        company[2].setSharedBikes(bike3);
        return company;
    }

}
