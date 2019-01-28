package NineGagProject;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class NineGag { // reshish da e singleton, zaradi GUI i frontend-a

	private static volatile NineGag singleton;
	private Map<Integer, String> tags; // tags - hashcode na imeto na taga, string - taga;
	final ConcurrentMap<String, User> users; // String - mail, User -user
	private Set<Post> posts;
	// Map<String, Section> sections = new TreeMap<String,Section>(); //String -
	// name of section, Secion - section
	private Set<Post> hotPosts;
	private Set<Post> fresh;
	private Set<Post> trending;

	private NineGag() {
		this.tags = new HashMap<Integer, String>();
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
		for (Post p : this.posts) { // po-dobre da stane s iterator, da obhojda postovete ot poslednite 2 chasa i
									// tiq s nad 10 da gi buta v hot
			if (p.getPoints() > 10) {
				long hours = Duration.between(p.getPostDate(), LocalTime.now()).toHours();
				if (hours >= 0 && hours <= 2) {
					this.hotPosts.add(p);
				}
			}
		}
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
