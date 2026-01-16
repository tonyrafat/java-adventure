public class Shop extends Building {
    public Shop(String name, String description) {
        super(name, description);
    }

    @Override
    public String onEnter(Player player) {
        if (isLocked()) return "The shop is closed.";
        return "You enter the shop.";
    }
}
