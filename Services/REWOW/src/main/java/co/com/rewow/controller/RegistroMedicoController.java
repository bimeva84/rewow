package co.com.rewow.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.rewow.dto.RegistroMedicoDto;
import co.com.rewow.services.RegistroMedicoService;
import co.com.rewow.util.ResponseDto;

@RestController
@RequestMapping(value = "/registroMedico")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class RegistroMedicoController {
	
	@Autowired RegistroMedicoService registroMedicoService;

	@PostMapping(value = "/registro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> nuevoRegistro(@RequestBody RegistroMedicoDto registroMedico) throws SQLException{
		ResponseDto response = registroMedicoService.registronuevo(registroMedico);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/consultaRegistro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> consultaRegistro(@RequestBody String nombreDueno) throws SQLException{
		ResponseDto response = registroMedicoService.consultarRegistro(nombreDueno);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/eliminarRegistro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> eliminarRegistro(@RequestBody String idRegistro) throws SQLException{
		ResponseDto response = registroMedicoService.eliminarRegistro(Integer.parseInt(idRegistro));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
