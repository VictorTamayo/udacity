import webbrowser
import time
count = 0;
music_videos = ["https://www.youtube.com/watch?v=M0Sloitb9Jg",
"http://www.youtube.com/watch?v=dQw4w9WgXcQ",
"https://www.youtube.com/watch?v=iPXKfGxeHIY",
"https://www.youtube.com/watch?v=58Le1Ove61o"]
breaks = len(music_videos)
print("This program started on " + time.ctime())
while count < breaks:
    time.sleep(60*60*2)
    webbrowser.open(music_videos.pop())
    count = count + 1
