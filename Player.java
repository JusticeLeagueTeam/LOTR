package LOTR;

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
		//ennyivel noveli, nem annyira allitja be
		//ha meghal egy ellenfel, az o eleterejenek ertekevel no a jatekos
		//varazsereje
		this.magicPower = this.magicPower + magicPower;
	}

	public void createDefenseTool(DefenseTools dt) {
		System.out.println("Player creatDefenseTool - Player csinal egy defenseTool-t");
		Map map=new Map();//map konstruktorabol lehet, hogy ki kene szedni a print-et? - arnold
		//a main-nel amikor eloszor letrehozzuk ott kiprinteljuk a mainbol es akkot a szekv
		//diagrammal konzisztens lesz - arnold
		dt.getCost();
		getMagicPower();
		System.out.println("ha van eleg varazsero a torony megepitesere"); //ezt is csak implementacioban kodoljuk le - arnold
		//map.towers.add((Tower) dt); //ezt sztem eleg kiprintelni most - arnold
		System.out.println("towers add SmallTower");
		
		
		
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
