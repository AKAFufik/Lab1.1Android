Задания к лабораторным работам
Общие требования
Среда разработки по-умолчанию — Android Studio. Язык программирования — Java.
По своему желанию, можно использовать Kotlin, а также XCode/Swift при наличии
соответствующего оборудования.
Решения должны быть размещены в виде проекта в git репозитории (github/bitbucket).
Ссылку на git репозиторий надо прислать до дедлайна на почту: atorkhov@gmail.com
Минимальная версия API - 19.
Вводное задание No0
Скачать, установить и запустить Android Studio. Создать первое приложение с одной
активити. Добавить кнопку и сделать какое-либо действие по нажатию на кнопку.
Задание No1
Реализовать приложение, состоящее из двух активити:
Первое активити - это splash screen. Полноэкранное без ActionBar, c одной картинкой
(или анимацией по желанию) по центру. Активити показывается 2 секунды, потом
запускает второе и первое «умирает». Ожидание необходимо реализовать через
Thread.sleep.
Второе активити представляет из себя список из 1000000 (один миллион) элементов,
где четные элементы имеют серый фон (#CCCCCC), а нечетные — белый (#FFFFFF).
Каждый элемент содержит картинку и текст. Картинка может быть любая, и она не
меняется для элементов (выбирайте маленькую). Текст каждого элемента — это его
индекс текстом (пример «cто двенадцать»). Отсчет начинается с единицы. Шрифт
большой.
Приложение должно нормально обрабатывать поворот экрана. При нажатии на
клавишу back во втором активити приложение должно закрываться.
Deadline - 23.03.2018 00:00.