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
		
		//ez majd ahhoz kell, amikor pl. beadta a user, hogy "enemy" és visszakérdezünk hogy milyen enemyt hozzon létre
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
	        	//ez a metďż˝dus biztos kell? - arnold
	        	//igazďż˝bďż˝l a szekv diagramon is ďż˝rtelmetlen egy kicsit :) - arnold
	        	//helyette get/set-tel kell, mint a tďż˝bbi ilyen megoldďż˝snďż˝l - arnold
	        	//ezt majd javďż˝tom (createDefenTool helyett get/set-es megoldďż˝s) - arnold
	        	st.getCost();
	        	//Map.player.setMagicPower(15);//honnan szďż˝moljuk ki  a paramďż˝tert? - arnold
	        								   //ezt nem kell meghivni szerintem, a Player createdefenseTool metodusa
	        								   //automatikusan levonja a varázserőt - oliver
	        	
	        	//todo: ďż˝sszes enemy feliratkozik a tower observerrre
	        	//ezt szekv diagramon jelezni - arnold
		        }
		        
		        else if(command.length == 1 && command[0].equals("enemy")){
		        	//map.tick() hďż˝vja a createEnemy()-t - arnold
		        	map.tick();
		        	//todo: ďż˝sszes torony observerre feliratkozik - arnold
		        	//ezt szekv diagramon jelezni - arnold
		        	
		        }
		        
		        else if(command.length == 1 && command[0].equals("move")){
		        	timer.tick();
		        	map.tick();
		        	//szekv diagramban enemyobjektum.tick() lenne, de helyette: - arnold
		        	LinkedList lili=map.getEnemies();
		        	//todo: forciklus vďż˝gigmegy rajtuk ďż˝s mindegyiken tick() - arnold
		
		        	//todo: forciklus vďż˝gigmegy rajtuk ďż˝s megnďż˝zi, hogy
		        	//todo: fajtďż˝l fďż˝ggďż˝en oszthatďż˝-e a tick_counter fajnak megfelelďż˝ sebessďż˝ggel (pl 5-tel) - arnold
		        	//todo: amelyik enemynďż˝l ez fenn ďż˝ll ott:
		        	
		        	Enemy e=new Enemy();
		        	e.tick();
		        }
		        
		        else if(command.length == 2 && command[0].equals("tower") && command[1].equals("attack")){
		        	timer.tick();
		        	map.tick();
		        	Enemy e=new Enemy();//todo: itt is forciklusos tďż˝ma lenne - arnold
		        	//todo: tehďż˝t ezt minden toronynďż˝l eljďż˝tszuk majd meg minden enemynďż˝l - arnold
		        	e.tick();
		        	Tower t=new Tower();
		        	t.tick();
		        	e.notifyObservers();//itt szekv diagramon a nyilat lehet, hogy elrontottam - arnold
		        	//ďż˝nmagďż˝ba fordulďż˝ nyďż˝l kellene - arnold
		        	System.out.println("Observable notifyObservers - ellenfďż˝l lďż˝pett, ezt jelzi az ďż˝sszes toronynak");
		        	
		        	System.out.println("Ha az ellenfďż˝l hatďż˝tďż˝von belďż˝l van");
		        	t.update(e);
		        	e.Attacked(t.getFiringRange());//Attacked szekv UML-ben benne van, de szkeletonbďż˝l kimaradt - arnold
		        	//valszeg osztďż˝lydiagramban sincs benne - arnold
		        	//paramďż˝ter ďż˝rtďż˝kďż˝hez le kďż˝ne kďż˝rezni a tďż˝madďż˝erďż˝t - arnold
		        	Map.player.setMagicPower(50);// - todo: paramďż˝ter mi alapjďż˝n - arnold
		        	//setMagicPower szekv diagramon lehet, hogy ďż˝nmagďż˝ba nyďż˝lďż˝ nyilat ďż˝rdemel? - arnold
		        	
		        	System.out.println("Ha az ellenfďż˝l ďż˝letereje elďż˝ri a nullďż˝t");
		        	System.out.println("Enemy dispose()");
		        }
		        
		        else if(command.length == 1 && command[0].equals("barrier")){
		        	System.out.println("Ha van elďż˝g varďż˝zserďż˝ akadďż˝ly lďż˝trehozďż˝sďż˝hoz");
		        	//szekv diagramrďż˝l lemaradt a setMagicPower - ezt kďż˝dban ďż˝s ott is pďż˝tolni kell - arnold
		        	//ugyanďż˝gy mint ahogy a tower-nďż˝l ďż˝rtam createdefensetool helyett get/set-es megoldďż˝s kďż˝ne - arnold
		
		        	//szekv diagramban van setBarriers, de ahhoz kďż˝ne get is, hogy legyen mit mďż˝dosďż˝tani - arnold
		        	//szintďż˝n mindkďż˝t helyen javďż˝tani kďż˝ne - arnold
		        }
		        
		        else if(command.length == 2 && command[0].equals("barrier") && command[1].equals("slowdown")){
		        	//vďż˝gsďż˝ megoldďż˝sban itt is forciklus lesz ami az ďż˝sszes enemy-n vďż˝gigmegy - arnold
		        	Enemy e=new Enemy();
		        	e.notifyObservers();
		        	Barrier b=new Barrier();
		        	b.update(e, new Object());
		        	b.effectEnemy();
		        	System.out.println("Ha egy cellďż˝ban vannak:");
		        	e.setSpeed(15);//paramďż˝ter hogy jďż˝n ki? szkeletonban mďż˝g nem kell tudni - arnold
		        }
		        
		        else if(command.length == 1 && command[0].equals("magicstone")){
		        	//todo:createdefensestone helyett get/set - arnold
		        	FiringSpeedIncreaseStone fsi=new FiringSpeedIncreaseStone();
		        	//todo:szekv diagramban lemaradt a varďż˝zserďż˝ levonďż˝sa
		        	Map.player.setMagicPower(15);
		        }
		        
		        else if(command.length == 2 && command[0].equals("magicstone") && command[1].equals("effect")){
		        	FiringSpeedIncreaseStone fsi=new FiringSpeedIncreaseStone();
		        	Tower t=new Tower();
		        	System.out.println("Ha egy cellďż˝ban vannak:");
		        	t.setFiringSpeed(15);//todo:Tower-ben setTďż˝zErďż˝
		        }
		        
		        else if(command.length == 1 && command[0].equals("endgame")){
		        	timer.tick();
		        	game.tick();
		        	System.out.println("Ha elpusztult minden ellensďż˝g:");
		        	game.winGame();
		        	System.out.println("Ha az ellensďż˝g elďż˝rt a vďż˝gzet hegyďż˝hez:");
		        	game.endGame();
		        }
		        
		        else{
					System.out.println("Hibas parancs!");
		        }
		}
	}
}



