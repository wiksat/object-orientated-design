package pl.agh.edu.dp.labirynth.Factory;

import pl.agh.edu.dp.labirynth.*;

public class EnchantedMazeFactory implements MazeFactory{
    private static EnchantedMazeFactory instance;
    // Singleton
    private EnchantedMazeFactory() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static EnchantedMazeFactory getInstance() {
        if (instance == null) {
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }
    @Override
    public Room makeRoom(int number) {
        return new EnchantedRoom(number);
    }

    @Override
    public Wall makeWall() {
        return new EnchantedWall();
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new EnchantedDoor(r1, r2);
    }
}
