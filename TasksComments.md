## Part 2

•	Functional and non-functional requirements were not provided for the task. For that reason, I didn’t check all the boundaries for parameters. I assumed that tax was in the range of 0 to 100. I also assumed the amount can only be in positive numbers. I added extra tests to check the vulnerabilities of the currency as I thought they could be related to the input field.
•	I assumed that no inputs can be empty.
•	In the current project all tests were in one file, so I added more tests in the same file but I considered that company standards may be different. I will follow them in the future when these standards are provided.

## Part 3

•	All requests were returned with status 200. I would recommend returning invalid requests with a different status code, for example 404.
•	Bugs/issues were noticed:
-	The message “Pokémon not found" is established in the requirements, but the app returned a different message – “No Pokémon found!”
-	The search field doesn’t accept terms with capitals letters. I think that this restriction was set in the front end, but the back end doesn’t reflect it. I would recommend making changes in the front end to accept all letters.
-	I’ve noticed it returned a list of results instead of a dropdown for a successful result
-	Alphabetical order doesn’t apply to the search results.
-	Some Pokemons have characteristics for Base happiness more than 100% (Lopunny 140%)
-	Some Pokemons have duplicates in the Evolution Chain (Hattrem-Hattrem)
-	Search doesn’t accept dashes. However, the name nidoran-f includes a dash which makes the search inva-lid
•	I started by writing manual tests and collected them in the TestCases file, but It’s possible to run automation tests with Postman collection using Newman. All collections are in the PostmanCollections folder.
•	To run all Automation tests at once with Newman run:

npm install -g newman   

newman run InvalidSearchTerm.postman_collection.json -d ../TestDataForPokemon/invalidSearchTerm.csv && newman run ValidSearchTerm.postman_collection.json -d ../TestDataForPokemon/validSearchTerm.csv && newman run E2E.postman_collection.json && newman run SearchRequest.postman_collection.json
