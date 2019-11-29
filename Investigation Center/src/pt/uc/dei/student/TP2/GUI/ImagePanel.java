package pt.uc.dei.student.TP2.GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	ImagePanel(String fileName){
		JPanel panel = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image backgroundImage=null;
				try {
					backgroundImage = ImageIO.read(new File(fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(backgroundImage, 0, 0,getX(),getY(),this);
			}
		};
		this.add(panel);
	}
}
