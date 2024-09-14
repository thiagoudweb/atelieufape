package br.com.atelieufape.negocio.cadastro;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.atelieufape.dados.UsuarioDados;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroUsuarioException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroUsuario;

@Service
public class CadastroUsuario implements ContratoCadastroUsuario {

	// construtor //
	@Autowired
	private UsuarioDados usuarioDados;

	public CadastroUsuario(UsuarioDados usuarioDados) {
		this.usuarioDados = usuarioDados;
	}

	// metodos opersonalizados//
	@Override
    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) {
        Optional<UsuarioEntity> verificarCpf = usuarioDados.findByCpf(usuario.getCpf());

        if (verificarCpf.isPresent()) {
            throw new CadastroUsuarioException("Erro! O usuário já está cadastrado no sistema!");
        } else {
            return usuarioDados.save(usuario);
        }
    }


	@Override
	public void RemoverUsuario(UsuarioEntity usuario) {

		if (usuarioDados.existsById(usuario.getId())) {

			usuarioDados.deleteById(usuario.getId());
		}

		else {
			throw new CadastroUsuarioException("Erro ao tentar remover usuário");
		}

	}

	@Override
	public UsuarioEntity AtualizarUsuario(UsuarioEntity usuario) {

		if (usuarioDados.existsById(usuario.getId())) {
			return usuarioDados.save(usuario);
		}

		else {

			throw new CadastroUsuarioException("Usuário não encontrado");
		}

	}


	@Override
	public List<UsuarioEntity> ListarUsuarios() {

		try {
			List<UsuarioEntity> usuarios = usuarioDados.findAll();

			return usuarios;

		} catch (Exception e) {

			throw new CadastroUsuarioException("Usuário já existe!");
		}
	}

	@Override
	public UsuarioEntity BuscarUsuarioPorID(Long id) {
		try {
			Optional<UsuarioEntity> usuarioBuscado = usuarioDados.findById(id);

			if (usuarioBuscado.isPresent()) {
				return usuarioBuscado.get();
			} else {
				throw new CadastroUsuarioException("Usuario não encontrado!");
			}
			}catch(Exception e){
				throw new CadastroUsuarioException("Erro ao buscar usuário: "+e.getMessage());
			}

		}

    // metodos especiais //
    public UsuarioDados getUsuarioDados() {
        return usuarioDados;
    }

    public void setUsuarioDados(UsuarioDados usuarioDados) {
        this.usuarioDados = usuarioDados;
    }
}
