package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

  private NinjaService ninjaService;

  public NinjaController(NinjaService ninjaService) {
    this.ninjaService = ninjaService;
  }

  @PostMapping("/criar")
  public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {

    NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + " ID: " + ninjaDTO.getId());
  }

  @GetMapping("/listar")
  public ResponseEntity<List<NinjaDTO>> listarNinjas() {

    List<NinjaDTO> ninjasDTO = ninjaService.listarNinjas();
    return ResponseEntity.ok(ninjasDTO);
  }

  @GetMapping("/listar/{id}")
  public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
    NinjaDTO ninjaDTO = ninjaService.listarNinjasPorId(id);

    if (ninjaDTO != null) {
      return ResponseEntity.ok(ninjaDTO);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Ninja com id " + id + " não encontrado");
    }
  }

  @PutMapping("/alterar/{id}")
  public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
    NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninja);

    if (ninjaDTO != null) {
      return ResponseEntity.ok("O ninja " + ninjaDTO.getNome() + " foi atualizado com sucesso!");
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Ninja com id " + id + " não encontrado");
    }
  }

  @DeleteMapping("/deletar/{id}")
  public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

    if (ninjaService.listarNinjasPorId(id) != null) {
      ninjaService.deletarNinjaPorId(id);
      return ResponseEntity.ok("Ninja com id " + id + " deletado com sucesso!");
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Ninja com id " + id + " não encontrado");
    }
  }
}
