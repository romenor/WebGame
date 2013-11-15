import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Item {
	
	private int x,y, dx, radius;
	
	public Item(int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		Random r = new Random();
		y = r.nextInt(400) + radius;
		radius = 10;
		dx = -2;
		
	}
	
	
	
	
	public void update(StartingPoint sp, Ball b){
		x += dx;
		checkForCollionsion(b);
		if (x < 0 - radius){
			Random r = new Random();
			x = sp.getWidth()+ 2000 + r.nextInt(300);
		}
	}
	
	private void checkForCollionsion(Ball b) {
	// TODO Auto-generated method stub
		int ballX = b.getX();
		int ballY = b.getY();
		int radius = b.getRadius();
		/*
		if(ballY + radius  > y && ballY + radius < y + height){
			if(ballX > x && ballX < x + width){
				double newDY = b.getGameDy();
				b.setY(y - radius);
				b.setDy(newDY);
			}
		}
		*/
	
}

	public void paint(Graphics g) {
		
		//g.setColor(Color.RED);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
		//g.drawRect(x, y, width, height);
		
	}
	
}
