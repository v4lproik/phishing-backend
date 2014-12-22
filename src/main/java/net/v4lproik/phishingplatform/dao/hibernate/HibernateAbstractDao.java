package net.v4lproik.phishingplatform.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by v4lproik on 21/12/14.
 * <p/>
 * This class basically aims to provide an abstract layer for database requests
 */
@Repository
public abstract class HibernateAbstractDao<E, I extends Serializable> {

    private final Class<E> klazz;
    @Autowired
    protected SessionFactory sessionFactory;

    public HibernateAbstractDao(final Class<E> klazz) {
        this.klazz = klazz;
        this.klazz.getName();
    }

    public List<E> list() {
        return currentSession().createCriteria(klazz).list();
    }

    public I save(E entity) {
        return (I) currentSession().save(entity);
    }

    public void update(E entity) {
        currentSession().update(entity);
    }

    public E getById(I id) {
        return (E) currentSession().get(klazz, id);
    }

    public List<E> getBySimpleCondition(String column, Object value) {
        Criteria c1 = currentSession().createCriteria(klazz);
        return c1.add(Restrictions.eq(column, value)).list();
    }

    public void delete(E entity) {
        currentSession().delete(entity);
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
}
