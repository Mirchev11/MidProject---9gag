package NineGagProject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.Validator;

public class User {
	public enum Countries {

	}

	public enum Statuses {

	}

	public enum Genders {
		MALE, FEMALE, UNSPECIFIED;
	}
	// required fileds - composition
	private String fullName;
	private String password;
	private String email;
	
	private String photo;
	private String userName;
	private LocalDate birthDate;
	private Countries country;
	private String description;
	private Statuses status;
	private Genders gender;
	private boolean sensitiveContent;
	//TODO isLoggedIn boolean
	//TODO date of creating the profile/ formatting
	private LocalDateTime dateOfUserCreation;
	
	private Set<Comment> comments; //TODO ??? Set<Post> myCommentedPosts, not just comments
	private Set<Post> posts; 
	private Set<Post> upvotes;

	public User(String fullName, String password, String email) throws InvalidDataException {
		//TODO endless entering in case of invalid data
		
		if(Helper.isNameValid(fullName)) {
			this.fullName = fullName;
			System.out.println("Your name was accepted!");
			System.out.println("Your name is " + this.fullName);
		} else {
			throw new InvalidDataException("Invalid name entered!");
		}
		
		if(Helper.passwordValidator.isPasswordStrong(password)) {
			this.password = password;
			System.out.println("Your password is valid!");
			System.out.println("Your password is: " + this.password);
		} else {
			throw new InvalidDataException("Weak password!");
		}
		
		Helper.EmailValidator validator = new Helper.EmailValidator();
		if(validator.validate(email)) {
			this.email = email;
			System.out.println("Your email is accepted");
			System.out.println("Your email is " + this.email);
		} else {
			throw new InvalidDataException("Invalid email entered!");
		}
		
		this.userName = Helper.userNameMaker(this.email);
		this.dateOfUserCreation = LocalDateTime.now();
		
		this.comments = new TreeSet<Comment>((com1,com2)-> com1.getDate().compareTo(com2.getDate()));
		this.posts = new TreeSet<Post>((pos1,pos2) -> pos1.getPostDate().compareTo(pos2.getPostDate()));
		this.upvotes = new TreeSet<Post>((pos1,pos2) -> pos1.getPostDate().compareTo(pos2.getPostDate()));
		
		
		
		
		//Scanner sc = new Scanner(System.in);

//		String names = null;
//		while (!Helper.isNameValid(names)) { //TODO ������������ �������� ���� ���� ���������� � ������ ��� � ����� �� �����.
//			System.out.println("Enter valid name:");
//			names = sc.nextLine();
//			if (!Helper.isNameValid(names)) {
//				System.out.println("Invalid name!");
//			}
//			System.out.println(names);
//		}
//
//		this.fullName = names;
//		System.out.println("Your name was accepted!");
//		System.out.println("Your name is " + this.fullName);
		
		
//		String pass = null;
//		while (!Helper.passwordValidator.isPasswordStrong(pass)) {
//			System.out.println("Enter new password 8 or more characters, "
//					+ "atleas 1 capital letter,1 small letter and 1 number:");
//			pass = sc.next();
//			if (!Helper.passwordValidator.isPasswordStrong(pass)) {
//				System.out.println("Weak password!");
//			}
//		}
//
//		this.password = pass;
//		System.out.println("Your password is valid!");
//		System.out.println("Your password is: " + this.password);

//		String email = null;
//		Helper.EmailValidator validator = new Helper.EmailValidator();
//		while (!validator.validate(email) || email == null) {
//			System.out.println("Enter a valid email!");
//			email = sc.next();
//			if (!validator.validate(email) || email == null) {
//				System.out.println("Bad email entered!");
//			}
//		}
//		this.email = email;
//		System.out.println("Your email is accepted");
//		System.out.println("Your email is " + this.email);
//		//TODO �� ����� ����� ������ �� ������ user-a � ����� �� user-� �� ����� ��.
		
//		this.userName = Helper.userNameMaker(this.email);//������ ������ �����.

	}
	
	//TODO just for testing; delete it afterwards
	void printUserInformation() {
		System.out.println("Full name: " + this.fullName);
		System.out.println("Password: " + this.password);
		System.out.println("Email: " + this.email);
		System.out.println("User name: " + this.userName);
		System.out.println("Date of creation: " + this.dateOfUserCreation);
		System.out.println("---------------- End of Account Information ----------------");
		System.out.println();
		
	}

	//TODO should it be static???
//	private static class Settings {
//		//TODO ?? should all these fields be copied maybe there is a better solution
//		private String photo; // TODO maybe a collection(ArrayList?) with default profile pictures and option to choose a random one; also to select your own
//		private String userName; 
//		private LocalDate birthDate; 
//		private Countries country;
//		private String description;
//		private Statuses status;
//		private Genders gender;
//		private boolean sensitiveContent;
//	}
//
	
	protected String getEmail() {
		return this.email;
	}
	
	protected String getFullName() {
		return fullName;
	}


	protected String getPassword() {
		return password;
	}

	
}
