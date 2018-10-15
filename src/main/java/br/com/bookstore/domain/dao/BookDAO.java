package br.com.bookstore.domain.dao;

import br.com.bookstore.domain.entity.Book;
import br.com.bookstore.util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class BookDAO implements GenericDAO<Book, Long> {

    @Override
    public List<Book> getAll() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Book> books;
        try {
            books = entityManager.createQuery("select b from Book b order by b.title", Book.class).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
        return books;
    }

    @Override
    public Book getById(Long id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Book book;
        try {
            book = entityManager.find(Book.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
        return book;
    }

    public List<Long> getIdsByAuthor(Integer id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Long> ids;
        try {
            entityManager.getTransaction().begin();
            ids = entityManager.createQuery("select b.isbn from Book b join b.authors a where a.id = :authorId")
                    .setParameter("authorId", id)
                    .getResultList();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
        return ids;
    }

    @Override
    public void save(Book book) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Book book) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Book book = entityManager.find(Book.class, id);
            entityManager.remove(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void deleteByPublisher(Integer id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete from Book b where b.publisher.id = :publisherId")
                    .setParameter("publisherId", id)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void deleteByAuthor(List<Long> ids) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete from Book b where b.isbn in :bookIds")
                    .setParameter("bookIds", ids)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
