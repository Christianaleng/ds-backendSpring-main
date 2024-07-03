package gr.hua.dit.dsproject.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
//@ControllerAdvice
//class ResourceNotFound {
//
//    @ResponseBody
//    @ExceptionHandler(ResourceNotFound.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    String employeeNotFoundHandler(ResourceNotFound ex) {
//        return ex.getMessage();
//    }
//}
@ControllerAdvice
class ResourceNotFound {

    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void handleConflict() {
        // Nothing to do
    }
}
