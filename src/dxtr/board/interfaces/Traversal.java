package dxtr.board.interfaces;

import dxtr.error.PeiceTourException;

public interface Traversal {

	public boolean findTour(int startingX, int startingY) throws PeiceTourException;

	public void printTour();

}
