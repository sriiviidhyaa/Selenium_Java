@echo off
cd /d "%~dp0"

REM === Get browser parameter from Jenkins ===
set BROWSER=%1

echo Running tests on browser: %BROWSER%

echo Compiling Java test files...
javac -d bin -cp "lib/*" src\testNG\*.java

echo Running Selenium TestNG tests...
java -Dbrowser=%BROWSER% -cp "bin;lib/*" org.testng.TestNG testng.xml

echo Test execution completed.
pause
