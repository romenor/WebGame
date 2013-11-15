import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class StartingPoint extends Applet implements Runnable, KeyListener{
	

	private Image i;
	private Graphics doubleG;
	Ball b, b2;
	Platform p[] = new Platform[7];
	Item item[] = new Item[3];
	
	
	
	@Override
	public void init() {
		setSize(800, 600);
		addKeyListener(this);
	}
	
	@Override
	public void start() {
		b = new Ball();
		//set up platforms
		for (int i = 0; i < p.length; i++){
			Random r = new Random();
			p[i] = new Platform(getWidth() + 200 * i, getHeight() - 40 - r.nextInt(400));
		}
		for (int i = 0; i < item.length; i++){
			Random r = new Random();
			item[i] = new GravUp(getWidth() + 2000 * i);
		}
		
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//thread information
		while (true){
			b.update(this);
			for (int i = 0; i<p.length; i++){
				p[i].update(this, b);
			}
			
			for (int i = 0; i<item.length; i++){
				item[i].update(this, b);
			}
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void stop() {


	}
	
	@Override
	public void destroy() {


	}
	
	
	/**
	 * Instead of having a blank page, 
	 * it updates with the last background and foreground page
	 * DoubleBuffer (Gets rid of flickering)
	 */
	@Override
	public void update(Graphics g) {
		if(i == null){
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}
		
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
	
		doubleG.setColor(getForeground());
		paint(doubleG);
		
		g.drawImage(i, 0, 0, this);
	
	}
	
	@Override
	public void paint(Graphics g) {
		b.paint(g);
		for (int i = 0; i<p.length; i++){
			p[i].paint(g);
		}
		
		for (int i = 0; i<item.length; i++){
			item[i].paint(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			b.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			b.moveRight();
			break;
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
