package chess.controller;

import chess.moves.Mover;
import chess.view.View;

public class Puzzle15Controller implements Controller {
	private final View view;
	private final Mover mover;
	//private final Solver solver;

	public Puzzle15Controller(View view) {
		this.view = view;
		this.mover = new Mover(view.getModel());
		//this.solver = new Solver(view.getModel());

		view.setController(this);
	}

	@Override
	public void onClick(int x, int y) {
		mover.moveAt(x, y);
		if (mover.isSolved())
			view.showSolvedDialog();
	}

//	@Override
//	public void init() {
//		do {
//			mover.init();
//		}
//		while (mover.isSolved());
//	}
	
}