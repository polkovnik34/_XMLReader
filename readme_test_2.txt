---ИнициаторЗк---
Test_1 - ИнициаторЗк_1_Внешние - выбирается пустой номер ЗП и задача уходит в закупки
Test_2 - ИнициаторЗк_2_Внешние - выбирается выбирается ЗП и задача идет дальше - приходит эксперту
Test_3 - ИнициаторЗк_3_Внешние - выбирается выбирается ЗП с разным филиалом и задача идет дальше - задача приходит в закупки.
Test_4 - ИнициаторЗк_4_Внешние - выбирается выбирается несколько ЗП и задача идет дальше - приходит эксперту
Test_5 - ИнициаторЗк_5_Внешние - выбирается выбирается несколько ЗП, в одной ЗП не совпадает филиал и задача идет дальше - приходит в закупки
Test_6 - ИнициаторЗк_1_ЭДО - выбирается пустой номер ЗП и задача уходит в закупки
Test_7 - ИнициаторЗк_2_ЭДО - выбирается выбирается ЗП и задача идет дальше - приходит на заполнение номера поступления
Test_8 - ИнициаторЗк_3_ЭДО - выбирается выбирается ЗП с разным филиалом и задача идет дальше - задача приходит в закупки.
Test_9 - ИнициаторЗк_4_ЭДО - выбирается выбирается несколько ЗП и задача идет дальше - в СИ. Выбираются ЗП с разными типами закупок (ТМЦ и Услуги)
Test_10 -ИнициаторЗк_5_ЭДО - выбирается выбирается несколько ЗП, в одной ЗП не совпадает филиал и задача идет дальше - приходит в закупки
Test_11 - ИнициаторЗк_1_Дилеры - выбирается пустой номер ЗП и задача уходит в закупки
Test_12 - ИнициаторЗк_2_Дилеры - выбирается выбирается ЗП и задача идет дальше - приходит в ОЦО
Test_13 - ИнициаторЗк_3_Дилеры - выбирается выбирается ЗП с разным филиалом и задача идет дальше - задача приходит в закупки.

---ИсполнительЗК---
Test_1 - ИсполнительЗК_1_Внешние - задача отправляется эксперту на запрос информации
Test_2 - ИсполнительЗК_2_Внешние - задача отправляется на корректировку
Test_3 - ИсполнительЗК_3_Внешние - задача отправляется менеджеру для изменения филиала
Test_4 - ИсполнительЗК_4_Внешние - Подтверждается ЗП и задача отправляется на следующий этап - задача приходит эксперту
Test_5 - ИсполнительЗК_5_Внешние - указывается новый номер ЗП и задача уходит на повторный подбор ЗП - придет эксперту
Test_6 - ИсполнительЗК_6_Внешние - выбирается выбирается несколько ЗП и задача идет дальше - приходит эксперту
Test_7 - ИсполнительЗК_1_ЭДО - задача отправляется эксперту на запрос информации
Test_8 - ИсполнительЗК_2_ЭДО - задача отправляется на корректировку
Test_9 - ИсполнительЗК_3_ЭДО -  задача отправляется менеджеру для изменения филиала
Test_10 - ИсполнительЗК_4_ЭДО - Подтверждается ЗП и задача отправляется на следующий этап - задача приходит на контроль наличия поступления в логистику
Test_11 - ИсполнительЗК_5_ЭДО - указывается новый номер ЗП и задача уходит на повторный подбор ЗП и придет на контроль лимита
Test_12 - ИсполнительЗК_6_ЭДО - выбирается выбирается несколько ЗП и задача идет дальше - приходит на контроль лимита
Test_13 - ИсполнительЗК_1_Дилеры - задача отправляется эксперту на запрос информации
Test_14 - ИсполнительЗК_2_Дилеры - задача отправляется на корректировку
Test_15 - ИсполнительЗК_3_Дилеры - задача отправляется менеджеру для изменения этапа
Test_16 - ИсполнительЗК_4_Дилеры - Подтверждается ЗП и задача отправляется на следующий этап - задача приходит в СИ
Test_17 - ИсполнительЗК_5_Дилеры - указывается новый номер ЗП и задача уходит на повторный подбор ЗП - приходит на контроль лимита

--Эксперт "Запрос информации"--
Test_1 - ЭкспертЗК_1_Внешние - задача открывается и возвращается обратно с комментарием - возврат в закупки
Test_2 - ЭкспертЗК_2_ЭДО - задача открывается и возвращается обратно с комментарием - возврат в закупки
Test_3 - ЭкспертЗК_3_Дилеры - задача открывается и возвращается обратно с комментарием - возврат в закупки

