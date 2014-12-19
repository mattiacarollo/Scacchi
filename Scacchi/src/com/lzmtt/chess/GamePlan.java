/**
 *  Creazione del Piano di gioco
 */

package com.lzmtt.chess;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;


public class GamePlan extends JPanel
{

	private static final long serialVersionUID = 1L;
	private final int Divide = 600/8;
	private Rectangle2D rec;
	private int box = 600;	

	public GamePlan(){		
		setLayout(null);
	}
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         
        Graphics2D g2 = (Graphics2D)g;
         
        //Disegno il piano
        for (int i=0; i<8; i=i+2) {
            for (int j=0; j<8; j=j+2) {
                g2.setColor(Color.BLACK);
                rec=new Rectangle2D.Double(j*box/8,(1+i)*box/8,Divide,Divide);
                g2.fill(rec);
                rec=new Rectangle2D.Double((1+j)*box/8,i*box/8,Divide,Divide);
                g2.fill(rec);
            }
        }
    }
}
