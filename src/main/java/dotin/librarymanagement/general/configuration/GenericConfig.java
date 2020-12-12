package dotin.librarymanagement.general.configuration;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.NativeDebug.map;

@Component
public class GenericConfig<TViewModel, TModel> {

    private Logger logger = LoggerFactory.getLogger(GenericConfig.class);

    public TModel viewToModel(TViewModel viewModel, TModel model) {

        logger.info("start method mapper viewToModel() - {} : " + viewModel.getClass().getSimpleName());

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(viewModel, (Type) model.getClass());
    }

    public TViewModel modelToView(TModel model, TViewModel viewModel) {

        logger.info("start method mapper viewToModel() - {} : " + viewModel.getClass().getSimpleName());

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(model, (Type) viewModel.getClass());
    }

    public List<Object> modelToView(List<TViewModel> modelList, Class<TViewModel> model) {

        logger.info("start method mapper viewToModel() - {} : " + modelList.getClass().getSimpleName());

        return modelList.stream().map(viewModel -> map(viewModel, model)).collect(Collectors.toList());
    }
}
