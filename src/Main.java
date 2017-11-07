import java.security.SecureRandom;


public class Main {
	
	public static void main(String[] args) {
		
		double numberOfRounds=10000000;
		double checksCounter = 0;
		
		for(int i=1; i<numberOfRounds; i++) {
			//run a single round of board generation and checks
			boolean check = RunRound.round();
			
			//if check found, add check to the counter
			if(check == true) {
				checksCounter++;
			}
		}//end for loop
		
		//print statements
		System.out.println("The Program ran " + numberOfRounds + " times.");
		System.out.println("The Black King was in check " + checksCounter + " times.");
		double probability = (checksCounter/numberOfRounds);
		System.out.println("The probability the Black King is in check is: " + probability);
		
	}//end main method

}
