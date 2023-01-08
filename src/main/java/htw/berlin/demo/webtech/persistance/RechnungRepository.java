package htw.berlin.demo.webtech.persistance;

import htw.berlin.demo.webtech.api.Rechnung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechnungRepository extends JpaRepository<RechnungEntity, Long> {

    List<RechnungEntity> findAllByName(String name);
}
