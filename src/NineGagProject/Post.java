package NineGagProject;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Post {
	
	private static final int MAX_HOURS_FOR_COMMENTS_IN_FRESH = 2;
	private static final int POINTS_FOR_HOT_COMMENTS = 5;

	private User user;
	private String photo;
	private String description;
	private boolean isSensitive;
	private LocalDateTime postDate;
	private int points;
	private int upvotes;
	private String section;

	private Set<String> tags;
	private List<Comment> comments;
	private Set<Comment> freshComments;
	private Set<Comment> hotComments;
	
	

	public Post(User user, String photo, String description) throws NotLoggedInException {

		if (user.isLoggedIn()) {
			this.postDate = LocalDateTime.now();

			NineGag site = NineGag.giveNineGag();

			this.user = user;
			if (Helper.isStringValid(photo)) {
				this.photo = photo;
			}
			if (Helper.isStringValid(description)) {
				this.description = description;
			}
			this.comments = new ArrayList<Comment>();
			this.tags = new TreeSet<String>();
			this.freshComments = new TreeSet<Comment>(new Comparator<Comment>() {

				@Override
				public int compare(Comment comm1, Comment comm2) {
					return comm1.getDate().compareTo(comm2.getDate());
				}
			});
			//TODO ???
			this.hotComments = new TreeSet<Comment>(new Comparator<Comment>() {

				@Override
				public int compare(Comment comm1, Comment comm2) {
					return comm1.getPoints() - comm2.getPoints();
				}
				});
		} else {
			throw new NotLoggedInException("Not logged in user!");
		}

	}

	public Post(User user, String photo, String description, String section, boolean isSensitive) throws NotLoggedInException, InvalidSectionException {
		this(user, photo, description);
		if(NineGag.isValidSection(section)) {
			this.section = section;
		} else {
			throw new InvalidSectionException("Invalid section given!");
		}
		
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
	
	void putCommentsInFresh() {
		if(!comments.isEmpty()) {
			for(Iterator<Comment> it = comments.iterator(); it.hasNext();) {
				Comment c = it.next();
				long hours = Duration.between(c.getDate(), LocalTime.now()).toHours();
				if (hours >= 0 && hours <= MAX_HOURS_FOR_COMMENTS_IN_FRESH) {
					this.freshComments.add(c);
				}
			}
		} else {
			System.out.println("There are no comments to put in fresh");
		}
	}
	
	void putCommentsInHot() {
		if(!comments.isEmpty()) {
			for(Iterator<Comment> it = comments.iterator(); it.hasNext();) {
				Comment c = it.next();
				if (c.getPoints() > POINTS_FOR_HOT_COMMENTS) {
					long hours = Duration.between(c.getDate(), LocalTime.now()).toHours();
					if (hours >= 0 && hours <= MAX_HOURS_FOR_COMMENTS_IN_FRESH) {
						this.hotComments.add(c);
					}
				}
			} 
		}else {
			System.out.println("There are no comments to put in hot");
		}
	}

	void increasePoints() {
		this.points++;
		this.upvotes++;
	}

	void decreasePoints() {
		if (this.points >= 0) {
			this.points--;
		}
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
	
	public Set<String> getAllTags() {
		Set<String> allTagsForAPost = new HashSet<String>();
		for(String tag : tags) {
			allTagsForAPost.add(tag);
		}
		return allTagsForAPost;
		
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
	
	public int getUpvotes() {
		return upvotes;
	}
	

	protected int getPoints() {
		return points;
	}
	
	protected LocalDateTime getPostDate() {
		return postDate;
	}

	public String getSection() {
		return section;
	}

	@Override
	public String toString() {
		return "Post [user=" + user + ", photo=" + photo + ", description=" + description + ", isSensitive="
				+ isSensitive + ", postDate=" + postDate + ", points=" + points + ", upvotes=" + upvotes + ", tags="
				+ tags + "]";
	}

	



}
