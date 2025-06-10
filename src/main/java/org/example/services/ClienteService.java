package org.example.services;

import org.example.entities.Cliente;
import org.example.repositories.ClienteRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Cliente insert(Cliente cliente) {
        return repository.save(cliente);
    }

    public boolean update(Long id, Cliente cliente) {
        Optional<Cliente> optionalCliente = repository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente clienteSistema = optionalCliente.get();
            clienteSistema.setCliNome(cliente.getCliNome());
            clienteSistema.setCliCpf(cliente.getCliCpf());
            clienteSistema.setCliStatus(cliente.getCliStatus());
            repository.save(clienteSistema);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}