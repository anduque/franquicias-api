package com.anduque.franquiciasapi.service;

import com.anduque.franquiciasapi.dto.FranquiciaRequestDTO;
import com.anduque.franquiciasapi.model.Franquicia;
import com.anduque.franquiciasapi.repository.FranquiciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    public FranquiciaService(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    //Obtener franquicias
    public List<Franquicia> findAll() {
        return franquiciaRepository.findAll();
    }

    //Buscar franquicia por ID
    public Optional<Franquicia> findById(Long id) {
        return franquiciaRepository.findById(id);
    }

    //Eliminar franquicia
    public void deleteById(Long id) {
        franquiciaRepository.deleteById(id);
    }
}
