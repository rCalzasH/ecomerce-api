package com.ecomerce.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.api.model.Rol;
import com.ecomerce.api.model.Usuario;
import com.ecomerce.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
    private final UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<Usuario> Resgister(@RequestParam String password,@RequestParam String name,@RequestParam String email){
        try { 
            usuarioService.valName(name);
            Usuario user = new Usuario(name,password,email);
            usuarioService.save(user);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    public ResponseEntity<Usuario> Login(@RequestParam String password,@RequestParam String email){
        
        Optional<Usuario> user=usuarioService.findByEmail(email);
        
        //  Comprobar si el user existe
        if(user.isEmpty()){return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}

        // Comprobar si la contraseña es correcta
        if(user.get().getPassword().equals(password)){return ResponseEntity.ok(user.get());/*login ok*/
        }else{return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();/*Fail login*/}
    }
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }
    public List<Usuario> getAll(){
        return usuarioService.findAll();
    }
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        return usuarioService.findById(id).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        usuarioService.deleteById(id);
    }

    @PatchMapping("/id")
    public ResponseEntity<Usuario> updateId(@RequestParam Long id,@RequestBody Usuario usuario){
        return usuarioService.updateId(id,usuario).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/email")
    public ResponseEntity<Usuario> updateEmail(@RequestParam String email,@RequestBody Usuario usuario){
        return usuarioService.updateEmail(email,usuario).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/Rol")
    public ResponseEntity<Usuario> updateRol(@RequestParam Rol rol,@RequestBody Usuario usuario){
        return usuarioService.updateRol(rol,usuario).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/pathPic")
    public ResponseEntity<Usuario> updatePic(@RequestParam String pathPic,@RequestBody Usuario usuario){
        return usuarioService.updatePic(pathPic,usuario).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Boolean> existsByEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.existsByEmail(email));
    }
}