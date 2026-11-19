@echo off
if not exist out mkdir out
javac -encoding UTF-8 -d out src\visitorevoluido\*.java test\visitorevoluido\*.java
echo ===== Programa =====
java -cp out visitorevoluido.Main
echo.
echo ===== Testes =====
java -cp out visitorevoluido.TesteVisitorEvoluido
pause
