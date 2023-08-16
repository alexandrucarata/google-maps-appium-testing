# Google Maps Mobile Automation Testing Framework
## Table of Contents
- [Introduction](#Introduction)
- [Demo Videos](#Demo-Videos)
- [Tech Stack](#Tech-Stack)
- [Build Specification](#Build-Specification)
---
## Introduction
Developed a **mobile automation testing framework** for [Google Maps](https://maps.google.com/) Android application
based on Java, Selenium and Appium. 
Completed as part of QA Automation Project Oriented Training in May 2023 (updated and uploaded August 2023).

---
## Demo Videos

https://github.com/alexandrucarata/google-maps-appium-testing/assets/80596038/df30d0da-8600-4040-957e-1f1531edc20c


https://github.com/alexandrucarata/google-maps-appium-testing/assets/80596038/f5e5580a-d665-451e-8a32-5a8254c2508c


https://github.com/alexandrucarata/google-maps-appium-testing/assets/80596038/c9d27894-559f-4c40-bfd6-31e589be7536


---
## Tech Stack
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Android Studio](https://developer.android.com/studio)
- [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [Selenium](https://www.selenium.dev/)
- [TestNG](https://testng.org/)
- [Appium](http://appium.io/)
- [Allure](https://docs.qameta.io/allure/)
- [Jenkins](https://www.jenkins.io/)
---
## Build Specification
- **Clone Project**
  ```bash
  git clone https://github.com/alexandrucarata/google-maps-appium-testing.git
  ```
- **Switch Branch**
  ```bash
  git checkout develop
  ```
- **Run Test Suite**
  ```shell
  mvn clean test -DsuiteXmlFile="mapsTest.xml"
  ```
- **Access Allure Report**
  ```shell
  allure serve target/allure-results
  ```
