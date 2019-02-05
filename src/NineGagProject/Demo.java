 package NineGagProject;

import java.util.Scanner;

import javax.swing.JFrame;

import NineGagProject.Settings.Countries;
import NineGagProject.Settings.Genders;

public class Demo {
	
	
	public static void main(String[] args) throws InvalidDataException, InterruptedException, NotLoggedInException {
		
		User usi = new User("Ivan m", "Im112488","ivan@abv.bg");
		try {
			usi.createAPost("photo1", "Mega qkata snimka, brat!", "Animals", false).addTagsToPost("snimka","qko","fun");
			usi.createAPost("photo2", "Malko tupa snimka, brat!", "Funny", true).addTagsToPost("tag1","tag10");
		} catch (InvalidSectionException e) {
			System.out.println("Invalid Section!");
		}
		//usi.searching("tup");
		
//		usi.addSectionToFavourites("Funny", "Animals", "Ask 9GAG");
//		usi.showMyFavouriteSections();
//		
//		
//		NineGag ninegag = NineGag.giveNineGag();
//		//ninegag.showAllSections();
//		ninegag.showPostsAccordingToSections();
		
//	Ads ad = new Ads();
//	ad.start();
		 
		 
		
		
		
		
		MenuFor9gag.main();
		
	}

}
