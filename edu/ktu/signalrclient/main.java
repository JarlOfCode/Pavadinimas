package edu.ktu.signalrclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;

import com.microsoft.signalr.Action2;
import com.microsoft.signalr.HubConnection;
import com.microsoft.signalr.HubConnectionBuilder;
import com.microsoft.signalr.HubConnectionState;

import FactoryAndBuilder.Enemy;
import FactoryAndBuilder.EnemyFactory;
import Strategy.Bullet;
import Testing.ManualTests;
import io.reactivex.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.awt.event.*;

public class main extends JFrame implements ActionListener, Action2<String, String>{

	HashMap<String,JButton> buttonCache = new HashMap<String,JButton>();
		
	
	static JPanel drawingPanel = new JPanel();
	static int windowWidth = 700;
	static int windowHeight = 500;
	EnemyFactory EF = new EnemyFactory();
	GameSingleton GS = GameSingleton.getInstance();
	static File bulletFile = new File("src/Bullet.png");
	
	
	
	static List<Enemy> enemies = new ArrayList<Enemy>();
	static List<Bullet> bullets = new ArrayList<Bullet>();
	static Renderer r; 
	static Player1 player;
	
	public static void main(String[] args) throws IOException{
		
		/*main GM = new main();
		
		GM.gui();
		
		GM.setVisible(true);
		GM.setup();
		
		r = new Renderer();
		r.start();
		
		player.startConstantObserve();
		
		while(true) {
		GM.constant();
		}*/
		
		ManualTests mt = new ManualTests();
		mt.evaluatesExpression();
	}
	
	
	public void constant() {
		requestFocusInWindow();
	}
	
	public static void render() throws IOException {
		r.run();	
	}
	
	public void setup() throws IOException {
		
		player  = new Player1();
		KeyListener listener = new KeyListener(){
			
			@Override
	        public void keyReleased(KeyEvent e) {
				//System.out.println("Key Released");
	            player.keyReleased(e);
	            
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	        	//System.out.println("Key pressed");
	            try {
					player.keyPressed(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
	        }

			@Override
			public void keyTyped(KeyEvent arg0) {
				//System.out.println("Key typed");
				// TODO Auto-generated method stub
				
			}
		};

		addKeyListener(listener);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    String command = ((JButton) e.getSource()).getActionCommand();
	    JButton button = buttonCache.get(command);
	    if(button.getText() == "Spawn Random Enemy") {
	    	SendMessage("JavaClient", command);
	    	Random random = new Random();
	    	int ran = random.nextInt(5 - 1) + 1;
	    	Enemy test = null;
	    	if(ran == 1) {
	    		test = EF.getEnemy("circle");
	    	}
	    	else if(ran == 2) {
	    		test = EF.getEnemy("spiral");
	    	}
	    	else if(ran == 3) {
	    		test = EF.getEnemy("continued");
	    	}
	    	else if(ran == 4) {
	    		test = EF.getEnemy("burst");
	    	}
	    	
			try {
				test.Spawn();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				spawnEnemy(test);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    }
	    else if(button.getText() == "Observer") {
	    	SendMessage("JavaClient", command);
	    	
	    }
	}
	
	public  void spawnEnemy(Enemy e) throws IOException{	
		e.setX(getRandomX());
		e.setY(getRandomY());
		enemies.add(e);
		render();
	}
	
	// COPY PASTE
	public void gui() {

		
		setSize(windowWidth * 2, windowHeight *2 );
		setTitle("BulletHell");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		JPanel workPanel;
		workPanel = new JPanel();	
		workPanel.setBackground(Color.ORANGE);
		add(workPanel, BorderLayout.CENTER);
		workPanel.setLayout(new  GridLayout(1,2));
		
		drawingPanel.setBackground(Color.WHITE);
		drawingPanel.setSize(windowWidth, windowHeight);
		setLocationRelativeTo(null);
		workPanel.add(drawingPanel);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		add(buttonsPanel, BorderLayout.SOUTH);
		
		
		JButton button = new JButton("Spawn Random Enemy");
		button.addActionListener(this);
		buttonsPanel.add(button, BorderLayout.CENTER);
		buttonCache.put(button.getText(), button);
		
		JButton buttonDown = new JButton("Observer");
		buttonDown.addActionListener(this);
		buttonsPanel.add(buttonDown, BorderLayout.SOUTH);
		buttonCache.put(buttonDown.getText(), buttonDown);
	}

	@Override
	public void invoke(String name, String message) {
		ReceiveMessage(name, message);
	}
	
	public static void ReceiveMessage(String user, String message) {
		String msg = user + ": " + message;
		System.out.println(msg);
	}
    
    public static void SendMessage(String user, String message) {
        String url = "http://localhost:5000/gamehub";
        

        HubConnection hubConnection = HubConnectionBuilder.create(url).build();
        hubConnection.start().blockingAwait();

        String Id = hubConnection.getConnectionId();
        
        hubConnection.send("SendMessage", user, message);
        String msg = "SND: " + user + ": " + message;
        
        hubConnection.stop();
        
    }
	
	public static int getRandomX(){
		return (int)(Math.random()*(windowWidth-100));
	}
	public static int getRandomY(){
		return (int)(Math.random()*(windowHeight-100));
	}
}

class Renderer implements Runnable {
	private Thread t;
	private String threadName;
	private BufferedImage bf;
	
	Renderer(){
		threadName = "renderer";
	}
	
	public void run() {
		BufferedImage bulletImage = null;
		try {
			bulletImage = ImageIO.read(main.bulletFile);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
	         
			Graphics g = main.drawingPanel.getGraphics();
			main.drawingPanel.setFocusable(true);
			main.drawingPanel.requestFocus();
			main.drawingPanel.paint(g);
			
				List<Enemy> e = main.enemies;
				for(int i = 0; i < e.size(); i++) {
					
					Enemy E = e.get(i);
					BufferedImage image = ImageIO.read(E.getImage());
			
					g.drawImage(image, E.getX(), E.getY(), null);
					
					
					
					
					for(int u = 0; u < E.getBullets().size(); u++) {
						if(E.getBullets().get(u).timeAlive > 100) {
							E.removeBullet(u);
						}
						else {
						E.getBullets().get(u).Move();
						g.drawImage(bulletImage, E.getBullets().get(u).getX(), E.getBullets().get(u).getY(), null);
						}
					}
				}
				Image bff = main.player.getImage();	
				
				for(int i = 0; i < main.player.getBullets().size(); i++) {
					main.player.getBullets().get(i).Move();
					g.drawImage(bulletImage, main.player.getBullets().get(i).getX(), main.player.getBullets().get(i).getY(), null);
				}
				
				int x = main.player.getX();
				int y = main.player.getY();
				g.drawImage(bff, x, y, null);
				
				try {
					Thread.sleep(0);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				Thread.sleep(16);
				
				try {
					Thread.sleep(0);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
	      } catch (IOException | InterruptedException e) {
	      }
		
	}
	
	public void update(Graphics g){
         	paint(g);
	}

	public void paint(Graphics g){
		bf = new BufferedImage( main.drawingPanel.getWidth(), main.drawingPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
		g.drawImage(bf,0,0,null);
	}
	
	public void start () {
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	  }
}