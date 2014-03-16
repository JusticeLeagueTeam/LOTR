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
		//Player player=new Player(); //Balázs észrevétele alapján kivettem, mivel a Playert a Map hozza létre
		
		SmallTower sm = new SmallTower();	//teszteleshez
		map.player.createDefenseTool(sm);
		
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
        	player.createDefenseTool(st);
        	//ez a met�dus biztos kell? - arnold
        	//igaz�b�l a szekv diagramon is �rtelmetlen egy kicsit :) - arnold
        	//helyette get/set-tel kell, mint a t�bbi ilyen megold�sn�l - arnold
        	//ezt majd jav�tom (createDefenTool helyett get/set-es megold�s) - arnold
        	st.getCost();
        	player.setMagicPower(15);//honnan sz�moljuk ki  a param�tert? - arnold
        	
        	//todo: �sszes enemy feliratkozik a tower observerrre
        	//ezt szekv diagramon jelezni - arnold
        }
        
        if(s.equals("enemy")){
        	//map.tick() h�vja a createEnemy()-t - arnold
        	map.tick();
        	//todo: �sszes torony observerre feliratkozik - arnold
        	//ezt szekv diagramon jelezni - arnold
        }
        
        if(s.equals("move")){
        	timer.tick();
        	map.tick();
        	//szekv diagramban enemyobjektum.tick() lenne, de helyette: - arnold
        	LinkedList lili=map.getEnemies();
        	//todo: forciklus v�gigmegy rajtuk �s mindegyiken tick() - arnold

        	//todo: forciklus v�gigmegy rajtuk �s megn�zi, hogy
        	//todo: fajt�l f�gg�en oszthat�-e a tick_counter fajnak megfelel� sebess�ggel (pl 5-tel) - arnold
        	//todo: amelyik enemyn�l ez fenn �ll ott:
        	
        	Enemy e=new Enemy();
        	e.tick();
        }
        
        if(s.equals("towerattack")){
        	timer.tick();
        	map.tick();
        	Enemy e=new Enemy();//todo: itt is forciklusos t�ma lenne - arnold
        	//todo: teh�t ezt minden toronyn�l elj�tszuk majd meg minden enemyn�l - arnold
        	e.tick();
        	Tower t=new Tower();
        	t.tick();
        	e.notifyObservers();//itt szekv diagramon a nyilat lehet, hogy elrontottam - arnold
        	//�nmag�ba fordul� ny�l kellene - arnold
        	System.out.println("Observable notifyObservers - ellenf�l l�pett, ezt jelzi az �sszes toronynak");
        	
        	System.out.println("Ha az ellenf�l hat�t�von bel�l van");
        	t.update(e);
        	e.Attacked(t.getFiringRange());//Attacked szekv UML-ben benne van, de szkeletonb�l kimaradt - arnold
        	//valszeg oszt�lydiagramban sincs benne - arnold
        	//param�ter �rt�k�hez le k�ne k�rezni a t�mad�er�t - arnold
        	player.setMagicPower(50);// - todo: param�ter mi alapj�n - arnold
        	//setMagicPower szekv diagramon lehet, hogy �nmag�ba ny�l� nyilat �rdemel? - arnold
        	
        	System.out.println("Ha az ellenf�l �letereje el�ri a null�t");
        	System.out.println("Enemy dispose()");
        }
        
        if(s.equals("barrier")){
        	System.out.println("Ha van el�g var�zser� akad�ly l�trehoz�s�hoz");
        	//szekv diagramr�l lemaradt a setMagicPower - ezt k�dban �s ott is p�tolni kell - arnold
        	//ugyan�gy mint ahogy a tower-n�l �rtam createdefensetool helyett get/set-es megold�s k�ne - arnold

        	//szekv diagramban van setBarriers, de ahhoz k�ne get is, hogy legyen mit m�dos�tani - arnold
        	//szint�n mindk�t helyen jav�tani k�ne - arnold
        }
        
        if(s.equals("barrier slowdown")){
        	//v�gs� megold�sban itt is forciklus lesz ami az �sszes enemy-n v�gigmegy - arnold
        	Enemy e=new Enemy();
        	e.notifyObservers();
        	Barrier b=new Barrier();
        	b.update(e, new Object());
        	b.effectEnemy();
        	System.out.println("Ha egy cell�ban vannak:");
        	e.setSpeed(15);//param�ter hogy j�n ki? szkeletonban m�g nem kell tudni - arnold
        }
        
        if(s.equals("magicstone")){
        	//todo:createdefensestone helyett get/set - arnold
        	FiringSpeedIncreaseStone fsi=new FiringSpeedIncreaseStone();
        	//todo:szekv diagramban lemaradt a var�zser� levon�sa
        	player.setMagicPower(15);
        }
        
        if(s.equals("magicstone effect")){
        	FiringSpeedIncreaseStone fsi=new FiringSpeedIncreaseStone();
        	Tower t=new Tower();
        	System.out.println("Ha egy cell�ban vannak:");
        	t.setFiringSpeed(15);//todo:Tower-ben setT�zEr�
        }
        
        if(s.equals("endgame")){
        	timer.tick();
        	game.tick();
        	System.out.println("Ha elpusztult minden ellens�g:");
        	game.winGame();
        	System.out.println("Ha az ellens�g el�rt a v�gzet hegy�hez:");
        	game.endGame();
        }
        
		}
	}

}
