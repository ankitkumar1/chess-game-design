# chess-game-design. A console based java application

# Chessboard:
The chessboard is an 8 x 8 grid with 64 cells in it.
With 8 rows (A, B, C…. H) and 8 columns (1, 2, 3…. 8), each cell can be uniquely  identified with its cell number
* In 2D array context: A cell with celNo D5 will be represented at [3, 3]

Objective of this application
-------------------------------
simulate the movement of each unique chess piece on an empty chessboard.
• Input – The input string to your program will be the Type of chess piece and
        its Position (cell number) on the chessboard. E.g. “King D5”
• Output – Once you execute the program, the output will be a string of all
        possible cells in which the chess piece can move. "D6, E6, E5, E4, D4, C4, C5, C6"

# Setup
Step1: Download the zip and import the java project in eclipse.

# Bootstrap class
        BootStrap.java
# Model Classes
Piece.java (abstract and super class for all the pice types)
      ---| King.java
      ---| Queen.java
      ---| Bishop.java
      ---| Horse.java
      ---| Rook.java
      ---| Pawn.java

Cell.java  -> Wrapper around x and y coordinate value.
ConvertedRequest.java -> Class to store converted request
# Service classes
  ChessPlayService.java
  RequestValidator.java
# Factory class
        PieceFactory.java -> to create Piece instance based on input type
# Test class
   ChessPlayServiceTest.java

Additional API/jars:
 - Add junit5 libraries in the classpath


