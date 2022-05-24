# SampleMokService

Добро пожаловать в демо проект мок-сервисов. В нем демонстрируется пример построения простого мок-сервиса с интеграцией необходимых зависимостей/

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


Используемые фреймворки:
- [WireMock](https://wiremock.org/docs/)
- [Junit 4](https://wiremock.org/docs/junit-extensions/)
- [JsonPath](https://www.baeldung.com/guide-to-jayway-jsonpath)
- [jknack handlebars](https://github.com/jknack/handlebars.java)
