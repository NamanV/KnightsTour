package dxtr.board.interfaces;

public interface Board {

	// Checks the validity of the move
	public boolean isValidMove(int x, int y);

	// Checks if the cell is already visited
	public boolean isVisited(int x, int y);

	public void initBoard();

	public void printTour();
	
	public int[][] getBoard();
	
	public int getBoardSizeXAxis();
	public int getBoardSizeYAxis();
	
}
