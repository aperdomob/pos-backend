package syoux.apps.pos.controllers.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import syoux.apps.pos.controllers.exceptions.SaleNotFoundException;

@ControllerAdvice
public class SaleNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(SaleNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ErrorBody saleNotFoundHandler(SaleNotFoundException ex) {
    return new ErrorBody(ex.getMessage());
  }
}
