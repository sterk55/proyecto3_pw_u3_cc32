package com.uce.edu.pw.proyecto3_pw_u3_cc3.repository;
import org.springframework.stereotype.Repository;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements iProfesorRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertarProfesor(Profesor profesor) {
        // TODO Auto-generated method stub
        this.entityManager.persist(profesor);
    }

    @Override
    public void actualizarProfesor(Profesor estudainte) {
        // TODO Auto-generated method stub
        this.entityManager.merge(estudainte);
    }

    @Override
    public Profesor consultarProfesor(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Profesor.class, id);
    }

    @Override
    public void eliminarProfesor(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.consultarProfesor(id));        
    }
    @Override
    public Profesor consultaProfesorPorCedula(String cedula) {
        // TODO Auto-generated method stub
        TypedQuery<Profesor> myQuery = this.entityManager.createQuery("SELECT p FROM Profesor p WHERE p.cedula = :cedula", Profesor.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
    }

 
}
