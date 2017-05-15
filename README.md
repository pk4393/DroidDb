# DroidDb
DroidDb is a key-value SQLite based database for Android.

Add it in your root build.gradle at the end of repositories:

 Step 1. Add the JitPack repository to your build file
 
		allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

		dependencies {
		compile 'com.github.User:Repo:Tag'
	}
  
  Maven Dependency :
  
  Step 1. Add the JitPack repository to your build file
 
 	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  
Step 2. Add the dependency

		<dependency>
	    <groupId>com.github.User</groupId>
	    <artifactId>Repo</artifactId>
	    <version>Tag</version>
	</dependency>
