#include "stdio.h"
#define n 4
int w[n],v[n],a[n],c;
float t[n],s;
void sort()
{
	int i,j,b,m;
	for(i=0;i<n;i++) a[i]=i;
	for(i=0;i<n;i++)
	{
		b=i;
		for(j=i+1;j<=n;j++)
		if(t[b]<t[j])
		b=j; //��bָ��ÿ�����������ε����Ԫ��
		s=t[i];
		t[i]=t[b];
		t[b]=s;
		m=a[i];a[i]=a[b];a[b]=m;
	}
}
int main()
{
	int i,j,sc;
	float sumv;
	printf("��������Ʒ������:\n");
	for(i=0;i<n;i++)
	scanf("%d",&w[i]);
	printf("��������Ʒ�ļ�ֵ:\n");
	for(i=0;i<n;i++)
	scanf("%d",&v[i]);
	printf("�����뱳��������:\n");
	scanf("%d",&c);
	for(i=0;i<n;i++)
	t[i]=(float)v[i]/(float)w[i];
	for(i=0;i<n;i++)
	printf("%f ",t[i]);
	printf("\n");
	sort();
	sumv=0;
	sc=c;
	for(i=0;i<n;i++)
	{
		if(sc>=w[a[i]])
		{
			sc-=w[a[i]];
			sumv=sumv+v[a[i]];
		}
			else
			{
				if(sc<w[a[i]])
				break;
			}
	}
	sumv=sumv+v[a[i]]*sc/w[a[i]];
	printf("��������Ʒ������ֵΪ��%f",sumv);
	getch();
	return 0;
	}
