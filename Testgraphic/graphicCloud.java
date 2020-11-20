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
		x=400; //needs to be middle
		y=500;
		rectangles = new ArrayList<Rectangle>();
		
	}

	public void paint( Graphics g ){
		Set<String> keys= new TreeSet<String>();
		keys = cloud.keySet();
		Iterator it = keys.iterator();
		while(it.hasNext()) {
			String current = (String) it.next();
			Rectangle a = new Rectangle(x, y,((cloud.get(current))*(current.length()))/2,cloud.get(current));
			//rectangles.add(a);
			if(!rectangles.isEmpty()) {
				for(Rectangle r: rectangles) {
					while(a.intersects(r)) {
						//need to change x and y
						x+=(int)((Math.random()*5)-5);//fix change to 1?
						y+=(int)((Math.random()*5)-5);
						a = new Rectangle(x, y, ((cloud.get(current))*(current.length()))/2,cloud.get(current));
					}
						
				}
			}
			rectangles.add(a);
			
			//draws rectangle(is this even needed)
			g.setColor(Color.black);
			g.drawRect((int)a.getX(),(int)a.getY(),(int)a.getWidth(),(int)a.getHeight());
			//g.drawRect(x, y, width, height);
			//draws string
			Font nFont = new Font("Arial", Font.BOLD, cloud.get(current));
			g.setColor(Color.black);
			g.setFont( nFont );
			g.drawString(current, x, (int) (y+a.getHeight()));
		}
	}
			
}

