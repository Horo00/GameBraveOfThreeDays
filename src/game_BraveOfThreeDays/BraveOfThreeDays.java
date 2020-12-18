package game_BraveOfThreeDays;
import java.util.Scanner;

public class BraveOfThreeDays {

	public static void main(String[] args) {

		oP();

		howToPlay();

		String name = name();

		adventure(name);
	}

	public static void oP() {
		oP1();
		oP2();
		oP3();
		oP4();
	}

	public static void howToPlay() {
		Scanner stdin = new Scanner(System.in);
		int number = 0;
		try {
			for (;;) {
				System.out.println("[1]ゲームを始める。　[2]ゲーム説明　[3]もう一度OPを見る");
				number = stdin.nextInt();
				if (number == 1) {
					break;
				} else if (number == 2) {
					howToPlay2();
					continue;
				} else if (number == 3) {
					oP();
					continue;
				} else {
					System.out.println("無効な入力です");
				}
			}
		} catch (Exception e) {
			System.out.println("※数字を入力して下さい。\n");
			howToPlay();
		}
	}

	public static String name() {
		Scanner stdin = new Scanner(System.in);
		System.out.println("主人公の名前を決めてください↓");
		System.out.print("■");
		return stdin.next();
	}

	public static void adventure(String name) {
		Scanner stdin = new Scanner(System.in);
		Brave brave = new Brave(name, 10, 10, 0, 7, 1);
		int number =0;
		for (int day = 1; day <= 3; day++) {
				brave.printInfo();
				try {
					Thread.sleep(1000);
					System.out.println("\n◆" + day + "日目：昼");
				} catch (InterruptedException e) {
					System.out.println(e);
				}
				if (day == 3) {
					System.out.println(brave.name + ":今日が最終日だ。魔王城に行かなければ……");
				}
				while(true) {
					System.out.println(brave.name + ":今日はどうしよう。\n[1]戦闘　[2]寝る　[3]魔王城に行く");
					if(stdin.hasNextInt()) {
						number = stdin.nextInt();
						if (number == 1) {
							brave.battle();
							continue;
						} else if (number == 2) {
							brave.sleep();
							break;
						} else if (number == 3) {
							brave.bossBattle();
						} else {
							System.out.println("無効な入力です");
							continue;
						}
					} else {
						stdin.nextLine();
						System.out.println("※数字を入力して下さい");
					}
				}
			System.out.println("1日が終わりました");
		}
		System.out.println("3日目を過ぎてしまった……");
		System.out.println("魔王が世界を征服し終えたようだ……");
		System.out.println("GAME OVER");
	}

	public static void oP1() {
		System.out.println("　　■■■■■■■■■■■■■■■■■■\n\n\n\n\n");
		System.out.println("\n\n　　     ■■■■■■■■■■■■■\n\n\n\n\n");
		System.out.println("\n\n　■■■■■■■■■■■■■■■■■■■■■");
	}

