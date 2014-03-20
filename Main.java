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
		Timer timer=new Timer();
		Map map=new Map();
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		//ez majd ahhoz kell, amikor pl. beadta a user, hogy "enemy" es visszakerdezunk hogy milyen enemyt hozzon letre
		BufferedReader buff2 = new BufferedReader(new InputStreamReader(System.in));
		String line2;
		
		while(true){
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
			
			else if(command.length == 1 && command[0].equals("tower")){
	        	SmallTower st=new SmallTower();
	        	Map.player.createDefenseTool(st);

	        	//st.getCost(); - ez sztem createDefenseTool-on belulre kell - arnold
	        	
	        	//todo:az osszes enemy feliratkozik a tower observerrre - arnold
		        }
		        
		        else if(command.length == 1 && command[0].equals("enemy")){
		        	//map.tick() hivja a createEnemy()-t - arnold
		        	map.tick();
		        	//implementacional az osszes torony observerre feliratkozik - arnold
		        }
		        
		        else if(command.length == 1 && command[0].equals("move")){
		        	timer.tick();
		        	map.tick();
		        	LinkedList lili=map.getEnemies();
		        	//implemenacional forciklus vegigmegy rajtuk - arnold
		        	
		        	Enemy e=new Enemy();
		        	e.tick();
		        }
		        
		        else if(command.length == 2 && command[0].equals("tower") && command[1].equals("attack")){
		        	timer.tick();
		        	map.tick();
		        	Enemy e=new Enemy();//implementacional forciklusos megoldas lesz
		        	e.tick();
		        	Tower t=new Tower();
		        	t.tick();
		        	e.notifyObservers();
		        	System.out.println("Observable notifyObservers - ellenfel lepett, ezt jelzi az osszes toronynak");
		        	
		        	System.out.println("Ha az ellenfel hatotavon belul van");
		        	t.update(e);
		        	e.Attacked(t.getFiringRange());
		        	Map.player.setMagicPower(50);
		        	
		        	System.out.println("Ha az ellenfel eletereje eleri a nullat");
		        	System.out.println("Enemy dispose()");
		        }
		        
		        else if(command.length == 1 && command[0].equals("barrier")){
		        	System.out.println("Ha van eleg varazsero akadaly letrehozasahoz");
		        	//implementacional ciklusos tema - arnold
		        }
		        
		        else if(command.length == 2 && command[0].equals("barrier") && command[1].equals("slowdown")){
		        	//implementacional forciklus lesz - arnold
		        	Enemy e=new Enemy();
		        	e.notifyObservers();
		        	Barrier b=new Barrier();
		        	b.update(e, new Object());
		        	b.effectEnemy();
		        	System.out.println("Ha egy cellaban vannak:");
		        	e.setSpeed(15);
		        }
		        
		        else if(command.length == 1 && command[0].equals("magicstone")){
		        	//todo:createdefensestone helyett get/set - arnold
		        	FiringSpeedIncreaseStone fsi=new FiringSpeedIncreaseStone();
		        	Map.player.setMagicPower(15);
		        }
		        
		        else if(command.length == 2 && command[0].equals("magicstone") && command[1].equals("effect")){
		        	FiringSpeedIncreaseStone fsi=new FiringSpeedIncreaseStone();
		        	Tower t=new Tower();
		        	System.out.println("Ha egy cellaban vannak:");
		        	t.setFiringSpeed(15);
		        }
		        
		        else if(command.length == 1 && command[0].equals("endgame")){
		        	timer.tick();
		        	game.tick();
		        	System.out.println("Ha elpusztult minden ellenseg:");
		        	game.winGame();
		        	System.out.println("Ha az ellenseg elert a Vegzet Hegyehez:");
		        	game.endGame();
		        }
		        
		        else{
					System.out.println("Hibas parancs!");
		        }
		}
	}
}



