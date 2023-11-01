import greenfoot.*;
import java.util.List;
public class SnakeGame extends World 
{
    private snake snake;
    private food food;
    private int score;
    
    public SnakeGame()
    {
        super(600, 600, 1);
        snake = new snake();
        food = new food();
        addObject(snake, getWidth() / 2, getHeight() / 2);
        addObject(food, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight())); score = 0;
    }
    public void act()
    {
        snake.move(2);
        checkCollision();
    }
    public void checkCollision()
    {
        if (snake.intersects(food)) {
            snake.extend();
            removeObject(food);
            addObject(food, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight())); 
            score++;
        }
        if (snake.hitrock() || snake.hitItself()) {
        Greenfoot.stop();
        showText("Game Over! Score: " + score, getWidth() / 2, getHeight() / 2);
        } 
    }
}
