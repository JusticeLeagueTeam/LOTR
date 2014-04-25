package LOTR;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main extends JPanel{
	
	

	public static void main(String[] args) {
		/**
		 * GUI-hoz szukseges dolgok
		 */
		Map.view=new View();
		
		Map.frame = new JFrame("Lord of the Rings - by justice_league");
		Map.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        View mv = new View();
        Map.frame.add(mv);
        
        Map.frame.setSize(850, 840);
        Map.frame.setVisible(true);
        
      
		/**
		 * gameStatus flag inicializalasa
		 * protonal 0-an volt
		 * amig nincs start gomb, addig gui-nal 1
		 */
		Game.gameStatus=1;
		/**
		 * fileMode flag inicializalasa
		 */
		if(args.length > 0)
			Game.fileMode=true;
		/**
		 * fajlmuveletekhez szukseges valtozok
		 */
		/**
		 * FileReader es BufferedReader
		 */
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		if(Game.fileMode){
			/**
			 * beallitjuk oket
			 * elso argumentum az input fajl
			 */
			try {
				// FileReader reads text files in the default encoding.
				fileReader = new FileReader(args[0]);

				// Always wrap FileReader in BufferedReader.
				bufferedReader = new BufferedReader(fileReader);	
			}
			catch(FileNotFoundException ex) {
				System.out.println("Hibas az input fajl.");
			}
			catch(IOException ex) {
				System.out.println("Hibas az input fajl.");
			}
		}
		/**
		 * FileWriter es Game.bufferedWriter
		 */
		FileWriter fileWriter = null;
		//Game.bufferedWriter Game.bufferedWriter = null;
		if(Game.fileMode){
			try {
				// Assume default encoding.
				fileWriter = new FileWriter(args[1]);

				// Always wrap FileWriter in Game.bufferedWriter.
				Game.bufferedWriter = new BufferedWriter(fileWriter);
			}
			catch(IOException ex) {
				System.out.println("Hibas output fajl.");
			}
		}
		/**
		 * udvozlo szoveg kiiratasa
		 */
		if(Game.fileMode){
			try{
				Game.bufferedWriter.write("Udvozollek a Justice League prototipus programjaban!");
				Game.bufferedWriter.newLine();
				Game.bufferedWriter.write("---------------------------------------------------");
				Game.bufferedWriter.newLine();
				Game.bufferedWriter.newLine();
			}
			catch(IOException ex) {
				System.out.println("Hibas output fajl.");
			}
		}
		else{
			System.out.println("Udvozollek a Justice League prototipus programjaban!");
			System.out.println("---------------------------------------------------");	
		}
		/**
		 * elso szekvencia diagram kezdete
		 */
		Game game=new Game();
		/**
		 * ebbe olvassuk majd az inputot (konzol)
		 */
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		/**
		 * ebbe a valtozoba generalunk string-et konzolrol es fajlbol is (input)
		 */
		String line = null;

		/**
		 * parancs szavainak tombje
		 */
		String[] command=null;

		/**
		 * vegtelen ciklus folyamatosan input-ot var es az alapjan indit el szekv diagramok szerint metodusokat
		 */
		while(true){
			/**
			 * lehetseges inputok kiiratasa
			 */
			if(Game.fileMode && Game.gameStatus != 2){
				try{
					Game.bufferedWriter.write("Lehetseges inputok: gamestart, bigtower, smalltower, enemy , shiftingsand, swamp, printdefensetools, printall, firingspeedincreaserstone, rangeextenderstone, elfdwarfspecializedstone, tick, endgame, exit");
					Game.bufferedWriter.newLine();
					if(command != null && command[0].equals("printall") == false)
						Game.bufferedWriter.newLine();
				}
				catch(IOException ex) {
					System.out.println("Hibas output fajl.");
				}
			}
			else{
				System.out.println("Lehetseges inputok: gamestart, bigtower, smalltower, enemy , shiftingsand, \nswamp, printdefensetools, printall, firingspeedincreaserstone, \nrangeextenderstone, elfdwarfspecializedstone, tick, endgame, exit");
				System.out.println("input:");	
			}
			/**
			 * input beolvasasa
			 */
			if(Game.fileMode){
				/**
				 * input beolvasasa fajbol
				 */
				try{
					/**
					 * beolvassuk a sort a fajlbol, illetve break ha a vegere ertunk
					 */
					if((line = bufferedReader.readLine()) == null)
						break;
				}
				catch(FileNotFoundException ex) {
					System.out.println("Hibas az input fajl.");
				}
				catch(IOException ex) {
					System.out.println("Hibas az input fajl.");
				}
			}
			else{
				/**
				 * input beolvasasa konzolrol
				 */
				try {
					line = buff.readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			/**
			 * szokozoknel tagolas
			 */
			String line2 = line.toLowerCase();
			command = line2.split(" ");
			/**
			 * jatek kezdese
			 */
			if(command.length == 1 && command[0].equals("gamestart")){
				if(Game.fileMode){
					try{
						Game.bufferedWriter.newLine();
						Game.bufferedWriter.write("A jatekmenet elindult.");
						Game.bufferedWriter.newLine();
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				else{
					System.out.println("A jatekmenet elindult.");
					System.out.println();					
				}
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
					/**
					 * ha van eleg varazsero
					 */
					if(Map.player.getMagicPower() >= defenseTool.cost){
						int y = -1;
						int x = -1;
						try{
							y = Integer.parseInt(command[1]);
							x = Integer.parseInt(command[2]);
						} catch(NumberFormatException e) { 
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A koordinatakat szam formatumban kell megadni");
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A koordinatakat szam formatumban kell megadni");				
							}
						}
						if(x >= 0 && x <= 24 && y >= 0 && y <= 24 && Map.mainMap[y][x].getRoadFlag() == false){
							defenseTool.position.setRowValue(y);
							defenseTool.position.setColumnValue(x);
							Map.player.createDefenseTool(defenseTool);
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("Letrejott egy bigtower az alabbi cellan: "+y+" "+x);
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("Letrejott egy bigtower az alabbi cellan: "+y+" "+x);
							}
						}
						else{
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A megadott koordinata nem helyes");
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A megadott koordinata nem helyes");			
							}
						}
					}
					else{
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Nincs elegendo varazsero");
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Nincs elegendo varazsero");			
						}
					}


				}
				/**
				 * kis torony epitese
				 */
				else if(command.length == 3 && command[0].equals("smalltower")){
					SmallTower defenseTool = new SmallTower();
					/**
					 * ha van eleg varazsero
					 */
					if(Map.player.getMagicPower() >= defenseTool.cost){
						int y = -1;
						int x = -1;
						try{
							y = Integer.parseInt(command[1]);
							x = Integer.parseInt(command[2]);
						} catch(NumberFormatException e) { 
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A koordinatakat szam formatumban kell megadni");
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A koordinatakat szam formatumban kell megadni");				
							}
						}
						if(x >= 0 && x <= 24 && y >= 0 && y <= 24 && Map.mainMap[y][x].getRoadFlag() == false){
							defenseTool.position.setRowValue(y);
							defenseTool.position.setColumnValue(x);
							Map.player.createDefenseTool(defenseTool);
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("Letrejott egy smalltower az alabbi cellan: "+y+" "+x);
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("Letrejott egy smalltower az alabbi cellan: "+y+" "+x);
							}
						}
						else{
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A megadott koordinata nem helyes");
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A megadott koordinata nem helyes");			
							}
						}
					}
					else{
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Nincs elegendo varazsero");
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Nincs elegendo varazsero");			
						}
					}

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
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("A koordinatakat szam formatumban kell megadni");
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("A koordinatakat szam formatumban kell megadni");				
						}
					}
					if((!(x >= 0 && x <= 24 && y >= 0 && y <= 24))  || (Map.mainMap[y][x].getRoadFlag() == false)){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("A megadott koordinata nem helyes");
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("A megadott koordinata nem helyes");			
						}
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
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Letrejott egy hobbit az alabbi cellan: "+y+" "+x);
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Letrejott egy hobbit az alabbi cellan: "+y+" "+x);
						}
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
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Letrejott egy human az alabbi cellan: "+y+" "+x);
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Letrejott egy human az alabbi cellan: "+y+" "+x);
						}
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
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Letrejott egy dwarf az alabbi cellan: "+y+" "+x);
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Letrejott egy dwarf az alabbi cellan: "+y+" "+x);
						}
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
						/**
						 * enemy hozzaadasa modellhez es view-hoz
						 */
						Map.enemies.add(enemy);
						View.enemyviews.add(new EnemyView(enemy));
						
						for(Tower t : Map.towers){
							Map.enemies.get(Map.enemies.indexOf(enemy)).addObserver(t);
						}
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Letrejott egy elf az alabbi cellan: "+y+" "+x);
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Letrejott egy elf az alabbi cellan: "+y+" "+x);
						}
					}    
				}
				/**
				 * futohomok letrehozasa
				 */
				else if(command.length == 3 && command[0].equals("shiftingsand")){
					ShiftingSand defenseTool = new ShiftingSand();
					/**
					 * ha van eleg varazsero
					 */
					if(Map.player.getMagicPower() >= defenseTool.cost){
						int y = -1;
						int x = -1;
						try{
							y = Integer.parseInt(command[1]);
							x = Integer.parseInt(command[2]);
						} catch(NumberFormatException e) { 
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A koordinatakat szam formatumban kell megadni");
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A koordinatakat szam formatumban kell megadni");
							}
						}
						if(x >= 0 && x <= 24 && y >= 0 && y <= 24 && Map.mainMap[y][x].getRoadFlag()){
							defenseTool.position.setRowValue(y);
							defenseTool.position.setColumnValue(x);
							Map.player.createDefenseTool(defenseTool);
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("Letrejott egy shiftingsand az alabbi cellan: "+y+" "+x);
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("Letrejott egy shiftingsand az alabbi cellan: "+y+" "+x);
							}
						}
						else{
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A megadott koordinata nem helyes");
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A megadott koordinata nem helyes");
							}
						}
					}
					else{
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Nincs elegendo varazsero");
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Nincs elegendo varazsero");
						}
					}
					
				}
				/**
				 * mocsar letrehozasa
				 */
				else if(command.length == 3 && command[0].equals("swamp")){
					Swamp defenseTool = new Swamp();
					/**
					 * ha van eleg varazsero
					 */
					if(Map.player.getMagicPower() >= defenseTool.cost){
						int y = -1;
						int x = -1;
						try{
							y = Integer.parseInt(command[1]);
							x = Integer.parseInt(command[2]);
						} catch(NumberFormatException e) { 
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A koordinatakat szam formatumban kell megadni");
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A koordinatakat szam formatumban kell megadni");
							}
						}
						if(x >= 0 && x <= 24 && y >= 0 && y <= 24 && Map.mainMap[y][x].getRoadFlag()){
							defenseTool.position.setRowValue(y);
							defenseTool.position.setColumnValue(x);
							Map.player.createDefenseTool(defenseTool);
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("Letrejott egy swamp az alabbi cellan: "+y+" "+x);
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("Letrejott egy swamp az alabbi cellan: "+y+" "+x);
							}
						}
						else{
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A megadott koordinata nem helyes");
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A megadott koordinata nem helyes");
							}
						}
					}
					else{
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Nincs elegendo varazsero");
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Nincs elegendo varazsero");
						}
					}
				}
				/**
				 * a vedelmi eszkozok kiiratasa
				 */
				else if(command.length == 1 && command[0].equals("printdefensetools")){
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("tick "+Map.getTickCount());
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("tick "+Map.getTickCount());
					}
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("player varazsereje "+Map.player.getMagicPower());
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("player varazsereje "+Map.player.getMagicPower());
					}
					//Tornyok kiiratasa
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("tornyok listaja:");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("tornyok listaja:");
					}
					if(Map.towers.isEmpty()){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("nincs torony");
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("nincs torony");
						}
					}
					else{
						LinkedList<Tower> towers = Map.getTowers();
						for(Tower element : towers){
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
							}
						}
					}
					if(Game.fileMode){
						try{
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println();
					}
					//Akadalyok kiiratasa
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("akadalyok listaja:");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("akadalyok listaja:");
					}
					if(Map.barriers.isEmpty()){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("nincs akadaly");
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("nincs akadaly");
						}
					}
					else{
						LinkedList<Barrier> barriers = Map.getBarriers();
						for(Barrier element : barriers){
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
							}
						}
					}
					if(Game.fileMode){
						try{
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println();
					}
					//Varazskovek kiiratasa
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("varazskovek listaja:");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("varazskovek listaja:");
					}
					if(Map.magicStones.isEmpty()){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("nincs varazsko");
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("nincs varazsko");
						}
					}
					else{
						LinkedList<MagicStone> magicStones = Map.getMagicStones();
						for(MagicStone element : magicStones){
							if(element instanceof FiringSpeedIncreaseStone == false){
								if(Game.fileMode){
									try{
										Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
										Game.bufferedWriter.newLine();
									}
									catch(IOException ex) {
										System.out.println("Hibas output fajl.");
									}
								}
								else{
									System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
								}
							}
							else{
								if(Game.fileMode){
									try{
										Game.bufferedWriter.write("FiringSpeedIncreaserStone"+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
										Game.bufferedWriter.newLine();
									}
									catch(IOException ex) {
										System.out.println("Hibas output fajl.");
									}
								}
								else{
									System.out.println("FiringSpeedIncreaserStone"+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
								}
							}
						}
					}
					if(Game.fileMode){
						try{
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println();
					}
				}
				/**
				 * jatekot erinto attributumok kiiratasa
				 */
				else if(command.length == 1 && command[0].equals("printall")){
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("tick "+Map.getTickCount());
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("tick "+Map.getTickCount());
					}
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("player varazsereje "+Map.player.getMagicPower());
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("player varazsereje "+Map.player.getMagicPower());
					}
					//Tornyok kiiratasa
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("tornyok listaja:");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("tornyok listaja:");
					}
					if(Map.towers.isEmpty()){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("nincs torony");
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("nincs torony");
						}
					}
					else{
						LinkedList<Tower> towers = Map.getTowers();
						for(Tower element : towers){
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
							}
						}
					}
					if(Game.fileMode){
						try{
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println();
					}
					//Akadalyok kiiratasa
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("akadalyok listaja:");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("akadalyok listaja:");
					}
					if(Map.barriers.isEmpty()){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("nincs akadaly");
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("nincs akadaly");
						}
					}
					else{
						LinkedList<Barrier> barriers = Map.getBarriers();
						for(Barrier element : barriers){
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
							}
						}
					}
					if(Game.fileMode){
						try{
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println();
					}
					//Varazskovek kiiratasa
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("varazskovek listaja:");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("varazskovek listaja:");
					}
					if(Map.magicStones.isEmpty()){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("nincs varazsko");
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("nincs varazsko");
						}
					}
					else{
						LinkedList<MagicStone> magicStones = Map.getMagicStones();
						for(MagicStone element : magicStones){
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
							}
						}
					}
					if(Game.fileMode){
						try{
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println();
					}
					//Ellenfelek kiiaratasa
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("ellenfelek:");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("ellenfelek:");
					}
					if(Map.enemies.isEmpty()){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("nincs ellenfel");
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("nincs ellenfel");
						}
					}
					else{
						LinkedList<Enemy> enemies = Map.getEnemies();
						for(Enemy element : enemies){
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue()+" "+element.getHealth());
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println(element.getClass().toString().substring(11).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue()+" "+element.getHealth());
							}
						}
					}
					if(Game.fileMode){
						try{
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println();
					}
				}
				/**
				 * tuzelesi gyakorisagot novelo ko letrehozasa
				 */
				else if(command.length == 3 && command[0].equals("firingspeedincreaserstone")){
					FiringSpeedIncreaseStone defenseTool = new FiringSpeedIncreaseStone();
					if(Map.player.getMagicPower() >= defenseTool.cost){
						int y = -1;
						int x = -1;
						try{
							y = Integer.parseInt(command[1]);
							x = Integer.parseInt(command[2]);
						} catch(NumberFormatException e) { 
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A koordinatakat szam formatumban kell megadni");
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A koordinatakat szam formatumban kell megadni");
							}
						}
						if(x >= 0 && x <= 24 && y >= 0 && y <= 24){
							defenseTool.position.setRowValue(y);
							defenseTool.position.setColumnValue(x);
							Map.player.createDefenseTool(defenseTool);
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("Letrejott egy firingspeedincreaserstone az alabbi cellan: "+y+" "+x);
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("Letrejott egy firingspeedincreaserstone az alabbi cellan: "+y+" "+x);
							}
						}
						else{
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A megadott koordinata nem helyes");
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A megadott koordinata nem helyes");
							}
						}
					}
					else{
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Nincs elegendo varazsero");
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Nincs elegendo varazsero");
						}
					}
					
				}
				/**
				 * hatotavot novelo ko letrehozasa
				 */
				else if(command.length == 3 && command[0].equals("rangeextenderstone")){
					RangeExtenderStone defenseTool = new RangeExtenderStone();
					/**
					 * ha van eleg varazsero
					 */
					if(Map.player.getMagicPower() >= defenseTool.cost){
						int y = -1;
						int x = -1;
						try{
							y = Integer.parseInt(command[1]);
							x = Integer.parseInt(command[2]);
						} catch(NumberFormatException e) { 
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A koordinatakat szam formatumban kell megadni");
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A koordinatakat szam formatumban kell megadni");
							}
						}
						if(x >= 0 && x <= 24 && y >= 0 && y <= 24 ){
							defenseTool.position.setRowValue(y);
							defenseTool.position.setColumnValue(x);
							Map.player.createDefenseTool(defenseTool);
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("Letrejott egy rangeextenderstone az alabbi cellan: "+y+" "+x);
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("Letrejott egy rangeextenderstone az alabbi cellan: "+y+" "+x);
							}
						}
						else{
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A megadott koordinata nem helyes");
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A megadott koordinata nem helyes");
							}
						}
					}
					else{
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Nincs elegendo varazsero");
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Nincs elegendo varazsero");
						}
					}
					
				}
				/**
				 * specialis ko letrehozasa
				 */
				else if(command.length == 3 && command[0].equals("elfdwarfspecializedstone")){
					ElfDwarfSpecializedStone defenseTool = new ElfDwarfSpecializedStone();
					/**
					 * ha van eleg varazsero
					 */
					if(Map.player.getMagicPower() >= defenseTool.cost){
						int y = -1;
						int x = -1;
						try{
							y = Integer.parseInt(command[1]);
							x = Integer.parseInt(command[2]);
						} catch(NumberFormatException e) { 
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A koordinatakat szam formatumban kell megadni");
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A koordinatakat szam formatumban kell megadni");
							}
						}
						if(x >= 0 && x <= 24 && y >= 0 && y <= 24){
							defenseTool.position.setRowValue(y);
							defenseTool.position.setColumnValue(x);
							Map.player.createDefenseTool(defenseTool);
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("Letrejott egy elfdwarfspecializedstone az alabbi cellan: "+y+" "+x);
									Game.bufferedWriter.newLine();
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("Letrejott egy elfdwarfspecializedstone az alabbi cellan: "+y+" "+x);
							}
						}
						else{
							if(Game.fileMode){
								try{
									Game.bufferedWriter.write("A megadott koordinata nem helyes");
									Game.bufferedWriter.newLine();
								}
								catch(IOException ex) {
									System.out.println("Hibas output fajl.");
								}
							}
							else{
								System.out.println("A megadott koordinata nem helyes");
							}
						}
					}
					else{
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write("Nincs elegendo varazsero");
								Game.bufferedWriter.newLine();
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
						else{
							System.out.println("Nincs elegendo varazsero");
						}
					}
					
				}
				/**
				 * tick, orajel kiadasa
				 */
				else if((command.length == 1 || command.length == 2) && command[0].equals("tick")){
					if(command.length == 1){
						MyTimer.tick();

						if(Game.fileMode){
							try{
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
					}
					if(command.length == 2){
						if(command[1].equals("fog")){
							if(Game.isFog == false)
								Game.fogPrint=true;
							Game.isFog= !Game.isFog;
							MyTimer.tick();
						}
						else if(command[1].equals("special")){
							Game.isSpecial=true;
							MyTimer.tick();
						}
						else{
							int tickPar = -1;
							try{
								tickPar = Integer.parseInt(command[1]);
							} catch(NumberFormatException e) {
								if(Game.fileMode){
									try{
										Game.bufferedWriter.write("Helytelen tick parameter");
										Game.bufferedWriter.newLine();
									}
									catch(IOException ex) {
										System.out.println("Hibas output fajl.");
									}
								}
								else{
									System.out.println("Helytelen tick parameter");
								}
							}
							if(tickPar > 0){
								for(int i = 0;i < tickPar; i++){
									MyTimer.tick();
								}
								/**
								 * tick sorozat utan a fajl outputban legyen kihagyott sor
								 */
								if(Game.fileMode){
									try{
										Game.bufferedWriter.newLine();
									}
									catch(IOException ex) {
										System.out.println("Hibas output fajl.");
									}
								}
							}
							else{
								if(Game.fileMode){
									try{
										Game.bufferedWriter.write("A ticknek egy pozitiv egesz szamot kell megadni");
										Game.bufferedWriter.newLine();
									}
									catch(IOException ex) {
										System.out.println("Hibas output fajl.");
									}
								}
								else{
									System.out.println("A ticknek egy pozitiv egesz szamot kell megadni");
								}
							}
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
					/**
					 * flag beallitasa
					 */
					Game.gameStatus = 2;
				}
				else if(command.length == 1 && command[0].equals("exit")){
					if(Game.fileMode){
						/**
						 * BufferedReader/Writer lezarasa
						 */
						try {
							bufferedReader.close();
							Game.bufferedWriter.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
					/**
					 * break-rol atirtam return-re, hogy ne legyen dupla inputlista az output vegen
					 */
					return;
				}
				/**
				 * ha nem a megadott inputok kozul valasztott a felhasznalo
				 */
				else{
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("Hibas parancs!");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println("Hibas parancs!");
					}
				}
			}
			else{
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("Elobb el kell inditani a jatekmenetet (gamestart)");
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				else{
					System.out.println("Elobb el kell inditani a jatekmenetet (gamestart)");
				}
			}
			/**
			 * itt kezeljuk ha a jatekos hibas inputot gepel be
			 */
		}
	}
}
