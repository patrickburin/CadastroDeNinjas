package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController //informa que tudo é um controller
@RequestMapping("missoes") //vai começar a mapear as APIs e da o valor antes do endpoint, nesse caso "locahost:8080/missoes/..."
public class MissoesController {


  @GetMapping("/listar")
  public String listarMissoes() {
    return "Missões listadas com sucesso!";
  }

  @PostMapping("/criar")
  public String criarMissao() {
    return "Missao criada com sucesso!";
  }

  @PutMapping("/alterar")
  public String alterarMissao() {
    return "Missao alterada com sucesso!";
  }

  @DeleteMapping("/deletar")
  public String deletarMissao() {
    return "Missao deletada com sucesso!";
  }

}
