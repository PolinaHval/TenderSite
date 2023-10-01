package org.teachmeskills.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.teachmeskills.dto.CreateTenderDto;
import org.teachmeskills.model.Organization;
import org.teachmeskills.model.Tender;
import org.teachmeskills.model.Victory;
import org.teachmeskills.repository.TenderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TenderService {

  private final TenderRepository tenderRepository;
  private final OrganizationService organizationService;

  public Page<Tender> findPaginatedAllTenders(int pageNo, int pageSize) {
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
    return tenderRepository.findAll(pageable);
  }

  public void createTender(CreateTenderDto createTenderDto, Organization organization) {
    final Tender tender = Tender.builder()
        .subject(createTenderDto.getSubject())
        .shortDescription(createTenderDto.getShortDescription())
        .valuta(createTenderDto.getValuta())
        .amount(createTenderDto.getAmount())
        .unitOfMeasurement(createTenderDto.getUnitOfMeasurement())
        .unitPrice(createTenderDto.getUnitPrice())
        .totalCost(createTenderDto.getTotalCost())
        .termsOfPayment(createTenderDto.getTermsOfPayment())
        .deliveryConditions(createTenderDto.getDeliveryConditions())
        .organizationTenders(organization)
        .build();
    tenderRepository.save(tender);
  }

  public List<Tender> getListTenders(long organizationId) {
    return organizationService.findOrganizationById(organizationId).orElseThrow().getTenders();
  }

  public Optional<Tender> findTenderById(int tenderId) {
    return tenderRepository.findTenderById(tenderId);
  }

  public Tender getTenderById(int tenderId) {
    return tenderRepository.getTenderById(tenderId);
  }

  public void deleteTender(Tender tender) {
    tenderRepository.delete(tender);
  }
}
