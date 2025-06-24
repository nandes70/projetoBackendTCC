package org.example.services;

import dto.FornecedorDTO;
import org.example.entities.Fornecedor;
import org.example.entities.Endereco;
import org.example.entities.Contato;
import org.example.repositories.FornecedorRepository;
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
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Fornecedor findById(Long id) {
        Optional<Fornecedor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Fornecedor insert(Fornecedor obj) {
        try {
            obj.setForId(null);
            obj = repository.save(obj);
            enderecoRepository.saveAll(obj.getEnderecos());
            return obj;
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Fornecedor update(Long id, FornecedorDTO dto) {
        try {
            Fornecedor entity = findById(id);

            // Atualiza dados básicos
            entity.setForNomeFantasia(dto.getForNomeFantasia());
            entity.setForRazaoSocial(dto.getForRazaoSocial());
            entity.setForStatus(dto.getForStatus());
            entity.setForCnpj(dto.getForCnpj());

            // Atualiza Endereço (assumindo apenas um)
            Endereco endereco = entity.getEnderecos().get(0);
            endereco.setEndRua(dto.getEndRua());
            endereco.setEndNumero(dto.getEndNumero());
            endereco.setEndCidade(dto.getEndCidade());
            endereco.setEndCep(dto.getEndCep());
            endereco.setEndEstado(dto.getEndEstado());
            endereco.setEndBairro(dto.getEndBairro());

            // Atualiza Contato (assumindo apenas um)
            Contato contato = entity.getContatos().get(0);
            contato.setConCelular(dto.getConCelular());
            contato.setConTelefoneComercial(dto.getConTelefoneComercial());
            contato.setConEmail(dto.getConEmail());
            contato.setConEmailSecundario(dto.getConEmailSecundario());

            repository.save(entity);

            return entity;
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteFornecedor(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Fornecedor fromDTO(FornecedorDTO dto) {
        Fornecedor forne = new Fornecedor(null, dto.getForNomeFantasia(), dto.getForRazaoSocial(), dto.getForStatus(), dto.getForCnpj());
        Endereco ender = new Endereco(null, forne, dto.getEndRua(), dto.getEndNumero(), dto.getEndCidade(), dto.getEndCep(), dto.getEndEstado(), dto.getEndBairro());
        Contato contato = new Contato(null, forne, dto.getConCelular(), dto.getConTelefoneComercial(),
                dto.getConEmail(), dto.getConEmailSecundario());

        forne.getEnderecos().add(ender);
        forne.getContatos().add(contato);

        return forne;
    }

    public FornecedorDTO toNewDTO(Fornecedor obj) {
        FornecedorDTO dto = new FornecedorDTO();

        dto.setForId(obj.getForId());
        dto.setForNomeFantasia(obj.getForNomeFantasia());
        dto.setForStatus(dto.getForRazaoSocial());
        dto.setForCnpj(dto.getForCnpj());

        Endereco endereco = obj.getEnderecos().get(0);
        dto.setEndRua(endereco.getEndRua());
        dto.setEndNumero(endereco.getEndNumero());
        dto.setEndCidade(endereco.getEndCidade());
        dto.setEndCep(endereco.getEndCep());
        dto.setEndEstado(endereco.getEndEstado());
        dto.setEndBairro(endereco.getEndBairro());

        Contato contato = obj.getContatos().get(0);
        dto.setConCelular(contato.getConCelular());
        dto.setConTelefoneComercial(contato.getConTelefoneComercial());
        dto.setConEmail(contato.getConEmail());
        dto.setConEmailSecundario(contato.getConEmailSecundario());

        return dto;
    }
}
