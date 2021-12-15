package com.example.agency.serviceimpl;

import com.example.agency.dto.PageDto;
import com.example.agency.entity.Client;
import com.example.agency.entity.Deal;
import com.example.agency.exception.ResourceAlreadyExistsException;
import com.example.agency.exception.ResourceNotFoundException;
import com.example.agency.model.DealModel;
import com.example.agency.repository.ClientRepository;
import com.example.agency.repository.EstateRepository;
import com.example.agency.repository.DealRepository;
import com.example.agency.service.DealService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DealServiceImpl implements DealService {
    private final DealRepository dealRepository;

    private final ClientRepository clientRepository;

    @Override
    public Deal getDealById(Long id) {
        return dealRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The deal with id=" + id + " does not exist."));
    }

    @Override
    public Page<Deal> getDeal(PageDto pageDto) {
        return dealRepository.findAll(pageDto.getPageable());
    }

    @Override
    public Deal addDeal(DealModel dealModel) {
        Client client = clientRepository
                .findById(dealModel.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The client with id=" + dealModel.getClientId() + " does not exist."));

        Deal deal = new Deal(dealModel.getRealtor(), client);
        dealRepository.save(deal);
        return deal;
    }
    @Override
    public Deal updateDeal(Deal deal) {
        if (!dealRepository.existsById(deal.getId())) {
            throw new ResourceNotFoundException("The deal with id=" + deal.getId() + " does not exist.");
        }
        dealRepository.save(deal);
        return deal;
    }

    @Override
    public void deleteById(Long id) {
        dealRepository.deleteById(id);
    }
}
