
![Logo](https://raw.githubusercontent.com/stdarkpha/Java-UTS-PBO/main/logo.webp)


# Java Program - UTS PBO 2023

Pada repository ini mencakup tentang program Java yang dikerjakan untuk UTS mata kuliah Pemrograman Berorientasi Objek (PBO). 

Program ini mencakup pemahaman konsep-konsep bahasa pemrograman.
Termasuk di antaranya adalah pemahaman dan implementasi operator perbandingan dan aritmatika, pengontrolan alur program dengan IF, IF-Else, dan IF Bersarang, penggunaan atribut dan method sebagai anggota dari class, user input, pemahaman perbedaan antara class dan object, implementasi Recursion, pemahaman konsep loop, serta kemampuan untuk menganalisis, merancang, dan menerapkan sistem berbasis komputer secara efisien menggunakan pemrograman prosedural dan berorientasi objek.


## List Program

 - [Program Tarif Pulsa](#program-tarif-pulsa)
 - [Program Formula BMI](#program-formula-bmi)
 - [Program Input Bilangan dan Jumlah](#program-input-bilangan-dan-jumlah)
 - [Program Penghitung Lingkaran & Inheritance](#program-penghitung-lingkaran--inheritance)
 

## Program Tarif Pulsa

Berikut kode program untuk menghitung sisa pulsa dan biaya percakapan telepon dengan tarif Rp 150 per 5 detik

```bash
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
```
Output1:
```bash
Masukkan pulsa yang Anda miliki: 50000

Berikut Tarif Biaya Percakapan:
Durasi: 754 detik, Tarif Dasar: Rp.150 /Pulsa
Biaya Percakapan: Rp 22500

Sisa Pulsa: Rp 27500
```

Output2: (Jika pulsa kurang)
```bash
Masukkan pulsa yang Anda miliki: 10000

Berikut Tarif Biaya Percakapan:
Durasi: 754 detik, Tarif Dasar: Rp.150 /Pulsa
Biaya Percakapan: Rp 22500

Maaf, pulsa Anda kurang untuk percakapan ini.
```

* [Download Source Code](https://github.com/stdarkpha/Java-UTS-PBO/blob/main/TarifPulsa.java)

## Program Formula BMI

Berikut kode program untuk menghitung BMI (Body Mass Index)

```bash
/* 
 * UTS PBO 2023 - Farouq Mulya Al Simabua - 2022071087
 * 
 * ---------------------------------------------------
 * Program untuk menghitung BMI (Body Mass Index)
 * ---------------------------------------------------
 */

class IndeksMassaTubuh {
    // Atribut yang akan digunakan untuk menghitung BMI
    private double beratBadan;
    private double tinggiBadan;

    // Konstruktor untuk menerima berat badan dan tinggi badan
    public IndeksMassaTubuh(double beratBadan, double tinggiBadan) {
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
    }

    // Method untuk menghitung BMI
    public double hitungBMI() {
        double bmi = beratBadan / (tinggiBadan * tinggiBadan);
        // Membulatkan nilai BMI ke 1 angka di belakang koma
        return Math.round(bmi * 10.0) / 10.0;
    }

    // Method untuk menentukan status BMI
    public String getStatus() {
        double bmi = hitungBMI();
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi > 22.9) {
            return "Overweight";
        } else {
            return "Normal";
        }
    }

    // Method getter untuk mendapatkan berat badan dan tinggi badan
    public double getBeratBadan() {
        return beratBadan;
    }

    public double getTinggiBadan() {
        return tinggiBadan;
    }
}

public class BMI {
    public static void main(String[] args) {
        // Memasukkan berat badan dan tinggi badan
        IndeksMassaTubuh imm = new IndeksMassaTubuh(70, 1.75);

        System.out.println("Berat Badan: " + imm.getBeratBadan() + "kg");
        System.out.println("Tinggi Badan: " + imm.getTinggiBadan() + "m");
        System.out.println("BMI: " + imm.hitungBMI());
        System.out.println("Status: " + imm.getStatus());
    }
}

```
Output:
```bash
Berat Badan: 70.0kg
Tinggi Badan: 1.75m
BMI: 22.9
Status: Normal
```

* [Download Source Code](https://github.com/stdarkpha/Java-UTS-PBO/blob/main/BMI.java)

## Program Input Bilangan dan Jumlah

Berikut kode program untuk menghitung jumlah 10 bilangan bulat yang diinputkan oleh pengguna.

```bash
/* 
 * UTS PBO 2023 - Farouq Mulya Al Simabua - 2022071087
 * 
 * ---------------------------------------------------
 * Program untuk menghitung jumlah 10 bilangan bulat
 * yang diinputkan oleh pengguna.
 * ---------------------------------------------------
 * 
 */

import java.util.Scanner;

class Penjumlahan {
    // Atribut yang akan digunakan untuk menghitung jumlah 10 bilangan
    private int[] bilangan = new int[10];

    // Method untuk menginputkan 10 bilangan
    public void inputBilangan() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print("Masukkan bilangan ke-" + (i + 1) + ": ");
            bilangan[i] = input.nextInt();
        }
        input.close();
    }

    // Method untuk menghitung jumlah 10 bilangan
    public int hitungJumlah(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return bilangan[n - 1] + hitungJumlah(n - 1);
        }
    }
}

class InputJumlah {
    public static void main(String[] args) {
        // Memasukkan 10 bilangan
        Penjumlahan penjumlahan = new Penjumlahan();
        penjumlahan.inputBilangan();
        // Mencetak hasil penjumlahan
        System.out.println("\nJumlah 10 bilangan tersebut adalah: " + penjumlahan.hitungJumlah(10));
    }
}

```
Output:
```bash
Masukkan bilangan ke-1: 9
Masukkan bilangan ke-2: 8
Masukkan bilangan ke-3: 7
Masukkan bilangan ke-4: 6
Masukkan bilangan ke-5: 5
Masukkan bilangan ke-6: 4
Masukkan bilangan ke-7: 3
Masukkan bilangan ke-8: 2
Masukkan bilangan ke-9: 1
Masukkan bilangan ke-10: 9

Jumlah 10 bilangan tersebut adalah: 54
```

* [Download Source Code](https://github.com/stdarkpha/Java-UTS-PBO/blob/main/InputJumlah.java)

## Program Penghitung Lingkaran & Inheritance

Berikut kode program untuk menghitung jumlah 10 bilangan bulat yang diinputkan oleh pengguna.

```bash
/* 
 * UTS PBO 2023 - Farouq Mulya Al Simabua - 2022071087
 * 
 * ---------------------------------------------------
 * Program untuk menghitung Luas & Keliling Lingkaran,
 * lalu mewarisinya untuk menghitung Luas Permukaan &
 * Volume Tabung.
 * ---------------------------------------------------
 */

class Lingkaran {
    protected double jariJari; // Atribut jari-jari lingkaran

    // Konstruktor untuk menerima jari-jari lingkaran
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    // Method untuk menghitung luas dan keliling lingkaran
    public double hitungLuas() {
        return Math.round(Math.PI * jariJari * jariJari * 10.0) / 10.0;
    }

    public double hitungKeliling() {
        return Math.round(2 * Math.PI * jariJari * 10.0) / 10.0;
    }
}

// Inheritance (Pewarisan) dari class Lingkaran
class Tabung extends Lingkaran {
    private double tinggi; // Atribut tinggi tabung

    // Konstruktor untuk menerima jari-jari dan tinggi tabung
    public Tabung(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
    }

    // Method untuk menghitung luas permukaan dan volume tabung
    public double hitungLuasPermukaan() {
        double luasLingkaran = super.hitungLuas();
        double luasSelimut = 2 * Math.PI * jariJari * tinggi;
        double totalLuas = 2 * luasLingkaran + luasSelimut;
        return Math.round(totalLuas * 10.0) / 10.0;
    }

    public double hitungVolume() {
        return super.hitungLuas() * tinggi;
    }
}

class Hasil {
    public static void main(String[] args) {
        // Memasukkan jari-jari dan tinggi
        double jariJari = 5.0;
        double tinggi = 10.0;

        // Menghitung luas dan keliling lingkaran
        Lingkaran lingkaran = new Lingkaran(jariJari);
        System.out.println("\nDengan Jari-Jari (" + jariJari + ") kita dapat menghitung: ");
        System.out.println("Keliling lingkaran: " + lingkaran.hitungKeliling());
        System.out.println("Luas lingkaran: " + lingkaran.hitungLuas());

        // Menghitung luas permukaan dan volume tabung
        Tabung tabung = new Tabung(jariJari, tinggi);
        System.out.println("\ndan dengan mewarisi luas lingkaran diatas");
        System.out.println("\nKita dapat menghitung luas permukaan dan volume tabung:");
        System.out.println("Luas permukaan tabung: " + tabung.hitungLuasPermukaan());
        System.out.println("Volume tabung: " + tabung.hitungVolume());
    }
}

```
Output:
```bash
Dengan Jari-Jari (5.0) kita dapat menghitung: 
Keliling lingkaran: 31.4
Luas lingkaran: 78.5

dan dengan mewarisi luas lingkaran diatas

Kita dapat menghitung luas permukaan dan volume tabung:
Luas permukaan tabung: 471.2
Volume tabung: 785.0
```

* [Download Source Code](https://github.com/stdarkpha/Java-UTS-PBO/blob/main/PewarisanLingkaran.java)

## Authors

- [@Farouq Mulya Al Simabua - 2022071087](https://github.com/stdarkpha/)
