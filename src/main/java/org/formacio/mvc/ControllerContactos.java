package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
