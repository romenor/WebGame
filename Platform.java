import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Platform {

	int dx;
	int x, y, width, height;
	
	public Platform() {
		// TODO Auto-generated constructor stub
		dx = -1;
		x = 300;
		y = 300;
		width = 120;
		height = 40;
	}
	
	public Platform(int x, int y){
		this.x = x;
		this.y = y;
		width = 120;
		height = 40;
		dx  = -1;
	}
	
	public void update(StartingPoint sp, Ball b){
			x += dx;
			checkForCollionsion(b);
			if (x < 0 - width){
				Random r = new Random();
				y = sp.getHeight() - 40 - r.nextInt(400);
				x = sp.getWidth()+ r.nextInt(300);
			}
		}
		
		private void checkForCollionsion(Ball b) {
		// TODO Auto-generated method stub
			int ballX = b.getX();
			int ballY = b.getY();
			int radius = b.getRadius();
			
			if(ballY + radius  > y && ballY + radius < y + height){
				if(ballX > x && ballX < x + width){
					double newDY = b.getGameDy();
					b.setY(y - radius);
					b.setDy(newDY);
				}
			}
			
		
	}

		public void paint(Graphics g) {
			
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
			//g.drawRect(x, y, width, height);
			
		}
}
