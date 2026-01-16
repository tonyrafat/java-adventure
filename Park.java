public class Park extends Location {
    public Park(String name, String description) {
        super(name, description);
    }

    @Override
    public String onEnter(Player player) {
        return "The park feels peaceful.";
    }
}

    

