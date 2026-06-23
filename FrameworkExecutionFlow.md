# Selenium Framework Execution Flow

1. Execution starts from testng.xml.
2. TestNG loads listener and test classes.
3. BaseTest launches browser before every test.
4. ConfigReader reads browser and URL from config.properties.
5. Test class creates page object.
6. Page class performs actions using locators.
7. Test class verifies result using assertions.
8. Listener captures test status.
9. On failure, ScreenshotUtil captures screenshot.
10. Extent Report logs pass/fail/skip status.
11. extent.flush() generates final HTML report.
12. BaseTest closes browser after test.