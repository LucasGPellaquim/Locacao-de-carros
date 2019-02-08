package models;

//import service.LojaService;
/**
 *
 * @author Lucas
 */
public class Carro {
    private String nomeLoja; 
    private String categoriaCarro;
    private int capacidadeLimite; 
    private int taxa[][] = new int[2][2]; //O primeiro [] eh referente ao tipo de cliente e o segundo [] eh referente aos dias da semana.
    private boolean disponibilidade=true;     
    private final Carro[] carroArray=new Carro[3];
   // private final Loja[] loja=new Loja[3];
    
    //Atribuicao de valores aos carros
    public Carro(){
        carroArray[0]=new Carro("SouthCar","COMPACTO",4,new int[][]{{210,200},{150,90}});
        carroArray[1]=new Carro("WestCar","FERRARI",2, new int[][]{{530,200},{150,90}}); 
        carroArray[2]=new Carro("NorthCar","NAVIGATOR",7, new int[][]{{630,600},{580,590}});
    }
    //Metodo construtor
     public Carro(String nomeLoja,  String categoriaCarro, int capacidadeLimite,int taxa[][]){ 
        this.setNomeLoja(nomeLoja);
        this.setCategoriaCarro(categoriaCarro);
        this.setCapacidadeLimite(capacidadeLimite);
        this.setTaxa(taxa);
    }
    
    //Metodo construtor
    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponivel) {
        this.disponibilidade = disponivel;
    }
    
    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nome) {
        this.nomeLoja = nome;
    }

    public int[][] getTaxa() {
        return taxa;
    }

    public void setTaxa(int[][] taxa) {
        this.taxa = taxa;
    }

    public String getCategoriaCarro() {
        return categoriaCarro;
    }

    public void setCategoriaCarro(String categoriaCarro) {
        this.categoriaCarro = categoriaCarro;
    }
    
    public int getCapacidadeLimite() {
        return capacidadeLimite;
    }

    public void setCapacidadeLimite(int capacidadeLimite) {
        this.capacidadeLimite = capacidadeLimite;
    }
}
