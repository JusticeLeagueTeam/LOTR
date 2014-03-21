package LOTR;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Justice League's sceleton!");
		//A szekvenciaval konzisztens create() sorrendet tartsunk
		//korabbi 4.4.1 Jatek inditasa
		Game game=new Game();
		//Timer timer=new Timer();
		//Map map=new Map();
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		//ez majd ahhoz kell, amikor pl. beadta a user, hogy "enemy" es visszakerdezunk hogy milyen enemyt hozzon letre
		BufferedReader buff2 = new BufferedReader(new InputStreamReader(System.in));
		String line2;
		
		while(true){
			System.out.println("\nLehetseges inputok: bigtower, smalltower, enemy, move, tower attack, shiftingsand, swamp, barrier slowdown, firingspeedincreaserstone, rangeextenderstone, elfdwarfspecializedstone, magicstone effect, endgame, exit");
			System.out.println("input:");
			try {
				line = buff.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String[] command = line.split(" ");
			
			if(command.length == 1 && command[0].equals("exit")){
				break;
			}
			
			else if(command.length == 1 && command[0].equals("smalltower")){
	        	SmallTower st=new SmallTower();
	        	Map.player.createDefenseTool(st);
		        }
			else if(command.length == 1 && command[0].equals("bigtower")){
	        	BigTower bt=new BigTower();
	        	Map.player.createDefenseTool(bt);
		        }
		        
		        else if(command.length == 1 && command[0].equals("enemy")){
		        	//map.tick() hivja a createEnemy()-t - arnold
		        	Map.tickFlag=1;
		        	Map.tick();
		        	//implementacional az osszes torony observerre feliratkozik - arnold
		        }
		        
		        else if(command.length == 1 && command[0].equals("move")){
	        		
		        	Map.tickFlag=2;
		        	Map.tick();		        
		        }
		        
		        else if(command.length == 2 && command[0].equals("tower") && command[1].equals("attack")){
		        	Map.tickFlag=3;
		        	LinkedList<Enemy> enemiesLinkedList= Map.getEnemies();
		        	LinkedList<Tower> towersLinkedList = Map.getTowers();
		        	if(enemiesLinkedList.size() == 0 || towersLinkedList.size() == 0)
		        	{
		        		System.out.println("Meg nem jott letre enemy(ellenfel) vagy tower(torony)!");
		        	}
		        	else
		        	{
			        	Game.timer.tick();
			        	Map.tick();
		        		for(Enemy e : enemiesLinkedList)
			        	{
			        		e.tick();
				        	e.notifyObservers();
				        	System.out.println("Observable notifyObservers - ellenfel lepett, ezt jelzi az osszes toronynak");
				        	
				        	for(Tower t : towersLinkedList)
				        	{
					        	System.out.println("[IF] Ha az ellenfel hatotavon belul van");
					        	t.update(e);
					        	e.Attacked(t.getFiringRange());				        	
					        	System.out.println("[IF] Ha az ellenfel eletereje eleri a nullat");
					        	System.out.println("Enemy dispose()");
				        	}				        	
			        	}
		        	}		        			        
		        }
		        
		        else if(command.length == 1 && command[0].equals("shiftingsand")){
		        	System.out.println("[IF] Ha van eleg varazsero akadaly letrehozasahoz");
		        	ShiftingSand sand = new ShiftingSand();
		        	Map.player.createDefenseTool(sand);
		        }
			
		        else if(command.length == 1 && command[0].equals("swamp")){
		        	System.out.println("[IF] Ha van eleg varazsero akadaly letrehozasahoz");
	        		Swamp swamp = new Swamp();
	        		Map.player.createDefenseTool(swamp);
		        }
		        
		        else if(command.length == 2 && command[0].equals("barrier") && command[1].equals("slowdown")){
		        	
		        	LinkedList<Barrier> barrierLinkedList = Map.getBarriers();
		        	LinkedList<Enemy> enemiesLinkedList= Map.getEnemies();
		        	
		        	if(barrierLinkedList.size() == 0 || enemiesLinkedList.size() == 0)
		        	{
		        		System.out.println("Meg nem jott letre barrier(akadaly) vagy ellenseg(enemy)!");
		        	}
		        	else
		        	{
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
		        
		        else if(command.length == 1 && command[0].equals("firingspeedincreaserstone")){
		        	FiringSpeedIncreaseStone fsi=new FiringSpeedIncreaseStone();
		        	Map.magicStones.add(fsi);
		        	fsi.getCost();
		        	Map.player.setMagicPower(15);
		        }
			
		        else if(command.length == 1 && command[0].equals("rangeextenderstone")){
		        	RangeExtenderStone res=new RangeExtenderStone();
		        	Map.magicStones.add(res);
		        	res.getCost();
		        	Map.player.setMagicPower(25);
		        }
			
		        else if(command.length == 1 && command[0].equals("elfdwarfspecializedstone")){
		        	ElfDwarfSpecializedStone eds=new ElfDwarfSpecializedStone();
		        	Map.magicStones.add(eds);
		        	eds.getCost();
		        	Map.player.setMagicPower(30);
		        }
		        
		        else if(command.length == 2 && command[0].equals("magicstone") && command[1].equals("effect")){
		        	LinkedList<MagicStone> magicStoneLinkedList = Map.getMagicStones();
		        	LinkedList<Barrier> barrierLinkedList = Map.getBarriers();
		        	LinkedList<Tower> towersLinkedList = Map.getTowers();
		        	
		        	if(magicStoneLinkedList.size() == 0 && (barrierLinkedList.size()==0 || towersLinkedList.size()==0))
		        	{		 
		        		System.out.println("Meg nem jott letre tower(torony) vagy barrier(akadaly)!");
		        	}
		        	else
		        	{
		        		for(MagicStone m : magicStoneLinkedList)
		        		{
		        			if(m instanceof FiringSpeedIncreaseStone)
		        			{
		        				System.out.println("FiringSpeedIncreaserStone hasznalata a grafikus feluleten kivalasztott tornyon");
		    		        	System.out.println("[IF] Ha egy cellaban vannak");
		        				m.effectTower();
		        				m.setWasItUsed(true);
		        			}
		        			if(m instanceof RangeExtenderStone)
		        			{
		        				System.out.println("FiringSpeedIncreaserStone hasznalata a grafikus feluleten kivalasztott tornyon");
		        				System.out.println("[IF] Ha egy cellaban vannak");
		        				m.effectTower();
		        				m.setWasItUsed(true);		        				
		        			}
		        			if(m instanceof ElfDwarfSpecializedStone)
		        			{
		        				System.out.println("FiringSpeedIncreaserStone hasznalata a grafikus feluleten kivalasztott tornyon vagy akadalyon");
		        				System.out.println("[IF] Ha egy cellaban vannak");
		        				((ElfDwarfSpecializedStone) m).effectDefenseTool();
		        				m.setWasItUsed(true);
		        			}
		        		}
		        	}

		        }
		        
		        else if(command.length == 1 && command[0].equals("endgame")){
		        	Game.timer.tick();
		        	game.tick();
		        	System.out.println("[IF] Ha elpusztult minden ellenseg:");
		        	game.winGame();
		        	System.out.println("[IF] Ha az ellenseg elert a Vegzet Hegyehez:");
		        	game.endGame();
		        }
		        
		        else{
					System.out.println("Hibas parancs!");
		        }
		}
	}
}



