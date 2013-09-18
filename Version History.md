#Kenny ClassIQ
* Author: Kenshin Himura *(Sudarsan Balaji)*
* License: *GNU GPL v3* (see COPYING.txt)
* Latest Application Version: 0.3 build 3238
* Latest Stable Version: [0.2](https://www.sourceforge.net/projects/kennyclassiq) *([Versioning](Versioning.md#versioning))*
* Version History Document Version: 1.6

##Version History

####Version 0.3 (3238)
* Fixed a lot of issues.
* Fixed improper PV.
* Fixed invalid moves being made (white made moves twice consecutively).
* Corrected problem with *isChecked()*.
* Corrected error in Quiescence Search where it would call itself repeatedly if score is greater than 300 centipawns after a capture, leading to engine crash.
* Added proper PV collection, normal alphaBetaPVS and alphaBetaPVS with PV collection and corrected bugs in quiescence search.
* Reduced fixed search depth to 2 half moves.
* Added separate getMaterialScore() function to improve move-ordering immediately after generation.
* AI still buggy when dealing with promotion-related moves, but bug relating to castling where rooks would not be moved in the internal board fixed.
* Lots of stability improvements and bugfixes, which should have made separate versions (like 0.2.1) have been refined and finally ended up in 0.3

####Version 0.2 (2771)
* Lots of bugfixes.
* Added evaluation.
* Added minimax search with alpha-beta pruning.
* Corrected UCI output.
* Corrected *Executor* errors.
* Renamed threads.
* Corrected issues #151, #152.
* Engine now plays okay-okay moves with 3 depths (fixed for now, will be dynamic later).
* No time-related implementation.
* Made *protocolType of Main* public so output strings can be properly formatted according to the GUI.
* Re-added the boolean newCommand in *Command*.
* Corrected errors in *makeMove() and unMakeMove()* which did not implement proper castling.
* Implemented Quicksort in move ordering.
* Removed Windows executables and added jLaunch executable. (32-bit only)

#####Version 0.1.3 (2198)
* Fixed issues #144 and #150.
* Corrected errors in enPassantSquare generation.
* Corrected errors in isChecked().
* Added scores.
* Added MakeBestMove ability..
* Added *MakeBestMoveTest*, to test it.
* Made various bugfixes and improvements.

#####Version 0.1.2 (2156)
* Fixed issues #142, #146, and #147
* Added proper UCI support.
* Added enPassant Move Generation.
* Updated debug messages.

#####Version 0.1.1 (2097)
* Fixed #143.
* Fixed buggy *UCI* driver, now both *UCI and WinBoard* drivers are at the same level.
* Added and implemented support for *d* command, which can be used to display the stats of the *Game*.
* Improved *Game, Executor, UCIExecutor and XBoardExecutor*.
* Added *printStats()* to *Game*.
* Optimized *Move* construction.
* Corrected major issue with promotion moves' setting of moveString.

####Version 0.1 (2081) - First Playable Version (nickname *Shinta*)
* Tested a thousand times. Playable, doesn't crash. First stable release.
* Simply plays the first move it can find. Don't expect searches or evaluations in the first playable version.
* Added legal-move-checking. Was a huge pain, but my efforts weren't in vain.
* Improved *Player, Game, Board, AI, Move, Executor, XBoardExecutor, UCIExecutor,* and probably any class you can name.
* Plays legal move it generates.
* Can Play both sides.
* Can play in both *UCI* and *XBoard* modes.
* Fixed lots of major crashes.
* Fixed lots of errors in the undocumented builds. Woah! Took me a hell of a time to clear all those.
* Made installer and hosted it on sourceforge.

#####Version 0.0.17 (1698)
* Improved *Player*.
* Added promotion moves to *Pawn*.
* Improved *Move* for promotion.
* Improved *XBoard, Uci*.
* Improved *Player*'s *makeMove()* for promotion.
* Changed version output.
* Changed exe's and names.
* Included jlaunch.

#####Version 0.0.16 (1677)
* Yes, the updates are coming in a frenzy!
* Added basic UCI support. Now engine supports both UCI and XBoard
* Improved *Player*.
* Improved *AI*.
* Improved *Game*.
* Improved *FENTest*.
* Improved *XBoardExecutor*.
* Tested a lot! Even Demo mode in "Arena" works now!

#####Version 0.0.15 (1453)
* Made the engine playable.
* Improved *Player*.
* Improved *Executor*
* Improved *XBoardExecutor* by adding implementations for *new, usermove and setboard*.
* Improved *Game*.
* Improved *QueenMoveGenTest*.
* Added *getMove()* to *AI*.
* Added *GetMoveTest*, a jUnit Test Case.


#####Version 0.0.14 (1236)
* Removed *Diagonal*.
* Removed instances of *Diagonal* from *Board*.
* Improved *Piece*.
* Added missing commentary for the newly implemented move generation functions, including those in *Square and Piece*.

######Version 0.0.13.5 (1221)
* Added move generation for *Queen*.
* Added *QueenMoveGenTest*, a jUnit Test Case to test if the move generator works properly.

######Version 0.0.13.4 (1203)
* Added move generation for *Rook*.
* Added *RookMoveGenTest*, a jUnit Test Case to test if the move generator works properly.

######Version 0.0.13.3 (1187)
* Optimized certain functions of *Piece*.
* Added move generation for *Bishop*.
* Improved *Knight*.
* Added *BishoPMoveGenTest*, a jUnit Test Case.

######Version 0.0.13.2 (1145)
* Improved and optimized move generation of *King* and *Pawn*.
* Added *Knight* move generation.
* Improved *Piece*.
* Added *KnightMoveGenTest*, a jUnit Test Case.

######Version 0.0.13.1 (1123)
* Improved *Move*.
* Improved *Piece,Pawn*.
* Added move generation for *King*.
* Added *KingMoveGenTest*, a jUnit Test Case.

#####Version 0.0.13 (1099)
* Improved *Square*.
* Improved *Move, Game and Piece*.
* Changed moveOutput.
* Corrected certain function definitions.
* Corrected certain comment blocks.
* Added *PawnMoveGenTest*, a jUnit Test Case.

######Version 0.0.12.4 (1086)
* Modified *Square*.
* Improved *Board*.
* Corrected minor errors in *Move*.
* Improved *Rank, File*.
* Added a lot of new methods.
* Added *OccupiedSquaresTest* and *CanMoveToTest*, jUnit Test Cases.

######Version 0.0.12.3 (1061)
* Added all missing javadoc commentary.
* Fixed issue #116.
* Improved *Square, Move and Player*.

######Version 0.0.12.2 (1056)
* Fixed issue #113.
* Made *makeMove() and  unMakeMove* to set and reset *enPassantSquare* of *Game*.
* Modified identification of *Pawn* in various places.
* Improved *MakeMoveTest* to include *enPassantSquare* implementation test.

######Version 0.0.12.1 (1004)
* Fixed issue #112.
* *makeMove() and unMakeMove()* now set and reset *castlingRights* of *Game*.
* Improved *Move, Player and Game*.
* Improved *MakeMoveTest* jUnit Test Case.

#####Version 0.0.12 (990)
* Yep, a major jump! Added *FEN* implementation, fixed issue #51.
* Updated *Game* construction to use FEN strings.
* Removed defualt *Game* constructor.
* Removed *setupBoard()* from *Game*.
* Removed *halfMoveNumber* from *Game*.
* Added *moveNumber, enPassantSquare, and castlingRights* to *Game*.
* Added *startPositionFEN* to *Definitions*.
* Updated *Player* to support *moveNumber* instead of *halfMoveNumber*.
* Added *FENTest* jUnit Test Case, to showcase FEN implementation.

#####Version 0.0.11 (930)
* Added *halfMoveClock* for FEN and 50-Moves Rule.
* Improved *Move*.
* Improved *makeMove() and unMakeMove()* to work with the change.
* Added *HalfMoveTest*.

######Version 0.0.10.3 (911)
* Improved *halfMoveNumber* of *Game*.
* Fixed issue #104.
* Added ability of players to change the *halfMoveNumber* when they make a  *Move*.
* Improved *MakeMoveTest*, the *jUnit Test Case*.
* Added *printMainLine* to *Game*.

######Version 0.0.10.2 (892)
* Corrected *setFeatures* output.
* Removed redundant "feature" output.
* Changed when *Executor* executes.

######Version 0.0.10.1 (876)
* Improved *moveList* of *Game*, made it an *ArrayList*.
* Implemented updation of *moveList* in *Game* with every *makeMove()* and *unMakeMove()* of *Player*.
* Made jUnit Test Case *MakeMoveTest* capable of testing this updation.

#####Version 0.0.10 (853)
* Added *makeMove()*.
* Added *unMakeMove()*.
* Improved *Game*.
* Improved *Board*.
* Fixed issue #62.

######Version 0.0.9.2 (797)
* Updated *UCI*.
* Updated *UCIExecutor*.
* Updated *XBoard*, removed uciConsole.
* Fixed issue #58

######Version 0.0.9.1 (773)
* Fixed issue #91.
* Deleted *newCommand* and added *commandArray*.
* Greatly improved *XBoard* driver implementation.
* Added debug messages when unimplemented commands are met with.

#####Version 0.0.9 (748)
* Reopened issue #64.
* Removed *legalMove*, only legal moves should be generated, so not required.
* Added *capturingMove*.
* Added proper *Move* commentary.
* Added improved *MoveTest (jUnit Test Case)*.

######Version 0.0.8.4 (722)
* Added *checkingMove*.
* Added *matingMove*.
* Added *legalMove*.
* Improved *Player, Move, XBoardExecutor*.
* Fixed issue #64.

######Version 0.0.8.1 (697) - 0.0.8.3 (712)
* Added *Executor* commentary.
* Added *UCIExecutor* commentary.
* Added *XBoardExecutor* commentary.
* Added *Listener* commentary.
* Added *InputThread* commentary.
* Added *GUIConsole* commentary.
* Improved *XBoard* and *UCI*.
* Fixed issue #4.

#####Version 0.0.8 (693)
* Fixed issues #84,#85,#87
* Rewrote large volumes of code to implement new console interaction.
* Added *InputThread, Listener, Executor, GUIConsole*.
* Added *UCIExecutor, XBoardExecutor*.

######Version 0.0.7.1 (482) - 0.0.7.3 (511)
* Modified *start()* of *XBoard* to allow for listening.
* Various optimizations.
* Inputs from console still buggy.
* Stilll missing certain commands from console, raised issue.

#####Version 0.0.7 (476)
* Changed *System.console().readLine()* to *BuffereedReader* reading.
* Major code revisions on implementation of *input reading* from the console.
* Added *validate()* to validate input commands from the console.
* Improved *listen()* of *XBoard*.
* Re-organized *com.kenny.classiq.protocols*
* Wrote *GUIConsole*
* Wrote *InputThread*

######Versions 0.0.6.2 (342) - 0.0.6.5 (397)
* Modified *Xboard* to properly read *protover 2*.
* Changed *Scanner.nextLine()* to *System.console().readLine()*.
* Fixed various memory leaks and redundant input-console-read issues.

######Version 0.0.6.1 (323)
* Made *Scanner* a member of *Xboard*.
* Made *commandString* and *cmdString* members of *XBoard*.
* Modified *init*() of *Xboard*.

#####Version 0.0.6 (317)
* Greatly enhanced *Move*.
* Added full commentary to *Move*.
* Implemented a lot of ways to construct a *Move*.
* Fixed issue #77
* Added jUnit test for *Move*. Worked great!
* Improved *Game*.
* Greatly improved *Board*.

######Version 0.0.5.3 (266)
* Added messages before start.

######Version 0.0.5.2 (264)
* Removed *KennyClassIQ.exe*
* Added x86 exe.
* Added x64 exe.

######Version 0.0.5.1 (256)
* Fixed issue #69
* Corrected *GUI, User* registering as *AI*.
* Modified *Versioning* and *Version History Document*.

#####Version 0.0.5 (253)
* Added *AI* from *Player*.
* Added *User* from *Player*.
* Added *GUI* from *Player*.
* Reorganized *com.kenny.classiq.players*
* Reorganized *com.kenny.classiq.game*

######Version 0.0.4.4 (225)
* Added *halfMoveNumber* to take care of turns in *Game*.

######Version 0.0.4.3 (221)
* Fixed issues #44, #45.
* Added *Game* commentary.
* Added *showBoard()* to *Game*.
* Modified *toString()* of *Move*.
* Modified *getShortAlgebraicNotation()* of *Piece*.

######Version 0.0.4.2 (192) 
* Added *printBoard()*
* Added *Board, Square* commentary.
* Fixed issues #43, #46.
* Tested Branch-Merge.

######Version 0.0.4.1 (174)
* Complete *PieceSet*, with full commentary.
* Improved *Diagonals, Ranks, Files, Board*.
* Added commentary and re-organized *Main*.
* Solved issues #20, #21, #22.

#####Version 0.0.4 (156)
* Removed nesting of *Square* in *Board*.
* Re-organized the *com.kenny.classiq.board* package.
* Improved *Board*, pending comments.
* Improved *Square*, pending comments.
* Added *PieceSet*, with comments.
* Re-organized *Move*.
* Added *Player*, with full commentary.

#####Version 0.0.3 (140)
* Started coding for *Game*.
* Added *Move*, fully commented.
* Improved *Piece*, pending comments.
* Improved *Board.Square*, pending comments.

######Version 0.0.2.2 (121)
* Added *Piece* commentary.
* Re-organized the source into different packages.
* Added derived classes from *Piece* representing each piece.
* Playable versions to start from __*version 0.1*__

######Version 0.0.2.1 (89)
* Added *setFeatures()* function in the *XBoard* class.
* Added javadoc commentary for *Definitions*.
* Created uciConsole inside *XBoard* to facilitate switching in case of auto-detection.
* Added execute function definitions in *XBoard*.

#####Version 0.0.2 (71)
* Started defining *Piece*, *Board*, and *Square*.
* Included *Definitions*.
* Modified *CommunicationProtocol* interface, again(!).
* Modified *XBoard* communication and included error messages.
* All code from this version will by default carry javadoc commentary.

######Version 0.0.1.1 (51)
* Modified the *CommunicationProtocol* interface.
* Worked on accepting *XBoard* commands, now the minimum commands to run the engine are properly read and identified.
* Added javadoc commentary to make sure people (myself included) understand what's going on.
* Got to know today that this engine can be 10-100 times slower than my CPP engine [Kenny](https://www.github.com/kenshinthebattosai/Kenny). Have to write better evaluation functions than in Kenny, to overcome this disadvantage.

#####Version 0.0.1 (34)
* *XBoard*, *UCI* (classes, if names are in *PascalCase* hereafter) started to be defined.
* init() functions created for both protocols.
* Unplayable, but gaining confidence that I'll learn both protocols soon.
* Added binary files for testing purposes (included executable jars and a win-32 exe to add as an engine in GUIs!)

###Version 0 (17)
* Started to code.
* Nothing there yet.
* First Commit.

