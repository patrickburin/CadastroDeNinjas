package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA = Java Persistence API
@Entity // o Entity transforma uma classe em uma entidade do DB
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  @Column(unique = true)
  private String email;
  private int idade;
  @ManyToOne // @ManyToOne =  muitos ninjas para uma missão
  @JoinColumn(name = "missoes_id") //isso é a chave estrangeira
  private MissoesModel missoes;

}
