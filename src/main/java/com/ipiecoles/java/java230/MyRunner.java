package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EmployeRepository employerepository;
/*
    @Override
    public void run(String... strings) throws Exception {
        System.out.println(employerepository.count());
        Optional<Employe> e = employerepository.findById(5L);
        if (e.isPresent()) {
            Employe emp = e.get();
            System.out.println(emp);
            emp.setSalaire(2500d);
            employerepository.save(emp);
            System.out.println(emp);
        } else {
            System.out.println("Employé non trouvé");
        }
    }
    */

    @Override
    public void run(String... strings) throws Exception {
        /*
        PageRequest pageRequest = (PageRequest.of(0,10, Sort.Direction.ASC, "matricule"));
        Page<Employe> p = employerepository.findAll(pageRequest);
        for (Employe employe : p){
            System.out.println(employe);
        }
        */

        List<Employe> emps=employerepository.findByNomOrPrenomAllIgnoreCase("Adam");
        for (Employe e : emps){
            System.out.println(e);
        }
    }
}