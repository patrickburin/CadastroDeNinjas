package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
  @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso!"),
      @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
  })
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
  @Operation(summary = "Lista o ninja por ID", description = "Rota lista um ninja pelo ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Ninja listado com sucesso!"),
      @ApiResponse(responseCode = "400", description = "Ninja não encontrado")
  })
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
  @Operation(summary = "Altera o ninja por ID", description = "Rota altera um ninja pelo ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Ninja listado com sucesso!"),
      @ApiResponse(responseCode = "400", description = "Ninja não encontrado, não foi possível alterar")
  })
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
