#include <bits/stdc++.h>
using namespace std;
const int MAX = 100;
void BinarySearch_Changed(int *a, int value, int left, int right, int &i, int &j)
{
    int mid, rright = right, lleft = left;
    while(left <= right)
    {
        mid = (left + right) / 2;
        if(value == a[mid])
        {
            i = j = mid;
            return;
        }
        else if(value < a[mid])
        {
            right = mid - 1;
        }
        else
        {
            left = mid + 1;
        }
    }
    i = left - 1, j =  left;
    if(left  > rright)
        i = rright, j = -1;
    if(right < 0)
        i = -1, j = 0;
}
int main()
{
    int a[MAX];
    int i, j, num, value;
    scanf("%d", &num);
    for(int i = 0; i < num; ++i)
    {
        scanf("%d", &a[i]);
    }
    scanf("%d", &value);
    BinarySearch_Changed(a, value, 0, num - 1, i, j);
    printf("i = %d , j = %d", i, j);
}
