import java.util.Scanner;

/**
 * @author:LXY
 * @className:work5
 * @description:
 * @date:2021/3/2013:28
 * @version:0.1
 * @since:1.8
 */
public class work5 {
    public static class administrator{
        String userName;
        int passWord;
        public administrator() {
        }
        public administrator(String userName, int passWord) {
            this.userName = userName;
            this.passWord = passWord;
        }
        public void show(){
            System.out.println("管理员的用户名是："+this.userName+"  密码是："+this.passWord);
        }
        public boolean verify(String userName,int passWord){
            if(this.userName.equals(userName)&&this.passWord==passWord){
                return true;
            }else{
                return false;
            }
        }
    }
//    public static class member{//看错题目了 看串行了
//        int memberNum;
//        String memberName;
//        int vipScore;
//        public member() {
//        }
//        public member(int memberNum, String memberName, int vipScore) {
//            this.memberNum = memberNum;
//            this.memberName = memberName;
//            this.vipScore = vipScore;
//        }
//    }
    public static void main(String[] strs){
        Scanner input=new Scanner(System.in);
        administrator admin=new administrator("cat",2021314);
        String userName;
        int passWord;
        System.out.println("请输入用户名：");
        userName=input.next();
        System.out.println("请输入密码：");
        passWord=input.nextInt();
        if(admin.verify(userName,passWord)){
            System.out.println("登陆成功");
        }else{
            System.out.println("账号密码输入错误，登陆失败");
        }
        admin.show();
    }
}
