package NineGagProject;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.Validator;

public class User {
	

	private String fullName;
	private String password;
	private String email;
	private Set<Comment> comments;
	private Set<Post> posts;
	private Set<Post> upvotes;
	Settings settings;


	public User(String names,String pass,String email) {
		this.settings = new Settings(this);
		
		
		Scanner sc = new Scanner(System.in);
		while (!Helper.isNameValid(names)) { //TODO допълнителна проверка дали няма потребител с такова име в листа на сайта.
			System.out.println("Enter valid name:");
			names = sc.nextLine();
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
			if (!Helper.passwordValidator.isPasswordStrong(pass)) {
				System.out.println("Weak password!");
			}
		}

		this.password = pass;
		System.out.println("Your password is valid!");
		System.out.println("Your password is: " + this.password);

	
		Helper.EmailValidator validator = new Helper.EmailValidator();
		while (!validator.validate(email) || email == null) {
			System.out.println("Enter a valid email!");
			email = sc.next();
			if (!validator.validate(email) || email == null) {
				System.out.println("Bad email entered!");
			}
		}
		this.email = email;
		System.out.println("Your email is accepted");
		System.out.println("Your email is " + this.email);
//		//TODO да логна некви работи да вкарам user-a в листа от user-и на сайта ни.
////		this.userName = Helper.userNameMaker(this.email);//ужасно грозен метод.
		this.comments = new TreeSet<Comment>((com1,com2)-> com1.getDate().compareTo(com2.getDate()));
		this.posts = new TreeSet<Post>((pos1,pos2) -> pos1.getPostDate().compareTo(pos2.getPostDate()));
		this.upvotes = new TreeSet<Post>((pos1,pos2) -> pos1.getPostDate().compareTo(pos2.getPostDate()));
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



}
