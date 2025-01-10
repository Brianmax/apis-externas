package org.example.service;


import org.example.request.PersonaRequest;
import org.example.response.PersonaResponse;
import org.example.response.ReniecResponse;

import java.util.List;

public interface PersonaService {
    PersonaResponse crearPersona(PersonaRequest request);
    List<ReniecResponse> listarPersonas();
    ReniecResponse buscarPersonaDni(String dni);
    ReniecResponse actualizarPersona(Long id, PersonaRequest personaRequest);
    ReniecResponse eliminarPersona(String dni);
    ReniecResponse buscarDatosReniec(String dni);
    ReniecResponse buscarPrueba(int code) throws Exception;
    ReniecResponse buscarPrueba2(String dni);

}
