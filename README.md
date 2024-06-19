# Maps_MM

This is a simple application in Android Studio to demonstrate the use of the Google Maps API


After setting up a new project through Google Cloud, acquiring an API Key for Maps, implementing the Google Maps SDK, and setting up some basic code within my main activity Java and XML files, I can start my application and get connected to a map using the emulator. I can move around the map and zoom in and out of different locations.

![Capture1](https://github.com/MMahar5/Maps_MM/assets/97249776/8bf2695f-ece9-4206-a565-b650cf19d67a)


To add some customization to the map, I used the maps platform styling wizard tool from mapstyle.withgoogle.com which lets me customize things like changing colors, removing icons/roads, choosing a theme, and more. The tool uses my changes and converts it to JSON which I am then able to add to a "raw" folder under "res".
![Capture](https://github.com/MMahar5/Maps_MM/assets/97249776/490fc06c-ef0e-4d16-ac01-b0e87e7cd949)


After implementing the code into my application, you can see that the app looks different as I chose a Retro theme which changes the colors of the water, the land, and more. 

![Capture2Water](https://github.com/MMahar5/Maps_MM/assets/97249776/580166f4-6bdc-4b29-be43-7e2c5661ea6b)


I also changed the colors of the schools to a dark red which you can see in the picture. We can see how this could be useful in an application by making it easy to locate specific locations on a map.

![CaptureSchools](https://github.com/MMahar5/Maps_MM/assets/97249776/aeafef03-6b69-4f3a-8fe2-46be19bce215)



I also implemented the ability to get your location data on an Android. To do this I needed to first add the necessary permissions and request them on the phone if turned off. I added a button and used intent to get to the phone settings where we can enable location permissions.

![CaptureLocBtn](https://github.com/MMahar5/Maps_MM/assets/97249776/82e6b738-3a36-48e5-a6d2-f55c74bc6bd4)


Here we can see where we get to after clicking the button and activating location permissions for the app.
![CapturePermission](https://github.com/MMahar5/Maps_MM/assets/97249776/8d60076d-e3b1-4175-9724-43f52bdaf721)


The code shown below is a method to check if the location permissions are enabled and hide the button if so.
![CaptureCheckPerm](https://github.com/MMahar5/Maps_MM/assets/97249776/3f0e5dba-b8df-4ce7-8d4c-2e5385020d54)
![CaptureHideBtn](https://github.com/MMahar5/Maps_MM/assets/97249776/ba3df9b8-86a6-40c6-9f81-805898294c53)


I added a text view at the bottom to display the latitude and longitude of our location. However, this was just added to show that it is working. I don't have other features enabled yet, like adding a marker to the map so you can easily change the location.
![latlong](https://github.com/MMahar5/Maps_MM/assets/97249776/2fe5f5f3-b249-4a1d-8a45-af4541be74bc)


Sources:
https://codeible.com/view/videotutorial/UX85nUxpOToeWKkR1GF4
https://mapstyle.withgoogle.com/

