package NineGagProject;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Post {
	
	// which are mandatory
	private User user;
	private String photo;
	private String description;
	private boolean isSensitive;
	private LocalDate postDate;
	//?? section
	
	//??? private Set<String> tags; choosing a few random tags to show in homepage
	private List<Comment> comments;
	
	Post(User user, String photo, String description, boolean isSensitive){
		//if user is logged in
		//?? what is a valid photo??
	}

	public LocalDate getPostDate() {
		return postDate;
	}
	
	

}
