package work4;

/**
 * @author:LXY
 * @className:monster
 * @description:
 * @date:2021/3/2217:38
 * @version:0.1
 * @since:1.8
 */
public abstract class monster {
    String name;
    int hp;
    int attack;
    int defense;
    public abstract void attack();
    public abstract void move();
}
