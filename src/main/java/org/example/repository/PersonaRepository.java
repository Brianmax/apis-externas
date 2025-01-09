package org.example.repository;

import org.example.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
    Optional<PersonaEntity> findByNumDoc(String dni);
    Optional<List<PersonaEntity>> findByEstado(Integer estado);
}