--Эксперт "Одобрение экспертом"--
Test_1 - ЭкспертОдобрение_1_Внешние - Отправка задачи дальше - придет в логистику на контроль наличия поступления
Test_2 - ЭкспертОдобрение_2_Внешние - отправка на корректировку  - придет инициатору ОО
Test_3 - ЭкспертОдобрение_3_Внешние - выбрать новую ЗП и отправить дальше - задача придет в логистику с новым ЗП

+ Test_4 - ЭкспертОдобрение_4_Внешние - выбрать две других ЗП и отправить дальше - задача придет в логистику с новыми ЗП

Test_5 - ЭкспертОдобрение_1_Счет -  Отправка задачи дальше - придет в СИ (проверка условия "Закупка низкой стоимости")
Test_6 - ЭкспертОдобрение_2_Счет -  Отправка задачи дальше - Владельцу ЦБО (проверка условия "Закупка не низкой стоимости")
Test_7 - ЭкспертОдобрение_3_Счет -  Отправка задачи дальше - На контроль лимита (проверка условия "Закупка не низкой стоимости")
Test_8 - ЭкспертОдобрение_4_Счет -  Отправка задачи дальше - На контроль наличия поступления (проверка условия "Закупка не низкой стоимости")
Test_9 - ЭкспертОдобрение_5_Счет -  Отправка задачи дальше - На подписание (проверка условия "Закупка не низкой стоимости")
Test_10 - ЭкспертОдобрение_6_Счет -  Отправка задачи дальше - На подписание (проверка условия "Закупка не низкой стоимости", автоначисление включено)


--Исполнитель закупок "Контроль лимита"--
Test 1 - ИсполнительЛимит_1_Внешние - Отправка задачи дальше - придет владельцу ЦБО на акцептование
Test 2 - ИсполнительЛимит_2_Внешние - Отправка задачи на корректировку - придет инициатору ОО
Test 3 - ИсполнительЛимит_3_Внешние - Выбрать другую ЗП из списка - уйдет в статус "На ожидание утверждения ЗП"
Test 4 - ИсполнительЛимит_4_Внешние - Указать новый номер ЗП - задача уйдет на "На ожидание утверждения ЗП"
Test 5 - ИсполнительЛимит_5_Внешние - Указать несколько ЗП - задача уйдет на "На ожидание утверждения ЗП"
Test 6 - ИсполнительЛимит_1_ЭДО - Отправка задачи дальше - придет в логистику на контроль наличия поступления
Test 7 - ИсполнительЛимит_2_ЭДО - Отправка задачи на корректировку - придет инициатору ОО
Test 8 - ИсполнительЛимит_3_ЭДО - Выбрать другую ЗП из списка - уйдет в статус "На ожидание утверждения ЗП"
Test 9 - ИсполнительЛимит_4_ЭДО - Указать новый номер ЗП - задача уйдет на "На ожидание утверждения ЗП"
Test 10 - ИсполнительЛимит_5_ЭДО - Указать несколько ЗП - задача уйдет на "На ожидание утверждения ЗП"
Test 11 - ИсполнительЛимит_1_Дилеры - Отправка задачи дальше - придет исполнителю в СИ1
Test 12 - ИсполнительЛимит_2_Дилеры - Отправка задачи на корректировку - придет инициатору ОО
Test 13 - ИсполнительЛимит_3_Дилеры - Выбрать другую ЗП из списка - уйдет в статус "На ожидание утверждения ЗП"
Test 14 - ИсполнительЛимит_4_Дилеры - Указать новый номер ЗП - задача уйдет на "На ожидание утверждения ЗП"

--ИнициаторПодписание--
Test 1 - ИнициаторПодписание_1_Внешние - Отправка дальше с простановкой подписи - задача уйдет в СИ
Test 2 - ИнициаторПодписание_2_Внешние - Отправка на корректировку - задача уйдет на корректировку в ГО инициаторов
Test 3 - ИнициаторПодписание_3_Внешние - Отправка дальше без простановки подписи - задача вернется в ГО инициаторов для подписания

--ИсполнительНаличиеПоступления--
Test 1 - ИсполнительНаличиеПоступления_1_Внешние - Отправка дальше - задача уйдет в СИ
Test 2 - ИсполнительНаличиеПоступления_2_Внешние - Отправка на корректировку - задача уйдет в ГО Инициаторов
Test 3 - ИсполнительНаличиеПоступления_1_ЭДО - Отправка дальше - задача уйдет в СИ
Test 4 - ИсполнительНаличиеПоступления_2_ЭДО - Отправка на корректировку - задача уйдет в ГО Инициаторов

