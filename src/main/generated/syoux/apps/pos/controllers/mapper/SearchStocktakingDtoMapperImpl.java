package syoux.apps.pos.controllers.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.dto.SearchStocktakingDto;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.domain.SearchStocktakingDomain;
import syoux.apps.pos.domain.StocktakingDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-22T13:40:39-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class SearchStocktakingDtoMapperImpl implements SearchStocktakingDtoMapper {

    @Override
    public SearchStocktakingDto map(SearchStocktakingDomain domain) {
        if ( domain == null ) {
            return null;
        }

        SearchStocktakingDto searchStocktakingDto = new SearchStocktakingDto();

        searchStocktakingDto.setReference( domainProductReference( domain ) );
        searchStocktakingDto.setProductId( domainProductId( domain ) );
        String price = domainProductPrice( domain );
        if ( price != null ) {
            searchStocktakingDto.setPrice( Double.parseDouble( price ) );
        }
        searchStocktakingDto.setAvailable( domainStocktakingAvailable( domain ) );
        searchStocktakingDto.setName( domainProductName( domain ) );
        searchStocktakingDto.setLastCost( domainStocktakingLastCost( domain ) );
        searchStocktakingDto.setStocktakingId( domainStocktakingId( domain ) );
        searchStocktakingDto.setAverageCost( domainStocktakingAverageCost( domain ) );

        return searchStocktakingDto;
    }

    private String domainProductReference(SearchStocktakingDomain searchStocktakingDomain) {
        if ( searchStocktakingDomain == null ) {
            return null;
        }
        ProductDomain product = searchStocktakingDomain.getProduct();
        if ( product == null ) {
            return null;
        }
        String reference = product.getReference();
        if ( reference == null ) {
            return null;
        }
        return reference;
    }

    private Long domainProductId(SearchStocktakingDomain searchStocktakingDomain) {
        if ( searchStocktakingDomain == null ) {
            return null;
        }
        ProductDomain product = searchStocktakingDomain.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String domainProductPrice(SearchStocktakingDomain searchStocktakingDomain) {
        if ( searchStocktakingDomain == null ) {
            return null;
        }
        ProductDomain product = searchStocktakingDomain.getProduct();
        if ( product == null ) {
            return null;
        }
        String price = product.getPrice();
        if ( price == null ) {
            return null;
        }
        return price;
    }

    private Long domainStocktakingAvailable(SearchStocktakingDomain searchStocktakingDomain) {
        if ( searchStocktakingDomain == null ) {
            return null;
        }
        StocktakingDomain stocktaking = searchStocktakingDomain.getStocktaking();
        if ( stocktaking == null ) {
            return null;
        }
        Long available = stocktaking.getAvailable();
        if ( available == null ) {
            return null;
        }
        return available;
    }

    private String domainProductName(SearchStocktakingDomain searchStocktakingDomain) {
        if ( searchStocktakingDomain == null ) {
            return null;
        }
        ProductDomain product = searchStocktakingDomain.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private double domainStocktakingLastCost(SearchStocktakingDomain searchStocktakingDomain) {
        if ( searchStocktakingDomain == null ) {
            return 0.0d;
        }
        StocktakingDomain stocktaking = searchStocktakingDomain.getStocktaking();
        if ( stocktaking == null ) {
            return 0.0d;
        }
        double lastCost = stocktaking.getLastCost();
        return lastCost;
    }

    private Long domainStocktakingId(SearchStocktakingDomain searchStocktakingDomain) {
        if ( searchStocktakingDomain == null ) {
            return null;
        }
        StocktakingDomain stocktaking = searchStocktakingDomain.getStocktaking();
        if ( stocktaking == null ) {
            return null;
        }
        Long id = stocktaking.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private double domainStocktakingAverageCost(SearchStocktakingDomain searchStocktakingDomain) {
        if ( searchStocktakingDomain == null ) {
            return 0.0d;
        }
        StocktakingDomain stocktaking = searchStocktakingDomain.getStocktaking();
        if ( stocktaking == null ) {
            return 0.0d;
        }
        double averageCost = stocktaking.getAverageCost();
        return averageCost;
    }
}
