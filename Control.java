package LOTR;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Control{
	boolean BigTowerFlag=false;
	boolean SmallTowerFlag=false;
	boolean SwampFlag=false;
	boolean ShiftingSandFlag=false;
	boolean SpeedStoneFlag=false;
	boolean RangeStoneFlag=false;
	boolean ElfDwarfStoneFlag=false;

	public void controlClick(int x, int y) {
		// TODO Auto-generated method stub
		if(BigTowerFlag == false && x >= 250 && x <= 250+32 && y >= 0 && y <= 50){
			/**
			 * BigTower ikonra kattintott
			 */
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
		else if(SmallTowerFlag == false && x >= 250+32*1 && x <= 250+32*2 && y >= 0 && y <= 50){
			/**
			 * SmallTower ikonra kattintott
			 */
			SmallTowerFlag=true;
		}
		else if(SmallTowerFlag == true){
			/**
			 * cella sor es oszlop kiszamolasahoz leosztok 32-vel
			 */
			int CellColumn = (x - (x % 32)) / 32;
			int CellRow = (y - (y % 32)) / 32;
			/**
			 * SmallTower letrehozasa
			 */
			SmallTower bt = new SmallTower();
			bt.position.setRowValue(CellRow);
			bt.position.setColumnValue(CellColumn);
			Map.player.createDefenseTool(bt);
			View.towerviews.add(new TowerView(bt));
			/**
			 * SmallTowerFlag visszaallitasa
			 */
			SmallTowerFlag=false;
		}
		else if(SwampFlag == false && x >= 250+32*2 && x <= 250+32*3 && y >= 0 && y <= 50){
			/**
			 * Swamp ikonra kattintott
			 */
			SwampFlag=true;
		}
		else if(SwampFlag == true){
			/**
			 * cella sor es oszlop kiszamolasahoz leosztok 32-vel
			 */
			int CellColumn = (x - (x % 32)) / 32;
			int CellRow = (y - (y % 32)) / 32;
			/**
			 * Swamp letrehozasa
			 */
			Swamp bt = new Swamp();
			bt.position.setRowValue(CellRow);
			bt.position.setColumnValue(CellColumn);
			Map.player.createDefenseTool(bt);
			View.barrierviews.add(new BarrierView(bt));
			/**
			 * SwampFlag visszaallitasa
			 */
			SwampFlag=false;
		}
		else if(ShiftingSandFlag == false && x >= 250+32*3 && x <= 250+32*4 && y >= 0 && y <= 50){
			/**
			 * ShiftingSand ikonra kattintott
			 */
			ShiftingSandFlag=true;
		}
		else if(ShiftingSandFlag == true){
			/**
			 * cella sor es oszlop kiszamolasahoz leosztok 32-vel
			 */
			int CellColumn = (x - (x % 32)) / 32;
			int CellRow = (y - (y % 32)) / 32;
			/**
			 * ShiftingSand letrehozasa
			 */
			ShiftingSand bt = new ShiftingSand();
			bt.position.setRowValue(CellRow);
			bt.position.setColumnValue(CellColumn);
			Map.player.createDefenseTool(bt);
			View.barrierviews.add(new BarrierView(bt));
			/**
			 * ShiftingSandFlag visszaallitasa
			 */
			ShiftingSandFlag=false;
		}
		else if(SpeedStoneFlag == false && x >= 250+32*4 && x <= 250+32*5 && y >= 0 && y <= 50){
			/**
			 * SpeedStone ikonra kattintott
			 */
			SpeedStoneFlag=true;
		}
		else if(SpeedStoneFlag == true){
			/**
			 * cella sor es oszlop kiszamolasahoz leosztok 32-vel
			 */
			int CellColumn = (x - (x % 32)) / 32;
			int CellRow = (y - (y % 32)) / 32;
			/**
			 * SpeedStone letrehozasa
			 */
			FiringSpeedIncreaseStone bt = new FiringSpeedIncreaseStone();
			bt.position.setRowValue(CellRow);
			bt.position.setColumnValue(CellColumn);
			Map.player.createDefenseTool(bt);
			View.stoneviews.add(new StoneView(bt));
			/**
			 * SpeedStoneFlag visszaallitasa
			 */
			SpeedStoneFlag=false;
		}
		else if(RangeStoneFlag == false && x >= 250+32*5 && x <= 250+32*6 && y >= 0 && y <= 50){
			/**
			 * RangeStone ikonra kattintott
			 */
			RangeStoneFlag=true;
		}
		else if(RangeStoneFlag == true){
			/**
			 * cella sor es oszlop kiszamolasahoz leosztok 32-vel
			 */
			int CellColumn = (x - (x % 32)) / 32;
			int CellRow = (y - (y % 32)) / 32;
			/**
			 * RangeStone letrehozasa
			 */
			RangeExtenderStone bt = new RangeExtenderStone();
			bt.position.setRowValue(CellRow);
			bt.position.setColumnValue(CellColumn);
			Map.player.createDefenseTool(bt);
			View.stoneviews.add(new StoneView(bt));
			/**
			 * RangeStoneFlag visszaallitasa
			 */
			RangeStoneFlag=false;
		}
		else if(ElfDwarfStoneFlag == false && x >= 250+32*6 && x <= 250+32*7 && y >= 0 && y <= 50){
			/**
			 * ElfDwarfStone ikonra kattintott
			 */
			ElfDwarfStoneFlag=true;
		}
		else if(ElfDwarfStoneFlag == true){
			/**
			 * cella sor es oszlop kiszamolasahoz leosztok 32-vel
			 */
			int CellColumn = (x - (x % 32)) / 32;
			int CellRow = (y - (y % 32)) / 32;
			/**
			 * ElfDwarfStone letrehozasa
			 */
			ElfDwarfSpecializedStone bt = new ElfDwarfSpecializedStone();
			bt.position.setRowValue(CellRow);
			bt.position.setColumnValue(CellColumn);
			Map.player.createDefenseTool(bt);
			View.stoneviews.add(new StoneView(bt));
			/**
			 * ElfDwarfStoneFlag visszaallitasa
			 */
			ElfDwarfStoneFlag=false;
		}
	}

}