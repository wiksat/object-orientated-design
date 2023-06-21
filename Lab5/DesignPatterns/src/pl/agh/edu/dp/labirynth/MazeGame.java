package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.Builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.Factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.Factory.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.Factory.MazeFactory;

import java.io.IOException;

public class MazeGame {
    public MazeGame() {}
    public Maze createMaze(MazeBuilder builder, MazeFactory factory){
//first version
//        Maze maze = new Maze();
//
//        Room r1 = new Room(1);
//        Room r2 = new Room(2);
//
//        Door door = new Door(r1, r2);
//
//        maze.addRoom(r1);
//        maze.addRoom(r2);
//
//        r1.setSide(Direction.North, new Wall());
//        r1.setSide(Direction.East, new Wall());
//        r1.setSide(Direction.South, new Wall());
//        r1.setSide(Direction.West, new Wall());
//
//        r2.setSide(Direction.North, new Wall());
//        r2.setSide(Direction.East, new Wall());
//        r2.setSide(Direction.South, new Wall());
//        r2.setSide(Direction.West, new Wall());
//
//        return maze;

//second version - builder
        Maze maze = new Maze();

        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Room r3 = new Room(3);

        builder.addRoom(r1);
        builder.addRoom(r2);
        builder.addRoom(r3);
        r1.setSide(Direction.North, new Wall());
        r1.setSide(Direction.East, new Wall());
        r1.setSide(Direction.South, new Wall());
        r1.setSide(Direction.West, new Wall());

        r2.setSide(Direction.North, new Wall());
        r2.setSide(Direction.East, new Wall());
        r2.setSide(Direction.South, new Wall());
        r2.setSide(Direction.West, new Wall());
        builder.attachWall(new Wall(), Direction.West, r1, r2);
        builder.attachDoor(new Door(r1, r2));
        builder.attachWall(new Wall(), Direction.North, r2, r3);
        builder.attachDoor(new Door(r2, r3));


        return maze;
    }
    public void createEnchantedMaze(MazeBuilder builder) {
        createMaze(builder, EnchantedMazeFactory.getInstance());
    }

    public void createBombedMaze(MazeBuilder builder) {
        createMaze(builder, BombedMazeFactory.getInstance());
    }
    public void checkSingletons() {
        MazeFactory mazeFactory1 = EnchantedMazeFactory.getInstance();
        MazeFactory mazeFactory2 = EnchantedMazeFactory.getInstance();
        if(mazeFactory1.equals(mazeFactory2)) {
            System.out.println("The same objects!");
        }

        MazeFactory mazeFactory3 = BombedMazeFactory.getInstance();
        MazeFactory mazeFactory4 = BombedMazeFactory.getInstance();
        if(mazeFactory3.equals(mazeFactory4)) {
            System.out.println("The same objects!");
        }
    }
    private Maze maze;
    private Player player;

    private void beforeStart() {
        System.out.println("---------------------- HELP -----------------------");
        System.out.println("w - up | s - down | a - left | d - right | q - exit");
        System.out.println("---------------------------------------------------");
        System.out.println(maze);
        System.out.println(player);
    }

    public MazeGame(Maze maze, Player player) {
        this.maze = maze;
        player.setCurrentRoom(maze.getStartRoom());
        this.player = player;
    }

    public void startGame() throws IOException, IOException {
        beforeStart();
        char input = 0;
        while(input != 'q') {
            input = (char) System.in.read();
            switch (movePlayer(input)) {
                case -1 : {
                    System.out.println("You died");
                    System.out.println("GAME OVER");
                    return;
                }
                case 1 : {
                    System.out.println("YOU WON");
                    return;
                }
                case 0 : {
                    System.out.println(maze);
                }
            }
        }
    }

    public int movePlayer(int x) {
        switch (x) {
            case 'a' : {
                player.moveLeft();
                break;
            }
            case 'd' : {
                player.moveRight();
                break;
            }
            case 'w' : {
                player.moveForward();
                break;
            }
            case 's' : {
                player.moveBackward();
                break;
            }
            default: {
                return -2;
            }
        }
        return checkAfterMovement();
    }

    private int checkAfterMovement() {
        if(player.getHealth() < 0) {
            return -1;
        }
        if(player.getCurrentRoom().equals(maze.getEndRoom())) {
            return 1;
        }
        System.out.println(player);
        return 0;
    }

}
