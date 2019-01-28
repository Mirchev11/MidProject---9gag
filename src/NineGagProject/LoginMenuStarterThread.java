package NineGagProject;

public class LoginMenuStarterThread implements Runnable {//nishka koqto vika login menuto

	@Override
	public void run() {
		LoginMenu m = new LoginMenu();
		m.main();
		
	}

}
