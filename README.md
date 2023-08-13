# Selenide Project Example

This is an example project demonstrating how to use RestAssured for API testing and integrate it with TestNG and ExtentReports for reporting.

## Overview

This project serves as a practical demonstration of UI testing using Selenide framework. It showcases how to structure your tests, manage dependencies, and generate detailed reports using TestNG and ExtentReports.

## Prerequisites

Before you begin, ensure you have met the following requirements:

* Java JDK (8 or higher) installed
* Apache Maven installed
* Git installed
* Allure installed

## Getting Started
To get started with this project, follow these steps:

```shell
git clone https://github.com/horuktaras/SelenideProjectExample.git
```
Navigate to the project directory:
```shell
cd SelenideProjectExample
```
Compile and run the tests using Maven:
```shell
mvn clean verify -Ptest -Dname="standard_user" -Dpassword="secret_sauce" -Dheadless="true"
```

Generate Allure report
```shell
allure generate target/allure-results/ -o target/allure-report/
```

Open Allure report
```shell
allure open target/allure-report/     
```