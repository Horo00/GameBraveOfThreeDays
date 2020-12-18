package game_BraveOfThreeDays;
import java.util.Random;

class Enemy extends Character{

		Enemy(String name, int maxEnergy, int energy,int mP, int offence, int lV) {
			super(name, maxEnergy, energy, mP, offence, lV);

			String[] enemys= {"スライム","スライムナイト","ゾンビ騎士","リザードマン",
					"スライム(狂)","スライムナイト(狂)","ゾンビ騎士(狂)","リザードマン(狂)",
					"幹部(弱)","幹部(強)","幹部(狂)","側近","?","??","???","????"};
			this.name = enemys[lV];
			this.maxEnergy =getMaxEnergy(lV);
			this.energy =this.maxEnergy;
			this.offence = getOffence(lV);
		}
		public static int getMaxEnergy(int lV) {
			Random rand = new Random();
			int maxEnergy =0;
			maxEnergy = ((lV+1) * 7)+(rand.nextInt(6)+1);
			return maxEnergy;
		}
		public static int getOffence(int lV) {
			int offence =0;
			offence = (lV+1)*2 ;
			return offence;
		}
	}