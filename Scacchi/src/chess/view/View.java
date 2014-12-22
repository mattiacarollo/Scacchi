package chess.view;

import chess.controller.Controller;
import chess.model.Model;

public interface View {
	Model getModel();
	void setController(Controller controller);

	// 3: change your display
	void showSolvedDialog();

	// 4: I've changed
	void onConfigurationChange();
}