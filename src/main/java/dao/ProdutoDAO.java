package dao;

import model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU");

    public void criar(Produto produto) {
        EntityManager em = emf.createEntityManager(); //produto
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }

    public Produto ler(Long id) { // comando para ler
        EntityManager em = emf.createEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        return produto;
    }

    public List<Produto> listarTodos() { // comando para listar todos
        EntityManager em = emf.createEntityManager();
        List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList();
        em.close();
        return produtos;
    }

    public void atualizar(Produto produto) { //atualizar com o commit 
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(Long id) { //excluir
        EntityManager em = emf.createEntityManager();
        Produto produto = em.find(Produto.class, id);
        if (produto != null) {
            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();
        }
        em.close();
    }
}