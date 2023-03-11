# Проект по автоматизации UI тестирования для сайта KonturUiTests

## 📘 Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Варианты запуска тестов](#running_woman-варианты-запуска-тестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Allure-отчет](#-allure-отчет)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-Jira)
- [Уведомление в Telegram с использованием бота](#-уведомление-в-telegram-с-использованием-бота)
- [Видео запуска одного из тестов в Selenoid](#-видео-запуска-одного-из-тестов-в-selenoid)

## :computer: Использованный стек технологий

<p align="center">
<img width="6%" title="Java" src="src/test/resources/img/logo/Java.svg">
<img width="6%" title="Allure Report" src="src/test/resources/img/logo/Allure_Report.svg">
<img width="6%" title="Allure TestOps" src="src/test/resources/img/logo/AllureTestOps.svg">
<img width="6%" title="IntelliJ IDEA" src="src/test/resources/img/logo/Intelij_IDEA.svg">
<img width="6%" title="Selenide" src="src/test/resources/img/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="src/test/resources/img/logo/Selenoid.svg">
<img width="6%" title="Gradle" src="src/test/resources/img/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="src/test/resources/img/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="src/test/resources/img/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="src/test/resources/img/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="src/test/resources/img/logo/Telegram.svg">
</p>

Параметризованные автотесты написаны на <code>Java</code> с использованием <code>Gradle</code> и <code>JUnit 5</code>.
Для UI тестов используется фреймворк [Selenide](https://selenide.org/).
Тесты можно запускать локально или удаленно с помощью [Selenoid](https://aerokube.com/selenoid/).
Сборка в <code>Jenkins</code> реализована с формированием Allure-отчета и отправкой уведомления с результатами тестирования в <code>Telegram</code> после завершения прохождения тестов.

#### Allure-отчет включает в себя:
* названия тестов с шагами выполнения;
* скриншот страницы в браузере в момент завершения автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения UI тестов.

## Варианты запуска тестов

### Локальный запуск тестов
С параметрами по умолчанию
```
gradle clean test -Denv=local
```

При необходимости можно изменить параметры запуска
```
gradle clean test
${TASK}
-Dbrowser=${BROWSER}
-Dversion=${VERSION}
-Dbrowsersize=${SIZE}
```

### Запуск тестов на удаленном браузере
```
gradle clean test -Denv=server
```
При необходимости можно изменить параметры запуска

```
gradle clean test -Denv=remote
-Dbrowser=${BROWSER}
-Dversion=${VERSION}
-Dbrowsersize=${SIZE}
```

### Параметры сборки

* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>VERSION</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>109.0</code>.
* <code>SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По-умолчанию - <code>1024x768</code>.

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="src/test/resources/img/logo/Jenkins.svg"> Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/Kontur_ru_Ui_Tests/">*Jenkins job*</a>

<p align="center">
<img title="Jenkins Build" src="src/test/resources/img/screenshots/jenkinsBuild_.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="src/test/resources/img/logo/Allure_Report.svg"> Allure-отчет
### <a target="_blank" href="https://jenkins.autotests.cloud/job/Kontur_ru_Ui_Tests/11/allure/#">*Overview*</a>

<p align="center">
<img title="Allure Overview" src="src/test/resources/img/screenshots/allureReportMain_.png">
</p>

### *Результат прохождения параметризованных тестов с описанием  и шагами выполнения*

<p align="center">
<img title="Test Results in Alure" src="src/test/resources/img/screenshots/allureReportTests_.png">
</p>


## <img width="4%" style="vertical-align:middle" title="Telegram" src="src/test/resources/img/logo/AllureTestOps.svg"> Интеграция с Allure TestOps
### *Allure TestOps* <a target="_blank" href="https://allure.autotests.cloud/project/1998/dashboards">*Dashboard*</a>

<p align="center">  
<img title="Allure TestOps Dashboard" src="src/test/resources/img/screenshots/allureTestOpsDashboard_.png">  
</p>  

### *Тест кейсы*

<p align="center">  
<img title="Allure TestOps Tests" src="src/test/resources/img/screenshots/allureTestOpsTestCases_.png">  
</p>

### *Запуски*

<p align="center">  
<img title="Allure TestOps Tests" src="src/test/resources/img/screenshots/allureTestOpsLaunches_.png">  
</p>


## <img width="4%" style="vertical-align:middle" title="Telegram" src="src/test/resources/img/logo/jiraLogo.png"> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-588">**Jira**</a>


<p align="center">  
<img title="Jira" src="src/test/resources/img/screenshots/jira_.png">  
</p>  


## <img width="4%" style="vertical-align:middle" title="Telegram" src="src/test/resources/img/logo/Telegram.svg"> Уведомление в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически отправляет сообщение с отчетом прохождения тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="src/test/resources/img/screenshots/notificationTelegram_.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Selenoid" src="src/test/resources/img/logo/Selenoid.svg"> Видео запуска одного из тестов в Selenoid

Для каждого теста выполняется запись видео. Ниже представлен пример видео прохождения теста.
<p align="center">
  <img title="Selenoid Video" src="src/test/resources/img/gif/video.gif">
</p>
