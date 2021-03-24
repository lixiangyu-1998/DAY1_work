import work4.catDemon;
import work4.goblin;
import work4.monster;

/**
 * @author:LXY
 * @className:monsterTest
 * @description:
 * @date:2021/3/2217:45
 * @version:0.1
 * @since:1.8
 */
public class monsterTest {
    public static void attack(monster monster){
        if(monster instanceof catDemon){
            catDemon catDemon=(work4.catDemon)monster;
            catDemon.attack();
        }else if(monster instanceof goblin){
            goblin goblin=(work4.goblin)monster;
            goblin.attack();
        }
    }
    public static void move(monster monster){
        if(monster instanceof catDemon){
            catDemon catDemon=(work4.catDemon)monster;
            catDemon.move();
        }else if(monster instanceof goblin){
            goblin goblin=(work4.goblin)monster;
            goblin.move();
        }
    }

    public static void main(String[] args) {
        monster[] monster=new monster[2];
        goblin goblin=new goblin();
        catDemon catDemon=new catDemon();
        monster[0]=goblin;
        monster[1]=catDemon;
        int len=monster.length;
        for(int index=0;index<len;index++){
            attack(monster[index]);
            move(monster[index]);
        }
    }
}
