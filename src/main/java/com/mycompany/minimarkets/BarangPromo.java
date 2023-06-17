/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minimarkets;

/**
 *
 * @author lenovo
 */
public class BarangPromo extends Barang implements Diskon {
    private double diskon;

    public BarangPromo(String nama, int harga, double diskon) {
        super(nama, harga);
        this.diskon = diskon;
    }

    public double getDiskon() {
        return diskon;
    }

    @Override
    public double hitungDiskon() {
        return diskon * getHarga();
    }
}