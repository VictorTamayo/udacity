import turtle

window = turtle.Screen()
window.bgcolor("blue")

flower = turtle.Turtle()
flower.shape("turtle")
flower.color("green")

def draw_petal():
    for i in range(1,10):
        flower.circle(100/i)

def draw_flower():
    for i in range(1,5):
        draw_petal()
        flower.right(90)
    flower.right(90)
    flower.forward(400)


draw_flower()
window.exitonclick()
