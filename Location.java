import java.util.ArrayList;

public class Location {
    protected String name;
    protected String description;
    protected ArrayList<Item> items;
    protected NonPlayerCharacter npc;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }

    public String getName() { return name; }
    public NonPlayerCharacter getNpc() { return npc; }
    public void setNpc(NonPlayerCharacter npc) { this.npc = npc; }

    public void addItem(Item item) { items.add(item); }

    public Item takeItem(String name) {
        for (int i = 0; i < items.size(); i++)
            if (items.get(i).getName().equalsIgnoreCase(name))
                return items.remove(i);
        return null;
    }

    public boolean isLocked() { return false; }
    public void unlock() {}

    public String onEnter(Player player) {
        int roll = (int)(Math.random() * 100);
        if (roll < 15) {
            player.takeDamage(5);
            return "You get jumped in the street. Lose 5 health.";
        }
        if (roll < 30 && npc == null) {
            npc = new Enemy("Street Thug", 20, 5, "The thug snarls.");
            return "A thug appears!";
        }
        return description;
    }

    @Override
    public String toString() {
        return description +
                "\nItems: " + (items.isEmpty() ? "none" : items) +
                "\n" + (npc == null ? "No one is here." : "You see " + npc.getName());
    }
}
    
