package NineGagProject;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class NineGag { 
private static final int MAX_NUMBER_OF_RANDOM_TAGS = 8;
private static final int MAX_HOURS_FOR_POSTS_IN_HOT = 2;
private static final int MAX_HOURS_FOR_POSTS_IN_FRESH = 2;
private static final int MAX_HOURS_FOR_POSTS_IN_TRENDING = 2;
private static final int POINTS_FOR_HOT_POSTS = 10;
private static final int UPVOTES_FOR_TRENDING = 10;

// reshish da e singleton, zaradi GUI i frontend-a

	private static volatile NineGag singleton;
	private Map<Integer, String> tags; // tags - hashcode na imeto na taga, string - taga; 
	//TODO do we need a map for all tags??
	private Set<String> allTags;
	//TODO maybe map < string, list<post>>?
	
	final ConcurrentMap<String, User> users; // String - mail, User -user
	
	private Set<Post> posts;
	// Map<String, Section> sections = new TreeMap<String,Section>(); //String -
	// name of section, Secion - section
	private Set<Post> hotPosts; // posts with points over given constant and are uploaded in the last 2 hours
	private Set<Post> fresh; // posts that are uploaded in the last 2 hours
	private Set<Post> trending; //  posts that are most upvoted in the past few hours??

	private NineGag() {
		this.tags = new HashMap<Integer, String>();
		this.allTags = new HashSet<String>();
		this.users = new ConcurrentHashMap<String, User>();
		this.fresh = new TreeSet<Post>((post1, post2) -> post1.getPostDate().compareTo(post2.getPostDate()));
		this.posts = new TreeSet<Post>((post1, post2) -> post1.getPostDate().compareTo(post2.getPostDate()));
		this.hotPosts = new TreeSet<Post>((post1, post2) -> post1.getPoints() - post2.getPoints());
		this.trending = new TreeSet<Post>((post1, post2) -> post1.getPoints() - post2.getPoints());
	}

	synchronized public static NineGag giveNineGag() {
		if (NineGag.singleton == null) {
			synchronized (NineGag.class) {
				if (NineGag.singleton == null) {

					singleton = new NineGag();

				}
			}
		}
		return singleton;
	}

	// User methods - add,check, etc:

	void printAllUsers() { // print for check purpose
		for (Map.Entry<String, User> en : users.entrySet()) {
			User us = en.getValue();
			System.out.println("areee");
			us.printUserInformation();
		}
	}

	synchronized void addUserToSite(User user) {
		synchronized (this.users) {
			if (users.containsKey(user.getEmail())) {
				System.out.println("User with this email already exists");
				return;
			}
			users.put(user.getEmail(), user);
		}
	}

	boolean checkIfUserExists(String email) { // email check
		synchronized (this.users) {
			if (users.containsKey(email)) {
				return true;
			}
			return false;
		}
	}

	boolean checkIfPasswordIsCorrect(String email, String pass) { // pass check
		if (this.checkIfUserExists(email)) {
			User u = users.get(email);
			if (u.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}

	// posts methods and distributing
	void addMeme(Post newPost) {
		if (newPost != null) {
			this.posts.add(newPost);
		}
	}

	void putInHot() {
		for (Iterator<Post> it = posts.iterator(); it.hasNext();) {
			Post p = it.next();
			if (p.getPoints() > POINTS_FOR_HOT_POSTS) {
				long hours = Duration.between(p.getPostDate(), LocalTime.now()).toHours();
				if (hours >= 0 && hours <= MAX_HOURS_FOR_POSTS_IN_HOT) {
					this.hotPosts.add(p);
				}
			}
		}
	}
	
	void showHotPosts() {
		System.out.println("The hot posts are: ");
		for(Post p : hotPosts) {
			System.out.println(p);
		}
	}
	
	void putInFresh() {
		for (Iterator<Post> it = posts.iterator(); it.hasNext();) { 
			Post p = it.next();
			long hours = Duration.between(p.getPostDate(), LocalTime.now()).toHours();
			if (hours >= 0 && hours <= MAX_HOURS_FOR_POSTS_IN_FRESH) {
				this.fresh.add(p);
			}
		}
	}
	
	void showFreshPosts() {
		System.out.println("The fresh posts are: ");
		for(Post p : fresh) {
			System.out.println(p);
		}
	}
	
	void putInTrending() {
		//TODO
		
//		for (Iterator<Post> it = posts.iterator(); it.hasNext();) { 
//			Post p = it.next();
//			long hours = Duration.between(p.getPostDate(), LocalTime.now()).toHours();
//			if (hours >= 0 && hours <= MAX_HOURS_FOR_POSTS_IN_TRENDING) {
//				this.trending.add(p);
//			}
//		}
	}
	
	void putAllTags() {
		for (Iterator<Post> it = posts.iterator(); it.hasNext();) { 
			Post p = it.next();
			allTags.addAll(p.getAllTags());
		}
	}
	void showAllTags() {
		for(String tag : allTags) {
			System.out.println(tag);
		}
	}

	//TODO change return type
	void showSomeRandomTagsToChooseFrom() {
		List<String> allTagstoGetRandom = new ArrayList<String>();
		allTagstoGetRandom.addAll(allTags);
		System.out.println(allTagstoGetRandom);
		Set<String> uniqueRandomTags = new HashSet<String>();
		
		int randomNumber = (allTagstoGetRandom.size() < MAX_NUMBER_OF_RANDOM_TAGS) ? (int) (allTagstoGetRandom.size() * Math.random()) : new Random().nextInt(MAX_NUMBER_OF_RANDOM_TAGS) + 1;
		
		System.out.println("The random tags are: ");
		while(uniqueRandomTags.size() < randomNumber) {
			int randomIndex = (int) (allTagstoGetRandom.size()*Math.random());
			uniqueRandomTags.add((allTagstoGetRandom.get(randomIndex)));
		}
		System.out.println(uniqueRandomTags);
	}

	public List<Post> giveSearchedPosts(String search) {

		List<Post> resultsFromSearch = new ArrayList<Post>();

		for (Post p : this.posts) {
			if (p.doesDescriptionContainsSearch(search) || p.isPostTaggedWith(search)) {
				resultsFromSearch.add(p);
			}
		}
		return resultsFromSearch;
	}

}
