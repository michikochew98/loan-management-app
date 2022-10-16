package com.michiko.lendingengine.domain.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;

@Entity
public class Balance {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ElementCollection
	@MapKeyClass(Currency.class)
	@OneToMany(targetEntity = Money.class, cascade = CascadeType.ALL)
	private Map<Currency, Money> moneyMap = new HashMap<>();

	public void topUp(final Money money) {
		if(moneyMap.get(money.getCurrency()) == null) {
			moneyMap.put(money.getCurrency(), money);
		} else {
			moneyMap.put(money.getCurrency(), 
					moneyMap.get(money.getCurrency()).add(money));
		}
	}
	
	public void withdraw(final Money money) {
		final Money moneyInBalance = moneyMap.get(money.getCurrency());
		if(moneyInBalance == null) {
			throw new IllegalStateException();
		} else {
			moneyMap.put(money.getCurrency(), 
					moneyMap.get(money.getCurrency()).minus(money));
		}
	}

	public Map<Currency, Money> getMoneyMap() {
		return moneyMap;
	}

	public void setMoneyMap(Map<Currency, Money> moneyMap) {
		this.moneyMap = moneyMap;
	}
	
	
}
