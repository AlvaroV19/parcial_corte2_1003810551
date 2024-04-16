package Controller;

import Entity.Cliente;
import IService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @GetMapping("/getClientes")
    public List<Cliente> findAll() {
        return iClienteService.findAll();
    }

    @GetMapping("getCliente/{id}")
    public Optional<Cliente> findById(@PathVariable Long id) {
        return iClienteService.findById(id);
    }

    @PostMapping("/saveCliente")
    public Cliente save(@RequestBody Cliente cliente) {
        return iClienteService.save(cliente);
    }


    @PutMapping("updateCliente/{id}")
    public void update(@RequestBody Cliente cliente, @PathVariable Long id) {
        iClienteService.update(cliente, id);
    }
    @DeleteMapping("deleteCliente/{id}")
    public void delete(@PathVariable Long id) {
        iClienteService.delete(id);
    }
}
