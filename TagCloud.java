import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TagCloud extends JFrame {
	static String s;
	static websiteData sitewebsiteData;
	static graphicCloud graphic;
	static final int WIDTH = 1200, HEIGHT = 800;
	
	public TagCloud(){
		super("TagCloud");
		
		setSize(WIDTH,HEIGHT);
		getContentPane().add(graphic);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//used for graphics
		BufferedImage image = new BufferedImage ( graphic.getWidth (), graphic.getHeight (), BufferedImage.TYPE_INT_ARGB );
        Graphics2D graphics2D = image.createGraphics ();
        graphic.paintAll ( graphics2D );
        graphics2D.graphicose ();

        try {
            ImageIO.write ( image, "png", new File("image.png"));
        }
        catch ( IOException e ) {
            e.printStackTrace ();
        }

		
		System.out.println("size: " + getContentPane().getSize().toString());
		System.out.println("height: " + getContentPane().getHeight());
		
	}
	
	public static void main(String[] args) throws Exception {
		String url = "https://www.genshin.cc/";
		GetURL scr = new GetURL(url); //we need a file/class that gets the data from the website
		String s = scr.getWebsitewebsiteData();
		System.out.println(s);
		sitewebsiteData = new websiteData(s);	//the data from the website
		graphic = new Display(sitewebsiteData.getMax(),sitewebsiteData.getCloud()); //using the graphics
		
		new TagCloud();
	}
}
