package com.kpr.dice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cup {

	private int amount;
	private int dice;
	private boolean isLoaded;
	private int total;
}
