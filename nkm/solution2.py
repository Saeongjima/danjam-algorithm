while True:
    a, b, c = map(int, input().split())

    if a == 0 and b == 0 and c == 0:
        break

    # max() 사용하지 않고 직접 비교
    if a > b:
        if a > c:
            max_side, sum_of_others = a, b + c
        else:
            max_side, sum_of_others = c, a + b
    else:
        if b > c:
            max_side, sum_of_others = b, a + c
        else:
            max_side, sum_of_others = c, a + b

    # 삼각형 유효성 및 종류 판별
    if sum_of_others <= max_side:
        print("Invalid")
    elif a == b == c:
        print("Equilateral")
    elif a == b or b == c or a == c:
        print("Isosceles")
    else:
        print("Scalene")

'''
최적화된 코드: 성능과 메모리 절감
'''