package NineGagProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.Validator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;


import NineGagProject.Settings.Genders;
import NineGagProject.Settings.Statuses;
import sun.misc.IOUtils;

public class User {
	public enum Genders {
		MALE, FEMALE, UNSPECIFIED;
	}

	@Expose
	private String fullName;
	@Expose
	private String password;
	@Expose
	private String email;
	@Expose
	private LocalDateTime userCreationTime;
	@Expose
	private boolean isLoggedIn;
	@Expose
	private Set<Post> commentedPosts;
	@Expose
	private Set<Post> posts;
	@Expose
	private Set<Post> upvotes;
	@Expose
	private Set<String> favouriteSections;

	@Expose
	private Settings settings;

	public User(String names, String pass, String email) throws InvalidDataException {
		this.settings = new Settings(this);

		if (Helper.isNameValid(names)) {
			this.fullName = names;
		} else {
			throw new InvalidDataException("Unable to create user!");
		}

		if (Helper.passwordValidator.isPasswordStrong(pass)) {
			this.password = pass;
		} else {
			throw new InvalidDataException("Unable to create user!");
		}

		Helper.EmailValidator validator = new Helper.EmailValidator();

		if (validator.validate(email) || email == null) { // check if there
															// already is such
															// email in the
															// database
			this.email = email;
		} else {
			throw new InvalidDataException("Unable to create user!");
		}

		this.settings.setUserName(Helper.userNameMaker(this.email));
		this.commentedPosts = new TreeSet<Post>((com1, com2) -> com1.getPostDate().compareTo(com2.getPostDate()));
		this.posts = new TreeSet<Post>((pos1, pos2) -> pos1.getPostDate().compareTo(pos2.getPostDate()));
		this.upvotes = new TreeSet<Post>((pos1, pos2) -> pos1.getPostDate().compareTo(pos2.getPostDate()));
		this.favouriteSections = new LinkedHashSet<String>();

		this.isLoggedIn = true;
		this.userCreationTime = LocalDateTime.now();

		// this.printUserInformation();
	}

	public void setUserName() {
		this.settings.setUserName(Helper.userNameMaker(this.email));
	}

	// TODO just for testing; delete it afterwards
	void printUserInformation() {
		System.out.println("---------------- Start of Account Information ----------------");
		System.out.println("Full name: " + this.fullName);
		System.out.println("Password: " + this.password);
		System.out.println("Email: " + this.email);
		System.out.println("User name: " + settings.getUserName());
		// System.out.println("Date of creation: " + this.userCreationTime);
		System.out.println("---------------- End of Account Information ----------------");
		System.out.println();

	}

	public Post createAPost(String photo, String description, String section, boolean isSensitive)
			throws NotLoggedInException, InvalidSectionException, InvalidDataException {
		if (Helper.isStringValid(photo) && Helper.isStringValid(description) && Helper.isStringValid(section)) {
			if (PostStorage.givePostStorage().isValidSection(section)) {
				Post newPost = new Post(this, photo, description, section, isSensitive);
				this.posts.add(newPost);
				NineGag.giveNineGag().getPostStorage().addMeme(newPost);
				return newPost;
			} else {
				throw new InvalidSectionException("Invalid section given!");
			}
		} else {
			throw new InvalidDataException("Invalid data given for post!");
		}
	}

	public boolean changePassword(String newPass, String reNewPass) {
		if (newPass.equals(reNewPass)) {
			Helper.passwordValidator passValidator = new Helper.passwordValidator();
			if (passValidator.isPasswordStrong(newPass)) {
				this.password = newPass;
				return true;
			} else {
				System.out.println("New password is weak!");
				return false;
			}
		} else {
			System.out.println("Passwords are not equal!");
			return false;
		}
	}

	public void listAllPosts() {
		System.out.println("Posts: ");
		for (Post p : this.posts) {
			p.showPost();
		}
	}

	public void listAllCommentedPosts() {
		System.out.println("Commented posts: ");
		for (Post p : this.commentedPosts) {
			p.showPost();
		}
	}

	public void listAllPostIHaveVotedUp() {
		System.out.println("Upvotes");
		for (Post p : this.upvotes) {
			p.showPost();
		}
	}

	public void writeAComment(Post p, String comment) {
		if (p != null && Helper.isStringValid(comment)) {
			p.addComment(comment);
			this.commentedPosts.add(p);
		} else {
			System.out.println("It was not possible to write a comment!");
		}

	}

	public void openProfile() {
		this.listAllPosts();
		System.out.println("-----------");
		this.listAllCommentedPosts();
		System.out.println("-----------");
		this.listAllPostIHaveVotedUp();
	}

	public void searching(String search) {
		if (Helper.isStringValid(search)) {
			this.printFoundPosts(NineGag.giveNineGag().getPostStorage().giveSearchedPosts(search));
		} else {
			System.out.println("Inavlid search");
		}

	}

	public void printFoundPosts(List<Post> result) {
		if (result.size() == 0) {
			System.out.println("No posts found!");
			return;
		}

		for (Post p : result) {
			p.showPost();
		}
	}

	// TODO change it according to front end
	public void addSectionToFavourites(String... sections) {
		for (String section : sections) {
			if (section != null && PostStorage.givePostStorage().isValidSection(section)) {
				this.favouriteSections.add(section);
			} else {
				System.out.println("There is no such section");
			}
		}
	}

	public void showMyFavouriteSections() {
		System.out.println("My favourite sections are: ");
		for (String s : favouriteSections) {
			System.out.println(s);
		}

	}

	protected void setFullName(String fullName) {
		if(Helper.isNameValid(fullName)){
		this.fullName = fullName;
		}
	}

	protected String getFullName() {
		return fullName;
	}

	protected String getPassword() {
		return password;
	}

	protected String getEmail() {
		return email;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	protected void setEmail(String email) {
		Helper.EmailValidator validator = new Helper.EmailValidator();

		if (validator.validate(email) || email == null) {
			this.email = email;
		}

	}

	void forgottenPass(String newPass) {
		this.password = newPass;
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", password=" + password + ", email=" + email + ", userCreationTime="
				+ userCreationTime + ", isLoggedIn=" + isLoggedIn + ", upvotes=" + upvotes + ", favouriteSections="
				+ favouriteSections + "]";
	}

	Settings getSettings() {
		return this.settings;
	}

}
