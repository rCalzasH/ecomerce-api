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
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        return usuarioService.findById(id).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        usuarioService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updateId(@RequestParam Long id,@RequestBody Usuario usuario){
        return usuarioService.updateId(id,usuario).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{email}")
    public ResponseEntity<Usuario> updateEmail(@RequestParam String email,@RequestBody Usuario usuario){
        return usuarioService.updateEmail(email,usuario).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{Rol}")
    public ResponseEntity<Usuario> updateRol(@RequestParam Rol rol,@RequestBody Usuario usuario){
        return usuarioService.updateRol(rol,usuario).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updatePic(@RequestParam String pathPic,@RequestBody Usuario usuario){
        return usuarioService.updatePic(pathPic,usuario).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Boolean> existsByEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.existsByEmail(email));
    }
}