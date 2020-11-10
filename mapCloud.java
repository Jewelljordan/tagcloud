import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class mapCloud extends tagCloud
{
static Map<String, Integer> cloud=new HashMap<String,Integer>();
static int first=0; //starting index of the current string you are on
static int last=0; //ending index of the current string you are on
static String current="";


	public static void main(String[] args) throws Exception
	{
		tagCloud.run();
		String url=tagCloud.getUrl();
		System.out.println(url);
		while(url.contains("<title>") && url.contains("</title>"))
		{
			first=url.lastIndexOf("<title>"); 
			last=url.lastIndexOf("</title>"); 
			current=url.substring(first+7,last);
			String[] title=current.split(" ");
			for(String s:title)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(cloud.containsKey(s))
					cloud.put(s,cloud.get(s)+10);
				if(!cloud.containsKey(s))
					cloud.put(s, 10);	
			}
			url=url.replaceFirst("<title>.*</title>"," ");  //this removes the title from the html (it works)
			//System.out.println(url);
			//System.out.println(cloud);			
		}
	
		while(url.contains("<h1>") && url.contains("</h1>"))
		{
			first=url.lastIndexOf("<h1>"); 
			last=url.lastIndexOf("</h1>"); 
			current=url.substring(first+4,last);
			String[] title=current.split(" ");
			for(String s:title)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(cloud.containsKey(s))
					cloud.put(s,cloud.get(s)+10);
				if(!cloud.containsKey(s))
					cloud.put(s, 10);	
			}
			url=url.replaceFirst("<title>.*</title>"," ");
		}
	}
}




/*
<h1> word </h1> worth 10
<h2> word </h2> worth 8
<h3> word </h3> worth 6
<h4> word </h4> worth 4
<h5> word </h5> worth 2
<h6> word </h6> worth 1
<p> word </p> worth 1
<title> word </title> worth 10
<a href = "word"> word </a> worth 5
<ul>
 <li> word </li> worth 1
 <li> word </li> worth 1
</ul>
*/
