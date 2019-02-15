package NineGagProject;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//"Awesome", "Basketball", "Car", "Comic", "Cosplay", "Countryballs", 
//"Classical Art Memes", "DIY & Crafts", "Drawing & Illistration", "Fan Art",
//"Food & Drinks", "Football", "Fortnite", "Gaming", "GIF", "Girl", "Girly Things",
//"Guy", "History", "Horror", "Home Design", "K-Pop", "League of Legends", "LEGO",
//"Movie & TV", "Music", "NFK - Not For Kids", "Overwatch", "PC Master Race", "Pic Of The Day",
//"Pokemon", "Politics", "Relationship", "PUBG", "Roast Me", "Savage", "Satisfying",
//"School", "Sci-Tech", "Star Wars", "Superhero", "Surreal Memes",
//Travel","Timely", "Video", "Warhammer", "Wallpaper", "WTF", "Dark Humor", Anime&Manga", "Ask 9GAG",

public class PostStorage {
	private static final int MAX_HOURS_FOR_POSTS_IN_HOT = 2;
	private static final int MAX_HOURS_FOR_POSTS_IN_FRESH = 2;
	private static final int MAX_HOURS_FOR_POSTS_IN_TRENDING = 2;
	private static final int POINTS_FOR_HOT_POSTS = 10;
	private static final int UPVOTES_FOR_TRENDING = 10;
	private static final int MIN_POINTS_FOR_HOT_POST = 10;

	private static PostStorage singleton;

	private Set<Post> posts; // TODO ???

	private Set<Post> hotPosts; // posts with points over given constant and are
								// uploaded in the last 2 hours
	private Set<Post> fresh; // posts that are uploaded in the last 2 hours
	private Set<Post> trending; // posts that are most upvoted in the past few
								// hours??
	private Map<String, Set<Post>> sectionOfPosts; // String section, tree set
													// of posts

	private final String[] sections = { "Funny", "Animals", "Sport", };

	public PostStorage() {
		this.fresh = new TreeSet<Post>((post1, post2) -> post1.getPostDate().compareTo(post2.getPostDate()));
		this.posts = new TreeSet<Post>((post1, post2) -> post1.getPostDate().compareTo(post2.getPostDate()));
		this.hotPosts = new TreeSet<Post>((post1, post2) -> post1.getPoints() - post2.getPoints());
		this.trending = new TreeSet<Post>((post1, post2) -> post1.getPoints() - post2.getPoints());
		this.sectionOfPosts = new HashMap<String, Set<Post>>(); // ???
	}

	public static PostStorage givePostStorage() {
		if (PostStorage.singleton == null) {
			PostStorage.singleton = new PostStorage();
		}
		return singleton;
	}

	// posts methods and distributing
	
		void addMeme(Post newPost) {
		if (newPost != null && this.isValidSection(newPost.getSection())) {
			this.posts.add(newPost);
			if (this.sectionOfPosts.containsKey(newPost.getSection())) {
				Set<Post> newPosts = this.sectionOfPosts.get(newPost.getSection());
				newPosts.add(newPost);
			} else {
				Set<Post> newPosts = new TreeSet<Post>(
						(post1, post2) -> post1.getPostDate().compareTo(post2.getPostDate()));
				newPosts.add(newPost);
				this.sectionOfPosts.put(newPost.getSection(), newPosts);
			}
			NineGag.giveNineGag().putInAllTags(newPost);
	
		} else {
			System.out.println("Given section is invalid");
		}
	}
	
		//	Set<String> getAllTags(){
		//		Set<String> tags = new HashSet<String>();
		//		for (Iterator<Post> it = posts.iterator(); it.hasNext();) {
		//			Post p = it.next();
		//			tags.addAll(p.getAllTags());
		//		}
		//		return tags;
		//	}
	

	public boolean isValidSection(String section) {
		boolean isValid = false;
		if(Helper.isStringValid(section)) {
			int length = this.sections.length;
			for(int index = 0 ; index < length; index++) {
				if(sections[index].equalsIgnoreCase(section)) {
					isValid = true; 
					break;
				}
			}
		}
		return isValid;
	}

	public void showPostsAccordingToSections() {
		for (Map.Entry<String, Set<Post>> entry : sectionOfPosts.entrySet()) {
			System.out.println("Section: " + entry.getKey());
			Set<Post> currPosts = entry.getValue();
			for (Post p : currPosts) {
				System.out.println("Post: " + p);
			}
		}
	}

	void putInHot() {
		for (Iterator<Post> it = posts.iterator(); it.hasNext();) {
			Post p = it.next();
			if (p.getPoints() > POINTS_FOR_HOT_POSTS) {
				long hours = Duration.between(p.getPostDate(), LocalTime.now()).toHours();
				if (hours > MAX_HOURS_FOR_POSTS_IN_HOT) {
					return;
				}
				if (hours >= 0 && p.getPoints() >= MIN_POINTS_FOR_HOT_POST) {
					this.hotPosts.add(p);
				}
			}
		}
	}

	void showHotPosts() {
		System.out.println("The hot posts are: ");
		for (Post p : hotPosts) {
			System.out.println(p);
		}
	}

	void putInFresh() {
		for (Iterator<Post> it = posts.iterator(); it.hasNext();) {
			Post p = it.next();
			long hours = Duration.between(p.getPostDate(), LocalTime.now()).toHours();
			if (hours > MAX_HOURS_FOR_POSTS_IN_FRESH) {
				return;
			}
			if (hours >= 0) {
				this.fresh.add(p);
			}
		}
	}

	void showFreshPosts() {
		System.out.println("The fresh posts are: ");
		for (Post p : fresh) {
			System.out.println(p);
		}
	}

	void putInTrending() {
		// TODO

		// for (Iterator<Post> it = posts.iterator(); it.hasNext();) {
		// Post p = it.next();
		// long hours = Duration.between(p.getPostDate(),
		// LocalTime.now()).toHours();
		// if (hours >= 0 && hours <= MAX_HOURS_FOR_POSTS_IN_TRENDING) {
		// this.trending.add(p);
		// }
		// }
	}

	public List<Post> giveSearchedPosts(String search) {

		List<Post> resultsFromSearch = new ArrayList<Post>();

		for (Post p : this.posts) {
			if (p.doesDescriptionContainsSearch(search) || p.isPostTaggedWith(search)) {
				resultsFromSearch.add(p);
			}
		}
		
		for(Post p : resultsFromSearch){
			p.showPost();
		}
		return resultsFromSearch;
	}

}
