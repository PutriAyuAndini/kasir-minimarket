/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.minimarkets;

/**
 *
 * @author lenovo
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static final int MAX_BARANG = 100;
    public static void menu() {
        System.out.println("===============================");
        System.out.println("MINIMARKET");
        System.out.println("===============================");
        System.out.println("1. Beli Barang");
        System.out.println("2. Urutkan Berdasarkan Total Harga");
        System.out.println("3. Cari Berdasarkan Nama Barang");
        System.out.println("4. Tampilkan History");
        System.out.println("5. Exit/Bayar");
        System.out.println("6. Tambah Barang Promo");
        System.out.print("Pilih ");
    }

    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        Transaksi transaksi = new Transaksi();
        List<Barang> data = new ArrayList<>();
        data.add(new Barang("Sabun", 10000));
        data.add(new Barang("Coca Cola", 5000));
        data.add(new Barang("Kitkat", 10000));
        data.add(new Barang("Yakult", 11000));
        data.add(new Barang("Champ Sosis", 13000));

        while (true) {
            menu();
            String pilihan = get.nextLine();
            if (pilihan.equals("1")) {
                System.out.println("Daftar Barang : ");
                for (int i = 0; i < data.size(); i++) {
                    System.out.println((i + 1) + ". " + data.get(i).getNama() + "\t" + data.get(i).getHarga());
                }
                System.out.print("Pilih ");
                int x = Integer.parseInt(get.nextLine());
                System.out.print("Jumlah Barang = ");
                int q = Integer.parseInt(get.nextLine());
                transaksi.add(data.get(x - 1), q);
                System.out.println("Transaksi Berhasil");
            } else if (pilihan.equals("2")) {
                transaksi.sort();
                System.out.println("Transaksi Berhasil Diurutkan");
            } else if (pilihan.equals("3")) {
                System.out.print("Masukan Nama Barang : ");
                String nama = get.nextLine();
                transaksi.search(nama);

            } else if (pilihan.equals("4")) {
                transaksi.display();
            } else if (pilihan.equals("5")) {
                int test = 1;
                test += 1;
                int total = transaksi.total();
                System.out.println("Total Harga: " + total);
                while (true) {
                    System.out.print("Masukan Pembayaran:");
                    int bayar = Integer.parseInt(get.nextLine());
                    if (bayar > total) {
                        System.out.println("Kembali :" + (bayar - total));
                        break;
                    } else {
                        System.out.println("Pembayaran kurang :" + (total - bayar));
                    }
                }
                System.out.println("\nTerimakasih telah menggunakan program saya!");
                System.out.println("Nama\t : Putri Ayu Andini");
                System.out.println("NIM\t : 225150600111017");
                break;
            } else if (pilihan.equals("6")) {
                System.out.print("Masukkan Nama Barang: ");
                String nama = get.nextLine();
                System.out.print("Masukkan Harga Barang: ");
                int harga = Integer.parseInt(get.nextLine());
                System.out.print("Masukkan Diskon Barang (0-1): ");
                double diskon = Double.parseDouble(get.nextLine());
    
                BarangPromo barangPromo = new BarangPromo(nama, harga, diskon);
                int jumlahs = 0;
                data.set(jumlahs, barangPromo);
    
                System.out.print("Jumlah Barang = ");
                int q = Integer.parseInt(get.nextLine());
                transaksi.add(data.get(jumlahs), q);
    
                System.out.println("Barang Promo berhasil ditambahkan");
            } else {
                System.out.println("Input Tidak ada di Pilihan");
            }
        }

    }
}