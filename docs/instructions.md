# Instructions

## Build Instructions

To build PowerList, you must go to https://merced-es.github.io/power-list1/. 
Click on the button "View on GitHub" below the title. You will be directed to GitHub.com to clone the 
repository. Once you are there, click on the large green "clone" button towards the right of the page. 
Copy the SSH link by clicking on the "clipboard" button to the right of the link. Open your IntelliJ IDE
and select "Import project from Version Control". A window will pop up; paste the link into the open field
and click "Enter". The project will take a few moments to load. Once it is finished loading, click on the
green "play" button on the menu bar at the top of the screen. The project will build and your emulator will 
start to run. 

## Basic User Instructions

The first fragment of the app you will see is the login page with Google Sign-In. Once you are logged in, 
you will be directed to the home fragment. The home fragment contains two buttons taking you to your "Goals"
and your "Power Lists". 

"Goals" will get you to the goal fragment with a recycler view. The recyler view is a list of goals that can 
be edited. To edit an already existing goal, click on it and an edit dialog fragment will appear. There is
a title and description field that must be filled out to save. To create a new goal, you can click on the 
floating action button at the bottom right corner of the fragment. To return back to the home screen you
can click on the back button. 

From the home fragment, you can click on the "Power Lists" button and you will be directed to the power list fragment.
Here, there is a recycler view with lists of to-do's and powerlists. These can be edited as well just by 
clicking on them. A floating action button is at the bottom right corner of the fragment to create a new power list.
The back button will navigate you back to the home fragment. 