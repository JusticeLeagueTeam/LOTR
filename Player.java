package LOTR;

/**
 * Player a jatekos osztalya
 * a jatekos iranyitja a GUI-n keresztul az egysegeit
 * @author justice_league
 *
 */
public class Player {

	private int magicPower;
	
	public Player(){
		System.out.println("Player konstruktor");
	}

	public int getMagicPower() {
		System.out.println("Player getMagicPower - visszaadja a jatekos eleterejet");
		return this.magicPower;
	}

	public void setMagicPower(int magicPower) {
		System.out.println("Player setMagicPower - beallitja a jatekos eleterejet");
		this.magicPower = this.magicPower + magicPower;
	}

	public void createDefenseTool(DefenseTools dt) {
		System.out.println("Player createDefenseTool - Player csinal egy defenseTool-t");
		dt.getCost();
		getMagicPower();
		System.out.println("[IF] ha van eleg varazsero a torony megepitesere");
		
		String dtClass = dt.getClass().toString();
		dtClass = dtClass.substring(5);	//TODO
		
		if(dt instanceof Tower)
		{
			Map.towers.add((Tower) dt);
			System.out.println("towers add " + dtClass);
		}
		if(dt instanceof Barrier)
		{
			Map.barriers.add((Barrier) dt);
			System.out.println("barriers add " + dtClass);
		}
		if(dt instanceof MagicStone)
		{
			Map.magicStones.add((MagicStone) dt);
			System.out.println("magicstones add " + dtClass);
		}

		
		//ez szvsz mar implementacio, egyelore szerintem eleg elenne ezeket kiprintelni - arnold
		//meg abban sem vagyok biztos, hogy ezt eredetileg igy gondoltuk-e - arnold
		/*if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof SmallTower))
		{
			SmallTower smallTower = new SmallTower();
			Map.towers.add(smallTower);
			this.magicPower = this.magicPower - DefenseTool.getCost();
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof BigTower))
		{
			BigTower bigTower = new BigTower();
			Map.towers.add(bigTower);
			this.magicPower = this.magicPower - DefenseTool.getCost();
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof Swamp))
		{
			Swamp swamp = new Swamp();
			Map.barriers.add(swamp);
			this.magicPower = this.magicPower - DefenseTool.getCost();
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof ShiftingSand))
		{
			ShiftingSand shiftingSand = new ShiftingSand();
			Map.barriers.add(shiftingSand);
			this.magicPower = this.magicPower - DefenseTool.getCost();
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof FiringSpeedIncreaseStone))
		{
			FiringSpeedIncreaseStone firingSpeedIncreaseStone = new FiringSpeedIncreaseStone();
			Map.magicStones.add(firingSpeedIncreaseStone);
			this.magicPower = this.magicPower - DefenseTool.getCost();
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof RangeExtenderStone))
		{
			RangeExtenderStone rangeExtenderStone = new RangeExtenderStone();
			Map.magicStones.add(rangeExtenderStone);
			this.magicPower = this.magicPower - DefenseTool.getCost();
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof ElfDwarfSpecializedStone))
		{
			ElfDwarfSpecializedStone elfDwarfSpecializedStone = new ElfDwarfSpecializedStone();
			Map.magicStones.add(elfDwarfSpecializedStone);
			this.magicPower = this.magicPower - DefenseTool.getCost();
		}*/
		
	}

}
