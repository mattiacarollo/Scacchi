package chess.moves;

import chess.moves.Rules;
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
	
	public void init() {
		model.setConfiguration(new Rules(model.getConfiguration()).init(1000));
	}

}