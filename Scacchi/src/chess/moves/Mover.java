package chess.moves;

import chess.model.Model;

public class Mover {
	private final Model model;

	public Mover(Model model) {
		this.model = model;
	}

	public boolean isSolved() {
		return new Rules(model.getConfiguration()).isSolved();
	}

	public void moveAt(int x, int y) {
		model.setConfiguration(new Rules(model.getConfiguration()).afterMovingAt(x, y));
	}

	public void randomize() {
		model.setConfiguration(new Rules(model.getConfiguration()).randomize(1000));
	}
}