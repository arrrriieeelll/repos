import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pesawat {
    String kodePesawat;
    String namaPesawat;
    int jumlahKursi;

    Pesawat(String kode, String nama, int kursi) {
        this.kodePesawat = kode;
        this.namaPesawat = nama;
        this.jumlahKursi = kursi;
    }
}

class Penerbangan {
    String nomorPenerbangan;
    String rute;
    String tanggalKeberangkatan;
    String waktuKeberangkatan;
    Pesawat pesawat;

    Penerbangan(String nomor, String rute, String tanggal, String waktu, Pesawat pesawat) {
        this.nomorPenerbangan = nomor;
        this.rute = rute;
        this.tanggalKeberangkatan = tanggal;
        this.waktuKeberangkatan = waktu;
        this.pesawat = pesawat;
    }
}

public class PemesananTiket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data contoh
        List<Penerbangan> daftarPenerbangan = new ArrayList<>();
        daftarPenerbangan.add(new Penerbangan("GA123", "Jakarta - Bali", "2023-11-24", "10:00", new Pesawat("B737", "Boeing 737", 150)));
        daftarPenerbangan.add(new Penerbangan("SJ456", "Surabaya - Medan", "2023-11-25", "13:30", new Pesawat("A320", "Airbus A320", 180)));

        // Tampilkan daftar penerbangan
        System.out.println("Daftar Penerbangan:");
        for (Penerbangan penerbangan : daftarPenerbangan) {
            System.out.println("Nomor Penerbangan: " + penerbangan.nomorPenerbangan);
            System.out.println("Rute: " + penerbangan.rute);
            System.out.println("Tanggal: " + penerbangan.tanggalKeberangkatan + " " + penerbangan.waktuKeberangkatan);
            System.out.println("Pesawat: " + penerbangan.pesawat.namaPesawat);
            System.out.println("------------------------");
        }

        // Minta pengguna memilih penerbangan
        System.out.print("Masukkan nomor penerbangan yang ingin dipesan: ");
        String nomorPenerbangan = scanner.nextLine();

        // Cari penerbangan berdasarkan nomor
        Penerbangan penerbanganTerpilih = null;
        for (Penerbangan penerbangan : daftarPenerbangan) {
            if (penerbangan.nomorPenerbangan.equals(nomorPenerbangan)) {
                penerbanganTerpilih = penerbangan;
                break;
            }
        }

        if (penerbanganTerpilih != null) {
            System.out.print("Masukkan nama penumpang: ");
            String namaPenumpang = scanner.nextLine();
            System.out.print("Masukkan nomor telepon: ");
            String nomorTelepon = scanner.nextLine();
            System.out.print("Masukkan jumlah tiket: ");
            int jumlahTiket = scanner.nextInt();

            // Lakukan pemesanan (simplified)
            System.out.println("Pemesanan berhasil!");
            System.out.println("Nama Penumpang: " + namaPenumpang);
            System.out.println("Penerbangan: " + penerbanganTerpilih.nomorPenerbangan);
            System.out.println("Jumlah Tiket: " + jumlahTiket);
        } else {
            System.out.println("Penerbangan tidak ditemukan.");
        }
    }
}
