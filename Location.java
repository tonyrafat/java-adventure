import java.util.ArrayList;

public class Location {
    private String name;
    private String description;
    private ArrayList<Item> items;
    private NonPlayerCharacter npc;

    public Location() {
        this("Empty Street", "Just a normal street.");
    }

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.npc = null;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public NonPlayerCharacter getNpc() { return npc; }
    public void setNpc(NonPlayerCharacter npc) { this.npc = npc; }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item takeItemByName(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(name)) {
                return items.remove(i);
            }
        }
        return null;
    }

    public String onEnter(Player player) {
        return "";
    }

    @Override
    public String toString() {
        return description +
                "\nItems: " + (items.isEmpty() ? "none" : items) +
                "\n" + (npc == null ? "No one is here." : "You see " + npc.getName());
    }
}

    
