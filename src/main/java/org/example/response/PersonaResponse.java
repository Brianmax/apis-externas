package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonaResponse {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroDoc;
}
