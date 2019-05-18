package textGame;
//import java.util.Scanner;
import java.util.Random;
public class driver {
	
	public static final int MEDIUM=1000;
	public static final int LONG=2000;
	public static final int SHORT=500;
	
	player player1;
	player enemy1;
	//private int level;
	public static void timeDelay(int delay) {
		try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(delay);
         } catch (Exception e) {
            System.out.println(e);
         }
		
	}
	
	public static void main(String[] args) {
	//	Scanner scanner=new Scanner(System.in);
		
		player player1=new player(1,1,1,1,1);
		player1.generateEnemyStats(30);
		Random rand=new Random();
		int level=1;
		
		enemy enemyGenerator=new enemy();
		//ScanUtil reading=new ScanUtil();
	
		//enemy1.generateEnemyStats(20);
		
		//enemy1.setName("Goblin");
		
		// type, bonus, stat, level, 0 for random
		
		item item3=new item(0,0,0,1);
		
		//int x=1;
		while(player1.isAlive()){
			//# of fights per level is set to 5+level+0-4, so ex lvl 10, fights would be 15-19
		int fightMax=rand.nextInt(4);
		fightMax=fightMax+level+5;
		//generate 2 random items to give at end of level
		item item1=new item(0,0,0,level);
		item item2=new item(0,0,0,level);
		
		// for loop does each dungeon level
		for(int fight=1;fight<2;fight++) {
			player enemy1=new player(1,1,1,1,1);
			//generates a new enemy based on dungeon level
			enemyGenerator.generateEnemy(enemy1, level+30);
		battle battle=new battle(player1, enemy1);
		System.out.println("----------------------FIGHT #"+fight);
		battle.battleArena();
		
		
		}
		System.out.println("Dungeon cleared!");
		timeDelay(MEDIUM);
		System.out.println("You found a "+item1.getType()+" and a "+item2.getType()+"!");
		player1.addItem(item1);
		player1.addItem(item2);
		System.out.println("---");
		
		
		player1.displayPlayerStats();
		//enemy1.displayPlayerStats();
		System.out.println("-xxxxxx--");
		//player1.attackPunch();
		level++;
		System.out.println("Level "+level);
		}
		
	}

}
