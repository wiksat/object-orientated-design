package pl.agh.edu.dp.labirynth;

public class Player {

    private int health;
    private int XP;
    private Room currentRoom;

    public Player(int health) {
        this.health = health;
        this.XP = 0;
    }

    public void receiveDamage(int damage) {
        health -= damage;
        if(health > 0) {
            System.out.println("You received " + damage + " damage");
        }
    }
    public void moveForward() {
        currentRoom.getSide(Direction.North).Enter(this);
    }

    public void moveBackward() {
        currentRoom.getSide(Direction.South).Enter(this);
    }

    public void moveLeft() {
        currentRoom.getSide(Direction.East).Enter(this);
    }

    public void moveRight() {
        currentRoom.getSide(Direction.West).Enter(this);
    }

    @Override
    public String toString() {
        return "Player: " +
                "health=" + health +
                ", XP=" + XP +
                ", currentRoom=" + currentRoom.getRoomNumber();
    }

    public int getHealth() {
        return health;
    }

    public int getXP() {
        return XP;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
