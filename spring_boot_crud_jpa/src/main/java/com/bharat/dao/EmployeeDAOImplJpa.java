package com.bharat.dao;

import com.bharat.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImplJpa implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImplJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query theQuery = entityManager.createQuery("from Employee");
        List<Employee> list = theQuery.getResultList();
        return list;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        return theEmployee;
    }

    @Override
    public void save(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void delete(int id) {
        Query theQuery = entityManager.createQuery("delete from Employee where id=:id");
        theQuery.setParameter("id", id);
        theQuery.executeUpdate();
    }
}
