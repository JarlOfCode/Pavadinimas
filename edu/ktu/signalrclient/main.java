package edu.ktu.signalrclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
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
	static JTextArea chatBox = new JTextArea(5, 20);
	static JScrollPane chatPanel = new JScrollPane(chatBox);
	
	static JPanel drawingPanel = new JPanel();
	static int windowWidth = 700;
	static int windowHeight = 500;
	EnemyFactory EF = new EnemyFactory();
	GameSingleton GS = GameSingleton.getInstance();
	
	static String[] planeTypes = {"src/plane.jpg", "src/bomber.jpg", "src/helicopter.jpg"};
	
	
	
	static List<Enemy> enemies = new ArrayList<Enemy>();
	static List<Bullet> bullets = new ArrayList<Bullet>();
	static Player1 player;
	
	public static void main(String[] args) throws IOException{
		
		main GM = new main();
		GM.gui();
		GM.setVisible(true);	
		GM.forever();
	}
	
	public static void render() throws IOException {
		Graphics g = drawingPanel.getGraphics();
		
		/*javax.swing.Timer t = new javax.swing.Timer(0, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            drawingPanel.repaint();
	        }
	     });*/
		
		
		
		
			List<Enemy> e = enemies;
			for(int i = 0; i < e.size(); i++) {
				
				Enemy E = e.get(i);
				//drawingPanel.repaint(E.getX()-1, E.getY()-1, 100, 100);
				BufferedImage image = ImageIO.read(E.getImage());
		
				g.drawImage(image, E.getX(), E.getY(), null);
			}
			int x = player.getX();
			int y = player.getY();
			g.drawImage(player.getImage(), x, y, null);
			drawingPanel.repaint(x/2-5, y/2, x/2+10, y/2+500);
			//drawingPanel.repaint(x/2-10, y/2, x/2+10, y/2+500);
			System.out.println(x-10 + " ; " + y + " ; " + x  + " ; " +  y+500);
			// drawingPanel.repaint();
			//t.start();
		
	}
	
	public void forever() throws IOException {
		
		player  = new Player1();
		Graphics g = drawingPanel.getGraphics();
		drawingPanel.setFocusable(true);
		drawingPanel.requestFocus();
		requestFocusInWindow();
		main.render();
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
				System.out.println("Key typed");
				// TODO Auto-generated method stub
				
			}
		};
		
		addKeyListener(listener);
	}
	
	 /*private class TAdapter extends KeyAdapter {

	        
	    }*/
	
	// MANO RASYTI
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				spawnEnemy(test);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    else if(button.getText() == "Get Time and Score") {
	    	SendMessage("JavaClient", command);
	    	chatBox.append("\nTime: " + GS.getTime());
	    	chatBox.append("\nScore: " + GS.getScore());
	    }
	    else if(button.getText() == "Spawn a Player") {
	    	SendMessage("JavaClient", command);
	    	drawPlayer();	    	
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
		
		//JPanel drawingPanel = new JPanel();
		//drawingPanel = new JPanel();	
		drawingPanel.setBackground(Color.WHITE);
		drawingPanel.setSize(windowWidth, windowHeight);
		setLocationRelativeTo(null);
		workPanel.add(drawingPanel);//, BorderLayout.NORTH);
		
		//JScrollPane chatPanel = new JScrollPane();
		/*chatPanel.setLayout(new ScrollPaneLayout());
		chatPanel.setBackground(Color.GREEN);
		chatPanel.setVerticalScrollBarPolicy(*/
               // JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//JTextArea chatBox = new JTextArea();
		//chatPanel.add(chatBox);
		//chatBox.setWrapStyleWord(true);
		//chatBox.setEditable(false);
		//chatBox.append("SINGLETON TIME AND SCORE");
		//workPanel.add(chatPanel);//, BorderLayout.CENTER);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		add(buttonsPanel, BorderLayout.SOUTH);
		
		//Savi
		
		
		JButton button = new JButton("Spawn Random Enemy");
		button.addActionListener(this);
		buttonsPanel.add(button, BorderLayout.CENTER);
		buttonCache.put(button.getText(), button);
		
		JButton buttonLeft = new JButton("Get Time and Score");
		buttonLeft.addActionListener(this);
		buttonsPanel.add(buttonLeft, BorderLayout.WEST);
		buttonCache.put(buttonLeft.getText(), buttonLeft);
		
		JButton buttonRight = new JButton("Spawn a Player");
		buttonRight.addActionListener(this);
		buttonsPanel.add(buttonRight, BorderLayout.EAST);
		buttonCache.put(buttonRight.getText(), buttonRight);
		
		// Copy + Paste
		
		JButton buttonUp = new JButton("Up");
		buttonUp.addActionListener(this);
		buttonsPanel.add(buttonUp, BorderLayout.NORTH);
		buttonCache.put(buttonUp.getText(), buttonUp);
		
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
		//String msg = "RCV: " + user + ": " + message;
		String msg = user + ": " + message;
		System.out.println(msg);
		
		//ChatBoxAppend(msg);
		
		drawRedPlane();
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//	        public void run() {
//	        	ChatBoxAppend(msg);
//	        }
//	    });
	}
	
	/*private static void ChatBoxAppend(String msg) {
		chatBox.append(msg + "\n");
		chatBox.setCaretPosition(chatBox.getDocument().getLength());
		chatBox.update(chatBox.getGraphics());
		chatBox.paintImmediately(chatBox.getBounds());  
		chatPanel.paintImmediately(chatPanel.getBounds());
	}*/
	
    public static void TestSignalR() throws Exception{
        System.out.println("Enter the URL of the SignalR Chat you want to join");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        
        //String url = "https://chatroom2019.azurewebsites.net/signalr/";
        //String url = "https://localhost:5001/signalr/";
        String url = "http://localhost:5000/gamehub";
        

        HubConnection hubConnection = HubConnectionBuilder.create(url).build();
        
        System.out.println("connection established");

        
        hubConnection.on("ReceiveMessage", (user, message) -> {
            ReceiveMessage(user, message);
        }, String.class, String.class);      
        
        //This is a blocking call
        hubConnection.start().blockingAwait();
        
        HubConnectionState state = hubConnection.getConnectionState();

        String user = "java client";
        String message = "test";
        while (!message.equals("leave")){
        	message = reader.nextLine();
            hubConnection.send("SendMessage", user, message);
        }

        reader.close();
        hubConnection.stop();
    }
    
    public static void SendMessage(String user, String message) {
        
        //String url = "https://chatroom2019.azurewebsites.net/signalr/";
        //String url = "https://localhost:5001/signalr/";
        String url = "http://localhost:5000/gamehub";
        

        HubConnection hubConnection = HubConnectionBuilder.create(url).build();
        
        //System.out.println("connection established");   
        
        //This is a blocking call
        hubConnection.start().blockingAwait();

        String Id = hubConnection.getConnectionId();
        
        hubConnection.send("SendMessage", user, message);
        String msg = "SND: " + user + ": " + message;
        
		//ChatBoxAppend(msg);
		
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//	        public void run() {
//	        	ChatBoxAppend(msg);
//	        }
//	    });
        
        hubConnection.stop();
        
    }
	
	public static void getRequest() {
		//String url = "https://gameserver.azurewebsites.net/api/player";
		//String url = "https://chatroom2019.azurewebsites.net/api/player";
		String url = "https://chatroom2019.azurewebsites.net";
		
			
				//"http://localhost:8080/RestfulWebServices/order-inventory/order/1016";
	    HttpURLConnection urlConn = null;
	    BufferedReader reader = null;
	    try {
	        URL urlObj = new URL(url);
	        urlConn = (HttpURLConnection) urlObj.openConnection();
	        urlConn.setRequestMethod("GET");
	        urlConn.setConnectTimeout(5000);
	        urlConn.setReadTimeout(5000);
	       // urlConn.setRequestProperty("Accept", "application/json");
	        if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            System.err.println("GET - Unable to connect to the URL...");
	            return;
	        }
	        System.out.println("GET - Connected to the server...");
	        InputStream is = urlConn.getInputStream();
	        reader = new BufferedReader(new InputStreamReader((is)));
	        System.out.println("GET - Reading data from server...");
	        String tmpStr = null;
	        while((tmpStr = reader.readLine()) != null){
	            System.out.println(tmpStr);
	        }
	    } catch (MalformedURLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        try {
	            if(reader != null) reader.close();
	            if(urlConn != null) urlConn.disconnect();
	        } catch(Exception ex){
	             
	        }
	    }
	}
	
	public static void postRequest() {
		//String url = "https://gameserver.azurewebsites.net/api/player";
		//String url = "https://chatroom2019.azurewebsites.net/api/player";
		String url = "https://chatroom2019.azurewebsites.net";
		
        HttpURLConnection urlConn = null;
        BufferedReader reader = null;
        OutputStream ouputStream = null;
        String jsonInput = "{\"name\":\"Java-7\",\"score\":7,\"posX\":7,\"posY\":7}";
        //"{\"custmer\":\"Java2novice\",\"address\":\"Bangalore\","+ "\"bill-amount\":\"$2000\"}";
        try {
            URL urlObj = new URL(url);
            urlConn = (HttpURLConnection) urlObj.openConnection();
            urlConn.setDoOutput(true);
            urlConn.setRequestMethod("POST");
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.setConnectTimeout(5000);
            urlConn.setReadTimeout(5000);
            urlConn.setRequestProperty("Accept", "application/json");
            // send json input request
            ouputStream = urlConn.getOutputStream();
            ouputStream.write(jsonInput.getBytes());
            ouputStream.flush();
            String returnUrl = urlConn.getURL().toString();
            
            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.err.println("POST - Unable to connect to the URL...");
                return;
            }
            System.out.println("POST - Connected to the server...");
            InputStream is = urlConn.getInputStream();
            reader = new BufferedReader(new InputStreamReader((is)));
            String tmpStr = null;
            while((tmpStr = reader.readLine()) != null){
                System.out.println(tmpStr);
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(reader != null) reader.close();
                if(urlConn != null) urlConn.disconnect();
            } catch(Exception ex){
                 
            }
        }
	}

	
	
	public void draw() {
		Graphics g = drawingPanel.getGraphics();
		//g.clearRect(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());
		Runtime.getRuntime().gc();
		
		drawSinglePlane();
	}
	
	public void drawSinglePlane(){
		//class is not used
		Graphics g = drawingPanel.getGraphics();
		
		BufferedImage image;
		try {
			String fileName =  getRandomType();  //"src/plane.jpg";
			//File imageFile = new File(fileName);
			File imageFile = new File("src/bomber.jpg");
			//System.out.println(imageFile.getAbsolutePath() );			
			image = ImageIO.read(imageFile );
			
			g.drawImage(image, getRandomX(), getRandomY(), null);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void drawPlayer() {
		Graphics g = drawingPanel.getGraphics();
		Runtime.getRuntime().gc();
		
		BufferedImage image;
		try {
			String fileName =  getRandomType();  //"src/plane.jpg";
			//File imageFile = new File(fileName);
			File imageFile = new File("src/player.jpg");
			//System.out.println(imageFile.getAbsolutePath() );			
			image = ImageIO.read(imageFile );
			
			g.drawImage(image, getRandomX(), getRandomY(), null);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static   void drawRedPlane(){
		//class is not used
		Graphics g = drawingPanel.getGraphics();
		
		BufferedImage image;
		try {
			String fileName =  getRandomType();  //"src/plane.jpg";
			//File imageFile = new File(fileName);
			File imageFile = new File("src/plane-red.png");
			//System.out.println(imageFile.getAbsolutePath() );			
			image = ImageIO.read(imageFile );
			
			g.drawImage(image, getRandomX(), getRandomY(), null);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	public static int getRandomX(){
		return (int)(Math.random()*(windowWidth-100));
	}
	public static int getRandomY(){
		return (int)(Math.random()*(windowHeight-100));
	}
	
	public static String getRandomType(){
		Random random = new Random();
		int index = random.nextInt(planeTypes.length);
		return planeTypes[index];
	}	
}
