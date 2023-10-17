package com.example.demo5.solar;

import com.example.demo5.solar.entities.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Fonction {

    public static Connexion conn = new Connexion();
    public static TypeBatterie getCapaciteById(int idtypebatterie) throws Exception{
        String sql = "select * from typebatterie where id="+idtypebatterie;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        TypeBatterie res = new TypeBatterie();
        while(rs.next()){
            res.setId(rs.getInt("id"));
            res.setValeur(rs.getDouble("valeur"));
        }
        connection.close();
        return res;
    }

    public static ArrayList<TypeBatterie> getListeCapaciteBatterie() throws Exception{
        String sql = "select * from typebatterie";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<TypeBatterie> liste = new ArrayList<>();
        while(rs.next()){
            TypeBatterie res = new TypeBatterie();
            res.setId(rs.getInt("id"));
            res.setValeur(rs.getDouble("valeur"));
            liste.add(res);
        }
        connection.close();
        return liste;
    }

    public static ArrayList<Client> getListClient() throws Exception{
        String sql = "select * from client";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Client> clients = new ArrayList<>();
        while(rs.next()){
            Client cl = new Client();
            cl.setId(rs.getInt("id"));
            cl.setEmail(rs.getString("email"));
            cl.setPass(rs.getString("pass"));
            cl.setLienImage(rs.getString("lienimage"));
            clients.add(cl);
        }
        connection.close();
        return clients;
    }

    public static Client getClientById(int id) throws Exception{
        String sql = "select * from client where id="+id;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Client cl = new Client();
        while(rs.next()){
            cl.setId(rs.getInt("id"));
            cl.setEmail(rs.getString("email"));
            cl.setPass(rs.getString("pass"));
            cl.setLienImage(rs.getString("lienimage"));
        }
        connection.close();
        return cl;
    }

    public static UsefulEntity loginClient(String email, String pass) throws Exception{
        UsefulEntity usefulEntitySolar = new UsefulEntity();
        usefulEntitySolar.setState(false);
        ArrayList<Client> liste = getListClient();
        for(int i=0; i<liste.size(); i++){
            if((Objects.equals(email, liste.get(i).getEmail()) && Objects.equals(pass, liste.get(i).getPass()))&&(liste.get(i).isHaveQr()==true)){
                usefulEntitySolar.setIdClient(liste.get(i).getId());
                usefulEntitySolar.setState(true);
            }
        }
        return usefulEntitySolar;
    }

    public static void signUpClient(String email, String pass, String lienimage, String adresse, String codepostale) throws Exception{
        String sql = "insert into client(email,pass,lienimage,adresse,codepostal) values ('"+email+"','"+pass+"','"+lienimage+"','"+adresse+"','"+codepostale+"')";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }

    public static void insertDonnee(String idmodule, String voltagepanneau, String voltageoutput, String voltagebatterie, String consommation, String production) throws Exception {
        long milliseconds = System.currentTimeMillis();
        Timestamp temps = new Timestamp(milliseconds);
        Module module = getModuleById(Integer.parseInt(idmodule));
        double capacitebatterie = getCapaciteById(module.getIdBatterie()).getValeur();
        double pourcentage = 0;
        double[] val = new double[5];
        val[0] = Double.parseDouble(voltagepanneau);
        val[1] = Double.parseDouble(voltageoutput);
        val[2] = Double.parseDouble(voltagebatterie);
        val[3] = Double.parseDouble(production);
        val[4] = Double.parseDouble(consommation);
        pourcentage = (capacitebatterie*Double.parseDouble(voltagebatterie))/100;
        String sql = "insert into donnees(idmodule,voltagepanneau,voltageoutput,voltagebatterie,production,consommation,valeurbatterie,temps) values ("+Integer.parseInt(idmodule)+","+val[0]+","+val[1]+","+val[2]+","+val[3]+","+val[4]+","+pourcentage+",'"+temps+"')";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }

    public static ArrayList<Donnee> getListDonnee() throws Exception {
        String sql = "select * from donnees";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Donnee> liste = new ArrayList<>();
        while(rs.next()){
            Donnee d = new Donnee();
            d.setIdmodule(rs.getInt("idmodule"));
            d.setVoltagePanneau(rs.getDouble("voltagepanneau"));
            d.setVoltageOutPut(rs.getDouble("voltageoutput"));
            d.setVoltageBatterie(rs.getDouble("voltagebatterie"));
            d.setProduction(rs.getDouble("production"));
            d.setConsommation(rs.getDouble("consommation"));
            d.setTemps(rs.getTimestamp("temps"));
            d.setValeurBatterie(rs.getDouble("valeurbatterie"));
            liste.add(d);
        }
        connection.close();
        return liste;
    }

    public static ArrayList<Donnee> getListDonneeSpecifique(String t1, String t2) throws Exception {
        String sql = "select * from donnees where temps >= '"+t1+"' and temps <= '"+t2+"'";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Donnee> liste = new ArrayList<>();
        while(rs.next()){
            Donnee d = new Donnee();
            d.setIdmodule(rs.getInt("idmodule"));
            d.setVoltagePanneau(rs.getDouble("voltagepanneau"));
            d.setVoltageOutPut(rs.getDouble("voltageoutput"));
            d.setVoltageBatterie(rs.getDouble("voltagebatterie"));
            d.setProduction(rs.getDouble("production"));
            d.setConsommation(rs.getDouble("consommation"));
            d.setTemps(rs.getTimestamp("temps"));
            d.setValeurBatterie(rs.getDouble("valeurbatterie"));
            liste.add(d);
        }
        connection.close();
        return liste;
    }

    public static Module getModuleById(int id) throws Exception{
        String sql = "select * from module where id="+id;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Module res = new Module();
        while(rs.next()){
            res.setId(rs.getInt("id"));
            res.setQrcode(rs.getString("qrcode"));
            res.setIdBatterie(rs.getInt("idbatterie"));
        }
        connection.close();
        return res;
    }

    public static void AttributionQrClient(String idclient) throws Exception{
        String sql = "update client set haveqr=true where id="+Integer.parseInt(idclient);
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }

    public static ArrayList<Module> getListModule() throws Exception{
        String sql = "select * from module";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Module> liste = new ArrayList<>();
        while(rs.next()){
            Module res = new Module();
            res.setId(rs.getInt("id"));
            res.setQrcode(rs.getString("qrcode"));
            res.setIdBatterie(rs.getInt("idbatterie"));
            liste.add(res);
        }
        connection.close();
        return liste;
    }

    public static Timestamp castToTimestamp(String dateString) {
        String dateFormatPattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);

        try {
            Date parsedDate = dateFormat.parse(dateString);
            return new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) throws Exception {
////        signUpClient("james@gmail.com","j","itonylien","jamesadresse","tana102");
////                ArrayList<TypeBatterie> liste = getListeCapaciteBatterie();
//        Client liste =getClientById(1);
////        for(int i=0; i<liste.size(); i++){
////            System.out.println(liste.get(i).getId());
////            System.out.println(liste.get(i).getValeur());
////        }
//        System.out.println(liste.getId());
//        System.out.println(liste.getEmail());
//    }
}
