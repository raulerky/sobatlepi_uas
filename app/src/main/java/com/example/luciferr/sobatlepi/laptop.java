package com.example.luciferr.sobatlepi;

/**
 * Created by fandy on 21/05/2016.
 */
public class laptop {
    private String tipe, merk, jenis;
    private int harga;

    public laptop(String tipe,String merk,String jenis, int harga){
        this.setTipe(tipe);
        this.setMerk(merk);
        this.setJenis(jenis);
        this.setHarga(harga);
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
