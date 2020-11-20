import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.net.*;
import java.io.*;

public class TagCloud extends JFrame {
	static String s;
	static mapCloud sitewebsiteData;
	static paintCloud graphic;
	static final int WIDTH = 800, HEIGHT = 600;
	
	public TagCloud(){
		super("TagCloud by Jewell, Brooklyn, and Ramya");
		
		setSize(WIDTH,HEIGHT);
		getContentPane().add(graphic);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//used for graphics
		BufferedImage image = new BufferedImage ( graphic.getWidth (), graphic.getHeight (), BufferedImage.TYPE_INT_ARGB );
        Graphics2D graphics2D = image.createGraphics ();
        graphic.paintAll ( graphics2D );
        graphics2D.dispose();

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
		
		String url ="https://www.allbirds.com/?utm_source=sas_aff&utm_medium=314743&utm_content=923405&sscid=b1k4_ivy4i";
		urlCloud scr = new urlCloud(url); //we need a file/class that gets the data from the website
		urlCloud.run();
		String s = scr.getUrl();//method in URL (method name might be different)
		System.out.println(s);
		sitewebsiteData = new mapCloud(s);//the data from the website
		//map needs run()?? not printing the map
		mapCloud.runs();
		System.out.println(sitewebsiteData.getMap());
		graphic = new paintCloud(500,sitewebsiteData.getMap()); //using the graphics (need getmap class in mapcloud)
		new TagCloud();
	}
}
