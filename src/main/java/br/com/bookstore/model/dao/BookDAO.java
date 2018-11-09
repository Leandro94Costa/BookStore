package br.com.bookstore.model.dao;

import br.com.bookstore.model.entity.Book;
import br.com.bookstore.util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class BookDAO implements GenericDAO<Book, String> {

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
    public Book getById(String id) throws Exception {
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
            ids = entityManager.createQuery("select b.isbn from Book b join b.authors a where a.id = :authorId")
                    .setParameter("authorId", id)
                    .getResultList();
        } catch (Exception e) {
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
    public void delete(String id) throws Exception {
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

    public List<Book> findByISBN(String isbn) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Book> books;
        try {
            books = entityManager.createQuery("select b from Book b where b.isbn like :isbn")
                    .setParameter("isbn", isbn)
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
        return books;
    }

    public List<Book> findByTitle(String title) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Book> books;
        try {
            books = entityManager.createQuery("select b from Book b where b.title like :title")
                    .setParameter("title", "%" + title + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
        return books;
    }

    public List<Book> findByAuthor(String name) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Book> books;
        try {
            if (!name.contains(" ")) {
                books = entityManager.createQuery("select b from Book b inner join b.authors a " +
                        "where a.firstName like :name or a.name like :name")
                        .setParameter("name", "%" + name + "%")
                        .getResultList();
            } else {
                books = entityManager.createQuery("select b from Book b inner join b.authors a " +
                        "where concat(a.firstName, ' ', a.name) like :name")
                        .setParameter("name", "%" + name + "%")
                        .getResultList();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
        return books;
    }

    public List<Book> findByPublisher(String name) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Book> books;
        try {
            books = entityManager.createQuery("select b from Book b inner join b.publisher p where p.name like :name")
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
        return books;
    }
}
