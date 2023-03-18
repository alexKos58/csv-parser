##Тестовое задание (Библиотека autocomplete вводимого текста)

Требуется написать консольное Java-приложение (JDK 11), позволяющее быстро искать данные аэропортов по вводимому пользователем тексту. 
Данные для программы берутся из файла. 
В нем находится таблица аэропортов со свойствами в формате CSV. За что отвечает каждая колонка – не важно.
После запуска программа выводит в консоль предложение ввести текст. Например,
пользователь вводит «Bo» и нажимает «Enter». Программа выводит список всех строк из
файла, вторая колонка которых начинается на «Bo».

**Нефункциональные требования**
- Перечитывать все строки файла при каждом поиске нельзя
(в том числе читать только определенную колонку у каждой строки).
- Создавать новые файлы или редактировать текущий нельзя
(в том числе использовать СУБД).
- Хранить весь файл в памяти нельзя
(не только в качестве массива байт, но и в структуре, которая так или иначе содержит все
данные из файла).
- Для корректной работы программе требуется не более 7 МБ памяти
(все запуски java –jar должны выполняться с флагом ).
- Скорость поиска должна быть максимально высокой с учетом требований выше.
- Сложность поиска меньше чем O(n), где n — число строк файла.
- Должны соблюдаться принципы ООП и SOLID.
- Ошибочные и краевые ситуации должны быть корректно обработаны.
- Использовать готовые библиотеки для парсинга CSV формата нельзя.