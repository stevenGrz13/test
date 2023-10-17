package com.example.demo5.solar.entities;

public class ClientModule {
    int Id;
    int Idclient;
    int Idmodule;

    public ClientModule(){}

    public ClientModule(int idclient, int idmodule) {
        Idclient = idclient;
        Idmodule = idmodule;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdclient() {
        return Idclient;
    }

    public void setIdclient(int idclient) {
        Idclient = idclient;
    }

    public int getIdmodule() {
        return Idmodule;
    }

    public void setIdmodule(int idmodule) {
        Idmodule = idmodule;
    }
}
