import java.awt.*; 
import java.awt.event.*;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*; 

public class graphicCloud extends Canvas
{
	private Map<String, Integer> cloud;
    private int x;
    private int y;

	public graphicCloud(Map<String, Integer> input){
		setBackground(Color.WHITE);
		cloud = input;
		x=0;
		y=0;
		
		//use font metrix and rectangle class to determine if words are intersecting
	}

	public void paint( Graphics window ){
		window.setColor(Color.RED);
		Iterator<Map> it = cloud.iterator(); //huh?
		while(it.hasNext()) {
			String a=it.next().getKey(); //map key
			int b=0; //map value
			//need some way to create a varible for the key and value so dont keep use it.next()
			Font nFont = new Font("Arial", Font.BOLD, b); //does it.next() get the key or value cause i need value
			window.setFont( nFont );
			if(x>windowsize) {
				x=reset;
				y+=10; //probs need to change
			}
			window.drawString(a,x,y); //needs key this time
			x+=cloud.get(a.length());//maybe need to * by something if to small
		}
		//just print in row, x=x+length of previous word, if x is greater than side value x is reset and y goes down
		//font size = number in map
		//or scale*value in map
		
	}	
}