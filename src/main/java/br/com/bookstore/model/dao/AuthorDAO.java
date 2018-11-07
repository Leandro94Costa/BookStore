package br.com.bookstore.model.dao;

import br.com.bookstore.model.entity.Author;
import br.com.bookstore.util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorDAO implements GenericDAO<Author, Integer> {

    @Override
    public List<Author> getAll() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Author> authors;
        try {
            authors = entityManager.createQuery("select a from Author a order by a.firstName", Author.class).getResultList();
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

    public boolean hasBooks(Integer id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        boolean result;
        result = (boolean) entityManager.createQuery("select case when (count(b.isbn) > 0) then true else false end " +
                "from Book b join b.authors a where a.id = :authorId")
                .setParameter("authorId", id)
                .getSingleResult();
        entityManager.close();
        return result;
    }

    @Override
    public void save(Author author) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(author);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
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

    public List<Author> findByName(String name) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Author> authors;
        try {
            if (!name.contains(" ")) {
                authors = entityManager.createQuery("select a from Author a where a.firstName like :name or a.name like :name")
                        .setParameter("name", "%" + name + "%")
                        .getResultList();
            } else {
                authors = entityManager.createQuery("select a from Author a where concat(a.firstName, ' ', a.name) like :name")
                        .setParameter("name", "%" + name + "%")
                        .getResultList();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
        return authors;
    }
}
