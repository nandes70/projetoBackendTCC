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

import javax.naming.spi.ResolveResult;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

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
            obj = repository.save(obj);
            enderecoRepository.saveAll(obj.getEnderecos());
            return obj;
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

// Atualiza o Endereço do Cliente
            Endereco endereco = entity.getEnderecos().get(0);

//Assumindo que há apensa um Endereço por Cliente
            endereco.setEndRua(objDto.getEndRua());
            endereco.setEndNumero(objDto.getEndNumero());
            endereco.setEndCidade(objDto.getEndCidade());
            endereco.setEndCep(objDto.getEndCep());
            endereco.setEndEstado(objDto.getEndEstado());
            endereco.setEndBairro(objDto.getEndBairro());

// Atualiza o Contato do cliente
            Contato contato = entity.getContatos().get(0);

//Assumindo que há apensa um Contato por Cliente
            contato.setConCelular(objDto.getConCelular());
            contato.setConTelefoneComercial(objDto.getConTelefoneComercial());
            contato.setConEmail(objDto.getConEmail());

// Salva as Alterações
            repository.save(entity);

            return entity;
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
                objDto.getConEmail());

        cli.getEnderecos().add(ender);
        cli.getContatos().add(contato);

        return cli;
    }

    public ClienteDTO toNewDTO(Cliente obj) {
        ClienteDTO dto = new ClienteDTO();

// Mapeie os atributos comuns entre Cliente e ClienteNewDTO
        dto.setCliId(obj.getCliId());
        dto.setCliNome(obj.getCliNome());
        dto.setCliCpf(obj.getCliCpf());
        dto.setCliStatus(dto.getCliStatus());

// Atributos específicos de Endereco
        Endereco endereco = obj.getEnderecos().get(0);
        dto.setEndRua(endereco.getEndRua());
        dto.setEndNumero(endereco.getEndNumero());
        dto.setEndCidade(endereco.getEndCidade());
        dto.setEndCep(endereco.getEndCep());
        dto.setEndEstado(endereco.getEndEstado());
        dto.setEndBairro(endereco.getEndBairro());

// Atributos específicos de Contato
        Contato contato = obj.getContatos().get(0);
        dto.setConCelular(contato.getConCelular());
        dto.setConTelefoneComercial(contato.getConTelefoneComercial());
        dto.setConEmail(contato.getConEmail());

        return dto;
    }




}