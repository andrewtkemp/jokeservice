Joke Service
Jokes-R-Us.com is a service that will store and retrieve jokes for clients.

Create an api from scratch that will fulfill the following requirements...

Required Endpoints
POST: new joke - accept any joke in one of the specified categories
GET: all jokes in db
GET: all jokes containing a given search string (bonus: add optional category to search)
GET: all jokes by category
GET: random joke by optional category (see sql below)
PATCH: update the category, or text of a joke
DELETE: delete a joke by id
Joke Entity
jokeId : Long PK
category: String Values { TECHNOLOGY,DADJOKES,MOMJOKES,KIDJOKES,KNOCKKNOCK }
joke: String LONGTEXT