package com.epam.homework.dao;

import com.epam.homework.entity.SubType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public class SubTypeDaoImpl implements SubTypeDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public SubTypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public SubType create(SubType subType) {
        Session session = sessionFactory.getCurrentSession();
        session.save(subType);
        return subType;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<SubType> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from SubType").list();
    }

    @Override
    @Transactional
    public List<SubType> getByIds(List<Integer> ids) {
        Session session = sessionFactory.getCurrentSession();
        return session.byMultipleIds(SubType.class).multiLoad(ids);
    }

    @Override
    @Transactional
    public SubType get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        SubType subType = session.get(SubType.class, id);
        return Objects.requireNonNull(subType, "SubType not found by id: "+id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        SubType subType = get(id);
        sessionFactory.getCurrentSession().delete(subType);
    }
}
