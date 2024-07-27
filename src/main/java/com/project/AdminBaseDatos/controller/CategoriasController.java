package com.project.AdminBaseDatos.controller;

import Modelo.Categoria;
import Modelo.CategoriaDAO;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Categorias")
public class CategoriasController {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @GetMapping
    public String categorias(HttpServletRequest request) {
        List<Categoria> datos = categoriaDAO.mostrar();
        request.setAttribute("datos", datos);
        return "Categorias";
    }
}