package NineGagProject;

import NineGagProject.Settings.Countries;
import NineGagProject.Settings.Genders;

public class Demo {

	public static void main(String[] args) {
	User usi = new User("Ivan Mirchev","Zm112488","ivanmirchev92@abv.bg");

	usi.settings.country(Countries.CAMEROON).userName().sensitiveContent(true).description("bla bla").gender(Genders.MALE);
	System.out.println(usi.settings.toString());
	}

}
