import java.util.Scanner;

public class app {
    public static class Game {
        private Player player;
        private Monster monster;
        private Item item;

        public Game() {
            player = new Player("Герой");
            monster = new Monster("Монстр");
            item = new Item("Зелье здоровья");
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Добро пожаловать в простую RPG-игру!");
            System.out.println("Ваш герой: " + player.getName());

            while (player.isAlive() && monster.isAlive()) {
                System.out.println("\nЧто вы хотите сделать?");
                System.out.println("1. Атаковать монстра");
                System.out.println("2. Посмотреть статус");
                System.out.println("3. Использовать предмет");
                System.out.println("4. Выйти из игры");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        player.attack(monster);
                        if (monster.isAlive()) {
                            monster.attack(player);
                        } else {
                            System.out.println(monster.getName() + " повержен!");
                        }
                        break;
                    case 2:
                        System.out.println("Статус героя:");
                        System.out.println("Здоровье: " + player.getHealth());
                        System.out.println("Статус монстра:");
                        System.out.println("Здоровье: " + monster.getHealth());
                        break;
                    case 3:
                        System.out.println("Вы использовали " + item.getName() + " и восстановили здоровье!");
                        player.setHealth(player.getHealth() + 20);
                        break;
                    case 4:
                        System.out.println("Выход из игры...");
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            }

            if (player.isAlive()) {
                System.out.println("Поздравляем! Вы победили!");
            } else {
                System.out.println("Игра окончена. Ваш герой погиб.");
            }
        }

        public static void main(String[] args) {
            Game game = new Game();
            game.start();
        }
    }

    public static class Item {
        private String name;

        public Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Monster {
        private String name;
        private int health;
        private int attackPower;

        public Monster(String name) {
            this.name = name;
            this.health = 50;
            this.attackPower = 5;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getAttackPower() {
            return attackPower;
        }

        public void attack(Player player) {
            player.setHealth(player.getHealth() - attackPower);
            System.out.println(name + " атакует " + player.getName() + " и наносит " + attackPower + " урона!");
        }

        public boolean isAlive() {
            return health > 0;
        }
    }

    public static class Player {
        private String name;
        private int health;
        private int attackPower;

        public Player(String name) {
            this.name = name;
            this.health = 100;
            this.attackPower = 10;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getAttackPower() {
            return attackPower;
        }

        public void attack(Monster monster) {
            monster.setHealth(monster.getHealth() - attackPower);
            System.out.println(name + " атакует " + monster.getName() + " и наносит " + attackPower + " урона!");
        }

        public boolean isAlive() {
            return health > 0;
        }
    }
}
