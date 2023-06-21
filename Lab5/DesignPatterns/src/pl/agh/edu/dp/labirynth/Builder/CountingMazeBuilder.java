package pl.agh.edu.dp.labirynth.Builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

import java.util.HashMap;

public class CountingMazeBuilder implements MazeBuilder {

    private int roomCounter;
    private int wallCounter;
    private int doorCounter;

    public CountingMazeBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.roomCounter = 0;
        this.wallCounter = 0;
        this.doorCounter = 0;
    }

    @Override
    public void addRoom(Room room) {
        this.roomCounter++;
        this.wallCounter += 4;
    }

    @Override
    public void attachWall(Wall wall, Direction direction, Room r1, Room r2) {
        this.wallCounter--;
    }

    @Override
    public void attachDoor(Door door) {
        this.wallCounter--;
        this.doorCounter++;
    }

    public HashMap<String, Integer> getCount() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("roomCounter", this.roomCounter);
        result.put("wallCounter", this.wallCounter);
        result.put("doorCounter", this.doorCounter);
        return result;
    }
}
