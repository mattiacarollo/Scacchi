package com.lzmtt.chess;

import java.awt.*;
import javax.swing.*;

public class Pedine extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	Image alfiere_bianco = Toolkit.getDefaultToolkit().getImage("/pezziBianchi/alfiere.gif");
	Image cavallo_bianco = Toolkit.getDefaultToolkit().getImage("/pezziBianchi/cavallo.gif");
	Image pedone_bianco = Toolkit.getDefaultToolkit().getImage("/pezziBianchi/pedone.gif");
	Image re_bianco = Toolkit.getDefaultToolkit().getImage("/pezziBianchi/re.gif");
	Image regina_bianco = Toolkit.getDefaultToolkit().getImage("/pezziBianchi/regina.gif");
	Image torre_bianco = Toolkit.getDefaultToolkit().getImage("/pezziBianchi/torre.gif");
	Image alfiere_nero = Toolkit.getDefaultToolkit().getImage("/pezziNeri/alfiere.gif");
	Image cavallo_nero = Toolkit.getDefaultToolkit().getImage("/pezziNeri/cavallo.gif");
	Image pedone_nero = Toolkit.getDefaultToolkit().getImage("/pezziNeri/pedone.gif");
	Image re_nero = Toolkit.getDefaultToolkit().getImage("/pezziNeri/re.gif");
	Image regina_nero = Toolkit.getDefaultToolkit().getImage("/pezziNeri/regina.gif");
	Image torre_nero = Toolkit.getDefaultToolkit().getImage("/pezziNeri/torre.gif");
	
	public Pedine(){		
		setLayout(new GridLayout(8,8,0,0));
		
		//drawPedine();
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(torre_bianco, 10, 10, this);
		g2.finalize();
	}
}