	public static void oP2() {
		try {
			Thread.sleep(1000);
			System.out.println("\n\n\n\n");
			System.out.println("　　■■■■■■■■■■■■■■■■■■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■■■■■■■■■■■■■■■■■■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■　　　　　　　　　　　　　　　　■");
			System.out.println("　　■■■■■■■■■■■■■■■■■■");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public static void oP3() {
		try {
			Thread.sleep(1000);
			System.out.println("\n\n\n\n");
			System.out.println("　　　　　　■■■■■■■■　　　　　　　");
			System.out.println("　　　　　　　　　　　　■■　　　　　　　");
			System.out.println("　　　　　　　　■　　■■　　　　　　　　");
			System.out.println("　　　　　　　　　■■■　　　　　　　　　");
			System.out.println("　　　　　　　　　　■　　　　　　　　　　");
			System.out.println("　　　■■■■■■■■■■■■■　　　");
			System.out.println("　　　■　　　　　■　　　　　■　　　");
			System.out.println("　　　■　　　　　■　　　　　■　　　");
			System.out.println("　　　■　　　　　■　　　　　■　　　");
			System.out.println("　　　■■■■■■■■■■■■■　　　");
			System.out.println("　　　■　　　　　■　　　　　■　　　");
			System.out.println("　　　■　　　　　■　　　　　■　　　");
			System.out.println("　　　■　　　　　■　　　　　■　　　");
			System.out.println("　　　■■■■■■■■■■■■■　　　");
			System.out.println("　　　　　　　　　■　　　　　　　　　　　");
			System.out.println("　　■■■■■■■■■■■■■■■　　　");
			System.out.println("　　　　　　　　　■　　　　　　■　　　　");
			System.out.println("　　　　　　　　■■　　　　　■■　　　");
			System.out.println("　　　　　　　■■　　　　　■■　　　");
			System.out.println("　　　　　　■■　　　　　■■　　　　");
			System.out.println("　　　　　■■　　　　　■■　　　　");
			System.out.println("　　　　■■　　　　　■■　　　　");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public static void oP4() {
		try {
			Thread.sleep(1000);
			System.out.println("\n\n\n\n");
			System.out.println("　　　　　　　　　■　　　　　　　　　　　　");
			System.out.println("　　　　　　　　　■　　　　　　　　　　　　");
			System.out.println("　　　　　　　　　■　　　　　　　　　　　　");
			System.out.println("　　　　　　　■■■■■　　■　　　　　　　");
			System.out.println("　　　　　　　　　■　　　■　　　　　　　　");
			System.out.println("　　　　　　　　　■　　■　　　　　　　　　");
			System.out.println("　　　　　　　　　■　■　　　　　　　　　　");
			System.out.println("　　　　　　　　　■■　　　　　　　　　　　");
			System.out.println("　　　■■■■■■■■■■■■■■　　　　　");
			System.out.println("　　　　　　　　■　　　　　　　　　　　　　");
			System.out.println("　　　　　　　■　　　　　　　　　　　　　　");
			System.out.println("　　　　　　■■■■■■■■■　　　　　　　　");
			System.out.println("　　　　　■　■　　　　　　■　　　　　　　　");
			System.out.println("　　　　■　　■　　　　　　■　　　　　　　　");
			System.out.println("　　　■　　　■　　　　　　■");
			System.out.println("　　■　　　　■■■■■■■■");
			System.out.println("　■　　　　　■　　　　　　■");
			System.out.println("　　　　　　　■　　　　　　■");
			System.out.println("　　　　　　　■　　　　　　■");
			System.out.println("　　　　　　　■　　　　　　■");
			System.out.println("　　　　　　　■■■■■■■■");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(1500);

			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n　　　　　【三日勇者】\n\n\n");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public static void howToPlay2() {
		System.out.println("世界は魔王の手によって魔物の蔓延る世界となっていた。");
		System.out.println("ある日、魔王は世界中に響き渡る声でこう言った……");
		try {
			Thread.sleep(3000);
			System.out.println("\n「我は世界のほとんどを掌握した」");
			System.out.println("「世界を完全に支配するまで後3日であろう」");
			System.out.println("「人間どもよ。せいぜい恐怖に怯えるがいい」");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(3000);
			System.out.println("\n人々は嘆き悲しみ、そして神に祈りました。");
			System.out.println("「どうか我々に救いの手を……」");
			System.out.println("神はその祈りを聞き届け、一人の人間を生み出しました");
			System.out.println("人々は歓喜し、そしてその人間をこう呼びました。");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(5000);
			System.out.println("\n3日で世界を救うべき勇者――【三日勇者】と");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		try {
			Thread.sleep(5000);
			howToPlay3();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public static void howToPlay3() {
		Scanner stdin = new Scanner(System.in);
		String[] message = new String[5];
		message[0] = "\n\nあなたは勇者として生まれました。";
		message[1] = "しかし生まれたばかりのあなたではすぐには魔王は倒せません";
		message[2] = "幸いにして世界中のいたる所に魔物がいるので、それらを倒しレベルを上げましょう";
		message[3] = "寝れば体力は全回復しますが、3日目に到達すると魔王が世界を征服してしまいます";
		message[4] = "限られた時間の中でレベルを上げ、魔王を倒しましょう";
		System.out.println("\n([エンターキー]で次へ)");
		for (int i = 0; i < message.length; i++) {
			System.out.println(message[i]);
			stdin.nextLine();
		}
	}

}
