![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java CI with Maven](https://github.com/mfaisalkhatri/selenium4poc/actions/workflows/maven.yml/badge.svg)](https://github.com/mfaisalkhatri/selenium4poc/actions/workflows/maven.yml)
[![CodeQL](https://github.com/mfaisalkhatri/selenium4poc/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/mfaisalkhatri/selenium4poc/actions/workflows/codeql-analysis.yml)

## Don't forget to give a :star: to make the project popular.

## :question: What is this Repository about?

- This repo has example codes with Selenium 4 features.
- Websites used for testing are: [automationpractice.com](http://automationpractice.com/index.php), [saucedemo.com](https://www.saucedemo.com),
  [the-internet](http://the-internet.herokuapp.com/) [owasp-juice-shop](https://github.com/juice-shop/juice-shop)
  and [LambdaTest e-commerce Playground](https://ecommerce-playground.lambdatest.io/)
- This repo uses `Maven` as build tool and `TestNG` testing framework to run the tests.

## Talking more about the Scenarios Covered in this project:

- I have tried to answer the below questions by providing working code example in this repo:

1. How do I select a value from Table?
2. How do I tick and untick checkboxes using selenium
3. How do I right-click using selenium?
4. How do I drag and drop using selenium?
5. How do I write code to log in and logout using Selenium?
6. How do I pass multiple test data value using DataProvider in tests?
7. How do I mouse hover an element using selenium?
8. How do I download a file using Selenium?
9. How do I upload file using selenium?
10. How do I press keys using selenium?
11. How do I work with multiple Tab windows in selenium?
12. How do I work with iFrames using Selenium?
13. How do I double-click using Selenium WebDriver?
14. How to check for chrome generated logs when selenium tests are run?

## :writing_hand: Blog Links
 
- [Selenium 4 WebDriver Hierarchy: A Detailed Explanation](https://medium.com/@iamfaisalkhatri/selenium-4-webdriver-hierarchy-a-detailed-explanation-lambdatest-18771c5fd3e9)
- [Selenium Manager in Selenium 4.11.0: New Features and Improvements](https://medium.com/@iamfaisalkhatri/selenium-manager-in-selenium-4-11-0-new-features-and-improvements-lambdatest-761593a7f009)
- [Different Types of Locators in Selenium WebDriver](https://www.lambdatest.com/blog/locators-in-selenium-webdriver-with-examples/)
- [How to Locate Elements Using CSS Selectors in Selenium](https://www.lambdatest.com/learning-hub/css-selectors)
- [How to Use @FindBy Annotation in Selenium Java](https://www.lambdatest.com/blog/findby-annotation-selenium-java/)
- [Understanding CSS Selectors in Selenium](https://medium.com/@iamfaisalkhatri/understanding-css-selectors-in-selenium-pcloudy-blog-3e4b09672264)
- [End to End testing using Selenium WebDriver and Java](https://medium.com/@iamfaisalkhatri/end-to-end-testing-using-selenium-webdriver-and-java-4ff8667716ca)
- [Writing Selenium Web Automation tests in Fluent way!](https://medium.com/@iamfaisalkhatri/writing-selenium-web-automation-tests-in-fluent-way-864db95ee67a)
- [How To Automate Shadow DOM In Selenium WebDriver?](https://medium.com/@iamfaisalkhatri/how-to-automate-shadow-dom-in-selenium-webdriver-lambdatest-blog-3884698b995)
- [How to setup GitHub Actions for Java with Maven project?](https://mfaisalkhatri.github.io/2022/04/26/githubactions-for-java-maven-project/)
- [How to Automate ServiceNow with Selenium](https://medium.com/@iamfaisalkhatri/how-to-automate-servicenow-with-selenium-511e41172161)
- [Cross browser testing in Selenium WebDriver](https://medium.com/@iamfaisalkhatri/cross-browser-testing-in-selenium-webdriver-pcloudy-blog-46e9d70fa13a)
- [How to Handle ElementClickInterceptedException in Selenium Java](https://www.lambdatest.com/blog/elementclickinterceptedexception-in-selenium-java/)

## :movie_camera: Tutorial Videos

[![Watch the video](https://img.youtube.com/vi/JYosKUL0aZU/hqdefault.jpg)]( https://youtu.be/JYosKUL0aZU?si=qjHlpkHUxwZtITED)
[![Watch the video](https://img.youtube.com/vi/1Bw2JHoOg5U/hqdefault.jpg)]( https://youtu.be/1Bw2JHoOg5U?si=mdbGd7XAfbJ3VNbO)
[![Watch the video](https://img.youtube.com/vi/bhZX7apMqR8/hqdefault.jpg)]( https://www.youtube.com/live/bhZX7apMqR8?si=4n0u5YiMuz5vTiHd)
[![Watch the video](https://img.youtube.com/vi/uHLYoJmZxWc/hqdefault.jpg)](https://youtu.be/uHLYoJmZxWc?si=3nevAn0Z3QZycdG8)
[![Watch the video](https://img.youtube.com/vi/_hlXjVTa-jo/hqdefault.jpg)](https://youtu.be/_hlXjVTa-jo?si=PfOfU7ihb8eEgduh)
[![Watch the video](https://img.youtube.com/vi/wSxnk3XkG58/hqdefault.jpg)](https://youtu.be/wSxnk3XkG58)
[![Watch the video](https://img.youtube.com/vi/sVBgpz1z9Ts/hqdefault.jpg)]( https://youtu.be/sVBgpz1z9Ts?si=azE1_vquOwT9jFT1d)


## End-to-End Tests for OWASP-Juice-Shop

- End-to-End tests for Juice Shop Website are running on `http://localhost:3000` inside the container in GitHub actions.
- GitHub Actions is used for setting up CI/CD Pipeline

### Following is the Automation Test Strategy used for writing End-to-End Tests:

1. User will navigate to the website and close all the pop-up first.
2. User will click on Login link and click on `Not yet a customer link` and register himself on the website.
3. Once the Registration is successful, User will Log in with that username and password.
4. After successful Login, User will Add AppleJuice and BananaJuice to the Basket.
5. After asserting the messages for items added to basket, user will check for the count of items displayed on top
   of `Your Basket` link.
6. User will click on `Your Basket` link and check the order details and click on Checkout.
7. User will enter a new Address for Delivery and select it to process further.
8. User will continue further to Card for Payment and select the card added to make payment.
9. On the Order Summary page, user will verify all the details like Name, Address, Order details and total amount to be
   paid and place order.
10. User will re-check the details on Order confirmation page and check for `Thank You` message order confirmation and
    delivery message.

## End-to-End Tests for LambdaTest ECommerce Playground Website

### Following is the automation test strategy used for writing end-to-end tests:

1. The User will navigate to the website.
2. From the Home Page of the screen, user will navigate to the Registration Page and register himself. Verification will
   be done by asserting the registration successful message.
3. User will click on the Shop by Category option on the top left and select a category for selecting the product to
   purchase.
4. From the Product Page, the user will hover on any product which he likes and select the Add to cart option. Once a
   product is added to cart, assertions will be performed to check the success message displayed.
5. On the Checkout page, user will provide the billing address details and also assertion will be made for product name
   and its respective price.
6. Once a product is checked out, the user lands on the Order Confirmation page, where product name, price and shipping
   address will be asserted and after that Order would be marked as confirmed.
7. Finally, an Order confirmation message would be verified in the tests which marks the end of the test journey.

## How to run the Tests?

### Running Juice Shop Tests on your local machine:

- Start `Juice-Shop` website locally, for doing this we will make use of `docker-compose-v3-juiceshop.yml` which is
  available in the root folder of this project.
- Open terminal/command prompt and navigate to the root folder of the project and run the following command:

  `docker-compose -f docker-compose-v3-juiceshop.yml up -d`

- Once the `Juice-Shop` website is up and running, we are good to run the end-to-end tests using the juice shop website.
- There are 2 ways to run the tests, those are as follows:
  ### 1. TestNG:
    - Right-Click on the `test-suite\testng-juice-shop.xml` and select `Run ...\test-suite\testng-juice-shop.xml`
  ### 2. Maven:
    - To run the tests in headless mode update the value for `headless` property variable to `true`

      `mvn clean install -Dsuite-xml=test-suite\testng-juice-shop.xml -Dheadless=true`

    - To run the tests without headless mode(to see the test running in browser) update the value for headless property
      variable to
      `false`

      `mvn clean install -Dsuite-xml=test-suite\testng-juice-shop.xml -Dheadless=false`


- Stopping the Juice Shop website running in local

  `docker-compose -f docker-compose-v3-juiceshop.yml down`

### Running Selenium Grid on local and running tests using Selenium Grid

- Start the Selenium Grid in local using the `docker-compose-v3-seleniumgrid.yml` file.
- Run the following command:
  `docker-compose -f docker-compose-v3-seleniumgrid.yml up -d`

  This will start the selenium grid which can be access using `http://localhost:4444`.

    - To run the tests on Selenium Grid using `TestNG`:

      Right click on `test-suite\testng-seleniumgrid-theinternet.xml` and
      select `Run test-suite\testng-seleniumgrid-theinternet.xml`

    - To run the tests on Selenium Grid using `Maven`:

      `mvn clean install -Dsuite-xml=test-suite\testng-seleniumgrid-theinternet.xml`

- Stopping the Selenium Grid:

  `docker-compose -f docker-compose-v3-seleniumgrid.yml down`

### Running all the tests in one go:

- Start the `Juice -Shop` website using following command:

  `docker-compose -f docker-compose-v3-juiceshop.yml up -d`

- Start `Selenium Grid` using following command:

  `docker-compose -f docker-compose-v3-seleniumgrid.yml up -d`

- Run the tests using `TestNG`:

  Right click on `test-suite\testng.xml` and select `Run test-suite\testng.xml`

- Run the tests using `Maven` in headless mode:

  `mvn clean install -Dheadless=true`

- Stopping the `Juice-Shop` website and `Selenium Grid`:

  `docker-compose -f docker-compose-v3-juiceshop.yml down --remove-orphan`

### Running LambdaTest ECommerce Playground Tests on your local machine:

- There are 2 ways to run the tests, those are as follows:

  ### 1. TestNG:
    - Right-Click on the `test-suite\testng-lambdatestecommerce.xml` and
      select `Run ...\test-suite\testng-lambdatestecommerce.xml`

  ### 2. Maven:
    - To run the tests in headless mode update the value for `headless` property variable to `true`

      `mvn clean install -Dsuite-xml=test-suite\testng-lambdatestecommerce.xml -Dheadless=true`

    - To run the tests without headless mode(to see the test running in browser) update the value for headless property
      variable to
      `false`

      `mvn clean install -Dsuite-xml=test-suite\testng-lambdatestecommerce.xml -Dheadless=false`


## :question: Need Assistance?

- Discuss your queries by writing to me @ `mohammadfaisalkhatri@gmail.com`
  OR ping me on any of the social media sites using the below link:
    - [Linktree](https://linktr.ee/faisalkhatri)
  
## :computer: Paid Trainings

- Contact me for Paid trainings related to Test Automation and Software Testing,
mail me @ `mohammadfaisalkhatri@gmail.com` or ping me on [LinkedIn](https://www.linkedin.com/in/faisalkhatri/)

## :thought_balloon: Checkout the blogs related to Testing written by me on the following links:

- [Medium Blogs](https://medium.com/@iamfaisalkhatri)
- [LambdaTest Blogs](https://www.lambdatest.com/blog/author/mfaisalkhatri/)
- [My Website](https://mfaisalkhatri.github.io)

## :computer: Recommended Proxies

There are cases when proxies may be required to run the tests, this may happen when the software teams are working in isolation at different places.
Residential proxies help in keeping the user’s information safe and help in hiding the real location of the user
It acts as a middleman between the device and the internet and keep the users safe from being tracked.

[NodeMaven](https://go.nodemaven.com/automation_proxy) provides high quality proxies with industry-first filtering, super sticky sessions and best customer support.
Try out [NodeMaven](https://go.nodemaven.com/automation_proxy) now(_Use F86 at checkout to get extra 2GB of proxy_)

## :bulb: Cloud platform supporter

### Big thanks to **LambdaTest** for their support to the project with their open source license:

<a href="http://www.lambdatest.com?fp_ref=faisal58" target="_blank" style="outline:none;border:none;"><img src="https://d2gdx5nv84sdx2.cloudfront.net/uploads/n3ufe5o3/marketing_asset/banner/6476/728_x_90.png" alt="lambdatest" border="0"/></a>
 
 
