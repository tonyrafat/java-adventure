public class Building extends Location {
    private boolean locked = true;

    public Building(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isLocked() { return locked; }

    @Override
    public void unlock() { locked = false; }

    @Override
    public String onEnter(Player player) {
        if (locked) return "The door is locked.";
        return "You enter the building.";
    }
}
