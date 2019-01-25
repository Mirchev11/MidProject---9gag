package NineGagProject;

import NineGagProject.Settings.Countries;
import NineGagProject.Settings.Genders;

public class Demo {

	public static void main(String[] args) {
	User usi;
	try {
		usi = new User("Ivan Mirchev","mm112488","ivanmirchev92@abv.bg");
		usi.printUserInformation();
	} catch (InvalidDataException e) {
		System.out.println("Did not create a user!");
	}
	

	//usi.settings.country(Countries.CAMEROON).userName().sensitiveContent(true).description("bla bla").gender(Genders.MALE);
	//System.out.println(usi.settings.toString());
	//System.out.println(Helper.userNameMaker("ivan_!*92M_irchev11@abv.bg"));
	}

}
