package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.Builder.CountingMazeBuilder;
import pl.agh.edu.dp.labirynth.Builder.StandardBuilderMaze;

import java.io.IOException;

public class Main {

    public static void main(String[] args)throws IOException {

        MazeGame mazeGame = new MazeGame();
// first version
//        Maze maze = mazeGame.createMaze();
//        System.out.println(maze.getRoomNumbers());

// second version builder
//        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
//        mazeGame.createMaze(standardBuilderMaze);
//        System.out.println(standardBuilderMaze.getMaze().getRoomNumbers());
//
//        CountingMazeBuilder countingBuilderMaze = new CountingMazeBuilder();
//        mazeGame.createMaze(countingBuilderMaze);
//        System.out.println(countingBuilderMaze.getCount());

// third version factory

//        singletons test
        mazeGame.checkSingletons();

        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        mazeGame.createBombedMaze(standardBuilderMaze);

        Maze maze = standardBuilderMaze.getMaze();
        Player player = new Player(100);

        MazeGame mazeGame2 = new MazeGame(maze, player);
        mazeGame2.startGame();
    }
}



