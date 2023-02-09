package com.uce.edu.pw.proyecto3_pw_u3_cc3.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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

    @Override
    public List<Estudiante> buscarTodos() {
        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return myQuery.getResultList();
    }

    @Override
    public Estudiante buscarSalario(BigDecimal salario) {
        TypedQuery<Estudiante> myQuery = this.entityManager
                .createQuery("SELECT e FROM Estudiante e WHERE e.salario <= :salario", Estudiante.class);
        myQuery.setParameter("salario", salario);
        return myQuery.getSingleResult();
    }

}
