package pe.com.bcp.casacambio.controller;

import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.bcp.casacambio.domain.Moneda;
import pe.com.bcp.casacambio.domain.TipoCambio;
import pe.com.bcp.casacambio.domain.TipoCambioRequest;
import pe.com.bcp.casacambio.domain.TipoCambioResponse;
import pe.com.bcp.casacambio.service.TipoCambioService;
import pe.com.bcp.casacambio.util.Constantes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/casacambio")
public class TipoCambioController {

    @Autowired
    TipoCambioService tipoCambioService;

    @GetMapping(value= "/obtenerMonedas", produces= Constantes.CONTENT_TYPE_JSON)
    public List<Moneda> obtenerMonedas() {
        return tipoCambioService.obtenerMonedas();
    }

    @GetMapping(value= "/obtenerListaTipoCambio", produces= Constantes.CONTENT_TYPE_JSON)
    public List<TipoCambio> obtenerListaTipoCambio() {
        return tipoCambioService.obtenerListaTipoCambio();
    }

    @GetMapping(value= "/obtenerTipoCambio/{id}", produces= Constantes.CONTENT_TYPE_JSON)
    public Optional<TipoCambio> obtenerTipoCambio(@PathVariable("id") Long id) {
        return tipoCambioService.obtenerTipoCambio(id);
    }

    @RequestMapping(value = "/consultarTipoCambio", method = RequestMethod.POST, headers = Constantes.HEADER_JSON, produces = Constantes.CONTENT_TYPE_JSON)
    public @ResponseBody TipoCambioResponse tipoCambioResponse(@RequestBody TipoCambioRequest tipoCambioRequest){
        return tipoCambioService.consultarTipoCambio(tipoCambioRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/obtenerMonedasRxJava")
    public Observable<List<Moneda>> consultarMonedasRx() {
        List<Moneda> monedas = tipoCambioService.obtenerMonedas();
        return Observable.just(monedas);
    }

    @RequestMapping(value = "/consultarTipoCambioRxJava", method = RequestMethod.POST, headers = Constantes.HEADER_JSON, produces = Constantes.CONTENT_TYPE_JSON)
    public @ResponseBody TipoCambioResponse tipoCambioResponseRxJava(@RequestBody TipoCambioRequest tipoCambioRequest){
        return tipoCambioService.consultarTipoCambioRxJava(tipoCambioRequest);
    }

}
