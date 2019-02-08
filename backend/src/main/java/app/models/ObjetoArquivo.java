package app.models;

public class ObjetoArquivo {

    private String tipoCarro;

    private int quantidadePassageiros;

    private String[] intervaloData;

    public ObjetoArquivo(){
        this.tipoCarro = "---";
        this.quantidadePassageiros = 0;
        this.intervaloData = new String[2];
    }

    public String getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(String tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(int quantidadePassageiros) {
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public String[] getIntervaloData() {
        return intervaloData;
    }

    public void setIntervaloData(String[] intervaloData) {
        this.intervaloData = intervaloData;
    }
}
