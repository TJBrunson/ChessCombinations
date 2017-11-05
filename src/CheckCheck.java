

public class CheckCheck {
	
	//accept variables from Main
	protected static void checkInit(String[][] board) {
		
		//variables for king locations
		int[] bKing = new int[2];
		int[] wKing = new int[2];
		
		//check for positions of the two kings
		for(int i=0; i<board.length; i++) {
			for(int k=0; k<board.length; k++) {
				if(board[i][k] == "Bking") {
					bKing[0]=k;
					bKing[1]=i;
				}
				if(board[i][k]=="Wking"){
					wKing[0]=k;
					wKing[1]=i;
				}
			}//end inner for
		}//end outer for
		
		System.out.println("Black King: " +bKing[0] + "  " + bKing[1]);
		System.out.println("White King: " +wKing[0] + "  " + wKing[1]);
		
		//send kings to be checked for check
		boolean bCheck = checker(board, bKing);
		
	}//end checkInit
	
	private static boolean checker(String[][] board, int[] kingPosition) {
		
		boolean inCheck = diagonalCheckUL(board, kingPosition); 
		if(inCheck == true) {
			return true;
		}
		inCheck = diagonalCheckUR(board,kingPosition);
		if(inCheck == true) {
			return true;
		}
		
		return false;
	}//end checker
	
	//check up and left diagonal
	private static boolean diagonalCheckUL(String[][] board, int[] kingPos) {
		
		//variables
		int[] checkPos = new int[2];
		checkPos[0] = kingPos[0];
		checkPos[1] = kingPos[1];
		//System.out.println(checkPos[0]);
		//System.out.println(checkPos[1]);
		//System.out.println();
		
		boolean firstRun = true;
		while(checkPos[0] >= 1 && checkPos[1]>=1) {
			checkPos[0]= checkPos[0]-1;
			checkPos[1]= checkPos[1]-1;
			
			//System.out.println(checkPos[0]);
			//System.out.println(checkPos[1]);
			//System.out.println();
			
			if(firstRun==true && board[checkPos[1]][checkPos[0]] == "Wpawn") {
				System.out.println("Check found pawn " + board[checkPos[1]][checkPos[0]]+ ' ' + checkPos[0] + ' ' + checkPos[1]);
				return true;
			}
			if(board[checkPos[1]][checkPos[0]] == "Wbishop" || board[checkPos[1]][checkPos[0]] == "Wqueen") {
				System.out.println("Check found bish or qwueen " + board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1]);
				return true;
			}
			else if(board[checkPos[1]][checkPos[0]].substring(0)!="E") {
				System.out.println("Check not found " + board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1]);
				return false;
			}
			
			firstRun=false;
		}
		
		
		System.out.println("All EZ");
		return false;
	}
	
	//check up and right diagonal
	private static boolean diagonalCheckUR(String[][] board, int[] kingPos) {
		
		//variables
		int[] checkPos = new int[2];
		checkPos[0] = kingPos[0];
		checkPos[1] = kingPos[1];
		System.out.println(checkPos[0]);
		System.out.println(checkPos[1]);
		System.out.println();
		
		boolean firstRun = true;
		while(checkPos[0] < 8 && checkPos[1]>=1) {
			checkPos[0]= checkPos[0]+1;
			checkPos[1]= checkPos[1]-1;
			
			System.out.println(checkPos[0]);
			System.out.println(checkPos[1]);
			System.out.println();
			
			if(firstRun==true && board[checkPos[1]][checkPos[0]] == "Wpawn") {
				System.out.println("Check found pawn " + board[checkPos[1]][checkPos[0]]+ ' ' + checkPos[0] + ' ' + checkPos[1]);
				return true;
			}
			if(board[checkPos[1]][checkPos[0]] == "Wbishop" || board[checkPos[1]][checkPos[0]] == "Wqueen") {
				System.out.println("Check found bish or queen " + board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1]);
				return true;
			}
			else if(board[checkPos[1]][checkPos[0]].substring(0)!="E") {
				System.out.println("Check not found " + board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1]);
				return false;
			}
			
			firstRun=false;
		}
		
		
		System.out.println("All EZ");
		return false;
	}
	
}
