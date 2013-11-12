import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class StartingPoint extends Applet implements Runnable, KeyListener{
	

	private Image i;
	private Graphics doubleG;
	Ball b, b2;
	Platform p;
	
	
	
	@Override
	public void init() {
		setSize(800, 600);
		addKeyListener(this);
	}
	
	@Override
	public void start() {
		b = new Ball();
		b2 = new Ball(250, 250);
		p = new Platform();
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//thread information
		while (true){
			b.update(this);
			b2.update(this);
			p.update(this);
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
		b2.paint(g);
		p.paint(g);
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
