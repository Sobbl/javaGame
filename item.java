package textGame;

//add attacks to different iteams?
import java.util.Random;
public class item {
	private String description;
private String type;
private String stats;
private int position;
private int level;

private int stat;
private int bonus;



public static final int SWORD=1;
public static final int SHIELD=2;
public static final int WAND=3;
public static final int BOOK=4;
public static final int HELMET=5;
public static final int ARMOR=6;
public static final int GLOVES=7;
public static final int BOOTS=8;
public static final int POTION=9;
public static final int THROWABLE=10;

Random rand=new Random();
	public item(String description, String type, int position, int stat, int bonus, int level) {
		setDescription(description);
		setType(type);
		setPosition(position);
		setLevel(level);
		
	}
	
	public item(int type, int bonus, int stat, int level ) {
	
		
	
		generateBonus(bonus,stat, level);
		
		generateType(type);
		
		generateDescription(level);
		
		
	}

	public String getType() {
		return type;
	}

	public int getPosition() {
		return position;
	}

	public int getLevel() {
		return level;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getBonus() {
		return bonus;
	}
	
	public int getStat() {
		return stat;
	}
	
	public void setDescription(String description) {
		if(description!=null&&!description.contentEquals("")) {
			this.description=description;
		}
		else {this.description="a generic item";
		}
		}
	
	public void setType(String type) {
		if(type!=null&&!type.equals("")){
			this.type=type;
		}
	}
	public void generateType(int inputType) {
		int typeNum;
		
		if(inputType==0) {
		typeNum=rand.nextInt(10);
		}
		else {typeNum=inputType;}
		if(typeNum==SWORD) {
			type="sword";
			position=SWORD;
			
		}
		if(typeNum==BOOK) {
			type="book";
			position=BOOK;
		}
		if(typeNum==SHIELD) {
			type="shield";
			position=SHIELD;
		}
		if(typeNum==WAND) {
			type="wand";
			position=WAND;
		}
		if(typeNum==HELMET) {
			type="helmet";
			position=HELMET;
		}
		if(typeNum==ARMOR) {
			type="armor";
			position=ARMOR;
		}
		if(typeNum==GLOVES) {
			type="gloves";
			position=GLOVES;
		}
		if(typeNum==BOOTS) {
			type="boots";
			position=BOOTS;
		}
		if(typeNum==POTION) {
			type="potion";
			position=POTION;
		}
		if(typeNum==THROWABLE) {
			type="throwable";
			position=THROWABLE;
		}
		
	}
	
	public void generateDescription(int level) {
		
		String article1[]= {"This","The","A"};
		String adj2[]= {"shiny", "dirty", "old", "ancient", "new", "polished", "rusty", "large", "small", "heavy", "strange", "ugly", "beautiful"};
		String looks4[]= {"appears to be", "feels like", "seems it would be", "probably will be"};
		String descript5[]= {"covered in blood", "a great weapon", "useless", "useful", "well made"};
		String does6[]={"and gives", "and does", "and can do"};
		
		String statNames[]= {"health","strength", "speed", "intelligence", "fatigue"};
		stats= bonus+" bonus "+ statNames[stat];
		
		this.level=level;
		//"this ..adj..... type .....looks.....descript....and does .....stats"
		int r3=rand.nextInt(3);
		int r12=rand.nextInt(12);
		
		int r4=rand.nextInt(4);
		int r5=rand.nextInt(5);
		description=article1[r3]+" "+adj2[r12]+" "+type+" "+looks4[r4]+" "+descript5[r5]+" "+does6[r3]+" "+stats;
		type=adj2[r12]+" "+type;
		
	}
	
	public void generateBonus(int bonusInput, int statInput, int levelInput) {
		if(bonusInput==0) {
		bonus=1+levelInput+rand.nextInt(5)-Math.max(levelInput/2,1)+rand.nextInt(levelInput/3+1)+rand.nextInt(levelInput/3+1)+rand.nextInt(levelInput/3+1);

		
		}
		
		else{bonus=bonusInput;}
		if(statInput==0) {
		stat=rand.nextInt(5);
		}
		else {stat=statInput;
		}
		}
	

	public void setPosition(int position) {
		this.position = position;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setStat(int stat)
	{this.stat=stat;
	}
	
	public void setBonus(int bonus) {
		this.bonus=bonus;
	}
	
	
	public void displayDetails() {
		System.out.println("Description: "+description);
		System.out.println("Level "+level+" "+type+": "+stats);
		System.out.println("---");
		
	}
	
	
}
