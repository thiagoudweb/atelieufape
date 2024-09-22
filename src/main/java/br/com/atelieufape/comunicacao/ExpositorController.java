package br.com.atelieufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroExpositorException;
import br.com.atelieufape.negocio.cadastro.exception.ExpositorCpfDuplicadoException;
import br.com.atelieufape.negocio.cadastro.exception.ExpositorEmailDuplicadoException;
import br.com.atelieufape.negocio.fachada.Fachada;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/expositor")
public class ExpositorController {

    @Autowired
    private Fachada fachada;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarExpositor(@RequestBody UsuarioExpositorEntity expositor) {
        try {
            fachada.cadastrarExpositor(expositor);
            return ResponseEntity.ok("Expositor cadastrado com sucesso!");
        } catch (ExpositorCpfDuplicadoException | ExpositorEmailDuplicadoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("Erro desconhecido: " + e.getMessage());
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarUsuarioExpositorPorID(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(fachada.buscarUsuarioExpositorPorID(id));
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioExpositorEntity>> listarExpositores() {
        return ResponseEntity.ok(fachada.listarExpositores());
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarExpositor(@PathVariable Long id,
            @RequestBody UsuarioExpositorEntity expositor) {
        try {
            expositor.setId(id);
            fachada.atualizarExpositor(expositor);
            return ResponseEntity.ok("Expositor atualizado com sucesso!");
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removerExpositor(@PathVariable Long id) {
        try {

            UsuarioExpositorEntity expositor = fachada.buscarUsuarioExpositorPorID(id);
            fachada.removerExpositor(expositor);
            return ResponseEntity.ok("Expositor removido com sucesso!");
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}