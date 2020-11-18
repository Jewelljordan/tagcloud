import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.*; 

public class graphicCloud extends JPanel
{
	private Map<String, Integer> cloud;
	private ArrayList<Rectangle> rectangles;
    private int x;
    private int y;

	public graphicCloud(Map<String, Integer> input){
		setBackground(Color.WHITE);
		cloud = input;
		x=300;
		y=400;
		rectangles = new ArrayList<Rectangle>();
		
	}

	public void paint( Graphics g ){
		Set<String> keys= new TreeSet<String>();
		keys = cloud.keySet();
		Iterator it = keys.iterator();
		while(it.hasNext()) {
			String current = (String) it.next();
			Rectangle a = new Rectangle(x, y, 10*(cloud.get(current)/2), 10*(cloud.get(current)/2));
			//rectangles.add(a);
			for(Rectangle r: rectangles) {
				while(a.intersects(r)) {
					//need to change x and y
					x+=(int)((Math.random()*10)-10);
					y+=(int)((Math.random()*10)-10);
					a = new Rectangle(x, y, 10*(cloud.get(current)/2), 10*(cloud.get(current)/2));
				}
					
			}
			rectangles.add(a);
			//draws rectangle(is this even needed)
			//g.drawRect((int)a.getX(),(int)a.getY(),(int)a.getWidth(),(int)a.getHeight());
			//draws string
			Font nFont = new Font("Arial", Font.BOLD, 10*(cloud.get(current)/2));
			g.setColor(Color.black);
			g.setFont( nFont );
			g.drawString(current, x, y);
		}
	}
			
}

