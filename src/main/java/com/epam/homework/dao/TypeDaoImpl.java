package com.epam.homework.dao;

import com.epam.homework.entity.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class TypeDaoImpl implements TypeDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public TypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Type create(Type type) {
        Session session = sessionFactory.getCurrentSession();
        session.save(type);
        return type;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Type> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Type").list();
    }

    @Override
    public List<Type> getByIds(List<UUID> ids) {
        Session session = sessionFactory.getCurrentSession();
        return session.byMultipleIds(Type.class).multiLoad(ids);
    }

    @Override
    public Type get(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        Type type = session.get(Type.class, id);
        return Objects.requireNonNull(type);
    }

    @Override
    public void delete(UUID id) {
        Type type = get(id);
        sessionFactory.getCurrentSession().delete(type);
    }
}
