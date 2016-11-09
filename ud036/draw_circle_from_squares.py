import turtle



def draw_square(square):

    for i in range(0,4):
        square.forward(100)
        square.right(90)

def draw_art():
    window = turtle.Screen()
    window.bgcolor("red")
    square = turtle.Turtle();
    square.shape("arrow")
    square.color("yellow")
    for i in range(1,37):
        draw_square(square)
        square.right(i)
    window.exitonclick()

draw_art()
