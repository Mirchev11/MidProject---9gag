package NineGagProject;

public class LoginUser implements Runnable { // nishka, koqto se vika kogato otvorim prozoreca i cyknem na butona za logvane

	@Override
	public void run() {
		Login_System lg = new Login_System();
		System.out.println(NineGag.giveNineGag().users.size());
		lg.main();
	}
}
