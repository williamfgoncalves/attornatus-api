package com.example.attornatusapi.service;

import com.example.attornatusapi.dto.ClienteDTO;
import com.example.attornatusapi.entity.ClienteEntity;
import com.example.attornatusapi.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final ModelMapper modelMapper;

    public List<ClienteDTO> listar() {
        return Stream.of(clienteRepository.findAll())
                .toList()
                .stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    public ClienteDTO consultarPorId(final Long id) {
        final ClienteEntity entity = clienteRepository.findById(id)
                .orElse(new ClienteEntity());

        return modelMapper.map(entity, ClienteDTO.class);
    }

    public void criar(ClienteDTO clienteDTO) {
        final ClienteEntity entity = modelMapper.map(clienteDTO, ClienteEntity.class);

        clienteRepository.save(entity);
    }

    public void alterar(Long id, ClienteDTO clienteDTO) {
        final Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);

        if (clienteEntity.isPresent()) {
            ClienteEntity entity = clienteEntity.get();
            entity = modelMapper.map(clienteDTO, ClienteEntity.class);
            clienteRepository.save(entity);
        }
    }
}
