package syoux.apps.pos.services.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.repository.entity.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-22T13:37:20-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDomain entityToDomain(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDomain productDomain = new ProductDomain();

        productDomain.setId( entity.getId() );
        productDomain.setName( entity.getName() );
        productDomain.setReference( entity.getReference() );
        productDomain.setPrice( String.valueOf( entity.getPrice() ) );

        return productDomain;
    }

    @Override
    public Product domainToEntity(ProductDomain domain) {
        if ( domain == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( domain.getId() );
        product.setName( domain.getName() );
        product.setReference( domain.getReference() );
        if ( domain.getPrice() != null ) {
            product.setPrice( Double.parseDouble( domain.getPrice() ) );
        }

        return product;
    }
}
