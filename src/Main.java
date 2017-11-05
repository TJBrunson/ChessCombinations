import java.security.SecureRandom;


public class Main {
	
	public static void main(String[] args) {
		
		//initialize variables
		String[][] board = new String[8][8];
		String[] blackTeam;
		String[] whiteTeam;
		SecureRandom random = new SecureRandom();
		int randomBoardSize=8;
		int randomPieceNum=16;
		int randOne = 0;
		int randTwo = 0;
		int randThree = 0;
		int randFour = 0;
		int randPiece=0;
		int[] pieceUsed= new int[16];
		int counter=0;
		int fpCounter=0; //finished placing counter
		boolean finishedPlacing=false;
		
		//initialize arrays for pieces in order pawn, king, queen. 
		blackTeam = new String[]{"Wpawn","Wpawn","Wpawn","Wpawn","Wpawn","Wpawn","Wpawn","Wpawn","Wking","Wqueen",
				"Wbishop","Wbishop","Wrook","Wrook","Wknight","Wknight"};
		whiteTeam = new String[]{"Bpawn","Bpawn","Bpawn","Bpawn","Bpawn","Bpawn","Bpawn","Bpawn","Bking","Bqueen",
				"Bbishop","Bbishop","Brook","Brook","Bknight","Bknight"};
		
		//initialize empty board with the letter E
		for(int i=0; i<8; i++) {
			for(int k=0; k<8; k++) {
				board[i][k] = "E";
			}
		}
		//set pieceUsed Values
		for(int i=0; i<pieceUsed.length; i++) {
			pieceUsed[i]=100;
		}
		
		//place pieces randomly on board
		while(finishedPlacing==false) {
			randOne = random.nextInt(randomBoardSize);
			randTwo = random.nextInt(randomBoardSize);
			randThree = random.nextInt(randomBoardSize);
			randFour = random.nextInt(randomBoardSize);
			
			//check if place has a piece and place pieces
			if(board[randOne][randTwo] == "E" && board[randThree][randFour]== "E") {
				
				//check if random number piece has been used
				randPiece = random.nextInt(randomPieceNum);
				boolean isUsed = false;
				for(int i=0;i<16;i++) {
					if(randPiece == pieceUsed[i]) {
						isUsed=true;
					}
				}
				
				//place pieces
				if(isUsed==false) {
					//place black piece
					board[randOne][randTwo] = blackTeam[randPiece];
					//place white piece
					board[randThree][randFour] = whiteTeam[randPiece];
					
					//remember piece that was placed;
					pieceUsed[counter] = randPiece;
					counter++;
				}
				isUsed=false;
			}
			
			//check to see if all pieces are placed
			if(counter==16) {
				finishedPlacing=true;
			}
			//to print used counter
			/*for(int i=0; i<16; i++) {
				System.out.print(pieceUsed[i] + "   ");
				
			}
			System.out.println();*/
			
			
			//check how many pieces were placed
			for(int i=0; i<8; i++) {
				for(int k=0; k<8; k++) {
					if(board[i][k] == "E") {
						fpCounter++;
					}
				}
			}
			
			if(finishedPlacing==true) {
				System.out.println(fpCounter);
			}
			fpCounter=0;
		}//end while
		
		printBoard(board);
		//pieceCount(board);
		CheckCheck.checkInit(board);
		
	}
	
	//print board
	private static void printBoard(String[][] boardToPrint) {
		System.out.println();
		
		for(int i=0; i<8; i++) {
			for(int k=0; k<8; k++) {
				System.out.print(boardToPrint[i][k] + "         ");
			}
			System.out.println();
			System.out.println();
		}
		
	}
	
	private static void pieceCount(String[][] board) {
		int bpawn = 0;
		int wpawn = 0;
		int brook = 0;
		int wrook = 0;
		int bbishop = 0;
		int wbishop = 0;
		int bknight = 0;
		int wknight = 0;
		int bking = 0;
		int wking = 0;
		int bqueen=0;
		int wqueen = 0;
		
		for(int i=0; i<8; i++) {
			for(int k=0; k<8; k++) {
				if(board[i][k] == "Wpawn") {
					wpawn++;
				}
				if(board[i][k] == "Bpawn") {
					bpawn++;
				}
				if(board[i][k] == "Wbishop") {
					wbishop++;
				}
				if(board[i][k] == "Bbishop") {
					bbishop++;
				}
				if(board[i][k] == "Wrook") {
					wrook++;
				}
				if(board[i][k] == "Brook") {
					brook++;
				}
				if(board[i][k] == "Wknight") {
					wknight++;
				}
				if(board[i][k] == "Bknight") {
					bknight++;
				}
				if(board[i][k] == "Wking") {
					wking++;
				}
				if(board[i][k] == "Bking") {
					bking++;
				}
				if(board[i][k] == "Wqueen") {
					wqueen++;
				}
				if(board[i][k] == "Bqueen") {
					bqueen++;
				}
			}
		}
		
		//print piece numbers
		System.out.println("black pawns: " +bpawn);
		System.out.println("white pawns: " + wpawn);
		System.out.println("black rook: " +brook);
		System.out.println("white rook: " + wrook);
		System.out.println("black bishop: " + bbishop);
		System.out.println("white bishop: " + wbishop);
		System.out.println("black knight: " + bknight);
		System.out.println("whight knight: " + wknight);
		System.out.println("black king: " + bking);
		System.out.println("white king: " + wking);
		System.out.println("black queen: " + bqueen);
		System.out.println("white queen: " + wqueen);
	}
	
}
