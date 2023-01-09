# Итоговый проeкт

 Вариант 5

Последовательность работы над проектом

1. Разрабатываю набор классов с составом полей из CSV-файла.
  ![image](https://user-images.githubusercontent.com/74453414/211375481-c57cd210-6de4-4331-a909-d8a6b28a5453.png)

2. Распарсив данные в файле CSV, по ним создаю набор объектов, заполняя все необходимые поля.

    Для работы с CSV-файлом скачиваем необходимую библиотеку OpenCSV

     Каждый новый экземпляр класса записываем в list, в котором хранятся данные из CSV-файла.
     
     ![image](https://user-images.githubusercontent.com/74453414/211376697-01bf676d-b3d8-4a41-98f2-909f592a66a7.png)

3. Далее создаем файл БД SQL Lite и подключить ее к проекту.
  
     Для этого необходимо скачать библиотеки для работы с SQlite
     
    ![image](https://user-images.githubusercontent.com/74453414/211377895-69b96ce5-7cfc-401d-8149-d5a2937826c2.png)

4. В БД создаю таблицу согласно набору объектов.
  
    ![image](https://user-images.githubusercontent.com/74453414/211378259-eda5c306-4e26-4dbf-baab-e186fb3e35e7.png)

5. Все данные из набора объектов сохраняю в БД.
  
    ![image](https://user-images.githubusercontent.com/74453414/211379459-6291217b-5c64-4c44-bad2-87bdfeec7f97.png)

6. Набор SQL-запросов к БД согласно своему варианту

     Первое задание: Постройте график по среднему количеству землетрясений для каждого года
     
     ![image](https://user-images.githubusercontent.com/74453414/211379786-8480c4d9-2818-4617-8ded-9629d01ad442.png)
  
     Результат запроса:
     
    ![image](https://user-images.githubusercontent.com/74453414/211380701-7808f5df-3d92-4801-b464-536d0d9d0309.png)

    Второе задание: Выведите в консоль среднюю магнитуду для штата "West Virginia"
    
    ![image](https://user-images.githubusercontent.com/74453414/211382618-c73b3389-40f6-4d03-a47e-8886f4c8096d.png)

    Результат запроса:
    
    ![image](https://user-images.githubusercontent.com/74453414/211381646-6c89e209-f935-4d25-8708-f58ee39e4a6d.png)

    Третье задание: Выведите в консоль название штата, в котором произошло самое глубокое землетрясение в 2013 году
    
    ![image](https://user-images.githubusercontent.com/74453414/211380163-981f9208-b55a-4fe3-95af-d9879949d682.png)
    
    Результат запроса:
    
    ![image](https://user-images.githubusercontent.com/74453414/211381759-b2ee39f3-d543-4be2-8148-e91eaeb3c377.png)
