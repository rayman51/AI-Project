package ie.gmit.sw.ai.nn;

import ie.gmit.sw.ai.nn.activator.Activator;

public class GameCharacter {
	private static NeuralNetwork nn;
	
	private static double[][] data = { //Health, Sword
			{ 2, 0 }, { 2, 1 }, { 2, 0 }, { 2, 1 }, { 2, 1 }, { 2, 0 },
			{ 1, 0}, { 1, 1 }, { 1, 0}, { 1, 1}, { 1, 1}, { 1, 0}, 
			{ 0, 0}, { 0, 1}, { 0, 0}, { 0, 1 }, { 0, 1}, { 0, 0 }};

	private static double[][] expected = { //Attack, Run
			{ 1.0, 0.0 }, { 1.0, 0.0 }, { 1.0, 0.0 }, { 0.0, 1.0 }, { 0.0, 1.0 }, { 0.0, 1.0 }, 
			{ 1.0, 0.0 }, { 1.0, 0.0 }, { 1.0, 0.0 }, { 1.0, 0.0 }, { 0.0, 1.0 }, { 1.0, 0.0 },  
			{ 1.0, 0.0 }, { 1.0, 0.0 }, { 1.0, 0.0 }, { 1.0, 0.0 }, { 1.0, 0.0 }, { 1.0, 0.0 }};
	
	static{
	
		nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 2, 2, 2);
		Trainator trainer = new BackpropagationTrainer(nn);
		trainer.train(data, expected, 0.01, 10000);
	}
	
	public GameCharacter(){
		
	}
	
	public double action(double health, double sword){
		double[] params = {health, sword };
		double[] result = null;
		try {
			result = nn.process(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double action = Utils.getMaxIndex(result) + 1;
		
		return action;
	}
}
