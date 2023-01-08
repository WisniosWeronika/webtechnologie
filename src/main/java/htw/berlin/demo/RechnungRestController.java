package htw.berlin.demo;

import htw.berlin.demo.webtech.api.Rechnung;
import htw.berlin.demo.webtech.api.RechnungManipulationRequest;
import htw.berlin.demo.webtech.service.RechnungService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RechnungRestController {

    private final RechnungService rechnungService;

    public RechnungRestController(RechnungService rechnungService) {
        this.rechnungService = rechnungService;
    }



    @GetMapping(path = "/api/v1/rechnung")
    public ResponseEntity<List<Rechnung>> fetchRechnungs() {
        return ResponseEntity.ok(rechnungService.findAll());
    }

    @GetMapping(path = "/api/v1/rechnung/{rid}")
    public ResponseEntity<Rechnung> fetchRechnungByRid(@PathVariable Long rid) {
        var rechnung = rechnungService.findByRid(rid);
        return rechnung != null? ResponseEntity.ok(rechnung) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/rechnungs")
    public ResponseEntity<Void> createRechnung(@RequestBody RechnungManipulationRequest request) throws URISyntaxException {
        var rechnung = rechnungService.create(request);
        URI uri = new URI("/api/v1/rechnungs/" + rechnung.getRid());
        return ResponseEntity.created(uri).build();
    }

}
