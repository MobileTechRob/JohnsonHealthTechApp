# Workout List App - Coding Assignment

## Overview

Welcome! This assignment is designed to evaluate your Android development skills, including your ability to work with JSON data, build clean UI, implement user interactions, and write testable, maintainable code.

You'll build an Android app that reads a local JSON file and displays a list of workouts. Users should be able to edit workout details.
You'll have one week to complete this assignment. While we understand everyone works at their own pace, we recommend spending no more than 4–6 hours on it. We’re not looking for a fully polished or production-ready app.  So, focus on clean, understandable code and demonstrating your thought process.

---

## ✨ Requirements

### Core Functionality

1. **Load & Display Workouts**
   - Load the provided JSON file (`workouts.json`).
   - Display the list of workouts in a scrollable list.

2. **Edit Workouts**
   - Users should be able to tap on a workout to view and edit its details in a separate screen.
   - Changes should be retained in-memory during the session.
---

## 🛠 Technical Expectations

- Use **Kotlin** or **Java** as the base language.
- Use **Jetpack Compose** or **XML** for UI.
- Add **unit tests** and/or **UI tests** to validate core functionality.

---

## 🎯 Bonus Points

- Persist workout changes.
- Deliver a polished and responsive UI.
- Scalable code structure.

---

## 🧪 Testing

Please include tests for:
- JSON parsing and data modeling
- Core logic (e.g., editing and updating workout details)
- UI interaction (if applicable)

---

## 📝 Developer Notes

Please fill out the section below before submitting your solution.

### What did you focus on and why?
- First Technology Spike (because it been 10 years since i looked at Android studio. i did have basis Kotlin project to work off out):
- Get a simple list view going with a simple list  .. show a sign of life for basic requirements 
- Then  bring the json file and get deserialized 
- Then start working on the layout.  At first I wanted a nice side by side 
    Label: Text  approach but that was eating time i decided to got with
      - Label
      - Text
    - because the requirements said nothing pretty on the UI.
- I then  switched to a scroll view that caused me grief in catching  the item  selected 
    setup initially see i switched back to  List view.  The ListView does scroll. Duh !
-  Then i started building the second screen and used the same
   - Label
   - EditText approach
-  I build the Edit Workout screen on label and one value at a time to make sure for methodical 
    testing.
- Once that completed,  i struggled with getting the call back to work.  I had save button but 
   then found the
   resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result : ActivityResult ->
- When importing ActivityResult, i saw that there are two imports to choose from and research that and used correct one
    ...androidx.   Once I got that working, then I started think about saving updates to the file a bit more.
- Then I introduced the Repository object for a single source of storage across intents in the app. I got that working.  I like the use of lambdas that i did.
- Once I got this far. My mind started absorbing more of what i just did.
- Once I got the core functionality going and cleaned up old code.. I looked at unit test and started 
  finding ways to bring them in.  Coming from  the C# world where everything I build is an class object,
  this way experience was different.
- towards the end, I got the settings to perist.  I do like the way Android handles some file operations over .NET MAUI. 
- there is an edit check for duration..can only be a number or else it can't be saved. My own special touch.


### What would you improve with more time?
-  clean up the UI a little more

### How did you approach testing?
- I had kept it in the back of my mind but coming MSTest world, everything is different in Android Studio.
- I found a way to separate out the update logic back to the database and the parsiing of the file into objects.

### Time Spent
   I put in more than the 4-6 hours because i really wanted to prove myself to produce an app to your basic requirements.
   I had a barely functional app at 6 hours. 

## 📁 Provided Files

- `workouts.json`
- `README.md`

---
## Deployment
I did check everything into Git.
- https://github.com/MobileTechRob/JohnsonHealthTechApp.git

- Should Johnson Health have a problem with that, I have a plan B.

- I have a zip file on my drop box account that has a zip file.
- https://www.dropbox.com/home/JohnsonHealthTech/local.zip

- I did grant Maya access to my my drop box account as hers is the main contact email.
- I did test that local.zip file on my local machine.

- I have a directory C:\ApplicationRnD\AndroidJavaApps\AManualCopyOfJohnsonHealthApp and put the local.zip file there
- When it went to extract it, I made sure C:\ApplicationRnD\AndroidJavaApps\AManualCopyOfJohnsonHealthApp was the root folder.

- Once extracted, I opened that folder with Android Studio.  
- I did have to do a Invalidate Cache
- checked Clear file system cache and Local History
- checked Clear VCS Log caches and indexes
- Clicked the Invalidate and Restart.

- I was able to run the solution and have the app run on my phone.


## 🚀 Submission Instructions

1. Complete the assignment and update this `README.md` with your responses above.
2. Upload your project to a private GitHub repository or share it via a zip file.
3. Make sure your project builds and runs cleanly.

Have fun building! 💪
