package textGame;
import java.util.Random;
public class test {
	Random rand=new Random();
	private int levelInput;
	private double z[];
	
	
	public test() {
	
		levelInput=1;
		z=new double[1000];
	}
	public void testLoop() {
		
		for(levelInput=1; levelInput<100;levelInput++) {
	int y=0;
	int max=0;
	int min=100;
	double avg=0;
	double sum=0;
	//double z[1000];
	double variance=0;
	double standardDeviation=0;
	
	for(int x=1; x<1000; x++) {
		y=levelInput+rand.nextInt(5)-Math.max(levelInput/2,1)+rand.nextInt(levelInput/3+1)+rand.nextInt(levelInput/3+1)+rand.nextInt(levelInput/3+1);
		z[x]=y;
		max=Math.max(max,  y);
		min=Math.min(min,  y);
		sum+=y;
	}
	avg=sum/1000;
	for(int x=1; x<1000; x++) {
		variance+=(z[x]-avg)*(z[x]-avg);
	}
	standardDeviation=Math.sqrt(variance/1000);
	
	System.out.println("level "+levelInput+ " average="+avg+" max="+max+" min="+min+" standard deviation="+standardDeviation);
	}
	}
	
	public void mod() {
		System.out.println(123%1000/100);
	}
	public static void main(String[] args) {
		//System.out.println(1/3);
		test test1=new test();
		//test1.testLoop();
		test1.mod();
	}

}
