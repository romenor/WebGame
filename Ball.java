import java.awt.Color;
import java.awt.Graphics;


public class Ball {

	
	private double gravity = 15;
	private double energyloss = 1;
	private double xFriction = .9;
	private double dt = .2;
	private int x = 400;
	private int y = 25;
	private double dx = 0;
	private double dy = 0;
	private double gameDy = -75;
	private int radius = 20;
	
	public Ball() {
		// TODO Auto-generated constructor stub
	}
	
	public Ball(int i, int j) {
		// TODO Auto-generated constructor stub
		x = i;
		y = j;
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getDx() {
		return dx;
	}
	public double getDy() {
		return dy;
	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}
	public double getGravity() {
		return gravity;
	}
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	public int getRadius() {
		return radius;
	}
	public double getGameDy() {
		return gameDy;
	}
	public void setGameDy(double gameDy) {
		this.gameDy = gameDy;
	}
	
	/**
	 * moves the ball to the right
	 */
	public void moveRight(){
		if(dx+1 < 20){
			dx += 1;
		}
	}
	/**
	 * nives ball to the left
	 */
	public void moveLeft(){
		if(dx-1 > -20){
			dx -= 1;
		}
	}

	public void update(StartingPoint sp){
		// Checks if the ball reaches the end of the applet
		if ( x + dx > sp.getWidth() - radius -1){
			//Set the ball to stop
			x = sp.getWidth() - radius - 1;
			//Change the direction
			dx = - dx;
		}else if(x+dx < 0 + radius){
			x = 0 + radius;
			dx = - dx;
		}
		else{
			//move the ball
			x += dx;
		}
		
		if(y == sp.getHeight() - radius -1){
			dx *= xFriction;
			if(Math.abs(dx) < .8){
				dx = 0;
			}
			
		}
		
		
		if(y > sp.getHeight() - radius - 1){
			y = sp.getHeight() - radius - 1;
			//makes the ball slow down after each bounce
			dy *= energyloss;
			dy = gameDy;
		}else{
			//velocity formula
			dy = dy + gravity * dt;
			//position formula
			y += dy*dt + .5*gravity*dt*dt;
		}
		
	}
	

	public void paint(Graphics g) {
		
		g.setColor(Color.GREEN);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
		
	}
	
}
