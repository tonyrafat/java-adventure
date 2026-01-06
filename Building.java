public class Building extends Location {

    public Building() {
        super("Building", "A generic building.");
    }

    public Building(String name, String description) {
        super(name, description);
    }

    @Override
    public String onEnter(Player player) {
        return "You step inside the building.";
    }
}

