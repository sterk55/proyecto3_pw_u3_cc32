package com.uce.edu.pw.proyecto3_pw_u3_cc3.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteRepositoryImpl implements iEstudianteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.entityManager.merge(estudiante);

    }

    @Override
    public Estudiante buscar(Integer id) {
        // TODO Auto-generated method stub

        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.buscar(id));

    }

}
