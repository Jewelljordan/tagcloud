import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.*;

import mapCloud.Pair; 

public class graphicCloud extends JPanel
{
	private Map<String, Integer> cloud;
	private ArrayList<Pair> pairs;
	private ArrayList<Rectangle> rectangles;
    private int x;
    private int y;
/*
	public graphicCloud(Map<String, Integer> input){
		setBackground(Color.WHITE);
		cloud = input;
		x=300;
		y=400;
		rectangles = new ArrayList<Rectangle>();
		
	}
	*/

	public graphicCloud(ArrayList<Pair> list) {
		setBackground(Color.WHITE);
		pairs = list;
		x=300;//needs to be middle
		y=400;
		rectangles = new ArrayList<Rectangle>();
	}
	public class Pair implements Comparable<Pair>{
		String num;
		int times;
		
		public Pair(String a, int b) {
			num = a;
			times = b;
		}
		public int compareTo(Pair a) {
			if (num == a.num) return -1*Integer.compare(times, a.times);
			return a.num.compareTo(num);
		}
		public String toString() {
			return num + " " + times;
		}
		public int getValue() {return times;}
		public String getWord() {return num;}
	}

	public void paint( Graphics g ){ //cloud.get(current) == value, current = string
		for(Pair pair:pairs) {
			Rectangle a = new Rectangle(x, y, pair.getValue()*pair.getWord().length()/2, pair.getValue());
			//Rectangle a = new Rectangle(x, y,((cloud.get(current))*(current.length()))/2,cloud.get(current));
			//rectangles.add(a);
			for(Rectangle r: rectangles) {
				while(a.intersects(r)) {
					//need to change x and y
					x+=(int)((Math.random()*10)-10);//fix change to 1?
					y+=(int)((Math.random()*10)-10);
					a = new Rectangle(x, y, pair.getValue()*pair.getWord().length()/2, pair.getValue());
				}
					
			}
			rectangles.add(a);
			
			//draws rectangle(is this even needed)
			g.setColor(Color.black);
			g.drawRect((int)a.getX(),(int)a.getY(),(int)a.getWidth(),(int)a.getHeight());
			//g.drawRect(x, y, width, height);
			//draws string
			Font nFont = new Font("Arial", Font.BOLD, pair.getValue());
			g.setColor(Color.black);
			g.setFont( nFont );
			g.drawString(pair.getWord(), x, (int) (y+a.getHeight()));
		}
	}
			
}
