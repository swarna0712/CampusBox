# CampusBox
Android Studio application where you can connect with students who would want to share a ride with.
This project aims at assisting people who want to commute to places.
Add your travel details or just request someone to tag along!
This is one of the major problems which we we, as students, face in our campus. We are trying to solve this issue by creating a separate portal for students to post their travel details, and allows other students to view, search and request for pooling on such posts, which can be accepted or rejected by the user.
We students face problems while buying and selling things as there is no exclusive portal to facilitate such transactions, and using other platforms leads to various inconveniences. Thus, we aim at connecting all such buyers and sellers through a common platform and making these purchases hassle-free.
We at CampusBox are trying to create a platform where all the students can interact exclusively. After successfully implementing basic components, we plan on integrating this portal further, such as creating a news-feed that connects all the clubs and teams with the concerned students.

                                                                    
SPLASH SCREEN

  We have designed our logo and put it in splashscreen.
  Everytime the user opens the app it comes for 2 seconds until the app is loaded.

WELCOME SLIDER

  After the first time installation,when the user opens the app they are taken to the slider.
  They can swipe to see what are the main functions of the app.
  If user has already installed the app and opened it atleast once, it wont show the slider and will directly take them to the login page.

LOGIN PAGE

  MOBILE VERIFICATION
  
   Firebase Authentication -  to sign in a user by sending an SMS message to the user's phone.
   The user signs in using a one-time code (the verification code) contained in the SMS message.
   User first enters his/her mobile number in the login page.
   OTP is sent to this number via SMS message. Proceeds to next page if authentication is successful.
   If user  is not registered it goes to the registration page and prompts the user to complete registration in order to use the app.
   If user is already registered then it goes to the home page of the app.


FIREBASE CLOUD FIRESTORE

  We stored our apps database in firebase cloud firestore.
  We also retrieved our database from the cloud as well.


MY PROFILE

  We retrieved users data and put it on the my profile page.
  They can later edit their name, email and also upload their profile picture.


Conveyance

  Post
    
   This is basically if a user is looking for a co passenger, so he can just post the details of his travel, and his request will be posted. The other user will       have the option to request him to tag him along.

  Search
    
   In this the user will have the option to look for the rides already posted so that he can request the user to pool the ride if he has the same destination.

  My Request
   
   Here the user can look for his requests if they have been declined or accepted.


Buy and Sell (Yet to implement)

  Connect with people around the campus, find things you want to buy, and add items that you would like to sell. 
  Bid on items with your buying price.


