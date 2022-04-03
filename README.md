# Проект по автоматизации тестирования для Veeam
<a target="_blank" href="https://www.veeam.com/ru/">Веб сайт Veeam</a>

<p align="center">
<img title="Allure Graphics" src="images/screens/Veeam.png">
</p>

## :drop_of_blood: Содержание:

- [Технологии и инструменты](#earth_africa-технологии-и-инструменты)
- [Реализованные проверки](#earth_africa-Реализованные-проверки)
- [Сборка в Jenkins](#earth_africa-Jenkins-job)
- [Запуск из терминала](#earth_africa-Запуск-тестов-из-терминала)
- [Allure отчет](#earth_africa-Allure-отчет)
- [Тест-кесы в Allure Testops](#earth_africa-Тест-кесы-в-Allure-Testops)
- [Отчет в Telegram](#earth_africa-Уведомление-в-Telegram-при-помощи-бота)
- [Видео примеры прохождения тестов](#earth_africa-Примеры-видео-о-прохождении-тестов)

## :bird: Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://qameta.io/"><img src="images/logo/Allure_TO.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## :boom: Реализованные проверки

- ✓ Поиск вакансии QA Automation
- ✓ Открытие статьи о Biocad и Exchange (параметризованные тесты)
- ✓ Поиск информации о компании Biocad в скачанном PDF файле
- ✓ Смена языка с русского на английский
- ✓ Заполнение Запроса в отдел продаж

## <img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/10_DikayaAV_diploma/"> job </a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/10_DikayaAV_diploma/"><img src="images/screens/Jenkins.png" alt="Jenkins"/></a>
</p>

### :maple_leaf: Параметры сборки в Jenkins:

- browser (браузер, по умолчанию chrome)
- version (версия браузера, по умолчанию 91.0)
- size (размер окна браузера, по умолчанию 1920x1080)
- remoteUrl (логин, пароль и адрес удаленного сервера selenoid)

## :japanese_ogre: Запуск тестов из терминала

Локальный запуск:
```
gradle clean test
```

Удаленный запуск:
```
clean
test
-Dbrowser=${BROWSER}
-Dversion=${VERSION}
-Dsize=${BROWSER_SIZE}
-Durl=${REMOTE_URL}
```

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/10_DikayaAV_diploma/allure/">Allure report</a>

### :lady_beetle: Основное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/Allure_Report3.png">
</p>

### :cherries: Тесты

<p align="center">
<img title="Allure Tests" src="images/screens/Allure_Report4.png">
</p>

### :cut_of_meat: Графики

<p align="center">
<img title="Allure Graphics" src="images/screens/Allure_Report2.png">
</p>

## <img src="images/logo/Allure_TO.svg" width="25" height="25"  alt="Allure"/></a> Отчеты <a target="_blank" href="https://allure.autotests.cloud/project/1176/dashboards">в Allure Testops</a>

### :cut_of_meat: Дашборд
<p align="center">
<img title="Allure Graphics" src="images/screens/Allure_TO.png">
</p>

### :cut_of_meat: Тест-кейсы
<p align="center">
<img title="Allure Graphics" src="images/screens/Allure_TO2.png">
</p>

### :cut_of_meat: Запуски
<p align="center">
<img title="Allure Graphics" src="images/screens/Allure_TO3.png">
</p>

## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Уведомление в Telegram при помощи бота

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/Telegram.png" >
</p>


## <img src="images/logo/Selenoid.svg" width="25" height="25"  alt="Allure"/></a> Видео прохождения теста

<p align="center">
<img title="Selenoid Video" src="images/gif/test.gif" width="250" height="153"  alt="video"> 
</p>
