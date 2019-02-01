package NineGagProject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.Validator;

import NineGagProject.Settings.Countries;
import NineGagProject.Settings.Genders;
import NineGagProject.Settings.Statuses;

public class User {
	Scanner sc = new Scanner(System.in);
	
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
	private Set<String> favouriteSections; 
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
		this.favouriteSections = new LinkedHashSet<String>();
		
		this.isLoggedIn = true;
		this.userCreationTime = LocalDateTime.now();
	
		
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

		public Post createAPost(String photo,String description, String section, boolean isSensitive) throws NotLoggedInException, InvalidSectionException {
			Post newPost = new Post(this,photo,description, section, isSensitive);
			 this.posts.add(newPost);
			 NineGag.giveNineGag().addMeme(newPost);
			 return newPost;
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
		
		public void openProfile() {
			this.listAllPosts();
			System.out.println("-----------");
			this.listAllCommentedPosts();
			System.out.println("-----------");
			this.listAllPostIHaveVotedUp();
		}
		
		
		public void searching (String search) {
			this.printFoundPosts(NineGag.giveNineGag().giveSearchedPosts(search));
			
		}
		
		public void printFoundPosts(List<Post> result) {
			if(result.size() == 0) {
				System.out.println("No posts found!");
				return;
			} 
			
			for(Post p : result) {
				p.showPost();
			}
		}
		
		//TODO change it according to front end
		public void addSectionToFavourites(String... sections ) {
			for(String section : sections) {
				if(section != null && NineGag.isValidSection(section)) {
					this.favouriteSections.add(section);
				} else {
					System.out.println("There is no such section");
				}
			}
		}
		
		public void showMyFavouriteSections() {
			System.out.println("My favourite sections are: ");
			for(String s : favouriteSections) {
				System.out.println(s);
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
		this.email = email;
	}
	
	



}
