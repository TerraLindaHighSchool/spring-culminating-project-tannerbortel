import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Space. Something for rockets to fly in...
 * 
 * @author Michael Kölling
 * @version 2.1
 */
public class Space extends World
{
    /**
     * Create the space world with black background and stars.
     */
    public Space() 
    {
        super(800, 600, 1);
        setBackground(new GreenfootImage("ocean.png"));
        Explosion.initialiseImages();
        prepare();
          switch( Greenfoot.getRandomNumber(3) )
      {
        case 0: addObject(new Asteroid(), 800, 600); break;
        case 1: addObject(new Shark(), 100, 400); break;
        case 2: addObject(new Asteroid(), 600, 700); break;
       } 
    }


    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Asteroid asteroid = new Asteroid();
        addObject(asteroid,600,500);
        Asteroid asteroid2 = new Asteroid();
        addObject(asteroid2,300,400);
        Rocket rocket = new Rocket();
        addObject(rocket,400,300);
    }
}