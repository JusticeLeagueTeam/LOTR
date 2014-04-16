package LOTR;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Game.gameStatus=0;;
		System.out.println("Udvozollek a Justice League prototipus programjaban!");
		System.out.println("---------------------------------------------------");
		/**
		 * elso szekvencia diagram kezdete
		 */
		Game game=new Game();
		/**
		 * ebbe olvassuk majd az inputot
		 */
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String line = null;

		/**
		 * vegtelen ciklus folyamatosan input-ot var es az alapjan indit el szekv diagramok szerint metodusokat
		 */
		while(true){
			/**
			 * input beolvasasa
			 */
			System.out.println("Lehetseges inputok: gamestart, bigtower, smalltower, enemy , shiftingsand, \nswamp, printdefensetools, printall, firingspeedincreaserstone, \nrangeextenderstone, elfdwarfspecializedstone, tick, endgame, exit");
			System.out.println("input:");
			try {
				line = buff.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String line2 = line.toLowerCase();
			String[] command = line2.split(" ");
			/**
			 * jatek kezdese
			 */
			if(command.length == 1 && command[0].equals("gamestart")){
				System.out.println("A jatekmenet elindult.");
				System.out.println();
				Game.gameStatus=1;
			}
			/**
			 * ha mar elindult a jatek akkor fogadjuk az inputokat
			 */
			else if(Game.gameStatus>=1){
				/**
				 * nagy torony epitese
				 */
				if(command.length == 3 && command[0].equals("bigtower")){
		        	BigTower defenseTool = new BigTower();
		        	int y = -1;
		        	int x = -1;
		        	try{
		        	y = Integer.parseInt(command[1]);
		        	x = Integer.parseInt(command[2]);
		        	} catch(NumberFormatException e) { 
		        		System.out.println("A koordinatakat szam formatumban kell megadni");
		            }
		        	if(x >= 0 && x <= 24 && y >= 0 && y <= 24 && Map.mainMap[y][x].getRoadFlag() == false){
			        	defenseTool.position.setRowValue(y);
			        	defenseTool.position.setColumnValue(x);
			        	Map.player.createDefenseTool(defenseTool);
			        	System.out.println("Letrejott egy bigtower az alabbi cellan: "+y+" "+x);
			        }
		        	else
		        		System.out.println("A megadott koordinata nem helyes");
			    }
				/**
				 * kis torony epitese
				 */
				else if(command.length == 3 && command[0].equals("smalltower")){
		        	SmallTower defenseTool = new SmallTower();
		        	int y = -1;
		        	int x = -1;
		        	try{
		        	y = Integer.parseInt(command[1]);
		        	x = Integer.parseInt(command[2]);
		        	} catch(NumberFormatException e) { 
		        		System.out.println("A koordinatakat szam formatumban kell megadni");
		            }
		        	if(x >= 0 && x <= 24 && y >= 0 && y <= 24 && Map.mainMap[y][x].getRoadFlag() == false){
		        		defenseTool.position.setRowValue(y);
		        		defenseTool.position.setColumnValue(x);
			        	Map.player.createDefenseTool(defenseTool);
			        	System.out.println("Letrejott egy smalltower az alabbi cellan: "+y+" "+x);
			        }
		        	else
		        		System.out.println("A megadott koordinata nem helyes");
				}
				/**
				 * ellenfel generalasa
				 */    
			    else if(command.length == 4 && command[0].equals("enemy") && (command[1].equals("hobbit") || command[1].equals("human") || command[1].equals("dwarf") || command[1].equals("elf"))){
			    	int y = -1;
		        	int x = -1;
		        	try{
		        	y = Integer.parseInt(command[2]);
		        	x = Integer.parseInt(command[3]);
		        	} catch(NumberFormatException e) { 
		        		System.out.println("A koordinatakat szam formatumban kell megadni");
		            }
		        	if((!(x >= 0 && x <= 24 && y >= 0 && y <= 24))  || (Map.mainMap[y][x].getRoadFlag() == false)){
		        		System.out.println("A megadott koordinata nem helyes");
		        	}
			    	/**
			    	 * Hobbit letrehozasa
			    	 */
		        	else if(command[1].equals("hobbit")){
			    		Hobbit enemy = new Hobbit();
				        enemy.position.setRowValue(y);
				       	enemy.position.setColumnValue(x);
				       	enemy.lastPosition.setRowValue(y);
				       	enemy.lastPosition.setColumnValue(x);
				       	Map.enemies.add(enemy);
				       	for(Tower t : Map.towers){
				       		Map.enemies.get(Map.enemies.indexOf(enemy)).addObserver(t);
				       	}
				       	System.out.println("Letrejott egy hobbit az alabbi cellan: "+y+" "+x);
				    }
			    	/**
			    	 * Human letrehozasa
			    	 */
			    	else if(command[1].equals("human")){
			    		Human enemy = new Human();
			    		enemy.position.setRowValue(y);
				       	enemy.position.setColumnValue(x);
				       	enemy.lastPosition.setRowValue(y);
				       	enemy.lastPosition.setColumnValue(x);
				       	Map.enemies.add(enemy);
				       	for(Tower t : Map.towers){
				       		Map.enemies.get(Map.enemies.indexOf(enemy)).addObserver(t);
				       	}
				       	System.out.println("Letrejott egy human az alabbi cellan: "+y+" "+x);
			    	}
			    	/**
			    	 * Dwarf letrehozasa
			    	 */
			    	else if(command[1].equals("dwarf")){
			    		Dwarf enemy = new Dwarf();
			    		enemy.position.setRowValue(y);
				       	enemy.position.setColumnValue(x);
				       	enemy.lastPosition.setRowValue(y);
				       	enemy.lastPosition.setColumnValue(x);
				       	Map.enemies.add(enemy);
				       	for(Tower t : Map.towers){
				       		Map.enemies.get(Map.enemies.indexOf(enemy)).addObserver(t);
				       	}
				       	System.out.println("Letrejott egy dwarf az alabbi cellan: "+y+" "+x);
			    	}
			    	/**
			    	 * Elf letrehozasa
			    	 */
					else if(command[1].equals("elf")){
						Elf enemy = new Elf();
						enemy.position.setRowValue(y);
				       	enemy.position.setColumnValue(x);
				       	enemy.lastPosition.setRowValue(y);
				       	enemy.lastPosition.setColumnValue(x);
				       	Map.enemies.add(enemy);
				       	for(Tower t : Map.towers){
				       		Map.enemies.get(Map.enemies.indexOf(enemy)).addObserver(t);
				       	}
				       	System.out.println("Letrejott egy elf az alabbi cellan: "+y+" "+x);
					}    
			    }
				/**
		         * futohomok letrehozasa
		         */
		        else if(command.length == 3 && command[0].equals("shiftingsand")){
		        	ShiftingSand defenseTool = new ShiftingSand();
		        	int y = -1;
		        	int x = -1;
		        	try{
		        	y = Integer.parseInt(command[1]);
		        	x = Integer.parseInt(command[2]);
		        	} catch(NumberFormatException e) { 
		        		System.out.println("A koordinatakat szam formatumban kell megadni");
		            }
		        	if(x >= 0 && x <= 24 && y >= 0 && y <= 24 && Map.mainMap[y][x].getRoadFlag() == false){
		        		defenseTool.position.setRowValue(y);
		        		defenseTool.position.setColumnValue(x);
			        	Map.player.createDefenseTool(defenseTool);
			        	System.out.println("Letrejott egy shiftingsand az alabbi cellan: "+y+" "+x);
			        }
		        	else
		        		System.out.println("A megadott koordinata nem helyes");
		        }
				/**
				 * mocsar letrehozasa
				 */
		        else if(command.length == 3 && command[0].equals("swamp")){
		        	Swamp defenseTool = new Swamp();
		        	int y = -1;
		        	int x = -1;
		        	try{
		        	y = Integer.parseInt(command[1]);
		        	x = Integer.parseInt(command[2]);
		        	} catch(NumberFormatException e) { 
		        		System.out.println("A koordinatakat szam formatumban kell megadni");
		            }
		        	if(x >= 0 && x <= 24 && y >= 0 && y <= 24 && Map.mainMap[y][x].getRoadFlag() == false){
		        		defenseTool.position.setRowValue(y);
		        		defenseTool.position.setColumnValue(x);
			        	Map.player.createDefenseTool(defenseTool);
			        	System.out.println("Letrejott egy swamp az alabbi cellan: "+y+" "+x);
			        }
		        	else
		        		System.out.println("A megadott koordinata nem helyes");
		        }
				/**
				 * a vedelmi eszkozok kiiratasa
				 */
				else if(command.length == 1 && command[0].equals("printdefensetools")){
					System.out.println("tick "+Map.getTickCount());
					System.out.println("player varazsereje "+Map.player.getMagicPower());
					//Tornyok kiiratasa
					System.out.println("tornyok listaja:");
					if(Map.towers.isEmpty()){
						System.out.println("nincs torony");
					}
					else{
						LinkedList<Tower> towers = Map.getTowers();
						for(Tower element : towers){
							System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());					}
					}
					System.out.println();
					//Akadalyok kiiratasa
					System.out.println("akadalyok listaja:");
					if(Map.barriers.isEmpty()){
						System.out.println("nincs akadaly");
					}
					else{
						LinkedList<Barrier> barriers = Map.getBarriers();
						for(Barrier element : barriers){
							System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());					}
					}
					System.out.println();
					//Varazskovek kiiratasa
					System.out.println("varazskovek listaja:");
					if(Map.magicStones.isEmpty()){
						System.out.println("nincs varazsko");
					}
					else{
						LinkedList<MagicStone> magicStones = Map.getMagicStones();
						for(MagicStone element : magicStones){
							if(element instanceof FiringSpeedIncreaseStone == false)
								System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
							else
								System.out.println("FiringSpeedIncreaserStone"+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
						}
					}
					System.out.println();
				}
				/**
				 * jatekot erinto attributumok kiiratasa
				 */
				else if(command.length == 1 && command[0].equals("printall")){
					System.out.println("tick "+Map.getTickCount());
					System.out.println("player varazsereje "+Map.player.getMagicPower());
					//Tornyok kiiratasa
					System.out.println("tornyok listaja:");
					if(Map.towers.isEmpty()){
						System.out.println("nincs torony");
					}
					else{
						LinkedList<Tower> towers = Map.getTowers();
						for(Tower element : towers){
							System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());					}
					}
					System.out.println();
					//Akadalyok kiiratasa
					System.out.println("akadalyok listaja:");
					if(Map.barriers.isEmpty()){
						System.out.println("nincs akadaly");
					}
					else{
						LinkedList<Barrier> barriers = Map.getBarriers();
						for(Barrier element : barriers){
							System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());					}
					}
					System.out.println();
					//Varazskovek kiiratasa
					System.out.println("varazskovek listaja:");
					if(Map.magicStones.isEmpty()){
						System.out.println("nincs varazsko");
					}
					else{
						LinkedList<MagicStone> magicStones = Map.getMagicStones();
						for(MagicStone element : magicStones){
							System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
						}
					}
					System.out.println();
					//Ellenfelek kiiaratasa
					System.out.println("ellenfelek:");
					if(Map.enemies.isEmpty()){
						System.out.println("nincs ellenfel");
					}
					else{
						LinkedList<Enemy> enemies = Map.getEnemies();
						for(Enemy element : enemies){
							System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue()+" "+element.getHealth());
						}
					}
					System.out.println();
				}
				/**
		         * tuzelesi gyakorisagot novelo ko letrehozasa
		         */
		        else if(command.length == 3 && command[0].equals("firingspeedincreaserstone")){
		        	FiringSpeedIncreaseStone defenseTool = new FiringSpeedIncreaseStone();
		        	int y = -1;
		        	int x = -1;
		        	try{
		        	y = Integer.parseInt(command[1]);
		        	x = Integer.parseInt(command[2]);
		        	} catch(NumberFormatException e) { 
		        		System.out.println("A koordinatakat szam formatumban kell megadni");
		            }
		        	if(x >= 0 && x <= 24 && y >= 0 && y <= 24){
		        		defenseTool.position.setRowValue(y);
		        		defenseTool.position.setColumnValue(x);
			        	Map.player.createDefenseTool(defenseTool);
			        	System.out.println("Letrejott egy firingspeedincreaserstone az alabbi cellan: "+y+" "+x);
			        }
		        	else
		        		System.out.println("A megadott koordinata nem helyes");
		        }
				/**
				 * hatotavot novelo ko letrehozasa
				 */
		        else if(command.length == 3 && command[0].equals("rangeextenderstone")){
		        	RangeExtenderStone defenseTool = new RangeExtenderStone();
		        	int y = -1;
		        	int x = -1;
		        	try{
		        	y = Integer.parseInt(command[1]);
		        	x = Integer.parseInt(command[2]);
		        	} catch(NumberFormatException e) { 
		        		System.out.println("A koordinatakat szam formatumban kell megadni");
		            }
		        	if(x >= 0 && x <= 24 && y >= 0 && y <= 24){
		        		defenseTool.position.setRowValue(y);
		        		defenseTool.position.setColumnValue(x);
			        	Map.player.createDefenseTool(defenseTool);
			        	System.out.println("Letrejott egy rangeextenderstone az alabbi cellan: "+y+" "+x);
	
			        }
		        	else
		        		System.out.println("A megadott koordinata nem helyes");
		        }
				/**
				 * specialis ko letrehozasa
				 */
		        else if(command.length == 3 && command[0].equals("elfdwarfspecializedstone")){
		        	ElfDwarfSpecializedStone defenseTool = new ElfDwarfSpecializedStone();
		        	int y = -1;
		        	int x = -1;
		        	try{
		        	y = Integer.parseInt(command[1]);
		        	x = Integer.parseInt(command[2]);
		        	} catch(NumberFormatException e) { 
		        		System.out.println("A koordinatakat szam formatumban kell megadni");
		            }
		        	if(x >= 0 && x <= 24 && y >= 0 && y <= 24){
		        		defenseTool.position.setRowValue(y);
		        		defenseTool.position.setColumnValue(x);
			        	Map.player.createDefenseTool(defenseTool);
			        	System.out.println("Letrejott egy elfdwarfspecializedstone az alabbi cellan: "+y+" "+x);
	
			        }
		        	else
		        		System.out.println("A megadott koordinata nem helyes");
		        }
				/**
				 * tick, orajel kiadasa
				 */
		        else if((command.length == 1 || command.length == 2) && command[0].equals("tick")){
		        	if(command.length == 1){
		        		Timer.tick();
		        	}
		        	if(command.length == 2){
		        		if(command[1].equals("fog")){
		        			if(Game.isFog == false)
		        				Game.fogPrint=true;
		        			Game.isFog= !Game.isFog;
		        			Timer.tick();
		        		}
		        		else if(command[1].equals("special")){
		        			Game.isSpecial=true;
		        			Timer.tick();
		        		}
		        		else{
		        			int tickPar = -1;
				        	try{
				        	tickPar = Integer.parseInt(command[1]);
				        	} catch(NumberFormatException e) { 
				        		System.out.println("Helytelen tick parameter");
				            }
				        	if(tickPar > 0){
				        		for(int i = 0;i < tickPar; i++){
				        			Timer.tick();
				        		}
				        	}
				        	else
				        		System.out.println("A ticknek egy pozitiv egesz szamot kell megadni");
		        		}
		        	}
		        }
		         /**
		         * jatekmenet vege
		         * ket fele kepp lehet vege a jateknak
		         * a.) elpusztult minden ellenseg - jatekos nyert
		         * b.) ellenseg elerte a vegzet hegyet - jatekos vesztett
		         */
		        else if(command.length == 1 && command[0].equals("endgame")){
		        	Game.gameStatus = 2;
		        }
		        else if(command.length == 1 && command[0].equals("exit")){
		        	break;
		        }
				/**
				 * ha nem a megadott inputok kozul valasztott a felhasznalo
				 */
		        else{
					System.out.println("Hibas parancs!");
				}
			}
			else{
				System.out.println("Elobb el kell inditani a jatekmenetet (gamestart)");
			}
		    /**
		     * itt kezeljuk ha a jatekos hibas inputot gepel be
		    */
		}
	}
}
