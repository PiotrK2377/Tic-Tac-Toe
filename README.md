# TIC - TAC - TOE
The game has 2 versions: displayed in the console and with a graphical interface using JavaFX.

## 1.Project goal:
 - Creating a simple game of tic-tac-toe.

## 2.Technologies and tools:
 - JavaFX

## 3.Application features
 - Playing with the computer,
 - Choice of board size 3x3 or 10x10,
   
   ![BoardsChoose](./src/main/resources/templates/pictures/Start%20Game%201.png)
 - Board 3x3,
   
   ![Board3x3](./src/main/resources/templates/pictures/Board%20%203x3%20Win.png)
 - On a 10x10 board, victory occurs with 5 adjacent symbols in a straight line,
   
   ![Board10x10](./src/main/resources/templates/pictures/Board%2010x10%20Win.png)
 - Rest Game button resets the board starting a new game on that board,
 - The New Game button starts a new game with an initial message about choosing a board size,
 - Exit Game button displays a message confirming that the application has ended,
   
   ![End Game](./src/main/resources/templates/pictures/End%20game%20chosse.png)
 - Scoreboard displays the player's counted victories.

## 4.Setup
 - Open a terminal on your computer
 - Select the directory where you will copy the repository with the command: `cd path/to/your/directory`
 - Type the git clone command and paste the URL of the repository: `git clone https://github.com/PiotrK2377/Tic-Tac-Toe.git`
 - Open the cloned program using Intelij or another program of the same type
 - In the program terminal, use the command `.\gradlew build` to build the project
 - To launch the game with a graphical interface, use the command: `.\gradlew run`

