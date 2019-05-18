package textGame;

import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;
public class player {
	//to do
	//allow attacks
	//skills?
	//dead?
	//level up function

	public static final int HEALTH=0;
	public static final int STRENGTH=1;
	public static final int SPEED=2;
	public static final int INTELLIGENCE=3;
	public static final int FATIGUE=4;
	public static final int EXPERIENCE=5;
	public static final int LEVEL=6;
	public static final int INVENTORY_SLOTS=10;
	public static final int LEVEL_UP=10;
	public static final int LEVEL_UP_POINTS=5;
	
	public static final int MEDIUM=1000;
	public static final int LONG=2000;
	public static final int SHORT=500;

	public static final int ATTACK_COST=1;
	//private int experience;
	private int level;

	private ArrayList<item> inventory;
	private item equipped[];
	private int stats[];
	private int currentStats[];
	private String statsDescription[]= {"Health", "Strength", "Speed", "Intelligence","Fatigue","Experience", "Level"};
	private String name="Adventurer";

	Random rand=new Random();
	Scanner reader;

	public static final int MIN_HEALTH=1;


	public player(int health, int strength, int speed, int intelligence, int fatigue) {
		stats=new int[7];
		currentStats=new int[5];
		//stats stores max player stats
		stats[HEALTH]=setMinimumStat(health);
		stats[STRENGTH]=setMinimumStat(strength);
		stats[SPEED]=setMinimumStat(speed);
		stats[INTELLIGENCE]=setMinimumStat(intelligence);
		stats[FATIGUE]=setMinimumStat(fatigue);
		//current stats will store the current stats
		currentStats[HEALTH]=stats[HEALTH];
		currentStats[STRENGTH]=stats[STRENGTH];
		currentStats[SPEED]=stats[SPEED];
		currentStats[FATIGUE]=stats[FATIGUE];
		currentStats[INTELLIGENCE]=stats[INTELLIGENCE];

		inventory=new ArrayList<item>();
		equipped=new item [INVENTORY_SLOTS];
		//Random rand=new random();
		stats[LEVEL]=1;
		stats[EXPERIENCE]=0;
		
	}


	public int getMaxHealth() {
		return stats[HEALTH];
	}
	public int getHealth() {
		return currentStats[HEALTH];
	}
	public int getMaxStrength() {
		return stats[STRENGTH];
	}
	public int getStrength() {
		return currentStats[STRENGTH];
	}
	public int getMaxSpeed() {
		return stats[SPEED];
	}
	public int getSpeed() {
		return currentStats[SPEED];
	}
	public int getMaxIntelligence() {
		return stats[INTELLIGENCE];
	}
	public int getIntelligence() {
		return currentStats[INTELLIGENCE];
	}
	public int getMaxFatigue() {
		return stats[FATIGUE];
	}
	public int getFatigue() {
		return currentStats[FATIGUE];
	}
	public int getLevel() {
		return stats[LEVEL];
	}
	public int getExperience() {
		return stats[EXPERIENCE];
	}
	public String getName() {
		return name;
	}
	public int setMinimumStat(int input) {
		if(input<1) {
			input=1;
		}
		return input;
	}
	public void damageHealth(int amount) {
		currentStats[HEALTH]-=amount;
	}
	public void damageStrength(int amount) {
		currentStats[STRENGTH]-=amount;
	}
	public void damageIntelligence(int amount) {
		currentStats[INTELLIGENCE]-=amount;
	}
	public void damageSpeed(int amount) {
		currentStats[SPEED]-=amount;
	}
	public void damageFatigue(int amount) {
		currentStats[FATIGUE]-=amount;
	}
	public void changeStats(int stat, int change) {
		stats[stat]+=change;
		currentStats[stat]+=change;
		
		//System.out.println("TEST  PLAYER HEALTH="+stats[0]);
	}
	public void setName(String name) {
		if(name!=null&&!name.equals("")) {
			this.name=name;
		}
		else {name="dumbo";
		}
	}
	
