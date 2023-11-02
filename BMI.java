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
