FROM anapsix/alpine-java
COPY target/sample-*.jar /sample.jar
EXPOSE 8080
CMD ["java","-jar","/sample.jar"]