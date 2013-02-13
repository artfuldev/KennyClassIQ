rem @echo off
rem ======================================================================
rem This script will run jlaunch in debug mode. By default all messages are
rem printed in a DOS box (mode=box). As an alternative you can redirect all
rem messages to the file jlaunch_log.txt (mode=logging).
rem 
rem ======================================================================
rem 
set mode=box
rem set mode=logging
rem 
rem ======================================================================
rem 
if "%mode%" == "box" goto runBox
goto runLogging
rem 
rem ======================================================================
rem 
:runBox
.\jlaunch.exe -v
pause
goto ende
rem 
rem ======================================================================
rem 
:runLogging
.\jlaunch.exe -L
goto ende
rem 
rem ======================================================================
rem 
:ende
