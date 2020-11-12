import java.awt.*; 
import java.awt.event.*;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*; 

public class graphicCloud extends JPanel
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

	public void paint( Graphics g ){
		FontMetrics f = g.getFontMetrics();
	}
			
}
