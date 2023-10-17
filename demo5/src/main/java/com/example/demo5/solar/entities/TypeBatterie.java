package com.example.demo5.solar.entities;

public class TypeBatterie {
    int Id;
    double Valeur;

    public TypeBatterie(){}

    public TypeBatterie(int id, double valeur) {
        Id = id;
        Valeur = valeur;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getValeur() {
        return Valeur;
    }

    public void setValeur(double valeur) {
        Valeur = valeur;
    }
}
