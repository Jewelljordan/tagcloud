import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.util.*;
import javax.swing.*;
import java.awt.Color.*;
import java.awt.*;
@SuppressWarnings("serial")
public class paintCloud extends JPanel  {
	
	private ArrayList<rectCloud> wordList;
	private double SCALE;
	private static final int centerX = TagCloud.WIDTH/2, centerY = TagCloud.HEIGHT/2;
	private Random rand = new Random();
	public paintCloud(int max, Map<String,Integer> w) {
		setBackground(Color.WHITE);	
		wordList = new ArrayList<rectCloud>();
		double count = 0,avg = 0; 
		for(Map.Entry<String,Integer> k : w.entrySet()) {
			wordList.add(new rectCloud(k.getKey(),k.getValue()));
		}
		SCALE = .3;
		
		System.out.println(wordList);
	}
	public Color getColor(int num) {
		Color red = new Color(156, 34, 93);
		Color pink = new Color(255, 56, 152);
		Color white = new Color(255, 113, 181);
		if (num == 1) return red;
		if (num == 2) return pink;
		else return white;
	}
	public void paint(Graphics w) {
		ArrayList<rectCloud> drawnWords = new ArrayList<rectCloud>();
		int count=0;
		for(rectCloud word : wordList) {
			w.setFont(new Font(Font.SANS_SERIF, Font.BOLD, (int)(word.weight/SCALE)));
			w.setColor(getColor(rand.nextInt(4)));
			FontMetrics font = w.getFontMetrics();
			
			Rectangle bounds = FindBounds((Graphics2D) w, word.word, 0,0);
			
			int height = font.getHeight();
			int width = font.stringWidth(word.word);

			if(height<=0) { height = 1; } //min height
			if(width<=0) { width = 1; } //min width

			int finalX = 0, finalY = 0;
			double LargeNum = 1e8;
			rectCloud lastRect= new rectCloud();
			for(int i = 0; i < TagCloud.WIDTH; i+=5) {
				for(int j = 0; j < TagCloud.HEIGHT; j+=5) {
					rectCloud rectVal = new rectCloud(word.word,word.weight);
					rectVal.setDimensions(i, j, width, height);
			        
					boolean intersects = true;
					for(Rectangle item : drawnWords) {
						if(rectVal.intersects(item)) {
							intersects = false;
							break;
						}
					}
					if(!intersects) continue;
					
					double midRectXVal = rectVal.getCenterX();
					double midRectYVal = rectVal.getCenterY();
					double num = FindDistance(centerX,midRectXVal,centerY,midRectYVal);
					
					if(num < LargeNum) {
						LargeNum = num;
						lastRect = rectVal;
						finalX = i;
						finalY = j;
					}
				}
			}
			drawnWords.add(lastRect);
				
			int placeY = finalY + height;
			
			//draw the border rectangles for each word
			//w.drawRect(end.x, end.y, end.width, end.height);
			w.drawString(word.word, finalX+(int)(Math.sqrt(width)/3), placeY - (height - bounds.height)/2);
		
			count++;
			if(count>80) {
				break;
			}
		}
	}
	public Rectangle FindBounds(Graphics2D graphics, String s, int x, int y) {
		FontRenderContext render = graphics.getFontRenderContext();
        GlyphVector vector = graphics.getFont().createGlyphVector(render, s);
        return vector.getPixelBounds(null, x, y);
	}
	public double FindDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}
	public class rectCloud extends Rectangle {
		public String word;
		public int weight;
		public rectCloud() {}
		public rectCloud(String word, int weight) {
			this.word = word;
			this.weight = weight;
		}
		public void changeX(int n) {
			this.x += n;
		}
		public void changeY(int n) {
			this.y += n;
		}
		public void setDimensions(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			this.width = w;
			this.height = h;
		}
		public void setHeight(int n) {
			this.height = n;
		}
		public void setWidth(int n) {
			this.width = n;
		}
		public String toString() {
			return word + ":" + weight;
		}
	}

}
