package dotin.librarymanagement.configuration;

import dotin.librarymanagement.model.Person;
import dotin.librarymanagement.viewmodel.PersonViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonConfig {

    public PersonViewModel modelToView(Person person) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(person, PersonViewModel.class);
    }

    public List<PersonViewModel> modelToView(List<Person> personList) {
        return personList.stream().map(this::modelToView).collect(Collectors.toList());
    }

    public Person viewToModel(PersonViewModel personViewModel) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(personViewModel, Person.class);
    }

    public List<Person> viewToModel(List<PersonViewModel> personViewModelList) {
        return personViewModelList.stream().map(this::viewToModel).collect(Collectors.toList());
    }
}
