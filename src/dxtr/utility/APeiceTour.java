package dxtr.utility;

import dxtr.board.ChessBoard;
import dxtr.board.WarnsdorffsHeuristic;
import dxtr.board.interfaces.Traversal;
import dxtr.error.PeiceTourException;

public class APeiceTour {

	public static void main(String[] args) {

		int startingX = Integer.valueOf(args[0]);
		int startingY = Integer.valueOf(args[1]);
		Traversal traversal;
		try {
			traversal = new WarnsdorffsHeuristic(new ChessBoard(Constants.BOARD_SIZE, Constants.BOARD_SIZE));
			int count = 1;
			while (!traversal.findTour(startingX, startingY)) {
				System.out.println("Iteration number: " + count);
				count++;
			}
			traversal.printTour();
			System.out.printf("%d no of recursion to find the solution", count);
		} catch (PeiceTourException e) {
			System.out.println(e.getMessage());
		}

	}

}
