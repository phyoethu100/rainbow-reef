# csc413-SecondGame

## Student Name  : Phyoe Thu
## Student ID    : 918656575


## src folder is to be used to store source code only.

## resources folder is to be used to store the resources for your project only. This includes images, sounds, map text files, etc.

## jar folder is used to store the built jar of your term-project. NO SOURCE CODE SHOULD BE IN THIS FOLDER. DOING SO WILL CAUSE POINTS TO BE DEDUCTED

## ABOUT THE GAME:

The project was made in IntelliJ IDEA 2019.3.2 with the Java version 1.8. The current working directory of the game is Start class, which is the main class that runs the game. The resources with all the images and sounds are under resource folder. The source codes are under Rainbow Reef package in src folder.

To run the jar, you also need to download the resources that are inside the jar folder and then use this command to run the jar: java -jar csc413-secondgame-phyoethu100.jar.

This game is based on the Super Rainbow Reef game with galaxy and space theme using different graphics and images. The goal of this game is for Pop to hit all three BigLegs in order to move onto next level. There are two levels and once the player hits all three BigLegs from level two, he/she will win the game and once the player loses all the lives, he/she will lose the game. Since there is no direct control over Pop’s movement, he will bounce freely around the map except the base. The collision with Katch will determine the direction of Pop’s bounce. If bounces toward left on Katch, then Pop will bounce to left and same goes for right. There are also two power ups in the game which can give an extra life and an extra copy of Pop. 

Left and right arrows are used to control the movement of Katch horizontally and spacebar is to bounce off Pop and start the game. 

There are different blocks: blocks that only need to be hit once, blocks that need to be hit twice, a block that need to be hit three times, blocks that are solid, walls that are unbreakable, and two power up blocks that can give extra Pop and extra life. All the breakable blocks need to be in red, blue or green in order to break it. For orange block, it will change to red block. For light blue block, it will change to blue block. For yellow block, it will change to green block. Four purple block, it will change to light blue and then it will change to blue block once being hit. 

The player has four lives and once the player loses all lives, he/she will lose the game and “Game Over” will pop up on the screen and once the player reaches level 2 and hits all three BigLegs, then he/she will win the game and "Congratulations" will display on the screen.
