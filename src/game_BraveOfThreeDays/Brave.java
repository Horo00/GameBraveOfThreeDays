package game_BraveOfThreeDays;
import java.util.Random;
import java.util.Scanner;

class Brave extends Character {
	Brave(String name, int maxEnergy, int energy, int mP, int offence, int lV) {
		super(name, maxEnergy, energy, mP, offence, lV);
	}

	void printInfo() {
		System.out.println("\n**************");
		System.out.println("名前:" + this.name);
		System.out.println("レベル:" + this.lV);
		System.out.println("最大体力:" + this.maxEnergy);
		System.out.println("現在体力:" + this.energy);
		System.out.println("最大マナ" + this.maxMP);
		System.out.println("マナ:" + this.mP);
		System.out.println("攻撃力:" + this.offence);
		System.out.println("**************");
	}

	void battle() {
		Random rand = new Random();
		Scanner stdin = new Scanner(System.in);
		System.out.println("\n*敵が現れた！！*");
		Enemy enemy = new Enemy("", 0, 0, 0, 0, this.lV - rand.nextInt(2));
		enemy.printInfo();
		while (energy > 0) {
			System.out.println("現在マナ:" + this.mP);
			try {
				Thread.sleep(1000);
				System.out.println("あなたの行動を決めてください");
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			int number = 0;
			while (true) {
				System.out.println("[1]攻撃　[2]魔法攻撃(2マナ消費)　[3]逃げる");
				if (stdin.hasNextInt()) {
					number = stdin.nextInt();
					if (number == 1) {
						enemy.energy = battleAttack(enemy.name, enemy.energy, enemy.offence);
						break;
					} else if (number == 2) {
						if (this.mP >= 2) {
							enemy.energy = battleMagic(enemy.name, enemy.energy, enemy.offence);
							break;
						} else {
							System.out.println("マナが足りない!");
							continue;
						}
					} else if (number == 3) {
						break;
					} else {
						System.out.println("無効な入力です");
						continue;
					}
				} else {
					stdin.nextLine();
					System.out.println("※数字を入力して下さい");
				}
			}
			if (number == 3) {
				if (battleEscape()) {
					battleEnd(enemy.energy);
					break;
				}
			}
			if (enemy.energy > 0) {
				enemyAttack(enemy.name, enemy.energy, enemy.offence);
			} else {
				battleEnd(enemy.energy);
				break;
			}

		}
	}

	void bossBattle() {
		Scanner stdin = new Scanner(System.in);
		System.out.println("*魔王が現れた*");
		System.out.println("～ファイナルバトル～");
		Boss boss = new Boss("魔王", 100, 100, 0, 8, 5);
		boss.printInfo();
		while (energy > 0) {
			System.out.println("現在マナ:" + this.mP);
			try {
				Thread.sleep(1000);
				System.out.println("あなたの行動を決めてください");
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			int number = 0;
			while (true) {
				System.out.println("[1]攻撃　[2]魔法攻撃(2マナ消費)　[3]逃げる");
				if (stdin.hasNextInt()) {
					number = stdin.nextInt();
					if (number == 1) {
						boss.energy = battleAttack(boss.name, boss.energy, boss.offence);
						break;
					} else if (number == 2) {
						if (this.mP >= 2) {
							boss.energy = battleMagic(boss.name, boss.energy, boss.offence);
							break;
						} else {
							System.out.println("マナが足りない!");
							continue;
						}
					} else if (number == 3) {
						bossEscape();
						continue;
					} else {
						System.out.println("無効な入力です");
						continue;
					}
				} else {
					stdin.nextLine();
					System.out.println("※数字を入力して下さい");
				}
			}
			if (boss.energy > 0) {
				enemyAttack(boss.name, boss.energy, boss.offence);
			} else {
				bossEnd();
				break;
			}
		}
	}

	private int battleAttack(String eneName, int eneEnergy, int eneOffence) {
		Random rand = new Random();
		if (rand.nextInt(10) < 8) {
			eneEnergy -= this.offence;
			battleAttackMessage(getBattleAttackMessage(eneName, eneEnergy));
		} else {
			eneEnergy -= getCritAttack(this.offence);
			battleAttackMessage(getCritBattleAttackMessage(eneName, eneEnergy));
		}
		return eneEnergy;
	}

	private String[] getBattleAttackMessage(String eneName, int eneEnergy) {
		String[] messages = new String[3];
		messages[0] = "\n" + this.name + "の攻撃！";
		messages[1] = eneName + "に" + this.offence + "のダメージ";
		messages[2] = eneName + "の現在体力:" + eneEnergy;
		return messages;
	}

	private String[] getCritBattleAttackMessage(String eneName, int eneEnergy) {
		String[] messages = new String[3];
		messages[0] = "\n" + this.name + "の会心の一撃！！";
		messages[1] = eneName + "に" + this.offence * 2 + "のダメージ";
		messages[2] = eneName + "の現在体力:" + eneEnergy;
		return messages;
	}

	private void battleAttackMessage(String message[]) {
		for (int i = 0; i < message.length; i++) {
			System.out.println(message[i]);
			if (i < message.length-1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}

	private int battleMagic(String eneName, int eneEnergy, int eneOffence) {
		int magicDamage = getMagicDamage();
		eneEnergy -= magicDamage;
		this.mP -= 2;
		battleAttackMessage(getBattleMagicMessage(eneName, eneEnergy, magicDamage));
		return eneEnergy;
	}

	private int getMagicDamage() {
		Random rand = new Random();
		return (this.offence + (rand.nextInt(4) + 3));
	}

	private String[] getBattleMagicMessage(String eneName, int eneEnergy, int magicDamage) {
		String[] messages = new String[4];
		messages[0] = "\nマナを2消費しました";
		messages[1] = this.name + "のメラメラ！";
		messages[2] = eneName + "に" + magicDamage + "のダメージ";
		messages[3] = eneName + "の現在体力:" + eneEnergy;
		return messages;
	}

	private void enemyAttack(String eneName, int eneEnergy, int eneOffence) {
		this.energy -= eneOffence;
		enemyAttackMessage(eneName, eneOffence);
		if (this.energy <= 0) {
			battleEnd(eneEnergy);
		}
	}

	private void enemyAttackMessage(String eneName, int eneOffence) {
		String[] message = new String[3];
		message[0] = "\n" + eneName + "の攻撃!";
		message[1] = this.name + "に" + eneOffence + "のダメージ";
		message[2] = "\n" + this.name + "の現在体力" + this.energy;
		for (int i = 0; i < message.length; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(message[i]);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

	}

	private boolean battleEscape() {
		Random rand = new Random();
		if (rand.nextInt(10) < 8) {
			System.out.println("上手く逃げられた");
			return true;
		} else {
			System.out.println("しかし回り込まれてしまった！");
			return false;
		}
	}

	private void battleEnd(int eneEnergy) {
		try {
			Thread.sleep(1000);
			System.out.println("*戦闘が終了しました*");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		if (this.energy > 0 && eneEnergy <= 0) {
			lVUP();
		} else if (this.energy <= 0) {
			System.out.println("GAME OVER");
			System.exit(0);
		}
	}

	private void lVUP() {
		this.lV++;
		this.maxEnergy += this.lV;
		this.energy += this.lV;
		this.maxMP += 2;
		this.mP += 2;
		this.offence += this.lV;
		lVUPMessage();
	}

	private void lVUPMessage() {
		String[] message = new String[5];
		message[0] = "*敵を倒しました*";
		message[1] = "■レベルが1上がった。";
		message[2] = "■体力が" + lV + "増えた";
		message[3] = "■マナが2増えた";
		message[4] = "■攻撃力が" + lV + "上がった";
		for (int i = 0; i < message.length; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(message[i]);
			} catch (InterruptedException e) {
				System.out.println(e);
			}			
		}
		try {
			Thread.sleep(1000);
			printInfo();
		} catch (InterruptedException e) {
			System.out.println(e);
		}	
	}

	private void bossEscape() {
		System.out.println("魔王からは逃げられない！");
	}

	private void bossEnd() {
		try {
			Thread.sleep(1000);
			System.out.println("*戦闘が終了しました*");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1000);
			eD();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.exit(0);
	}

	private void eD() {
		Scanner stdin = new Scanner(System.in);
		String[] message = new String[4];
		message[0] = "\n勇者は3日間の激戦の末、魔王を倒すことに成功した";
		message[1] = "人々は魔王の脅威が去ったことを知り、三日勇者は英雄と称えられることになりました";
		message[2] = "◆congratulations◆";
		message[3] = "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　[続く]";
		System.out.println("([エンターキー]で次へ)");
		for (int i = 0; i < message.length; i++) {
			System.out.println(message[i]);
			stdin.nextLine();
		}
	}
}
