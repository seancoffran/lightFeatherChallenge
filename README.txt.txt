Import project as an existing maven project.
Build and execute

Using an online tool such as YARC, poster or postman.

URL:http://localhost:23456/api/encode 
Request body: 
{	
  "Message": "YOUR MESSAGE HERE",
  "Shift": <Integer value for character shifting>
}
Request example:
{	
  "Message": "My dad is #1",
  "Shift": 2
}

A successful resquest will return a 200 response and the shifted message.
The request response will also be written to file @ C:/Users/Public/challenge.txt
Any other request strings or formats will return 500.