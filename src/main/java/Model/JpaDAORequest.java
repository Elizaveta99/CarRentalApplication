package Model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * DAO level for requests to Request entity
 */
public class JpaDAORequest extends JpaDAO implements DAORequest {
    static final Logger logger = LogManager.getLogger("dao");

//    @PersistenceContext(unitName="CarRental")
//    private EntityManager entityManager;

    /**
     * Returns all requests by given model
     * @param model
     * @return all requests by model
     */
    public List<Request> getAllRequestsByModel(String model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Request> q = cb.createQuery(Request.class);
        Root<Request> c = q.from(Request.class);
        ParameterExpression<String> pModel = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("model"), pModel));
        TypedQuery<Request> query = entityManager.createQuery(q);
        query.setParameter(pModel, model);
        List<Request> requests = query.getResultList();

        logger.info("Returned all requests by model successfully.");
        entityManager.close();
        return requests;
    }

    /**
     * Returns all requests
     * @return list of requests
     */
    public List<Request> getAllRequests() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Request> q = cb.createQuery(Request.class);
        Root<Request> c = q.from(Request.class);
        q.select(c);
        TypedQuery<Request> query = entityManager.createQuery(q);
        List<Request> requests = query.getResultList();

        logger.info("Returned all requests successfully.");
        entityManager.close();
        return requests;
    }
}
