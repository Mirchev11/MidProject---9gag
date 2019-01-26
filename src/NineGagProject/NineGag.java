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

public class NineGag { // reshish da e singleton, zaradi GUI i frontend-a

	private static NineGag singleton;
	private Map<Integer, String> tags; // tags - hashcode na imeto na taga, string - taga;
	private Map<String, User> users; // String - mail, User -user
	private Set<Post> posts;
	// Map<String, Section> sections = new TreeMap<String,Section>(); //String -
	// name of section, Secion - section
	private Set<Post> hotPosts;
	private Set<Post> fresh;
	private Set<Post> trending;

	private NineGag() {
		this.tags = new HashMap<Integer, String>();
		this.users = new HashMap<String, User>();
		this.fresh = new TreeSet<Post>((post1, post2) -> post1.getPostDate().compareTo(post2.getPostDate()));
		this.posts = new TreeSet<Post>((post1, post2) -> post1.getPostDate().compareTo(post2.getPostDate()));
		this.hotPosts = new TreeSet<Post>((post1, post2) -> post1.getPoints() - post2.getPoints());
		this.trending = new TreeSet<Post>((post1, post2) -> post1.getPoints() - post2.getPoints());
	}

	public static NineGag giveNineGag() {
		if (NineGag.singleton == null) {
			NineGag sigi = new NineGag();
			singleton = sigi;
			return sigi;
		} else {
			return singleton;
		}
	}

		

	// User methods - add,check, etc:

	void printAllUsers() { // print for check purpose
		for (Map.Entry<String, User> en : users.entrySet()) {
			User us = en.getValue();
			System.out.println("areee");
			us.printUserInformation();
		}
	}

	void addUserToSite(User user) {
		if (users.containsKey(user.getEmail())) {
			System.out.println("User with this email already exists");
			return;
		}
		users.put(user.getEmail(), user);
	}

	boolean checkIfUserExists(String email) { // email check
		if (users.containsKey(email)) {
			return true;
		}
		return false;
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
		for (Post p : this.posts) {   //po-dobre da stane s iterator, da obhojda postovete ot poslednite 2 chasa i tiq s nad 10 da gi buta v hot
			if (p.getPoints() > 10) {
				long hours = Duration.between(p.getPostDate(), LocalTime.now()).toHours();
				if (hours >= 0 && hours <= 2) {
						this.hotPosts.add(p);
				}
			}
		}
	}
	
	

	boolean checkIfTagExists(String tag) {
		if (tags.containsKey(tag.hashCode())) {
			return true;
		}
		return false;
	}

}
