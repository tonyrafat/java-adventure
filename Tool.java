public class Tool extends Item {
    public Tool(String name, String desc, int value) {
        super(name, desc, value);
    }

    @Override
    public String use(Player player) {
        return "You use the tool.";
    }
}

