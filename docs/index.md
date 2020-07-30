# Power List

## Introduction

Power List is an app designed for the user wanting to make daily progressions toward their goals. 
Studies have shown that you become 42% more likely to 
achieve your goals just by writing them down on a regular basis. Creating a check list 
with three to five essential tasks to complete every day is what we call a "Power List". Any progress is
 a step in the right direction, and "Power List" will help organize your goals and any plans to achieve them.

The functionalities of the app include a check list and a file uploader. 
A check list is essentially what we call the "Power List". The file uploader is used for uploading 
photos of whatever it is that you are working towards. These photos will display on your list of goals.

>* Check List
>* File uploader

## Elements

####- [Instructions](https://github.com/Merced-es/power-list1/blob/master/docs/instructions.md)
> * Build instructions
> * Basic User Instructions
####- [Wireframe Diagram](wireframe.md)
####- [ERD Diagram](erd.md)
####- [Entity Classes](https://github.com/Merced-es/power-list1/tree/master/app/src/main/java/edu/cnm/deepdive/powerlist1/model/entity)
####- [DAO Interfaces](https://github.com/Merced-es/power-list1/tree/master/app/src/main/java/edu/cnm/deepdive/powerlist1/model/dao)
####- [Database Class](https://github.com/Merced-es/power-list1/blob/master/app/src/main/java/edu/cnm/deepdive/powerlist1/service/ListDatabase.java)
####- [Repository Classes](https://github.com/Merced-es/power-list1/tree/master/app/src/main/java/edu/cnm/deepdive/powerlist1/service)
####- [Dependencies](https://github.com/Merced-es/power-list1/blob/master/app/build.gradle)
####- [Copyrights & Licenses](https://github.com/Merced-es/power-list1/blob/master/docs/notice.md)

### Intended Users

A college student with a part-time job and involved in extra-curricular activities.
   > As a busy college student, I need an app that will allow me to check off the most important things I need
to get done each day before I go to sleep.

Someone who wants to lose 15 lbs by Thanksgiving.
   > As someone who wants to lose some weight by Thanksgiving, I am looking for an app that will 
keep track of my weight loss goal and document a taskList of what I need to do to get there.

A mother who is planning a birthday party for her son.
   > As a mother who wants to throw her son a fishing birthday party next month, 
I need to save all of my party ideas in one place, so I am not so overwhelmed and trying to buy everything the day before.

An interior designer with a collection of ideas.
   > As an interior designer, I have a million and one ideas for the visions my clients have
for their homes, and I need a check list for my "To-Do's" each day 
project I am working on, so I complete my projects on time.

### Summary of Current State of The App

The app is currently in a compiling state. The user can navigate from the home fragment to the goal fragment
and the powerlists fragment. The goals fragment directs the user to the goal edit fragment that is in working 
condition. The goals fragment and goal edit fragment are complete. Navigation to the powerlists fragment works,
however, the data created in the database is not displaying. I was unable to figure out how to get it to
display. The data has been added to the Listdatabase class. The floating action button on the powerlists fragment
does work. An edit dialog fragment will appear, and you can type into the title and description fields, but
the created list does not save or display on the recycler view.

The Google Sign in service code has been created in the app, however a key was not generated. I was unable to 
figure out how to implement the option drop down in the top right corner of the screen to give a "Sign Out" option. 
This implementation is in an imcomplete state.

I would like to complete the powerlist recycler view so the lists are displayed. The code is created, but I am 
missing something that displays this data. 
A few improvements I'd like to make to this app are adding an options button to the top right corner 
of each fragment that allows the user to "Sign Out". I'd like to add a time stamp to the goals and powerlists 
that are created so the use can see when their ideas were created. 

Some stretch goals I have are to implement items into my powerlists that allow the use to check off as they 
complete them. This will allow the user to be proactive in the app and give them a sense of accomplishment. 
I also want to link the powerlists to the goals. In the data I have added to the listdatabase, I have matched the titles
of the goals and powerlists so they could eventually link. I could implement an autocomplete idea into 
the title field when the user creates a title in each fragment. A file uploader is another stretch goal that I'd like
to implement into the powerlists.

### Design documentation

- [Wireframe Diagram](wireframe.md)
- [ERD Diagram](erd.md)

### Device-based Services

* [Google Sign-In](https://developers.google.com/identity/sign-in/android/start-integrating)

> Google Sign In will allow you to sign into your account giving you access to your power lists from anywhere. 
>This service will be required to use the app.
