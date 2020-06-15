package syoux.apps.pos.controllers.advices;

import lombok.Getter;
import lombok.Setter;

public class ErrorBody {
  @Getter @Setter
  private String message;

  public ErrorBody() {
    this("");
  }

  public ErrorBody(String message) {
    this.message = message;
  }
}
