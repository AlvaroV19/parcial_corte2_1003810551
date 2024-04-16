package Service;

import Entity.Reserva;
import IRepository.IReservaRepository;
import IService.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    private IReservaRepository ireservaRepository;
    @Override
    public List<Reserva> findAll() {
        return ireservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return ireservaRepository.findById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return ireservaRepository.save(reserva);
    }

    @Override
    public void update(Reserva reserva, Long id) {
        //Obtener el objeto autor y el id
        //Verificar con el id, si exiten los datos
        Optional<Reserva> re = ireservaRepository.findById(id);

        //Cargar nuevo objeto
        if (!re.isEmpty()){
            Reserva reservaUpdate = re.get();
            reservaUpdate.setFechaentrada(reserva.getFechaentrada());
            reservaUpdate.setFechasalida(reserva.getFechasalida());
            reservaUpdate.setCliente(reserva.getCliente());

            //Actualizar el objeto autor
            ireservaRepository.save(reservaUpdate);
        }else{
            System.out.println("No existe el autor");
        }
    }

    @Override
    public void delete(Long id) {
        ireservaRepository.deleteById(id);
    }
}
