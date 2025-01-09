package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.service.PersonaService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    @Override
    public PersonaResponse crearPersona(PersonaRequest request) {
        return null;
    }

    @Override
    public PersonaResponse listarPersonas() {
        return null;
    }

    @Override
    public PersonaResponse buscarPersonaDni(String dni) {
        return null;
    }

    @Override
    public PersonaResponse actualizarPersona(Long id, PersonaRequest personaRequest) {
        return null;
    }

    @Override
    public PersonaResponse eliminarPersona(String dni) {
        return null;
    }

    @Override
    public PersonaResponse buscarDatosReniec(String dni) {
        return null;
    }

    @Override
    public PersonaResponse buscarPrueba(int code) throws Exception {
        return null;
    }

    @Override
    public PersonaResponse buscarPrueba2(String dni) {
        return null;
    }
}
