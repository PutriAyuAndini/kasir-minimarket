/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minimarkets;

/**
 *
 * @author lenovo
 */
import java.util.List;
import java.util.ArrayList;

public class Transaksi {
    private List<Barang> data;
    private List<Integer> jumlah;
    private static final int MAX_DATA = 100;

    public Transaksi() {
        data = new ArrayList<>();
        jumlah = new ArrayList<>();
    }

    public void display() {
        for (int i = 0; i < jumlah.size(); i++) {
            Barang barang = data.get(i);
            int jumlahBarang = jumlah.get(i);
            int totalHarga = barang.getHarga() * jumlahBarang;
            
            if (barang instanceof BarangPromo) {
                BarangPromo barangPromo = (BarangPromo) barang;
                double diskon = barangPromo.getDiskon();
                int hargaDiskon = (int) (totalHarga * (1 - diskon));
                System.out.println(barang.getNama() + " " + totalHarga + " (Diskon " + diskon * 100 + "%) = " + hargaDiskon);
            } else {
                System.out.println(barang.getNama() + " " + totalHarga);
            }
        }
    }

    public int total() {
        int total = 0;
        for (int i = 0; i < jumlah.size(); i++) {
            total += (data.get(i).getHarga() * jumlah.get(i));
        }
        return total;
    }

    public void sort() {
        bubbleSort();
    }

    public void search(String x) {
        int letak = sequentialSearch(x);
        if (letak == -1) {
            System.out.println("Data tidak ditemukan");
        } else {
            System.out.println(data.get(letak).getNama() + " " + (data.get(letak).getHarga() * jumlah.get(letak)));
        }
    }

    public void add(Barang b, int q) {
    data.add(b);
    jumlah.add(q);
    
    if (b instanceof BarangPromo) {
        BarangPromo barangPromo = (BarangPromo) b;
        double diskon = barangPromo.getDiskon();
        System.out.println("Diskon " + diskon * 100 + "% diterapkan pada barang " + b.getNama());
    }
}

    public int sequentialSearch(String x) {
        for (int i = 0; i < jumlah.size(); i++) {
            if (data.get(i).getNama().equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public void bubbleSort() {
        int n = jumlah.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (jumlah.get(j) * data.get(j).getHarga() > jumlah.get(j + 1) * data.get(j + 1).getHarga()) {
                    int temp = jumlah.get(j);
                    Barang a = data.get(j);
                    jumlah.set(j, jumlah.get(j + 1));
                    jumlah.set(j + 1, temp);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, a);
                }
    }
}