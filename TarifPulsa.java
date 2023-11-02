/* 
 * UTS PBO 2023 - Farouq Mulya Al Simabua - 2022071087
 * 
 * ---------------------------------------------------
 * Program untuk menghitung sisa pulsa dan biaya  
 * percakapan telepon dengan tarif Rp 150 per 5 detik.
 * ---------------------------------------------------
 */

import java.util.Scanner;

class Percakapan {
    // Atribut yang akan digunakan untuk menghitung biaya percakapan
    private int jam;
    private int menit;
    private int detik;

    // Konstruktor untuk menerima jam, menit, dan detik
    public Percakapan(int jam, int menit, int detik) {
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
    }

    // Method untuk menghitung durasi percakapan dalam detik
    public int getDurasiDetik() {
        return (jam * 3600) + (menit * 60) + detik;
    }

    // Method untuk menghitung pulsa dan biaya percakapan
    public int getPulsa() {
        return getDurasiDetik() / 5;
    }

    // Method untuk menghitung biaya percakapan
    public int getBiaya() {
        return getPulsa() * 150;
    }
}

class TarifPulsa {
    public static void main(String[] args) {

        // Memasukkan pulsa yang dimiliki
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMasukkan pulsa yang Anda miliki: ");
        int pulsa = scanner.nextInt();

        // Memasukkan waktu awal dan akhir percakapan
        Percakapan awal = new Percakapan(8, 0, 0);
        Percakapan akhir = new Percakapan(8, 12, 34);

        // Menghitung durasi percakapan
        int durasiDetik = akhir.getDurasiDetik() - awal.getDurasiDetik();
        Percakapan percakapan = new Percakapan(durasiDetik / 3600, (durasiDetik % 3600) / 60, durasiDetik % 60);

        // Menghitung sisa pulsa dan biaya percakapan
        int biayaPercakapan = percakapan.getBiaya();
        int sisaPulsa = pulsa - biayaPercakapan;

        // Menampilkan hasil perhitungan
        System.out.println("\nBerikut Tarif Biaya Percakapan:");
        System.out.println(
                "Durasi: " + durasiDetik + " detik, " + "Tarif Dasar: Rp." + percakapan.getPulsa() + " /Pulsa");
        System.out.println("Biaya Percakapan: Rp " + biayaPercakapan);

        if (sisaPulsa >= 0) {
            System.out.println("\nSisa Pulsa: Rp " + sisaPulsa);
        } else {
            System.out.println("\nMaaf, pulsa Anda kurang untuk percakapan ini.");
        }

        scanner.close();
    }
}