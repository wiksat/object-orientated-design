package pl.agh.edu.dp.labirynth.Builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public interface MazeBuilder {
    void reset();
    void addRoom(Room room);
    void attachWall(Wall wall, Direction direction, Room r1, Room r2);
    void attachDoor(Door door);
}
