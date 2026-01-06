import java.util.ArrayList;

public class Player extends Character {
    private int row;
    private int col;
    private ArrayList<Item> inventory;

    public Player(String name, int health, int row, int col) {
        super(name, health);
        this.row = row;
        this.col = col;
        this.inventory = new ArrayList<>();
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public String move(String dir, Location[][] world) {
        int r = row, c = col;

        switch (dir) {
            case "north": case "n": r--; break;
            case "south": case "s": r++; break;
            case "east":  case "e": c++; break;
            case "west":  case "w": c--; break;
            default: return "Invalid direction.";
        }

        if (r < 0 || c < 0 || r >= world.length || c >= world[0].length) {
            return "You hit an invisible wall.";
        }

        row = r;
        col = c;
        return "You move " + dir + ".";
    }

    public String pickUp(String item, Location loc) {
        Item found = loc.takeItemByName(item);
        if (found == null) return "That item isn't here.";
        inventory.add(found);
        return "Picked up " + found.getName();
    }

    public String use(String item) {
        for (Item i : inventory) {
            if (i.getName().equalsIgnoreCase(item)) {
                return i.use(this);
            }
        }
        return "You don't have that.";
    }

    public String inventoryString() {
        return inventory.isEmpty() ? "[empty]" : inventory.toString();
    }

    @Override
    public String talk() {
        return "You talk to yourself.";
    }
}

