## Запрос фильма
```shell
curl -X 'GET' \
  'https://kinopoiskapiunofficial.tech/api/v2.2/films/5304403' \
  -H 'accept: application/json' \
  -H 'X-API-KEY: ee97857e-9b91-4df5-b64f-576965097621'
```

## Ответ по фильму
```json
{
  "kinopoiskId": 5304403,
  "kinopoiskHDId": null,
  "imdbId": null,
  "nameRu": "Слово пацана. Кровь на асфальте",
  "nameEn": null,
  "nameOriginal": null,
  "posterUrl": "https://kinopoiskapiunofficial.tech/images/posters/kp/5304403.jpg",
  "posterUrlPreview": "https://kinopoiskapiunofficial.tech/images/posters/kp_small/5304403.jpg",
  "coverUrl": null,
  "logoUrl": null,
  "reviewsCount": 81,
  "ratingGoodReview": 61,
  "ratingGoodReviewVoteCount": 43,
  "ratingKinopoisk": 9,
  "ratingKinopoiskVoteCount": 471814,
  "ratingImdb": 7,
  "ratingImdbVoteCount": 1350,
  "ratingFilmCritics": null,
  "ratingFilmCriticsVoteCount": 0,
  "ratingAwait": 99,
  "ratingAwaitCount": 10297,
  "ratingRfCritics": 100,
  "ratingRfCriticsVoteCount": 6,
  "webUrl": "https://www.kinopoisk.ru/film/5304403/",
  "year": 2023,
  "filmLength": 50,
  "slogan": null,
  "description": "Конец 1980-х. Пока родители борются за выживание, брошенные всеми дети сбиваются в уличные стаи и бьются за асфальт. Буквально, чтобы контролировать всё, что стоит на «их» земле или передвигается по ней. Среди всеобщей нищеты — понятные правила жизни, поддержка и слово пацана, которое сильнее клятвы.\n14-летний Андрей из интеллигентной семьи, он учится в музыкальной школе и живёт с мамой и пятилетней сестрой. Парень регулярно сталкивается с прессингом уличных подростков и, чтобы защититься, заводит дружбу с гопниками. Один из них — 14-летний Марат — становится проводником Андрея в сложноустроенный мир улиц.",
  "shortDescription": null,
  "editorAnnotation": null,
  "isTicketsAvailable": false,
  "productionStatus": null,
  "type": "TV_SERIES",
  "ratingMpaa": null,
  "ratingAgeLimits": "age18",
  "countries": [
    {
      "country": "Россия"
    }
  ],
  "genres": [
    {
      "genre": "драма"
    },
    {
      "genre": "криминал"
    }
  ],
  "startYear": 2023,
  "endYear": null,
  "serial": true,
  "shortFilm": false,
  "completed": false,
  "hasImax": false,
  "has3D": false,
  "lastSync": "2023-12-14T23:41:22.079225"
}
```

## Запрос актёров в фильме

```shell
curl -X 'GET' \
  'https://kinopoiskapiunofficial.tech/api/v1/staff?filmId=507' \
  -H 'accept: application/json' \
  -H 'X-API-KEY: ee97857e-9b91-4df5-b64f-576965097621'
```

## Ответ по актёрам в фильме

