# AlterraShop QA - Mini Project

Quality Assurance testing project for **AlterraShop** e-commerce platform.

## Project Structure

```
MiniProject/
├── api-testing/                        # REST API Performance Testing
│   └── AlterraShop-API-TestPlan.jmx   # JMeter test plan
│
├── web-testing/                        # Web UI Automation Testing
│   ├── pom.xml                         # Maven + Serenity BDD dependencies
│   └── src/test/
│       ├── java/id/alta/qa/
│       │   ├── pages/                  # Page Object classes
│       │   ├── steps/                  # Cucumber step definitions
│       │   └── runners/                # Test runner
│       └── resources/
│           ├── features/               # Gherkin feature files
│           └── serenity.conf           # Serenity configuration
│
├── docs/
│   └── TestScenario&Case.md           # Test scenarios & cases documentation
│
├── .gitignore
└── README.md
```

## Tech Stack

| Area | Tool | Version |
|------|------|---------|
| API Testing | Apache JMeter | 5.4.3 |
| Web UI Testing | Serenity BDD + Cucumber | 3.9.8 / 7.14 |
| Browser Automation | Selenium WebDriver | 4.15.0 |
| Language | Java | 11 |
| Build Tool | Maven | 3+ |

## API Under Test

- **Base URL:** `https://be-qa.alta.id`
- **Endpoints:** Authentication, Categories, Products, Orders, Ratings, Comments

## How to Run

### API Testing (JMeter)
```bash
jmeter -n -t api-testing/AlterraShop-API-TestPlan.jmx -l results.jtl
```

### Web UI Testing (Serenity)
```bash
cd web-testing
mvn clean verify
```

Reports will be generated at `web-testing/target/site/serenity/index.html`

## Team

Project Avengers
