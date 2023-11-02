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