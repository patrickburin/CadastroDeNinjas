package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

  private NinjaService ninjaService;

  public NinjaController(NinjaService ninjaService) {
    this.ninjaService = ninjaService;
  }

  @GetMapping("/boasvindas")
  public String welcome() {
    return "Essa é minha primeira mensagem nessa rota";
  }

  @PostMapping("/criar")
  public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {//o @RequestBody pega o body e transforma em um ninja do tipo NinjaModel
    return ninjaService.criarNinja(ninja);
  }

  @GetMapping("/listar")
  public List<NinjaModel> listarNinjas() {
    return ninjaService.listarNinjas();
  }

  @GetMapping("/listar/{id}")
  public NinjaModel listarNinjasPorId(@PathVariable Long id) {//o @PathVariable pega a info da url pra se referir ao id do ninja que deseja
    return ninjaService.listarNinjasPorId(id);
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
