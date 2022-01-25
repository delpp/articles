Aplikacja jest uruchamiana metodą main w klasie ArticlesApplication.

Endpointy:
1. Zwraca wszystkie artykuły prasowe posortowane od najnowszego do najstarszego. (Request: GET /localhost:8080/articles?sort=publicationDate)
2. Tworzy nowy artykuł. (Request: POST /localhost:8080/articles z ciałem np w formacie JSON:
   {
   "title": "Title1",
   "description": "description1",
   "publicationDate": "2013-01-01",
   "titleOfJournal": "titleOfJournal1",
   "authorName": "First Name 1",
   "authorSecondName": "Second Name 1",
   "articleSaveDate": ""
   }
Zastosowana walidacja: pole "title" nie może być puste".
)
3. Odczytuje artykuł po id. (Request: GET /localhost:8080/articles/{id}).
4. Aktualizuje wybrany po id artykuł. (Request: PUT /localhost:8080/articles/{id}).
5. Zwraca wszystkie artykuły prasowe po słowie kluczowym zawartym w tytule lub treści publikacji. (Request: GET /localhost:8080/articles/search/{word}).

Warstwą persystencji jest zapis do bazy danych H2 (plik: articles-db).