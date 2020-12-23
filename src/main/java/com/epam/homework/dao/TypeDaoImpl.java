package com.epam.homework.dao;

import com.epam.homework.entity.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public class TypeDaoImpl implements TypeDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public TypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Type create(Type type) {
        Session session = sessionFactory.getCurrentSession();
        session.save(type);
        return type;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Type> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Type").list();
    }

    @Override
    @Transactional
    public List<Type> getByIds(List<Integer> ids) {
        Session session = sessionFactory.getCurrentSession();
        return session.byMultipleIds(Type.class).multiLoad(ids);
    }

    @Override
    @Transactional
    public Type get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Type type = session.get(Type.class, id);
        return Objects.requireNonNull(type);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Type type = get(id);
        sessionFactory.getCurrentSession().delete(type);
    }
}
