package ie.gmit.sw.ai.traversers;

import ie.gmit.sw.ai.*;

public interface Traversator {
	public enum TraverseAlgorithm {
		BFS, DFS, AStar, BestFirst, SAHC, RW
	}
	public  SearchResult traverse(Maze maze, Node start);
}
