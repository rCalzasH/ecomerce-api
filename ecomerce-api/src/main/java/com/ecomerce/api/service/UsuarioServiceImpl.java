package com.ecomerce.api.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ecomerce.api.model.Rol;
import com.ecomerce.api.model.Usuario;
@Service
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

    public Optional<Usuario> save(Usuario usuario){
        usuario.setId(idCont.getAndIncrement());
        usuarios.add(usuario);
        return usuarios.stream().filter(user -> user.equals(usuario)).findFirst();
    }

    public Optional<Usuario> updateId(Long id, Usuario usuario){
        Optional<Usuario> u= usuarios.stream().filter(user -> user.equals(usuario)).findFirst();
        u.get().setId(id);
        return u;
    }

    public Optional<Usuario> updateEmail(String email, Usuario usuario){
        Optional<Usuario> u= usuarios.stream().filter(user -> user.equals(usuario)).findFirst();
        u.get().setEmail(email);
        return u;
    }

    public Optional<Usuario> updateRol(Rol rol, Usuario usuario){
        Optional<Usuario> u= usuarios.stream().filter(user -> user.equals(usuario)).findFirst();
        u.get().setRol(rol);
        return u;
    }

    public Optional<Usuario> updatePic(String pathPic, Usuario usuario){
        Optional<Usuario> u= usuarios.stream().filter(user -> user.equals(usuario)).findFirst();
        u.get().setPathPic(pathPic);
        return u;  
    }

    public void deleteById(Long id){
        usuarios.remove(findById(id).get());
    }

    public boolean existsByEmail(String email){
        return usuarios.stream().filter(user -> user.getEmail().equals(email)).count() > 0;
    }
}
