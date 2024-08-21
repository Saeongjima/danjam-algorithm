def is_triangle_valid(a, b, c):
    return a + b > c and a + c > b and b + c > a

def classify_triangle(a, b, c):
    if not is_triangle_valid(a, b, c):
        return "Invalid"
    if a == b == c:
        return "Equilateral"
    if a == b or b == c or a == c:
        return "Isosceles"
    return "Scalene"

def main():
    while True:
        a, b, c = map(int, input().split())

        if a == 0 and b == 0 and c == 0:
            break
        
        print(classify_triangle(a, b, c))

if __name__ == "__main__":
    main()

'''
추상화된 코드: 유지보수성과 가독성 중점
'''