 package NineGagProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

import com.google.gson.Gson;


import NineGagProject.Settings.Genders;

public class Demo {
	
	
	public static void main(String[] args) throws InvalidDataException, InterruptedException, NotLoggedInException, InvalidSectionException, IOException {
		
		User usi = new User("Ivan m","Cska1948","ivan@abv.bg");
//		
//		
//			Post post1 = usi.createAPost("photo1", "Mega qkata snimka, brat!", "Animals", false);
//					post1.addTagsToPost("snimka","qko","fun");
//			usi.createAPost("photo2", "Malko tupa snimka, brat!", "Funny", true).addTagsToPost("tag1","tag10");
//		
//			
//		
//		Comment c1 = new Comment("outer comment");
//		Comment c2 = new Comment("inner Comment");
//		
//		post1.addComment(c1);
//		c1.addReplie(c2);
//		
//		
//		User usi2 = new User("Mitko Petrov","MitakaBaby23","mPetrov23@abv.bg");
//		User usi3 = new User("Ivan m3","Cska19483","ivan3@abv.bg");

		UserStorage storage = UserStorage.giveUserStorage();
//		storage.addUserToSite(usi);
//		storage.addUserToSite(usi2);
//		storage.addUserToSite(usi3);
//		
//		storage.printAllUsers();		
//		storage.toJson();	
		storage.loadJson("src\\NineGagProject\\jsonStorage.json");
//		storage.setUserNames();
		storage.printAllUsers();
		//storage.printCollection();
		
		
		


		
		//usi.searching("tup");
		
//		usi.addSectionToFavourites("Funny", "Animals", "Ask 9GAG");
//		usi.showMyFavouriteSections();
//		
//		
		NineGag.giveNineGag();
		MenuFor9gag m = new MenuFor9gag();
		m.main();
		
		
		
//		//ninegag.showAllSections();
//		ninegag.showPostsAccordingToSections();
		
//	Ads ad = new Ads();
//	ad.start();
		 
		
		 
		
		
		
		
		//MenuFor9gag.main();
		
	}

}
