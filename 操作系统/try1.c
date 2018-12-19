#include <stdio.h>
#include <string.h>
#define N 12
typedef struct 
{
	int page;         //页号
	int flag;         //标志
	int block;        //主存块号
	int mark;         //修改标志
}table;               //页表
typedef struct 
{
	char operation;   //操作
	int page;         //页号
	int address;      //页内地址
}list;                //指令序列
table table1[7]={{0,1,5,0},{1,1,8,0},{2,1,9,0},{3,1,12,0},{4,0,0,0},{5,0,0,0},{6,0,0,0}};
list list1[N]={{'+',0,70},{'+',1,50},{'*',2,15},{'S',3,21},{'L',0,56},{'-',6,40},{'M',4,53},{'+',5,23},{'S',1,37},{'L',2,78},{'+',4,10},{'S',6,48}};
int vec[5]={0};
int flg[5]={0};

int main()
{
	int n,i,j,k=0,pos,page,flag,mark,memaddress;
	for(i=0;i<N;i++)
	{
		mark=0;
		page=list1[i].page;
		flag=table1[page].flag;
		if(i<4)
		{
			for(j=i;j>=0;j--)
				vec[j]=vec[j-1];
			vec[0]=page;
			flag=1;
			if(list1[i].operation=='S')
				table1[page].mark=1;		
		}
	    else
		{
			for(j=0;j<4;j++)
			{
				if(page==vec[j])
				{
					mark=1;
					pos=j;
				}
			}
			if(mark)
			{
				for(j=pos+1;j>=0;j--)
					vec[j]=vec[j-1];
				vec[0]=page;
			}
			else
			{
				for(j=4;j>=0;j--)
					vec[j]=vec[j-1];
				pos=vec[4];
				table1[page].block=table1[pos].block;
			    table1[page].flag=table1[pos].flag;
			    table1[pos].flag=0;
		   	    table1[pos].mark=0;
			    table1[pos].block=0;
			    vec[0]=page;
				if(list1[i].operation=='S')
					table1[page].mark=1;
			}
			for(n=0;n<4;n++)
				printf("%d\t",vec[n]);
			printf("");
		}
		if((list1[i].page<7)&&i>3)
		{
			memaddress=table1[page].block*1024+list1[i].address;//物理地址
			printf("页号为%d的操作是%c，它的物理地址为：%ld\n",table1[page].page,list1[page].operation,memaddress);
		}
	}
	return 0;
}
