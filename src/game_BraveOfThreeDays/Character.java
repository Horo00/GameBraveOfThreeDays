package game_BraveOfThreeDays;
class Character {
	String name;
	int maxEnergy;
	int energy;
	int maxMP;
	int mP;
	int offence;
	int lV;

	Character(String name, int maxEnergy, int energy,int mP, int offence, int lV) {
		this.name = name;
		this.maxEnergy = maxEnergy;
		this.energy = energy;
		this.maxMP =mP;
		this.mP =mP;
		this.offence = offence;
		this.lV = lV;
	}

	void sleep() {
		this.energy = this.maxEnergy;
		this.mP = this.maxMP;
		System.out.println(this.name + ":よく寝た。体力とマナが回復したよ");
	}
	
	int getCritAttack(int offence) {
		return offence*2;
	}

	void printInfo() {
		System.out.println("**************");
		System.out.println("名前:" + this.name);
		System.out.println("レベル:" + this.lV);
		System.out.println("体力:" + this.energy);
		System.out.println("攻撃力:" + this.offence);
		System.out.println("**************");
	}

}
