package chess.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import chess.controller.*;
import chess.model.*;

public class ScacchiFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private final TilesModel model = new TilesModel(new LongBackedConfiguration());
//	private final Controller controller;
	
	JMenu menu;
	JMenuItem menuItem;
	Image frame_icon = Toolkit.getDefaultToolkit().getImage("");
	ImageIcon exit_icon = createImageIcon("/icon/close.jpg");
	ImageIcon exitItem_icon = createImageIcon("/icon/closeItem.jpg");
	ImageIcon error_icon = createImageIcon("/icon/error.png");
	ImageIcon new_icon = createImageIcon("/icon/new.png");
	ImageIcon info_icon = createImageIcon("/icon/info.png");
	ImageIcon infoItem_icon = createImageIcon("/icon/infoItem.png");
	ImageIcon tutorial_icon = createImageIcon("/icon/tutorial.png");
	ImageIcon tutorialItem_icon = createImageIcon("/icon/tutorialItem.png");

	public ScacchiFrame() {
		setTitle("Gioca a Scacchi");

		View view = addTiles();
//		controller = new Puzzle15Controller(view);
//		controller.init();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(frame_icon);
		
		JMenuBar menubar = new JMenuBar();
		menubar.setOpaque(true);
		menubar.setBackground(Color.white);
		menubar.setPreferredSize(new Dimension(200, 20));

		menu = new JMenu("File");
		menu.setBackground(Color.white);
		menu.setMnemonic(KeyEvent.VK_F);
			menuItem = new JMenuItem("Nuova Partita", new_icon);			
			menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
			menuItem.addActionListener(this);
			menu.add(menuItem);
			JSeparator separator = new JSeparator();
			menu.add(separator);			
			menuItem = new JMenuItem("Esci", exitItem_icon);
			menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
			menuItem.addActionListener(this);
			menu.add(menuItem);
		menubar.add(menu);

		menu = new JMenu("?");		
			menuItem = new JMenuItem("Info", infoItem_icon);
			menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
			menuItem.addActionListener(this);
			menu.add(menuItem);
			menuItem = new JMenuItem("Tutorial", tutorialItem_icon);
			menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
			menuItem.addActionListener(this);
			menu.add(menuItem);
		menubar.add(menu);
		
		this.setSize(606,649);
		this.setJMenuBar(menubar);
		this.setVisible(true);
	}

	
	private View addTiles() {
		TilesPanel panel = new TilesPanel(model, this);
		add(panel, BorderLayout.CENTER);

		return panel;
	}
	
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
    
    public void actionPerformed(ActionEvent e){		
		try{			
			JMenuItem mi = (JMenuItem)(e.getSource());
			if (mi.getText() == "Nuova Partita"){
				//.setEnabled(true);
			}
			else if (mi.getText() == "Esci"){
				int answer = JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Chiudi il gioco",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,exit_icon);
				if(answer == 0){
					System.exit (0);
				}
			}else if (mi.getText() == "Info"){
				JOptionPane.showMessageDialog(null,"Gioco degli Scacchi\nv1.0\n\n\u00a9 2015 / Lorenzo & Mattia. Tutti i diritti riservati.","Gli sviluppatori",JOptionPane.INFORMATION_MESSAGE,info_icon);	
			}
			else if (mi.getText() == "Tutorial"){
				JOptionPane.showMessageDialog(null,"Consultare la pagina Wikipedia.","Tutorial",JOptionPane.INFORMATION_MESSAGE,tutorial_icon);	
			}
		}catch(Exception ex){
			System.out.println("Errore nell'actionPerformed.");
		}
	}
}