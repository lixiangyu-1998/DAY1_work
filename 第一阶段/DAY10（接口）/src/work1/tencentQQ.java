package work1;

import java.util.Scanner;

/**
 * @author:LXY
 * @className:tencentQQ
 * @description:
 * @date:2021/3/2419:39
 * @version:0.1
 * @since:1.8
 */
public class tencentQQ implements qqSpace,qqMusic,qqGame {

    }


interface qqSpace{
   default void qqSpaceLoad(){
       System.out.println("正在加载qq空间插件");
       System.out.println("qq空间插件加载完成");
    }
    default void qqSpaceUninstall(){
        System.out.println("正在卸载qq空间插件");
        System.out.println("qq空间插件卸载完成");
    }
}
interface qqMusic{
    default void qqMusicLoad(){
        System.out.println("正在加载qqMusic插件");
        System.out.println("qqMusic插件加载完成");
    }default void qqMusicUninstall(){
        System.out.println("正在卸载qqMusic插件");
        System.out.println("qqMusic插件卸载完成");
    }
}
interface qqGame{
    default void qqGameLoad(){
        System.out.println("正在加载qqGame插件");
        System.out.println("qqGame插件加载完成");
    }default void qqGameUninstall(){
        System.out.println("正在卸载qqGame插件");
        System.out.println("qqGame插件卸载完成");
    }
}
