import work3.normalStudent;
import work3.richStudent;
import work3.student;

/**
 * @author:LXY
 * @className:test3
 * @description:
 * @date:2021/3/2421:44
 * @version:0.1
 * @since:1.8
 */
public class test3 {
    public static void main(String[] args) {
        normalStudent normalStudent=new normalStudent("lilei",24);
        richStudent richStudent=new richStudent("hanmeimei",18);
        normalStudent.study();
        richStudent.study();
        richStudent.earnMoney();
    }
}
