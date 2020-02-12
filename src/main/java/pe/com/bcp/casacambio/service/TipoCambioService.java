package pe.com.bcp.casacambio.service;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bcp.casacambio.domain.Moneda;
import pe.com.bcp.casacambio.domain.TipoCambio;
import pe.com.bcp.casacambio.domain.TipoCambioRequest;
import pe.com.bcp.casacambio.domain.TipoCambioResponse;
import pe.com.bcp.casacambio.repository.MonedaRepository;
import pe.com.bcp.casacambio.repository.TipoCambioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCambioService {

    @Autowired
    MonedaRepository monedaRepository;
    @Autowired
    TipoCambioRepository tipoCambioRepository;

    public List<Moneda> obtenerMonedas() {
        List<Moneda> monedas = new ArrayList<>();
        monedaRepository.findAll().forEach(moneda -> monedas.add(moneda));
        return monedas;
    }

    public Optional<Moneda> obtenerMoneda(Long id){
        return monedaRepository.findById(id);
    }

    public List<TipoCambio> obtenerListaTipoCambio() {
        List<TipoCambio> tipoCambioList = new ArrayList<>();
        tipoCambioRepository.findAll().forEach(tipoCambio -> tipoCambioList.add(tipoCambio));
        return tipoCambioList;
    }

    public Optional<TipoCambio> obtenerTipoCambio(Long id){
        return tipoCambioRepository.findById(id);
    }

    private Long buscarMoneda(String nombre){
        Long id = null;
        List<Moneda> monedas = obtenerMonedas();
        for(int i=0; i<=monedas.size()-1; i++){
            if (nombre.equalsIgnoreCase(monedas.get(i).getNombre())){
                id = monedas.get(i).getId();
            }
        }
        return id;
    }

    private Double buscarTipoCambio(String monedaOrigen, String monedaDestino){
       Double tipoCambio = null;
       Long idOrigen = buscarMoneda(monedaOrigen);
       Long idDestino = buscarMoneda(monedaDestino);
       List<TipoCambio> tipoCambioList = obtenerListaTipoCambio();
       for(int i=0; i <= tipoCambioList.size()-1 ; i++ ){
            if(idOrigen == tipoCambioList.get(i).getMonedaOrigen() && idDestino == tipoCambioList.get(i).getMonedaDestino()){
                tipoCambio = tipoCambioList.get(i).getTipoCambio();
            }
       }
       return tipoCambio;
    }

    private Double calcularTipoCambio(Double monto, String monedaOrigen, String monedaDestino){
        Double montoFinal = 0.0;
        Double tipoCambio = buscarTipoCambio(monedaOrigen,monedaDestino);
        if(tipoCambio  != null){
            montoFinal = monto * tipoCambio;
        }
        return   Math.round(montoFinal*100.0)/ 100.0;
    }

    public TipoCambioResponse consultarTipoCambio (TipoCambioRequest tipoCambioRequest){
        TipoCambioResponse tipoCambioResponse = new TipoCambioResponse();
        Double tipoCambio = buscarTipoCambio(tipoCambioRequest.getMonedaOrigen(), tipoCambioRequest.getMonedaDestino());
        Double montoFinal = calcularTipoCambio(tipoCambioRequest.getMontoInicial(),tipoCambioRequest.getMonedaOrigen(), tipoCambioRequest.getMonedaDestino());

        tipoCambioResponse.setMontoInicial(tipoCambioRequest.getMontoInicial());
        tipoCambioResponse.setMonedaOrigen(tipoCambioRequest.getMonedaOrigen());
        tipoCambioResponse.setMonedaDestino(tipoCambioRequest.getMonedaDestino());
        tipoCambioResponse.setTipoCambio(tipoCambio);
        tipoCambioResponse.setMontoFinal(montoFinal);

        return tipoCambioResponse;
    }

    public TipoCambioResponse consultarTipoCambioRxJava (TipoCambioRequest tipoCambioRequest){
        TipoCambioResponse tipoCambioResponse = new TipoCambioResponse();
        Observable<TipoCambioRequest> requestObservable = Observable.just(tipoCambioRequest);
        requestObservable.subscribe(new Consumer<TipoCambioRequest>() {
            @Override
            public void accept(TipoCambioRequest tipoCambioRequest) throws Exception {
                TipoCambioResponse tipoCambioResponseInicial  =  consultarTipoCambio(tipoCambioRequest);
                tipoCambioResponse.setMontoInicial(tipoCambioResponseInicial.getMontoInicial());
                tipoCambioResponse.setMonedaOrigen(tipoCambioResponseInicial.getMonedaOrigen());
                tipoCambioResponse.setMonedaDestino(tipoCambioResponseInicial.getMonedaDestino());
                tipoCambioResponse.setTipoCambio(tipoCambioResponseInicial.getTipoCambio());
                tipoCambioResponse.setMontoFinal(tipoCambioResponseInicial.getMontoFinal());
            }
        });
        return tipoCambioResponse;
    }
}
