package LOTR;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Udvozollek a Justice League szkeleton programjaban!");
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
			System.out.println("\nLehetseges inputok: bigtower, smalltower, enemy, \nmove, tower attack, shiftingsand, \nswamp, barrier slowdown, firingspeedincreaserstone, \nrangeextenderstone, elfdwarfspecializedstone, \nmagicstone effect, endgame, exit");
			System.out.println("input:");
			try {
				line = buff.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String line2 = line.toLowerCase();
			String[] command = line2.split(" ");
			/**
			 * kilepes
			 */
			if(command.length == 1 && command[0].equals("exit")){
				break;
			}
			/**
			 * kis torony epitese
			 */
			else if(command.length == 1 && command[0].equals("smalltower")){
	        	SmallTower st=new SmallTower();
	        	Map.player.createDefenseTool(st);
		        }
			/**
			 * nagy torony epitese
			 */
			else if(command.length == 1 && command[0].equals("bigtower")){
	        	BigTower bt=new BigTower();
	        	Map.player.createDefenseTool(bt);
		        }
			/**
			 * ellenfel generalasa
			 */
		        
		        else if(command.length == 1 && command[0].equals("enemy")){
		        	/**
		        	 * tickFlag alapjan tudni fogja a Map tick metodusa, hogy melyik input
		        	 * hivodott meg
		        	 * ez azert jo mert pl nem fog mindig enemy-t gyartani amikor
		        	 * pl csak leptetni akarunk
		        	 * 
		        	 * nincs ra szekv diagram
		        	 */
		        	Map.tickFlag=1;
		        	Map.tick();
		        }
		        /**
		         * ellenfel leptetese
		         */
		        else if(command.length == 1 && command[0].equals("move")){
	        		/**
	        		 * ott csak leptet a Mai
	        		 */
		        	Map.tickFlag=2;
		        	Map.tick();		        
		        }
		        /**
		         * torony megtamadja a kozelben levo ellenfelet
		         */
		        else if(command.length == 2 && command[0].equals("tower") && command[1].equals("attack")){
		        	/**
		        	 * tickFLag 3 hogy ne generaljon uj enemy-t
		        	 */
		        	Map.tickFlag=3;
		        	/**
		        	 * osszes torony es osszes ellenfel listajat lekerjuk
		        	 */
		        	LinkedList<Enemy> enemiesLinkedList= Map.getEnemies();
		        	LinkedList<Tower> towersLinkedList = Map.getTowers();
		        	/**
		        	 * ha akar az egyik lista ures akkor nincs ertelme az egesznek
		        	 */
		        	if(enemiesLinkedList.size() == 0 || towersLinkedList.size() == 0)
		        	{
		        		System.out.println("Meg nem jott letre enemy(ellenfel) vagy tower(torony)!");
		        	}
		        	else
		        	{
		        		/**
		        		 * orajel leptetes
		        		 */
			        	Game.timer.tick();
			        	Map.tick();
			        	/**
			        	 * osszes ellenfel lep egyet
			        	 * errol ertesitik az osszes tornyot
			        	 * observer minta szerint
			        	 */
		        		for(Enemy e : enemiesLinkedList)
			        	{
			        		e.tick();
				        	e.notifyObservers();
				        	System.out.println("Observable notifyObservers - ellenfel lepett, ezt jelzi az osszes toronynak");
				        	
				        	for(Tower t : towersLinkedList)
				        	{
				        		/**
				        		 * hatotavon beluli ellenfeleket tamadas eri
				        		 */
					        	System.out.println("[IF] Ha az ellenfel hatotavon belul van");
					        	t.update(e);
					        	e.Attacked(t.getFiringRange());				
					        	/**
					        	 * ellenfelek halalarol is gondoskodunk
					        	 */
					        	System.out.println("[IF] Ha az ellenfel eletereje eleri a nullat");
					        	System.out.println("Enemy dispose()");
				        	}				        	
			        	}
		        	}		        			        
		        }
		        /**
		         * futohomok letrehozasa
		         */
		        else if(command.length == 1 && command[0].equals("shiftingsand")){
		        	System.out.println("[IF] Ha van eleg varazsero akadaly letrehozasahoz");
		        	ShiftingSand sand = new ShiftingSand();
		        	Map.player.createDefenseTool(sand);
		        }
				/**
				 * mocsar letrehozasa
				 */
		        else if(command.length == 1 && command[0].equals("swamp")){
		        	System.out.println("[IF] Ha van eleg varazsero akadaly letrehozasahoz");
	        		Swamp swamp = new Swamp();
	        		Map.player.createDefenseTool(swamp);
		        }
		        /**
		         * akadaly lelassitja az ellenfelet aki ralep
		         */
		        else if(command.length == 2 && command[0].equals("barrier") && command[1].equals("slowdown")){
		        	/**
		        	 * osszes akadalyt es ellenfelet lekerjuk
		        	 */
		        	LinkedList<Barrier> barrierLinkedList = Map.getBarriers();
		        	LinkedList<Enemy> enemiesLinkedList= Map.getEnemies();
		        	/**
		        	 * ha legalabb az egyik lista ures akkor nincs ertelme
		        	 */
		        	if(barrierLinkedList.size() == 0 || enemiesLinkedList.size() == 0)
		        	{
		        		System.out.println("Meg nem jott letre barrier(akadaly) vagy ellenseg(enemy)!");
		        	}
		        	else
		        	{
		        		/**
		        		 * osszes ellenfelelnel megnezzuk, hogy akadalyra lepett-e
		        		 */
		        		for(Enemy e : enemiesLinkedList)
		        		{
				        	e.notifyObservers();
			        		for(Barrier b : barrierLinkedList)
			        		{
					        	b.update(e, new Object());
					        	b.effectEnemy();
					        	System.out.println("[IF] Ha egy cellaban vannak:");
					        	e.setSpeed(15);
			        		}
		        		}		        
		        	}
		        }
		        /**
		         * tuzelesi gyakorisagot novelo ko letrehozasa
		         */
		        else if(command.length == 1 && command[0].equals("firingspeedincreaserstone")){
		        	FiringSpeedIncreaseStone fsi=new FiringSpeedIncreaseStone();
		        	Map.magicStones.add(fsi);
		        	fsi.getCost();
		        	Map.player.setMagicPower(15);
		        }
				/**
				 * hatotavot novelo ko letrehozasa
				 */
		        else if(command.length == 1 && command[0].equals("rangeextenderstone")){
		        	RangeExtenderStone res=new RangeExtenderStone();
		        	Map.magicStones.add(res);
		        	res.getCost();
		        	Map.player.setMagicPower(25);
		        }
				/**
				 * specialis ko letrehozasa
				 */
		        else if(command.length == 1 && command[0].equals("elfdwarfspecializedstone")){
		        	ElfDwarfSpecializedStone eds=new ElfDwarfSpecializedStone();
		        	Map.magicStones.add(eds);
		        	eds.getCost();
		        	Map.player.setMagicPower(30);
		        }
		        /**
		         * varazsko hasznalata
		         */
		        else if(command.length == 2 && command[0].equals("magicstone") && command[1].equals("effect")){
		        	/**
		        	 * osszes varazskovet, akadalyt, tornyot lekerjuk
		        	 */
		        	LinkedList<MagicStone> magicStoneLinkedList = Map.getMagicStones();
		        	LinkedList<Barrier> barrierLinkedList = Map.getBarriers();
		        	LinkedList<Tower> towersLinkedList = Map.getTowers();
		        	/**
		        	 * ha nincs varazsko vagy nincs min alkalmazni akkor nincs ertelme hasznalni
		        	 */
		        	if(magicStoneLinkedList.size() == 0 || barrierLinkedList.size()==0 || towersLinkedList.size()==0)
		        	{		 
		        		System.out.println("Meg nem jott letre tower(torony) vagy barrier(akadaly) vagy magicstone(varazsko)!");
		        	}
		        	else
		        	{
		        		/**
		        		 * osszes varazskonel ellenorizzuk, hogy
		        		 * a.) van-e a cellajan torony vagy tipustol fuggoen (ElfDwarfSpecializedStone) akadaly
		        		 * b.) fel lett-e mar hasznalva (getWasItUsed)
		        		 * hasznalatkor a flag-et beallitjuk true-ra (setWasItUsed)
		        		 */
		        		for(MagicStone m : magicStoneLinkedList)
		        		{
		        			if(m instanceof FiringSpeedIncreaseStone && m.getWasItUsed())
		        			{
		        				System.out.println("FiringSpeedIncreaserStone hasznalata a grafikus feluleten kivalasztott tornyon");
		    		        	System.out.println("[IF] Ha egy cellaban vannak");
		        				m.effectTower();
		        				m.setWasItUsed(true);
		        			}
		        			if(m instanceof RangeExtenderStone && m.getWasItUsed())
		        			{
		        				System.out.println("FiringSpeedIncreaserStone hasznalata a grafikus feluleten kivalasztott tornyon");
		        				System.out.println("[IF] Ha egy cellaban vannak");
		        				m.effectTower();
		        				m.setWasItUsed(true);		        				
		        			}
		        			if(m instanceof ElfDwarfSpecializedStone && m.getWasItUsed())
		        			{
		        				System.out.println("FiringSpeedIncreaserStone hasznalata a grafikus feluleten kivalasztott tornyon vagy akadalyon");
		        				System.out.println("[IF] Ha egy cellaban vannak");
		        				((ElfDwarfSpecializedStone) m).effectDefenseTool();
		        				m.setWasItUsed(true);
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
		        	Game.timer.tick();
		        	game.tick();
		        	System.out.println("[IF] Ha elpusztult minden ellenseg:");
		        	game.winGame();
		        	System.out.println("[IF] Ha az ellenseg elert a Vegzet Hegyehez:");
		        	game.endGame();
		        }
		        /**
		         * itt kezeljuk ha a jatekos hibas inputot gepel be
		         */
		        else{
					System.out.println("Hibas parancs!");
		        }
		}
	}
}



