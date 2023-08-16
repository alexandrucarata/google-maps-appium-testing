# Google Maps Mobile Automation Testing Framework
## Table of Contents
- [Introduction](#Introduction)
- [Tech Stack](#Tech-Stack)
- [Build Specification](#Build-Specification)
---
## Introduction
Developed a **mobile automation testing framework** for [Google Maps](https://maps.google.com/) Android application
based on Java, Selenium and Appium. 
Completed as part of QA Automation Project Oriented Training in May 2023 (updated and uploaded August 2023).

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