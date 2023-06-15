Feature: Flight booking from makeMyTrip

@smoteSuit
Scenario Outline: Flight Booking for One Way trip
  Given User is on makemytrip landing page by hitting the url "<makemytripUrl>"
  And User chooses start "<From>" & destination "<To>"  places for trip
  When User provides departure date "<deptDate>" and return date "<returnDate>"
  And User chooses no of travelleres "<NoOfTraveller>" and click on search button


  Examples: 
    |makemytripUrl|From|To|deptDate|returnDate|NoOfTraveller|
    |https://www.makemytrip.com/|Kolkata|Delhi|16 Aug 2023| 19 Aug 2023|2|
