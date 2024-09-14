package br.com.atelieufape.negocio.basico;

import br.com.atelieufape.negocio.contratos.UsuarioAbstract;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_USUARIO")
public class UsuarioEntity extends UsuarioAbstract {

    public UsuarioEntity(String nome, String sobrenome, String cpf, String rg, String senha,
            String email) {
        super(nome, sobrenome, cpf, rg, senha, email);

    }

}
