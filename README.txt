B.Sc. Software Development – Artificial Intelligence (2019)
 


This is a java project created for our Artificial Intelligence module
using neural networks, fuzzy logic and traversal algorithms.

For this project, we were provided with a skeleton of the program containing 
an already created maze with a moveable player (using arrow keys)
If at any point the player gets lost in the maze you can
press the z button to zoom out and view the entire maze and the player 
is represented by a yellow square on the map.
The player can also pick up a sword or a h-bomb. If the player picks up the sword, they have 
a partial shield and the spider will either run away or attack depending on the rules set in the 
fuzzy logic and neural networks.
If the player picks up h-bomb, they can walk away and place it on the map by pressing h, 
once placed the bomb will explode and destroy surrounding bricks and cause damage to any spiders nearby.


Our goal was to design a fuzzy logic system
and a neural network that can control the enemy spiders and make them act in a pseudo
intelligent manner.

The spiders are configured using a traversal algorithm, each one uses it's own algorithm
such as A*, Steepest Ascent Hillclimb, Best First, Random Walk 
and Brute Force. These algorithms are used to allow the spiders to find the player.

Once the spiders find the player, depending on the spider either the fuzzy inference system
or the back propagation neural network is fired.

The fuzzy logic system is used to evaluate if the spider will attack the player or run away depending
on the player health and if the player has a sword, which adds more durability to the player.

The neural network is a back propagation nn which has 2 inputs (health & sword) 2 hidden layers and 
2 output layers (run or attack).

Finally, the spiders are run in their own threads, which is handled by an Executor service with a pool of 50.
If a spider dies, a thread is freed up and it checks for another spider and runs it.

When the thread fires, the traverser algorithms is started and the spider looks for the player,
if the player is found, the spider calls the fight method and it checks whether to fight or run,
if the player is not found the traverser algo is fired again.

To run the program cd to the folder where the jar is fired *ensure resource folder is also there*

and run the command 
java –cp ./game.jar ie.gmit.sw.ai.GameRunner