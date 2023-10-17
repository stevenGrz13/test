package com.example.demo5.solar.entities;

import java.sql.Timestamp;

public class Donnee {
    int Id;

    int Idmodule;
    double VoltagePanneau;
    double VoltageOutPut;
    double Consommation;
    double Production;

    double ValeurBatterie;

    double VoltageBatterie;
    Timestamp Temps;
    public Donnee(){}

    public Donnee(int idmodule, double voltagePanneau, double voltageOutPut, double consommation, double production, double valeurBatterie, double voltageBatterie, Timestamp temps) {
        Idmodule = idmodule;
        VoltagePanneau = voltagePanneau;
        VoltageOutPut = voltageOutPut;
        Consommation = consommation;
        Production = production;
        ValeurBatterie = valeurBatterie;
        VoltageBatterie = voltageBatterie;
        Temps = temps;
    }

    public int getIdmodule() {
        return Idmodule;
    }

    public void setIdmodule(int idmodule) {
        Idmodule = idmodule;
    }

    public double getVoltageBatterie() {
        return VoltageBatterie;
    }

    public void setVoltageBatterie(double voltageBatterie) {
        VoltageBatterie = voltageBatterie;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getVoltagePanneau() {
        return VoltagePanneau;
    }

    public void setVoltagePanneau(double voltagePanneau) {
        VoltagePanneau = voltagePanneau;
    }

    public double getVoltageOutPut() {
        return VoltageOutPut;
    }

    public void setVoltageOutPut(double voltageOutPut) {
        VoltageOutPut = voltageOutPut;
    }

    public double getConsommation() {
        return Consommation;
    }

    public void setConsommation(double consommation) {
        Consommation = consommation;
    }

    public double getProduction() {
        return Production;
    }

    public void setProduction(double production) {
        Production = production;
    }

    public double getValeurBatterie() {
        return ValeurBatterie;
    }

    public void setValeurBatterie(double valeurBatterie) {
        ValeurBatterie = valeurBatterie;
    }

    public Timestamp getTemps() {
        return Temps;
    }

    public void setTemps(Timestamp temps) {
        Temps = temps;
    }
}
