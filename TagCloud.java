import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class tagCloud { //scrapes data
	public static void main(String[] args);
	{
		try {
			URL myURL = new URL ("http://example.com/");
			URLConnection site = myURL.openConnection();
			site.connect();
			
			Scanner in = new Scanner(site.getInputStream());
			System.out.println(in.useDelimiter("\\Z").next());
		}
		catch (MalformedURLException e){
			//new URL() failed
		}
		catch(IOException e) {
			// openConnection() failed
		}
	}
	public static void run(String)
}//switch other to run and this to main
