package LOTR;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Control{
	boolean BigTowerFlag=false;

	public void controlClick(int x, int y) {
		// TODO Auto-generated method stub
		if(BigTowerFlag == false && x >= 250 && x <= 250+32 && y >= 0 && y <= 50){
			BigTowerFlag=true;
		}
		else if(BigTowerFlag == true){
			/**
			 * cella sor es oszlop kiszamolasahoz leosztok 32-vel
			 */
			int CellColumn = (x - (x % 32)) / 32;
			int CellRow = (y - (y % 32)) / 32;
			/**
			 * BigTower letrehozasa
			 */
			BigTower bt = new BigTower();
			bt.position.setRowValue(CellRow);
			bt.position.setColumnValue(CellColumn);
			Map.player.createDefenseTool(bt);
			View.towerviews.add(new TowerView(bt));
			/**
			 * BigTowerFlag visszaallitasa
			 */
			BigTowerFlag=false;
		}
	}

}
