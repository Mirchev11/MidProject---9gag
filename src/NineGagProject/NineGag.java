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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class NineGag {

	private static final int MAX_NUMBER_OF_RANDOM_TAGS = 8;

	// TODO array of sections ??? maybe there is a better way to store them

	private static NineGag singleton;

	// TODO do we need a map for all tags??

	private Set<String> allTags;
	private UserStorage usersStorage;
	private PostStorage postsStorage;

	private NineGag() {
		this.allTags = new HashSet<String>();
		this.usersStorage = UserStorage.giveUserStorage();
		this.postsStorage = PostStorage.givePostStorage();
	}

	public static NineGag giveNineGag() {
		if (NineGag.singleton == null) {
			NineGag.singleton = new NineGag();
		}
		return singleton;
	}

	public UserStorage getUserStorage() {
		return this.usersStorage;
	}

	public PostStorage getPostStorage() {
		return this.postsStorage;
	}

	void putInAllTags(Post p) {
		this.allTags.addAll(p.getAllTags());
	}

	void showAllTags() {
		for (String tag : allTags) {
			System.out.print(tag + " ");
		}
	}

	// public void showAllSections() {
	// int length = sections.length;
	// for(int index = 0 ; index < length; index++) {
	// System.out.println(sections[index]);
	// }
	// }

	void showSomeRandomTagsToChooseFrom() {
		List<String> allTagstoGetRandom = new ArrayList<String>();
		allTagstoGetRandom.addAll(allTags);
		System.out.println(allTagstoGetRandom);
		Set<String> uniqueRandomTags = new HashSet<String>();

		int randomNumber = (allTagstoGetRandom.size() < MAX_NUMBER_OF_RANDOM_TAGS)
				? (int) (allTagstoGetRandom.size() * Math.random())
				: new Random().nextInt(MAX_NUMBER_OF_RANDOM_TAGS) + 1;

		System.out.println("The random tags are: ");
		while (uniqueRandomTags.size() < randomNumber) {
			int randomIndex = (int) (allTagstoGetRandom.size() * Math.random());
			uniqueRandomTags.add((allTagstoGetRandom.get(randomIndex)));
		}
		System.out.println(uniqueRandomTags);
	}

}
