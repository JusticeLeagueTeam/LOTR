package LOTR;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Control{
	private boolean BigTowerFlag=false;
	private boolean SmallTowerFlag=false;
	private boolean SwampFlag=false;
	private boolean ShiftingSandFlag=false;
	private boolean SpeedStoneFlag=false;
	private boolean RangeStoneFlag=false;
	private boolean ElfDwarfStoneFlag=false;

	public void controlClick(int x, int y) {

		/**
		 * cella sor es oszlop kiszamolasahoz leosztok 33-vel
		 * Kiemeltem a szamitast elore, mivel mindenhol ezt kell hasznalni,
		 * es ne legyen kodismetles
		 */
		int CellColumn = (x - (x % 33)) / 33;
		int CellRow = (y - (y % 33)) / 33;
		
		if(BigTowerFlag == false && x >= 250 && x <= 250+32 && y >= 0 && y <= 50){
			/**
			 * BigTower ikonra kattintott
			 */
			BigTowerFlag=true;
		}
		else if(BigTowerFlag == true){

			/**
			 * BigTower letrehozasa
			 */
			
			/**
			 * Annak vizsgalata, hogy az adott helyen nincs-e mar torony
			 */
			boolean positionIsUsed = false;	
			if(!Map.towers.isEmpty()){
				for(Tower t : Map.towers){
					if(t.getPosition().getRowValue() == CellRow-2 && t.getPosition().getColumnValue() == CellColumn){
						positionIsUsed = true;
					}
				}
			}
			/**
			 * Amennyiben az adott hely nem foglalt, letrehozzuk a BigTowert
			 */
			if(positionIsUsed == false){
				BigTower bt = new BigTower();
				bt.position.setRowValue(CellRow-2);
				bt.position.setColumnValue(CellColumn);
				Map.player.createDefenseTool(bt);
				View.towerviews.add(new TowerView(bt));
			}
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
			 * SmallTower letrehozasa
			 */
			
			/**
			 * Annak vizsgalata, hogy az adott helyen nincs-e mar torony
			 */
			boolean positionIsUsed = false;	
			if(!Map.towers.isEmpty()){
				for(Tower t : Map.towers){
					if(t.getPosition().getRowValue() == CellRow-2 && t.getPosition().getColumnValue() == CellColumn){
						positionIsUsed = true;
						System.out.println("Foglalt");
					}
				}
			}
			/**
			 * Amennyiben az adott hely nem foglalt, letrehozzuk a SmallTowert
			 */
			if(positionIsUsed == false){
				SmallTower bt = new SmallTower();
				bt.position.setRowValue(CellRow-2);
				bt.position.setColumnValue(CellColumn);
				Map.player.createDefenseTool(bt);
				View.towerviews.add(new TowerView(bt));
			}
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
			 * Swamp letrehozasa
			 */
			Swamp bt = new Swamp();
			bt.position.setRowValue(CellRow-2);
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
			 * ShiftingSand letrehozasa
			 */
			ShiftingSand bt = new ShiftingSand();
			bt.position.setRowValue(CellRow-2);
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
			 * SpeedStone letrehozasa
			 */
			FiringSpeedIncreaseStone bt = new FiringSpeedIncreaseStone();
			bt.position.setRowValue(CellRow-2);
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
			 * RangeStone letrehozasa
			 */
			RangeExtenderStone bt = new RangeExtenderStone();
			bt.position.setRowValue(CellRow-2);
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
			 * ElfDwarfStone letrehozasa
			 */
			ElfDwarfSpecializedStone bt = new ElfDwarfSpecializedStone();
			bt.position.setRowValue(CellRow-2);
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
