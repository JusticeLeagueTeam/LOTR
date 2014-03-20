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
		
		SmallTower sm = new SmallTower();	//teszteleshez
		Map.player.createDefenseTool(sm);
		
		//String s = new String();
		
		/*
		while(s.equals("exit")==false){
		System.out.println("input:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		*/
		
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

	        	st.getCost();
	        	
	        	//todo: osszes enemy feliratkozik a tower observerrre
	        	//ezt szekv diagramon jelezni - arnold
		        }
		        
		        else if(command.length == 1 && command[0].equals("enemy")){
		        	//map.tick() hÄivja a createEnemy()-t - arnold
		        	map.tick();
		        	//todo: osszes torony observerre feliratkozik - arnold
		        	//ezt szekv diagramon jelezni - arnold
		        	
		        }
		        
		        else if(command.length == 1 && command[0].equals("move")){
		        	timer.tick();
		        	map.tick();
		        	//szekv diagramban enemyobjektum.tick() lenne, de helyette: - arnold
		        	LinkedList lili=map.getEnemies();
		        	//todo: forciklus vegigmegy rajtuk is mindegyiken tick() - arnold
		
		        	//todo: forciklus vegigmegy rajtuk es megnezi, hogy
		        	//todo: fajtol fuggetlen oszthato-e a tick_counter fajnak megfelelo sebesseggel (pl 5-tel) - arnold
		        	//todo: amelyik enemynel ez fenn all ott:
		        	
		        	Enemy e=new Enemy();
		        	e.tick();
		        }
		        
		        else if(command.length == 2 && command[0].equals("tower") && command[1].equals("attack")){
		        	timer.tick();
		        	map.tick();
		        	Enemy e=new Enemy();//todo: itt is forciklusos tema lenne - arnold
		        	//todo: tehat ezt minden toronynal eljatszuk majd meg minden enemynel - arnold
		        	e.tick();
		        	Tower t=new Tower();
		        	t.tick();
		        	e.notifyObservers();//itt szekv diagramon a nyilat lehet, hogy elrontottam - arnold
		        	//onmagaba fordulo nyil kellene - arnold
		        	System.out.println("Observable notifyObservers - ellenfel lepett, ezt jelzi az osszes toronynak");
		        	
		        	System.out.println("Ha az ellenfel hatotavon belul van");
		        	t.update(e);
		        	e.Attacked(t.getFiringRange());//Attacked szekv UML-ben benne van, de szkeletonbol kimaradt - arnold
		        	//valszeg osztalydiagramban sincs benne - arnold
		        	Map.player.setMagicPower(50);// - todo: parameter - arnold
		        	
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
		        	//todo:szekv diagramban lemaradt a varazsero levonasa
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



