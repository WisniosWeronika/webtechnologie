package htw.berlin.demo.webtech.service;

import htw.berlin.demo.webtech.api.Rechnung;
import htw.berlin.demo.webtech.api.RechnungManipulationRequest;
import htw.berlin.demo.webtech.persistance.RechnungEntity;
import htw.berlin.demo.webtech.persistance.RechnungRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RechnungService {
    private final RechnungRepository rechnungRepository;

    public RechnungService(RechnungRepository rechnungRepository) {
        this.rechnungRepository = rechnungRepository;
    }

    public List<Rechnung> findAll() {
        List<RechnungEntity> rechnung = rechnungRepository.findAll();
        return rechnung.stream()
                .map(this::transformEntity2)
                .collect(Collectors.toList());
    }

    public Rechnung findByRid(Long rid) {
        var rechnungEntity = rechnungRepository.findById(rid);
        return rechnungEntity.map(this::transformEntity2).orElse(null);
    }

    public Rechnung create(RechnungManipulationRequest request) {
        RechnungEntity RechnungEntity = new RechnungEntity(request.getName(), request.getFrist(), request.getKontonummer(), request.getPreis());
        htw.berlin.demo.webtech.persistance.RechnungEntity rechnungEntity = rechnungRepository.save(RechnungEntity);
        return transformEntity2(rechnungEntity);
    }


    public Rechnung update(Long rid, RechnungManipulationRequest request) {
        var rechnungEntityOptional = rechnungRepository.findById(rid);
        if (rechnungEntityOptional.isEmpty()) {
            return null;
        }

        var rechnungEntity = rechnungEntityOptional.get();
        rechnungEntity.setName(request.getName());
        rechnungEntity.setFrist(request.getFrist());
        rechnungEntity.setKontonummer(request.getKontonummer());
        rechnungEntity.setPreis(request.getPreis());
        rechnungEntity = rechnungRepository.save(rechnungEntity);

        return transformEntity2(rechnungEntity);
    }


    public boolean deleteByRid(Long rid) {
        if (!rechnungRepository.existsById(rid)) {
            return false;
        }

        rechnungRepository.deleteById(rid);
        return true;
    }


    private Rechnung transformEntity2(RechnungEntity rechnungEntity) {
        return new Rechnung(
                rechnungEntity.getRid(),
                rechnungEntity.getName(),
                rechnungEntity.getFrist(),
                rechnungEntity.getKontonummer(),
                rechnungEntity.getPreis());
        }

}
