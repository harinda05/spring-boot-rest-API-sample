# spring-boot-rest-API-sample

© 2019 Expedia.com v20
<br />

# Requirement #1: Flight Search <br />

Develop an application that will give you available flights for a given search query. You have
an inventory of the following flights: <br />
{
"flights": [
{
"flight": "Air Canada 8099",
"departure": "7:30AM"
},
{
"flight": "United Airline 6115",
"departure": "10:30AM"
},
{
"flight": "WestJet 6456",
"departure": "12:30PM"
},
{
"flight": "Delta 3833",
"departure": "3:00PM"
}
]
}<br />
To search a flight, you simply enter the time of the departure. Your flight search
algorithm will only display flights at a distance (plus or minus) of 5 hours from the
time you select for your departure. For example, if you search for a 6AM flight, you
will see both the 7:30AM and the 10:30AM flights in the results.<br />
Please implement a REST service to display the flights for different queries with
what you consider would be the best implementation for this scenario. <br />
© 2019 Expedia.com v20<br />
#Requirement #2: Credit Card Validator<br />
Develop an application that will validate credit cards based on the following
requirements:<br />
• Only Visa and MasterCard are accepted.<br />
• All card numbers have 16 digits.<br />
• Card numbers can optionally include spaces every 4 digits.<br />
• Visa card numbers start with a 4.<br />
• MasterCard card numbers start with the numbers 51 through 55.<br />
• The final digit of the card (verification digit) must be validated against the
Luhn formula.<br />
• Expiration dates must use the format MM/YY (e.g. 01/19 represents
January 2019).<br />
• Expiration dates must be in the future.<br />
• Credit cards must not be present on the blacklist (see below).<br />

Here is a blacklist of cards that have been detected as high risk by our fraud
prevention team. These cards must not pass validation:<br />
{
 "blacklist":[
 "4788 3845 3855 2446",
 "5144 3854 3852 3845"
 ]
}<br />
Please implement a REST service that will take as input credit cards numbers and
their expiration date and provide a response if the validation passes or not. Also,
if the credit card has been blacklisted, the service must respond with an
appropriate response. The details of the implementation is up to you, considering
what would be the best way to solve this problem.
