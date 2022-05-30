class Car:
    'This is car class'

    def __init__(self,manufacturer, model, make, transmission, color ):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")
        

car1 = Car("Maruti","Baleno","2022","Automatic", "Blue")
car2 = Car("Hyundai","i20","2021","Manual", "Black")

car1.accelerate()
car2.stop()