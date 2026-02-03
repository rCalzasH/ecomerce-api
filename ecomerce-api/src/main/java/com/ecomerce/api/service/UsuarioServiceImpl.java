package com.ecomerce.api.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.ecomerce.api.model.Rol;
import com.ecomerce.api.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();
    private AtomicLong idCont = new AtomicLong(1);

    public List<Usuario> findAll(){
        return usuarios;
    }

    public Optional<Usuario> findById(Long id){
        return usuarios.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public Optional<Usuario> findByEmail(String email){
        return usuarios.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public Usuario save(Usuario usuario){
        usuario.setId(idCont.getAndIncrement());
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario updateId(Long id, Usuario usuario){
        Usuario u=usuarios.stream().filter(user -> user.equals(usuario)).findFirst().get();
        u.setId(id);
        return u;
         
    }

    public Usuario updateEmail(String email, Usuario usuario){
        Usuario u=usuarios.stream().filter(user -> user.equals(usuario)).findFirst().get();
        u.setEmail(email);
        return u;
    }

    public Usuario updateRol(Rol rol, Usuario usuario){
        Usuario u=usuarios.stream().filter(user -> user.equals(usuario)).findFirst().get();
        u.setRol(rol);
        return u;    
    }

    public Usuario updatePic(String pathPic, Usuario usuario){
        Usuario u=usuarios.stream().filter(user -> user.equals(usuario) ).findFirst().get();
        u.setPathPic(pathPic);
        return u;    
    }

    public void deleteById(Long id){
        usuarios.remove(findById(id).get());
    }

    public boolean existsByEmail(String email){
        return usuarios.stream().filter(user -> user.getEmail().equals(email)).count() > 0;
    }
}
