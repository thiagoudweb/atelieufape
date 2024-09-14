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

import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroExpositorException;
import br.com.atelieufape.negocio.fachada.Fachada;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
public class ExpositorController {

    @Autowired
    private Fachada fachada;

    @PostMapping(value = "/expositor")
    public ResponseEntity<String> cadastrarExpositor(@RequestBody UsuarioExpositorEntity expositor) {
        try {
            fachada.cadastrarExpositor(expositor);
            return ResponseEntity.ok("Expositor cadastrado com sucesso!");
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/expositor/{id}")
    public ResponseEntity<?> buscarUsuarioExpositorPorID(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(fachada.BuscarUsuarioExpositorPorID(id));
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/expositor")
    public ResponseEntity<List<UsuarioExpositorEntity>> listarExpositores() {
        return ResponseEntity.ok(fachada.ListarExpositores());
    }

    @PatchMapping(value = "/expositor/{id}")
    public ResponseEntity<String> atualizarExpositor(@PathVariable Long id, @RequestBody UsuarioExpositorEntity expositor) {
        try {
            expositor.setId(id);
            fachada.AtualizarExpositor(expositor);
            return ResponseEntity.ok("Expositor atualizado com sucesso!");
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/expositor/{id}")
    public ResponseEntity<String> removerExpositor(@PathVariable Long id) {
        try {
            
            UsuarioExpositorEntity expositor = fachada.BuscarUsuarioExpositorPorID(id);
            fachada.RemoverExpositor(expositor);
            return ResponseEntity.ok("Expositor removido com sucesso!");
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
