/**
 * @author:LXY
 * @className:work3
 * @description:
 * @date:2021/3/2011:26
 * @version:0.1
 * @since:1.8
 */
public class work3 {
    static int count=0;
    public static class human{
        int id;
        String name;
        int age;
        public void human(){//这是重载human方法？还是无参构造函数？ 总之当new时  次数相应++
            //System.out.println("当前是被创建的第"+count+"个人类对象");
            count++;
        }

        public human(int id, String name,int age) {
            this.age=age;
            this.id = id;
            this.name = name;
            count++;
        }

        public void compare(human name){
            if(this.age>name.age){
                System.out.println(this.name+"的年龄是"+this.age+"大于"+name.name+"的年龄"+name.age);
            }else if(this.age==name.age){
                System.out.println(this.name+"的年龄是"+this.age+"与"+name.name+"的年龄相等");
            }else{
                System.out.println(this.name+"的年龄是"+this.age+"小于"+name.name+"的年龄"+name.age);
            }
        }
    }
    public static void main(String[] strs){
        human cat=new human(6324,"cat",24);
        human jack=new human(6326,"jack",26);
        cat.compare(jack);
        System.out.println("一共创建了"+count+"个人类对象");
    }
}
