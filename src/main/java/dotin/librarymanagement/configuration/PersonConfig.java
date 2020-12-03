package dotin.librarymanagement.configuration;

import dotin.librarymanagement.model.Person;
import dotin.librarymanagement.viewmodel.PersonViewModel;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PersonConfig {
    public PropertyMap<PersonViewModel , Person> personViewToModelMap = new PropertyMap<PersonViewModel , Person>(){
        protected void configure(){
            map().setId(source.getId());
            map().setCardId(source.getCardId());
            map().setName(source.getName());
            map().setFamily(source.getFamily());
            map().setBirthDate(source.getBirthDate());
            map().setRole(source.getRole());
            map().setAddress(source.getAddress());
            map().setNationalCode(source.getNationalCode());
            map().setActivation(source.getActivation());
        }
    };

    public PropertyMap<Person , PersonViewModel> personModelToViewMap = new PropertyMap<Person , PersonViewModel>(){
        protected void configure() {
            map().setCardId(source.getCardId());
            map().setName(source.getName());
            map().setFamily(source.getFamily());
            map().setBirthDate(source.getBirthDate());
            map().setAddress(source.getAddress());
            map().setNationalCode(source.getNationalCode());
            map().setActivation(source.getActivation());
        }
    };
}
