package app.service;
import app.models.Carro;
import org.springframework.stereotype.Service;
/**
 *
 * @author Lucas
 */
@Service
public class LojaService {
    Carro c;
    
    public LojaService(String nomeLoja, int taxa[][], String categoriaCarro, int limitePessoas){ 
        c.setNomeLoja(nomeLoja);
        c.setTaxa(taxa);
        c.setCategoriaCarro(categoriaCarro);
        c.setCapacidadeLimite(limitePessoas);
    }
    
     public LojaService(){    
         this.c = new Carro();
    }
     
     
    //Servico responsavel por calcular o valor de locacao
    public int calcularValorLocacao(String categoriaCarro, int quantidadePessoas, String intervaloLocacao[]){         
        int valor=0,tipoCliente=0; 
        int quantidadeDias=intervaloLocacao.length; //Armazena a quantidade de dias reservados para locacao
        
        //Caso o numero de passageiros atenda a capacidade de pessoas e exista carros disponiveis, calcula-se o valor da loca��o 
        if(quantidadePessoas<=c.getCapacidadeLimite()&&c.isDisponibilidade()){ 
            if(!categoriaCarro.equals("Normal")){ //Verifica se o cliente e do tipo "Normal" ou "Premium"
                tipoCliente=1; //Caso ele seja "Premium" recebera o valor 1
            }
            
            for(int i=0;i<quantidadeDias;i++){ //laco responsavel por calcular cada dia de locacao                
                //se o dia da locacao for final de semana, analisando pela posicao do dia da semana no arquivo de entrada
                if(intervaloLocacao[i].substring(11, 14).equals("sab")||intervaloLocacao[i].substring(11, 14).equals("dom")){
                    valor+=c.getTaxa()[tipoCliente][1]; //acumula o valor da locacao a cada iteracao para cliente "Premium"
                }
                else{ 
                    valor+=c.getTaxa()[tipoCliente][0]; //acumula o valor da locacao a cada iteracao para cliente "Normal"
                }
            }
        }      
        return valor; 
    }  
}
