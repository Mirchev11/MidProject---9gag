package NineGagProject;

import java.util.concurrent.Callable;
 
public class RegisterFormThread implements Runnable { //nishka koqto vika formata za registrirane na nov user.

	
	@Override
	public void run() {
		RegisterForm fr = new RegisterForm();
		System.out.println(NineGag.giveNineGag().users.size());
		fr.main();
	}

	
}
