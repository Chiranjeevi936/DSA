

class calculator():


    def sum(self, a,b):
        print(f"sum of {a} , {b} : {a+b}")

    def sum(self, a,b,c):
        print(f"sum of {a} , {b}, {c} : {a+b+c}")

    def diff(self, a,b):
        print(f"substraction of {a}, {b} : {a-b}")

    def mult(self, a,b):
        print(f"multiplication of {a}, {b}: {a*b}")
    
    def mult(self, a,b,c):
        print(f"multiplication of {a}, {b}, {c}: {a*b*c}")



cal = calculator()

a = int(input("Enter a: "))
b = int(input("Enter b: "))
c = int(input("Enter c: "))

cal.sum(a,b)

cal.sum(a,b,c)

