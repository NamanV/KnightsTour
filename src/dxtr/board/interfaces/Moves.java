package dxtr.board.interfaces;

import java.util.EnumSet;

public enum Moves {

	NORTH(-3, 0), EAST(0, 3), WEST(0, -3), SOUTH(3, 0), // With 3 moves in one go
	NE(-2, 2), SE(2, 2), SW(2, -2), NW(-2, -2); // with 2 moves in one go

	int xAxis;
	int yAxis;

	Moves(int xAxis, int yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}

	public static int noOfMoves() {
		return EnumSet.allOf(Moves.class).size();
	}

	public static Moves getMoveAtIndex(int index) {
		return Moves.values()[index];
	}

	public int xAxis() {
		return this.xAxis;
	}

	public int yAxis() {
		return this.yAxis;
	}

}
