package ru.skillbox.mapper;

import javax.annotation.processing.Generated;
import ru.skillbox.common.CityDto;
import ru.skillbox.common.CountryDto;
import ru.skillbox.model.City;
import ru.skillbox.model.Country;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T10:28:01+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class GeoMapperImpl implements GeoMapper {

    @Override
    public CityDto cityToCityDto(City city) {
        if ( city == null ) {
            return null;
        }

        CityDto.CityDtoBuilder cityDto = CityDto.builder();

        if ( city.getCountry() != null ) {
            cityDto.countryId( mapCountry( city.getCountry() ).intValue() );
        }
        cityDto.id( city.getId() );
        cityDto.title( city.getTitle() );

        return cityDto.build();
    }

    @Override
    public CountryDto countryToCountryDto(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        if ( country.getId() != null ) {
            countryDto.setId( country.getId().intValue() );
        }
        countryDto.setTitle( country.getTitle() );

        return countryDto;
    }
}
