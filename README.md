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


## Dropdowns and Date Picker Handling

### Concepts Practiced
- Handling static dropdowns using Selenium `Select` class
- Using `selectByVisibleText()`
- Handling dynamic dropdowns using click actions
- Handling date picker in DemoQA Student Registration Form
- Selecting month, year, and date
- Using `JavascriptExecutor` for scrolling and clicking
- Handling `ElementClickInterceptedException`
- Using `WebDriverWait` and `ExpectedConditions`

### Test Scenario Practiced
Automated the DemoQA Student Registration Form by filling:
- First Name
- Last Name
- Email
- Gender
- Mobile Number
- Date of Birth
- Hobbies
- Address
- State
- City

### Important Learning
DemoQA State and City dropdowns are dynamic dropdowns, so Selenium `Select` class cannot be used. These dropdowns were handled using click actions, explicit wait, and JavaScript scroll.

## Waits in Selenium

### Concepts Practiced
- Explicit Wait
- WebDriverWait
- ExpectedConditions
- Waiting for element visibility
- Waiting for element clickability
- JavaScriptExecutor scroll
- JavaScript click
- Handling timing issues in Selenium

### Application Used
DemoQA Student Registration Form

### Fields Automated
- First Name
- Last Name
- Email
- Gender
- Mobile Number
- Hobby
- Current Address

### Key Learning
Selenium runs faster than web pages load, so waits are required to make scripts stable. I used WebDriverWait and ExpectedConditions to wait for elements before performing actions.

### Issue Faced
The script looked stuck near the mobile number field, but the actual issue was an incorrect JavaScriptExecutor syntax while scrolling to the Reading checkbox.

### Fix Used
Correct JavaScriptExecutor syntax:

```java
js.executeScript("arguments[0].scrollIntoView({block: 'center'});", readingLabel);

##Alerts, Frames, and Windows

### Concepts Practiced
- Simple alert
- Confirmation alert
- Prompt alert
- Alert accept and dismiss
- Alert text handling
- Prompt alert input
- Frame handling
- Switching to iframe
- Switching back to main page
- Browser window handling
- Window handles

### Applications Used
- DemoQA Alerts
- DemoQA Frames
- DemoQA Browser Windows

### Key Learning
Selenium cannot directly interact with alerts, iframes, or new browser windows. We must switch Selenium control using `switchTo()` before performing actions.


## Actions Class in Selenium

### Concepts Practiced
- Actions class
- Double click
- Right click / context click
- Dynamic click
- Mouse hover
- Drag and drop
- Click and hold
- Keyboard actions
- Ctrl+A shortcut
- Tab key handling

### Applications Used
- DemoQA Buttons
- DemoQA Menu
- DemoQA Droppable
- DemoQA Text Box

### Key Learning
Actions class is used for advanced mouse and keyboard interactions in Selenium. It is useful for handling hover menus, right click, double click, drag and drop, and keyboard shortcuts.

### Practice Files
- DoubleClickPractice.java
- RightClickPractice.java
- DynamicClickPractice.java
- MouseHoverPractice.java
- DragAndDropPractice.java
- KeyboardActionsPractice.java