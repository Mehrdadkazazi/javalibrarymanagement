package dotin.librarymanagement.service.exceptionhandler;

import dotin.librarymanagement.model.ExceptionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionConfig {
    private Logger logger = LoggerFactory.getLogger(ExceptionConfig.class);

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionModel> generateException(RuntimeException re) {

        ExceptionModel exceptionModel = new ExceptionModel(new Date().toString(), "500", re.getMessage());

        logger.error("exception occurred : " + re);

        return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
