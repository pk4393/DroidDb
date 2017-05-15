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
	        compile 'com.github.pk4393:DroidDb:1.0.1'
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
	    <groupId>com.github.pk4393</groupId>
	    <artifactId>DroidDb</artifactId>
	    <version>1.0.1</version>
	</dependency>
