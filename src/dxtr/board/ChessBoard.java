package dxtr.board;

import dxtr.board.interfaces.Board;
import dxtr.error.ErrorCode;
import dxtr.error.PeiceTourException;
import dxtr.utility.Constants;

public class ChessBoard implements Board {

	private int[][] board;
	private int boardSizeX;
	private int boardSizeY;

	public ChessBoard(int boardSizeX, int boardSizeY) throws PeiceTourException {

		if (boardSizeX < Constants.MINIMUM_BOARD_SIZE || boardSizeY < Constants.MINIMUM_BOARD_SIZE) {
			throw new PeiceTourException(ErrorCode.INVALID_BOARD);
		}
		
		if(boardSizeX != boardSizeY) {
			throw new PeiceTourException(ErrorCode.INVALID_BOARD_SIZE);
		}
		

		this.boardSizeX = boardSizeX;
		this.boardSizeY = boardSizeY;
		this.board = new int[this.boardSizeX][this.boardSizeY];
	}

	@Override
	public void initBoard() {
		for (int i = 0; i < this.boardSizeX; i++) {
			for (int j = 0; j < this.boardSizeY; j++) {
				board[i][j] = Constants.CELL_DEFAULT_VALUE;
			}
		}
	}

	@Override
	public void printTour() {
		for (int i = 0; i < this.boardSizeX; i++) {
			for (int j = 0; j < this.boardSizeY; j++) {
				System.out.printf("%d\t", this.board[i][j]);
			}
			System.out.println("");
		}
	}

	@Override
	public boolean isVisited(int x, int y) {
		return this.board[x][y] > Constants.CELL_DEFAULT_VALUE;
	}

	@Override
	public boolean isValidMove(int x, int y) {
		return (x >= 0 && y >= 0 && x < this.boardSizeX && y < this.boardSizeY);
	}

	@Override
	public int[][] getBoard() {
		return this.board;
	}

	@Override
	public int getBoardSizeXAxis() {
		return this.boardSizeX;
	}

	@Override
	public int getBoardSizeYAxis() {
		return this.boardSizeY;
	}
}
