FROM openjdk
MAINTAINER Dipankar Chatterjee <dipankar.c@hcl.com>
ADD target/Eligibility-Check-Service-1.0.jar Eligibility-Check-Service-1.0.jar
ENTRYPOINT exec java -jar /Eligibility-Check-Service-1.0.jar Eligibility-Check-Service
EXPOSE 12001