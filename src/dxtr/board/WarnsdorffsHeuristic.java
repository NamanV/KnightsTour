package dxtr.board;

import dxtr.board.interfaces.Board;
import dxtr.board.interfaces.Traversal;
import dxtr.error.ErrorCode;
import dxtr.error.PeiceTourException;
import dxtr.utility.Constants;

public class WarnsdorffsHeuristic implements Traversal {

	private Board board;
	private int startingX, startingY;

	public WarnsdorffsHeuristic(Board board) {
		this.board = board;
	}

	@Override
	public boolean findTour(int startingX, int startingY) throws PeiceTourException {

		if (!board.isValidMove(startingX, startingY)) {
			throw new PeiceTourException(ErrorCode.INVALID_STARTING_POSITION);
		}
		
		// initialize each cell of the board as not visited
		board.initBoard();
		
		this.startingX = startingX;
		this.startingY = startingY;
		int moveNumber = 1;
		
		// set the starting position as the first move
		board.getBoard()[this.startingX][this.startingY] = moveNumber;

		// loop through all moves, each next move using Warnsdorff's heuristic
		for (moveNumber = 2; moveNumber <= board.getBoardSizeXAxis() * board.getBoardSizeYAxis(); moveNumber++) {
			if (!move(moveNumber)) {
				return false;
			}
		}

		return isTourSucessfull();
	}

	// If all the cell's have been visited then tour is successful
	private boolean isTourSucessfull() {
		for (int x = 0; x < board.getBoardSizeXAxis(); x++) {
			for (int y = 0; y < board.getBoardSizeYAxis(); y++) {
				if (board.getBoard()[x][y] == Constants.CELL_DEFAULT_VALUE) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * Count of empty valid moves adjacent to (x, y)
	 * 
	 * @param coordinates of the current cell
	 */
	private int getWarnsdorffDegree(int x, int y) {
		int noOfPossibleMoves = 0;
		for (int i = 0; i < Moves.noOfMoves(); i++) {
			Moves move = Moves.getMoveAtIndex(i);
			if (isMovePossible((x + move.xAxis()), (y + move.yAxis()))) {
				noOfPossibleMoves++;
			}
		}

		return noOfPossibleMoves;
	}

	private boolean isMovePossible(int x, int y) {
		return board.isValidMove(x, y) && !board.isVisited(x, y);
	}

	private boolean move(int currentMove) {
		
		int minimumWarnsdorffDegreeIndex = -1, minimumWarnsdorffDegree = board.getBoardSizeXAxis() + 1;
		int nextX, nextY;
		int warnsdorffDegree;
		Moves move;

		// Finding a valid move with least possible degree
		for (int index = 0; index < Moves.noOfMoves(); index++) {
			move = Moves.getMoveAtIndex(index);
			nextX = startingX + move.xAxis();
			nextY = startingY + move.yAxis();
			if (isMovePossible(nextX, nextY)) {
				warnsdorffDegree = getWarnsdorffDegree(nextX, nextY);
				if (warnsdorffDegree < minimumWarnsdorffDegree) {
					minimumWarnsdorffDegree = warnsdorffDegree;
					minimumWarnsdorffDegreeIndex = index;
				}
			}
		}

		// if no valid moves possible
		if (minimumWarnsdorffDegreeIndex < Constants.MINIMUM_INDEX) {
			return false;
		}

		move = Moves.getMoveAtIndex(minimumWarnsdorffDegreeIndex);
		startingX = startingX + move.xAxis();
		startingY = startingY + move.yAxis();
		board.getBoard()[startingX][startingY] = currentMove;
		
		return true;
	}

	@Override
	public void printTour() {
		board.printTour();
	}
}
