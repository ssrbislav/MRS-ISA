package com.airftn.AirFTN.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.PricelistDTO;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Pricelist;
import com.airftn.AirFTN.repository.PricelistRepository;

@Service
@Transactional
public class PricelistService implements IPricelistService {
	
	@Autowired
	PricelistRepository pricelistRepository;	
	
	@Autowired
	AirlinecompanyService airlineService;

	@Override
	public List<Pricelist> findAll() {
			
		return pricelistRepository.findAll(); 
	}

	@Override
	public Pricelist getOne(Long id) {
		
		return pricelistRepository.getOne(id);
	}

	@Override
	public Pricelist create(PricelistDTO pricelist, Long companyId) {
		
		AirlineCompany company = airlineService.getOne(companyId);

		Pricelist priceList = new Pricelist();
//		priceList.setPriceByKm(pricelist.getPriceByKm());
		priceList.setEconomyPricePrecentage(pricelist.getEconomyPricePrecentage());
		priceList.setBussinessPricePrecentage(pricelist.getBussinessPricePrecentage());
		priceList.setFirstPricePrecentage(pricelist.getFirstPricePrecentage());
		priceList.setDiscountedPrecentage(pricelist.getDiscountedPrecentage());
		priceList.setAirline(company);
		
		return pricelistRepository.save(priceList);
	
	}

	@Override
	public Pricelist update(Pricelist pricelist) {
		
		Pricelist priceList = pricelistRepository.getOne(pricelist.getId());
		
//		priceList.setPriceByKm(pricelist.getPriceByKm());
		priceList.setEconomyPricePrecentage(pricelist.getEconomyPricePrecentage());
		priceList.setBussinessPricePrecentage(pricelist.getBussinessPricePrecentage());
		priceList.setFirstPricePrecentage(pricelist.getFirstPricePrecentage());
		priceList.setDiscountedPrecentage(pricelist.getDiscountedPrecentage());
		priceList.setDeleted(pricelist.isDeleted());
		
		return pricelistRepository.save(priceList);
	}

	@Override
	public Pricelist getByAirlineId(Long id) {

		AirlineCompany company = airlineService.getOne(id);
		
		Pricelist pricelist = company.getPricelist();
	
		return pricelist;
	}

	
	
}
