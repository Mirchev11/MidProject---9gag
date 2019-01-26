package NineGagProject;

import java.util.concurrent.Callable;
 
public class CreateUser implements Runnable { //nishka koqto vika formata za registrirane na nov user.

	
	@Override
	public void run() {
		RegisterForm fr = new RegisterForm();
		fr.main();
	}

	
}
