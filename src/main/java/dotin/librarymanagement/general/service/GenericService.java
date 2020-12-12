package dotin.librarymanagement.general.service;

import java.util.List;

public interface GenericService<TModel, ID> {

    boolean save(TModel model);

    boolean update(TModel model);

    List<TModel> findAll(TModel model);

    TModel findById(ID id);

    boolean delete(TModel model);

    List<TModel> findAllObjects (Class<? extends TModel> model);
}
