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
        /**
         * View osztaly peldanyositasa
         */
        View mv = new View();
        Map.frame.add(mv);
        /**
         * Control osztaly peldanyositasa
         */
        Map.control=new Control();
        //ablak felbontas
        Map.frame.setSize(840, 892);
        Map.frame.setVisible(true);
        //alapbol 0 allapotban van a jatek
		Game.gameStatus=0;
        /**
         * popup ablak koszonti a felhasznalot
         */
		ImageIcon img_logo = new ImageIcon("logo.png") ;
        	JLabel lbl = new JLabel(img_logo);
        //csapattagok listazasa
		final JComponent[] inputs = new JComponent[] {
				new JLabel(img_logo),
				new JLabel("Csapattagok:"),
				new JLabel("         - Vamos Arnold"),
				new JLabel("         - Valyon Balazs"),
				new JLabel("         - Horvath Oliver"),
				new JLabel("         - Ree Tamas"),
				new JLabel(""),
				new JLabel("A jatek inditasahoz kattintson az Ok gombra!")
		};
		//udvozlo szoveg megjelenik
		JOptionPane.showMessageDialog(null, inputs, "Udvozlunk a jatekban!",JOptionPane.PLAIN_MESSAGE);
		//a kovetkezo sor csak az Ok-ra valo kattintas utan fut le,
		//tehat csak utana indul a jatekmenet
		Game.gameStatus=1;

	}
}
