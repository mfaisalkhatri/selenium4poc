![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)
[![Java CI with Maven](https://github.com/mfaisalkhatri/selenium4poc/actions/workflows/maven.yml/badge.svg)](https://github.com/mfaisalkhatri/selenium4poc/actions/workflows/maven.yml)
[![CodeQL](https://github.com/mfaisalkhatri/selenium4poc/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/mfaisalkhatri/selenium4poc/actions/workflows/codeql-analysis.yml)

## Don't forget to give a :star: to make the project popular.

## :question: What is this Repository about?

- This repo has example codes with Selenium 4 features.
- Websites used for testing are: [automationpractice.com][automationpractice], [saucedemo.com][saucedemo],
  [the-internet][the-internet] and [owasp-juice-shop][juice-shop]
- This repo uses Maven as build tool and TestNG testing framework to run the tests.

## Talking more about the Scenarios Covered in this project:

- I have tried to answer the below questions by providing working code example in this repo:

1. How do I select a value from Table?
2. How do I tick and untick checkboxes using selenium
3. How do I right click using selenium?
4. How do I drag and drop using selenium?
5. How do I write code to login and logout using Selenium?
6. How do I pass multiple test data value using DataProvider in tests?
7. How do I mouse hover an element using selenium?
8. How do I download a file using Selenium?
9. How do I upload file using selenium?
10. How do I press keys using selenium?
11. How do I work with multiple Tab windows in selenium?
12. How do I work with iFrames using Selenium?
13. How do I double click using Selenium WebDriver?
14. How to check for chrome generated logs when selenium tests are run?

### End to End Tests for [owasp-juice-shop][juice-shop]

### Following is the Automation Test Strategy used for writing End to End Tests:

1. User will navigate to the website and close all the pop up first.
2. User will click on Login link and click on `Not yet a customer link` and register himself on the website.
3. Once the Registration is successful, User will Login with that username and password.
4. After successful Login, User will Add AppleJuice and BananaJuice to the Basket.
5. After asserting the messages for items added to basket, user will check for the count of items displayed on top
   of `Your Basket` link.
6. User will click on `Your Basket` link and check the order details and click on Checkout.
7. User will enter a new Address for Delivery and select it to process further.
8. User will continue further to Card for Payment and select the card added to make payment.
9. On the Order Summary page, user will verify all the details like Name, Address, Order details and total amount to be
   paid and place order.
10. USer will re-check the details on Order confirmation page and check for `Thank You` message order confirmation and
    delivery message.

- End to End tests for Juice Shop Website are running on 'http://localhost:3000' inside the container in github actions.
- CI/CD Pipeline has been added using Github Actions.

## :question: Need Assistance?

- Discuss your queries by writing to me @ [mohammadfaisalkhatri@gmail.com][mail] OR you can ping me on the following
  social media sites:
- Twitter: [mfaisal_khatri][twitter]
- LinkedIn: [Mohammad Faisal Khatri][linkedin]
- Contact me for 1:1 trainings related to Testing and Test Automation.

## :thought_balloon: Checkout the blogs related to Testing on my [website][]

[mail]: mohammadfaisalkhatri@gmail.com

[linkedin]: https://www.linkedin.com/in/faisalkhatri/

[twitter]: https://twitter.com/mfaisal_khatri

[automationpractice]:http://automationpractice.com/index.php

[saucedemo]: https://www.saucedemo.com

[the-internet]: http://the-internet.herokuapp.com/

[juice-shop]: https://github.com/juice-shop/juice-shop

[website]: https://mfaisalkhatri.github.io