package org.example.services;

import dto.ClienteDTO;
import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.repositories.ClienteRepository;
import org.example.repositories.EnderecoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Cliente insert(Cliente obj) {
        try {
            obj.setCliId(null);
            // Cascade ALL cuida do save de enderecos e contatos
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Cliente update(Long id, ClienteDTO objDto) {
        try {
            Cliente entity = findById(id);

            // Atualiza os dados do cliente
            entity.setCliNome(objDto.getCliNome());
            entity.setCliCpf(objDto.getCliCpf());
            entity.setCliStatus(objDto.getCliStatus());

            // Atualiza ou cria o Endereço do Cliente
            if (entity.getEnderecos().isEmpty()) {
                Endereco novoEndereco = new Endereco(null, entity,
                        objDto.getEndRua(), objDto.getEndNumero(),
                        objDto.getEndCidade(), objDto.getEndCep(),
                        objDto.getEndEstado(), objDto.getEndBairro());
                entity.getEnderecos().add(novoEndereco);
            } else {
                Endereco endereco = entity.getEnderecos().get(0);
                endereco.setEndRua(objDto.getEndRua());
                endereco.setEndNumero(objDto.getEndNumero());
                endereco.setEndCidade(objDto.getEndCidade());
                endereco.setEndCep(objDto.getEndCep());
                endereco.setEndEstado(objDto.getEndEstado());
                endereco.setEndBairro(objDto.getEndBairro());
            }

            // Atualiza ou cria o Contato do cliente
            if (entity.getContatos().isEmpty()) {
                Contato novoContato = new Contato(null, entity,
                        objDto.getConCelular(), objDto.getConTelefoneComercial(),
                        objDto.getConEmail(), objDto.getConEmailSecundario());
                entity.getContatos().add(novoContato);
            } else {
                Contato contato = entity.getContatos().get(0);
                contato.setConCelular(objDto.getConCelular());
                contato.setConTelefoneComercial(objDto.getConTelefoneComercial());
                contato.setConEmail(objDto.getConEmail());
                contato.setConEmailSecundario(objDto.getConEmailSecundario());
            }

            return repository.save(entity);
        } catch (DataIntegrityViolationException e){
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteCliente(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        Cliente cli = new Cliente(null, objDto.getCliNome(), objDto.getCliCpf(), objDto.getCliStatus());
        Endereco ender = new Endereco(null, cli, objDto.getEndRua(), objDto.getEndNumero(), objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndEstado(), objDto.getEndBairro());
        Contato contato = new Contato(null, cli, objDto.getConCelular(), objDto.getConTelefoneComercial(),
                objDto.getConEmail(), objDto.getConEmailSecundario());

        cli.getEnderecos().add(ender);
        cli.getContatos().add(contato);

        return cli;
    }

    public ClienteDTO toNewDTO(Cliente obj) {
        ClienteDTO dto = new ClienteDTO();

        dto.setCliId(obj.getCliId());
        dto.setCliNome(obj.getCliNome());
        dto.setCliCpf(obj.getCliCpf());
        dto.setCliStatus(obj.getCliStatus());  // corrigido aqui

        if (!obj.getEnderecos().isEmpty()) {
            Endereco endereco = obj.getEnderecos().get(0);
            dto.setEndRua(endereco.getEndRua());
            dto.setEndNumero(endereco.getEndNumero());
            dto.setEndCidade(endereco.getEndCidade());
            dto.setEndCep(endereco.getEndCep());
            dto.setEndEstado(endereco.getEndEstado());
            dto.setEndBairro(endereco.getEndBairro());
        }

        if (!obj.getContatos().isEmpty()) {
            Contato contato = obj.getContatos().get(0);
            dto.setConCelular(contato.getConCelular());
            dto.setConTelefoneComercial(contato.getConTelefoneComercial());
            dto.setConEmail(contato.getConEmail());
            dto.setConEmailSecundario(contato.getConEmailSecundario());
        }

        return dto;
    }
}
