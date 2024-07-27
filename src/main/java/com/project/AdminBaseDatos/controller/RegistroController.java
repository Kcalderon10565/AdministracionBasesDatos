/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.AdminBaseDatos.controller;

import Modelo.Usuario;
import com.project.AdminBaseDatos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kenca
 */

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("Registro")
    public String mostrarRegistro() {
        return "Registro";
    }

    @PostMapping("/registrar")
    public ModelAndView registrarUsuario(@RequestParam("nombre") String nombre,
                                         @RequestParam("apellido") String apellido,
                                         @RequestParam("email") String email,
                                         @RequestParam("contrasena") String contrasena) {
        System.out.println("Nombre: " + nombre);
    System.out.println("Apellido: " + apellido);
    System.out.println("Email: " + email);
    System.out.println("Contraseña: " + contrasena);
        
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setContrasena(contrasena); 

        usuarioService.guardarUsuario(nuevoUsuario);
        
        return new ModelAndView("redirect:/Home");
    }
}
