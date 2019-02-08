package app.controller;

import app.service.LojaService;
import app.models.Carro;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.models.ObjetoArquivo;
import app.util.json.Json;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class LocacaoController {
    @Autowired
    LojaService lj;

    @PostMapping("/enviarObjetoArquivo")
    public int testeRetornoVariavel(@RequestBody ObjetoArquivo objetoArquivo){
        System.out.println(objetoArquivo.getTipoCarro());
        return this.lj.calcularValorLocacao(objetoArquivo.getTipoCarro(), objetoArquivo.getQuantidadePassageiros(), objetoArquivo.getIntervaloData());
    }

}
