package pl.agh.edu.dp.labirynth.Factory;

import pl.agh.edu.dp.labirynth.*;

public class BombedMazeFactory implements MazeFactory{
    private static BombedMazeFactory instance;

    // Singleton
    private BombedMazeFactory() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static BombedMazeFactory getInstance() {
        if (instance == null) {
            instance = new BombedMazeFactory();
        }
        return instance;
    }
    @Override
    public Room makeRoom(int number) {
        return new BombedRoom(number);
    }

    @Override
    public Wall makeWall() {
        return new BombedWall();
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
