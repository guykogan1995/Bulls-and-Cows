# Bulls and Cows Game

This is a text-based implementation of the Bulls and Cows game written in Java. The game generates a secret code consisting of digits and/or lowercase letters. The player needs to guess the code within a certain number of turns by making guesses and receiving feedback on the correctness of their guesses.

## How to Play

1. The game generates a secret code based on the specified length and number of possible symbols.

2. The player needs to make guesses by entering a code of the same length as the secret code.

3. After each guess, the game provides feedback in the form of bulls and cows:
   - A "bull" represents a correct symbol in the correct position.
   - A "cow" represents a correct symbol in the wrong position.

4. Based on the feedback, the player can make subsequent guesses to narrow down the possibilities and eventually guess the correct code.

5. The game continues until the player guesses the correct code or reaches the maximum number of turns.

## Running the Game

To run the Bulls and Cows game, follow these steps:

1. Ensure you have Java installed on your system.

2. Download or clone the repository containing the code.

3. Compile the `Main.java` file using the Java compiler:
   ```
   javac Main.java
   ```

4. Run the compiled code:
   ```
   java Main
   ```

5. The game will start, and you can follow the prompts on the command line to play.

## Example Gameplay

Here's an example of how a Bulls and Cows game session might look:

```
Input the length of the secret code:
4
Input the number of possible symbols in the code:
6
The secret is prepared: **** (0-9, a-f).
Okay, let's start a game!
Turn 1:
1234
Grade: 1 bull(s) and 2 cow(s)
Turn 2:
5678
Grade: None
Turn 3:
abcdef
Grade: None
Turn 4:
45ab
Grade: 2 bull(s)
Turn 5:
4a56
Grade: 1 bull(s)
Turn 6:
4a5c
Grade: 2 bull(s)
Turn 7:
4a5d
Grade: 3 bull(s)
Turn 8:
4a5e
Grade: 4 bull(s)
Congratulations! You guessed the secret code.
```

## Contributions

Contributions to this Bulls and Cows game implementation are welcome. If you find any issues or have suggestions for improvements, feel free to create a pull request or submit an issue in the repository.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to modify and distribute the code as per the terms of the license.

## Author

This Bulls and Cows game implementation was developed by Guy Kogan.
