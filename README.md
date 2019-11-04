# NfApp

App configuration info

  - minSDkVersion 21
  - targetSdkVersion 29
  - compileSdkVersion 29
  - Gradle plugin version 3.5.1
  - Kotlin version 1.3.50
  - Android Studio 3.5


Dependencies used for base framework
  - Dagger 2
  - Android Architecure Librareis
  - DataBinding
  - Glide
  - AndroidX framework
  - Kotlin
# NyTimes API

  - Obtain  api key from https://developer.nytimes.com/
  - fetching the result ttps://api.nytimes.com/svc/mostpopular/v2/mostviewed/{section}/{period}.json?api-key=sample-key
  - sample api key should be added in 
  ```sh
class BaseConfigurations {
    companion object {
        const val API_KEY = "Ld___________________N"
    }
}
```
### Development

Used mvvm architecture with the help of Dagger2 Dependency injection and DataBinding



![Architecture](https://benoitpasquier.com/images/2018/01/mvvm-pattern.png)


>Flow will be like this -> Fetching the result from API -> proccessing thre result->rendering UI


#### App UI
- Master screen -> Displaying list of items from server 
- Details screen - > details of the selected item

# 1- HomeScreen
![screen1](https://i.postimg.cc/L6FRwMPv/Screenshot-20191104-091746.jpg)

##### User can able to search them item with title of displaying items


# 2- DetailsScreen
![screen1](https://i.postimg.cc/GtGRtXWk/Screenshot-20191104-091824.jpg)


# To run test 
To run a test, proceed as follows:

>Be sure your project is synchronized with Gradle by clicking Sync Project   in the toolbar.
>Run your test in one of the following ways:
In the Project window, right-click a test and click Run .
In the Code Editor, right-click a class or method in the test file and click Run  to test all methods in the class.
To run all tests, right-click on the test directory and click Run tests .

##### The test classes kept inside 

![screen1](https://i.ibb.co/gtMbC4d/Screenshot-2019-07-31-at-6-52-23-PM.png)

##### UI Tested with Espresso


##### Test coverage report generation
We can now get coverage (on Android Studio) by: right clicking in our project → Run Tests with Coverage. This will output our code coverage metrics.

![screen1](https://miro.medium.com/max/696/1*nL5uv_eKaWSBvi-E5rdTVg.png)


### Libraries Used

| Libraries |
| ------ |
| Glide |
| Retrofit |
| OkHttp |
| Dagger 2 |
| AndroidX Libraries |
