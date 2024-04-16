package IService;

import Entity.Reserva;
import java.util.List;
import java.util.Optional;

public interface IReservaService {

    List<Reserva> findAll();

    Optional<Reserva> findById(Long id);

    Reserva save(Reserva reserva);

    void update(Reserva reserva, Long id);

    void delete(Long id);
}
