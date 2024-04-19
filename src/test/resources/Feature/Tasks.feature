# language: ru

  @withdrawal
  Функция: Добавление товара через веб интерфейс

    Предыстория:
    * Открыть странице по адресу http://149.154.71.152:8080/

    @success
    Сценарий: Добавления товара
      * нажимаем на строку Песочница
      * в выпадающем списка нажимаем на Товары
      * видим список товаров
      * нажимаем на кнопку Добавить
      * открывается окно Добавления товара
      * кликаем по полю Наименование
      * вводим название Бамия
      * кликаем по выпадающему списку Тип
      * выбираем тип овощ
      * кликаем по чек-боксу Экзотический
      * нажимаем на кнопку Сохранить
      * проверяем, что товар добавился в список товаров

    @success
    Сценарий: Удаления добавленного товара
      * нажимаем на строку Песочница
      * в выпадающем списка нажимаем на Товары
      * видим список товаров
      * нажимаем на строку Песочница
      * в выпадающес списке нажимаем Сброс данных
      * проверем, что добавленный товар удалился