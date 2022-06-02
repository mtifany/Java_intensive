rm -rf target
mkdir target
cp -R src/resources ./target
javac src/java/edu/school21/printer/*/*.java -d ./target

jar cfm ./target/images-to-chars-printer.jar ./src/manifest.txt -C target .
chmod 777 target/images-to-chars-printer.jar
java -jar target/images-to-chars-printer.jar . 0

#java -cp target edu.school21.printer.app.Program . 0 /Users/mtifany/Downloads/it.bmp


