package LOTR;

public class Player {

	private int magicPower;
	
	public Player(){
		System.out.println("Player konstruktor - Player objektum l�trej�tt.");
	}

	public int getMagicPower() {
		System.out.println("Player getMagicPower - visszaadja a j�t�kos �leterej�t");
		return this.magicPower;
	}

	public void setMagicPower(int magicPower) {
		System.out.println("Player setMagicPower - �t�ll�tja a j�t�kos �leterej�t");
		//ennyivel noveli, nem annyira allitja be
		//ha meghal egy ellenfel, az o eleterejenek ertekevel no a jatekos
		//varazsereje
		this.magicPower = this.magicPower + magicPower;
	}

	public void createDefenseTool(DefenseTools DefenseTool) {
		System.out.println("Player creatDefenseTool - Player csin�lt egy defenseTool-t");
		
		if((this.getMagicPower() >= DefenseTool.getCost()) && (DefenseTool instanceof SmallTower))
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
		}
		
	}

}
