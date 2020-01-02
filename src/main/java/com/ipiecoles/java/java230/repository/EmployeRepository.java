package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeRepository extends PagingAndSortingRepository<Employe,Long> {

    Employe findByMatricule (String matricule);

    List<Employe> findByNomAndPrenom (String nom, String prenom);

    List<Employe> findByNomIgnoreCase (String nom);
    Page<Employe> findByNomIgnoreCase (String nom, Pageable pageable);

    List<Employe> findByDateEmbaucheAfter (LocalDate date);

    List<Employe> findByDateEmbaucheBefore (LocalDate date);

    //Gagnant + de X euros par salaire décroissant
    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc (Double salaire);

    @Query("from Employe e where(e.nom) = lower(:nomOuPrenom) or lower(e.prenom)=lower(:nomOuPrenom)")
    List<Employe> findByNomOrPrenomAllIgnoreCase (@Param("nomOuPrenom") String nomOrPrenom);

}


