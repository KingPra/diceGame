package com.kpr.dice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiceController {

	@GetMapping("/")
	public String getIndexPage(Model model, Cup cup) {
		model.addAttribute("amount", cup);
		return "index";
	}

	@PostMapping("/")
	public String rollDice(@ModelAttribute Cup cup, Model model) {
		int total = shakeCup(cup.isLoaded(), cup.getAmount());
		model.addAttribute("total", total);
		model.addAttribute("cup", cup);

		System.out.println("dice is " + cup.isLoaded());
		System.out.println("dice is " + cup.getDice());
		System.out.println("cup is = " + cup.toString());
		System.out.println("cup is = " + cup.getAmount());
		return "index";
	}

	public int dice() {
		int rand = (int) (Math.random() * 6) + 1;
		return rand;
	}

	public int loadedDice() {
		int[] diceArr = { 1, 3, 2, 3, 3, 4, 3, 5, 3, 6, 3 };
		int i = (int) (Math.random() * diceArr.length);
		return diceArr[i];
	}

	public int shakeCup(boolean isLoaded, int amount) {
		int total = 0;
		if (isLoaded) {
			for (int i = 0; i < amount; i++) {
				total += loadedDice();

			}
			return total;
		} else {
			for (int i = 0; i < amount; i++) {
				total += dice();
			}
			return total;
		}
	}

}
