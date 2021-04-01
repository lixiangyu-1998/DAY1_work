import work1.tencentQQ;

/**
 * @author:LXY
 * @className:test
 * @description:
 * @date:2021/3/2420:59
 * @version:0.1
 * @since:1.8
 */
public class test {
    public static void main(String[] args) {
        tencentQQ qq = new tencentQQ();
        qq.qqGameLoad();
        qq.qqGameUninstall();
        qq.qqMusicLoad();
        qq.qqMusicUninstall();
        qq.qqSpaceLoad();
        qq.qqSpaceUninstall();
    }
}
