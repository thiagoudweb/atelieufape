package br.com.atelieufape.negocio.cadastro;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.atelieufape.dados.ExpositorDados;
import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroExpositorException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroExpositor;

@Service
public class CadastroExpositor implements ContratoCadastroExpositor {

	@Autowired
	private ExpositorDados expositorDados;

	public CadastroExpositor(ExpositorDados expositorDados) {
		this.expositorDados = expositorDados;
	}

	@Override
	public UsuarioExpositorEntity cadastrarExpositor(UsuarioExpositorEntity expositor) {

		Optional<UsuarioExpositorEntity> verificarCpf = expositorDados.findByCpf(expositor.getCpf());

		if (verificarCpf.isPresent()) {
			throw new CadastroExpositorException("Erro! O usuário expositor já cadastrado no sistema.");
		} else {
			return expositorDados.save(expositor);
		}

	}

	@Override
	public void removerExpositor(UsuarioExpositorEntity expositor) {

		if (expositorDados.existsById(expositor.getId())) {

			expositorDados.deleteById(expositor.getId());
		} else {
			throw new CadastroExpositorException("Erro ao tentar remover expositor");
		}
	}

	@Override
	public UsuarioExpositorEntity atualizarExpositor(UsuarioExpositorEntity expositor) {

		if (expositorDados.existsById(expositor.getId())) {

			return expositorDados.save(expositor);

		} else {

			throw new CadastroExpositorException("Expositor não encontrato");

		}

	}

	@Override
	public List<UsuarioExpositorEntity> listarExpositores() {

		try {

			List<UsuarioExpositorEntity> expositores = expositorDados.findAll();

			return expositores;

		} catch (Exception e) {

			throw new CadastroExpositorException("Usuário já existe!");

		}
	}

	@Override
	public UsuarioExpositorEntity buscarUsuarioExpositorPorID(Long id) {

		Optional<UsuarioExpositorEntity> expositorBuscado = expositorDados.findById(id);

		if (expositorBuscado.isPresent()) {
			return expositorBuscado.get();

		} else {

			throw new CadastroExpositorException("Expositor não encontrato!");
		}
	}

	public ExpositorDados getExpositorDados() {
		return expositorDados;

	}

	public void setExpositorDados(ExpositorDados expositorDados) {
		this.expositorDados = expositorDados;
	}

	@Override
	public void deletarExpositor(Long ID) {

		if (expositorDados.existsById(ID)) {
			expositorDados.deleteById(ID);

		} else {

			throw new CadastroExpositorException("Expositor não encontrado!");

		}

	}
}
