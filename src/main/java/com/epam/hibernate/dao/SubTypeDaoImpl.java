package com.epam.hibernate.dao;

import com.epam.hibernate.entity.SubType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class SubTypeDaoImpl implements SubTypeDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public SubTypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SubType create(SubType subType) {
        Session session = sessionFactory.getCurrentSession();
        session.save(subType);
        return subType;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SubType> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from SubType").list();
    }

    @Override
    public List<SubType> getByIds(List<UUID> ids) {
        Session session = sessionFactory.getCurrentSession();
        return session.byMultipleIds(SubType.class).multiLoad(ids);
    }

    @Override
    public SubType get(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        SubType subType = session.get(SubType.class, id);
        return Objects.requireNonNull(subType, "SubType not found by id: " + id);
    }

    @Override
    public void delete(UUID id) {
        SubType subType = get(id);
        sessionFactory.getCurrentSession().delete(subType);
    }
}
