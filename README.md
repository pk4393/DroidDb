# DroidDb
DroidDb is a key-value based database for Android.

You can store and get primitive types. You can also store or get a object or arrayList in a type-safe way.

Create and Close database:

public class MyApplication extends Application {
  private Database mDatabase;

  @Override
  public void onCreate() {
    mDatabase = new Database(this);
    try {
      mDatabase.open();
    } catch (SQLException e) {
      Log.e("SQLException", e.getMessage());
    }
    super.onCreate();
  }

  @Override
  public void onTerminate() {
    mDatabase.close();
    super.onTerminate();
  }
}

How to store the primitive types :

Database.getDataDao().addBooleanValue("DbBooleanDemo", true);

Database.getDataDao().addIntValue("DbIntDemo", 4393);

Database.getDataDao().addLongValue("DbLongDemo", 4393L);

Database.getDataDao().addStringValue("DbStringDemo", "DbDemo");

Database.getDataDao().addDoubleValue("DbDoubleDemo", 4393d);


How to get the primitive types :

boolean dbBooleanDemo = Database.getDataDao().addBooleanValue("DbBooleanDemo", true);

int dbIntDemo = Database.getDataDao().addIntValue("DbIntDemo", 4393);

long dbLongDemo = Database.getDataDao().addLongValue("DbLongDemo", 4393L);

String dbStringDemo = Database.getDataDao().addStringValue("DbStringDemo", "DbDemo");

double dbDoubleDemo = Database.getDataDao().addDoubleValue("DbDoubleDemo", 4393d);


How to store the Object :

DemoPojo demoPojo = new DemoPojo ();
Database.getDataDao().addObject("pojo", demoPojo);

Note: No need to implement Serializable interface in the DemoPojo


How to get the Object :

DemoPojo demoPojo = Database.getDataDao().getObject("pojo", DemoPojo.class);



Gradle Dependency:

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
