/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.web;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.gm.sga.servicio.PersonaService;
import java.io.IOException;
import java.util.List;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author tony
 */
@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    
    @Inject
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        List<Persona> personas = personaService.listarPersonas();
        System.out.println("Personas: " + personas);
        request.setAttribute("personas", personas); // aqui se envia la variable "personas" a archivo.jsp para ocuparlo en el forEach
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
}
