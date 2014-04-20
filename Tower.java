package LOTR;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;


/**
 * Tower osztaly a DefenseTools osztaly leszarmazottja.
 * Toronynak felel meg. A jatekos rakja le oket ha van eleg varazsereje
 * Az ellenfeleket az Observer mintan keresztul figyeli.
 * Ha egy ellenfel a hatotavolsagaba er akkor tuzel
 * Varazskovekkel javithatok a konstruktorban beallitott valtozoi
 * 
 * @author justice_league
 *
 */
public class Tower extends DefenseTools implements Observer{
	/**
	 *  tuzelesi gyakorisag 
	 */
	protected int firingSpeed;
	/**
	 *  tuzelesi hatotav 
	 */
	protected int firingRange;
	/**
	 *  tuzero
	 */
	protected int firingPower;
	/**
	 *  flag az olyan varazskoveknek ami csak elfekre vagy torpekre hat 
	 */
	protected boolean elfOrDwarfFlag;
	/**
	 *  jatek kezdete ota eltelt orajelek szama
	 */
	protected int tick_counter;
	/**
	 * Tower konstruktor
	 */
	public Tower(){

	}
	/**
	 * visszaadja a tamadas sebesseget
	 */
	public int getFiringSpeed() {
		return firingSpeed;
	}
	/**
	 * beallitja a tamadas sebesseget
	 */
	public void setFiringSpeed(int fs) {
		firingSpeed = fs;
	}
	/**
	 * visszaadja a hatotavot
	 */
	public int getFiringRange() {
		return firingRange;
	}
	/**
	 * beallitja a hatotavot
	 */
	public void setFiringRange(int fr) {
		firingRange = fr;
	}
	/**
	 * visszaadja a tuzerot
	 */
	public int getFiringPower() {
		return firingPower;
	}
	/**
	 * beallitja a tuzerot
	 */
	public void setFiringPower(int fp) {
		firingPower = fp;
	}
	/**
	 *visszaadja a flag-et 
	 */
	public boolean getElfOrDwarfFlag() {
		return elfOrDwarfFlag;
	}
	/**
	 * beallitja a flag-et
	 */
	public void setElfOrDwarfFlag(boolean eodf) {
		elfOrDwarfFlag = eodf;
	}

	/**
	 * noveli a tick_counter-t eggyel
	 */
	public void tick() {
		tick_counter++;
	}
	/**
	 * ellenorzi, hogy van-e ellenseg a hatokoreben es megtamadja
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		// segedvaltozo
		//minden ellenfelen vegigmegy a ciklus es ellenorzi a hatotavot
		//ha benne van es eljott a tamadas ideje, akkor megtamadja
		for(Enemy e : Map.enemies){
			boolean is_in_target=false;
			if(Game.isFog == true){
				//torony tipusatol fuggoen ellenorzi a hatotavot
				if(firingRange == 2){
					if((Math.abs(e.getPosition().getRowValue() - this.position.getRowValue()) <= 1) && (Math.abs(e.getPosition().getColumnValue() - this.position.getColumnValue()) <= 1))
						is_in_target = true;
				}
				if(firingRange == 3){
					if((Math.abs(e.getPosition().getRowValue() - this.position.getRowValue()) <= 2) && (Math.abs(e.getPosition().getColumnValue() - this.position.getColumnValue()) <= 2))
						is_in_target = true;
				}
			}
			else{
				//torony tipusatol fuggoen ellenorzi a hatotavot
				if(firingRange == 1){
					if((Math.abs(e.getPosition().getRowValue() - this.position.getRowValue()) <= 1) && (Math.abs(e.getPosition().getColumnValue() - this.position.getColumnValue()) <= 1))
						is_in_target = true;
				}
				if(firingRange == 2){
					if((Math.abs(e.getPosition().getRowValue() - this.position.getRowValue()) <= 2) && (Math.abs(e.getPosition().getColumnValue() - this.position.getColumnValue()) <= 2))
						is_in_target = true;
				}
				if(firingRange == 3){
					if((Math.abs(e.getPosition().getRowValue() - this.position.getRowValue()) <= 3) && (Math.abs(e.getPosition().getColumnValue() - this.position.getColumnValue()) <= 3))
						is_in_target = true;
				}
			}

			//ha hatotavon belul van akkor tamad
			if(is_in_target == true){
				//ha specialis a lovedek
				if(Game.isSpecial == true){
					Game.isSpecial=false;//TODO:tobb torony eseten ez rossz helyen van
					if(elfOrDwarfFlag == true && (e instanceof Elf || e instanceof Dwarf))
						e.splitAttacked(firingPower + 10);
					else
						e.splitAttacked(firingPower);
					/**
					 * publci static flag beallitasa, hogy a minden enemies-en vegigmeno cikluson kivul jojjon letre az uj enemy
					 */
					Map.indexOfSplitAttacked=Map.enemies.indexOf(e);
							
					if(Game.fileMode){
						try{
							Game.bufferedWriter.newLine();
							Game.bufferedWriter.write(Map.towers.indexOf(this) + ". sorszamu torony tamadja " + Map.enemies.indexOf(e) + ". sorszamu ellenfelet");
							Game.bufferedWriter.newLine();
							//Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						//System.out.println(Map.towers.indexOf(this) + ". sorszamu torony tamadja " + Map.enemies.indexOf(e) + ". sorszamu ellenfelet");
						System.out.println(Map.towers.indexOf(this) + ". sorszamu torony tamadja 0XXXX. sorszamu ellenfelet");
					}
				}
				else{
					//normal lovedek
					//elotte ellenorzi, hogy van-e a tornyon specialis ko
					//illetve ahhoz tartozo ellenfelrol van-e szo
					if(elfOrDwarfFlag == true && (e instanceof Elf || e instanceof Dwarf))
						e.Attacked(firingPower + 10);
					else
						e.Attacked(firingPower);
					if(Game.fileMode){
						try{
							Game.bufferedWriter.newLine();
							Game.bufferedWriter.write(Map.towers.indexOf(this) + ". sorszamu torony tamadja " + Map.enemies.indexOf(e) + ". sorszamu ellenfelet");
							Game.bufferedWriter.newLine();
							//Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
					else{
						System.out.println(Map.towers.indexOf(this) + ". sorszamu torony tamadja " + Map.enemies.indexOf(e) + ". sorszamu ellenfelet");
					}
				}
			}
		}
	}
}
