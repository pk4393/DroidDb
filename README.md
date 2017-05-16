# DroidDb
DroidDb is a key-value based database for Android.

You can store and get primitive types. You can also store or get a object or arrayList in a type-safe way.

**Create and Close database:**

```sh
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

```

**How to store the primitive types :**

```sh Database.getDataDao().addBooleanValue("DbBooleanDemo", true);

Database.getDataDao().addIntValue("DbIntDemo", 4393);

Database.getDataDao().addLongValue("DbLongDemo", 4393L);

Database.getDataDao().addStringValue("DbStringDemo", "DbDemo");

Database.getDataDao().addDoubleValue("DbDoubleDemo", 4393d);

```


**How to get the primitive types :**

```sh

boolean dbBooleanDemo = Database.getDataDao().getBooleanValue("DbBooleanDemo", true);

int dbIntDemo = Database.getDataDao().getIntValue("DbIntDemo", 4393);

long dbLongDemo = Database.getDataDao().getLongValue("DbLongDemo", 4393L);

String dbStringDemo = Database.getDataDao().getStringValue("DbStringDemo", "DbDemo");

double dbDoubleDemo = Database.getDataDao().getDoubleValue("DbDoubleDemo", 4393d);
```


**How to store the Object :**

```sh

DemoPojo demoPojo = new DemoPojo ();

Database.getDataDao().addObject("pojo", demoPojo);

Note: No need to implement Serializable interface in the DemoPojo

```


**How to get the Object :**

```sh

DemoPojo demoPojo = Database.getDataDao().getObject("pojo", DemoPojo.class);
```



**Gradle Dependency:**

 **Step 1. Add the JitPack repository to your build file**
 
 ```sh
			allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
```
  
**Step 2. Add the dependency**

 ```sh
	dependencies {
	        compile 'com.github.pk4393:DroidDb:1.0.1'
	}
	
```
  
  **Maven Dependency :**
  
  **Step 1. Add the JitPack repository to your build file**
  
  ```sh
 	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
```
  
**Step 2. Add the dependency**

```sh
	<dependency>
	    <groupId>com.github.pk4393</groupId>
	    <artifactId>DroidDb</artifactId>
	    <version>1.0.1</version>
	</dependency>
```
