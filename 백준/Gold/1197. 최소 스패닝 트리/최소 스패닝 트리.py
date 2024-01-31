import sys


def input(): return sys.stdin.readline().rstrip()


V, E = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(E)]


parent = [i for i in range(V + 1)]


def find(a):
    if parent[a] == a:
        return a

    parent[a] = find(parent[a])

    return parent[a]


def union(a, b):
    a = find(parent[a])
    b = find(parent[b])

    if a == b:
        return False

    parent[max(a, b)] = min(a, b)
    return True


graph.sort(key=lambda x: x[2])

print(sum(c for a, b, c in graph if union(a, b)))