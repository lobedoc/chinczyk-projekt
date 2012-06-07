package com.ludo.game.other;

import java.util.Random;

public class SixRoll implements Roll{

		@Override
		public int roll() {
			Random random = new Random();
			int roll = random.nextInt(6) + 1;
			return roll;
		}
}
