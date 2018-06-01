##Purpose
 測試spring boot framework ,miro service 以RESTful為基礎, mongo db測試
 

## Requirements
* docker
* docker-compose
* jdk 10
* 在docker-compose目錄,



以下是所需啟動的Server
* mongo <- docker latest
* mongo-express <- docker latest

## Spring boot framework integrate 3rd tools

run in command mode , needs install gradle 4.7 version above 

* insert test data test/java/com/sb/OrderMain.java

* run WebApplication for startup application
  * start docker-compose up -d
     
  * java -jar test-service-1.0.jar -Xmx3550m -Xms3550m -Xmn2g -Xss128k -XX:+UseParallelGC  -XX:MaxGCPauseMillis=100 -XX:+UseAdaptiveSizePolicy