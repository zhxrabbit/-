#include "stdio.h"
#include "string.h"

struct table
{
	int tablenum;//分区号
	int startaddr;//起始地址
	int length;//长度
	char state[10];//分配状态
};
table free[100];//空闲分区表
table used[100];//已分配分区表
int freelength;//空闲分区表长度
int usedlength;//已分配分区表长度
int procnum=0;//进程分区号
void initial();//初始化分区
void firstfit();//首次适应算法
void bestfit();//最佳适应算法
void worstfit();//最坏适应算法
void terminal();//结束进程
int transfer();//逻辑地址转换
void print();//打印输出

int main()
{
	printf("可变分区存储管理系统");
	initial();
	int s,n,x=1;
	print();
	while(x)
	{
		printf("1、创建进程（进程名 内存大小）\n");
		printf("2、结束进程（进程名）\n");
		printf("3、逻辑地址转换\n");
		printf("4、退出\n");
	
	scanf("%c",&n);
	switch(n)
	{
	case 1:
		printf("1、首次适应算法\n2、最佳适应算法\n3、最差适应算法");
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
	printf("空闲分区表：\n");
	printf("分区号\t起始地址\t大小\t状态\n");
	for(int i=0;i<freelength;i++)
	{
		printf("free[i].tablenum\tfree[i].startaddr\tfree[i].length\tfree[i].state\n");
	}
	printf("已分配分区表：\n");
	printf("分区号\t起始地址\t大小\t状态\n");
	for(int i=0;i<freelength;i++)
	{
		printf("used[i].tablenum\nused[i].startaddr\nused[i].length\nused[i].state\n");
	}
}

int transfer()
{
	int m;
	printf("输入要转换的分区号：\n");
	scanf("%d",&m);
	for(int i=0;i<usedlength;i++)
	{
		if(used[i].tablenum==m)
		{
			printf("%d的物理地址：%d\n",m,used[i].startaddr);
			retun 1;
		}
	}
	printf("l逻辑分区号输入错误。");
	return 0;
}

void firstfit()
{
	char procname[20];
	int proclength;
	int i,j,flag,t;
	printf("输入进程名称和大小：\n");
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
		printf("无满足要求的空间内存，请稍后再试\n");
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
			//空闲区域大于申请的区域
			free[i].startaddr+=proclength;
			free[i].length-=proclength;
		}
		else
		{
			//空闲区域等于申请的区域
			for(j=i;j<freelength-1;j++)
			{
				free[j]=free[j+1];
			}
			freelength--;
		}
		printf("内存空间分配成功。\n");
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
	printf("输入要结束的进程名：\n");
	scanf("%s",&procname);
	char buffer[20];
	strcpy(buffer,"used");
	strcat(buffer,procname);
	falg=-1;
	for(i=0;i<usedlength;i++)
	{
		//寻找指定名称的作业
		if(!strcmp(used[i].state,buffer))
		{
			falg=i;
			start=used[i].startaddr;
			length=used[i].length;
		}
	}
	if(flag==-1)
	{
		printf("没有这个进程名。\n");
	}
	else
	{
		for(i=0;i<freelength;i++)
		{
			if(free[i].startaddr+free[i].length)==start//与前边的邻接
			{
				if(((i+1)<freelength)&&(free[i+1].startaddr==start+length))//分配了一个空闲表表项
				{
					free[i].length=free[i].length+free[i+1].length+length;//三块合并
					for(j=i+1;j<freelength;j++)
					{
						fre[j]=free[j+1];
					}
					free;ength--;
					p=1;
				}
				else//两块合并
				{
					free[i].length+=length;
					p=1;
				}
			}
			if(free[i].startaddr==(start+length))//与后边邻接
			{
				free[i].startaddr=start;
				free[i].length+=length;
				p=1;
			}
		}
		if(p==0)//既不与前邻接，也不与后邻接
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