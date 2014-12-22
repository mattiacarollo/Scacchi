package chess.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import chess.controller.Controller;
import chess.model.Model;

public class TilesPanel extends JPanel implements View, ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private final JFrame frame;
	private final Model model;
	private Controller controller;
	private final JButton[][] buttons = new JButton[4][4];

	public TilesPanel(Model model, JFrame frame) {
		this.frame = frame;
		this.model = model;

		createButtons();

		model.setView(this);
	}

	@Override
	public Model getModel() {
		return model;
	}

	private void createButtons() {
		setLayout(new GridLayout(4, 4));

		for (int y = 0; y < 4; y++)
			for (int x = 0; x < 4; x++)
				add(buttons[x][y] = mkButton(x, y, model.at(x, y)));
	}

	private JButton mkButton(final int x, final int y, int value) {
		JButton button = new JButton(value == 0 ? "" : String.valueOf(value));
		button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	if (controller != null)
					controller.onClick(x, y);
	          }
	        });

		return button;
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void onConfigurationChange() {
		for (int y = 0; y < 4; y++)
			for (int x = 0; x < 4; x++)
				buttons[x][y].setText(model.at(x, y) == 0 ?
					"" : String.valueOf(model.at(x, y)));
	}

	@Override
	public void showSolvedDialog() {
		new SolvedDialog(frame, controller).setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){		

	}


}