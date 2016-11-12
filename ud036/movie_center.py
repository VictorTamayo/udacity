import movie
import fresh_tomatoes

toy_story = movie.Movie("Toy Story",
"A story of a boy and his toys that come to life",
"http://upload.wikimedia.org/wikipedia/en/1/13/Toy_Story.jpg",
"https://www.youtube.com/watch?v=vwyZH85NQC4")

conan_barberian = movie.Movie("Conan The Barberian",
 "A man seeks revenge for the destruction of his village",
 "https://upload.wikimedia.org/wikipedia/en/8/81/Conan_the_Barbarian_by_Renato_Casaro.jpg",
 "https://www.youtube.com/watch?v=YGKJC22Roxs")

movie_list =[toy_story, conan_barberian]
fresh_tomatoes.open_movies_page(movie_list)
