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
	
	
	public Post(User user, String photo, String description) throws NotLoggedInException{
		if(user.isLoggedIn()) {
			this.postDate = LocalDateTime.now();
			this.user = user;
			if(Helper.isStringValid(photo)) {
				this.photo = photo;
			}
			if(Helper.isStringValid(description)) {
				this.description = description;
			}
		} else {
			throw new NotLoggedInException("Not logged in user!");
		}
			
	}
	
	public  Post(User user, String photo, String description, boolean isSensitive) throws NotLoggedInException{
			this(user, photo, description);
			this.isSensitive = isSensitive;
	}
	
	public void showPostInformation() {
		//test
	}

	protected LocalDateTime getPostDate() {
		return postDate;
	}


}
