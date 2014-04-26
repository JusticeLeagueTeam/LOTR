package LOTR;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class View extends JPanel{
	public static LinkedList<EnemyView> enemyviews;
	public static LinkedList<TowerView> towerviews;
	public static LinkedList<BarrierView> barrierviews;
	public static LinkedList<StoneView> stoneviews;
	public static MenuView menuview;
	public static MapView mapview;
	public static int cnt = 0;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/**
		 * terkep rajzolasa
		 */
		mapview.Paint(g);
		/**
		 * menusor rajzolasa
		 */
		menuview.Paint(g);
		/**
		 * enemy-k megjelenitese
		 */
		for(EnemyView ev : enemyviews){
			ev.Paint(g);
		}
		/**
		 * tower-ek megjelenitese
		 */
		for(TowerView tv : towerviews){
			tv.Paint(g);
		}
		/**
		 * barrier-ek megjelenitese
		 */
		for(BarrierView bv : barrierviews){
			bv.Paint(g);
		}
		/**
		 * stone-ok megjelenitese
		 */
		for(StoneView sv : stoneviews){
			sv.Paint(g);
		}
	}
	/**
	 * frissites
	 */
	public void update(Graphics g){
		paintComponent(g);
	}
	/**
	 * konstruktor
	 */
	public View(){
		enemyviews = new LinkedList<EnemyView>();
		towerviews = new LinkedList<TowerView>();
		barrierviews = new LinkedList<BarrierView>();
		stoneviews = new LinkedList<StoneView>();
		menuview = new MenuView();
		mapview = new MapView();
	}
}