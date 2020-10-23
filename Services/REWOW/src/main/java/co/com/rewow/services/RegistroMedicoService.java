package co.com.rewow.services;

import java.sql.SQLException;

import co.com.rewow.dto.RegistroMedicoDto;
import co.com.rewow.util.ResponseDto;

public interface RegistroMedicoService {
	public ResponseDto registronuevo(RegistroMedicoDto registroMedico) throws SQLException;
	public ResponseDto consultarRegistro(String nombreDueno) throws SQLException;
	public ResponseDto eliminarRegistro(Integer idRegistro) throws SQLException;
}
