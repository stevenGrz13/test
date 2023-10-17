package com.example.demo5.solar.entities;

public class Module {
    int Id;
    String Qrcode;
    int IdBatterie;

    public Module(){}

    public Module(String qrcode, int idBatterie) {
        Qrcode = qrcode;
        IdBatterie = idBatterie;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getQrcode() {
        return Qrcode;
    }

    public void setQrcode(String qrcode) {
        Qrcode = qrcode;
    }

    public int getIdBatterie() {
        return IdBatterie;
    }

    public void setIdBatterie(int idBatterie) {
        IdBatterie = idBatterie;
    }
}
