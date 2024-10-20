def solve_test_case():
    n = int(input())
    numbers = map(int, input().split(' '))
    dic = {}
    for idx, num in enumerate(numbers):
        if num not in dic:
            dic[num] = (1, idx)
        else:
            count, _ = dic[num]
            dic[num] = (count + 1, idx)
    for num in dic.keys():
        count, idx = dic[num]
        if count == 1:
            print(idx + 1)
            break

def main():
    test_cases = int(input())
    while test_cases:
        solve_test_case()
        test_cases -= 1

if __name__ == '__main__':
    main()
