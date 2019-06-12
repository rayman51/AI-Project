package ie.gmit.sw.ai.spiders;

import ie.gmit.sw.ai.Maze;
import ie.gmit.sw.ai.Node;
import ie.gmit.sw.ai.*;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;

@SuppressWarnings("rawtypes")
public class FuzzySpider extends Spider{
	public FuzzySpider(Node start, char type, TraverseAlgorithm algorithm, Maze maze, ControlledSprite player) {
		super(start, type, algorithm, maze, player);
	}
	
	public double fight(double health) {
		FIS fis = FIS.load("./resources/fuzzy/fight.fcl", true);
		fis.getFunctionBlock("Fight");
		
		//JFuzzyChart.get().chart(fis);
		fis.setVariable("health", player.getHealth());
		
		fis.evaluate();
		Variable fight = fis.getVariable("fight");
		return fight.getValue();
	}

	
	
}
