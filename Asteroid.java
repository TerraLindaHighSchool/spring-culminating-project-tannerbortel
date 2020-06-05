import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A rock in space.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 2.0
 */
public class Asteroid extends Mover
{
    /** Size of this asteroid */
    private int size;

    /** When the stability reaches 0 the asteroid will break up */
    private int stability;

    /**
     * Create an asteroid with default size and speed.
     */
    public Asteroid()
    {
        this(64);
           
    }
    
    /**
     * Create an asteroid with a given size, random movement direction and 
     * default speed.
     */
    public Asteroid(int size)
    {
        this(size, new Vector(Greenfoot.getRandomNumber(360), 2));
    }
    
    /**
     * Create an asteroid with a given size size, direction, and speed.
     */
    private Asteroid(int size, Vector speed)
    {
        super(speed);
        setSize(size);
    }
    
    /**
     * Let the asteroid act. That is: fly around.
     */
    public void act()
    {         
        move();
         if (isTouching(Bullet.class))
        {
            getWorld().removeObject(this);
        }
    }

    /**
     * Set the size of this asteroid. Note that stability is directly
     * related to size. Smaller asteroids are less stable.
     */
    public void setSize(int size) 
    {
        this.size = size;
        stability = size;
        GreenfootImage image = getImage();
        image.scale(size, size);
    }

    /**
     * Return the current stability of this asteroid. (If it goes down to 
     * zero, it breaks up.)
     */
    public int getStability() 
    {
        return stability;
    }
    

    
}