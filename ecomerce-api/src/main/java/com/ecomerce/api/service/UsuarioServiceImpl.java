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
        return usuarios.stream().filter(user -> user.equals(usuario)).findFirst().get().setId(id);    
    }

    public Usuario updateEmail(String email, Usuario usuario){
        return usuarios.stream().filter(user -> user.equals(usuario)).findFirst().get().setEmail(email);
    }

    public Usuario updateRol(Rol rol, Usuario usuario){
        return usuarios.stream().filter(user -> user.equals(usuario)).findFirst().get().setRol(rol); 
    }

    public Usuario updatePic(String pathPic, Usuario usuario){
       return usuarios.stream().filter(user -> user.equals(usuario) ).findFirst().get().setPathPic(pathPic);
    }

    public void deleteById(Long id){
        usuarios.remove(findById(id).get());
    }

    public boolean existsByEmail(String email){
        return usuarios.stream().filter(user -> user.getEmail().equals(email)).count() > 0;
    }
}
