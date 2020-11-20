import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.util.Scanner;
import java.net.MalformedURLException;
public class urlCloud
{
	static String s;
	static String imput;	
	public urlCloud(String url) {
			imput = url;
		}
		
	public static void run()throws Exception {
		try {
			//URL myURL = new URL("https://www.allbirds.com/?utm_source=sas_aff&utm_medium=314743&utm_content=923405&sscid=b1k4_ivy4i"); //https://www.unm.edu/~gmartin/535/Sticks.htm //https://news.ycombinator.com/ //https://www.nngroup.com/articles/presenting-bulleted-lists/
			URL myURL = new URL(imput);
			URLConnection site = myURL.openConnection();
		 site.connect();
		 Scanner file = new Scanner( site.getInputStream() );
		 s= file.useDelimiter( "\\Z" ).next() ;
		}
		
		catch (MalformedURLException e) {
		 // new URL() failed
		 // ...
		}
		catch (IOException e) {
		 // openConnection() failed
		 // ...
		}
	}
	 public static String getUrl() {
		 return s;
	 }
	 public static void main(String[] args) throws Exception {
		 urlCloud.run();
	 }
}