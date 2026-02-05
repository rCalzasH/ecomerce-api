package com.ecomerce.api.service;
import java.util.List;
import java.util.Optional;

import com.ecomerce.api.model.Rol;
import com.ecomerce.api.model.Usuario;

public interface UsuarioService {
    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> save(Usuario usuario);

    Optional<Usuario> updateId(Long id, Usuario usuario);

    Optional<Usuario> updateEmail(String email, Usuario usuario);

    Optional<Usuario> updateRol(Rol rol, Usuario usuario);

    Optional<Usuario> updatePic(String pathPic,Usuario usuario);

    void deleteById(Long id);

    boolean existsByEmail(String email);
}
