package com.example.demo5.solar.entities;

public class Client {
    int Id;
    String Email;
    String Pass;
    String LienImage;

    String Adresse;

    String CodePostal;
    boolean HaveQr;
    public Client(){}

    public Client(String email, String pass, String lienImage, String adresse, String codePostal, boolean haveQr) {
        Email = email;
        Pass = pass;
        LienImage = lienImage;
        Adresse = adresse;
        CodePostal = codePostal;
        HaveQr = haveQr;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getLienImage() {
        return LienImage;
    }

    public void setLienImage(String lienImage) {
        LienImage = lienImage;
    }

    public boolean isHaveQr() {
        return HaveQr;
    }

    public void setHaveQr(boolean haveQr) {
        HaveQr = haveQr;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(String codePostal) {
        CodePostal = codePostal;
    }
}
