#Kenny ClassIQ
* Author: Kenshin Himura *(Sudarsan Balaji)*
* License: *GNU GPL v3 and CC-BY-NC-SA Licenses* (see gpl.txt and ccbyncsa.txt)
* Application Version: 0.0.1.0 (Unplayable)
* ReadMe Version: 1.2

##Description
Kenny ClassIQ *(read Kenny Classic)* is something like my dream project. It is a chess engine with pure object oriented programming with close-to-real-world representation of the game inside the program using OOPS. Initially I thought of doing a similar thing in C++, but after trying to develop my other chess engine [Kenny](https://www.github.com/kenshinthebattosai/Kenny) in this route, I found out that it is a difficult task, and switched to using Java for the programming instead. To learn how to do it, I created a similar, many-times-lesser-in-complexity project [KenTacToe](https://www.github.com/kenshinthebattosai/KenTacToe).

Having completed it successfully, I've gained the confidence to proceed with Kenny ClassIQ, named so because it is more class-oriented than Kenny, and because I want it to be intelligent. *(A play with words landed me Kenny ClassIQ.)* Also, I used this name so that people searching for my other chess engine Kenny can also find this more advanced chess engine (okay, yes, I wanted to name my chess engine Kenny, so).

##Updates

###Version 0.0.1.0
* Fixed issues #44, #45.
* Added *Game* commentary.
* Added *showBoard()* to *Game*.
* Modified *toString()* of *Move*.
* Modified *getShortAlgebraicNotation()* of *Piece*.

###Version 0.0.0.9
* Added *printBoard()*
* Added *Board, Square* commentary.
* Fixed issues #43, #46.
* Tested Branch-Merge.

###Version 0.0.0.8
* Complete *PieceSet*, with full commentary.
* Improved *Diagonals, Ranks, Files, Board*.
* Added commentary and re-organized *Main*.
* Solved issues #20, #21, #22.

###Version 0.0.0.7
* Removed nesting of *Square* in *Board*.
* Re-organized the *com.kenny.classiq.board* package.
* Improved *Board*, pending comments.
* Improved *Square*, pending comments.
* Added *PieceSet*, with comments.
* Re-organized *Move*.
* Added *Player*, with full commentary.

###Version 0.0.0.6
* Started coding for *Game*.
* Added *Move*, fully commented.
* Improved *Piece*, pending comments.
* Improved *Board.Square*, pending comments.

###Version 0.0.0.5
* Added *Piece* commentary.
* Re-organized the source into different packages.
* Added derived classes from *Piece* representing each piece.
* Playable versions to start from __*version 0.1*__

###Version 0.0.0.4
* Added *setFeatures()* function in the *XBoard* class.
* Added javadoc commentary for *Definitions*.
* Created uciConsole inside *XBoard* to facilitate switching in case of auto-detection.
* Added execute function definitions in *XBoard*.

###Version 0.0.0.3
* Started defining *Piece*, *Board*, and *Square*.
* Included *Definitions*.
* Modified *CommunicationProtocol* interface, again(!).
* Modified *XBoard* communication and included error messages.
* All code from this version will by default carry javadoc commentary.

###Version 0.0.0.2
* Modified the *CommunicationProtocol* interface.
* Worked on accepting *XBoard* commands, now the minimum commands to run the engine are properly read and identified.
* Added javadoc commentary to make sure people (myself included) understand what's going on.
* Got to know today that this engine can be 10-100 times slower than my CPP engine [Kenny](https://www.github.com/kenshinthebattosai/Kenny). Have to write better evaluation functions than in Kenny, to overcome this disadvantage.

###Version 0.0.0.1
* *XBoard*, *UCI* (classes, if names are in *PascalCase* hereafter) started to be defined.
* init() functions created for both protocols.
* Unplayable, but gaining confidence that I'll learn both protocols soon.
* Added binary files for testing purposes (included executable jars and a win-32 exe to add as an engine in GUIs!)

###Version 0.0.0.0
* Started to code.
* Nothing there yet.
* First Commit.

##Goals

###Long Term
* To have a close-to-real-world representation of the game inside the program

###Short Term
* To finish defining *XBoard* class, *CommunicationProtocol* interface properly.
* To finish defining only the necessary things for a game, ie, *Square, Piece*, etc, and atleast play random moves.
* To finish defining *Game*.
* To finish adding commentary to all uploaded files.
* To make an executable jar (console program) capable of communicating with Arena GUI, identifying all possible xboard/winboard commands.