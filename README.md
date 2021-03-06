# ToyCAD
Simplified AutoCAD application
I made this program to learn more about OOP concepts.
There is also a fun aspect of visualisation to it.

![Alt Text](https://media.giphy.com/media/iIwQ6r5kgKMhnqUSWA/giphy.gif)

### Prerequisites
Compiles with Java 8.
Color display doesn't work for windows cmd prompt (use console emulator).

### How to use:
Run the JAR with PATH = ToyCAD.jar path:
```
java -jar <PATH>
```

After running you will be prompt with the controls guide.
Some basic controls for example:
Create new shape:

    -   new circle color x y radius
    >>> Creates new circle with center at (x,y) and radius.

Print the sketch to the screen:


    -   print width height
    >>> Prints a visualisation to the screen.
    >>> width is the number of characters in a line.
    >>> height is the number of lines.

### Notes:
Currently this program supports only 6 shapes and 4 colors:
* Ellipse, Circle, Parallelogram, Square, Rectangle, Triangle.
* Red, Green, Blue, Yellow.
* No support for overlapping shapes.
* Support for one project per program.

### Example:

Running these commands:
```
new triangle blue 0 0 1 1 2 0
print 80 25
new triangle red 0 1.5 1 1 2 1.5
print 80 25
new triangle green 2 0 1 1 2 1.5
print 80 25
new triangle yellow 0 1.5 1 1 0 0
print 80 25
```

Will yield 4 triangles with a vertex always pointing to the center:

![Alt Text](https://media.giphy.com/media/J0BiKXD1ediQvbtdwb/giphy.gif)