import urllib

def read_text():
    quotes = open("movie_quotes.txt")
    contents_of_file = quotes.read()
    check_profanity(contents_of_file)
    quotes.close()

def check_profanity(text_to_check):
    url = "http://www.wdylike.appspot.com/?q="
    connection = urllib.urlopen(url + text_to_check)
    output = connection.read()
    if "true" in output:
        print("Profanity Alert!!")
    elif "false" in output:
        print("This document has no curse words!")
    connection.close()

read_text()
