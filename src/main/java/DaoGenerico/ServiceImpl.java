/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoGenerico;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author fabian.giraldo
 */
public class ServiceImpl<T> implements Service<T> {

    protected EntityManager entityManager;
    protected Class type;
    protected String entity;

    public ServiceImpl(Class<T> entityClass) {
        this.type = entityClass;
    }

    public T busacarObj(Object id) {
        return (T) entityManager.find(type, id);
    }

    public void eliminarObje(T object) {
        entityManager.remove(object);
        entityManager.getTransaction().commit();
    }

    public List<T> buscarTodoObj() {
        Query query
                = entityManager.createQuery("select x from "
                        + getEntityName() + " x");

        return (List<T>) query.getResultList();
    }

    public void crearObj(T object) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.persist(object);
        try {
            entityManager.flush();

        } catch (PersistenceException exception) {
            throw new RuntimeException(exception);
        }

        entityManager.getTransaction().commit();

    }

    public T actualizarObj(T object) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        T t = entityManager.merge(object);

        try {
            entityManager.flush();

        } catch (PersistenceException exception) {
            throw new RuntimeException(exception);
        }

        entityManager.getTransaction().commit();

        return t;
    }

    ////////////
    /// Crea una consulta especifica
    public List<T> findByProperty(String prop, Object val) {
        Query query
                = entityManager.createQuery("select x from "
                        + getEntityName()
                        + " x where x." + prop + " = ?1");
        query.setParameter(1, val);
        return (List<T>) query.getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getEntityName() {
        if (entity == null) {
            Entity entityAnn = (Entity) type.getAnnotation(Entity.class);
            if (entityAnn != null && !entityAnn.name().equals("")) {
                entity = entityAnn.name();
            } else {
                entity = type.getSimpleName();
            }
        }
        return entity;
    }

}
