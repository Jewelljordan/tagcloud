import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class rectCloud extends Rectangle
{
	private ArrayList<Rectangle> rect;
	public rectCloud() {
		rect = new ArrayList<Rectangle>();
	final int x = 10;
	final int y = 10;
	final int height = 10;
	final int width = 10;
	}
	
	public ArrayList<Rectangle> createRects(Map<String, Integer> in){
		Iterator it = in.iterator();
		while(it.hasNext()) {
			Rectangle a = new Rectangle(x, y, height*(in.getValue/2), width*(in.getValue/2));
			
		}
		return rect;
	}
	
	 
}

// need to create rectangle with the words in them - need font class?, check for overlapping