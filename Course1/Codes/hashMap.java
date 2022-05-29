// HashMap example to count the words 
import java.util.*;
public class Main
{
    //loadWords method will return an arraylist of the words from specified length
    public static List<String> loadWords( String[] words){
        List<String> arrlst = new ArrayList <String>(600);
        for(String word : words){
            
                arrlst.add(word);
            
        }
        return arrlst;
    }
    
	public static void main(String[] args) {
	    String text = "But soft what light through yonder window breaks It is the east and Juliet is the sun Arise fair sun and kill the envious moon Who is already sick and pale with grief";
	    String[] words = text.split(" ");
		List<String> arrlst = new ArrayList<String>();
		arrlst = loadWords(words);
		Map<String,Integer> mymap = new HashMap<String,Integer>();
		for(String word : arrlst){
		    word = word.toLowerCase();
		    if(!mymap.containsKey(word)){
		        mymap.put(word,1);
		    }
		    else{
		        mymap.put(word,mymap.get(word)+1);
		    }
		}
		System.out.println(mymap.toString());
	}
}
