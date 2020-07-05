package syoux.apps.pos.services.interfaces;

import java.io.InputStream;
import java.util.List;
import syoux.apps.pos.domain.ProductDomain;

public interface IExcelService {
  List<ProductDomain> extract(InputStream excel);
}
