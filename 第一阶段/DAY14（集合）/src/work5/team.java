package work5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sun.misc.PostVMInitHook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author:LXY
 * @className:team
 * @description:
 * @date:2021/3/2919:58
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class team {
    private Integer id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof team)) return false;
        team team = (team) o;
        return Objects.equals(getId(), team.getId()) &&
                Objects.equals(getName(), team.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return
                "id是" + id +
                ", 名字是" + name ;
    }

    public static void main(String[] args) {
        List list=new ArrayList();
        //5. 已知有十六支男子足球队参加2008 北京奥运会。写一个程序，把这16 支球队随机分为4 个组。
        // 采用List集合和随机数  2008 北京奥运会男足参赛国家：
        // 科特迪瓦,阿根廷,澳大利亚,塞尔维亚,荷兰,尼日利亚,
        // 日本,美国,中国,新西 兰,巴西,比利时,韩国,喀麦隆,洪都拉斯,意大利
        list.add(new team(1,"科特迪瓦"));
        list.add(new team(2,"阿根廷"));
        list.add(new team(3,"澳大利亚"));
        list.add(new team(4,"塞尔维亚"));
        list.add(new team(5,"荷兰"));
        list.add(new team(6,"尼日利亚"));
        list.add(new team(7,"日本"));
        list.add(new team(8,"美国"));
        list.add(new team(9,"中国"));
        list.add(new team(10,"新西兰"));
        list.add(new team(11,"巴西"));
        list.add(new team(12,"比利时"));
        list.add(new team(13,"韩国"));
        list.add(new team(14,"喀麦隆"));
        list.add(new team(15,"意大利"));
        list.add(new team(16,"洪都拉斯"));
        Collections.shuffle(list);
        Integer num=1;
        for(int index=0;index<16;){
            System.out.println("第"+num+"组");
            System.out.println(list.get(index));
            System.out.println(list.get(index+1));
            System.out.println(list.get(index+2));
            System.out.println(list.get(index+3));
            index=index+4;
            num++;
        }

    }
}
