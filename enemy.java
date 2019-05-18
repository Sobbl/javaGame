package textGame;
import java.util.Random;
public class enemy {
Random rand=new Random();

public static final int HEALTH=0;
public static final int STRENGTH=1;
public static final int SPEED=2;
public static final int INTELLIGENCE=3;
public static final int FATIGUE=4;

//private player enemy1;

public String healthNames[]= {"Ogre"};
public String strengthNames[]= {"Barbarian"};
public String speedNames[]= {"Spider"};
public String intelligenceNames[]= {"Wizard"};
public String fatigueNames[]= {"Wolf"};
	
public enemy() {
	//enemy1=player;
	//setEnemyName(enemy1);
}

	
public void generateEnemy(player enemy1, int level) {
	
	generateEnemyStats(enemy1, level);
	 setEnemyName(enemy1);
}

	
	
	
	public void setEnemyName(player player) {
		
		
		int health=player.getMaxHealth();
		int strength=player.getMaxStrength();
		int speed=player.getMaxSpeed();
		int intelligence=player.getMaxIntelligence();
		int fatigue=player.getMaxFatigue();
		int max=Math.max(health,  strength);
		max=Math.max(max,  speed);
		max=Math.max(max,  intelligence);
		max=Math.max(max,  fatigue);
		//System.out.println("max is"+max);
		if(health==max) {
			player.setName(healthNames[rand.nextInt(healthNames.length)]);
		}
		if(strength==max) {
			player.setName(strengthNames[rand.nextInt(strengthNames.length)]);
		}
		if(speed==max) {
			player.setName(speedNames[rand.nextInt(speedNames.length)]);
		}
		if(intelligence==max) {
			player.setName(intelligenceNames[rand.nextInt(intelligenceNames.length)]);
		}
		if(fatigue==max) {
			player.setName(fatigueNames[rand.nextInt(fatigueNames.length)]);
		}
		
		
	}
	
	public void generateEnemyStats(player player,int level) {
		
	int points=rand.nextInt(level+3)+rand.nextInt(level+1)+level/3;
	
	double healthPoints=(rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
	double strengthPoints=(rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
	double intelligencePoints=(rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
	double speedPoints=(rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
	double fatiguePoints=(rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
	//System.out.println("health points"+ healthPoints);
	healthPoints=points*Math.max(0.1, healthPoints/60);
	strengthPoints=Math.max(0.1, strengthPoints/60);
	
	intelligencePoints=points*Math.max(0.1, intelligencePoints/60);
	fatiguePoints=points*Math.max(0.1, fatiguePoints/60);
	speedPoints=points*Math.max(0.1,  speedPoints/60);
	
	/*
	System.out.println("strength"+strengthPoints);
	System.out.println("int"+intelligencePoints);
	System.out.println("fat"+fatiguePoints);
	System.out.println("spd"+speedPoints);
	*/
	player.changeStats(HEALTH,(int)healthPoints);
	player.changeStats(STRENGTH,(int)strengthPoints);
	player.changeStats(SPEED,(int)intelligencePoints);
	player.changeStats(INTELLIGENCE,(int)fatiguePoints);
	player.changeStats(FATIGUE,(int)speedPoints);
	}
	
	
	
	
	
	
	
	
}
			
			
			
			
			
			
			
	

