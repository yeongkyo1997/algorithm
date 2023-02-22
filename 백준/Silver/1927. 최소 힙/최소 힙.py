import sys
import heapq

heap = []
result = []
for t in range(int(input())):
    n = int(sys.stdin.readline().rstrip())

    if n == 0:
        if not len(heap):
            result.append(0)
        else:
            result.append(heapq.heappop(heap))
    else:
        heapq.heappush(heap, n)
       
for i in result:
    print(i)
