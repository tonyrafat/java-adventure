public class Shop extends Building {

    public Shop() {
        super("Shop", "A small shop.");
    }

    public Shop(String name, String description) {
        super(name, description);
    }

    @Override
    public String onEnter(Player player) {
        return "You enter the shop. A clerk nods at you.";
    }
}
