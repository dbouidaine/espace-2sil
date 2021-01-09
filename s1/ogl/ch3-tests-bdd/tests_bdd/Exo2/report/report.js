$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Exo2.feature");
formatter.feature({
  "name": "Exo2",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Adding product to cart ebay",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I am in the page \"https://www.ebay.com\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Exo2Steps.iAmInThePage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \"shoes for men\"",
  "keyword": "When "
});
formatter.match({
  "location": "Exo2Steps.iSearchFor(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I choose \"Men’s lightweight casual running shoes White\" as product",
  "keyword": "And "
});
formatter.match({
  "location": "Exo2Steps.iChooseAsProduct(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \"Black\" as color and \"UK 10\" as size",
  "keyword": "And "
});
formatter.match({
  "location": "Exo2Steps.iSelectAsColorAndAsSize(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add the product to the cart",
  "keyword": "And "
});
formatter.match({
  "location": "Exo2Steps.iAddTheProductToTheCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect \"GBP 24.99\" as a total price",
  "keyword": "Then "
});
formatter.match({
  "location": "Exo2Steps.iExpectAsATotalPrice(String)"
});
formatter.result({
  "status": "passed"
});
});