import java.util.Scanner;

public class AdventureGame {

    public static void main(String[] args) {
        Location[][] world = buildWorld(5, 5);
        Player player = new Player("Explorer", 100, 2, 2);

        System.out.println("----------------------------------------");
        System.out.println(" Welcome to the Neighborhood Adventure!");
        System.out.println("----------------------------------------");
        System.out.println("Type 'help' for commands.\n");

        playGame(world, player);
    }

    private static Location[][] buildWorld(int rows, int cols) {
        Location[][] grid = new Location[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Location("Empty Street", "Just a normal street.");
            }
        }

        grid[2][2] = new Park("Town Square", "A busy gathering place with a fountain.");

        grid[1][2] = new Shop("Bakery", "The smell of fresh bread wafts out.");
        grid[1][2].addItem(new Food("Croissant", "Warm and flaky.", 3, 10));

        grid[2][3] = new Building("Dark Alley", "It is very dark here.");
        grid[2][3].addItem(new Tool("Key", "A small metal key.", 0));
        grid[2][3].setNpc(new Enemy("Thug", 30, 6, "The thug blocks your path."));

        grid[3][1] = new Park("Oak Garden", "A quiet garden with a tall oak tree.");
        grid[3][1].addItem(new Treasure("Golden Key", "It glows faintly.", 50));

        grid[4][2] = new Building("Old Bookstore", "A locked bookstore door.");

        return grid;
    }

    private static void playGame(Location[][] world, Player player) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            Location current = world[player.getRow()][player.getCol()];

            System.out.println("\n----------------------------------------");
            System.out.println("Position: (" + player.getRow() + "," + player.getCol() + ")");
            System.out.println(current.getName());
            System.out.println("----------------------------------------");

            String enterText = current.onEnter(player);
            if (!enterText.isEmpty()) System.out.println(enterText);

            System.out.print("\n> ");
            String input = scanner.nextLine().trim();
            String lower = input.toLowerCase();

            if (lower.equals("help")) printHelp();
            else if (lower.equals("look")) System.out.println(current);
            else if (lower.startsWith("move ")) System.out.println(player.move(lower.substring(5), world));
            else if (lower.matches("n|s|e|w|north|south|east|west"))
                System.out.println(player.move(lower, world));
            else if (lower.startsWith("pick up "))
                System.out.println(player.pickUp(input.substring(8), current));
            else if (lower.startsWith("use "))
                System.out.println(player.use(input.substring(4)));
            else if (lower.equals("inventory"))
                System.out.println("Inventory: " + player.inventoryString());
            else if (lower.equals("status")) {
                System.out.println("Health: " + player.getHealth());
                System.out.println("Inventory: " + player.inventoryString());
            }
            else if (lower.equals("talk")) {
                if (current.getNpc() == null) System.out.println("No one is here.");
                else System.out.println(current.getNpc().talk());
            }
            else if (lower.equals("attack"))
                System.out.println(player.attackEnemy(current));
            else if (lower.equals("unlock"))
                System.out.println(player.unlock(current));
            else if (lower.equals("quit")) {
                System.out.println("Thanks for playing!");
                running = false;
            }
            else System.out.println("Command not recognized. Type 'help'.");

            if (player.getHealth() <= 0) {
                System.out.println("\nGAME OVER");
                running = false;
            }
        }
        scanner.close();
    }

    private static void printHelp() {
        System.out.println("Available commands:");
        System.out.println(" move north | south | east | west");
        System.out.println(" n | s | e | w");
        System.out.println(" look");
        System.out.println(" pick up <item>");
        System.out.println(" use <item>");
        System.out.println(" attack");
        System.out.println(" unlock");
        System.out.println(" talk");
        System.out.println(" inventory");
        System.out.println(" status");
        System.out.println(" quit");
    }
}
