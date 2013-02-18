#Kenny ClassIQ
* Author: Kenshin Himura *(Sudarsan Balaji)*
* License: *GNU GPL v3* (see COPYING.txt)
* Latest Application Version: 0.3 build 3238 *([Version History](Version%20History.md#version-history))*
* Latest Stable Version: [0.2](https://www.sourceforge.net/projects/kennyclassiq)
*([Versioning](Versioning.md#versioning))*
* ReadMe Version: 2.5

##Description

Kenny ClassIQ *(read Kenny Classic)* is something like my dream project. It is a chess engine with pure object oriented programming with close-to-real-world representation of the game inside the program using OOPS. Initially I thought of doing a similar thing in C++, but after trying to develop my other chess engine [Kenny](https://www.github.com/kenshinthebattosai/Kenny) in this route, I found out that it is a difficult task, and switched to using Java for the programming instead. To learn how to do it, I created a similar, many-times-lesser-in-complexity project [KenTacToe](https://www.github.com/kenshinthebattosai/KenTacToe).

Having completed it successfully, I've gained the confidence to proceed with Kenny ClassIQ, named so because it is more class-oriented than Kenny, and because I want it to be intelligent. *(A play with words landed me Kenny ClassIQ.)* Also, I used this name so that people searching for my other chess engine Kenny can also find this more advanced chess engine (okay, yes, I wanted to name my chess engine Kenny, so).

##Features
(Features refer to existing features in the latest stable version only).

(Words in italics represent class names)

Game-breaking features (why you *can't* play against it now):

* Plays only fixed search depth : 2 half moves mode.
* Does not know about draws or 3 move repetitions, but can find mate in 1 (because search depth is only 2, you see).
* Does not do promotion evaluation and search properly. Engine mostly crashes when thinking about promotions.

Niceties under the hood (why you *should* play against it later):

* Multi-protocol support: *UCI* and *WinBoard*.
* Better, human-like thinking planned, instead of boring, best, engine-like play.
* Better *Move* system *(Players make Moves in the Game)*.
* Alpha Beta Principal Variation Search implemented fully. Also collects the PV.
* Automatic *MoveList* of *Game* updation.
* Better *printMainLine()* implementation.
* Better *FEN* implementation.
* Better-than-ever *Console* implementation, with *synchronized* reader, listener and executor threads.

Other features yet to come! :D

##Branching
* *[master](https://github.com/kenshinthebattosai/KennyClassIQ)* contains the latest minor revision.
* *[majrev](https://github.com/kenshinthebattosai/KennyClassIQ/tree/majrev)* contains the latest major revision.
* *[stable](https://github.com/kenshinthebattosai/KennyClassIQ/tree/stable)* contains the latest stable code *(minor version)*.
* *[working](https://github.com/kenshinthebattosai/KennyClassIQ/tree/minrev)* contains the latest code.

##Goals

###Long Term
* To have a close-to-real-world representation of the game inside the program

###Short Term
* To add king safety.
* To fix promotion bug.
* To add timing controls.
* To finish adding commentary to all uploaded files.