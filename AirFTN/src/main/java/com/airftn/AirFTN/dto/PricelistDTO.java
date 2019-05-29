package com.airftn.AirFTN.dto;

import javax.validation.constraints.NotBlank;

public class PricelistDTO {

	@NotBlank
	private Double priceByKm;

	@NotBlank
	private Double economyPricePrecentage;
	@NotBlank
	private Double bussinessPricePrecentage;

	@NotBlank
	private Double firstPricePrecentage;

	@NotBlank
	private Double discountedPrecentage;

	public PricelistDTO(@NotBlank Double priceByKm, @NotBlank Double economyPricePrecentage,
			@NotBlank Double bussinessPricePrecentage, @NotBlank Double firstPricePrecentage,
			@NotBlank Double discountedPrecentage) {
		super();
		this.priceByKm = priceByKm;
		this.economyPricePrecentage = economyPricePrecentage;
		this.bussinessPricePrecentage = bussinessPricePrecentage;
		this.firstPricePrecentage = firstPricePrecentage;
		this.discountedPrecentage = discountedPrecentage;
	}

	public Double getPriceByKm() {
		return priceByKm;
	}

	public void setPriceByKm(Double priceByKm) {
		this.priceByKm = priceByKm;
	}

	public Double getEconomyPricePrecentage() {
		return economyPricePrecentage;
	}

	public void setEconomyPricePrecentage(Double economyPricePrecentage) {
		this.economyPricePrecentage = economyPricePrecentage;
	}

	public Double getBussinessPricePrecentage() {
		return bussinessPricePrecentage;
	}

	public void setBussinessPricePrecentage(Double bussinessPricePrecentage) {
		this.bussinessPricePrecentage = bussinessPricePrecentage;
	}

	public Double getFirstPricePrecentage() {
		return firstPricePrecentage;
	}

	public void setFirstPricePrecentage(Double firstPricePrecentage) {
		this.firstPricePrecentage = firstPricePrecentage;
	}

	public Double getDiscountedPrecentage() {
		return discountedPrecentage;
	}

	public void setDiscountedPrecentage(Double discountedPrecentage) {
		this.discountedPrecentage = discountedPrecentage;
	}

}
