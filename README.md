# Calculator
This is my calculator app for Android. I hope you like it!
'Calculator' and 'Calculator2' should have been in the same project, but none of them wants to contain all the files. One project contains the files that the other is missing.

VERSION 2:
I tried to implement a clean architecture where everything is separated. Heavily inspired by this project https://github.com/BracketCove/KotlinMVPCalculator and the youtube videos that belong to it.
This did not work perfectly for me, as the input and output is not working atm.
I also did not implement a unit test. 

VERSION 1:
----Description of my solution---- 

The app consists of one activity, which is activity_main. This activity has two layouts, One for the display, where we can see the buttons we have pressed and the result, and one for the buttons. The button layout is a tablelayout. When a button is pressed, the string tv_userInput is expanded to include the symbol of the button, if it is a number or an operator. When the "="-button is pressed, the sstring is turned into an expression that can be evaluated. To do this, I included a third party library (https://www.objecthunter.net/exp4j/index.html#Tag_Library). A string is returned to tv_userResult.text, which will then be presented on the screen.


----What I am most proud of---- 

I am proud that I managed to find the cause of the bugs I encountered along the way. There were three big issues that I had to solve.
 - The first was that the buttons in the layout disappered for no reason. This I solved by editing the radius in the drawable files for the buttons. Previousely, I had defined the radius for each individual corner, now they are all defined at once. 

 - The second large bug was caused by a poor color reference, where I had chosen one of the colours that Android studio suggested to me for the background. This caused the app to crash when launched

 - The third large bug was a problem in the manifest file, and the app couldn't be installed. 

With a lot of help from Google, and some thinking, I managed to solve all of these problems in the end. 

I am also proud of some of the details. While in the app, the status bar has one of the app colours. When switching between apps, the bar with my calculator app has the blue app colour. This was not hard to do, but I still think it is pretty neat.
Lastly, I am proud that I managed to implement (almost, se below) all the functions that I wanted with regards to the buttons. 


----What I could have done better---- 

Now, all the functions that the app run are in the file MainActivity.kt. To make it tidier, they should have been in a seperate file.
I tried to make sure that if an operator is pressed right after another, the old one would be replaced by the new one. This does not work at the moment. The whole addInput function is quite messy and should have been better. 
The symbols on the buttons are now given by a text, it could have looked better if they had been images, like the backspace button.  


----What I would work on more if I had the time---- 

With more time, I would improve on the things that I am not happy with at the moment/ the things I could have done better.
I would try to find a better addInput () and Iwould also spend time to resolve the warnings that the compiler gives me.
It would also be nice if my calculator could have some more functions like square root and %. 
I would play around more with the layout as I had many ideas. Some of them had a very unlinear layout, and to try and recreate one like this could be a fun challenge.
With more time, I would also do the unit test.

If you have any questions, please ask! :)
