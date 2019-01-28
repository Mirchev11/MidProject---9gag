 package NineGagProject;

import java.util.Scanner;

import javax.swing.JFrame;

import NineGagProject.Settings.Countries;
import NineGagProject.Settings.Genders;

public class Demo {
	
	
	public static void main(String[] args) throws InvalidDataException, InterruptedException, NotLoggedInException {
		
//		User usi = new User("Ivan m", "Im112488","ivan@abv.bg");
//		usi.createAPost("photo1", "Mega qkata snimka, brat!").addTagsToPost("snimka","qko","fun");
//		usi.createAPost("photo2", "Malko tupa snimka, brat!").addTagsToPost("tup","grozen");
//		usi.searching("tup");
		
		
		MenuFor9gag m = new MenuFor9gag();
		m.main(args);
		
	}

}
