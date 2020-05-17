package dxtr.utility;

import java.util.Scanner;

import dxtr.board.ChessBoard;
import dxtr.board.WarnsdorffsHeuristic;
import dxtr.board.interfaces.Traversal;
import dxtr.error.PeiceTourException;

public class APeiceTour {

	public static void main(String[] args) {
		System.out.println("Enter starting position for the piece as two space seperated integers (x,y) : ");
		Scanner sc = new Scanner(System.in);
//		int startingX = sc.nextInt();
//		int startingY = sc.nextInt();
		int startingX = Integer.valueOf(args[0]);
		int startingY = Integer.valueOf(args[1]);
		Traversal traversal;
		try {
			traversal = new WarnsdorffsHeuristic(new ChessBoard(Constants.BOARD_SIZE, Constants.BOARD_SIZE));
			int count = 1;
			while (!traversal.findTour(startingX, startingY)) {
				count++;
			}
			traversal.printTour();
			System.out.printf("%d recursion(s) to find the solution.", count);
		} catch (PeiceTourException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
	

}
