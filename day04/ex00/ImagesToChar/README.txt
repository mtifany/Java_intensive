rm -rf target
mkdir target
javac src/java/edu/school21/printer/*/*.java -d ./target
java -cp target edu.school21.printer.app.Program . 0 /Users/mtifany/Downloads/it.bmp