--ИсполнительСИ1--
Test 1 - ИсполнительСИ1_1_Внешние - завершить обработку - уйдет в архив
Test 2 - ИсполнительСИ1_2_Внешние - Отправить на замену / досканирование документов - уйдет Эксперту
Test 3 - ИсполнительСИ1_3_Внешние - Скорректировать процесс / группу обработки - уйдет менеджеру
Test 4 - ИсполнительСИ1_4_Внешние - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в Отправить на замену / досканирование документов - уйдет эксперту
Test 5 - ИсполнительСИ1_5_Внешние - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в архив - уйдет в архив
Test 6 - ИсполнительСИ1_6_Внешние - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в Скорректировать процесс / группу обработки - уйдет менеджеру
Test 7 - ИсполнительСИ1_7_Внешние - отправить в СИ2
Test 8 - ИсполнительСИ1_8_Внешние - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в СИ2

Test 9 - ИсполнительСИ1_1_ЭДО - завершить обработку - уйдет в архив
Test 10 - ИсполнительСИ1_2_ЭДО - Отправить на замену / досканирование документов - уйдет Эксперту
Test 11 - ИсполнительСИ1_3_ЭДО - Скорректировать процесс / группу обработки - уйдет менеджеру
Test 12 - ИсполнительСИ1_4_ЭДО - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в Отправить на замену / досканирование документов - уйдет эксперту
Test 13 - ИсполнительСИ1_5_ЭДО - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в архив - уйдет в архив
Test 14 - ИсполнительСИ1_6_ЭДО - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в Скорректировать процесс / группу обработки - уйдет менеджеру
Test 15 - ИсполнительСИ1_7_ЭДО - отправить в СИ2
Test 16 - ИсполнительСИ1_8_ЭДО - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в СИ2

Test 17 - ИсполнительСИ1_1_Дилеры - завершить обработку - уйдет в архив
Test 18 - ИсполнительСИ1_2_Дилеры - Отправить на замену / досканирование документов - придет на корректировку в ОО
Test 19 - ИсполнительСИ1_3_Дилеры - Скорректировать процесс / группу обработки - уйдет менеджеру
Test 20 - ИсполнительСИ1_4_Дилеры - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в Отправить на замену / досканирование документов - уйдет эксперту
Test 21 - ИсполнительСИ1_5_Дилеры - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в архив - уйдет в архив
Test 22 - ИсполнительСИ1_6_Дилеры - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в Скорректировать процесс / группу обработки - уйдет менеджеру

Test 23 - ИсполнительСИ1_1_Аренда - завершить обработку - уйдет в архив
Test 24 - ИсполнительСИ1_2_Аренда - Скорректировать процесс / группу обработки - уйдет менеджеру
Test 25 - ИсполнительСИ1_3_Аренда - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в архив - уйдет в архив
Test 26 - ИсполнительСИ1_4_Аренда - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в Скорректировать процесс / группу обработки - уйдет менеджеру
Test 27 - ИсполнительСИ1_5_Аренда - Отправить на замену / досканирование документов - уйдет на корректировку
Test 28 - ИсполнительСИ1_6_Аренда - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в Отправить на замену / досканирование документов - уйдет на корректировку

--Эксперт "На доработке у Эксперта"
Test 1 - ДоработкаЭксперта_1_Внешние - переправить на "Корректировку"
Test 2 - ДоработкаЭксперта_2_Внешние - переправить на "Вернуть предыдущему исполнителю"
Test 3 - ДоработкаЭксперта_1_ЭДО - переправить на "Корректировку"
Test 4 - ДоработкаЭксперта_2_ЭДО - переправить на "Вернуть предыдущему исполнителю"

--ИсполнительСИИ2--
Test 1 - ИсполнительСИИ2_1_Внешние - завершить обработку - уйдет в архив
Test 2 - ИсполнительСИИ2_2_Внешние - Вернуть предыдущему исполнителю - вернется в СИ1
Test 3 - ИсполнительСИИ2_3_Внешние - Скорректировать процесс / группу обработки - уйдет менеджеру
Test 4 - ИсполнительСИИ2_4_Внешние - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит Вернуть предыдущему исполнителю  - вернется в СИ1
Test 5 - ИсполнительСИИ2_5_Внешние - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в архив - уйдет в архив
Test 6 - ИсполнительСИИ2_6_Внешние - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в Скорректировать процесс / группу обработки - уйдет менеджеру

