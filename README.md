# AirportsDatabaseProject

In the context of my bachelors degree, I was asked to develop an entity-relationship model that represents the above process and to
converted to a relational model. 
Then implement the Database (DB) and develop a Java application through it
of which, the user will be able to enter data in the NW and display the results of
questions listed below. No GUI was developed for the application.

## Specifically, the application will contain a rudimentary menu of options and allow the user to:

i. To update NW with flights, customers and ticket reservations for specific flights per
airline.
ii. Retrieve the list of flights available for each airline (whether it exists or not
availability).
iii. Retrieves the list of flights that are full (no available - empty seats, either
economy nor business class) at the time of search.
iv. Retrieve the list of available flights between Toronto (Airport_Code: YYZ) and
New York (Airport_Code: JFK), sorted by flight number.
v. To execute ticket booking orders of a specific flight that offers a specific one
airline. The flight and the airline will be parameters given by the user.
vi. To retrieve specific reservation based on reservation number and be registered (updated) as
"held-paid" in the system after payment of the remaining amount of its consideration
reserved ticket.
vii. To retrieve all canceled flight ticket reservations for a specific/selected
airline (which it will take as a parameter) and then delete them.