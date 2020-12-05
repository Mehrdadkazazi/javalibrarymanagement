package dotin.librarymanagement.configuration;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.NativeDebug.map;

@Component
public class GenericConfig<T, D> {

    private Logger logger = LoggerFactory.getLogger(GenericConfig.class);

    public D viewToModel(T viewModel, D model) {

        logger.info("start method mapper viewToModel() - {} : " + viewModel.getClass().getSimpleName());

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(viewModel, (Type) model.getClass());
    }

    public T modelToView (D model , T viewModel){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(model , (Type) viewModel.getClass());
    }

    public List<Object> modelToView (List<D> modelList , Class<D> model){
        return modelList.stream().map(viewModel -> map(viewModel , model)).collect(Collectors.toList());
    }

//    public List<D> viewToModel(List<T> viewModelList , D model){
////        return viewModelList.stream().map(this :: viewToModel).collect(Collectors.toList());
////    }
}
