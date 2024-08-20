#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    vector<int> result;
    int n, x;
    cin >> n;

    priority_queue<int, vector<int>, greater<int>> q;

    for (int i = 0; i < n; i++)
    {
        cin >> x;
        if (x != 0)
        {
            q.push(x);
        }
        else
        {
            if (q.empty())
            {
                result.push_back(0);
            }
            else
            {
                result.push_back(q.top());
                q.pop();
            }
        }
    }

    for (int ele : result)
    {
        cout << ele << "\n";
    }
    return 0;
}