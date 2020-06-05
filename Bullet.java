import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A bullet that can hit asteroids.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 2.0
 */
public class Bullet extends Mover
{
    private int life;  // A bullet looses one life each act, and will disappear when life = 0 
    private int damage; // The damage this bullet will deal
    
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        life = 30;
        damage = 16;
        setRotation(rotation);
        increaseSpeed(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            move();
            Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
            if (asteroid != null) {
                getWorld().removeObject(this);
            }
            else {
                life--;
            }
        }
    }
}