package TagCloud;

import java.awt.Color;
import java.awt.Rectangle;
//@SuppressWarnings("serial")

public class rectCloud extends Rectangle {
	
	private String word;
	private int weight;
	public rectCloud() {}
	public rectCloud(String word, int weight) {
		this.word = word;
		this.weight = weight;
	}
	public String getWord() {
		return word;
	}
	public Integer getWeight() {
		return weight;
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
