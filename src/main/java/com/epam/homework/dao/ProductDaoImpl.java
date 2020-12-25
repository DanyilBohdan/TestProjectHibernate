package com.epam.homework.dao;

import com.epam.homework.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class ProductDaoImpl implements ProductDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product create(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        return product;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product").list();
    }

    @Override
    public List<Product> getByIds(List<UUID> ids) {
        Session session = sessionFactory.getCurrentSession();
        return session.byMultipleIds(Product.class).multiLoad(ids);
    }

    @Override
    public Product get(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        return Objects.requireNonNull(product, "Product not found by id: " + id);
    }

    @Override
    public void delete(UUID id) {
        Product product = get(id);
        sessionFactory.getCurrentSession().delete(product);
    }
}
