package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

  @GetMapping("/boasvindas")
  public String welcome() {
    return "Essa é minha primeira mensagem nessa rota";
  }

  @PostMapping("/criar")
  public String criarNinja() {
    return "Ninja criado";
  }

  @GetMapping("/listar")
  public String mostrarTodosOsNinjas() {
    return "Mostrar ninja";
  }

  @GetMapping("/listarId")
  public String mostrarTodosOsNinjasPorId() {
    return "Mostrar ninja por id";
  }

  @PutMapping("/alterarId")
  public String alterarNinjaPorId() {
    return "Alterar o ninja por id";
  }

  @DeleteMapping("/deletarId")
  public String deletarNinjaPorId() {
    return "Ninja deletado por id";
  }

}
