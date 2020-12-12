package dotin.librarymanagement.general.reporitory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public abstract class GenericDaoImpl<TModel, ID> implements GenericDao<TModel, ID> {
    @PersistenceContext
    EntityManager entityManager;
    private Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);

    public boolean save(TModel model) {
        logger.info("start save query() - {} :", (new Object[]{this.getClass().getSimpleName()}));

        entityManager.merge(model);

        logger.info("end save query method() - {}", (new Object[]{this.getClass().getSimpleName()}));

        return true;
    }

    public boolean update(TModel model) {
        logger.info("start update query() - {} :", (new Object[]{this.getClass().getSimpleName()}));

        entityManager.merge(model);

        logger.info("end update query method() - {}", (new Object[]{this.getClass().getSimpleName()}));

        return true;
    }

    public boolean delete(TModel model) {
        logger.info("start delete query() - {} :", (new Object[]{this.getClass().getSimpleName()}));

        entityManager.remove(model);

        return true;
    }

    @Override
    public List<TModel> findAll(TModel model) {
        return null;
    }

    public List<TModel> findAllObjects(Class<? extends TModel> model) {
        logger.info("start delete query() - {} :", (new Object[]{this.getClass().getSimpleName()}));

        Query query= entityManager.createQuery("select entity from" + model.getAnnotation(Entity.class).name() + "entity");
        return query.getResultList();
    }

    public TModel findById(ID id) {
        return null;
    }
}
