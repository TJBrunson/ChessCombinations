

public class CheckCheck {

	protected static void checkInit(String[][] board) {
		
		//variables for king locations
		int[] bKing = new int[2];
		int[] wKing = new int[2];
		
		//check for positions of the two kings
		for(int i=0; i<board.length; i++) {
			for(int k=0; k<board.length; k++) {
				if(board[i][k] == "Bking") {
					bKing[0]=i;
					bKing[1]=k;
				}
				if(board[i][k]=="Wking"){
					wKing[0]=i;
					wKing[1]=k;
				}
			}//end inner for
		}//end outer for
		
		System.out.println("Black King: " +bKing[0] + "  " + bKing[1]);
		System.out.println("White King: " +wKing[0] + "  " + wKing[1]);
		
	}//end checkInit
	
}
