while True:
    a, b, c = sorted(map(int, input().split()))
    if a == b == c == 0:
        break
    if c >= a + b:
        print("Invalid")
    elif a == b == c:
        print("Equilateral")
    elif a == b or b == c:
        print("Isosceles")
    else:
        print("Scalene")