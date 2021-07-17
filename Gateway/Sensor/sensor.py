import random
import time

def adjust(temprature):
    adjustment = random.choice([-0.03, 0.00, 0.03])
    return temprature + adjustment

temprature = round(random.uniform(0, 35), 2)
while True:
    time.sleep(1)
    temprature = adjust(temprature)
    output = round(temprature, 1)
    print(output)