package dotin.librarymanagement.identification.controller;

import dotin.librarymanagement.identification.model.Person;
import dotin.librarymanagement.identification.service.UserManagementService;
import dotin.librarymanagement.general.controller.GenericController;
import dotin.librarymanagement.general.model.ResponseObject;
import dotin.librarymanagement.viewmodel.PersonViewModel;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signUp")
public class UserManagement {

    private ModelMapper modelMapper = new ModelMapper();

    private Logger logger = LoggerFactory.getLogger(GenericController.class);

    private UserManagementService userManagementService;

    @Autowired
    public UserManagement (UserManagementService userManagementService){
        this.userManagementService = userManagementService;
    }

    @PostMapping("save")
    public ResponseObject save(@RequestBody PersonViewModel personViewModel){
        logger.info("start method save() - {}", (new Object[]{this.getClass().getSimpleName()}));

        Person model = modelMapper.map(personViewModel , Person.class);

        userManagementService.save(model);

        return new ResponseObject(false, "200", "success", null);
    }
}
