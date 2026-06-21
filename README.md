# Stellar Burgers — Unit Tests

Unit tests for the burger-assembly library of the **Stellar Burgers** training
service. The project covers the business logic of the `Bun`, `Ingredient`, and
`Burger` classes, including mocking of dependencies and verification of thrown
exceptions. Code coverage is measured with **JaCoCo**.

## Tech stack

- Java 11
- JUnit 4
- Mockito (mocking dependencies)
- JaCoCo (coverage report)
- Maven

## Test coverage

| Test class | Checks |
|---|---|
| `BunTests` | bun name and price are correct |
| `IngredientTests` | ingredient name, price, and type are correct |
| `BurgerTests` | setting the bun; adding/removing/moving ingredients; price calculation; receipt formatting; `IndexOutOfBoundsException` for invalid indices |
| `ParameterizedBurgerTest` | parameterized calculation of the total burger price |

Total: 14 tests. External dependencies (`Database`, ingredients) are isolated with Mockito.

## Project structure

```
src/
├── main/java/praktikum/      # code under test (Bun, Burger, Ingredient, ...)
└── test/java/                # tests
    ├── BunTests.java
    ├── BurgerTests.java
    ├── IngredientTests.java
    └── ParameterizedBurgerTest.java
```

## Running the tests

```bash
mvn clean test
```

## Coverage report (JaCoCo)

```bash
mvn clean verify
```

After the build the report is available at:

```
target/site/jacoco/index.html
```

Open `index.html` in a browser to see coverage per class and per line.
The utility classes `Praktikum` and `Database` are excluded from coverage.

## Requirements

- JDK 11+
- Maven 3.6+
