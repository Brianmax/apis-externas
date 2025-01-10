package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.PersonaEntity;
import org.example.ofeign.ReniecClient;
import org.example.repository.PersonaRepository;
import org.example.request.PersonaRequest;
import org.example.response.PersonaResponse;
import org.example.response.ReniecResponse;
import org.example.retrofit.ReniecRetrofitImpl;
import org.example.retrofit.ReniecService;
import org.example.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {
    
    private final ReniecClient reniecClient;
    // retrofit
    private final ReniecService reniecService = ReniecRetrofitImpl.getClient().create(ReniecService.class);
    @Value("${token.api}")
    private String token;
    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public PersonaResponse crearPersona(PersonaRequest request) { 
        PersonaEntity personaEntity = getEntity(request);
        if (Objects.nonNull(personaEntity)) {
            personaRepository.save(personaEntity);
            return new PersonaResponse(
                    personaEntity.getNombres(),
                    personaEntity.getApellidos().split(" ")[0],
                    personaEntity.getApellidos().split(" ")[1],
                    personaEntity.getNumDoc()
            );
        }
        return null;
    }

    @Override
    public List<ReniecResponse> listarPersonas() {
        return List.of();
    }

    @Override
    public ReniecResponse buscarPersonaDni(String dni) {
        return null;
    }

    @Override
    public ReniecResponse actualizarPersona(Long id, PersonaRequest personaRequest) {
        return null;
    }

    @Override
    public ReniecResponse eliminarPersona(String dni) {
        return null;
    }

    @Override
    public ReniecResponse buscarDatosReniec(String dni) {
        return null;
    }

    @Override
    public ReniecResponse buscarPrueba(int code) throws Exception {
        return null;
    }

    @Override
    public ReniecResponse buscarPrueba2(String dni) {
        return null;
    }
    
    private PersonaEntity getEntity(PersonaRequest personaRequest) {
        ReniecResponse response = reniecClient.getPersonaReniec(personaRequest.getDni(), "Bearer " + token);
        PersonaEntity personaEntity = new PersonaEntity();
        if (response != null) {
            personaEntity.setNombres(response.getNombres());
            personaEntity.setApellidos(response.getApellidoPaterno() + " " + response.getApellidoMaterno());
            personaEntity.setNumDoc(response.getNumeroDocumento());
            personaEntity.setTipoDoc(response.getTipoDocumento());
            personaEntity.setUsua_crea("GEORGE");
            personaEntity.setDate_crea(new Timestamp(System.currentTimeMillis()));
            return personaEntity;
        }
        return null;
    }
    
    private PersonaEntity getEntityRetrofit(PersonaRequest personaRequest) throws Exception{
        Call<ReniecResponse> callReniec = reniecService.getPersonaReniec(
                "Bearer " + token,
                personaRequest.getDni());

        Response<ReniecResponse> execute = callReniec.execute();
        
        if (execute.isSuccessful() && Objects.nonNull(execute.body())) {
            ReniecResponse response = execute.body();
            PersonaEntity personaEntity = new PersonaEntity();
            personaEntity.setNombres(response.getNombres());
            
            
            
            return personaEntity;
        }
        return null;
    }
}
