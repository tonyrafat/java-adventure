public class Food extends Item {
    private int heal;

    public Food(String name, String desc, int value, int heal) {
        super(name, desc, value);
        this.heal = heal;
    }

    @Override
    public String use(Player player) {
        player.setHealth(player.getHealth() + heal);
        return "You eat the food and feel better.";
    }
}

