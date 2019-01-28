package NineGagProject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Post {

	// which are mandatory
	private User user;
	private String photo;
	private String description;
	private boolean isSensitive;
	private LocalDateTime postDate;
	private int points;
	// section

	private Set<String> tags;
	private List<Comment> comments;

	public Post(User user, String photo, String description) throws NotLoggedInException {

		if (user.isLoggedIn()) {
			this.postDate = LocalDateTime.now();

			NineGag site = NineGag.giveNineGag();
			site.addMeme(this);

			this.user = user;
			if (Helper.isStringValid(photo)) {
				this.photo = photo;
			}
			if (Helper.isStringValid(description)) {
				this.description = description;
			}
			this.comments = new ArrayList<Comment>();
			this.tags = new TreeSet<String>();
		} else {
			throw new NotLoggedInException("Not logged in user!");
		}

	}

	public Post(User user, String photo, String description, boolean isSensitive) throws NotLoggedInException {
		this(user, photo, description);
		this.isSensitive = isSensitive;
	}

	public void addComment(String content) {
		if (content != null && content.trim().length() > 0) {
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
		if (this.points >= 0) {
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
		for (Comment c : this.comments) {
			c.printComment();// da izvadq metod, koito mi printi komentara.
		}
	}

	public void addTagsToPost(String... tags) {
		for (String tag : tags) {
			if (Helper.isStringValid(tag)) {
				this.tags.add(tag);
			}
		}
	}
	
	public boolean isPostTaggedWith(String tag) {
		if(Helper.isStringValid(tag)) {
			for(String t : this.tags) {
				if(t.contains(tag)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean doesDescriptionContainsSearch(String search) {
		if(Helper.isStringValid(search)) {
			if(this.description.contains(search)) {
				return true;
			}
		}
		return false;
	}

	protected LocalDateTime getPostDate() {
		return postDate;
	}

}
