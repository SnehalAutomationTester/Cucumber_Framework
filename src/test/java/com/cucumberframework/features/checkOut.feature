Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search Experience for product search in both Home and Offers page

Given User is on GreenCart Landing page
When User searched with Shortname <Name> extracted actual name of the product
And Added "3" items of the seleceted product to cart
Then User proceed to checkout and validate the <Name> item in checkout page
And Verify user has ability to enter promo code and place the order
 
Examples:
| Name |
| Tom  |
