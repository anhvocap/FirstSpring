# Spring Boot
- url: https://start.spring.io/
- spring-demo has dependency: Spring Web, Spring Data JPA, Oracle Driver

# Plural Sight
- Create First Spring Boot Application: 
https://app.pluralsight.com/course-player?clipId=b7bc9b61-098a-4bcc-84db-bee51013d9a2

# Spring Boot config and environment
- External Sources: command line parameters, JNDI, OS environment variables
- Internal Sources: servlet parameters, property files, java configuration

# Customize and Override Spring Boot
- Order of precedence:
- 1. Command line args
- 2. SPRING_APPLICATION_JSON args
- 3. Servlet parameters
- 4. JNDI
- 5. Java System Properties
- 6. OS environment variable
- 7. Profile properties
- 8. Application properties
- 9. @PropertySource annotations
- 10. Default properties

# Spring Boot Containerless Architecture
- Original Deployment: Tomcat, Glassfish, Websphere, Spring Boot
- Support Containers: Tomcat, Jetty, Undertow

# Common cloud platform
- cloud foundry
- heroku
- google cloud
- aws
- ms azure

# Spring Framework: Overview of Spring Data
- https://github.com/dlbunker/ps-first-spring-boot-app
- Main modules: JPA, JDBC, MongoDB, Cassandra, Spring Data n
- Community modules: CouchBase, ElasticSearch, Hazelcast, Neo4j, Spring Data n

# ACID Transactional: Atomic, Consistent, Isolated, Durable
- Atomic: it either all happens or does not happen at all
- Consistent: the data written is valid according to the various contraints
- Isolated: other transactions can not see the result until the transaction is committed
- Durable: the results of the transaction are written to disk

# Spring Data: Repository + Query Generation
- https://github.com/dlbunker/ps-spring-data-jpa
- Spring Data Commons: Spring Data JPA, Spring JDBC, Spring Data KeyValue, Spring Data CouchBase, Spring Data Ne04j, Spring Data LDAP, Spring Data MongoDB, Spring Data Redis, Spring Data Hazelcast, Spring Data DynamoDB
