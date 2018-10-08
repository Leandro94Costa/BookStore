package br.com.bookstore.domain.dao;

import br.com.bookstore.domain.entity.Author;
import br.com.bookstore.util.JpaUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorDAO implements GenericDAO<Author> {

    @Override
    public List<Author> getAll() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Author> authors;

        try {
            authors = entityManager.createQuery("select a from Author a", Author.class).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

        return authors;
    }

    @Override
    public Author getById(Integer id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Author author;

        try {
            author = entityManager.find(Author.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

        return author;
    }

    public List<Author> getAuthorsByBook(Long id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Author> authors;

        try {
            authors = entityManager.createQuery("select a from Book b inner join b.authors a where b.id = :bookId", Author.class)
                    .setParameter("bookId", id)
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

        return authors;
    }

    @Override
    public Long save(Author author) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Long id;

        try {
            //entityManager.getTransaction().begin();
            id = (Long) entityManager.unwrap(Session.class).save(author);
            //entityManager.getTransaction().commit();
        } catch (Exception e) {
            //entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

        return id;
    }

    @Override
    public void update(Author author) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(author);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            Author author = entityManager.find(Author.class, id);
            entityManager.remove(author);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
