import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class mapCloud extends urlCloud
{
static Map<String, Integer> cloud=new HashMap<String,Integer>();
static int first=0; //starting index of the current string you are on
static int last=0; //ending index of the current string you are on
static String current="";


	public static void runs() throws Exception //public static void main(String[] args) throws Exception
	{
		urlCloud.run();
		String url=urlCloud.getUrl();
		//System.out.println(url);
		url=url.replaceAll("[\n\r]"," ");
		//System.out.println(url);
		
		
		while(url.contains("<title>") && url.contains("</title>"))
		{
			first=url.lastIndexOf("<title>"); 
			last=url.lastIndexOf("</title>"); 
			current=url.substring(first+7,last);
			String[] title=current.split(" ");
			for(String s:title)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(s.length()>1 && (s.substring(s.length()-1).equals(".") || s.substring(s.length()-1).equals(","))) {
				if(cloud.containsKey(s.substring(0,s.length()-1)))
					cloud.put(s,cloud.get(s.substring(0,s.length()-1))+10);
				if(!cloud.containsKey(s.substring(0,s.length()-1)))
					cloud.put(s.substring(0,s.length()-1), 10);	}
				else
				{
					if(cloud.containsKey(s))
						cloud.put(s,cloud.get(s)+10);
					if(!cloud.containsKey(s))
						cloud.put(s, 10);
				}
			}
			url=url.replaceFirst("<title>.*</title>"," ");  //this removes the title from the html (it works)
			//System.out.println(url);
			//System.out.println(cloud);			
		}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		while(url.contains("<h1>") && url.contains("</h1>"))
		{
			first=url.lastIndexOf("<h1>"); 
			last=url.lastIndexOf("</h1>"); 
			current=url.substring(first+4,last);
			String[] h1=current.split(" ");
			for(String s:h1)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(s.length()>1 && (s.substring(s.length()-1).equals(".") || s.substring(s.length()-1).equals(","))) {
					if(cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s,cloud.get(s.substring(0,s.length()-1))+10);
					if(!cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s.substring(0,s.length()-1), 10);	}
					else
					{
						if(cloud.containsKey(s))
							cloud.put(s,cloud.get(s)+10);
						if(!cloud.containsKey(s))
							cloud.put(s, 10);
					}	
			}
			url=url.replaceFirst("<h1>.*</h1>"," ");
		}
		while(url.contains("<h2>") && url.contains("</h2>"))
		{
			first=url.lastIndexOf("<h2>"); 
			last=url.lastIndexOf("</h2>"); 
			current=url.substring(first+4,last);
			String[] h2=current.split(" ");
			for(String s:h2)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(s.length()>1 && (s.substring(s.length()-1).equals(".") || s.substring(s.length()-1).equals(","))) {
					if(cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s,cloud.get(s.substring(0,s.length()-1))+8);
					if(!cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s.substring(0,s.length()-1), 8);	}
					else
					{
						if(cloud.containsKey(s))
							cloud.put(s,cloud.get(s)+8);
						if(!cloud.containsKey(s))
							cloud.put(s, 8);
					}	
			}
			url=url.replaceFirst("<h2>.*</h2>"," ");
		}
		while(url.contains("<h3>") && url.contains("</h3>"))
		{
			first=url.lastIndexOf("<h3>"); 
			last=url.lastIndexOf("</h3>"); 
			current=url.substring(first+4,last);
			String[] h3=current.split(" ");
			for(String s:h3)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(s.length()>1 && (s.substring(s.length()-1).equals(".") || s.substring(s.length()-1).equals(","))) {
					if(cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s,cloud.get(s.substring(0,s.length()-1))+6);
					if(!cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s.substring(0,s.length()-1), 6);	}
					else
					{
						if(cloud.containsKey(s))
							cloud.put(s,cloud.get(s)+6);
						if(!cloud.containsKey(s))
							cloud.put(s, 6);
					}	
			}
			url=url.replaceFirst("<h3>.*</h3>"," ");
		}
		while(url.contains("<h4>") && url.contains("</h4>"))
		{
			first=url.lastIndexOf("<h4>"); 
			last=url.lastIndexOf("</h4>"); 
			current=url.substring(first+4,last);
			String[] h4=current.split(" ");
			for(String s:h4)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(s.length()>1 && (s.substring(s.length()-1).equals(".") || s.substring(s.length()-1).equals(","))) {
					if(cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s,cloud.get(s.substring(0,s.length()-1))+4);
					if(!cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s.substring(0,s.length()-1), 4);	}
					else
					{
						if(cloud.containsKey(s))
							cloud.put(s,cloud.get(s)+4);
						if(!cloud.containsKey(s))
							cloud.put(s, 4);
					}	
			}
			url=url.replaceFirst("<h4>.*</h4>"," ");
		}
		while(url.contains("<h5>") && url.contains("</h5>"))
		{
			first=url.lastIndexOf("<h5>"); 
			last=url.lastIndexOf("</h5>"); 
			current=url.substring(first+4,last);
			String[] h5=current.split(" ");
			for(String s:h5)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(s.length()>1 && (s.substring(s.length()-1).equals(".") || s.substring(s.length()-1).equals(","))) {
					if(cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s,cloud.get(s.substring(0,s.length()-1))+2);
					if(!cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s.substring(0,s.length()-1), 2);	}
					else
					{
						if(cloud.containsKey(s))
							cloud.put(s,cloud.get(s)+2);
						if(!cloud.containsKey(s))
							cloud.put(s, 2);
					}	
			}
			url=url.replaceFirst("<h5>.*</h5>"," ");
		}
		while(url.contains("<h6>") && url.contains("</h6>"))
		{
			first=url.lastIndexOf("<h6>"); 
			last=url.lastIndexOf("</h6>"); 
			current=url.substring(first+4,last);
			String[] h6=current.split(" ");
			for(String s:h6)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(s.length()>1 && (s.substring(s.length()-1).equals(".") || s.substring(s.length()-1).equals(","))) {
					if(cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s,cloud.get(s.substring(0,s.length()-1))+1);
					if(!cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s.substring(0,s.length()-1), 1);	}
					else
					{
						if(cloud.containsKey(s))
							cloud.put(s,cloud.get(s)+1);
						if(!cloud.containsKey(s))
							cloud.put(s, 1);
					}	
			}
			url=url.replaceFirst("<h6>.*</h6>"," ");
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		while(url.contains("<a href") && url.contains("</a>"))// for(int x=0; x<2; x++)
		{
			first=url.indexOf("<a "); 
			last=url.indexOf("</a>");
			current=url.substring(first+2,last);
			//System.out.println(current);
			String lastcarrot= current.substring(current.lastIndexOf(">"));
			//System.out.println(lastcarrot);
			if(lastcarrot.length()>1) //cut out the carrot key
			{
				lastcarrot=lastcarrot.substring(1);
			}
			else
			{
				lastcarrot="";
			}
			//System.out.println("A");
			//System.out.println(lastcarrot);
			//System.out.println("A");
			String[] a=lastcarrot.split(" ");
			for(String s:a)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(s.length()>1 && (s.substring(s.length()-1).equals(".") || s.substring(s.length()-1).equals(","))) {
					if(cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s,cloud.get(s.substring(0,s.length()-1))+5);
					if(!cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s.substring(0,s.length()-1), 5);	}
					else
					{
						if(cloud.containsKey(s))
							cloud.put(s,cloud.get(s)+5);
						if(!cloud.containsKey(s))
							cloud.put(s, 5);
					}	
				//System.out.println(place);
			}
			url=url.substring(0,first) + url.substring(last+4);         // 	<a  </a>																						 //[\\<]a\\s.*[\\<][\\/]a[\\>]
			
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		while(url.contains("<ul>") && url.contains("</ul>"))
		{
			first=url.indexOf("<ul>"); 
			last=url.indexOf("</ul>"); 
			current=url.substring(first,last);
			String[] list=current.split("</li>");
			//make sure to remove white space 
			ArrayList<String> bulletlist= new ArrayList<String>();
			for(String str:list)
			{
				bulletlist.add(str);
			}
			for(int x=0; x<bulletlist.size(); x++)
			{
				bulletlist.get(x).replaceAll("<li>", "");
				bulletlist.get(x).replaceAll("\\s", "");
					
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		while(url.contains("<p class") && url.contains("</p>"))
		{
			first=url.indexOf("<p class");
			last=url.indexOf("</p>");
			current=url.substring(first+7,last);
			
			
			while(current.contains("<a href") && current.contains("</a>"))
			{
				int firstone=url.indexOf("<a "); 
				int lastone=url.indexOf("</a>");
				String currentone=url.substring(firstone+2,lastone);
				String lastcarrot= current.substring(currentone.lastIndexOf(">"));
				if(lastcarrot.length()>1) //cut out the carrot key
				{
					lastcarrot=lastcarrot.substring(1);
				}
				else
				{
					lastcarrot="";
				}
				String[] a=lastcarrot.split(" ");
				for(String s:a)   //adds all of the words in title to cloud map with their correct numerical value
				{
					if(s.length()>1 && (s.substring(s.length()-1).equals(".") || s.substring(s.length()-1).equals(","))) {
						if(cloud.containsKey(s.substring(0,s.length()-1)))
							cloud.put(s,cloud.get(s.substring(0,s.length()-1))+5);
						if(!cloud.containsKey(s.substring(0,s.length()-1)))
							cloud.put(s.substring(0,s.length()-1), 5);	}
						else
						{
							if(cloud.containsKey(s))
								cloud.put(s,cloud.get(s)+5);
							if(!cloud.containsKey(s))
								cloud.put(s, 5);
						}	
					//System.out.println(place);
				}
				current=current.substring(0,first) + current.substring(last+4);
			}
			
			
			String lastcarrot=current.substring(current.lastIndexOf(">"));
			if(lastcarrot.length()>1)
			{
				lastcarrot=lastcarrot.substring(1);
			}
			else
			{
				lastcarrot="";
			}
			String[] a=lastcarrot.split(" ");
			for(String s:a)   //adds all of the words in title to cloud map with their correct numerical value
			{
				if(s.length()>1 && (s.substring(s.length()-1).equals(".") || s.substring(s.length()-1).equals(","))) {
					if(cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s,cloud.get(s.substring(0,s.length()-1))+1);
					if(!cloud.containsKey(s.substring(0,s.length()-1)))
						cloud.put(s.substring(0,s.length()-1), 1);	}
					else
					{
						if(cloud.containsKey(s))
							cloud.put(s,cloud.get(s)+1);
						if(!cloud.containsKey(s))
							cloud.put(s, 1);
					}	
				//System.out.println(place);
			}
			url=url.substring(0,first) + url.substring(last+4);
		}
		
		if(cloud.containsKey(""))
			cloud.remove("");
		if(cloud.containsKey(","))
			cloud.remove(",");
		//System.out.println(cloud);
	

	
	}
	public static void main(String[] args) throws Exception
	{
		mapCloud.runs();
	}
	public static Map<String, Integer> getMap()
	{
		return cloud;
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
