package pl.agh.edu.dp.labirynth.Factory;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public interface MazeFactory {

    Room makeRoom(int number);
    Wall makeWall();
    Door makeDoor(Room r1, Room r2);
}
