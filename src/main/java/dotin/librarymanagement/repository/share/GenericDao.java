package dotin.librarymanagement.repository.share;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenericDao<TModel, ID> {
    boolean save(TModel model);

    boolean update(TModel model);

    List<TModel> findAll(TModel model);

    TModel findById(ID id);

    boolean delete(TModel model);


}
