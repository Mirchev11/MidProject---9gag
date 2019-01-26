package NineGagProject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.Validator;

import NineGagProject.Settings.Countries;
import NineGagProject.Settings.Genders;
import NineGagProject.Settings.Statuses;

public class User {
	
	public enum Genders {
		MALE, FEMALE, UNSPECIFIED;
	}
	private String fullName;
	private String password;
	private String email;
	private LocalDateTime userCreationTime;
	private boolean isLoggedIn;
	
	private Set<Post> commentedPosts;
	private Set<Post> posts;
	private Set<Post> upvotes;
	private Settings settings;
	
	

	public User(String names,String pass,String email) throws InvalidDataException {
		this.settings = new Settings(this);

		if(Helper.isNameValid(names)) { 
			this.fullName = names;
		} else {
				throw new InvalidDataException("Unable to create user!");
		}

		
		if(Helper.passwordValidator.isPasswordStrong(pass)) {
			this.password = pass;
			}else {
				throw new InvalidDataException("Unable to create user!");
			}
			

	
		Helper.EmailValidator validator = new Helper.EmailValidator();
		
		if(validator.validate(email) || email == null) { // check if there already is such email in the database
			this.email = email;
		} else {
			throw new InvalidDataException("Unable to create user!");
		}
	
		this.settings.setUserName(Helper.userNameMaker(this.email));
		this.commentedPosts = new TreeSet<Post>((com1,com2)-> com1.getPostDate().compareTo(com2.getPostDate()));
		this.posts = new TreeSet<Post>((pos1,pos2) -> pos1.getPostDate().compareTo(pos2.getPostDate()));
		this.upvotes = new TreeSet<Post>((pos1,pos2) -> pos1.getPostDate().compareTo(pos2.getPostDate()));
		
		this.isLoggedIn = true;
		this.userCreationTime = LocalDateTime.now();
	
		NineGag.giveNineGag().addUserToSite(this);
		this.printUserInformation();
	}
	
	//TODO just for testing; delete it afterwards
		void printUserInformation() {
			System.out.println("---------------- Start of Account Information ----------------");
			System.out.println("Full name: " + this.fullName);
			System.out.println("Password: " + this.password);
			System.out.println("Email: " + this.email);
			System.out.println("User name: " + settings.getUserName());
			System.out.println("Date of creation: " + this.userCreationTime);
			System.out.println("---------------- End of Account Information ----------------");
			System.out.println();
			
		}

		public void createAPost(String photo,String description) throws NotLoggedInException {
			Post newPost = new Post(this,photo,description);
			 this.posts.add(newPost);
			 NineGag.giveNineGag().addMeme(newPost);
		}
		
		public void listAllPosts() { //Lista vsichki postove za potrebitelq
			System.out.println("Posts");
			for(Post p : this.posts) {
				p.showPost();
			}
		}
		
		public void listAllCommentedPosts() {
			System.out.println("Commented");
			for(Post p : this.commentedPosts) {
				p.showPost();
			}
		}
		
		public void listAllPostIHaveVotedUp() {
			System.out.println("Upvotes");
			for(Post p : this.upvotes) {
				p.showPost();
			}
		}
		
		public void writeAComment(Post p,String comment) {
			p.addComment(comment);
			this.commentedPosts.add(p);
			
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
		this.email = email;
	}
	
	



}
