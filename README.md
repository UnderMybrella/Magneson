# Magneson
An image based esoteric language written in Kotlin

## Run
To run a Magneson program, download the parser [here](https://storage.googleapis.com/brella-archives/ci/magneson/Magneson-latest.jar), and run it with `java -jar Magneson-latest.jar <program path here>`.
If no path is provided, the parser will wait for a line of input to read the path from, and then proceed.

## Structure
Magneson programs are composed of many differently coloured pixels, and the colour of those pixels determines the function to run.
These functions are broken down into "palettes", and are used in different scenarios. The default palette is used normally, while the Integer palette is used for integers, and the String palette for strings.

|   Color   |  Scope   | Function |
| --------- | -------- | -------- |
| (0, 0, 0) | COMMAND  | Print the proceeding string to STDOUT |
| (0, 0, 1) | COMMAND  | Print the proceeding string to STDOUT, followed by a newline |
| (0, 1, 0) | COMMAND  | Assign a string to a string variable. Takes two strings - the variable name, and the variable value |
| (0, 1, 1) | COMMAND  | Assign an int to an int variable. Takes one string (the variable name) and one int (the variable value) |
| (0, 2, 0) | ALL      | Get a string from a string variable. Takes one string (the variable name). When used independently of a string requirement, print the value out followed by a newline |
| (0, 2, 1) | ALL      | Get an int from an int variable. Takes one string (the variable name). When used independently of an int requirement, print the value out followed by a newline |
| (0, 3, 0) | ALL      | Reverse a string in a string variable. Takes one string (the variable name) |
| (0, 4, 0) | COMMAND  | Append a string to a string variable. Takes two strings - the variable name, and the string to append |
| (0, 5, 0) | COMMAND  | Prepend a string to a string variable. Takes two strings - the variable name, and the string to prepend |
| (0, 6, 1) | STR_REQ  | Converts an integer to a string. Takes an int (the int to convert ot a string) |
| (0, 7, 0) | INT_REQ  | Get the length of a string. Takes a string (the variable name) |
| (0, 8, 0) | COMMAND  | Add an int to an int variable. Takes a string (the variable name) and an int (the value to add) |
| (0, 9, 0) | COMMAND  | Subtract an int from an int variable. Takes a string (the variable name) and an int (the value to subtract) |
| (0, 10, 0) | COMMAND  | Multiply an int variable by an int. Takes a string (the variable name) and an int (the value to multiply by) |
| (0, 11, 0) | COMMAND  | Divide an int variable by an int. Takes a string (the variable name) and an int (the value to divide by) |
| (0, 12, 0) | COMMAND  | Get the remainder of dividing an int variable by another int. Takes a string (the variable name) and an int (the value to divide by) |
| (0, 13, 0) | COMMAND  | Add a string to a string list. Takes two strings - the variable name, and the string to add |
| (0, 13, 1) | COMMAND  | Add an int to an int list. Takes a string (the variable name) and an int (the value to add) |
| (0, 15, 0) | COMMAND  | Get a string from a string list, and assign it to a string variable. Takes two strings (the string list variable name, and the string variable name) and an int (the index) |
| (0, 15, 0) | STR_REQ  | Get a string from a string list. Takes a string (the variable name) and an int (the index) |
| (0, 15, 1) | COMMAND  | Get an int from an int list, and assign it to an int variable. Takes two strings (the string list variable name, and the string variable name) and an int (the index) |
| (0, 15, 1) | STR_REQ  | Get an int from an int list. Takes a string (the variable name) and an int (the index) |
| (1, 0, 0) | COMMAND  | Start a simple for loop. Takes an int (number of times to loop) |
| (1, 0, 1) | COMMAND  | Mark the end of a simple for loop |
| (1, 0, 2) | COMMAND  | Break out of the current simple for loop |
| (1, 1, 0) | COMMAND  | Compare two strings, and run the following code if the statement is true. Takes two strings |
| (1, 1, 1) | COMMAND  | Compare two ints, and run the following code if the statement is true. Takes two ints |
| (1, 1, 254) | COMMAND  | Run the following code if the corresponding IF statement (`1, 1, 0` or `1, 1, 1`) was false |
| (1, 1, 255) | COMMAND  | End the IF and ELSE blocks |
| (255, 255, 0) | COMMAND | Remove all command pixels that are not part red. Takes an int, which is the red value to compare against |
| (255, 255, 1) | COMMAND | Remove all command pixels that are not part green. Takes an int, which is the green value to compare against |
| (255, 255, 2) | COMMAND | Remove all command pixels that are not part blue. Takes an int, which is the blue value to compare against |
| (255, 255, 3) | COMMAND | Remove all command pixels that are not part alpha. Takes an int, which is the alpha value to compare against |
| (255, 255, 4) | COMMAND | Remove all command pixels that are not fully red |
| (255, 255, 5) | COMMAND | Remove all command pixels that are not fully green |
| (255, 255, 6) | COMMAND | Remove all command pixels that are not fully blue |
| (255, 255, 7) | COMMAND | Remove all command pixels that are not fully opaque |
| (255, 255, 8) | COMMAND | Remove all command pixels that are fully red |
| (255, 255, 9) | COMMAND | Remove all command pixels that are fully green |
| (255, 255, 10) | COMMAND | Remove all command pixels that are fully blue |
| (255, 255, 11) | COMMAND | Remove all command pixels that are fully opaque |
| (255, 255, 12) | COMMAND | Remove all command pixels that are any part red |
| (255, 255, 13) | COMMAND | Remove all command pixels that are any part green |
| (255, 255, 14) | COMMAND | Remove all command pixels that are any part blue |
| (255, 255, 15) | COMMAND | Remove all command pixels that are any part alpha |
| (255, 255, 16) | COMMAND | Use the alpha component of the command pixels to determine the new pixel values, and therefore the new commands |
| (255, 255, 254) | COMMAND | Exit the program
| (255, 255, 255) | COMMAND | Pass