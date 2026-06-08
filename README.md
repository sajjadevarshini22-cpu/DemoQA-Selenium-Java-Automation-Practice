# DemoQA Selenium Java Automation Practice

## Repository Overview

This repository contains my Selenium WebDriver practice programs using Java.

I am using the DemoQA website to practice Selenium concepts such as locators and WebElement actions.

This repository is created for learning and practice purposes.

## Website Used for Practice

DemoQA  
https://demoqa.com/

Practice Form Page  
https://demoqa.com/automation-practice-form

## Tools and Technologies Used

- Java
- Selenium WebDriver
- ChromeDriver
- IntelliJ IDEA
- Git
- GitHub

## Practice Files

### 1. LocatorsPractice.java

In this file, I practiced different Selenium locators such as:

- `id`
- `name`
- `className`
- `xpath`
- `cssSelector`
- `linkText`
- `partialLinkText`

### 2. WebElementActionsPractice.java

In this file, I practiced different WebElement methods such as:

- `sendKeys()`
- `click()`
- `clear()`
- `getText()`
- `getAttribute()`
- `isDisplayed()`
- `isEnabled()`
- `isSelected()`

## Concepts Practiced

- Launching Chrome browser using Selenium WebDriver
- Opening DemoQA practice pages
- Finding web elements using different locators
- Entering text into input fields
- Clearing text from input fields
- Clicking radio buttons
- Clicking checkboxes
- Validating placeholder values
- Checking whether elements are displayed
- Checking whether elements are enabled
- Checking whether radio buttons and checkboxes are selected
- Closing the browser using `driver.quit()`

## Challenge Faced

While practicing checkbox handling on the DemoQA Student Registration Form, I faced an `ElementClickInterceptedException`.

Selenium was able to locate the Reading checkbox, but normal click was not working because another UI element was blocking the clickable area.

## Solution Used

I handled this issue using `JavascriptExecutor`.

```java
WebElement readingLabel = driver.findElement(By.xpath("//label[text()='Reading']"));

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView({block: 'center'});", readingLabel);
js.executeScript("arguments[0].click();", readingLabel);