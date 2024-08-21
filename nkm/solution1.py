while True:
    sides = list(map(int, input().split()))

    # 입력이 0 0 0인 경우 종료
    if sides == [0, 0, 0]:
        break

    sides.sort()
    a, b, c = sides

    if a + b <= c:
        print("Invalid")
    elif a == b == c:
        print("Equilateral")
    elif a == b or b == c:
        print("Isosceles")
    else:
        print("Scalene")

'''
기본 코드: 성능 최적화 중점
'''