def store_car (manufacturer, model, year, color, price):
    car = {
        'manufacturer': manufacturer,
        'model': model,
        'color': color,
    }
    return car

car_1 = store_car('subaru', 'Outback', 'blue', two_package = True)
car_2 = store_car('Honda', 'Acoord', 'white',year = 1991, headlight = 'popup')

print(car_1)
print(car_2)