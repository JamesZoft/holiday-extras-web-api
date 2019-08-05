This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

There is an associated Dockerfile - to launch it, just build it:

`docker build -t frontend .`

and then run it:

`docker run -it -p 3000:3000 frontend`

It should be noted that at this stage, the back-end to which this is tied to is hard-coded, 
so if you wish to run both the front and back-end locally, you will need to change anywhere 
that has
 
`https://test-spring-boot-jr.herokuapp.com`
  
to
   
`http://localhost:3000`

Currently the front end is being served at 

[https://holiday-extras-front-end.herokuapp.com/](https://holiday-extras-front-end.herokuapp.com/) 