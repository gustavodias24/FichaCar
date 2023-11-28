package benicio.solucoes.fichacar;

public class CarroModel {

    String nomeCarro, fotoCarro, fichaTécnica, valorFipe;

    public CarroModel(String nomeCarro, String fotoCarro, String fichaTécnica, String valorFipe) {
        this.nomeCarro = nomeCarro;
        this.fotoCarro = fotoCarro;
        this.fichaTécnica = fichaTécnica;
        this.valorFipe = valorFipe;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public String getFotoCarro() {
        return fotoCarro;
    }

    public void setFotoCarro(String fotoCarro) {
        this.fotoCarro = fotoCarro;
    }

    public String getFichaTécnica() {
        return fichaTécnica;
    }

    public void setFichaTécnica(String fichaTécnica) {
        this.fichaTécnica = fichaTécnica;
    }

    public String getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(String valorFipe) {
        this.valorFipe = valorFipe;
    }

    @Override
    public String toString() {
        return  "Nome do carro: " + nomeCarro + '\n' +
                "Ficha técnica: " + fichaTécnica + '\n' +
                "Valor da Tabela Fipe: R$" + valorFipe ;
    }
}
