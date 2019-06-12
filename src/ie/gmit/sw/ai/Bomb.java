package ie.gmit.sw.ai;

public class Bomb extends Thread{
	@SuppressWarnings("unused")
	private char type;
	private Maze model;
	private int row;
	private int col;
	
	public Bomb(char type, Maze model, int currentRow, int currentCol){
		this.type = type;
		this.model = model;
		this.row = currentRow;
		this.col = currentCol;
	}
	
	public void run() {
		try {
			// Sleep for 1.5 seconds to allow player to get away from explosion
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
			for (int i = row-1; i <= row+1; i++){
				for (int j = col-1; j <= col+1; j ++){
					// "Blow up" help sprites (turn them to hedges)
					if(model.get(i, j) == '\u0031' || model.get(i, j) == '\u0032' || model.get(i, j) == '\u0033' || model.get(i, j) == '\u0034' || model.get(i, j) == '0' ){
						model.set(i, j, ' ');
					}
					
					if(model.get(i, j) == '\u0034'){
						// Do damage to player
						GameRunner.player.setHealth(GameRunner.player.getHealth() - 30);
						GameRunner.information.setText("  Health: " + Double.toString(GameRunner.player.getHealth()) + "   Shield: " + GameRunner.player.getDurability()
				    	+ "  H-Bombs  " + GameRunner.player.gethBomb());
					}
				}
			}
			
			if(model.getGoal().getRow() == row && model.getGoal().getCol() == col){
				GameRunner.player.setHealth(GameRunner.player.getHealth() - 30);
				GameRunner.information.setText("  Health: " + Double.toString(GameRunner.player.getHealth()) + "   Shield: " + GameRunner.player.getDurability()
		    	+ "  H-Bombs  " + GameRunner.player.gethBomb());
			}
		}
	}


