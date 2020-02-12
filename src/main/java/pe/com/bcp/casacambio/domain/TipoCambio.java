package pe.com.bcp.casacambio.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

@Table(name="tipo_cambio")
@Entity
public class TipoCambio implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="moneda_origen")
    private Long monedaOrigen;

    @Column(name="moneda_destino")
    private Long monedaDestino;

    @Column(name="tipo_cambio")
    private Double tipoCambio;

    public TipoCambio() {  }

    public TipoCambio(Long id, Long monedaOrigen, Long monedaDestino, Double tipoCambio) {
        this.id = id;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tipoCambio = tipoCambio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(Long monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public Long getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(Long monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}
