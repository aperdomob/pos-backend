package syoux.apps.pos.controllers.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.dto.ProductDto;
import syoux.apps.pos.controllers.dto.StocktakingDto;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.domain.StocktakingDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-22T12:20:49-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class ProductDtoMapperImpl extends ProductDtoMapper {

    @Override
    public ProductDomain map(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductDomain productDomain = new ProductDomain();

        productDomain.setId( dto.getId() );
        productDomain.setName( dto.getName() );
        productDomain.setReference( dto.getReference() );
        productDomain.setPrice( dto.getPrice() );
        productDomain.setStocktaking( stocktakingDtoListToStocktakingDomainList( dto.getStocktaking() ) );

        return productDomain;
    }

    @Override
    public ProductDto map(ProductDomain product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setReference( product.getReference() );
        productDto.setPrice( product.getPrice() );
        productDto.setStocktaking( stocktakingDomainListToStocktakingDtoList( product.getStocktaking() ) );

        setProductId( productDto );

        return productDto;
    }

    @Override
    public StocktakingDto map(StocktakingDomain domain) {
        if ( domain == null ) {
            return null;
        }

        StocktakingDto stocktakingDto = new StocktakingDto();

        stocktakingDto.setId( domain.getId() );
        stocktakingDto.setAvailable( domain.getAvailable() );
        stocktakingDto.setLastCost( domain.getLastCost() );
        stocktakingDto.setAverageCost( domain.getAverageCost() );

        return stocktakingDto;
    }

    protected StocktakingDomain stocktakingDtoToStocktakingDomain(StocktakingDto stocktakingDto) {
        if ( stocktakingDto == null ) {
            return null;
        }

        StocktakingDomain stocktakingDomain = new StocktakingDomain();

        stocktakingDomain.setId( stocktakingDto.getId() );
        stocktakingDomain.setAvailable( stocktakingDto.getAvailable() );
        stocktakingDomain.setLastCost( stocktakingDto.getLastCost() );
        stocktakingDomain.setAverageCost( stocktakingDto.getAverageCost() );

        return stocktakingDomain;
    }

    protected List<StocktakingDomain> stocktakingDtoListToStocktakingDomainList(List<StocktakingDto> list) {
        if ( list == null ) {
            return null;
        }

        List<StocktakingDomain> list1 = new ArrayList<StocktakingDomain>( list.size() );
        for ( StocktakingDto stocktakingDto : list ) {
            list1.add( stocktakingDtoToStocktakingDomain( stocktakingDto ) );
        }

        return list1;
    }

    protected List<StocktakingDto> stocktakingDomainListToStocktakingDtoList(List<StocktakingDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<StocktakingDto> list1 = new ArrayList<StocktakingDto>( list.size() );
        for ( StocktakingDomain stocktakingDomain : list ) {
            list1.add( map( stocktakingDomain ) );
        }

        return list1;
    }
}
