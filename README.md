# Проект автоматизации тестирования для http://sportmaster.ru

<img src="images/screenshots/Sportmaster.png">

##  Используемые инструменты

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="TestOps" src="images/logo/Allure-ee-logo.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

>В данном проекте автотесты написаны на <code>Java</code> с использованием <code>Selenide</code> для UI тестов.
> 
> В качестве библиотеки для модульного тестирования используется <code>JUnit 5</code>.
>
> Для автоматизированной сборки проекта используется <code>Gradle</code>.
>
> <code>Selenoid</code> выполняет запуск браузеров в контейнерах <code>Docker</code>.
>
> <code>Allure Report</code> формирует отчет о запуске тестов.
>
> <code>Jenkins</code> выполняет запуск тестов.
>
> После завершения прогона отправляются уведомления с помощью бота в <code>Telegram</code>.

## Запуск тестов
<details>
<summary>Подробнее ...</summary>

### Локальный запуск тестов

```./gradlew clean test```

### Локальный запуск тестов в Selenoid
<details>
<summary>Шаги запуска</summary>

>1. Создать файл с проперти
>> * путь указать ```./src/test/resources/config/remoteBrowser.properties```
>> * добавить данные в файл, пример( ```src/test/resources/config/exampleRemoteBrowser.properties``` )
>2. Запустить тесты
>>```./gradlew clean test -DselenoidURL=${SELENOIDURL}```
</details>


### Удаленный запуск тестов в Jenkins
<details>
<summary>Шаги запуска</summary>

>1. Создать файл с проперти в Jenkins
>> * путь указать ```./src/test/resources/config/remoteBrowser.properties```
>> * добавить данные в файл, пример( ```src/test/resources/config/exampleRemoteBrowser.properties``` )
>2. Создать файл с настройками для Telegram в Jenkins
>> * путь указать ```./notifications/telegram_config.json```
>> * добавить данные в файл, пример(```./notifications/example_telegram_config.json```)
>3. Запустить тесты
>>```
>>clean
>>test
>>-DselenoidURL=${SELENOIDURL}
>>```
</details>
</details>



# Пример запуска тестов Jenkins и отчеты
## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Главная страница сборки Jenkins

<p align="center">
  <img src="images/screenshots/jenkins.png">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure_Report.svg"> Отчет о результатах тестирования в Allure Report

### Главная страница Allure-отчета

<p align="center">
<img title="Allure Overview" src="images/screenshots/allure_overview.png">
</p>

### Страница с тестами

<p align="center">
<img title="Allure Behaviors" src="images/screenshots/allure_behaviors.png">
</p>

## <img width="4%" title="TestOps" src="images/logo/Allure-ee-logo.svg"> Отчеты в TestOps

<p align="center">
<img title="" src="images/screenshots/testops.png">
<img title="" src="images/screenshots/testops_launches.png">
</p>


## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

> После завершения сборки бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом.
<p align="center">
<img title="Telegram Notifications" src="images/screenshots/telegram_notifications.png">
</p>




