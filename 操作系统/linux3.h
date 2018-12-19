#include "stdio.h"
#include "string.h"

struct table
{
	int tablenum;//������
	int startaddr;//��ʼ��ַ
	int length;//����
	char state[10];//����״̬
};
table free[100];//���з�����
table used[100];//�ѷ��������
int freelength;//���з�������
int usedlength;//�ѷ����������
int procnum=0;//���̷�����
void initial();//��ʼ������
void firstfit();//�״���Ӧ�㷨
void bestfit();//�����Ӧ�㷨
void worstfit();//���Ӧ�㷨
void terminal();//��������
int transfer();//�߼���ַת��
void print();//��ӡ���

int main()
{
	printf("�ɱ�����洢����ϵͳ");
	initial();
	int s,n,x=1;
	print();
	while(x)
	{
		printf("1���������̣������� �ڴ��С��\n");
		printf("2���������̣���������\n");
		printf("3���߼���ַת��\n");
		printf("4���˳�\n");
	
	scanf("%c",&n);
	switch(n)
	{
	case 1:
		printf("1���״���Ӧ�㷨\n2�������Ӧ�㷨\n3�������Ӧ�㷨");
		scanf("%c",&s);
		switch(s)
		{
		case 1:firstfit();break;
		case 2:bestfit();break;
		case 3:worstfit();break;
		}
		print();break;
	case 2:
		terminal();
		print();
		break;
	case 3:
		transfer();
		break;
	case 4:
		x=0;
		break;
	}
	}
	
	return 0;
}

void initial()
{
	for(int i=0;i<100;i++)
	{
		free[i].tablenum=-1;
		free[i].startaddr=-1;
		free[i].length=0;
		strcpy(free[i].state,"free");
		used[i].tablenum=-1;
		used[i].startaddr=-1;
		used[i].length=0;
		strcpy(used[i].state,"used");
	}
	freelength=0;
	usedlength=0;
	free[0].tablenum=0;
	free[0].startaddr=0;
	free[0].length=50;
	free[1].tablenum=1;
	free[1].startaddr=50;
	free[1].length=100;
	free[2].tablenum=2;
	free[2].startaddr=150;
	free[2].length=80;
	free[3].tablenum=3;
	free[3].startaddr=230;
	free[3].length=40;
	free[4].tablenum=4;
	free[4].startaddr=270;
	free[4].length=200;
	free[5].tablenum=5;
	free[5].startaddr=470;
	free[5].length=150;
	freelength=6;
}

void print()
{
	printf("���з�����\n");
	printf("������\t��ʼ��ַ\t��С\t״̬\n");
	for(int i=0;i<freelength;i++)
	{
		printf("free[i].tablenum\tfree[i].startaddr\tfree[i].length\tfree[i].state\n");
	}
	printf("�ѷ��������\n");
	printf("������\t��ʼ��ַ\t��С\t״̬\n");
	for(int i=0;i<freelength;i++)
	{
		printf("used[i].tablenum\nused[i].startaddr\nused[i].length\nused[i].state\n");
	}
}

int transfer()
{
	int m;
	printf("����Ҫת���ķ����ţ�\n");
	scanf("%d",&m);
	for(int i=0;i<usedlength;i++)
	{
		if(used[i].tablenum==m)
		{
			printf("%d�������ַ��%d\n",m,used[i].startaddr);
			retun 1;
		}
	}
	printf("l�߼��������������");
	return 0;
}

void firstfit()
{
	char procname[20];
	int proclength;
	int i,j,flag,t;
	printf("����������ƺʹ�С��\n");
	scanf("%s %d",&procname,&proclength);
	for(i=0;i<freelength;i++)
	{
		if(free[i].length>=proclength)
		{
			flag=1;
		}
	}
	if(flag==0)
	{
		printf("������Ҫ��Ŀռ��ڴ棬���Ժ�����\n");
	}
	else
	{
		t=0;
		i=0;
		while(t==0)
		{
			if(free[i].length>=proclength)
			{
				t=1;
			}
			i++;
		}
		i--;
		used[usedlength].startaddr=free[i].startaddr;
		strcat(used[usedlength].state,procname);
		used[usedlength].length=proclength;
		used[usedlength].tablenum=procnum;
		usedlength++;
		procnum++;
		if(free[i].length>proclength)
		{
			//��������������������
			free[i].startaddr+=proclength;
			free[i].length-=proclength;
		}
		else
		{
			//��������������������
			for(j=i;j<freelength-1;j++)
			{
				free[j]=free[j+1];
			}
			freelength--;
		}
		printf("�ڴ�ռ����ɹ���\n");
	}
}

void bestfit()
{

}

void worstfit()
{

}

void terminal()
{
	char procname[20];
	int proclength;
	int i,j,flag,p=0;
	int start;
	int length;
	printf("����Ҫ�����Ľ�������\n");
	scanf("%s",&procname);
	char buffer[20];
	strcpy(buffer,"used");
	strcat(buffer,procname);
	falg=-1;
	for(i=0;i<usedlength;i++)
	{
		//Ѱ��ָ�����Ƶ���ҵ
		if(!strcmp(used[i].state,buffer))
		{
			falg=i;
			start=used[i].startaddr;
			length=used[i].length;
		}
	}
	if(flag==-1)
	{
		printf("û�������������\n");
	}
	else
	{
		for(i=0;i<freelength;i++)
		{
			if(free[i].startaddr+free[i].length)==start//��ǰ�ߵ��ڽ�
			{
				if(((i+1)<freelength)&&(free[i+1].startaddr==start+length))//������һ�����б����
				{
					free[i].length=free[i].length+free[i+1].length+length;//����ϲ�
					for(j=i+1;j<freelength;j++)
					{
						fre[j]=free[j+1];
					}
					free;ength--;
					p=1;
				}
				else//����ϲ�
				{
					free[i].length+=length;
					p=1;
				}
			}
			if(free[i].startaddr==(start+length))//�����ڽ�
			{
				free[i].startaddr=start;
				free[i].length+=length;
				p=1;
			}
		}
		if(p==0)//�Ȳ���ǰ�ڽӣ�Ҳ������ڽ�
		{
			free[freelength].startaddr=start;
			free[freelength].length=length;
			free[freelength].tablenum=free[freelength-1].tablenum+1;
			freelength++;
		}
		for(i=flag;i<usedlength;i++)
		{
			used[i]=used[i+1];
		}
		usedlength--;
	}
}