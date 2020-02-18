package pe.com.bcp.casacambio.model;

public class TipoCambioRequest {

    private Double montoInicial;
    private String monedaOrigen;
    private String monedaDestino;

    public TipoCambioRequest() {
    }

    public TipoCambioRequest(Double montoInicial, String monedaOrigen, String monedaDestino) {
        this.montoInicial = montoInicial;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
    }

    public Double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(Double montoInicial) {
        this.montoInicial = montoInicial;
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
}
