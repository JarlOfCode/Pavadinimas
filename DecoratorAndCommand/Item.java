package DecoratorAndCommand;

import edu.ktu.signalrclient.Player1;

public class Item {
	
	public void AddHealth(Player p) {
		p.AddHP(2);
	}
	
	public Player SetSpeed(Player p) {
		PlayerWithBoots pwb = new PlayerWithBoots(p);
		pwb.Decorate(pwb);
		return pwb;
	}
	
	public Player SetHealth(Player p) {
		PlayerWithArmor pwa = new PlayerWithArmor(p);
		pwa.Decorate(pwa);
		return pwa;
	}
}
