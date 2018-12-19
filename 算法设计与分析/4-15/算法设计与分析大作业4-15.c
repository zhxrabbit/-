#include <stdio.h>
int fun(int n){
    int a[100];//保存分解后的数 
    int k=1,sum=1;//k为数组a索引，sum乘积
    int i,j;

    a[1]=2; //先减2,注意这里索引是1
    n-=2;
    while(n>a[k]){  //循环减
        k++;
        a[k]=a[k-1]+1;
        n-=a[k];
    }
    if(n==a[k]){//相等，最后的再加1。
        a[k]++;
        n--;
    }
    for(i=0;i<n;i++)//以10为例，这里n=1，然后每个元素+1
        a[k-i]++;
    for(j=1;j<=k;j++){//从1开始
        sum*=a[j];
    }
    return sum;
}

int main(){
    int n,m;
    FILE *fin,*fout;
    fin = fopen("input.txt","r"); // 打开文件，按读的方式打开
    fscanf(fin,"%d", &n);
    printf("input.txt输入n:10\n");
    m=fun(n);
    fout=fopen("output.txt", "w");// 打开文件，按写的方式打开
    fprintf(fout,"%d",m);
    fclose(fout);
    printf("输出%d output.txt\n",m);
    return 0;
}