```json
[
  {
    "staffId": 27977,
    "nameRu": "Джеймс Кэмерон",
    "nameEn": "James Cameron",
    "description": null,
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/27977.jpg",
    "professionText": "Режиссеры",
    "professionKey": "DIRECTOR"
  },
  {
    "staffId": 6264,
    "nameRu": "Арнольд Шварценеггер",
    "nameEn": "Arnold Schwarzenegger",
    "description": "Terminator",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/6264.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 38338,
    "nameRu": "Майкл Бин",
    "nameEn": "Michael Biehn",
    "description": "Kyle Reese",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/38338.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 28012,
    "nameRu": "Линда Хэмилтон",
    "nameEn": "Linda Hamilton",
    "description": "Sarah Connor",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/28012.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 3898,
    "nameRu": "Пол Уинфилд",
    "nameEn": "Paul Winfield",
    "description": "Traxler",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/3898.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 1464,
    "nameRu": "Лэнс Хенриксен",
    "nameEn": "Lance Henriksen",
    "description": "Vukovich",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/1464.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 68910,
    "nameRu": "Рик Россович",
    "nameEn": "Rick Rossovich",
    "description": "Matt",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/68910.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 65300,
    "nameRu": "Бесс Мотта",
    "nameEn": "Bess Motta",
    "description": "Ginger",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/65300.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 30221,
    "nameRu": "Эрл Боэн",
    "nameEn": "Earl Boen",
    "description": "Silberman",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/30221.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 32995,
    "nameRu": "Дик Миллер",
    "nameEn": "Dick Miller",
    "description": "Pawn Shop Clerk",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/32995.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 44171,
    "nameRu": "Шон Шеппс",
    "nameEn": "Shawn Schepps",
    "description": "Nancy",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/44171.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 1525157,
    "nameRu": "Брюс Кернер",
    "nameEn": "Bruce M. Kerner",
    "description": "Desk Sergeant",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/1525157.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 835727,
    "nameRu": "Франко Коломбо",
    "nameEn": "Franco Columbu",
    "description": "Future Terminator",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/835727.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 985,
    "nameRu": "Билл Пэкстон",
    "nameEn": "Bill Paxton",
    "description": "Punk Leader",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/985.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156485,
    "nameRu": "Брэд Рирден",
    "nameEn": "Brad Rearden",
    "description": "Punk",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156485.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 3222,
    "nameRu": "Брайан Томпсон",
    "nameEn": "Brian Thompson",
    "description": "Punk",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/3222.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 20954,
    "nameRu": "Уильям Уишер мл.",
    "nameEn": "William Wisher",
    "description": "Policeman (в титрах: William Wisher Jr.)",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/20954.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 123469,
    "nameRu": "Кен Фриц",
    "nameEn": "Ken Fritz",
    "description": "Policeman",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/123469.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156486,
    "nameRu": "Том Оберхауз",
    "nameEn": "Tom Oberhaus",
    "description": "Policeman",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156486.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156487,
    "nameRu": "Эд Доганс",
    "nameEn": "Ed Dogans",
    "description": "Cop in Alley",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156487.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 123839,
    "nameRu": "Джо Фараго",
    "nameEn": "Joe Farago",
    "description": "TV Anchorman",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/123839.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 144394,
    "nameRu": "Хетти Линн Хёртес",
    "nameEn": "Hettie Lynne Hurtes",
    "description": "TV Anchorwoman",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/144394.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156488,
    "nameRu": "Тони Мирелез",
    "nameEn": "Tony Mirelez",
    "description": "Station Attendant",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156488.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 108747,
    "nameRu": "Филип Гордон",
    "nameEn": "Philip Gordon",
    "description": "Mexican Boy",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/108747.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 130754,
    "nameRu": "Энтони Трухильо",
    "nameEn": "Anthony Trujillo",
    "description": "Mexican Boy (в титрах: Anthony T. Trujillo)",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/130754.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 81850,
    "nameRu": "Стэн Йейл",
    "nameEn": "Stan Yale",
    "description": "Derelict",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/81850.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 32695,
    "nameRu": "Аль Кан",
    "nameEn": "Al Kahn",
    "description": "Customer",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/32695.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 130749,
    "nameRu": "Лесли Моррис",
    "nameEn": "Leslie Morris",
    "description": "Customer",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/130749.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 137759,
    "nameRu": "Хью Фаррингтон",
    "nameEn": "Hugh Farrington",
    "description": "Customer",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/137759.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 92854,
    "nameRu": "Харриет Медин",
    "nameEn": "Harriet Medin",
    "description": "Customer",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/92854.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156489,
    "nameRu": "Лори Фрэзиер",
    "nameEn": "Loree Frazier",
    "description": "Customer",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156489.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 111654,
    "nameRu": "Джеймс Ралстон",
    "nameEn": "James Ralston",
    "description": "Customer",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/111654.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156490,
    "nameRu": "Норман Фридман",
    "nameEn": "Norman Friedman",
    "description": "Cleaning Man (в титрах: Norma Friedman)",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156490.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156491,
    "nameRu": "Барбара Пауэрс",
    "nameEn": "Barbara Powers",
    "description": "Ticket Taker",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156491.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156492,
    "nameRu": "Уэйн Стоун",
    "nameEn": "Wayne Stone",
    "description": "Tanker Driver",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156492.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156378,
    "nameRu": "Дэвид Мишелс",
    "nameEn": "David Michels",
    "description": "Tanker Partner",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156378.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156493,
    "nameRu": "Джон Е. Бристоль",
    "nameEn": "John E. Bristol",
    "description": "Phone Booth Man",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156493.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156494,
    "nameRu": "Уэбстер Уильямс",
    "nameEn": "Webster Williams",
    "description": "Reporter",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156494.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 196,
    "nameRu": "Патрик Пинни",
    "nameEn": "Patrick Pinney",
    "description": "Bar Customer",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/196.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 154998,
    "nameRu": "Билл В. Ричмонд",
    "nameEn": "Bill W. Richmond",
    "description": "Bartender",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/154998.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 119528,
    "nameRu": "Чино «Фэтс» Уильямс",
    "nameEn": "Chino «Fats» Williams",
    "description": "Truck Driver",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/119528.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156495,
    "nameRu": "Грегори Роббинс",
    "nameEn": "Greg Robbins",
    "description": "Motel Customer (в титрах: Gregory Robbins)",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156495.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 52712,
    "nameRu": "Марианн Мюллерлейл",
    "nameEn": "Marianne Muellerleile",
    "description": "Wrong Sarah",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/52712.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 156496,
    "nameRu": "Джон Дурбан",
    "nameEn": "John Durban",
    "description": "Sentry",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/156496.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 1874,
    "nameRu": "Робин Антин",
    "nameEn": "Robin Antin",
    "description": "Ferro, в титрах не указан",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/1874.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 3635,
    "nameRu": "Мэриэн Грин",
    "nameEn": "Marian Green",
    "description": "Dancer Shot by the Terminator, в титрах не указан",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/3635.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 1724774,
    "nameRu": "Дж. Рэндольф Харрисон",
    "nameEn": "J. Randolph Harrison",
    "description": "Policeman, в титрах не указан",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/1724774.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 295598,
    "nameRu": "Дэвид Кристин",
    "nameEn": "David Kristin",
    "description": "Punk, в титрах не указан",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/295598.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 105974,
    "nameRu": "Дэррелл Мапсон",
    "nameEn": "Darrell Mapson",
    "description": "Bar Patron at Pay Phone with Sarah, в титрах не указан",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/105974.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 5353516,
    "nameRu": "",
    "nameEn": "Bob Ritchie",
    "description": "Bar Patron, в титрах не указан",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/5353516.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 155063,
    "nameRu": "Джон Стюарт Уэст",
    "nameEn": "John Stuart West",
    "description": "MacDougal, в титрах не указан",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/155063.jpg",
    "professionText": "Актеры",
    "professionKey": "ACTOR"
  },
  {
    "staffId": 125093,
    "nameRu": "Джон Дэйли",
    "nameEn": "John Daly",
    "description": "исполнительный продюсер",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/125093.jpg",
    "professionText": "Продюсеры",
    "professionKey": "PRODUCER"
  },
  {
    "staffId": 5270898,
    "nameRu": "Дерек Гибсон",
    "nameEn": "Derek Gibson",
    "description": "исполнительный продюсер",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/5270898.jpg",
    "professionText": "Продюсеры",
    "professionKey": "PRODUCER"
  },
  {
    "staffId": 25428,
    "nameRu": "Гейл Энн Хёрд",
    "nameEn": "Gale Anne Hurd",
    "description": "продюсер (produced by)",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/25428.jpg",
    "professionText": "Продюсеры",
    "professionKey": "PRODUCER"
  },
  {
    "staffId": 307647,
    "nameRu": "Людмила Логийко",
    "nameEn": "",
    "description": null,
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/307647.jpg",
    "professionText": "Режиссеры дубляжа",
    "professionKey": "VOICE_DIRECTOR"
  },
  {
    "staffId": 1680962,
    "nameRu": "Юлия Бирюкова",
    "nameEn": "",
    "description": "дубляж для Blu-Ray",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/1680962.jpg",
    "professionText": "Режиссеры дубляжа",
    "professionKey": "VOICE_DIRECTOR"
  },
  {
    "staffId": 27977,
    "nameRu": "Джеймс Кэмерон",
    "nameEn": "James Cameron",
    "description": null,
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/27977.jpg",
    "professionText": "Сценаристы",
    "professionKey": "WRITER"
  },
  {
    "staffId": 25428,
    "nameRu": "Гейл Энн Хёрд",
    "nameEn": "Gale Anne Hurd",
    "description": null,
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/25428.jpg",
    "professionText": "Сценаристы",
    "professionKey": "WRITER"
  },
  {
    "staffId": 20954,
    "nameRu": "Уильям Уишер мл.",
    "nameEn": "William Wisher",
    "description": "дополнительные диалоги",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/20954.jpg",
    "professionText": "Сценаристы",
    "professionKey": "WRITER"
  },
  {
    "staffId": 608127,
    "nameRu": "Адам Гринберг",
    "nameEn": "Adam Greenberg",
    "description": null,
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/608127.jpg",
    "professionText": "Операторы",
    "professionKey": "OPERATOR"
  },
  {
    "staffId": 608126,
    "nameRu": "Брэд Фидель",
    "nameEn": "Brad Fiedel",
    "description": null,
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/608126.jpg",
    "professionText": "Композиторы",
    "professionKey": "COMPOSER"
  },
  {
    "staffId": 164865,
    "nameRu": "Мария Ребман Казо",
    "nameEn": "Maria Caso",
    "description": "по декорациям",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/164865.jpg",
    "professionText": "Художники",
    "professionKey": "DESIGN"
  },
  {
    "staffId": 338491,
    "nameRu": "Джордж Костильо",
    "nameEn": "George Costello",
    "description": null,
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/338491.jpg",
    "professionText": "Художники",
    "professionKey": "DESIGN"
  },
  {
    "staffId": 2010852,
    "nameRu": "Хилари Райт",
    "nameEn": "Hilary Wright",
    "description": "по костюмам",
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/2010852.jpg",
    "professionText": "Художники",
    "professionKey": "DESIGN"
  },
  {
    "staffId": 137722,
    "nameRu": "Марк Голдблатт",
    "nameEn": "Mark Goldblatt",
    "description": null,
    "posterUrl": "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/137722.jpg",
    "professionText": "Монтажеры",
    "professionKey": "EDITOR"
  }
]
```
Красные огни
