package dotin.librarymanagement.general.controller;

import dotin.librarymanagement.general.model.ResponseObject;
import dotin.librarymanagement.general.service.GenericService;
import dotin.librarymanagement.general.service.GenericServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public abstract class GenericController<TViewModel, TModel, ID extends Serializable> {
    private Logger logger = LoggerFactory.getLogger(GenericController.class);

    @Autowired
    private GenericServiceImpl<TModel, ID> genericServiceImpl;
    private ModelMapper modelMapper = new ModelMapper();

    protected abstract GenericService<TModel, ID> getRelatedService();

    protected abstract Class<TViewModel> getViewModelClass();

    protected abstract Class<TModel> getModelClass();

    protected Class<TViewModel> viewModeClass = this.getViewModelClass();
    protected Class<TModel> modelClass = this.getModelClass();

    public GenericController() {
        //modelMapper.getConfiguration().setImplicitMappingEnabled(false);
    }

    @PostMapping("/save")
    public ResponseObject save(@RequestBody TViewModel viewModel) {
        logger.info("start method save() - {}", (new Object[]{this.getClass().getSimpleName()}));

        TModel model = modelMapper.map(viewModel, this.modelClass);
        this.getRelatedService().save(model);

        return new ResponseObject(false, "200", "success", null);
    }

    @PostMapping("/update")
    public ResponseObject update(@RequestBody TViewModel viewModel) {
        logger.info("start method findAll() - {}", (new Object[]{this.getClass().getSimpleName()}));

        TModel model = modelMapper.map(viewModel, this.modelClass);
        this.getRelatedService().update(model);

        return new ResponseObject(false, "200", "success", null);
    }

    @PostMapping("/delete")
    public ResponseObject delete(@RequestBody TViewModel viewModel) {
        logger.info("start method delete() - {}", (new Object[]{this.getClass().getSimpleName()}));

        TModel model = modelMapper.map(viewModel, this.modelClass);

        genericServiceImpl.delete(model);

        return new ResponseObject(false, "200", "success", null);
    }

    @PostMapping("/findAll")
    public ResponseObject findAll(@RequestBody TViewModel viewModel) {
        logger.info("start method findAll() - {}", (new Object[]{this.getClass().getSimpleName()}));

        TModel model = modelMapper.map(viewModel, this.modelClass);

        List modelList = this.getRelatedService().findAll(model);

        TViewModel responseViewModel = modelMapper.map(modelList.size() > 0 ? modelList.get(0) : 0, (Type) this.modelClass);

        return new ResponseObject(false, "200", "success", Collections.singletonList(responseViewModel));
    }

    @GetMapping("/findById/{ID}")
    public ResponseObject findById(@PathVariable(value = "ID") Long id) {
        logger.info("start method findById() - {}", (new Object[]{this.getClass().getSimpleName()}));

        TModel model = genericServiceImpl.findById((ID) id);

        TViewModel viewModel = modelMapper.map(model, this.viewModeClass);

        return new ResponseObject(false, "200", "success", (List<?>) viewModel);
    }

}
