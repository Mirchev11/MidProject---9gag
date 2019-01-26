package NineGagProject;

import java.util.Scanner;

import javax.swing.JFrame;

import NineGagProject.Settings.Countries;
import NineGagProject.Settings.Genders;

public class Demo {
	
	
	public static void main(String[] args) throws InvalidDataException, InterruptedException, NotLoggedInException {

	 
//		Menu m = new Menu(); //viknal sym ti menuto za da testvash, imash izbor za suzdavane na user i logavne, ima oshte za doopravqne
//								//ne e zaduljitelno da polzvame klasovete - Login_System,LoginUser,RegisterForm,CreateUser i Menu, tova e front end, moje i bez tqh da si napravim vsichko ako ne te kefi
//									//nqma da se nalagat promeni na koda
//		m.main();

		User usi = new User("Ivan m", "Im112488", "ivan@abv.bg");
		usi.createAPost("photo1", "strange photo");
		Post newPost = new Post(usi,"photo2", "even stranger photo!");
		usi.writeAComment(newPost, "are dano stane!");
		newPost.showPost();
		newPost.listAllCommentsForAPost();
		
		
		 
	}

}
