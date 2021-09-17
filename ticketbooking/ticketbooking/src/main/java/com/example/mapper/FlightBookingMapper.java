package com.example.mapper;

import com.example.dbdata.BookFlightTicket;
import com.example.dbdata.PassangerDtl;
import com.example.dtos.BookFlightDto;
import com.example.dtos.PassangerDtlDto;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class FlightBookingMapper extends ConfigurableMapper {
    @Override
    public void configure(MapperFactory mapperFactory) {
        super.configure(mapperFactory);
        mapperFactory.registerClassMap(
                mapperFactory.classMap(BookFlightDto.class, BookFlightTicket.class)
                        .byDefault()
                        .customize(new customPassangerMapper())
                        .toClassMap()
        );
    }
}

class customPassangerMapper extends CustomMapper<BookFlightDto, BookFlightTicket> {
    @Override
    public void mapAtoB(final BookFlightDto bookFlightDto,final BookFlightTicket bookFlightTicket, MappingContext context) {
        bookFlightTicket.getPassangerDlt().clear();
        bookFlightDto.getPassangerDlt().stream().forEach(passanger->{
            PassangerDtl passangerDtl = new PassangerDtl();
            passangerDtl.setFoodType(passanger.getFoodType());
            passangerDtl.setGender(passanger.getGender());
            passangerDtl.setPassangerAge(passanger.getPassangerAge());
            passangerDtl.setPassangerName(passanger.getPassangerName());
            passangerDtl.setTicketStatus(passanger.getTicketStatus());
            bookFlightTicket.getPassangerDlt().add(passangerDtl);
        });
    }

    @Override
    public void mapBtoA(final BookFlightTicket bookFlightTicket,final BookFlightDto bookFlightDto, MappingContext context) {
        bookFlightDto.getPassangerDlt().clear();
        bookFlightTicket.getPassangerDlt().stream().forEach(passanger->{
            PassangerDtlDto passangerDtl = new PassangerDtlDto();
            passangerDtl.setFoodType(passanger.getFoodType());
            passangerDtl.setGender(passanger.getGender());
            passangerDtl.setPassangerAge(passanger.getPassangerAge());
            passangerDtl.setPassangerName(passanger.getPassangerName());
            passangerDtl.setTicketStatus(passanger.getTicketStatus());
            bookFlightDto.getPassangerDlt().add(passangerDtl);
        });
    }
}
