package bullscows;

import java.util.*;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String finalKey = "";
    private static String guess = "";
    private static int count = 1;

    public static void grader() {
        String turns = String.format("Turn %d:", count++);
        System.out.println(turns);
        guess = scanner.nextLine();
        char[] guessChars = guess.toCharArray();
        char[] keyChars = finalKey.toCharArray();
        String returnVal = "";
        int bulls = 0;
        int cows = 0;
            for (int i = 0; i < keyChars.length; i++) {
                if (guessChars[i] == keyChars[i]) {
                    bulls++;
                    continue;
                }
                for (int j = 0; j < keyChars.length; j++) {
                    if (guessChars[j] == keyChars[i] && j != i) {
                        cows++;
                        continue;
                    }
                }
            }
            if (cows == 0 && bulls != 0) {
                returnVal = String.format("Grade: %d bull(s)", bulls);
            } else if (bulls == 0 && cows != 0) {
                returnVal = String.format("Grade: %d cow(s)", cows);
            } else if (cows == 0 && bulls == 0) {
                returnVal = String.format("Grade: None");
            } else if (cows != 0 && bulls != 0) {
                returnVal = String.format("Grade: %d bull(s) and %d cow(s)", bulls, cows);
            }
        System.out.println(returnVal);
    }

    public static void generateCode() {
        System.out.println("Input the length of the secret code:");
        String sLengthKey = scanner.nextLine();
        if (!sLengthKey.matches("[0-9]+$") || sLengthKey.charAt(0) == '0') {
            String errorKey = String.format("error: %s isn't a valid number.", sLengthKey);
            System.out.println(errorKey);
            System.exit(1);
        }
        int lengthKey = Integer.parseInt(sLengthKey);
        System.out.println("Input the number on possible symbols in the code:");
        int lengthSymbols = scanner.nextInt();
        if (lengthSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(1);
        }
        if (lengthKey > lengthSymbols) {
            String errorString = String.format("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", lengthKey, lengthSymbols);
            System.out.println(errorString);
            System.exit(1);
        }
        char charMax;
        if (lengthSymbols <= 10) {
            charMax = '\0';
        } else {
            lengthSymbols -= 11;
            charMax = (char) (lengthSymbols + 97);
        }
        scanner.nextLine();
        if (lengthKey > 36) {
            System.out.println("Error: can't generate a secret number with a length greater then 36 too complex!");
            System.exit(1);
        }
        Random rand = new Random();
        StringBuilder key = new StringBuilder();
        char randomVal = 'Z';
        List<Character> charList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < lengthKey; i++) {
            int randomChoose = Math.abs(rand.nextInt() % 2);
            if(randomChoose == 0 && lengthSymbols > 10) {
                randomVal = (char) (Math.abs(rand.nextInt() % lengthSymbols) + 97);
                while (charList.contains(randomVal) || count == 0) {
                    randomVal = (char) (Math.abs(rand.nextInt() % lengthSymbols) + 97);
                    count++;
                }
                charList.add(randomVal);
            } else {
                randomVal = (char) (rand.nextInt(9) + 48);
                while (charList.contains(randomVal) || count == 0) {
                    randomVal = (char) (rand.nextInt(9) + 48);
                    count++;
                }
                charList.add(randomVal);
            }
            key.append(randomVal);
        }
        finalKey = String.valueOf(key);
        StringBuilder codeStars = new StringBuilder();
        for (int i = 0; i < lengthKey; i++) {
            codeStars.append("*");
        }
        String codeReady = String.format("The secret is prepared: %s (0-9, a-%c).", codeStars, charMax);
        System.out.println(codeReady);
        System.out.println("Okay, let's start a game!");
    }

    public static void main(String[] args) {
        generateCode();
        while (!guess.contentEquals(finalKey)) {
            grader();
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }
}