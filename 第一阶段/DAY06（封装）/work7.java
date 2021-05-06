import java.util.Scanner;

/**
 * @author:LXY
 * @className:work7
 * @description:
 * @date:2021/3/2014:43
 * @version:0.1
 * @since:1.8
 */
public class work7 {
    public static class music{
        String musicName;
        int musicTime;
        String singer;
        public music() {
        }
        public music(String musicName, int musicTime, String singer) {
            this.musicName = musicName;
            this.musicTime = musicTime;
            this.singer = singer;
        }
    }
    public static class musicPlayer{
        String musicPlayerName;
        public static void playMusic(String name1,String name2,int time){
            System.out.println("正在播放 "+name1+" 演唱的音乐：《"+name2+"》  剩余时间："+time/60+"分"+time%60+"秒");
        }
    }
    public static void main(String[] strs){
        String name;
        int time;
        String singer;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入音乐名：");
        name=input.next();
        System.out.println("请输入播放时长(秒)：");
        time=input.nextInt();
        System.out.println("请输入歌手名：");
        singer=input.next();
        music music1=new music(name,time,singer);
        musicPlayer.playMusic(music1.singer,music1.musicName,music1.musicTime);
    }
}
