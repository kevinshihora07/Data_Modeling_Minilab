package socialdistancing;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Building {
	
	//Name of Building
	String name;
	
	//Front facing walls of Building
	Wall vWall;
	Wall hWall;
	
	//Building constraints
	int vx, vy, hx, hy;
	Rectangle vWRect;
	Rectangle hWRect;
		
    public Building(String name, int vx, int vy, int hx, int hy) {
    	this.name = name;
    	this.vx = vx;
    	this.vy = vy;
    	this.hx = hx;
    	this.hy = hy;
    	
    	vWall = new Wall(vx, vy, "SocialDistancingImages/wall2.png", true);
    	hWall = new Wall(hx, hy, "SocialDistancingImages/wall1.png", false);
    	
		this.vWRect = vWall.getBounds();
	    this.hWRect = hWall.getBounds();
    }
    
    public String getName() {
    	return name;
    }
    
    public Wall getVWall() {
    	return vWall;
    }
    
    public Wall getHWall() {
    	return hWall;
    }
    
    public void drawImage(Graphics g, Panel panel) {
    	
    	int xoffset = vx < hx ? vx : hx;
		g.drawString(name, xoffset + 50 , vy + 50);


    	g.drawImage(vWall.getImage(), vWall.getX(), vWall.getY(), panel);
    	g.drawImage(hWall.getImage(), hWall.getX(), hWall.getY(), panel);

    }
    
    public boolean vCollision(Rectangle rect) {
		
		if(vWRect.intersects(rect)) {
			return true;
		}	
		return false;
    } 
    
    public boolean hCollision(Rectangle rect) {
		
		if(hWRect.intersects(rect)) {
			return true;
		}	
		return false;
    } 
    
    public boolean collision(Rectangle rect) {

		if(vWRect.intersects(rect) || hWRect.intersects(rect)) {
			return true;
		}
		return false;
		
    } 

}