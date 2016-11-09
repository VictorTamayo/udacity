import turtle

def draw_square():
    square = turtle.Turtle()
    square.shape("turtle")
    square.speed(10)
    square.color("yellow")
    steps = 100
    angle = 90

    for i in range(0,4):
        square.forward(steps)
        square.right(angle)



def draw_circle():
    circle = turtle.Turtle()
    circle.shape("square")
    circle.color("blue")
    circle.circle(100)

def draw_triangle():
    triangle = turtle.Turtle()
    triangle.shape("arrow")
    triangle.color("green")

    triangle.backward(100)
    triangle.right(90)
    triangle.forward(100)
    triangle.right(225)
    triangle.forward(150)

"""main program"""
window = turtle.Screen()
window.bgcolor("red")
draw_square()
draw_circle()
draw_triangle()
window.exitonclick()
