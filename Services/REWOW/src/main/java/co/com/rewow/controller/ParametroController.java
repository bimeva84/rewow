package co.com.rewow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.rewow.services.ParametroService;
import co.com.rewow.util.ResponseDto;

@RestController
@RequestMapping(value = "/parametro")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ParametroController {
	
	@Autowired
	ParametroService parametroService;
	
	@GetMapping(value = "/consultarTiposMascotas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> consultarParametro(){
		ResponseDto response = parametroService.consultarTipoMascota();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listaVacunas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> listaVacunas(){
		ResponseDto response = parametroService.listaVacunas();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
