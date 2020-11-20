import java.net.URL;
import java.net.URLConnection;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.net.MalformedURLException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TagCloud extends JFrame {
	static String s;
	static mapCloud sitewebsiteData;
	static graphicCloud graphic;
	static final int WIDTH = 800, HEIGHT = 600;
	
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
		/*
		String url = "https://www.genshin.cc/";
		urlCloud scr = new urlCloud(url); //we need a file/class that gets the data from the website
		//urlCloud.run();
		String s = scr.getUrl();//method in URL (method name might be different)
		System.out.println(s);
		sitewebsiteData = new mapCloud(s);//the data from the website
		//map needs run()?? not printing the map
		System.out.println(sitewebsiteData.getMap());
		*/
		//graphic = new graphicCloud(sitewebsiteData.getMap());
		Map<String, Integer> test = new TreeMap<String, Integer>();
		test.put("Test1",10);
		test.put("Test2",5);
		test.put("Test3",20);
		test.put("Test4",40);
		graphic = new graphicCloud(test);//using the graphics (need getmap class in mapcloud)
		new TagCloud();
	}
}