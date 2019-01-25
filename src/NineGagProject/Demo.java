package NineGagProject;

import javax.swing.JFrame;

import NineGagProject.Settings.Countries;
import NineGagProject.Settings.Genders;

public class Demo {
	
	
	public static void main(String[] args) {

	 
	NineGag site = new NineGag();
	try {
		User usi = new User("Ivan Mirchev","Im112488","ivanmirchev92@abv.bg",site);
		User usi1 = new User("Dimitar Petrov","Cska1948","mitko@gmail.com",site);
		User usi2 = new User("Georgi Pavlov","Levski1329","georgiPavlov@abv.bg",site);
		User usi3 = new User("Asen Georgiev","mIroEUmen13","AGeo@yahoo.com",site);
		User usi4 = new User("Ivan Naidenov","AzIsEGot3n","naidenov13@abv.bg",site);
		User usi5 = new User("Lazarina Semkova","P3TkoVoiVoda","lazaSemkova@mail.bg",site);

		usi.printUserInformation();
		Login_System login = new Login_System(site);
		login.main(args);
		
		
		
		
		
		
		
		
		
	} catch (InvalidDataException e) {
		System.out.println("Did not create a user!");
	}
	

	
	}

}
