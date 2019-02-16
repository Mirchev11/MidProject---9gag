 package NineGagProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

import com.google.gson.Gson;

import NineGagProject.Settings.Countries;
import NineGagProject.Settings.Genders;

public class Demo {
	
	
	public static void main(String[] args) throws InvalidDataException, InterruptedException, NotLoggedInException, InvalidSectionException, IOException {
		
//		Ads ad = new Ads();
//		ad.start();
		
		User usi = new User("Ivan m","Cska1948","ivan@abv.bg");
		
		
			Post post1 = usi.createAPost("photo1", "Mega qkata snimka, brat!", "Animals", false);
					post1.addTagsToPost("snimka","qko","fun");
			usi.createAPost("photo2", "Malko tupa snimka, brat!", "Funny", true).addTagsToPost("tag1","tag10");
		
			
		
//		Comment c1 = new Comment("outer comment");
//		Comment c2 = new Comment("inner Comment");
//		
//		post1.addComment(c1);
//		c1.addReplie(c2);
		
		
		User usi2 = new User("Ivan m2","Cska19482","ivan2@abv.bg");
		Post post2 = usi2.createAPost("photo12", "Mega qkata snimka, brat!22", "Animals", false);
		post1.addTagsToPost("snimka22","qko22","fun22");
		User usi3 = new User("Ivan m3","Cska19483","ivan3@abv.bg");
		
		
		
//		UserStorage storage = UserStorage.giveUserStorage();
//		storage.addUserToSite(usi);
//		storage.addUserToSite(usi2);
//		storage.addUserToSite(usi3);
		
		usi2.writeAComment(post1, "usi2 comment");
		usi3.writeAComment(post1, "usi3 comment");
		Comment c = usi.writeAComment(post2, "commenting this");
		usi2.writeAReply(c, "this is my reply");
		
		
		
		usi.putNotifications();
		usi.showMyNotifications();
		
//		storage.printAllUsers();
//		
//		storage.toJson();
		
		
//		storage.loadJson("src\\NineGagProject\\jsonStorage.json");
//		storage.setUserNames();
//		storage.printAllUsers();
		//storage.printCollection();
		
		
		
		
		
		
		//usi.searching("tup");
		
//		usi.addSectionToFavourites("Funny", "Animals", "Ask 9GAG");
//		usi.showMyFavouriteSections();
//		
//		
//		NineGag.giveNineGag();
//		MenuFor9gag m = new MenuFor9gag();
//		m.main();
		
		
		
//		//ninegag.showAllSections();
//		ninegag.showPostsAccordingToSections();
		
//	Ads ad = new Ads();
//	ad.start();
		 
		
		 
		
		
		
		
		//MenuFor9gag.main();
		
	}

}
