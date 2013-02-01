#Kenny ClassIQ
* Author: Kenshin Himura *(Sudarsan Balaji)*
* License: *GNU GPL v3 and CC-BY-NC-SA Licenses* (see gpl.txt and ccbyncsa.txt)
* Latest Application Version: 0.0.04.03 build 221
* Latest Stable Version: -.--
* Version History Document Version: 1.1

##Version History
###Version 0.00.04.03 (221)
* Fixed issues #44, #45.
* Added *Game* commentary.
* Added *showBoard()* to *Game*.
* Modified *toString()* of *Move*.
* Modified *getShortAlgebraicNotation()* of *Piece*.

###Version 0.00.04.02 (192) 
* Added *printBoard()*
* Added *Board, Square* commentary.
* Fixed issues #43, #46.
* Tested Branch-Merge.

###Version 0.00.04.01 (174)
* Complete *PieceSet*, with full commentary.
* Improved *Diagonals, Ranks, Files, Board*.
* Added commentary and re-organized *Main*.
* Solved issues #20, #21, #22.

###Version 0.00.04.00 (156)
* Removed nesting of *Square* in *Board*.
* Re-organized the *com.kenny.classiq.board* package.
* Improved *Board*, pending comments.
* Improved *Square*, pending comments.
* Added *PieceSet*, with comments.
* Re-organized *Move*.
* Added *Player*, with full commentary.

###Version 0.00.03.00 (140)
* Started coding for *Game*.
* Added *Move*, fully commented.
* Improved *Piece*, pending comments.
* Improved *Board.Square*, pending comments.

###Version 0.00.02.02 (121)
* Added *Piece* commentary.
* Re-organized the source into different packages.
* Added derived classes from *Piece* representing each piece.
* Playable versions to start from __*version 0.1*__

###Version 0.00.02.01 (89)
* Added *setFeatures()* function in the *XBoard* class.
* Added javadoc commentary for *Definitions*.
* Created uciConsole inside *XBoard* to facilitate switching in case of auto-detection.
* Added execute function definitions in *XBoard*.

###Version 0.00.02.00 (71)
* Started defining *Piece*, *Board*, and *Square*.
* Included *Definitions*.
* Modified *CommunicationProtocol* interface, again(!).
* Modified *XBoard* communication and included error messages.
* All code from this version will by default carry javadoc commentary.

###Version 0.00.01.01 (51)
* Modified the *CommunicationProtocol* interface.
* Worked on accepting *XBoard* commands, now the minimum commands to run the engine are properly read and identified.
* Added javadoc commentary to make sure people (myself included) understand what's going on.
* Got to know today that this engine can be 10-100 times slower than my CPP engine [Kenny](https://www.github.com/kenshinthebattosai/Kenny). Have to write better evaluation functions than in Kenny, to overcome this disadvantage.

###Version 0.00.01.00 (34)
* *XBoard*, *UCI* (classes, if names are in *PascalCase* hereafter) started to be defined.
* init() functions created for both protocols.
* Unplayable, but gaining confidence that I'll learn both protocols soon.
* Added binary files for testing purposes (included executable jars and a win-32 exe to add as an engine in GUIs!)

###Version 0.00.00.00 (17)
* Started to code.
* Nothing there yet.
* First Commit.

