package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.request.PersonaRequest;
import org.example.response.PersonaResponse;
import org.example.service.PersonaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;
    @PostMapping("/crear")
    public PersonaResponse crearPersona(@RequestBody PersonaRequest personaRequest) {
        return personaService.crearPersona(personaRequest);
    }
}
