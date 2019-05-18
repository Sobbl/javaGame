package textGame;
import java.util.Scanner;

public class ScanUtil {
private Scanner reader;
private int userInput;
private String words;
	public ScanUtil() {
System.out.println("PREPARING FOR INPUT");
		readInput();
	}
	
	public void readInput() {
		reader=new Scanner(System.in);
		System.out.println("just before while loop for scanner");
		while(reader.hasNext()){
			
				userInput=reader.nextInt();
			
			words=reader.next();
		}
		System.out.println("you entered "+userInput);
		System.out.println("...or you entered "+words);
	}
	
	public static void main(String[] args) {
		
	}
}
