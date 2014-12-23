package chess.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chess.controller.Controller;
import chess.model.Model;

public class TilesPanel extends JPanel implements View, ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private final JFrame frame;
	private final Model model;
	private Controller controller;
	private final JButton[][] buttons = new JButton[8][8];
	
	//Restituisce una ImageIcon, null se il percorso non è valido 
    private ImageIcon createImageIcon(String path){
        java.net.URL imgURL = this.getClass().getResource(path);
        if (imgURL != null){
            return new ImageIcon(imgURL);
        }else{
            System.err.println("File non trovato: "+path);
            return null;
        }
    }

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
		setLayout(new GridLayout(8, 8));
		int color = 0; // 0 white, 1 black
		
		for (int y = 0; y < 8; y++){			
			for (int x = 0; x < 8; x++){
				add(buttons[x][y] = mkButton(x, y, model.at(x, y), color));
				color = 1 - color;
			}
			//cambio colore riga successiva
			color = 1 - color;
		}
	}

	private JButton mkButton(final int x, final int y, String pathPedina, int color) {
		JButton button = new JButton(createImageIcon(pathPedina));
		
		//assegno colore casella
		if (color == 0)
			button.setBackground(Color.WHITE);
		else
			button.setBackground(Color.BLACK);
			
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
	//controlla se la casella affianco è vuota
	//allora la scambia, altrimenti non fa nulla
	//nel model corrisponde al metodo "swap()" file:LongBackedConfiguration.java
	public void onConfigurationChange() {
//		for (int y = 0; y < 8; y++)
//			for (int x = 0; x < 8; x++)
//				buttons[x][y].setText(model.at(x, y) == 0 ?
//					"" : String.valueOf(model.at(x, y)));
	}

	@Override
	public void showSolvedDialog() {
		new SolvedDialog(frame, controller).setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){		

	}
}