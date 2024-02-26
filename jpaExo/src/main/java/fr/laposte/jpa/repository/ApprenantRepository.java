package fr.laposte.jpa.repository;


import org.springframework.data.repository.CrudRepository;

import fr.laposte.jpa.model.Apprenant;

public interface ApprenantRepository extends CrudRepository<Apprenant, Long> {

}
