package NineGagProject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Post {

	//which are mandatory
	private User user;
	private String photo;
	private String description;
	private boolean isSensitive;
	private LocalDateTime postDate;
	//section
	
	
	private Set<String> tags;
	private List<Comment> comments;
	
	private Post(User user, String photo, String description, boolean isSensitive) throws NotLoggedInException{
		if(user.isLoggedIn()) {
			this.user = user;
			this.photo = photo;
			this.description = description;
			this.isSensitive = isSensitive;
			this.postDate = LocalDateTime.now();
		} else {
			throw new NotLoggedInException("Not logged in user!");
		}
	}
	
	

	protected LocalDateTime getPostDate() {
		return postDate;
	}


}
