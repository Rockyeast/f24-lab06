# 17214-24fall-lab06: Testing Infrastructure in Java

This repository is set up for testing with _JUnit_ and test coverage with _Jacoco_, both automated through _Maven_.

You will likely want to explore IDE integration for test execution and coverage in your IDE, but also ensure that tests still execute with Maven in a Continuous Integration environment (e.g. github actions).

The following commands might be useful:

* `mvn clean` reset the build
* `mvn test` execute tests and write a test coverage report in `target/site/jacoco/index.html`
* `mvn site` build and test the project and write results in `target/site/index.html` (includes coverage and test results)

See the comments in `pom.xml` for technical details of this setup.

此仓库已通过 JUnit 设置测试，并通过 Jacoco 设置测试覆盖率，两者都通过 Maven 自动化完成。

您可能需要探索在 IDE 中集成测试执行和覆盖率功能，但同时确保测试仍能在持续集成环境（例如 GitHub Actions）中通过 Maven 执行。

以下命令可能会对您有所帮助：

mvn clean 重置构建
mvn test 执行测试并将测试覆盖率报告写入 target/site/jacoco/index.html
mvn site 构建并测试项目，并将结果写入 target/site/index.html（包括覆盖率和测试结果）
有关此设置的技术细节，请参阅 pom.xml 中的注释。
