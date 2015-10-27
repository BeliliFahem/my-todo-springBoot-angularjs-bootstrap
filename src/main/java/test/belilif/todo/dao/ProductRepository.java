package test.belilif.todo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import test.belilif.todo.entities.Todo;

/**
 * Pas besoins d'implémenter et définir les methodes de bases CRUD, elles sont
 * définit (par héritage/généricité)
 * 
 * @author ajee
 *
 */

public interface ProductRepository extends JpaRepository<Todo, Long> {

	/**
	 * Cette méthode sera automatiquement inmplémenté car on a bien spécifier
	 * l'appelaltion : find By Labl. Label : c'est exactement le nom de d'un
	 * attribut de la classe Product. Le tour est joué, merci SPRING :).
	 * 
	 * resultats : list des produits qui ont le label EGALE au lbel donné en
	 * paramètre
	 */
	public List<Todo> findByTitle(String label);

	public Page<Todo> findByTitle(String label, Pageable pageable);

	/**
	 * Recup par mots clés (sql:like)
	 */
	@Query("select t from Todo t where t.title like :x")
	public Page<Todo> findByKeyWord(@Param("x") String titleKeyWord, Pageable pageable);
}
