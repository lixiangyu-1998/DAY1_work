import work2.employee;
import work2.programmer;
import work2.projectManager;

import java.util.*;

/**
 * @author:LXY
 * @className:test2
 * @description:
 * @date:2021/3/2717:13
 * @version:0.1
 * @since:1.8
 */
public class test2 {
    public static void main(String[] args) {
        programmer pg1=new programmer("marry",9527,28,758);
        programmer pg2=new programmer("lucy",9727,30,471);
        projectManager pm1=new projectManager("cherry",1452,37,99);
        projectManager pm2=new projectManager("lion",1172,44,999);
        HashMap map=new HashMap<>();
        map.put(1,pg1);
        map.put(2,pg2);
        map.put(3,pm1);
        map.put(4,pm2);
        Set set=map.keySet();
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            Object obj=map.get(iterator.next());
            if(obj instanceof programmer){
                programmer programmer=(work2.programmer)obj;
                programmer.show();
            }else if(obj instanceof projectManager){
                projectManager projectManager=(work2.projectManager)obj;
                projectManager.show();
            }
        }
    }
}
