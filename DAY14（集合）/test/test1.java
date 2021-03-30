import work1.employee;
import work1.programmer;
import work1.projectManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:LXY
 * @className:test1
 * @description:
 * @date:2021/3/2713:18
 * @version:0.1
 * @since:1.8
 */
public class test1 {
    public static void main(String[] args) {
        programmer pg1=new programmer("marry",9527,28,758);
        programmer pg2=new programmer("lucy",9727,30,471);
        projectManager pm1=new projectManager("cherry",1452,37,99);
        projectManager pm2=new projectManager("lion",1172,44,999);
        ArrayList<employee> employeeList=new ArrayList<>();
        employeeList.add(pg1);
        employeeList.add(pg2);
        employeeList.add(pm1);
        employeeList.add(pm2);
        int len=employeeList.size();
        for (int index=0;index<len;index++){
            if(employeeList.get(index) instanceof programmer){
                programmer programmer=(programmer)employeeList.get(index);
                programmer.show();
            }else if(employeeList.get(index) instanceof projectManager){
                projectManager projectManager=(projectManager)employeeList.get(index);
                projectManager.show();
            }
        }






    }
}
