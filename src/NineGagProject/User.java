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
	Settings settings;


	public User(String names,String pass,String email) throws InvalidDataException {
		this.settings = new Settings(this);
		
		
		Scanner sc = new Scanner(System.in);
		while (!Helper.isNameValid(names)) { 
			
			System.out.println("Enter valid name:");
			names = sc.nextLine();
			if(names.equalsIgnoreCase("X")) {
				throw new InvalidDataException("Unable to create user!");
			}
			if (!Helper.isNameValid(names)) {
				System.out.println("Invalid name!");
			}
			
			System.out.println(names);
		}

		this.fullName = names;
		System.out.println("Your name was accepted!");
		System.out.println("Your name is " + this.fullName);
		
		
		
		while (!Helper.passwordValidator.isPasswordStrong(pass)) {
			System.out.println("Enter new password 8 or more characters, "
					+ "atleas 1 capital letter,1 small letter and 1 number:");
			pass = sc.next();
			if(pass.equalsIgnoreCase("X")) {
				throw new InvalidDataException("Unable to create user!");
			}
			if (!Helper.passwordValidator.isPasswordStrong(pass)) {
				System.out.println("Weak password!");
			}
		}

		this.password = pass;
		System.out.println("Your password is valid!");
		System.out.println("Your password is: " + this.password);

	
		Helper.EmailValidator validator = new Helper.EmailValidator();
		while (!validator.validate(email) || email == null) { // check if there already is such email in the database
			System.out.println("Enter a valid email!");
			email = sc.next();
			if(email.equalsIgnoreCase("X")) {
				throw new InvalidDataException("Unable to create user!");
			}
			if (!validator.validate(email) || email == null) {
				System.out.println("Bad email entered!");
			}
		}
		this.email = email;
		System.out.println("Your email is accepted");
		System.out.println("Your email is " + this.email);

		settings.setUserName(Helper.userNameMaker(this.email));
		this.commentedPosts = new TreeSet<Post>((com1,com2)-> com1.getPostDate().compareTo(com2.getPostDate()));
		this.posts = new TreeSet<Post>((pos1,pos2) -> pos1.getPostDate().compareTo(pos2.getPostDate()));
		this.upvotes = new TreeSet<Post>((pos1,pos2) -> pos1.getPostDate().compareTo(pos2.getPostDate()));
		
		this.isLoggedIn = true;
		this.userCreationTime = LocalDateTime.now();
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



}
