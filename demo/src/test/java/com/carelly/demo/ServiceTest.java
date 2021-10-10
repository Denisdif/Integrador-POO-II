package com.carelly.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.carelly.demo.dto.TipoIdentificacionDto;
import com.carelly.demo.service.TipoIdentificacionServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ServiceTest {
    
    @Autowired
    private TipoIdentificacionServiceImpl tipoService;

    @Test
    public void serviceTest(){
        TipoIdentificacionDto tipoDto = tipoService.create(new TipoIdentificacionDto("DNI"));
        assertEquals("DNI", tipoDto.getTipoIdentificacion());
    }
}
