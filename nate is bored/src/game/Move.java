package game;
public class Move {
	private int damage;
	private int maxCooldown;
	private int cooldown;
	private String type;
	private String name;
	
	public Move(String name, String type, int damage, int cooldown) {
		if(cooldown < 0 || damage <= 0) {
			throw new IllegalArgumentException("invalid cooldown or damage");
		}
		
		this.name = name;
		this.damage = damage;
		this.type = type.toLowerCase();
		this.cooldown = cooldown;
		maxCooldown = cooldown;
	}
	
	public Move() {
		name = "no move";
		damage = 0;
		type = null;
		cooldown = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getCooldown() {
		return cooldown;
	}
	
	public int getMax() {
		return maxCooldown;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setDamage(int dmg) {
		damage = dmg;
	}
	
	public void setCd(int cd) {
		cooldown = cd;
	}
	
	public String moveDescription() {
		return "Move: "+name+"\nType: "+type+"\nDamage: "+damage;
	}
}
