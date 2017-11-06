

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
		//System.out.println("White King: " +wKing[0] + "  " + wKing[1]);
		
		//send kings to be checked for check
		boolean bCheck = checker(board, bKing);
		
	}//end checkInit
	
	private static boolean checker(String[][] board, int[] kingPosition) {
		
		boolean inCheck = diagonalCheckUL(board, kingPosition); 
		if(inCheck == true) {
			System.out.println("DIAGONAL CHECK UL");
			return true;
		}
		inCheck = diagonalCheckUR(board,kingPosition);
		if(inCheck == true) {
			System.out.println("DIAGONAL CHECK UR");
			return true;
		}
		inCheck = diagonalCheckDL(board,kingPosition);
		if(inCheck == true) {
			System.out.println("DIAGONAL CHECK DL");
			return true;
		}
		inCheck = diagonalCheckDR(board,kingPosition);
		if(inCheck == true) {
			System.out.println("DIAGONAL CHECK DR");
			return true;
		}
		inCheck = knightCheck(board,kingPosition);
		if(inCheck == true) {
			System.out.println("KNIGHT CHECK");
			return true;
		}
		inCheck = uDLRCheck(board,kingPosition);
		if(inCheck == true) {
			System.out.println("UDLR CHECK");
			return true;
		}
		
		System.out.println("NO CHECKS");
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
		//System.out.println(checkPos[0]);
		//System.out.println(checkPos[1]);
		//System.out.println();
		
		boolean firstRun = true;
		while(checkPos[0] < 7 && checkPos[1]>=1) {
			checkPos[0]= checkPos[0]+1;
			checkPos[1]= checkPos[1]-1;
			
			//System.out.println(checkPos[0]);
			//System.out.println(checkPos[1]);
			//System.out.println();
			
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
	
	//check down and left diagonal
    private static boolean diagonalCheckDL(String[][] board, int[] kingPos) {
		
		//variables
		int[] checkPos = new int[2];
		checkPos[0] = kingPos[0];
		checkPos[1] = kingPos[1];
		//System.out.println(checkPos[0]);
		//System.out.println(checkPos[1]);
		//System.out.println();
		
		boolean firstRun = true;
		while(checkPos[0] >= 1 && checkPos[1]<7) {
			checkPos[0]= checkPos[0]-1;
			checkPos[1]= checkPos[1]+1;
			
			//System.out.println(checkPos[0]);
			//System.out.println(checkPos[1]);
			//System.out.println();
			
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
    
    //check down and right diagonal
    private static boolean diagonalCheckDR(String[][] board, int[] kingPos) {
		
		//variables
		int[] checkPos = new int[2];
		checkPos[0] = kingPos[0];
		checkPos[1] = kingPos[1];
		//System.out.println(checkPos[0]);
		//System.out.println(checkPos[1]);
		//System.out.println();
		
		boolean firstRun = true;
		while(checkPos[0] < 7 && checkPos[1]<7) {
			checkPos[0]= checkPos[0]+1;
			checkPos[1]= checkPos[1]+1;
			
			//System.out.println(checkPos[0]);
			//System.out.println(checkPos[1]);
			//System.out.println();
			
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

    //check for rook
    private static boolean knightCheck(String[][] board, int[] kingPos) {
    	
    		
    		//set check variables so kingPos can stay constant
    		int[] checkPos = new int[2];
    		checkPos[0] = kingPos[0];
    		checkPos[1] = kingPos[1];
    		//left 1, up 2
    		if(checkPos[0] > 0 && checkPos[1]>1) {
    			checkPos[0] = checkPos[0]-1;
    			checkPos[1] = checkPos[1]-2;
    			System.out.println(board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1] );
    			
    			if(board[checkPos[1]][checkPos[0]] == "Wrook") {
    				return true;
    			}
    		}//end left 1, up 2
    		
    		//left 1, down 2
    		checkPos[0] = kingPos[0];
    		checkPos[1] = kingPos[1];
    		if(checkPos[0]>0 && checkPos[1]<6) {
    			checkPos[0] = checkPos[0]-1;
    			checkPos[1] = checkPos[1]+2;
    			System.out.println(board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1] );
    			
    			if(board[checkPos[1]][checkPos[0]] == "Wrook") {
    				return true;
    			}
    		}
    		
    		//left 2, down 1
    		checkPos[0] = kingPos[0];
    		checkPos[1] = kingPos[1];
    		if(checkPos[0]>1 && checkPos[1]<7) {
    			checkPos[0] = checkPos[0]-2;
    			checkPos[1] = checkPos[1]+1;
    			System.out.println(board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1] );
    			if(board[checkPos[1]][checkPos[0]] == "Wrook") {
    				return true;
    			}
    		}
    		
    		//left 2, up 1
    		checkPos[0] = kingPos[0];
    		checkPos[1] = kingPos[1];
    		if(checkPos[0]>1 && checkPos[1]>0) {
    			checkPos[0] = checkPos[0]-2;
    			checkPos[1] = checkPos[1]-1;
    			System.out.println(board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1] );
    			if(board[checkPos[1]][checkPos[0]] == "Wrook") {
    				return true;
    			}
    		}
    		
    		//right 1, up 2
    		checkPos[0] = kingPos[0];
    		checkPos[1] = kingPos[1];
    		if(checkPos[0]<7 && checkPos[1]>1) {
    			checkPos[0] = checkPos[0]+1;
    			checkPos[1] = checkPos[1]-2;
    			System.out.println(board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1] );
    			
    			if(board[checkPos[1]][checkPos[0]] == "Wrook") {
    				return true;
    			}
    		}
    		
    		//right 1, down 2
    		checkPos[0] = kingPos[0];
    		checkPos[1] = kingPos[1];
    		if(checkPos[0]<7 && checkPos[1]<6) {
    			checkPos[0] = checkPos[0]+1;
    			checkPos[1] = checkPos[1]+2;
    			System.out.println(board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1] );
    			
    			if(board[checkPos[1]][checkPos[0]] == "Wrook") {
    				return true;
    			}
    		}
    		
    		//right 2, up 1
    		checkPos[0] = kingPos[0];
    		checkPos[1] = kingPos[1];
    		if(checkPos[0]<6 && checkPos[1]>0) {
    			checkPos[0] = checkPos[0]+2;
    			checkPos[1] = checkPos[1]-1;
    			System.out.println(board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1] );
    			if(board[checkPos[1]][checkPos[0]] == "Wrook") {
    				return true;
    			}
    		}
    		
    		//right 2, down 1
    		checkPos[0] = kingPos[0];
    		checkPos[1] = kingPos[1];
    		if(checkPos[0]<6 && checkPos[1]<7) {
    			checkPos[0] = checkPos[0]+2;
    			checkPos[1] = checkPos[1]+1;
    			System.out.println(board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1] );
    			if(board[checkPos[1]][checkPos[0]] == "Wrook") {
    				return true;
    			}
    		}
    		
    		return false;
    }

    private static boolean uDLRCheck(String[][] board, int[] kingPos) {
    	
    		//set check variables so kingPos can stay constant
		int[] checkPos = new int[2];
		checkPos[0] = kingPos[0];
		checkPos[1] = kingPos[1];
		
		//check up
		while(checkPos[1]>0) {
			checkPos[1]=checkPos[1]-1;
			
			if(board[checkPos[1]][checkPos[0]] == "Wqueen" || board[checkPos[1]][checkPos[0]] == "Wrook") {
				System.out.println("Up Check: " + board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1]);
				return true;
			}//end if check
			else if(board[checkPos[1]][checkPos[0]] != "E" && (board[checkPos[1]][checkPos[0]] != "Wqueen" || board[checkPos[1]][checkPos[0]] == "Wrook")) {
				System.out.println("no check up");
				break;
			}
		}// end up while
		
		//reset checkPos and check left
		checkPos[0] = kingPos[0];
		checkPos[1] = kingPos[1];
		while(checkPos[0]>0) {
			checkPos[0]-=1;
			
			if(board[checkPos[1]][checkPos[0]] == "Wqueen" || board[checkPos[1]][checkPos[0]] == "Wrook") {
				System.out.println("Left Check: " + board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1]);
				return true;
			}//end if check
			else if(board[checkPos[1]][checkPos[0]] != "E" && (board[checkPos[1]][checkPos[0]] != "Wqueen" || board[checkPos[1]][checkPos[0]] == "Wrook")) {
				System.out.println("no check left");
				break;
			}
		}//end left check while
		
		//reset checkPos and check down
		checkPos[0] = kingPos[0];
		checkPos[1] = kingPos[1];
		while(checkPos[1]<7) {
			checkPos[1]+=1;
			
			if(board[checkPos[1]][checkPos[0]] == "Wqueen" || board[checkPos[1]][checkPos[0]] == "Wrook") {
				System.out.println("Down Check: " + board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1]);
				return true;
			}//end if check
			else if(board[checkPos[1]][checkPos[0]] != "E" && (board[checkPos[1]][checkPos[0]] != "Wqueen" || board[checkPos[1]][checkPos[0]] == "Wrook")) {
				System.out.println("no check down");
				break;
			}
		}//end down check while
		
		//reset checkPos and check right
		checkPos[0] = kingPos[0];
		checkPos[1] = kingPos[1];
		while(checkPos[0]<7) {
			checkPos[0]+=1;
			
			if(board[checkPos[1]][checkPos[0]] == "Wqueen" || board[checkPos[1]][checkPos[0]] == "Wrook") {
				System.out.println("Right Check: " + board[checkPos[1]][checkPos[0]] + ' ' + checkPos[0] + ' ' + checkPos[1]);
				return true;
			}//end if check
			else if(board[checkPos[1]][checkPos[0]] != "E" && (board[checkPos[1]][checkPos[0]] != "Wqueen" || board[checkPos[1]][checkPos[0]] == "Wrook")) {
				System.out.println("no check Right");
				break;
			}
		}//end right check while
				
    		return false;
    }//end UDLR checks

}//end CheckCheck
