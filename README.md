# CanvasDraw

**Build the Application:**
Navigate to the project root directory: $ mvn clean install

**Run the Application:**
Navigate to the project /target directory: java -jar CanvasDrawing.jar

**Test the Application:**
Sample Run

Below is a sample run of the program. User input is prefixed with enter command:

enter command: C 20 4
--------------------
|                  |
|                  |
|                  |
|                  |
--------------------

enter command: L 1 2 6 2
--------------------
|                  |
|xxxxxx            |
|                  |
|                  |
--------------------

enter command: L 6 3 6 4
--------------------
|                  |
|xxxxxx            |
|     x            |
|     x            |
--------------------

enter command: R 14 1 18 3
--------------------
|             xxxxx|
|xxxxxx       x   x|
|     x       xxxxx|
|     x            |
--------------------

enter command: B 10 3 o
--------------------
|oooooooooooooxxxxx|
|xxxxxxooooooox   x|
|     xoooooooxxxxx|
|     xoooooooooooo|
--------------------

enter command: L 6 4 13 4
--------------------
|oooooooooooooxxxxx|
|xxxxxxooooooox   x|
|     xoooooooxxxxx|
|     xxxxxxxxooooo|
--------------------

enter command: B 1 2 .
--------------------
|oooooooooooooxxxxx|
|......ooooooox   x|
|     .oooooooxxxxx|
|     ........ooooo|
--------------------

enter command: Q
