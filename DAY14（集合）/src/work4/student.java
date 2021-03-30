package work4;

import jdk.nashorn.internal.ir.LiteralNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

/**
 * @author:LXY
 * @className:student
 * @description:
 * @date:2021/3/2917:36
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class student implements Comparable{
    private Integer id;
    private Integer score;
    public int compareTo(Object obj){//重写方法
        student student=(student)obj;
        return this.score-student.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof student)) return false;
        student student = (student) o;
        return Objects.equals(getId(), student.getId()) &&
                Objects.equals(getScore(), student.getScore());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getScore());
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", score=" + score ;

    }

    //4. 创建Student类，属性包括id[1-40], score[0-100],所有属性随机生成。
// 创建Set集合，保存20个对象，找到分数最高与最低的学生
    public static void main(String[] args) {
        List list=new ArrayList(){
        };
        for(int i=0;i<20;i++){
            list.add( new student((int)(Math.random()*39+1), (int) (Math.random()*99+1)));
        }
        Collections.sort(list);
        System.out.println("分数最低的学生id与分数为："+list.get(0)+"分数最高的学生id与分数为："+list.get(19));
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        for(int index=0;index<20;index++){
//            System.out.println(list.get(index).);
//        }


    }

}
