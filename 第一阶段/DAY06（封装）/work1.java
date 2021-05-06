import com.sun.scenario.effect.impl.state.AccessHelper;
import sun.plugin2.message.GetNameSpaceMessage;
import sun.util.calendar.CalendarUtils;

/**
 * @author:LXY
 * @className:work1
 * @description:
 * @date:2021/3/209:25
 * @version:0.1
 * @since:1.8
 */
public class work1 {
    public static class programmer{
        private int id;
        private String name;
        private String gender;
        private int salary;
        private int hot;
        public programmer(){//无参构造函数
        }
        public programmer(int id, String name, String gender, int salary, int hot) {//全参构造函数
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.salary = salary;
            this.hot = hot;
        }
        public  void setId(int id){
            this.id=id;
        }
        public  int getId(){
            return id;
        }
        public  void setName(String name){
            this.name=name;
        }
        public  String getName(){
            return name;
        }
        public  void setGender(String gender){
            this.gender=gender;
        }
        public  String getGender(){
            return gender;
        }
        public  void setSalary(int salary){
            this.salary=salary;
        }
        public  int getSalary(){
            return salary;
        }
        public  void setHot(int hot){
            this.hot=hot;
        }
        public  int getHot(){
            return hot;
        }
        private void show(){//显示详细信息方法
            System.out.println("显示"+getName()+"的详细信息:  "+"员工编号为："+getId()+
                    "  性别是："+getGender()+"  工资是："+getSalary()+"关注度为："+getHot());
        }
    }
    public static class projectManager{
        private int id;
        private String name;
        private String gender;
        private int salary;
        private int bonus;
        public projectManager(){//无参构造函数
        }
        public projectManager(int id, String name, String gender, int salary, int bonus) {//全参构造函数
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.salary = salary;
            this.bonus = bonus;
        }
        public  void setId(int id){
            this.id=id;
        }
        public  int getId(){
            return id;
        }
        public  void setName(String name){
            this.name=name;
        }
        public  String getName(){
            return name;
        }
        public  void setGender(String gender){
            this.gender=gender;
        }
        public  String getGender(){
            return gender;
        }
        public  void setSalary(int salary){
            this.salary=salary;
        }
        public  int getSalary(){
            return salary;
        }
        public  void setHot(int hot){
            this.bonus=bonus;
        }
        public  int getBonus(){
            return bonus;
        }
        private void show(){//显示详细信息方法
            System.out.println("显示"+getName()+"的详细信息:  "+"员工编号为："+getId()+
                    "  性别是："+getGender()+"  工资是："+getSalary()+"关注度为："+getBonus());
        }
    }
    public static class calculateSalary{//计算工资 类
        public static void calculateSalary(int salary){//员工工资
            System.out.println("所查询的员工工资是"+salary);
        }
        public static void calculateSalary(int salary,int bonus){//重载方法 项目经理工资
            System.out.println("所查询的员工工资是"+(salary+bonus));
        }
    }
    public static class test{
        public static void main(String[] strs){
            //显示详细信息
            programmer tom=new programmer(6324,"tom","男",9999,666);
            programmer jerry=new programmer(6325,"jerry","女",8888,888);
            projectManager jack=new projectManager(6326,"jack","男",18888,6666);
            projectManager jay=new projectManager(6327,"jay","男",19999,8888);
            tom.show();
            jerry.show();
            jack.show();
            jay.show();
            //分别计算员工工资和项目经理工资
            calculateSalary calculateSalary=new calculateSalary();
            calculateSalary.calculateSalary(tom.salary);
            calculateSalary.calculateSalary(jay.salary,jay.bonus);
        }


    }
    public static void main(String[] strs){





    }
}
