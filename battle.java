package textGame;
import java.util.Random;
import java.util.Scanner;

//import java.util.concurrent.TimeUnit;

public class battle {
	
	Random rand=new Random();
	private player player1;
	private player enemy1;
	private boolean battleOn=true;
	public static final int MEDIUM=1000;
	public static final int LONG=2000;
	public static final int SHORT=500;
	public static final int TINY=400;
	
	
	
	public battle(player player, player enemy) {
		player1=player;
		enemy1=enemy;
		
	}
	
	public void battleIntro() {
		timeDelay(MEDIUM);
		System.out.println(player1.getName()+ " gets ready to fight "+enemy1.getName()+"!");
	}
	
	public int pickAttack(player player, int attack) {
		timeDelay(SHORT);
		System.out.println("");
		System.out.println("Pick an Attack! 0 to check attacks/inventory");
		Scanner reader=new Scanner(System.in);
		int choice=1;
		while(reader.hasNext()) {
			
			if(reader.hasNextInt()) {
			choice=reader.nextInt();
			
				break;
			}
			else {
				System.out.println("You must enter a number to pick an attack!");
				//input="";
				reader.nextLine();
			}
		
		
	}
		//timeDelay(MEDIUM);
		if(choice==1) {
			return player.attackPunch();
		}
		else {return 1;
		
		}
	}
	
	public int pickEnemyAttack(player player, int attack) {
		//timeDelay(MEDIUM);
		
		if(attack==1) {
			return player.attackPunch();
		}
		else {return 1;
		
		}
		
	}
	
	public void timeDelay(int delay) {
		try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(delay);
         } catch (Exception e) {
            System.out.println(e);
         }
		
	}
	public void dealDamage(player player, int damage) {
		
		player.damageHealth(damage);
		timeDelay(MEDIUM);
		System.out.print(player.getName()+" took "+damage+" damage");
		timeDelay(TINY);
		System.out.print(".");
		timeDelay(TINY);
		System.out.print(".");
		timeDelay(TINY);
		System.out.print(".");
		timeDelay(TINY);
		System.out.print(".");
		
		timeDelay(SHORT);
		
		//TimeUnit.SECONDS.sleep(1);
		
		
		
		
	}
	
	public boolean checkIfDead(player player) {
		//timeDelay(MEDIUM);
		if(player.getHealth()<=0) {
			timeDelay(MEDIUM);
			System.out.println(player.getName() +" was killed!");
			timeDelay(MEDIUM);
			
			//timeDelay(MEDIUM);
			battleOn=false;
			//System.out.println("battle on is FALSE");
			return true;
			
		}
		else {
			//System.out.println("battle on is TRUE");
			return false;
		
	}
	}
	
	
	
	public boolean speedCheck(player player1, player player2) {
		//timeDelay(MEDIUM);
		double speed1=player1.getSpeed();
		double speed2=player2.getSpeed();
		double speedDifference=(speed1/speed2);
		double chance1=rand.nextInt(33)+rand.nextInt(33)+rand.nextInt(33)+1;
		double chance2=speedDifference*(rand.nextInt(33)+rand.nextInt(33)+rand.nextInt(33)+1);
	//	System.out.println("chance 1="+chance1);
	//	System.out.println("chance 2="+chance2);
		timeDelay(MEDIUM);
		if(chance2>=chance1) {
			
			System.out.println(player1.getName()+" is faster than "+ player2.getName()+" and goes first!");
			return true;
		}
		else {
			System.out.println(player2.getName()+" is faster than "+ player1.getName()+" and goes first!");
			return false;
		
		}
	
		
		
		}
	
	public void battlePlayerRound(player player1, player enemy1) {
		
		int damage=pickAttack(player1, 1);
		dealDamage(enemy1,damage );
		if(checkIfDead(enemy1)) {
			//System.out.println("TEST1111");
			int gainedExp;
			int expGainRand=Math.max(enemy1.getLevel()/3,3);
			//1System.out.println("expGainRand="+expGainRand);
			
			gainedExp=player1.addExp(rand.nextInt(expGainRand)+rand.nextInt(expGainRand)+rand.nextInt(expGainRand));
			timeDelay(MEDIUM);
			System.out.println(player1.getName()+" gained "+gainedExp+" experience!");
			timeDelay(MEDIUM);
			player1.levelUp();
			timeDelay(MEDIUM);
		}
			
	}
		
	public void battleEnemyRound(player player1, player enemy1) {
		//timeDelay(MEDIUM);
		//System.out.println("test 3");
		int damage=pickEnemyAttack(enemy1, 1);
		dealDamage(player1, damage);
		//timeDelay(MEDIUM);
		
	//	System.out.println("test 4");
		if(checkIfDead(player1)) {
			timeDelay(MEDIUM);
			System.out.println("YOU HAVE DIED");
			//break;
		};
	}
	
	
	public void battleArena() {
		battleIntro();
		int round=1;
		while(battleOn==true) {
			timeDelay(MEDIUM);
			System.out.println("");
			System.out.println("-----------------");
			System.out.println("Round "+round+"!");
			
			if(speedCheck(player1, enemy1)) {
			battlePlayerRound(player1, enemy1);
			//System.out.println("test 1");
			if(battleOn==false) {
				break;
			}
			
			
			  
			//System.out.println("test 2");
			battleEnemyRound(player1, enemy1);
			
			
			   
				
			//System.out.println("--------player1 health="+player1.getFatigue());
			//System.out.println("---------enemy1 health="+enemy1.getFatigue());
			round++;
			}
			else {
			battleEnemyRound(player1, enemy1);
			if(battleOn==false) {
				break;
			}
			battlePlayerRound(player1, enemy1);
			
			//System.out.println("--------player1 health="+player1.getFatigue());
			//System.out.println("---------enemy1 health="+enemy1.getFatigue());
			round++;
	}
		}
	}
}
	
	


