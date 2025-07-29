package org.example.services;

import dto.FornecedorDTO;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.entities.Fornecedor;
import org.example.repositories.FornecedorRepository;
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
            return repository.save(obj); // Cascade deve cuidar de salvar contatos/endereços
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Fornecedor update(Long id, FornecedorDTO Objdto) {
        try {
            Fornecedor entity = findById(id);

            entity.setForNomeFantasia(Objdto.getForNomeFantasia());
            entity.setForRazaoSocial(Objdto.getForRazaoSocial());
            entity.setForStatus(Objdto.getForStatus());
            entity.setForCnpj(Objdto.getForCnpj());

            // Atualiza ou cria endereço
            if (entity.getEnderecos().isEmpty()) {
                Endereco novoEndereco = new Endereco(null, entity,
                        Objdto.getEndRua(), Objdto.getEndNumero(),
                        Objdto.getEndCidade(), Objdto.getEndCep(),
                        Objdto.getEndEstado(), Objdto.getEndBairro());
                entity.getEnderecos().add(novoEndereco);
            } else {
                Endereco endereco = entity.getEnderecos().get(0);
                endereco.setEndRua(Objdto.getEndRua());
                endereco.setEndNumero(Objdto.getEndNumero());
                endereco.setEndCidade(Objdto.getEndCidade());
                endereco.setEndCep(Objdto.getEndCep());
                endereco.setEndEstado(Objdto.getEndEstado());
                endereco.setEndBairro(Objdto.getEndBairro());
            }

            // Atualiza ou cria contato
            if (entity.getContatos().isEmpty()) {
                Contato novoContato = new Contato(null, entity,
                        Objdto.getConCelular(), Objdto.getConTelefoneComercial(),
                        Objdto.getConEmail(), Objdto.getConEmailSecundario());
                entity.getContatos().add(novoContato);
            } else {
                Contato contato = entity.getContatos().get(0);
                contato.setConCelular(Objdto.getConCelular());
                contato.setConTelefoneComercial(Objdto.getConTelefoneComercial());
                contato.setConEmail(Objdto.getConEmail());
                contato.setConEmailSecundario(Objdto.getConEmailSecundario());
            }

            return repository.save(entity);
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

    public Fornecedor fromDTO(FornecedorDTO objDto) {
        Fornecedor forne = new Fornecedor(null, objDto.getForNomeFantasia(), objDto.getForRazaoSocial(), objDto.getForCnpj(), objDto.getForStatus()
        );


        Endereco ender = new Endereco(null, forne,
                objDto.getEndRua(), objDto.getEndNumero(),
                objDto.getEndCidade(), objDto.getEndCep(),
                objDto.getEndEstado(), objDto.getEndBairro());

        Contato contato = new Contato(null, forne,
                objDto.getConCelular(), objDto.getConTelefoneComercial(),
                objDto.getConEmail(), objDto.getConEmailSecundario());

        forne.getEnderecos().add(ender);
        forne.getContatos().add(contato);

        return forne;
    }

    public FornecedorDTO toNewDTO(Fornecedor obj) {
        FornecedorDTO dto = new FornecedorDTO();

        dto.setForId(obj.getForId());
        dto.setForNomeFantasia(obj.getForNomeFantasia());
        dto.setForRazaoSocial(obj.getForRazaoSocial());
        dto.setForStatus(obj.getForStatus());
        dto.setForCnpj(obj.getForCnpj());

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
