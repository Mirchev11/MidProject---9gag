package NineGagProject;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


public class Settings {
	
	private static final String[] systemUserAvatars = { "photo1", "photo2", "photo3", "photo4", "photo5", 
			"photo6", "photo7", "photo8", "photo9", "photo10", "photo11", "photo12", "photo13", "photo14", 
			"photo15", "photo16", "photo17", "photo18", "photo19", "photo20", "photo21", "photo22", "photo23"};
	
	public enum Countries {
		ANDORA,BUGARIA,CAMEROON;
		
		
		public static boolean contains(Countries country) {
			for(Countries c : Countries.values()) {
				if(country.equals(c)) {
					return true;
				}
			}
			return false;
		}
	}

	public enum Statuses {
		
	}

	public enum Genders {
		MALE,FAMALE,UNSPECIFIED;
		
		public static boolean contains(Genders gender) {
			for(Genders g : Genders.values()) {
				if(gender.equals(g)) {
					return true;
				}
			}
			return false;
		}
	}
	private User owner;
	private String photo;
	private String userName;
	private LocalDate birthDate;
	private Countries country;
	private String description;
	private Statuses status;
	private Genders gender;
	private boolean sensitiveContent;

	
	public Settings(User owner) {
		if(owner != null && this.owner == null) {
			this.owner = owner;
		}
	}
	
	public Settings photo(String photo) {
		if(photo != null) {
			this.photo = photo;
		}
		return this;
	}
	
	public Settings chooseRandomAvatar() {
		this.photo = systemUserAvatars[(int) (Math.random() * systemUserAvatars.length)];
		return this;
	}
	
	public Settings userName() {
	String mailOfUser =	this.owner.getEmail();
		if(mailOfUser != null) {
			this.userName = Helper.userNameMaker(mailOfUser);
		}
		return this;
	}
	
	//date is in format yyyy-mm-dd 
	//TODO change regex to match other date formats
	public Settings birthDate(String date) throws InvalidDataException {
		Helper.FormattedDateMatcher matcher = new Helper.FormattedDateMatcher();
		if(Helper.isStringValid(date) && matcher.matches(date)) {
			this.birthDate = LocalDate.parse(date);
			
		} 
		return this;
	}
	
	public Settings country(Countries country) {
		if(Countries.contains(country)) {
			this.country = country;
		}
		return this;
	}
	
	public Settings description(String description) {
		if(description != null) {
			this.description = description;
		}
		return this;
	}
	
	public Settings gender(Genders gender) {
		if(Genders.contains(gender)) {
			this.gender = gender;
		}
		return this;
	}
	
	public Settings sensitiveContent(Boolean sensitive) {
		this.sensitiveContent = sensitive;
		return this;
	}
	
	protected String getCountry() {
		return this.country.toString();
	}
	
	@Override
	public String toString() {
		return "Settings [userName=" + userName + ", country=" + country + ", description=" + description + ", gender="
				+ gender + "]";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Genders getGender() {
		return gender;
	}

	public void setGender(Genders gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
}
