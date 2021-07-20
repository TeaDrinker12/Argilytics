import random
import time

def initialTemprature():
    return round(random.uniform(0, 35), 2)

def adjust(temprature):
    adjustment = random.choice([-0.03, 0.00, 0.03])
    return temprature + adjustment

temprature = initialTemprature()
while True:
    temprature = adjust(temprature)
    output = round(temprature, 1)
    print(output)
    time.sleep(0.1)
