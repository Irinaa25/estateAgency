package com.example.agency.serviceimpl;

import com.example.agency.dto.PageDto;
import com.example.agency.entity.Client;
import com.example.agency.entity.Estate;
import com.example.agency.exception.ResourceAlreadyExistsException;
import com.example.agency.exception.ResourceNotFoundException;
import com.example.agency.model.EstateModel;
import com.example.agency.repository.ClientRepository;
import com.example.agency.repository.EstateRepository;
import com.example.agency.service.EstateService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstateServiceImpl implements EstateService {
    private final EstateRepository estateRepository;

    private final ClientRepository clientRepository;

    @Override
    public Estate getEstateById(Long id) {
        return estateRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The estate with id=" + id + " does not exist."));
    }

    @Override
    public Page<Estate> getEstate(PageDto pageDto) {
        return estateRepository.findAll(pageDto.getPageable());
    }

    @Override
    public Estate addEstate(EstateModel estateModel) {
        Client client = clientRepository
                .findById(estateModel.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The client with id=" + estateModel.getClientId() + " does not exist."));
        if (estateRepository.existsByName(estateModel.getName())) {
            throw new ResourceAlreadyExistsException("The estate with such name already exists.");
        }
        Estate estate = new Estate(estateModel.getName(),  estateModel.getEstate_type(), estateModel.getPrice(), estateModel.getYear_construction(), estateModel.getArea(), client);
        estateRepository.save(estate);
        return estate;
    }
    @Override
    public Estate updateEstate(Long id, EstateModel estateModel) {
        if (!estateRepository.existsById(id))
        {
            throw new ResourceNotFoundException("The estate with id="+id+"doesn't exist.");
        }
        Client client = clientRepository.findById(estateModel.getClientId()).orElseThrow(() -> new ResourceNotFoundException(
                "The client with id="+estateModel.getClientId()+"doesn't exist"));
        Estate estate = new Estate(id, estateModel.getName(), estateModel.getEstate_type(),estateModel.getPrice(), estateModel.getArea(), estateModel.getYear_construction(), client);
        estateRepository.save(estate);
        return estate;
    }

    @Override
    public void deleteById(Long id) {
        estateRepository.deleteById(id);
    }
}
