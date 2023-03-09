package ru.skillbox.mapper;

import javax.annotation.processing.Generated;
import ru.skillbox.common.AccountDto;
import ru.skillbox.model.Person;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T10:28:01+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto personToAccountDto(Person person) {
        if ( person == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setCity( mapCity( person.getCity() ) );
        accountDto.setCountry( mapCountry( person.getCountry() ) );
        accountDto.setIsOnline( checkIsOnline( person.getLastOnlineTime() ) );
        accountDto.setId( person.getId() );
        accountDto.setEmail( person.getEmail() );
        accountDto.setPhone( person.getPhone() );
        accountDto.setPhoto( person.getPhoto() );
        accountDto.setAbout( person.getAbout() );
        accountDto.setFirstName( person.getFirstName() );
        accountDto.setLastName( person.getLastName() );
        accountDto.setRegDate( person.getRegDate() );
        accountDto.setBirthDate( person.getBirthDate() );
        accountDto.setMessagePermission( person.getMessagePermission() );
        accountDto.setLastOnlineTime( person.getLastOnlineTime() );
        accountDto.setIsBlocked( person.getIsBlocked() );

        return accountDto;
    }
}
