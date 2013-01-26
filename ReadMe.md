#Kenny ClassIQ
* Author: Kenshin Himura *(Sudarsan Balaji)*
* License: *GNU GPL v3 and CC-BY-NC-SA Licenses* (see gpl.txt and ccbyncsa.txt)
* Application Version: 0.0.0.2
* ReadMe Version: 1.0

##Description
Kenny ClassIQ *(read Kenny Classic)* is something like my dream project. It is a chess engine with pure object oriented programming with close-to-real-world representation of the game inside the program using OOPS. Initially I thought of doing a similar thing in C++, but after trying to develop my other chess engine [Kenny](https://www.github.com/kenshinthebattosai/Kenny) in this route, I found out that it is a difficult task, and switched to using Java for the programming instead. To learn how to do it, I created a similar, many-times-lesser-in-complexity project [KenTacToe](https://www.github.com/kenshinthebattosai/KenTacToe).

Having completed it successfully, I've gained the confidence to proceed with Kenny ClassIQ, named so because it is more class-oriented than Kenny, and because I want it to be intelligent. *(A play with words landed me Kenny ClassIQ.)* Also, I used this name so that people searching for my other chess engine Kenny can also find this more advanced chess engine (okay, yes, I wanted to name my chess engine Kenny, so).

##Updates

###Version 0.0.0.2
* Modified the COmmunicationProtocol interface.
* Worked on accepting XBoard commands, now the minimum commands to run the engine are properly read and identified.
* Added javadoc commentary to make sure people (myself included) understand what's going on.
* Got to know today that this engine can be 10-100 times slower than my CPP engine [Kenny](https://www.github.com/kenshinthebattosai/Kenny). Have to write better evaluation functions than in Kenny, to overcome this disadvantage.

###Version 0.0.0.1
* XBoard, UCI Classes started to be defined.
* init() functions created for both protocols.
* Unplayable, but gaining confidence that I'll learn both protocols soon.
* Added binary files for testing purposes (included executable jars and a win-32 exe to add as an engine in GUIs!)

###Version 0.0.0.0
* Started to code.
* Nothing there yet.
* First Commit.

##Visions

###Long Term
* To have a close-to-real-world representation of the game inside the program

###Short Term
* To finish defining WinBoard class, CommunicationProtocol interface properly.
* To make an executable jar (console program) capable of communicating with Arena GUI, identifying all possible xboard/winboard commands.