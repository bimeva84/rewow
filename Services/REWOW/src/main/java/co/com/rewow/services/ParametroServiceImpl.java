package co.com.rewow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.rewow.entity.TipoMascota;
import co.com.rewow.repository.TipoMascotaRepository;
import co.com.rewow.repository.TipoVacunaRepository;
import co.com.rewow.repository.VacunaRepository;
import co.com.rewow.util.ResponseDto;

@Service
public class ParametroServiceImpl implements ParametroService{
	
	ResponseDto response;
	@Autowired
	TipoMascotaRepository tipoMascotaRepository;
	@Autowired
	VacunaRepository vacunaRepository;
	
	@Override
	public ResponseDto consultarTipoMascota() {
		response = new ResponseDto();
		
		response.setBody(tipoMascotaRepository.findAll());
		response.setStatus(200);
		
		return response;
	}
	
	@Override
	public ResponseDto listaVacunas() {
		response = new ResponseDto();
		
		response.setBody(vacunaRepository.findAll());
		response.setStatus(200);
		
		return response;
	}
}
