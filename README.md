# goeuro-devtest

```
git clone https://github.com/chrismhv/goeuro-devtest.git
cd goeuro-devtest
chmod +x gradlew
./gradlew fatJar
```
GoEuroTest.jar will be created in build/libs.
Execute it from command line using
```
java -jar GoEuroTest.jar "Berlin"
```
The csv file will be created in the same directory.

Use
```
./gradlew eclipse
```
to be able to import it in eclipse.