	public boolean isAlive() {
		boolean alive;
		if(currentStats[HEALTH]>0) {
			 alive=true;
		}
		else {alive=false;
		}
		return alive;
		
	}
//duplicate and can remove, useful for random testing tho
	public void generateEnemyStats(int level) {

		int points=rand.nextInt(level+3)+rand.nextInt(level+1)+level/3;

		double healthPoints=(rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
		double strengthPoints=(rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
		double intelligencePoints=(rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
		double speedPoints=(rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
		double fatiguePoints=(rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
		//	System.out.println("health points"+ healthPoints);
		healthPoints=points*Math.max(0.1, healthPoints/60);
		strengthPoints=points*Math.max(0.1, strengthPoints/60);

		intelligencePoints=points*Math.max(0.1, intelligencePoints/60);
		fatiguePoints=points*Math.max(0.1, fatiguePoints/60);
		speedPoints=points*Math.max(0.1,  speedPoints/60);

		
	System.out.println("strength"+strengthPoints);
	System.out.println("int"+intelligencePoints);
	System.out.println("fat"+fatiguePoints);
	System.out.println("spd"+speedPoints);
		 
		changeStats(HEALTH,(int)healthPoints);
		changeStats(STRENGTH,(int)strengthPoints);
		changeStats(SPEED,(int)intelligencePoints);
		changeStats(INTELLIGENCE,(int)fatiguePoints);
		changeStats(FATIGUE,(int)speedPoints);
	}


	public void addItem(item item) {
		if(item!=null) {
			inventory.add(item);
		}
	}

	public void searchItem(String itemSearch) {
		if(itemSearch!=null&&!itemSearch.equals("")){
			for(item item:inventory) {
				if(item.getDescription().contentEquals(itemSearch)){
					item.displayDetails();
				}
			}

		}
	}

	public void displayInventory() {

		for(item item:inventory) {
			System.out.println(inventory.indexOf(item));
			item.displayDetails();
		}
	}

	public void displayPlayerStats() {
		System.out.println("Player Name: "+name);
		System.out.println("Health: "+stats[HEALTH]);
		System.out.println("Strength: "+stats[STRENGTH]);
		System.out.println("Speed: "+stats[SPEED]);
		System.out.println("Intelligence: "+stats[INTELLIGENCE]);
		System.out.println("Fatigue: "+stats[FATIGUE]);
		System.out.println("--");
	}
	/*
	 * equip item takes the index of an item in invetory, and equips it to the player
	 * if an item was previously equipped, it is removed and bonuses are removed to player stats
	 * 
	 * the new item is equipped and bonuses are added to the player stats
	 */
	public void equipItem(int itemIndex) {
		//System.out.println("TEST 1: ITEM INDEX="+itemIndex);
		if(itemIndex>=0&&itemIndex<inventory.size()){

			item item=inventory.get(itemIndex);

			int itemBonus=item.getBonus();
			int itemStat=item.getStat();
			int itemPosition=item.getPosition();
			//determine the previous stat, and the bonus to that stat
			//System.out.println("TEST 2: itembonus="+itemBonus);
			//System.out.println("TEST 3: itemstat="+itemStat);
			//System.out.println("TEST 4: itemPosition="+itemPosition);


			int previousStat=0;
			int previousBonus=0;
			//remove subtract its bonus as long as there was an item equipped
			if(equipped[itemPosition]!=null) {
				previousBonus=equipped[itemPosition].getBonus();
				previousStat=equipped[itemPosition].getStat();
				stats[previousStat]-=previousBonus;
				currentStats[previousStat]-=previousBonus;
			}
			//equip the new item
			equipped[itemPosition]=item;
			//add new bonus
			stats[itemStat]+=itemBonus;
			currentStats[itemStat]+=itemBonus;
			//display stat changes    
			System.out.println("item equipped! lost "+previousBonus+statsDescription[previousStat]+", gained "+itemBonus+statsDescription[itemStat]);

		}
	}


	public int attackPunch() {

		double fat1=currentStats[FATIGUE];
	//	System.out.println("current fatigue"+currentStats[FATIGUE]);
		double fat2=stats[FATIGUE];
		double exhausted=1-fat1/fat2;
		double str=currentStats[STRENGTH];
		exhausted = 1 - 0.3714286*exhausted + 0.9714286*Math.pow(exhausted, 2) - 1.6*Math.pow(exhausted, 2);
	//	System.out.println("exhausted= "+exhausted);
		//	System.out.println("exhausted= "+exhausted);
		double smart=currentStats[INTELLIGENCE];
		smart=1+Math.min((smart/3)*fat1/fat2,20)/100;
		//System.out.println("smzart= "+smart);
		double damage=str*exhausted*smart;
		int punch=Math.max((int)damage,1);
		//System.out.println("punch= "+punch);
		
		if(currentStats[FATIGUE]<=0) {
			System.out.println("You are too exhausted too atack!");
			currentStats[FATIGUE]+=2*ATTACK_COST;
			punch=0;
			
		}
		if(currentStats[FATIGUE]>0) {
			System.out.println(name+" punches for "+punch+" damage!");
			currentStats[FATIGUE]-=ATTACK_COST;
		}
		return punch;
	}



	public int addExp(int level) {
		int gainedExp=rand.nextInt(level+5)+3;
		stats[EXPERIENCE]+=gainedExp;
		return gainedExp;
	}
	
	public void statIncreaseInput(int input) {
		//System.out.println("INPUT FOR LEVEL UP IS "+input);
		if(input==HEALTH+1) {
			changeStats(HEALTH,1);
		}
		if(input==STRENGTH+1) {
			changeStats(STRENGTH,1);
		}
		if(input==SPEED+1) {
			changeStats(SPEED,1);
		}
		if(input==INTELLIGENCE+1) {
			changeStats(INTELLIGENCE,1);
		}
		if(input==FATIGUE+1) {
			changeStats(FATIGUE,1);
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
	public void levelUp() {
		if(getExperience()>=level*LEVEL_UP) {
			String input="";
			stats[EXPERIENCE]=getExperience()-level*LEVEL_UP;
			level++;
			timeDelay(MEDIUM);
			System.out.println(getName()+" gained a level!");
			timeDelay(MEDIUM);
		//	battle.timeDelay(MEDIUM);
			System.out.println("---");
			System.out.println("You have "+LEVEL_UP_POINTS+" points to distribute! Enter five digits from 1-5 to assign a point to that stat (e.g. 11122 )");
			System.out.println("1. Health ");
			System.out.println("2. Strength ");
			System.out.println("3. Speed ");
			System.out.println("4. Intelligence ");
			System.out.println("5. Fatigue ");
			
			Scanner reader=new Scanner(System.in);
			//lazy code, fix later
			while(reader.hasNext()&&input.contentEquals("")) {
				
					input=reader.next();
					if(input.length()==5) {
						//reader.close();
						//input=reader.next();
						//System.out.println("YOU ENTERED"+input);
						break;
					}
					else {
						System.out.println("You must enter 5 digits");
						input="";
						reader.nextLine();
					}
				
				
			}

			for(int index=10;index<=100000;index=index*10) {
				statIncreaseInput(Integer.parseInt(input)%index/(index/10));
				
				//System.out.println("increase stat # "+Integer.parseInt(input)%index/(index/10));
			}

			
			System.out.println("Stats increased!");
			displayPlayerStats();
			levelUp();
		}
	}

}
