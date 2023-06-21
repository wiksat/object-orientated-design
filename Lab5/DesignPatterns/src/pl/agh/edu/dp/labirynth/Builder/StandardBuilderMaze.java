package pl.agh.edu.dp.labirynth.Builder;

import pl.agh.edu.dp.labirynth.*;

public class StandardBuilderMaze implements MazeBuilder {

    private Maze currentMaze;

    public StandardBuilderMaze() {
        this.reset();
    }

    public Maze getMaze() {
        Maze maze = currentMaze;
        this.reset();
        return maze;
    }

    private Direction getCommonWallDirection(Room r1, Room r2) {
        Direction[] directionList = Direction.values();
        for (Direction currentDirection : directionList) {
            Direction oppositeDirection = Direction.getOppositeTo(currentDirection);
            if(r2.getSide(oppositeDirection).equals(r1.getSide(currentDirection))) {
                return currentDirection;
            }
        }
        throw new IllegalArgumentException("Cannot make door [no common wall] between Room1 " +
                "(number: " + r1.getRoomNumber() + ") i Room2 (number: " + r2.getRoomNumber() + ")");
    }

    @Override
    public void reset() {
        this.currentMaze = new Maze();
    }

    @Override
    public void addRoom(Room room) {
        currentMaze.addRoom(room);
    }

    @Override
    public void attachWall(Wall joiningWall, Direction direction, Room r1, Room r2) {
        r1.setSide(direction, joiningWall);
        r2.setSide(Direction.getOppositeTo(direction), joiningWall);
    }

    @Override
    public void attachDoor(Door door) {
        Room r1 = door.getRoom1();
        Room r2 = door.getRoom2();
        Direction doorDirection = getCommonWallDirection(r1, r2);
        r1.setSide(doorDirection, door);
        r2.setSide(Direction.getOppositeTo(doorDirection), door);
    }
}
