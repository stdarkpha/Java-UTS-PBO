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