# Open best farm [![Travis CI](https://travis-ci.org/bieli/open-best-farm.svg?branch=master)](https://travis-ci.org/bieli/open-best-farm) [![Coverage Status](https://coveralls.io/repos/github/bieli/open-best-farm/badge.svg?branch=master)](https://coveralls.io/github/bieli/open-best-farm?branch=master) #
==============


How to start
--------------

```

$ ./gradlew clean build test jacocoTestReport run

> Configure project :
The ConfigurableReport.setDestination(Object) method has been deprecated and is scheduled to be removed in Gradle 5.0. Please use the method ConfigurableReport.setDestination(File) instead.
        at build_895p4jfozgj6zftdes0yrvflt$_run_closure3$_closure6.doCall(/home/mbielak/Pulpit/_priv/projects/open-best-farm/build.gradle:45)

> Task :run
d780873e-f617-4770-8087-3ef617a770ff >> ProductImpl{productKind=EGG, points=1, price=3, stars=2, ticks=3, tick=0}
4a76e1df-f985-4faf-b6e1-dff9856faf05 >> ProductImpl{productKind=CORN, points=2, price=2, stars=1, ticks=7, tick=0}
0b61edc5-5d03-4be7-a1ed-c55d03dbe7de >> ProductImpl{productKind=EGG, points=1, price=3, stars=2, ticks=3, tick=0}
137320bc-419a-4e35-b320-bc419a6e352d >> ProductImpl{productKind=MILK, points=4, price=6, stars=5, ticks=5, tick=0}
f49a13f0-347b-4dd2-9a13-f0347bedd26e >> ProductImpl{productKind=CREAM, points=2, price=5, stars=3, ticks=1, tick=0}
02b02363-559e-455e-b023-63559e055e9c >> ProductImpl{productKind=BUTTER, points=2, price=5, stars=3, ticks=2, tick=0}
961ecbc3-1921-4352-9ecb-c319211352a7 >> ProductImpl{productKind=EGG, points=1, price=3, stars=2, ticks=3, tick=0}


 ============= Barn report ============= 

|     name |    count |    ticks |
+----------+----------+----------+
|      EGG |        3 |        3 |
|     CORN |        1 |        7 |
|     MILK |        1 |        5 |
|    CREAM |        1 |        1 |
|   BUTTER |        1 |        2 |


 =============== FeedMill ============== 


------ START: feedMill.run - product: ProductImpl{productKind=EGG, points=1, price=3, stars=2, ticks=3, tick=0}

  -> feedMill.tick(): 1, product.getTick(): 1

  -> feedMill.tick(): 2, product.getTick(): 2

  -> feedMill.tick(): 3, product.getTick(): 3

------ STOP: feedMill.stop - product: ProductImpl{productKind=EGG, points=1, price=3, stars=2, ticks=3, tick=3}


------ START: feedMill.run - product: ProductImpl{productKind=CORN, points=2, price=2, stars=1, ticks=7, tick=0}

  -> feedMill.tick(): 1, product.getTick(): 1

  -> feedMill.tick(): 2, product.getTick(): 2

  -> feedMill.tick(): 3, product.getTick(): 3

  -> feedMill.tick(): 4, product.getTick(): 4

  -> feedMill.tick(): 5, product.getTick(): 5

  -> feedMill.tick(): 6, product.getTick(): 6

  -> feedMill.tick(): 7, product.getTick(): 7


------ STOP: feedMill.stop - product: ProductImpl{productKind=CORN, points=2, price=2, stars=1, ticks=7, tick=7}


------ START: feedMill.run - product: ProductImpl{productKind=MILK, points=4, price=6, stars=5, ticks=5, tick=0}

  -> feedMill.tick(): 1, product.getTick(): 1

  -> feedMill.tick(): 2, product.getTick(): 2

  -> feedMill.tick(): 3, product.getTick(): 3

  -> feedMill.tick(): 4, product.getTick(): 4

  -> feedMill.tick(): 5, product.getTick(): 5


------ STOP: feedMill.stop - product: ProductImpl{productKind=MILK, points=4, price=6, stars=5, ticks=5, tick=5}


------ START: feedMill.run - product: ProductImpl{productKind=CREAM, points=2, price=5, stars=3, ticks=1, tick=0}

  -> feedMill.tick(): 1, product.getTick(): 1


------ STOP: feedMill.stop - product: ProductImpl{productKind=CREAM, points=2, price=5, stars=3, ticks=1, tick=1}


------ START: feedMill.run - product: ProductImpl{productKind=BUTTER, points=2, price=5, stars=3, ticks=2, tick=0}

  -> feedMill.tick(): 1, product.getTick(): 1

  -> feedMill.tick(): 2, product.getTick(): 2


------ STOP: feedMill.stop - product: ProductImpl{productKind=BUTTER, points=2, price=5, stars=3, ticks=2, tick=2}
result: limit: 10, str: net.bieli.machine.FeedMill@a09ee92


BUILD SUCCESSFUL in 4s
10 actionable tasks: 10 executed


```

TODOs
-----

- [x] create repository with first conceptual version
- [x] creating state machine prototype
- [x] adding conccurent usage example and unit tests
- [ ] create document/concept with REST API for "farm like" games
- [ ] REST API prototype (with storage in RAM) with integration tests
- [ ] try to self-consume REST API service in simple game with GUI / UI
- [ ] implementing persistent storage (i.e. RIAK, Couchbase, Redis, MySQL/MariaDB, MongoDB, ...)
- [ ] service as backend for text mode game play
- [ ] testing game with this backend by other developers
- [ ] find best UI game frameworka for implementing multiplatform game
- [ ] create background and graphics/prints fot game UI
- [ ] implementing game UI and connecting with this backend
- [ ] first ALPHA game release
- [ ] serving game on www/domain
