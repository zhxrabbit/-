#include <stdio.h>
int fun(int n){
    int a[100];//����ֽ����� 
    int k=1,sum=1;//kΪ����a������sum�˻�
    int i,j;

    a[1]=2; //�ȼ�2,ע������������1
    n-=2;
    while(n>a[k]){  //ѭ����
        k++;
        a[k]=a[k-1]+1;
        n-=a[k];
    }
    if(n==a[k]){//��ȣ������ټ�1��
        a[k]++;
        n--;
    }
    for(i=0;i<n;i++)//��10Ϊ��������n=1��Ȼ��ÿ��Ԫ��+1
        a[k-i]++;
    for(j=1;j<=k;j++){//��1��ʼ
        sum*=a[j];
    }
    return sum;
}

int main(){
    int n,m;
    FILE *fin,*fout;
    fin = fopen("input.txt","r"); // ���ļ��������ķ�ʽ��
    fscanf(fin,"%d", &n);
    printf("input.txt����n:10\n");
    m=fun(n);
    fout=fopen("output.txt", "w");// ���ļ�����д�ķ�ʽ��
    fprintf(fout,"%d",m);
    fclose(fout);
    printf("���%d output.txt\n",m);
    return 0;
}

