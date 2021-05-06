import work3.animal;
import work3.fish;
import work3.snake;

/**
 * @author:LXY
 * @className:animalTest
 * @description:
 * @date:2021/3/2217:32
 * @version:0.1
 * @since:1.8
 */
public class animalTest {
    public static void move(animal animal){
        if(animal instanceof fish){
            fish fish=(fish)animal;
            fish.move();
        }else if(animal instanceof snake){
            snake snake=(snake)animal;
                    snake.move();
        }
    }
    public static void main(String[] args){
        animal fish=new fish();
        animal snake=new snake();
        move(fish);
        move(snake);

    }
}
