# A Simple Platformer
Assignment 2

[![YouTube](https://img.youtube.com/vi/BknMMHymF6k/0.jpg)](https://www.youtube.com/watch?v=BknMMHymF6k)

# Keys to control player :
up arrow: jump

left arrow: move left

right arrow: move right

#Team info
Team name : Calvin
Team members : Calvin Ho

#Project description
I used the eclipse ide to develop a game in java.
The game is a simple 2d platformer game. I used Jframe and Graphics2D to develop this game.
The game works by creating a player instance that can move using the arrow keys.
The getbounds() methods returns the 4 rectangles used to define the players hitbox. If any of the rectangles intersects an object it will preform some action.
The player begins with 5 lives. If the player runs out of lives it will send the player back to level 1.




The map files are read in from a txt file. Reading each character, spawning a block depending on the number in the txt file.
The diffent blocks in the game are:

Block: player will sit on top of a block or will not allow the player pass through it.
Mblock: same as block but it moves. It moves the player along with the Mblock movement.
Obstacle: causes players to loose life and respawn.
Enemy: player will kill enemy the bottom of player collides with enemy. If left, right or top of player collides it causes a life loss.
Flag: The objective of the game. If the player collides with a flag it proceeds to the next level.


#Member contribution
I worked as an individual on this project.

