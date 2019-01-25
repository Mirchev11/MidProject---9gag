package NineGagProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class NineGag {
	
	Map<Integer,String> tags = new HashMap<Integer,String>();	//tags - hashcode na imeto na taga, string - taga;
	Map<String, User> users = new HashMap<String, User>(); //String - mail, User -user
	Set<Post> post = new TreeSet<Post>((post1,post2) )
//	Map<String, Section> sections = new TreeMap<String,Section>(); //String - name of section, Secion - section
//	Set<Post> hotPosts = new TreeSet<Post>((post1,post2) -> post1.getPoints() - post2.getPoints()); 
	Set<Post> fresh = new TreeSet<Post>((post1,post2) -> post1.getPostDate().compareTo(post2.getPostDate()));
//	Set<Post> trending = new TreeSet<Post>((post1,post2) -> post1.getPoints() - post2.getPoints());
	
		
	boolean checkIfTagExists(String tag) {
		if(tags.containsKey(tag.hashCode())) {
			return true;
		}
		return false;
	}
	
	
	
	

}
