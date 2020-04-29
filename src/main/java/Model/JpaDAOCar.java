package Model;

import Model.Exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * DAO level for requests to Car entity
 */
public class JpaDAOCar extends JpaDAO implements DAOCar {
    static final Logger logger = LogManager.getLogger("dao");

//    @PersistenceContext(unitName="CarRental")
//    private EntityManager entityManager;

    /**
     * Returns amount of cars of given model
     * @param carModel - model of the car
     * @return amount
     */
    public int getAmountByCarModel(String carModel) throws DAOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String ansStr = "";
        int ans = 0;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> q = cb.createQuery(Long.class);
        Root<Car> c = q.from(Car.class);

        ParameterExpression<Boolean> pState = cb.parameter(Boolean.class);
        ParameterExpression<String> pModel = cb.parameter(String.class);
        q.select(cb.count(c)).where(cb.equal(c.get("carState"), pState), (cb.equal(c.get("carModel"), pModel)));
        TypedQuery<Long> query = entityManager.createQuery(q);
        query.setParameter(pState, true).setParameter(pModel, carModel);
        ansStr = query.getSingleResult().toString();
        ans = Integer.parseInt(ansStr);

        logger.info("Returned amount by carModel successfully.");
        entityManager.close();
        return ans;
    }

    /**
     * Returns car's state by id
     * @param carId = id of given car
     * @return state
     */
    public boolean getCarStateByCarId(int carId) throws DAOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        boolean ans = false;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> q = cb.createQuery(Car.class);
        Root<Car> c = q.from(Car.class);
        ParameterExpression<Integer> pId = cb.parameter(Integer.class);
        q.select(c).where(cb.equal(c.get("carId"), pId));
        TypedQuery<Car> query = entityManager.createQuery(q);
        query.setParameter(pId, carId);
        Car car = query.getSingleResult();

        ans = car.isCarState();

        logger.info("Returned carState by carId successfully.");
        entityManager.close();
        return ans;
    }

    /**
     * Returns car object by car's state and model
     * @param carState - given state
     * @param carModel - given model
     * @return car objects
     */
    public List<Car> getCarByCarStateAndModel(boolean carState, String carModel) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> q = cb.createQuery(Car.class);
        Root<Car> c = q.from(Car.class);
        ParameterExpression<Boolean> pState = cb.parameter(Boolean.class);
        ParameterExpression<String> pModel = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("carState"), pState), (cb.equal(c.get("carModel"), pModel)));
        TypedQuery<Car> query = entityManager.createQuery(q);
        query.setParameter(pState, carState).setParameter(pModel, carModel);
        List<Car> cars = query.getResultList();

        logger.info("Returned car by carState and carModel successfully.");
        entityManager.close();
        return cars;
    }

    /**
     * Updates car's availability
     * @param carId - id
     */
    public void getCarByIdUpdate(int carId, boolean state) throws DAOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> q = cb.createQuery(Car.class);
        Root<Car> c = q.from(Car.class);
        ParameterExpression<Integer> pId = cb.parameter(Integer.class);
        q.select(c).where(cb.equal(c.get("carId"), pId));
        TypedQuery<Car> query = entityManager.createQuery(q);
        query.setParameter(pId, carId);
        Car car = query.getSingleResult();

        entityManager.getTransaction().begin();
        car.setCarState(state);

        try {
            entityManager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new DAOException("getCarByIdUpdate exception " + e.getMessage());
        } catch (IllegalStateException e)
        {
            throw new DAOException("getCarByIdUpdate exception " + e.getMessage());
        }

        //System.out.println("Car state updated successfully.");
        logger.info("Car state updated successfully.");
        entityManager.close();
    }

    /**
     * Returns list of cars
     * @return list of cars
     */
    public List<Car> getAllCars() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> q = cb.createQuery(Car.class);
        Root<Car> c = q.from(Car.class);
        q.select(c);
        TypedQuery<Car> query = entityManager.createQuery(q);
        List<Car> cars = query.getResultList();

        logger.info("Returned all cars successfully.");
        entityManager.close();
        return cars;
    }

}
