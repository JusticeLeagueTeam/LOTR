package LOTR;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Justice League's sceleton!");
		Game game=new Game();
		Map map=new Map();
		Timer timer=new Timer();
		Player player=new Player();
		//game.timer.run();
		//game.timer.setPeriod(50); 
		//game.timer.setGame(game); //szekv diagramban bennhagytuk, de szvsz felesleges - arnold
		
		String s = new String();
		
		while(s.equals("exit")==false){
		System.out.println("input:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        if(s.equals("tower")){
        	SmallTower st=new SmallTower();
        	player.createDefenseTool(st);//ez a metódus biztos kell? - arnold
        	//igazából a szekv diagramon is értelmetlen egy kicsit :) - arnold
        	//helyette get/set-tel kell, mint a többi ilyen megoldásnál - arnold
        	//ezt majd javítom (createDefenTool helyett get/set-es megoldás) - arnold
        	st.getCost();
        	player.setMagicPower(15);//honnan számoljuk ki  a paramétert? - arnold
        	
        	//todo: összes enemy feliratkozik a tower observerrre
        	//ezt szekv diagramon jelezni - arnold
        }
        
        if(s.equals("enemy")){
        	//ez azért még kérdéses srácok :D  - arnold
        	LinkedList lili=map.getEnemies();
        	//lili.add(new Object()); - ez egyelõre exceptiont dobna, de úgyis más lesz - arnold
        	System.out.println("új ellenfél létrejön");
        	map.setEnemies(lili);
        	//todo: összes torony observerre feliratkozik - arnold
        	//ezt szekv diagramon jelezni - arnold
        }
        
        if(s.equals("move")){
        	timer.tick();
        	map.tick();
        	//szekv diagramban enemyobjektum.tick() lenne, de helyette: - arnold
        	LinkedList lili=map.getEnemies();
        	//todo: forciklus végigmegy rajtuk és mindegyiken tick() - arnold

        	//todo: forciklus végigmegy rajtuk és megnézi, hogy
        	//todo: fajtól függõen osztható-e a tick_counter fajnak megfelelõ sebességgel (pl 5-tel) - arnold
        	//todo: amelyik enemynél ez fenn áll ott:
        	
        	Enemy e=new Enemy();
        	Position p=map.enemyStep(e.getPosition());
        	e.setPosition(p);//szekv diagramban move() van, az hibás - arnold
        }
        
        if(s.equals("towerattack")){
        	timer.tick();
        	map.tick();
        	Enemy e=new Enemy();//todo: itt is forciklusos téma lenne - arnold
        	//todo: tehát ezt minden toronynál eljátszuk majd meg minden enemynél - arnold
        	e.tick();
        	Tower t=new Tower();
        	t.tick();
        	e.notifyObservers();//itt szekv diagramon a nyilat lehet, hogy elrontottam - arnold
        	//önmagába forduló nyíl kellene - arnold
        	System.out.println("Observable notifyObservers - ellenfél lépett, ezt jelzi az összes toronynak");
        	
        	System.out.println("Ha az ellenfél hatótávon belül van");
        	t.update(e);
        	e.Attacked(t.getFiringRange());//Attacked szekv UML-ben benne van, de szkeletonból kimaradt - arnold
        	//valszeg osztálydiagramban sincs benne - arnold
        	//paraméter értékéhez le kéne kérezni a támadóerõt - arnold
        	player.setMagicPower(50);// - todo: paraméter mi alapján - arnold
        	//setMagicPower szekv diagramon lehet, hogy önmagába nyúló nyilat érdemel? - arnold
        	
        	System.out.println("Ha az ellenfél életereje eléri a nullát");
        	System.out.println("Enemy dispose()");
        }
        
        if(s.equals("barrier")){
        	System.out.println("Ha van elég varázserõ akadály létrehozásához");
        	//szekv diagramról lemaradt a setMagicPower - ezt kódban és ott is pótolni kell - arnold
        	//ugyanúgy mint ahogy a tower-nél írtam createdefensetool helyett get/set-es megoldás kéne - arnold

        	//szekv diagramban van setBarriers, de ahhoz kéne get is, hogy legyen mit módosítani - arnold
        	//szintén mindkét helyen javítani kéne - arnold
        }
        
        if(s.equals("barrier slowdown")){
        	//végsõ megoldásban itt is forciklus lesz ami az összes enemy-n végigmegy - arnold
        	Enemy e=new Enemy();
        	e.notifyObservers();
        	Barrier b=new Barrier();
        	b.update(e, new Object());
        	b.effectEnemy();
        	System.out.println("Ha egy cellában vannak:");
        	e.setSpeed(15);//paraméter hogy jön ki? szkeletonban még nem kell tudni - arnold
        }
        
        if(s.equals("magicstone")){
        	//todo:createdefensestone helyett get/set - arnold
        	FiringSpeedIncreaseStone fsi=new FiringSpeedIncreaseStone();
        	//todo:szekv diagramban lemaradt a varázserõ levonása
        	player.setMagicPower(15);
        }
        
        if(s.equals("magicstone effect")){
        	FiringSpeedIncreaseStone fsi=new FiringSpeedIncreaseStone();
        	Tower t=new Tower();
        	System.out.println("Ha egy cellában vannak:");
        	t.setFiringSpeed(15);//todo:Tower-ben setTûzErõ
        }
        
        if(s.equals("endgame")){
        	timer.tick();
        	game.tick();
        	System.out.println("Ha elpusztult minden ellenség:");
        	game.winGame();
        	System.out.println("Ha az ellenség elért a végzet hegyéhez:");
        	game.endGame();
        }
        
		}
	}

}
