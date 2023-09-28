Feature: Search and Place the order for Products

#Scenario: Search Experience for product search in both Home and Offers page

#Given User is on GreenCart Landing page
#When User searched with Shortname "Tom" extracted actual name of the product
#Then User searched for "Tom" shortname in offers page 
#And Validate product name in offers page matches with Landing Page

@OffersPage
Scenario Outline: Search Experience for product search in both Home and Offers page

Given User is on GreenCart Landing page
When User searched with Shortname <Name> extracted actual name of the product
Then User searched for <Name> shortname in offers page 
And Validate product name in offers page matches with Landing Page

Examples:
| Name |
| Tom  |
| Beet |


