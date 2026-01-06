public class Park extends Location {

    public Park() {
        super("Park", "A peaceful park.");
    }

    public Park(String name, String description) {
        super(name, description);
    }

    @Override
    public String onEnter(Player player) {
        return "A breeze passes through the park. It's calming.";
    }
}

    

