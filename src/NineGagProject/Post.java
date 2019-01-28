package NineGagProject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Post {

	//which are mandatory
	private User user;
	private String photo;
	private String description;
	private boolean isSensitive;
	private LocalDateTime postDate;
	private int points;
	//section
	
	
	private Set<String> tags;
	private List<Comment> comments;
	

	
	public Post(User user, String photo, String description) throws NotLoggedInException{

		if(user.isLoggedIn()) {
			this.postDate = LocalDateTime.now();

			NineGag site = NineGag.giveNineGag();
			site.addMeme(this);

			this.user = user;
			if(Helper.isStringValid(photo)) {
				this.photo = photo;
			}
			if(Helper.isStringValid(description)) {
				this.description = description;
			}
			this.comments = new ArrayList<Comment>();
		} else {
			throw new NotLoggedInException("Not logged in user!");
		}
			
	}
	
	public Post(User user, String photo, String description, boolean isSensitive) throws NotLoggedInException{
		this(user, photo, description);
		this.isSensitive = isSensitive;
	}
	
	public void addComment(String content) {
		if(content != null && content.trim().length() > 0) {
			try {
				this.comments.add(new Comment(content));
			} catch (InvalidDataException e) {
				System.out.println("Invalid content for comment!");
			}
		} 
	}

	void increasePoints() {
		this.points++;
	}
	
	void decreasePoints() {
		if(this.points >= 0) {
		this.points--;
		}
	}

	protected int getPoints() {
		return points;
	}


	public void showPost() {
		System.out.println("-----------------------------------");
		System.out.println("-----------------------------------");
		System.out.println("Descripion: \n" + this.description);
		System.out.println("----------------------------");
		System.out.println(this.photo);
		System.out.println("----------------------------");
		System.out.println("Points: " + this.points);
		System.out.println("----------------------------");
		System.out.println("Uploaded on: " + this.postDate);
		System.out.println("-----------------------------------");
		System.out.println("-----------------------------------");
	}
	
	
	public void listAllCommentsForAPost() {
		for(Comment c : this.comments) {
			c.printComment();//da izvadq metod, koito mi printi komentara.
		}
	}
	



	protected LocalDateTime getPostDate() {
		return postDate;
	}


}
