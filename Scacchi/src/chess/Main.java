/**
 *  Nome Progetto: Gioco degli scacchi
 *  Corso: Ingegneria del Software
 *  Docente: Spoto Fausto
 *  Allievi: Carollo Mattia, Niero Lorenzo
 *  Master: Computer Game Development
 */

package chess;

import java.awt.EventQueue;
import javax.swing.JFrame;
import chess.view.ScacchiFrame;

public class Main
{

//	public static void main(String[] args) {
//		new Gui();
//	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new ScacchiFrame();
			}
		});
	}
}
