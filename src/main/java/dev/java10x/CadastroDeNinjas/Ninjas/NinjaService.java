package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

  private NinjaRepository ninjaRepository;

  public NinjaService(NinjaRepository ninjaRepository) {
    this.ninjaRepository = ninjaRepository;
  }

  public List<NinjaModel> listarNinjas() {
    return ninjaRepository.findAll();
  }

  public NinjaModel listarNinjasPorId(Long id) {
    Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id); //esse optional serve para trabalhar caso não tenha um ninja com o id recebido
    return ninjaPorId.orElse(null); //o orElse serve para tratar o caso do id não existir, ele e o Optional trabalham juntos nisso
  }

  public NinjaModel criarNinja(NinjaModel ninja) {
    return ninjaRepository.save(ninja);
  }

  public void deletarNinjaPorId(Long id) {
    ninjaRepository.deleteById(id);
  }

  public NinjaModel atualizarNinja(Long id, NinjaModel ninja) {
    if (ninjaRepository.existsById(id)) {
      ninja.setId(id);
      return ninjaRepository.save(ninja);
    }
    return null;

  }
}
