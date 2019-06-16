package com.airftn.AirFTN.dto;

import javax.validation.constraints.NotBlank;

public class PricelistDTO {

	@NotBlank
	private Double luggagePrice;

	@NotBlank
	private Double economyPricePrecentage;
	@NotBlank
	private Double bussinessPricePrecentage;

	@NotBlank
	private Double firstPricePrecentage;

	@NotBlank
	private Double discountedPrecentage;

	public PricelistDTO() {
	}

	public PricelistDTO(@NotBlank Double luggagePrice, @NotBlank Double economyPricePrecentage,
			@NotBlank Double bussinessPricePrecentage, @NotBlank Double firstPricePrecentage,
			@NotBlank Double discountedPrecentage) {
		super();
		this.luggagePrice = luggagePrice;
		this.economyPricePrecentage = economyPricePrecentage;
		this.bussinessPricePrecentage = bussinessPricePrecentage;
		this.firstPricePrecentage = firstPricePrecentage;
		this.discountedPrecentage = discountedPrecentage;
	}

	public Double getLuggagePrice() {
		return luggagePrice;
	}

	public void setLuggagePrice(Double luggagePrice) {
		this.luggagePrice = luggagePrice;
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
