package NineGagProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserStorage { //class to store users
	
	
	private Map<String, User> users; // String - mail, User -user
	private static UserStorage storage;
	
	
	private UserStorage(){
		this.users = new HashMap<String, User>();
		
		
		
	}
	
	public void toJson() {
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		File jsonStorage = new File("src\\NineGagProject\\jsonStorage.json");
		if (!jsonStorage.exists()) {
			try {
				jsonStorage.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String jsonUserStorage = gson.toJson(new HashMap(this.users));
		
		try (PrintWriter pw = new PrintWriter(jsonStorage)) {
		pw.println(jsonUserStorage);
		System.out.println("Done");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}

	
	public static UserStorage giveUserStorage(){
		if(UserStorage.storage == null){
			UserStorage.storage = new UserStorage();
		}
		
		return UserStorage.storage;
	}
	
	Map<String, User> getCopyOfUsers(){
		return Collections.unmodifiableMap(users);
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
		 if(user != null) {
			synchronized (this.users) {
				if (users.containsKey(user.getEmail())) {
					System.out.println("User with this email already exists");
					return;
				}
				users.put(user.getEmail(), user);
			}
		 }
	}
	 
	 void deleteUser(User user) {
		 if(user != null) {
			synchronized (this.users) {
				if (users.containsKey(user.getEmail())) {
					System.out.println("Deleting user");
					this.users.remove(user.getEmail());
					user = null;
					return;
				}
			}
		 }
	}

	public boolean checkIfUserExists(String email) { // email check
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

	public User getUserFromStorage(String email){
		return this.users.get(email);
	}
	

	
}
