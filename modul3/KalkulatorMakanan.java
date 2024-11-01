import java.util.Scanner;

public class KalkulatorMakanan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah kalori nasi (per porsi): ");
        int kaloriNasi = scanner.nextInt();

        System.out.print("Masukkan jumlah kalori ayam (per porsi): ");
        int kaloriAyam = scanner.nextInt();

        // Menggunakan custom live template "totalKalori"
        int totalKalori = kaloriNasi + kaloriAyam;
        System.out.println("Total kalori: " + totalKalori);
    }
}