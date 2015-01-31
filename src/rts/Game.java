package rts;
import rts.mouse.Mouse;
import rts.state.State;
import rts.state.StateDebug;
import rts.state.StateTitle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements Runnable
{
	private Image dbImage;
	private Graphics dbGraphics;
	public static Mouse mouse;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	
	// States
	public State gameState;
	public State stateTitle, stateDebug;
 
	public Game()
	{
		//init();
	}
	
	public void init()
	{
		initGame();
		initStates();
	}
	
	public void initGame()
	{
		mouse = new Mouse();
		//addMouseListener (new Mouse());
		addMouseListener (mouse);
		setTitle("RTS");
		setSize(1366, 768);
		// Temp
		//setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*x = 15;
		y = 15;*/
		
		// Create a JPanel
		/*JPanel panel = new JPanel();
        add(panel);
        panel.requestFocusInWindow();*/
		
		// Create the canvas
		/*canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(1366, 768));
		canvas.setMaximumSize(new Dimension(1366, 768));
		canvas.setMinimumSize(new Dimension(1366, 768));*/
		
		// Add the canvas to the frame
		//add(canvas);
		//pack();

	}
	
	public void initStates()
	{
		// Load States
		stateDebug = new StateDebug();
		stateTitle = new StateTitle();
		
		// Initial State
		State.setState(stateDebug);
	}

	public void paint (Graphics g)
	{
		// Temp
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, 1366, 768);
		
		dbImage = createImage(getWidth(), getHeight());
		dbGraphics = dbImage.getGraphics();
		
		// Temp
		State.getState().render(dbGraphics);
		
		paintComponent(dbGraphics);
		g.drawImage(dbImage, 0, 0, this);
		
		// Temp
		/*if(State.getState() != null)
		{
			State.getState().render(g);
		}*/
	}

	public void paintComponent (Graphics g)
	{
		//g.fillOval(mouse.mouseCoordsX,mouse.mouseCoordsY,15,15);
		if (mouse.mouseOnScreen)
		{
			//g.setColor(Color.RED);
			//g.drawString("Coords: ("+ x + " , "+y+ ")", 150, 150);
		}
 
		repaint();
	}
	
	public void render()
	{
		System.out.println("render");
	}
	
	public void run()
	{
		// Render speed
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		// Create window
		init();
		
		// Main game loop
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000)
			{
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		// End game
		stop();
	}
	
	public synchronized void start()
	{
		if(running==false)
		{
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public synchronized void stop()
	{
		if(running==true)
		{
			try
			{
				thread.join();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void tick()
	{
		System.out.println("tick");
	}
}