Test 7 - ИсполнительСИИ2_1_ЭДО - завершить обработку - уйдет в архив
Test 8 - ИсполнительСИИ2_2_ЭДО - Вернуть предыдущему исполнителю - вернется в СИ1
Test 9 - ИсполнительСИИ2_3_ЭДО - Скорректировать процесс / группу обработки - уйдет менеджеру
Test 10 - ИсполнительСИИ2_4_ЭДО - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит Вернуть предыдущему исполнителю  - вернется в СИ1
Test 11 - ИсполнительСИИ2_5_ЭДО - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в архив - уйдет в архив
Test 12 - ИсполнительСИИ2_6_ЭДО - Отложить задачу - уйдет в отложен - вернет с "отложен" - отправит в Скорректировать процесс / группу обработки - уйдет менеджеру



----------------------------------------------------------------------------------------------------------------------------------------------------------
Внешние_1 (Услуги) -  документ приходит на подтверждение ЗП инициатору, он подтверждает одно зп и отправляет дальше
- задача приходит эксперту, ок подтверждает ЗП и отправляет дальше
-задача приходит пладельце ЦБО, он акцептует
- задача приходит инициатору ОО на подписание, он подписывает отправляет дальше
- задача приходит в исполнителю в СИ, он отправляет в архив

Внешние_2 (ТМЦ) -  документ приходит на подтверждение ЗП инициатору, он подтверждает одно зп и отправляет дальше
- задача приходит эксперту, он подтверждает ЗП и отправляет дальше
-задача приходит на контроль номера поступления, его прописывают и отправляю дальше
- задача приходит в СИ и ее отправляют в архив

Внешние_3 (Услуги) - документ приходит эксперту на подтверждение ЗП и отправляет дальше
- задача приходит владельцу ЦБО, он отклоняет
- задача приходит на корректировку инициатору ОО - инициатор отправляет задачу на на корректировку поставщику - инициатор возвращает документы с корректировки поставщика и возвращает задачу владельцу ЦБО
- владелец ЦБО акцептует задачу
- задача приходит в СИ1 и ее отправляют в архив

Внешние_4 (Услуги) - документ приходит инициатору на подтверждение ЗП, его отправляют с пустым номером ЗП в закупки
- в закупках задача отправляю на утверждение экперту
- задача приходит эксперту, он возвращает ее обратно
- Задаче подтверждают ЗП и отправляют дальше
- задача приходит Эксперту, он отправляет дальше
- задача приходит владельцу ЦБО, он откладывает задачу выбирая эксперта  - задача приходит эксперту, он отклоняет ее и завершает задачу
- Владелец ЦБО акцептует задачу
- задача приходит в СИ и отправляется в "Не принят"

Внешние_5 (ТМЦ) - задача приходит инициатору на подтверждение ЗП, он отправляет ее в закупки
- задача приходит в Закупки на создание/подтверждение ЗП ее отправляют на корректировку
- задача приходит инициатору на Корректировку, он отправляет на корректировку поставщиком - возвращает с корректировки поставщиком, возвращает предыдущему исполнителю
- задача возвращается на подтвержление/создание ЗП, подвтерждает ЗП и отправляет эксперту
- эксперт отправляет задачу на корректировку
- на корректировке инициатор отпправляет на корректировку поставщиком - возвращает с корректировки поставщиком и возвращает предыдущему исполнителю
- эксперт принимает задачу и отправляет дальше
- задача приходит на контроль лимита, ее отправляют на корректировку
- на корректировке отправляют на ожидание корректировки поставщиком, возвращают обратно и отправляют предыдущему исполнителю
- на контроле лимита задачу отправляют дальше по процессу
- задача приходит на проверку наличия поступления, отправляется на корректировку
- на корректировке инициатор отправляет на корректировку поставщиком - возвращает с корректировки поставщиком и возвращает предыдущему исполнителю
- задача возвращается на проверку наличия поступления, заполняется номер поступления и отправляется в СИ
- в СИ принимают задачу и отправляют в архив

Внешние_6 (ТМЦ) - задача приходит эксперту, он потправляет дальше
- задача приходит на подписание, ее отправляют на корректировку - задача приходит на корректировку, ее отправляют на ожидание корректировки поставщиком и повзращают
- задача возвращается на подписание, ее отправляют в СИ
- в СИ задачу отправляют на корректировку
- задача приходит эксперту, эксперт отправляет на корректировку - на корректировке задачу отправляют на корректировке поставщиком, вовзращают и отправляют обратно
- задача приходит эксперту, он вовращает в СИ
- в СИ задачу отправляют в Архив


