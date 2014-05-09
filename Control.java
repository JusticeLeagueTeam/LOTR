package LOTR;
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
			 * Amennyiben a jatekos a palyara kattintott:
			 */
			if(CellRow-2 >= 0 && CellColumn >= 0){
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
				 * Amennyiben az adott hely nem foglalt, es nem ut
				 * letrehozzuk a BigTowert
				 */
				if(positionIsUsed == false && Map.mainMap[CellRow-2][CellColumn].getRoadFlag()== false){
					BigTower bt = new BigTower();
					//varazsero ellenorzes
					if(bt.getCost() <= Map.player.getMagicPower()){
						bt.position.setRowValue(CellRow-2);
						bt.position.setColumnValue(CellColumn);
						Map.player.createDefenseTool(bt);
						View.towerviews.add(new TowerView(bt));
					}
				}
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
			 * Amennyiben a jatekos a palyara kattintott:
			 */
			if(CellRow-2 >= 0 && CellColumn >= 0){
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
						}
					}
				}
				/**
				 * Amennyiben az adott hely nem foglalt,
				 * es nem ut, letrehozzuk a SmallTowert
				 */
				if(positionIsUsed == false && Map.mainMap[CellRow-2][CellColumn].getRoadFlag()== false){
					SmallTower bt = new SmallTower();
					//varazsero ellenorzes
					if(bt.getCost() <= Map.player.getMagicPower()){
						bt.position.setRowValue(CellRow-2);
						bt.position.setColumnValue(CellColumn);
						Map.player.createDefenseTool(bt);
						View.towerviews.add(new TowerView(bt));
					}
				}
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
			 * Amennyiben a jatekos a palyara kattintott:
			 */
			if(CellRow-2 >= 0 && CellColumn >= 0){
				/**
				 * Swamp letrehozasa
				 */

				/**
				 * Annak vizsgalata, hogy az adott helyen nincs-e mar akadaly
				 */
				boolean positionIsUsed = false;	
				if(!Map.barriers.isEmpty()){
					for(Barrier b : Map.barriers){
						if(b.getPosition().getRowValue() == CellRow-2 && b.getPosition().getColumnValue() == CellColumn){
							positionIsUsed = true;
						}
					}
				}
				/**
				 * Amennyiben az adott hely nem foglalt,
				 * es ut, letrehozzuk a Swampet
				 */
				if(positionIsUsed == false && Map.mainMap[CellRow-2][CellColumn].getRoadFlag()== true){
					Swamp bt = new Swamp();
					//van-e eleg varazsero
					if(bt.getCost() <= Map.player.getMagicPower()){
						bt.position.setRowValue(CellRow-2);
						bt.position.setColumnValue(CellColumn);
						Map.player.createDefenseTool(bt);
						View.barrierviews.add(new BarrierView(bt));
					}
				}
			}
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
			 * Amennyiben a jatekos a palyara kattintott:
			 */
			if(CellRow-2 >= 0 && CellColumn >= 0){
				/**
				 * ShiftingSand letrehozasa
				 */

				/**
				 * Annak vizsgalata, hogy az adott helyen nincs-e mar akadaly
				 */
				boolean positionIsUsed = false;	
				if(!Map.barriers.isEmpty()){
					for(Barrier b : Map.barriers){
						if(b.getPosition().getRowValue() == CellRow-2 && b.getPosition().getColumnValue() == CellColumn){
							positionIsUsed = true;
						}
					}
				}
				/**
				 * Amennyiben az adott hely nem foglalt,
				 * es ut, letrehozzuk a ShiftingSandet
				 */
				if(positionIsUsed == false && Map.mainMap[CellRow-2][CellColumn].getRoadFlag()== true){
					ShiftingSand bt = new ShiftingSand();
					//van-e eleg varazsero
					if(bt.getCost() <= Map.player.getMagicPower()){
						bt.position.setRowValue(CellRow-2);
						bt.position.setColumnValue(CellColumn);
						Map.player.createDefenseTool(bt);
						View.barrierviews.add(new BarrierView(bt));
					}
				}
			}
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
			 * Amennyiben a jatekos a palyara kattintott:
			 */
			if(CellRow-2 >= 0 && CellColumn >= 0){
				/**
				 * SpeedStone letrehozasa
				 */

				/**
				 * Annak vizsgalata, hogy az adott helyen nincs-e mar varazsko
				 */
				boolean positionIsUsed = false;	
				if(!Map.magicStones.isEmpty()){
					for(MagicStone st : Map.magicStones){
						if(st.getPosition().getRowValue() == CellRow-2 && st.getPosition().getColumnValue() == CellColumn){
							positionIsUsed = true;
						}
					}
				}

				/**
				 * Annak vizsgalata, hogy az adott helyen van-e mar torony
				 * amire a varazskovet ratehetjuk
				 */
				boolean towerOnPosition = false;	
				if(!Map.towers.isEmpty()){
					for(Tower t : Map.towers){
						if(t.getPosition().getRowValue() == CellRow-2 && t.getPosition().getColumnValue() == CellColumn){
							towerOnPosition = true;
						}
					}
				}
				/**
				 * Ha van mar torony az aktualis pozicion es meg nincs rajta varazsko,
				 * akkor rahelyezzuk a varazskovet
				 */
				if(positionIsUsed == false && towerOnPosition == true){
					FiringSpeedIncreaseStone bt = new FiringSpeedIncreaseStone();
					//van-e eleg varazsero
					if(bt.getCost() <= Map.player.getMagicPower()){
						bt.position.setRowValue(CellRow-2);
						bt.position.setColumnValue(CellColumn);
						Map.player.createDefenseTool(bt);
						View.stoneviews.add(new StoneView(bt));
					}
				}
			}
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
			 * Amennyiben a jatekos a palyara kattintott:
			 */
			if(CellRow-2 >= 0 && CellColumn >= 0){
				/**
				 * RangeStone letrehozasa
				 */

				/**
				 * Annak vizsgalata, hogy az adott helyen nincs-e mar varazsko
				 */
				boolean positionIsUsed = false;	
				if(!Map.magicStones.isEmpty()){
					for(MagicStone st : Map.magicStones){
						if(st.getPosition().getRowValue() == CellRow-2 && st.getPosition().getColumnValue() == CellColumn){
							positionIsUsed = true;
						}
					}
				}

				/**
				 * Annak vizsgalata, hogy az adott helyen van-e mar torony
				 * amire a varazskovet ratehetjuk
				 */
				boolean towerOnPosition = false;	
				if(!Map.towers.isEmpty()){
					for(Tower t : Map.towers){
						if(t.getPosition().getRowValue() == CellRow-2 && t.getPosition().getColumnValue() == CellColumn){
							towerOnPosition = true;
						}
					}
				}
				/**
				 * Ha van mar torony az aktualis pozicion es meg nincs rajta varazsko,
				 * akkor rahelyezzuk a varazskovet
				 */
				if(positionIsUsed == false && towerOnPosition == true){
					RangeExtenderStone bt = new RangeExtenderStone();
					//van-e eleg varazsero
					if(bt.getCost() <= Map.player.getMagicPower()){
						bt.position.setRowValue(CellRow-2);
						bt.position.setColumnValue(CellColumn);
						Map.player.createDefenseTool(bt);
						View.stoneviews.add(new StoneView(bt));
					}
				}
			}
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
			 * Amennyiben a jatekos a palyara kattintott:
			 */
			if(CellRow-2 >= 0 && CellColumn >= 0){
				/**
				 * ElfDwarfStone letrehozasa
				 */

				/**
				 * Annak vizsgalata, hogy az adott helyen nincs-e mar varazsko
				 */
				boolean positionIsUsed = false;	
				if(!Map.magicStones.isEmpty()){
					for(MagicStone st : Map.magicStones){
						if(st.getPosition().getRowValue() == CellRow-2 && st.getPosition().getColumnValue() == CellColumn){
							positionIsUsed = true;
						}
					}
				}

				/**
				 * Annak vizsgalata, hogy az adott helyen van-e mar torony
				 * amire a varazskovet ratehetjuk
				 */
				boolean towerOnPosition = false;	
				if(!Map.towers.isEmpty()){
					for(Tower t : Map.towers){
						if(t.getPosition().getRowValue() == CellRow-2 && t.getPosition().getColumnValue() == CellColumn){
							towerOnPosition = true;
						}
					}
				}

				/**
				 * Ha van mar torony az aktualis pozicion es meg nincs rajta varazsko,
				 * akkor rahelyezzuk a varazskovet
				 */
				if(positionIsUsed == false && towerOnPosition == true){
					ElfDwarfSpecializedStone bt = new ElfDwarfSpecializedStone();
					//van-e eleg varazsero
					if(bt.getCost() <= Map.player.getMagicPower()){
						bt.position.setRowValue(CellRow-2);
						bt.position.setColumnValue(CellColumn);
						Map.player.createDefenseTool(bt);
						View.stoneviews.add(new StoneView(bt));						
					}
				}
			}
			/**
			 * ElfDwarfStoneFlag visszaallitasa
			 */
			ElfDwarfStoneFlag=false;
		}
	}
}
