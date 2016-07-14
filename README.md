Open best farm
--------------

[![Travis CI](https://travis-ci.org/bieli/open-best-farm.svg?branch=master)](https://travis-ci.org/bieli/open-best-farm)

How to start
==============

```

$ ./gradlew clean build run

:clean
:compileJava
:compileGroovy UP-TO-DATE
:processResources UP-TO-DATE
:classes
:jar
:assemble
:compileTestJava UP-TO-DATE
:compileTestGroovy
:processTestResources UP-TO-DATE
:testClasses
:test
:check
:build
:run


|     name |    count |
+----------+----------+
|     CORN |        1 |
|     MILK |        1 |
|      EGG |        2 |

 BUTTER count: 0
 EGG count: 2
 MILK count: 1
 CREAM count: 0
 FeedMill


------ feedMill.run product1

   1 -> feedMill.tick(product1)

   2 -> feedMill.tick(product1)

   3 -> feedMill.tick(product1)

   4 -> feedMill.tick(product1)

   5 -> feedMill.tick(product1)


------ feedMill.stop product1


------ feedMill.run product2

   1 -> feedMill.tick(product2)

   2 -> feedMill.tick(product2)

   3 -> feedMill.tick(product2)

   4 -> feedMill.tick(product2)

   5 -> feedMill.tick(product2)

   6 -> feedMill.tick(product2)

   7 -> feedMill.tick(product2)

   8 -> feedMill.tick(product2)

   9 -> feedMill.tick(product2)


------ feedMill.stop product2

BUILD SUCCESSFUL

Total time: 10.685 secs

```

TODOs
==============
 [x] create repository with first conceptual version
 [ ] create document/concept with REST API for "farm like" games
 [ ] REST API prototype (with storage in RAM) with integration tests
 [ ] creating state machine prototype
 [ ] try to self-consume REST API service in simple game with GUI / UI
 [ ] implementing persistent storage (i.e. RIAK, Couchbase, Redis, MySQL/MariaDB, MongoDB, ...)
 
