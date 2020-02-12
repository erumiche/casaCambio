package pe.com.bcp.casacambio.domain;

public class TipoCambioResponse {

    private Double montoInicial;
    private Double montoFinal;
    private String monedaOrigen;
    private String monedaDestino;
    private Double tipoCambio;

    public TipoCambioResponse() {
    }

    public TipoCambioResponse(Double montoInicial, Double montoFinal, String monedaOrigen, String monedaDestino, Double tipoCambio) {
        this.montoInicial = montoInicial;
        this.montoFinal = montoFinal;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tipoCambio = tipoCambio;
    }

    public Double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(Double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public Double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}
