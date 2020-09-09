# Yad2 

Small program uses selenium IDE to pop Yad2 posts. 
The program sign in to the user private area, after publishing the post, and pops-up the post with pre-defined identifiers.
Written in Java
 

# Installation and Error Handling

Before you run the app: configure on PageManager.java your own password, email and identifiers (see in the file).
Download the whole repository and run the jars placed in 'out' folder by cmd.

You may configure the Contants variable "DRIVER_PATH" to your own chrome driver path.
If it ends with chrome driver error:
1. check your chrome driver version
2. check if it equals to version 85.xxx
3. if not, download the compitable chrome driver version for selenium
4. place it at the "DRIVER_PATH"
