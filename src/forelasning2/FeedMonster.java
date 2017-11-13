package forelasning2;

public class FeedMonster {
	public static void main(String[] args) {
		Monster[] monsters = new Monster[3];
		
		Monster aake = new CookieMonster();
		Monster loke = new ScaryMonster();
		Monster aasa = new ScaryMonster();
		
		monsters[0] = aake;
		monsters[1] = loke;
		monsters[2] = aasa;
		
		for(Monster m : monsters){
			m.eat();
			if(Math.random() > 0.7){
				m.scream();
			}
		}
	}

}
