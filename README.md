# hifi_thattu_kada
TITLE		: HIFI_THATTU_KADA
DEVELOPER	: SIVA ANAND K S
TOOLS USED	: Spring Boot, gradle, war package, apache in build server, github repository, postgre sql, hibernate, tiles 2.2.2

Work Flow:

	1. 	We have a file name application.java with the main method. 
	2. 	As 	we know all know web application don't need main method, the spring boot changed it.
	3.	simply saying, when running the .war file, the main method is getting started.
	4. 	since we have the @ComponentScan annotation + gradle it scans all the packages, and observes all the configuration file while starting the server.
	5.	in out project we have the 2 configuration files named HibernateConfiguration.java and WebMvcConfig.java. 6. 	In WebMvcConfig.java file, we configure all the necessary beans, configuring view resolvers,configuring tiles 
	7. 	In the HibernateConfiguration.java, we create session for hibernate transaction, setting the DataSource and setting the transaction manager.   
	      (since, we have used tiles, it ll take care of this part)[removed]since we configured view resolver, prefix and suffix, it will automatically search for the index.jsp file in /WEB-INF/jsp/
	8. 	so now all set and ready to go.. while entering localhost:8080/hifi_thattu_kada/, it ll automatically trigger the @RequestMapping(value="/",method = RequestMethod.GET) inside UserController.java, then it ll forward to home. at this situation tiles is applying.
	9.	views.xml configured inside the WebMvcConfig.java, got activated. 
	10.	so, my project body and footer are same, only the header ll change. i have designed in that way. it ll take 1st header from, header.jsp and the remaining layout are same. after login the header ll change as loginheader.jsp



 	so, thats how we are seeing a page, technically, it is not one page, combination of 3 pages,header.jsp, body.jsp, footer.jsp, when the url, localhost:8080/hifi_thattu_kada/ is clicked.

