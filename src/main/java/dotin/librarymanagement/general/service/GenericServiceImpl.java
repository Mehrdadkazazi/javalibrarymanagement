package dotin.librarymanagement.general.service;

import dotin.librarymanagement.general.reporitory.GenericDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class GenericServiceImpl<TModel, ID extends Serializable> implements GenericService<TModel, ID> {

    public GenericServiceImpl() {
    }

    public abstract GenericDao<TModel, ID> getRelatedDao();

    @Transactional
    public boolean save(TModel model) {

        this.getRelatedDao().save(model);
        return true;
    }

    @Transactional
    public boolean update(TModel model) {

        this.getRelatedDao().update(model);
        return true;
    }

    public boolean delete(TModel model) {
        this.getRelatedDao().delete(model);
        return true;
    }

    @Override
    public List<TModel> findAllObjects(Class<? extends TModel> model) {
        return this.getRelatedDao().findAllObjects(model);
    }

    @Override
    public List<TModel> findAll(TModel model) {
        return null;
    }

    public TModel findById(ID id) {
        return null;
    }
}
