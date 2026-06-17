//to add: sprites???
package game;
import java.util.Random;
public class Natemon {
	private int hp;
	private int maxHp;
	private String type; // fire water grass
	private String name;
	private boolean alive = true; // true = alive, false = dead
	
	public Natemon(String name, String type, int hp) {
		this.name = name;
		this.hp = hp;
		this.type = type.toLowerCase();
		maxHp = hp;
	}
	
	public Natemon() {
		name = "Little Natemon";
		hp = 100;
		type = randomType();
	}
	
	public String randomType() {
		Random rand  = new Random();
		String type = "";
		int t = rand.nextInt(3);
		if(t == 0) type = "fire";
		else if(t == 1) type = "water";
		else if(t == 2) type = "grass";
		
		return type;
	}
	
	public int getHp() {
		return hp;
	}
	
	public String getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
		if(this.hp < 0) {
			this.hp = 0;
			alive = false;
		}
		if(this.hp > maxHp) this.hp = maxHp;
	}
	
	public void setType(String type) {
		this.type = type.toLowerCase();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String toString() {
		return "Natemon: "+name+"\nType: "+type+"\nHealth: "+hp;
	}
	
	
	
}

