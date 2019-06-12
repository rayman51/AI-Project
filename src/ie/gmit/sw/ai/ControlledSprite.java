package ie.gmit.sw.ai;

public class ControlledSprite extends Sprite{	
	
	// static variable single_instance of type Singleton
    private static volatile ControlledSprite single_instance = null;
    private double health = 100;
    public static synchronized ControlledSprite getInstance() throws Exception
    {

		if (single_instance == null) {
		    single_instance = new ControlledSprite();
		}
        
		return single_instance;
    } 
	public ControlledSprite(String name, int frames, String... images) throws Exception{
		super(name, frames, images);
	}

	

	
	public ControlledSprite() {
		super();
	}
	
	public void setDirection(Direction d){
		switch(d.getOrientation()) {
		case 0: case 1:
			super.setImageIndex(0); //UP or DOWN
			break;
		case 2:
			super.setImageIndex(1);  //LEFT
			break;
		case 3:
			super.setImageIndex(2);  //LEFT
		default:
			break; //Ignore...
		}		
	}

	
	private double sword = 0;
	private int durability = 0;
	private int hBomb = 0;

	public double getDurability(){
		return durability;
	}

	
	
	public double getSword(){
		return sword;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		if (health <= 0){
			System.out.println("Defeat. You were killed in: " + (System.currentTimeMillis() - GameRunner.time) + "ms"); 
		
			System.exit(0);
		}
		this.health = health;
	}

	public int gethBomb() {
		return hBomb;
	}

	public void sethBomb(int hBomb) {
		this.hBomb = hBomb;
	}

	public void setSword(double sword) {
		this.sword = sword;
		
		// Picking up a sword
		if(sword == 1){
			durability = 3;
		}
	}
	
	public double fight(){
		// Calculate damage to spider
		double extradamage = this.durability / 10.0;
		extradamage = Math.round(extradamage);
		
		if(sword == 1){
			durability--;
			if(durability == 0){
				// Sword broke
				sword = 0;
			}
			return 10 + extradamage;
		}else{
			return 5 + extradamage;
		}
	}
}

	
