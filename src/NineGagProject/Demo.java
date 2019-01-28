 package NineGagProject;

import java.util.Scanner;

import javax.swing.JFrame;

import NineGagProject.Settings.Countries;
import NineGagProject.Settings.Genders;

public class Demo {
	
	
	public static void main(String[] args) throws InvalidDataException, InterruptedException, NotLoggedInException {
		
		MenuFor9gag m = new MenuFor9gag();
		m.main(args);
	}

}
