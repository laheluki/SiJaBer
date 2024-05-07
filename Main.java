package uts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Muhamad Rifki Saputra
 *         Tugas UTS Mata Kuliah Pemrograman Berbasis Objek
 *         Syarat utama Nested IF, Array, Looping
 *         Membuat Aplikasi Transaksi Agen Beras
 *         input, output, processing data
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Transaction transaction = new Transaction();
        transaction.startTransaction();
        transaction.printReceipt();
    }
}

class Transaction {
    String nama_kasir;
    String[] jenis_beras, kualitas;
    int[] jumlah_kg;
    double[] harga_per_kg, total_harga;
    String tanggal;

    private void discount() {
        double total_pendapatan = 0;
        for (double total : total_harga) {
            total_pendapatan += total;
        }
        if (total_pendapatan > 100000) {
            double diskon = 0.05 * total_pendapatan;
            System.out.println("Anda mendapatkan diskon sebesar Rp " + diskon);
            total_pendapatan -= diskon;
            System.out.println("Total Yang harus dibayar adalah : Rp " + total_pendapatan);
        } else {
            System.out.println("Pembelian kurang dari Rp 100.000 tidak mendapat diskon");
            System.out.println("Total Yang harus dibayar adalah : Rp " + total_pendapatan);
        }

    }

    public void startTransaction() throws IOException {
        InputStreamReader keyReader = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(keyReader);

        System.out.println("=".repeat(43));
        System.out.println("   Selamat Datang di Aplikasi Si JaBer    ");
        System.out.println("     Aplikasi Sistem Java Agen Beras      ");
        System.out.println("=".repeat(43));

        System.out.print("Masukkan nama kasir : ");
        nama_kasir = input.readLine();

        System.out.print("Masukkan tanggal pembelian : ");
        tanggal = input.readLine();

        System.out.print("Masukkan jumlah data pembelian beras: ");
        int jumlah_data = Integer.parseInt(input.readLine());

        jenis_beras = new String[jumlah_data];
        kualitas = new String[jumlah_data];
        jumlah_kg = new int[jumlah_data];
        harga_per_kg = new double[jumlah_data];
        total_harga = new double[jumlah_data];

        for (int i = 0; i < jumlah_data; i++) {
            System.out.println("\nData ke-" + (i + 1));
            System.out.print("Jenis Beras [(P) Premium /(M) Medium /(B) Biasa]: ");
            jenis_beras[i] = input.readLine().toUpperCase();
            System.out.print("Kualitas [(B) Baik /(S) Sedang /(J) Jelek]: ");
            kualitas[i] = input.readLine().toUpperCase();
            System.out.print("Jumlah (kg): ");
            jumlah_kg[i] = Integer.parseInt(input.readLine());

            // Determine harga berdasarkan jenis dan kualitas beras
            if (jenis_beras[i].equalsIgnoreCase("P")) {
                jenis_beras[i] = "Premium";
                if (kualitas[i].equalsIgnoreCase("B")) {
                    kualitas[i] = "Baik";
                    harga_per_kg[i] = 12000;
                } else if (kualitas[i].equalsIgnoreCase("S")) {
                    kualitas[i] = "Sedang";
                    harga_per_kg[i] = 10000;
                } else {
                    kualitas[i] = "Jelek";
                    harga_per_kg[i] = 8000;
                }
            } else if (jenis_beras[i].equalsIgnoreCase("M")) {
                jenis_beras[i] = "Medium";
                if (kualitas[i].equalsIgnoreCase("B")) {
                    kualitas[i] = "Baik";
                    harga_per_kg[i] = 10000;
                } else if (kualitas[i].equalsIgnoreCase("S")) {
                    kualitas[i] = "Sedang";
                    harga_per_kg[i] = 8000;
                } else {
                    kualitas[i] = "Jelek";
                    harga_per_kg[i] = 6000;
                }
            } else if (jenis_beras[i].equalsIgnoreCase("B")) {
                jenis_beras[i] = "Biasa";
                if (kualitas[i].equalsIgnoreCase("B")) {
                    kualitas[i] = "Baik";
                    harga_per_kg[i] = 8000;
                } else if (kualitas[i].equalsIgnoreCase("S")) {
                    kualitas[i] = "Sedang";
                    harga_per_kg[i] = 6000;
                } else {
                    kualitas[i] = "Jelek";
                    harga_per_kg[i] = 4000;
                }
            } else {
                System.out.println("Jenis beras tidak valid.");
                return;
            }

            total_harga[i] = harga_per_kg[i] * jumlah_kg[i];
        }
    }

    public void printReceipt() {
        System.out.print("\n");
        System.out.format("+----+-------------+----------------+-------------+-------------+-------------+%n");
        System.out.format("| Nota Pembelian " + tanggal + "      Agen Beras Haji Lulung   Kasir : " + nama_kasir
                + "|\n");
        System.out.format("+----+-------------+----------------+-------------+-------------+-------------+%n");
        System.out.format("| No | Jenis Beras | Kualitas Beras | Jumlah (Kg) | Harga       | Total       |%n");
        System.out.format("+----+-------------+----------------+-------------+-------------+-------------+%n");

        String leftAlignFormat = "| %-2s | %-11s | %-14s | %-11s | %-11s | %-11s |%n";
        for (int i = 0; i < jumlah_kg.length; i++) {
            System.out.format(leftAlignFormat, (i + 1), jenis_beras[i], kualitas[i], jumlah_kg[i],
                    "Rp " + harga_per_kg[i], "Rp " + total_harga[i]);
        }
        System.out.format("+----+-------------+----------------+-------------+-------------+-------------+%n");
        discount();
    }
}