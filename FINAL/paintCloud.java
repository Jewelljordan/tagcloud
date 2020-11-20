package TagCloud;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class paintCloud extends JPanel  {
	
	private ArrayList<rectCloud> words;
	private double SCALE;
	private static final int centerX = TagCloud.WIDTH/2, centerY = TagCloud.HEIGHT/2;
	
	public paintCloud(int max, Map<String,Integer> w) {
		setBackground(Color.WHITE);	
		words = new ArrayList<rectCloud>();
		double count = 0,avg = 0; 
		for(Map.Entry<String,Integer> k : w.entrySet()) {
			words.add(new rectCloud(k.getKey(),k.getValue()));
		}
		SCALE = .3;
		
		System.out.println(words);
	}
	
	public void paint(Graphics w) {
		ArrayList<rectCloud> drawnWords = new ArrayList<>();
		int count=0;
		for(rectCloud word : words) {
			w.setFont(new Font(Font.SANS_SERIF, Font.BOLD, (int)(word.getWeight()/SCALE)));
			w.setColor(Color.PINK);
			FontMetrics font = w.getFontMetrics();
			
			Rectangle bounds = getBounds((Graphics2D) w, word.getWord(), 0,0);
			
			int height = font.getHeight();
			int width = font.stringWidth(word.getWord());
			//width += Math.sqrt(width)/3;

			if(height<=0) { height = 1; } //min height
			if(width<=0) { width = 1; } //min width

			int finX = 0, finY = 0;
			double mindis = 1e8;
			rectCloud end = new rectCloud();
			for(int i = 0; i < TagCloud.WIDTH; i+=5) {
				for(int j = 0; j < TagCloud.HEIGHT; j+=5) {
					rectCloud pos = new rectCloud(word.getWord(),word.getWeight());
					pos.setDimensions(i, j, width, height);
			        
					boolean ok = true;
					for(Rectangle item : drawnWords) {
						if(pos.intersects(item)) {
							ok = false;
							break;
						}
					}
					if(!ok) continue;
					
					double midRectX = pos.getCenterX();
					double midRectY = pos.getCenterY();
					double dis = distance(centerX,midRectX,centerY,midRectY);
					
					if(dis < mindis) {
						mindis = dis;
						end = pos;
						finX = i;
						finY = j;
					}
				}
			}
			drawnWords.add(end);
				
			int placeY = finY + height;
			
			//draw the border rectangles for each word
			//w.drawRect(end.x, end.y, end.width, end.height);
			w.drawString(word.getWord(), finX+(int)(Math.sqrt(width)/3), placeY - (height - bounds.height)/2);
		
			count++;
			if(count>100) {
				break;
			}
		}
	}
	
	public Rectangle getBounds(Graphics2D g, String s, int x, int y) {
		FontRenderContext render = g.getFontRenderContext();
        GlyphVector vec = g.getFont().createGlyphVector(render, s);
        return vec.getPixelBounds(null, x, y);
	}
	
	public double distance(double x1, double x2, double y1, double y2) {
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}
}
