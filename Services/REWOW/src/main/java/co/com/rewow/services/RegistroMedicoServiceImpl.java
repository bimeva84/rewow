package co.com.rewow.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.rewow.dto.RegistroMedicoDto;
import co.com.rewow.entity.Dueno;
import co.com.rewow.entity.Mascota;
import co.com.rewow.entity.RegistroMedico;
import co.com.rewow.repository.DuenoRepository;
import co.com.rewow.repository.MascotaRepository;
import co.com.rewow.repository.RegistroMedicoRepository;
import co.com.rewow.repository.TipoMascotaRepository;
import co.com.rewow.util.ResponseDto;

@Service
public class RegistroMedicoServiceImpl implements RegistroMedicoService {
	
	ResponseDto response;
	
	@Autowired
	DuenoRepository duenoRepository;
	
	@Autowired
	MascotaRepository mascotaRepository;
	
	@Autowired
	TipoMascotaRepository tipoMascotaRepository;
	
	@Autowired
	RegistroMedicoRepository registroMedicoRepository;


	@Override
	public ResponseDto registronuevo(RegistroMedicoDto registroMedico) throws SQLException{
		response = new ResponseDto();
		RegistroMedico registroNuevo = new RegistroMedico();
		
		if(null != registroMedico.getRegistroId()) {
			registroNuevo = registroMedicoRepository.findById(registroMedico.getRegistroId()).orElse(null);
		}
		
		registroNuevo = null != registroNuevo?registroNuevo:new RegistroMedico();
		registroNuevo.setRegMedicoDuenoId(validarDueno(registroMedico.getNombreDueno()));
		registroNuevo.setRegMedicoMascotaId(validarMascota(registroMedico.getNombreMascota()));
		registroNuevo.setRegMedicoTipoMascotaId(tipoMascotaRepository.findById(registroMedico.getTipoMascota()).orElse(null));
		registroNuevo.setRegMedicoTamano(registroMedico.getTamaño());
		registroNuevo.setRegMedicoDesc(registroMedico.getDescripcion());
		registroNuevo = registroMedicoRepository.save(registroNuevo);		
		
		response.setBody(registroNuevo);
		response.setStatus(200);
		return response;
	}
	
	private Dueno validarDueno(String nombre) throws SQLException {
		List<Dueno> dueno = duenoRepository.consutaDuenoPorNombre(nombre);
		if(dueno.isEmpty()) {
			Dueno nuevoDueno = new Dueno();
			nuevoDueno.setDuenoNombre(nombre);
			nuevoDueno = duenoRepository.saveAndFlush(nuevoDueno);
			return nuevoDueno;
		}else {
			return dueno.get(0);
		}
	}
	
	private Mascota validarMascota(String nombre) throws SQLException {
		List<Mascota> mascota = mascotaRepository.consutaMascotaPorNombre(nombre);
		if(mascota.isEmpty()) {
			Mascota nuevoMascota = new Mascota();
			nuevoMascota.setMascotaNombre(nombre);
			nuevoMascota = mascotaRepository.saveAndFlush(nuevoMascota);
			return nuevoMascota;
		}else {
			return mascota.get(0);
		}
	}
	
	@Override
	public ResponseDto consultarRegistro(String nombreDueno) throws SQLException{
		response = new ResponseDto();
		
		List<Dueno> dueno = duenoRepository.consutaDuenoPorNombre(nombreDueno);
		
		if(dueno.isEmpty()) {
			response.setBody(null);
			response.setStatus(104);
		}else {
			List<RegistroMedico> registro = registroMedicoRepository.consutaRegistroDueno(nombreDueno);
			boolean sinRegistro = registro.isEmpty();
			
			response.setBody(sinRegistro?null:registro.get(0));
			response.setStatus(sinRegistro?104:200);
		}
		return response;
	}
	@Override
	public ResponseDto eliminarRegistro(Integer idRegistro) throws SQLException{
		response = new ResponseDto();
		
		registroMedicoRepository.deleteById(idRegistro);
		response.setBody(null);
		response.setStatus(200);
		
		return response;
	}
}
