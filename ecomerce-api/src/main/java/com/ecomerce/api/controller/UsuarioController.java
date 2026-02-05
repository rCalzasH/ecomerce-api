package com.ecomerce.api.controller;

import com.ecomerce.api.service.UsuarioService;
import com.ecomerce.api.model.Rol;
import com.ecomerce.api.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController{
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getById(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @PostMapping
    public Optional<Usuario> save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        usuarioService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Optional<Usuario> updateId(@RequestParam Long id,@RequestBody Usuario usuario){
        return usuarioService.updateId(id,usuario);
    }

    @PatchMapping("/{email}")
    public Optional<Usuario> updateEmail(@RequestParam String email,@RequestBody Usuario usuario){
        return usuarioService.updateEmail(email,usuario);
    }

    @PatchMapping("/{Rol}")
    public Optional<Usuario> updateRol(@RequestParam Rol rol,@RequestBody Usuario usuario){
        return usuarioService.updateRol(rol,usuario);
    }

    @PatchMapping("/{id}")
    public Optional<Usuario> updatePic(@RequestParam String pathPic,@RequestBody Usuario usuario){
        return usuarioService.updatePic(pathPic,usuario);
    }

    public boolean existsByEmail(@RequestParam String email){
        return usuarioService.existsByEmail(email);
    }
}