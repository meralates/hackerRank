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
            return b.score - a.score; // Yüksek puandan düşük puana sıralama
        } else {
            return a.name.compareTo(b.name); // İsim sıralaması
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Oyuncu sayısını al
        scanner.nextLine(); // Satır sonunu atla

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine(); // İsim girişi
            int score = scanner.nextInt(); // Puan girişi
            scanner.nextLine(); // Bir sonraki satır sonunu atla
            players[i] = new Player(name, score); // Oyuncuyu oluştur
        }

        Arrays.sort(players, new Checker()); // Oyuncuları sıralama

        for (Player player : players) {
            System.out.println(player.name + " " + player.score); // Sıralı çıktı
        }

        scanner.close(); // Scanner'ı kapat
    }
}
