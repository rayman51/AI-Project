package ie.gmit.sw.ai.spiders;

import ie.gmit.sw.ai.ControlledSprite;
import ie.gmit.sw.ai.Maze;
import ie.gmit.sw.ai.Node;

import ie.gmit.sw.ai.nn.GameCharacter;

@SuppressWarnings("rawtypes")
public class NeuralSpider extends Spider{
	public NeuralSpider(Node start, char type, TraverseAlgorithm algorithm, Maze maze, ControlledSprite player) {
		super(start, type, algorithm, maze, player);
	}

	public double fight(double health) {
		GameCharacter gc = new GameCharacter();
		
		if (health <= 33){
			health = 0;
		}else if(health <= 66){
			health = 1;
		}else{
			health = 2;
		}
		
		
		return gc.action(health, player.getSword());
	}

}
