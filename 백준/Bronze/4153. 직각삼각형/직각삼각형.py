import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    while True:
        a, b, c = map(int, input().split())
        if a == 0 and b == 0 and c == 0:
            break

        arr = [a, b, c]
        arr.sort()

        if arr[0] ** 2 + arr[1] ** 2 == arr[2] ** 2:
            print('right')
        else:
            print('wrong')


if __name__ == '__main__':
    main()