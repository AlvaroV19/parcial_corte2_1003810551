package Controller;

import Entity.Reserva;
import IService.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reserva/")

public class ReservaController {

    @Autowired
    private IReservaService iReservaService;

    @GetMapping("/getAutores")
    public List<Reserva> findAll() {
        return iReservaService.findAll();
    }

    @GetMapping("/getAutor/{id}")
    public Optional<Reserva> findById(@PathVariable Long id) {
        return iReservaService.findById(id);
    }

    @PostMapping("/saveAutor")
    public Reserva save(@RequestBody Reserva reserva) {
        return iReservaService.save(reserva);
    }


    @PutMapping("/updateAutor/{id}")
    public void update(@RequestBody Reserva reserva, @PathVariable Long id) {
        iReservaService.update(reserva, id);
    }
    @DeleteMapping("/deleteAutor/{id}")
    public void delete(@PathVariable Long id) {
        iReservaService.delete(id);
    }
}
