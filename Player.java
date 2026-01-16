import java.util.ArrayList;

public class Player extends Character {

    private int row, col;
    private ArrayList<Item> inventory;

    public Player(String name, int health, int row, int col) {
        super(name, health, 10);
        this.row = row;
        this.col = col;
        inventory = new ArrayList<>();
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public String move(String dir, Location[][] world) {
        int r = row, c = col;

        switch (dir) {
            case "north": case "n": r--; break;
            case "south": case "s": r++; break;
            case "east": case "e": c++; break;
            case "west": case "w": c--; break;
            default: return "Invalid direction.";
        }

        if (r < 0 || c < 0 || r >= world.length || c >= world[0].length)
            return "You hit an invisible wall.";

        row = r; col = c;
        return "You move " + dir + ".";
    }

    public String pickUp(String name, Location loc) {
        Item item = loc.takeItem(name);
        if (item == null) return "That item isn't here.";
        inventory.add(item);
        return "Picked up " + item.getName();
    }

    public String use(String name) {
        for (Item i : inventory)
            if (i.getName().equalsIgnoreCase(name))
                return i.use(this);
        return "You don't have that.";
    }

    public String unlock(Location loc) {
        if (!loc.isLocked()) return "Nothing to unlock.";
        for (Item i : inventory)
            if (i.getName().equalsIgnoreCase("Key")) {
                loc.unlock();
                return "You unlocked the door.";
            }
        return "You need a key.";
    }

    public String attackEnemy(Location loc) {
        if (!(loc.getNpc() instanceof Enemy)) return "Nothing to attack.";
        Enemy e = (Enemy) loc.getNpc();
        e.takeDamage(attack);
        if (!e.isAlive()) {
            loc.setNpc(null);
            return "Enemy defeated!";
        }
        takeDamage(e.attack);
        return "You trade blows with the enemy!";
    }

    public String inventoryString() {
        return inventory.isEmpty() ? "[empty]" : inventory.toString();
    }

    @Override
    public String talk() {
        return "You talk to yourself.";
    }
}
