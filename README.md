# Create a BootsFaces desktop application or web application using Embedded Tomcat and CDI

## Step 1: embedding Tomcat in your application

This demo runs BootsFaces and CDI in an embedded Tomcat 8.0.39. After starting the Server.java, you can launch your application in your browser.
The URL is simply http://localhost.

## Step 2: make the application a full-blown desktop application

The second step is to wrap everything in a desktop application. Simply start the Main.java. A browser window
will open, and the index.jsf of your applation is shown automatically. When you close the application window,
the server is automatically shut down.

## JavaFX or SWT?
The application supports both JavaFX and SWT as containers of the browser window. So you can chose
between a pure-Java implementation running on every operation system (JavaFX) and an implementation
using the default browser of your operation system (SWT).

### JavaFX
To activate this variant, remove the SWT dependency from the pom.xml. At the time of writing,
this is lines 135-139. Depending on your IDE or Maven build, you may also have to remove line 93
from the Main.java (i.e. the line containing "SWTBrowserExample.launch();"). After that,
starting the Main.java opens the demo application in a JavaFX window.

This variant requires a current Java 8 installation. I've tested it with Java 8u101, but it should
run on any JDK above 8u40. Note that JavaFX is not part of the standard SDK, so you may add the jar
files manually to the JRE folder.

The advantage of JavaFX is that it runs on every operation system. However, the browser isn't as powerful
as the current browsers such as Google Chrome, Firefox or Edge. However, I didn't notice any incompatibilities
yet, so you might give it a try. The only difference I noticed so far is that JavaFX chooses a slightly
different font than Chrome does.

### SWT
SWT is activated by default, but you may have to modify the pom.xml if you're using Windows or Linux.
Remove the Cocoa SWT dependency (line 135-139) from the pom.xml, and activate either the Linux or the Windows dependency in the lines above. 
In the case of Windows, activate only one of the two dependencies, depending on whether you're running a 32 bit or 64 bit JVM.

The disadvantage of SWT is that you have to configure it for your target OS. However, once you've done that,
you benefit from the full feature set of your computers default browser. In the case of OSW, that's Safari, for Windows users
that's either good old Internet Explorer or Edge (on Windows 10 and above), and so on. It's possible to use Firefox
instead, but other than that, SWT doesn't allow you to use other browsers.

## Self-executable jar
The Maven command mvn install generates a jar file which should run by a double click on Windows (not tested yet).
On OSX, you have to write a shell script or to package the jar in a DMG archive in order to start the application by a simple double click. I didn't test either yet, so suffice it to say that you can find some information to both
approaches in the internet.

## Kudos
The example builds on a former project of mine, on an example provided by Heroku, and on this
article: https://musingsinjava.wordpress.com/2014/11/02/enabling-jsf-2-2-and-cdi-1-2-on-tomcat-8/. If
I've missed one of my sources, don't hesitate to tell me so I can add it.
