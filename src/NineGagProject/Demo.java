package NineGagProject;

public class Demo {

	public static void main(String[] args) throws InvalidDataException {
//	User usi = new User();
//	System.out.println(Helper.isNameValid("Ivan Mirchev"));
		
		User user1 = new User("Full Name1", "Pass1234", "some123email@abv.bg");
		System.out.println("-----------Account information -------------");
		user1.printUserInformation();
		
		User user2 = new User("Full Name2", "pasSS1234", "some.email@abv.bg");
		System.out.println("-----------Account information -------------");
		user2.printUserInformation();
		
		User user3 = new User("Full Name3", "valiD12pass", "some.123email@abv.bg");
		System.out.println("-----------Account information -------------");
		user3.printUserInformation();
		
		User user4 = new User("Full Name4", "ShouldBeValid123", "validEmail@abv.bg");
		System.out.println("-----------Account information -------------");
		user4.printUserInformation();
		
		User user5 = new User("Full Name5", "somePass134", "someemail@abv.bg");
		System.out.println("-----------Account information -------------");
		user5.printUserInformation();
		
		User user6 = new User("Full Name6", "    validDD12", "some123email78@abv.bg");
		System.out.println("-----------Account information -------------");
		user6.printUserInformation();
		
	
	//System.out.println(Helper.userNameMaker("ivan_!*92M_irchev11@abv.bg"));
	
	}

}
