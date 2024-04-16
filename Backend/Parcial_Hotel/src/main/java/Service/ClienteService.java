package Service;

import Entity.Cliente;
import IRepository.IClienteRepository;
import IService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository iclienteRepository;

    @Override
    public List<Cliente> findAll() {
        return iclienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return iclienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return iclienteRepository.save(cliente);
    }

    @Override
    public void update(Cliente cliente, Long id) {
        //Obtener el objeto autor y el id
        //Verificar con el id, si exiten los datos
        Optional<Cliente> cl = iclienteRepository.findById(id);

        //Cargar nuevo objeto
        if (!cl.isEmpty()) {
            Cliente clienteUpdate = cl.get();
            clienteUpdate.setNombre(cliente.getNombre());
            clienteUpdate.setTelefono(cliente.getTelefono());

            //Actualizar el objeto autor
            iclienteRepository.save(clienteUpdate);
        } else {
            System.out.println("No existe el autor");
        }
    }

    @Override
    public void delete(Long id) {
        iclienteRepository.deleteById(id);
    }
}
