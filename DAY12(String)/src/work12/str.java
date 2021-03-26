package work12;

/**
 * @author:LXY
 * @className:str
 * @description:
 * @date:2021/3/2617:45
 * @version:0.1
 * @since:1.8
 */
public class str {
    public static void main(String[] args) {
        //12. 现有一个字符串
        // “我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程”。
        // 将该字符串变成:“我要学编程”。
        // 使用正则
        StringBuffer str1=new StringBuffer();
        str1.append("我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程");
        String str2="我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程";
        str2=str2.replaceAll("\\.+","");//去掉.号
        System.out.println(str2);


    }
}
