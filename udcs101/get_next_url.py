page =('<div id="top_bin"><div id="top_content" class="width960">'
'<div class="udacity float-left"><a href="http://udacity.com">')

def get_next_target(s):
    start_link = s.find('<a href=')
    first_quote = s.find('"',start_link)
    last_quote = s.find('"',first_quote+1)
    url = page[first_quote+1:last_quote]
    return url,last_quote

print(get_next_target(page))    
