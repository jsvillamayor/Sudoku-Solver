
public class Main {
	
	private static final int GRID_SIZE = 9;

	public static void main(String[] args) {
		
		int[][] board = {
				{9,0,0,	0,4,3,	1,0,0},
				{0,0,0,	0,0,2,	0,0,0},
				{0,0,8,	0,0,0,	0,9,0},
				
				{8,0,0,	0,1,9,	3,0,0},
				{0,5,0,	0,0,0,	0,0,7},
				{0,0,0,	6,0,0,	0,0,0},
				
				{0,0,0,	8,0,0,	0,0,0},
				{0,0,7,	0,6,0,	0,0,0},
				{4,0,0,	2,0,0,	0,0,0},
				};
		
		/*	{0,0,0,	0,0,0,	0,0,0},
			{0,0,0,	0,0,0,	0,0,0},
			{0,0,0,	0,0,0,	0,0,0},
		
			{0,0,0,	0,0,0,	0,0,0},
			{0,0,0,	0,0,0,	0,0,0},
			{0,0,0,	0,0,0,	0,0,0},
		
			{0,0,0,	0,0,0,	0,0,0},
			{0,0,0,	0,0,0,	0,0,0},
			{0,0,0,	0,0,0,	0,0,0},	blank template of sudoku board*/
		
		if(!solveBoard(board)) {
			System.out.println("This board is not solvable!");
		}
		else {
			System.out.println("The board has been solved!\n");
			printBoard(board);
		}

	}
	
	private static boolean inSameRow(int[][] board, int row, int number) {
		
		for(int i=0;i<GRID_SIZE;i++) {
			
			if(board[row][i] == number)
				return true;
		}
		
		return false;
		
	}
	
	private static boolean inSameColumn(int[][] board, int column, int number) {
		
		for(int i=0;i<GRID_SIZE;i++) {
			
			if(board[i][column] == number)
				return true;
		}
		
		return false;
		
	}

	private static boolean inLocalSquare(int[][] board, int row, int column, int number) {
		
		for(int i=0;i<3;i++) {
			
			for(int j=0;j<3;j++) {
				
				if(board[row-(row%3)+i][column-(column%3)+j]==number) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	private static boolean isValid(int[][] board, int row, int column, int number) {
		
		if(!inSameRow(board, row, number)	&&	!inSameColumn(board, column, number)	&&	!inLocalSquare(board, row, column, number))
			return true;
		else
			return false;
		
	}
	
	private static boolean solveBoard(int[][] board) {
		
		for(int i=0;i<GRID_SIZE;i++) {
			for(int j=0;j<GRID_SIZE;j++) {
				
				if(board[i][j]==0) {
					
					for(int number2try=1;number2try<=GRID_SIZE;number2try++) {
						
						if(isValid(board, i, j, number2try)) {
							board[i][j] = number2try;
							if(solveBoard(board))
								return true;
							else
								board[i][j] = 0;
							
						}
						
					}
					
					return false;
					
				}
				
			}
		}
		
		return true;
		
	}
	
	private static void printBoard(int[][] board) {
		
		for(int row=0;row<GRID_SIZE;row++) {
			if(row%3==0 && row!=0)
				System.out.println("-----------");
			for(int column=0;column<GRID_SIZE;column++) {
				if(column%3==0 && column!=0)
					System.out.print("|");
				System.out.print(board[row][column]);
			}
			System.out.println();
		}
		
	}
}




