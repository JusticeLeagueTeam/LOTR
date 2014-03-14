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
        
        if(s.equals("tower"))
        	player.createDefenseTool(new DefenseTools());
        
        if(s.equals("enemy")){
        	//ez azért még kérdéses srácok :D  - arnold
        	LinkedList lili=map.getEnemies();
        	//lili.add(new Object()); - ez egyelõre exceptiont dobna, de úgyis más lesz - arnold
        	map.setEnemies(lili);
        }
        
		}
	}

}
