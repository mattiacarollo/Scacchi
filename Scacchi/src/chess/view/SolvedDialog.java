package chess.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chess.controller.Controller;

public class SolvedDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

	public SolvedDialog(JFrame owner, final Controller controller) {
		super(owner, "Game Solved", true);

		add(new JLabel("<html><h1>Game Solved!</h1></html>"));
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	
				setVisible(false);
	          }
	        });

		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);

		pack();
	}
}