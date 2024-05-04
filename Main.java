package uts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader Keyreader = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(Keyreader);

        // Deklarasi variabel
        int jumlah_data;
        String nama_kasir;
        String[] jenis_beras, kualitas;
        int[] jumlah_kg;
        double[] harga_per_kg, total_harga;

        System.out.println("=".repeat(43));
        System.out.println("   Selamat Datang di Aplikasi Si JaBer    ");
        System.out.println("     Aplikasi Sistem Java Agen Beras      ");
        System.out.println("=".repeat(43));

        System.out.print("Masukkan nama kasir : ");
        nama_kasir = input.readLine();

        System.out.print("Masukkan jumlah data pembelian beras: ");
        jumlah_data = Integer.parseInt(input.readLine());

        jenis_beras = new String[jumlah_data];
        kualitas = new String[jumlah_data];
        jumlah_kg = new int[jumlah_data];
        harga_per_kg = new double[jumlah_data];
        total_harga = new double[jumlah_data];

        double totalPendapatan = 0;

        for (int i = 0; i < jumlah_data; i++) {
            System.out.println("\nData ke-" + (i + 1));
            System.out.print("Jenis Beras [(P) Premium /(M) Medium /(B) Biasa]: ");
            jenis_beras[i] = input.readLine().toUpperCase();
            System.out.print("Kualitas [(B) Baik /(S) Sedang /(J) Jelek]: ");
            kualitas[i] = input.readLine().toUpperCase();
            System.out.print("Jumlah (kg): ");
            jumlah_kg[i] = Integer.parseInt(input.readLine());

            // Tentukan harga berdasarkan jenis dan kualitas beras
            if (jenis_beras[i].equalsIgnoreCase("P")) {
                if (kualitas[i].equalsIgnoreCase("B")) {
                    harga_per_kg[i] = 12000;
                } else if (kualitas[i].equalsIgnoreCase("S")) {
                    harga_per_kg[i] = 10000;
                } else {
                    harga_per_kg[i] = 8000;
                }
            } else if (jenis_beras[i].equalsIgnoreCase("M")) {
                if (kualitas[i].equalsIgnoreCase("B")) {
                    harga_per_kg[i] = 10000;
                } else if (kualitas[i].equalsIgnoreCase("S")) {
                    harga_per_kg[i] = 8000;
                } else {
                    harga_per_kg[i] = 6000;
                }
            } else if (jenis_beras[i].equalsIgnoreCase("B")) {
                if (kualitas[i].equalsIgnoreCase("B")) {
                    harga_per_kg[i] = 8000;
                } else if (kualitas[i].equalsIgnoreCase("S")) {
                    harga_per_kg[i] = 6000;
                } else {
                    harga_per_kg[i] = 4000;
                }
            } else {
                System.out.println("Jenis beras tidak valid.");
                return;
            }

            total_harga[i] = harga_per_kg[i] * jumlah_kg[i];
            totalPendapatan += total_harga[i];
        }

        System.out.println("\n===== LAPORAN PENJUALAN BERAS =====");
        for (int i = 0; i < jumlah_data; i++) {
            System.out.println("Data ke-" + (i + 1));
            System.out.println("Nama Kasir: " + nama_kasir);
            System.out.println("Jenis Beras: " + jenis_beras[i]);
            System.out.println("Kualitas: " + kualitas[i]);
            System.out.println("Harga per kg: Rp" + harga_per_kg[i]);
            System.out.println("Jumlah (kg): " + jumlah_kg[i]);
            System.out.println("Total Harga: Rp" + total_harga[i]);
            System.out.println();
        }
        System.out.println("Total Pendapatan: Rp" + totalPendapatan);
    }
}
