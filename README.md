Микросервис на языке Java 11-ой версии c использование фреймворка String Boot. Собирается проект maven-ном.
Приложение работает на порту 8080
Запустить приложение можно при помощью IDEA или из консоли с помощью maven (mvn spring-boot:run)


Реализованно два Endpoint:
    - GET: /uploadRates/{date} где {date} - дата в формате "YYYY-MM-dd"
    Данный Endpoint выполняет запрос по адресу: https://www.nbrb.by/api/exrates/rates?ondate={date}&periodicity=0
    И если были полученные данные, то сохраняет их в коллекцию.
    Возвращает булево значение в зависимости от того были полученны данные или нет. Также в заголовок доьавлено переменная
    CRC32, а значение для которой генерируется с строкового представления булевого результата оперции.
    Если во время данного запроса что-то пойдет не так, то будет выведена ошибка.

    - GET: /getRate/{date}/{currencyCode} где {date} - дата в формате "YYYY-MM-dd", {currencyCode} - цифровое представление валюты
    Данный Endpoint выполняет запрос по адресу: https://www.nbrb.by/api/exrates/rates/{currencyId}?ondate={date}
    Мы получает курс валют на выбранную данную. Затем на предыдущий день.
    После этого сравниваем курсы и записываем результат в переменную, которая будет добавлена к курс на выбранную дату с пояснениями.
    Возвращается объект валюты и курса запроса с пояснением по изменению курса с предыдущим днем.
    Также в заголовок добавлено переменная CRC32, а значение для которой генерируется с строкового представления
    возвращаемого объекта.
    Если во время данного запроса что-то пойдет не так, то будет выведена ошибка.

