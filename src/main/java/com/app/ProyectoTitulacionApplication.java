package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.dto.GuiaRemisionDTO;
import com.app.entity.GuiaRemision;

@SpringBootApplication
public class ProyectoTitulacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoTitulacionApplication.class, args);
	}
	
	@Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(GuiaRemisionDTO.class, GuiaRemision.class).addMappings(mapper -> {
            mapper.skip(GuiaRemision::setIdGuiaRemision);
            mapper.skip(GuiaRemision::setVehiculo);
            mapper.skip(GuiaRemision::setConductor);
        });

        return modelMapper;
    }

}
