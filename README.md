# SampleMokService

Добро пожаловать в демо проект мок-сервисов. В нем демонстрируется пример построения простого мок-сервиса с интеграцией необходимых зависимостей и примеры реализации простой автоматизации тестирования мок-сервиса на API с помощью Rest Assured/TestNG.

Для демонстрации механизмов мок-сервиса надо запустить mockService_jar. 

Для этого открываем его в Intellij idea и собираем jar файл.

```
1. Открываем File-project Structure - Artifacts.
2. Нажимаем + и добавляем JAR-from modules with dependencies
3. Выбираем в module mockService, в main class Mock
4. Жмем кнопку ОК.
5. Наверху в Idea жмем на вкладку Build-build artifacts - build.
6. К нам в директорию локально сохраняется jar файл в папке проекта в out/artifacts/mockService_jar
7. Переходим в консоль windows через win+r - cmd. 
8. переходим в папку с нашим jar 
9. Запускаем через java - jar *название файла*.jar
10. Вы великолепны :)
```


Далее можно запускать автотесты

```
1. Открываем их в Intellij в модуле autotestsMock.
2. Переходим в maven, выбираем профиль autotestsMock. Далее выбираем модуль autotestsMock-Lifecycle
3. Запускаем автотесты нажатием на test.
4. После прогона тестов открываем Plugins-allure. 
5. Жмем allure:serve. 
```


У нас открывается прекрасный отчет с результатами прогона автотестов на Mock
Вы великолепны (2)



Используемые фреймворки:
- [WireMock](https://wiremock.org/docs/)
- [Junit 4](https://wiremock.org/docs/junit-extensions/)
- [JsonPath](https://www.baeldung.com/guide-to-jayway-jsonpath)
- [jknack handlebars](https://github.com/jknack/handlebars.java)
- [Rest assured](https://rest-assured.io/)
- [TestNG + Allure](https://docs.qameta.io/allure-report/frameworks/java/testng)
