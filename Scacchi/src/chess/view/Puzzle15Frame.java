package chess.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chess.controller.Controller;
import chess.controller.Puzzle15Controller;
import chess.model.LongBackedConfiguration;
import chess.model.TilesModel;

public class Puzzle15Frame extends JFrame {
	private final TilesModel model = new TilesModel(new LongBackedConfiguration());
	private final Controller controller;

	public Puzzle15Frame() {
		setTitle("Puzzle 15");

		View view = addTiles();
		controller = new Puzzle15Controller(view);
		controller.randomize();
		addControlButtons();

		
		setIconImage(new ImageIcon("img/puzzle15.jpg").getImage());

		pack();
	}

	private void addControlButtons() {
		JPanel panel = new JPanel();
		
		JButton randomize = new JButton("Randomize");
		randomize.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	controller.randomize();
	          }
	        });
		panel.add(randomize);

		JButton hint = new JButton("Hint");
		hint.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	controller.giveHint();
	          }
	        });
		panel.add(hint);

		add(panel, BorderLayout.NORTH);
	}

	private View addTiles() {
		TilesPanel panel = new TilesPanel(model, this);
		add(panel, BorderLayout.CENTER);

		return panel;
	}

	private static final long serialVersionUID = 1L;
}