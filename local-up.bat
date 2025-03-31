@echo off
cd /d "%~dp0"
gradle bootRun --args="--spring.profiles.active=local"
pause
