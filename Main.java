package LOTR;

import javax.swing.*;

public class Main extends JPanel{
	

	public static void main(String[] args) {
		/**
		 * game es azon belul player letrejon
		 */
		Game game=new Game();
		/**
		 * GUI-hoz szukseges dolgok
		 */
		Map.view=new View();
		
		Map.frame = new JFrame("Lord of the Rings - by justice_league");
		Map.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        View mv = new View();
        Map.frame.add(mv);
        
        Map.control=new Control();
        
        Map.frame.setSize(840, 892);
        Map.frame.setVisible(true);
        
      
		/**
		 * gameStatus flag inicializalasa
		 * protonal 0-an volt
		 * amig nincs start gomb, addig gui-nal 1
		 */
		Game.gameStatus=1;
        	
		ImageIcon img_logo = new ImageIcon("logo.png") ;
        JLabel lbl = new JLabel(img_logo);
	
		final JComponent[] inputs = new JComponent[] {
				new JLabel(img_logo),
				new JLabel("Csapattagok:"),
				new JLabel("         - Vámos Arnold"),
				new JLabel("         - Valyon Balázs"),
				new JLabel("         - Horváth Olivér"),
				new JLabel("         - Reé Tamás"),
				new JLabel(""),
				new JLabel("A játék indításához kattintson az Ok gombra!")
		};
		
		JOptionPane.showMessageDialog(null, inputs, "Üdvözlünk a játékban!",JOptionPane.PLAIN_MESSAGE);

	}
}
