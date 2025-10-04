package com.anduque.franquiciasapi.repository;

import com.anduque.franquiciasapi.model.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia,Long> {

}
