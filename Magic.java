package classMagic;

public class Magic {
	private String name;
	private Character specializationRestriction;
	private String type;
	private int damage;


	public Magic() {
		name = null;
		specializationRestriction = null;
		type = null;
		damage = -1;	
	}

	public Magic(String name, Character specializationRestriction, String type, int damage) {
		name = name.toLowerCase();
		this.name = name;
		this.specializationRestriction = specializationRestriction;
		this.type = type;
		this.damage = damage;	
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getSpecializationRestriction() {
		return specializationRestriction;
	}

	public void setSpecializationRestriction(Character specializationRestriction) {
		this.specializationRestriction = specializationRestriction;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}


}
