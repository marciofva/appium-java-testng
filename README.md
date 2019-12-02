# onefootball-appium-automation
---

Onefootball app E2E testing project

## Pre-requisites:

- MacOS (latest)
- Node
- Java (v8)
- Appium (v1.13.0)
- Appium Doctor
- Android Emulator (Nexus 6 API 28 - Latest update)
- Maven

The following must be installed using brew:

- Carthage

---
## Setup

### 1) Configuring the environment variables in your `.bash_profile` file:

Open `.bash_profile`

```
vim ~/.bash_profile
```

Add the following to the opened file:

```
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$PATH:$JAVA_HOME
export PATH=$PATH:$JAVA_HOME/bin

export ANDROID_HOME=/Users/your_username/Library/Android/sdk
export PATH=$ANDROID_HOME/platform-tools:$PATH
export PATH=$ANDROID_HOME/tools:$PATH
export PATH=$ANDROID_HOME/lib:$PATH
export PATH=$ANDROID_HOME/emulator:$PATH
export PATH=$ANDROID_HOME/tools/lib:$PATH
```

Save and run `source` to apply the changes to your current session

```
source ~/.bash_profile
```


### 2) Checking Appium dependencies

Run in terminal:

```
appium-doctor
```

The output should contain something like this:

```
info AppiumDoctor Appium Doctor v.1.6.0
info AppiumDoctor ### Diagnostic starting ###
info AppiumDoctor  ✔ The Node.js binary was found at: /usr/local/bin/node
info AppiumDoctor  ✔ Node version is 11.14.0
info AppiumDoctor  ✔ Xcode is installed at: /Applications/Xcode.app/Contents/Developer
info AppiumDoctor  ✔ Xcode Command Line Tools are installed.
info AppiumDoctor  ✔ DevToolsSecurity is enabled.
info AppiumDoctor  ✔ The Authorization DB is set up properly.
info AppiumDoctor  ✔ Carthage was found at: /usr/local/bin/carthage
info AppiumDoctor  ✔ HOME is set to: /Users/...
info AppiumDoctor  ✔ ANDROID_HOME is set to: /Users/.../Library/Android/sdk
info AppiumDoctor  ✔ JAVA_HOME is set to: /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home
info AppiumDoctor  ✔ adb exists at: /Users/.../Library/Android/sdk/platform-tools/adb
info AppiumDoctor  ✔ android exists at: /Users/.../Library/Android/sdk/tools/android
info AppiumDoctor  ✔ emulator exists at: /Users/.../Library/Android/sdk/tools/emulator
info AppiumDoctor  ✔ Bin directory of $JAVA_HOME is set
info AppiumDoctor ### Diagnostic completed, no fix needed. ###
info AppiumDoctor
info AppiumDoctor Everything looks good, bye!
info AppiumDoctor
```


### 3) Setting up the Capabilities file

There is the file `AndroidSuite.xml` that defines the test classes that are contained within the suite Android. This file contains 2 must-have parameters for the execution, which are: 
- platform: Regarding the suite's platform
- device: Regarding in which device the tests will run

The `/src/test/java/com/onefootball/factory/DriverFactory.java` file contains the configuration variables.


### 4) Starting the emulator

- The default emulator used for the Android platform is the Nexus_6_API_28

List the installed android emulators:

```
emulator -list-avds
```
Open android emulator 


### 5) Starting the Appium server

Run in terminal:

```
appium
```


### 6) Running the test suite

Android:

```
mvn clean test -DsuiteXmlFile=suite-tests/AndroidSuite.xml
```

