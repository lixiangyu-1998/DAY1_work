import work1.Instrument;
import work1.Violin;
import work1.piano;

/**
 * @author:LXY
 * @className:instrumentTest
 * @description:
 * @date:2021/3/2216:47
 * @version:0.1
 * @since:1.8
 */
public class instrumentTest {
    public static void testPlay(Instrument instrument){
        if(instrument instanceof piano){
            piano piano=(piano)instrument;
            piano.play();
        }else if(instrument instanceof Violin){
            Violin Violin=(Violin)instrument;
            Violin.play();
        }
    }
    public static void main(String[] args){
        Instrument piano=new piano();
        Instrument violin=new Violin();
        testPlay(piano);
        testPlay(violin);

    }
}
