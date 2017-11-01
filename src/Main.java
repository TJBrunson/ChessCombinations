
import java.security.SecureRandom;


public class Main {
	
	public static void main(String[] args) {
		
		//initialize variables
		String[][] board = new String[8][8];
		String[] blackTeam;
		String[] whiteTeam;
		SecureRandom random = new SecureRandom();
		int[] randomsUsed = new int[16];
		int r = 0;
		
		//initialize arrays for pieces in order pawn, king, queen. 
		blackTeam = new String[]{"pawn","pawn","pawn","pawn","pawn","pawn","pawn","pawn","king","queen",
				"bishop","bishop","rook","rook","knight","knight"};
		whiteTeam = new String[]{"pawn","pawn","pawn","pawn","pawn","pawn","pawn","pawn","king","queen",
				"bishop","bishop","rook","rook","knight","knight"};
		
		//initialize empty board with the letter E
		for(int i=0; i<8; i++) {
			for(int k=0; k<8; k++) {
				board[i][k] = "E";
				System.out.print(board[i][k] + "    ");
			}
			System.out.println();
			System.out.println();
		}
		
		
	}
	
}
