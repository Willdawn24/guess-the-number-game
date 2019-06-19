# Make a draw project #

Make-a-draw project is a simple console version of a drawing program. 

## Requirement ##
* Java 11
* Maven
* Lombok Plugin

### Overview ##
The functionality of the program is limited as follows:

1. Create a canvus
2. Create draw on the canvus by different command
3. Quit the program

### Assumptions Made ###
1. Canvus is rectanglar area with integer width and height. Any draw outside the area of canvus will not be displayed.
2. Line and Rectangle command should accept four integer arguments, and are created at coordinate specified by the first two argument. The coordinate to create should be at upperleft side of the ending coordinate, specified by the last two argument. 
3. Line and Rectangle length should be at least two.
4. Vertical and horizontal borders of canvus are displayed by character '-' and '|'. Lines and boundaries of rectangle are displayed by character 'x'. Filling command can use other character other than the three characters.

### Command ###
|Command|Description|
|---|---|
|C w h|Should create a new canvas of width w and height h.|
|L x1 y1 x2 y2|Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.|
|R x1 y1 x2 y2|Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.|
|B x y c|Should fill the entire area connected to (x,y) with "colour" c. The behavior of this is the same as that of the "bucket fill" tool in paint programs.|
|Q|Should quit the program.|

### Install and Run ###
```
cd ${directory/console/target}
java -jar console-1.0-SNAPSHOT.jar
or
mvn clean install
```

