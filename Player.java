package LOTR;

public class Player {

	private int magicPower;
	
	public Player(){
		System.out.println("Player konstruktor - Player objektum létrejött.");
	}

	public int getMagicPower() {
		System.out.println("Player getMagicPower - visszaadja a játékos életerejét");
		return this.magicPower;
	}

	public void setMagicPower(int magicPower) {
		System.out.println("Player setMagicPower - átállítja a játékos életerejét");
		//ennyivel noveli, nem annyira allitja be
		//ha meghal egy ellenfel, az o eleterejenek ertekevel no a jatekos
		//varazsereje
		this.magicPower = this.magicPower + magicPower;
	}

	public void createDefenseTool(DefenseTools DefenseTool) {
		System.out.println("Player creatDefenseTool - Player csinált egy defenseTool-t");
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof SmallTower))
		{
			SmallTower smallTower = new SmallTower();
			Map.towers.add(smallTower);
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof BigTower))
		{
			BigTower bigTower = new BigTower();
			Map.towers.add(bigTower);
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof Swamp))
		{
			Swamp swamp = new Swamp();
			Map.barriers.add(swamp);
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof ShiftingSand))
		{
			ShiftingSand shiftingSand = new ShiftingSand();
			Map.barriers.add(shiftingSand);
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof FiringSpeedIncreaseStone))
		{
			FiringSpeedIncreaseStone firingSpeedIncreaseStone = new FiringSpeedIncreaseStone();
			Map.magicStones.add(firingSpeedIncreaseStone);
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof RangeExtenderStone))
		{
			RangeExtenderStone rangeExtenderStone = new RangeExtenderStone();
			Map.magicStones.add(rangeExtenderStone);
		}
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof ElfDwarfSpecializedStone))
		{
			ElfDwarfSpecializedStone elfDwarfSpecializedStone = new ElfDwarfSpecializedStone();
			Map.magicStones.add(elfDwarfSpecializedStone);
		}
		
	}

}