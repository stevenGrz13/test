package com.example.demo5.solar;

import com.example.demo5.solar.entities.Client;
import com.example.demo5.solar.entities.Donnee;
import com.example.demo5.solar.entities.UsefulEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/solar")
@CrossOrigin("*")
public class SolarController {

    @GetMapping("clientbyid/{id}")
    public Client ClientByIdSolar(@PathVariable("id") int id) throws Exception{
        return Fonction.getClientById(id);
    }

    @GetMapping("listeclient")
    public ArrayList<Client> listeClientSolar() throws Exception{
        return Fonction.getListClient();
    }

    @GetMapping("loginclient/{email}/{pass}")
    public UsefulEntity loginClientSolar(@PathVariable("email") String email, @PathVariable("pass")String pass) throws Exception{
        return Fonction.loginClient(email,pass);
    }

    @GetMapping("insertclient/{email}/{pass}/{lienimage}")
    public void insertClientSolar(@PathVariable("email") String email, @PathVariable("pass")String pass, @PathVariable("lienimage")String lienimage, @PathVariable("adresse")String adresse, @PathVariable("codepostal")String codepostal) throws Exception{
        Fonction.signUpClient(email,pass,lienimage,adresse,codepostal);
    }

    @GetMapping("insertdonnee/{idmodule}/{voltagepanneau}/{voltageoutput}/{voltagebatterie}/{consommation}/{production}")
    public void insertDonnee(@PathVariable("idmodule") String idmodule, @PathVariable("voltagepanneau")String voltagepanneau, @PathVariable("voltageoutput")String voltageoutput, @PathVariable("voltagebatterie")String voltagebatterie, @PathVariable("consommation") String consommation, @PathVariable("production") String production) throws Exception{
        Fonction.insertDonnee(idmodule,voltagepanneau,voltageoutput,voltagebatterie,consommation,production);
    }

    @GetMapping("listedonnees")
    public ArrayList<Donnee> listedonnee() throws Exception {
        return Fonction.getListDonnee();
    }

    @GetMapping("listedonneesspec/{t1}/{t2}")
    public ArrayList<Donnee> listedonneesspec(@PathVariable("t1") String t1, @PathVariable("t2") String t2) throws Exception {
        return Fonction.getListDonneeSpecifique(t1,t2);
    }

    @GetMapping("attributionqrclient/{idclient}")
    public void AttributionQrClient(@PathVariable("idclient") String idclient) throws Exception {
        Fonction.AttributionQrClient(idclient);
    }
}