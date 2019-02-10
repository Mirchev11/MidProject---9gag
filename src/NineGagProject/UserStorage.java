package NineGagProject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserStorage { //class to store users
	
	
	private ConcurrentMap<String, User> users; // String - mail, User -user
	private static UserStorage storage;
	
	private UserStorage(){
		this.users = new ConcurrentHashMap<String, User>();
	}
	
	public static UserStorage giveUserStorage(){
		if(UserStorage.storage == null){
			UserStorage.storage = new UserStorage();
		}
		
		return UserStorage.storage;
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

	public User getUserFromStorage(String email){
		return this.users.get(email);
	}
	

	
}
