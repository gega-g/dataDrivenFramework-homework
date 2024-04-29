package ge.tbc.tbcitacademy.util;

import java.util.Random;

public class GeneratePhoneNumber {
    Random random = new Random();
    public String generatePhoneNumber() {
        int randomNumber = random.nextInt(900000000) + 1000000000;
        return Integer.toString(randomNumber);
    }
}