//der Button funktioniert! Man muss nur nach dem Klicken die Groesse des Fensters kurz aendern, dann erscheint der Text

package basketball;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BasketBall{

	private int width = 250;
	private int height = 250;
	private int y = height/2;
	private int x = width/2;
	private int v=0;
	private int r=10;
	static JFrame frame = new JFrame("~~~~~~~BASKETBALL!~~~~~~~");
	
	
	//Random ran = new Random();
	//Color ranColor = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
	//button.addActionListener(new ButtonLauscher());
	
	public static void main(String[] args) {
		
		final BasketBall b = new BasketBall();
		
		
		JPanel panel = new JPanel() {
			
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.ORANGE);
				g.fillOval(b.x-b.r, b.y-b.r, 2*b.r, 2*b.r);
			}
		};
		
		panel.setBackground(Color.BLACK);
		//panel.setLayout(new GridLayout(1,10));
		panel.setPreferredSize(new Dimension((b.width)-50,(b.height)-50));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLUE);
		
		String text = "Basketball ist toll";
		JLabel basket = new JLabel(text);
		final JLabel wiederspruch = new JLabel ("Basketball ist doof");
		
		
		//FUNKTIONIERT, aber muss an Fenster "wackeln" damit man es sieht (also einmal kurz die groesse aendern)
		JButton button = new JButton("NEIN!");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent bas){
				frame.add(wiederspruch);
			}
		});
		
		
		
		
		//frame.setContentPane(panel);
		frame.setContentPane(buttonPanel);
		frame.add(panel, BorderLayout.WEST);
		//frame.add(buttonPanel, BorderLayout.EAST);
		panel.setSize(b.width, b.height);
		frame.add(basket);
		frame.add(button);
		
		frame.setSize(2500, 250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			b.simulate();
			panel.repaint();
			//System.out.println("hallo");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void simulate() {
		
		x = x + v;
		v = v - 1;
		if (x <= r) {
			v = (-v)-1;
			//System.out.println(v);
		}
		
		
	}
	
	
}