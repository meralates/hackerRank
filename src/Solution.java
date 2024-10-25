import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (b.score != a.score) {
            return b.score - a.score;
        } else {
            return a.name.compareTo(b.name);
        }
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            int score = scanner.nextInt();
            scanner.nextLine();
            players[i] = new Player(name, score);
        }

        Arrays.sort(players, new Checker());

        for (Player player : players) {
            System.out.println(player.name + " " + player.score);
        }

        scanner.close();
    }
}
