package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
public class ControllerContactos {

    @Autowired
    AgendaService agendaService;

    @RequestMapping("/nombre")
    @ResponseBody
    public int obtenerNumeroContactos(){
        return agendaService.nombreContactes();
    }

    @RequestMapping(path="/telefon", method=RequestMethod.GET)
    @ResponseBody
    public String obtenerContactoId(String id){
        //recupera(id) devuelve un objeto persona, que tiene el método getTelefon, que devuelve un String
        return agendaService.recupera(id).getTelefon();
    }

    //produces no es necesario, pero lo he usado para practicarlo
    @RequestMapping(value = "/contacte/{id}",produces={MediaType.APPLICATION_JSON_UTF8_VALUE,
                                                        MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Persona obtenerContacto(@PathVariable String id){
          return  agendaService.recupera(id);
    }

    @RequestMapping("/afegir")
    @ResponseBody
    public void addContacto(String id, String nom, String telefon){
        agendaService.inserta(id, nom, telefon);
    }
}
