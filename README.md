# Работа мечты

## О проекте

* Приложение работает через интернет-браузер
* Система имеет две модели: вакансии и кандидаты
* Кандидаты размещают резюме
* Отдел кадров публикует вакансии
* Кандидаты могут откликнуться на вакансию. HR может пригласить кандидата на собеседование
* Авторизация и аутентификация пользователей

## Инструменты

- **Java 17**
- **Spring Boot 2.7.6**
- **PostgreSQL 14**
- **HTML 5**
- **Thymeleaf 2.7.6**
- **Bootstrap 4.4.1**
- **H2database 1.4.2**
- **SQL2o 1.6.0**
- **Commons-dbcp2 2.9.0**
- **Junit 5**
- **Mockito 4.8.0**
- **Liquibase 4.15.0**
- **Maven 3.8**
- **Git**

## Требования к окружению

- **Java 17**
- **Maven 3.8**
- **PostgresSQL 14**

## Сборка и запуск<br>

- **Создать БД**

``` shell 
create database dreamjob;
```

- **Запустить проект по команде**

``` shell 
mvn spring-boot:run -Pproduction
```

- **Перейти в браузере по ссылке**

``` shell 
http://localhost:8080/
```

## Взаимодействие с приложением<br>

### Если пользователь не зарегистрирован в системе, необходимо пройти регистрацию.
![img_5.png](images/img_5.png)

### На странице авторизации необходимо выполнить вход.
![img.png](images/img.png)

### На главной странице выведена общая информация о ресурсе.
![img_1.png](images/img_1.png)

### На странице с вакансиями можете посмотреть доступные предложения от работодателей.
![img_2.png](images/img_2.png)

### Если нажать на название вакансии, вы перейдете к подробному описанию вакансии, также предоставляется возможность редактирования/удаления вакансии.
![img_4.png](images/img_4.png)

### Если у работодателя открылась новая вакансия, то ее без проблем можно создать.
![img_3.png](images/img_3.png)

### На странице с резюме можете посмотреть кандидатов, которые ищут работу.
![img_6.png](images/img_6.png)

### Если нажать на название резюме, вы перейдете к подробному описанию кандидата, также предоставляется возможность редактирования/удаления резюме.
![img_8.png](images/img_8.png)

### Если кандидат хочет разместить резюме, то его без проблем можно создать.
![img_7.png](images/img_7.png)


## Контакты для связи<br>
<a href="https://t.me/OvercomingJunk" target="blank"><img src="https://img.icons8.com/clouds/50/000000/telegram-app.png"/></a>

