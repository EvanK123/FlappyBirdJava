import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game 
{

    public static final int PIPE_DELAY = 100;

    private Boolean paused;

    private int pauseDelay;
    private int restartDelay;
    private int pipeDelay;

    private Bird bird;
    private ArrayList<Pipes> pipes;
    private Keyboard keyboard;

    public int score;
    public Boolean gameover;
    public Boolean started;

    public Game() 
    {
        keyboard = Keyboard.getInstance();
        restart();
    }

    public void restart() 
    {
        paused = false;
        started = false;
        gameover = false;
        score = 0;
        pauseDelay = 0;
        restartDelay = 0;
        pipeDelay = 0;

        bird = new Bird();
        pipes = new ArrayList<Pipes>();
    }

    public void update() 
    {
        watchForStart();

        if (!started)
            return;

        watchForPause();
        watchForReset();

        if (paused)
            return;

        bird.update();

        if (gameover)
            return;

        movePipes();
        checkForCollisions();
    }

    public ArrayList<Renderer> getRenders() 
    {
        ArrayList<Renderer> renders = new ArrayList<Renderer>();
        
        for (Pipes pipe : pipes)
            renders.add(pipe.getRender());
        
        renders.add(bird.getRender());
        return renders;
    }

    private void watchForStart() 
    {
        if (!started && keyboard.isDown(KeyEvent.VK_SPACE)) 
            started = true;
    }

    private void watchForPause() 
    {
        if (pauseDelay > 0)
            pauseDelay--;

        if (keyboard.isDown(KeyEvent.VK_P) && pauseDelay <= 0) 
        {
            paused = !paused;
            pauseDelay = 10;
        }
    }

    private void watchForReset() 
    {
        if (restartDelay > 0)
            restartDelay--;

        if (keyboard.isDown(KeyEvent.VK_R) && restartDelay <= 0) 
        {
            restart();
            restartDelay = 10;
            return;
        }
    }

    private void movePipes() 
    {
        pipeDelay--;

        if (pipeDelay < 0) {
            pipeDelay = PIPE_DELAY;
            Pipes northPipe = null;
            Pipes southPipe = null;

            for (Pipes pipe : pipes) 
            {
                if (pipe.x - pipe.width < 0) 
                {
                    if (northPipe == null)
                    {
                        northPipe = pipe;
                    } 
                    else 
                    	if (southPipe == null) 
                    	{
                        southPipe = pipe;
                        break;
                        }
                }
            }

            if (northPipe == null) 
            {
            	Pipes pipe = new Pipes("north");
                pipes.add(pipe);
                northPipe = pipe;
            } 
            else 
                northPipe.reset();

            if (southPipe == null) 
            {
            	Pipes pipe = new Pipes("south");
                pipes.add(pipe);
                southPipe = pipe;
            } 
            else 
                southPipe.reset();

            northPipe.y = southPipe.y + southPipe.height + 175;
        }

        for (Pipes pipe : pipes) 
            pipe.update();
        
}

    private void checkForCollisions() 
    {
    	Pipes northPipe = new Pipes("north");
    	Pipes southPipe = new Pipes("south");
        for (Pipes pipe : pipes) 
        {
            if (pipe.collide_test(northPipe) || pipe.collide_test(southPipe)) 
            {
                gameover = true;
                bird.dead = true;
            } 
            else 
            	if (pipe.x == bird.x && !pipe.collide_test(southPipe) && !pipe.collide_test(northPipe)) 
                score++;
        }
        if (bird.y + bird.height > Main.HEIGHT - 80) 
        {
            gameover = true;
            bird.dead = true;
            bird.y = Main.HEIGHT - 80 - bird.height;
        }
    }
} //pipe.x == bird.x && pipe.orientation.equalsIgnoreCase("south"