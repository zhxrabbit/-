#include <stdio.h>
#include<string.h>
#include<stdlib.h>
int cipan[100]={1,1,1,1,1,1,1,1,1,1};
struct USER
{
	char name[20];
	char passwd[20];
	int id;
}user[10]={{"abc","123",0},{"xyz","123",1}};
struct MFD//主文件目录
{                 
	char filename[20];  //文件名
	char mode;          //文件属性
	int length;         //文件长度 
	int address[4];     //文件地址 
}mfd[10][20]={{{"a",'r',3,{0,1,2}},{"b",'w',2,{3,4}}},{{"x",'r',3,{5,6,7}},{"y",'w',2,{8,9}}}};
struct UOF//用户已打开文件表 
{                
	char filename[20];  //文件名 
	char mode;          //文件属性 
	int length;         //文件长度 
	char status[10];    //状态（已打开） 
	int read;           //读指针 
	int write;          //写指针 
}uof[10];
int login()//登录账户
{                
	int i;
	char name[20];
	char passwd[20];
	printf("\t\t用户名: ");
	scanf("%s",&name);
	printf("\t\t密码: ");
	scanf("%s",&passwd);
	for(i=0;i<10;i++)
		if(strcmp(user[i].name,name)==0)
		{
			if(strcmp(user[i].passwd,passwd)==0)
				return user[i].id;
			else
			{
				printf("\t\t密码错误！\n");
				return -1;
			}
		}
	printf("\t\t用户名不存在！\n");
	return -1;
}
void create(int id)//建立文件 
{        
	int i,j,k;
	char mode,file[10];
	printf("\t\t输入用户名:");
	scanf("%s",&file);
	getchar();
	printf("\t\t输入操作权限:");
	scanf("%c",&mode);
	for(i=0;i<20;i++)
	{
		if(strcmp(mfd[id][i].filename,file)==0)
		{
			printf("\t\t文件名已存在！\n");
			return;
		}
	}
	for(i=0;i<20;i++)
	{
		if(strlen(mfd[id][i].filename)==0)
		{
			for(j=0;j<100;j++)
			{
				if(cipan[j]==0)
					break;
			}		
			strcpy(mfd[id][i].filename,file);
			mfd[id][i].mode=mode;
			mfd[id][i].length=1;
			mfd[id][i].address[0]=j;
			cipan[j]=1;		
			for(i=0;i<10;i++)
			{
				if(strlen(uof[i].filename)==0)
				{
					strcpy(uof[i].filename,file);
					uof[i].length=1;
					uof[i].mode=mode;
					strcpy(uof[i].status,"create");
					uof[i].write=j;
					uof[i].read=j;
					printf("\t\t文件建立成功！\n");
					return;	
				}
			}
		}
	}	
}
void open(int id)//打开文件
{             
	int i,j;
	char file[10];
		printf("\t\t输入文件名:");
	scanf("%s",&file);
	for(i=0;i<20;i++){
		if(strcmp(mfd[id][i].filename,file)==0){
			for(j=0;j<10;j++){
				if(strcmp(uof[j].filename,file)==0){
					if(strcmp(uof[j].status,"create")==0){
						printf("\t\t文件建立！\n");
						return;
					}
					strcpy(uof[j].status,"open");
					printf("\t\t文件已打开！\n");
					return;
				}
			}
			for(j=0;j<10;j++){
				if(strlen(uof[j].filename)==0)
				{
					strcpy(uof[j].filename,file);
					uof[j].length=mfd[id][i].length;
					uof[j].mode=mfd[id][i].mode;
					strcpy(uof[j].status,"open");
					uof[j].write=mfd[id][i].address[0];
					uof[j].read=mfd[id][i].address[0];
					printf("\t\t成功打开文件成功！\n");
					return;
				}
			}
		}
	}
	printf("\t\t文件不存在！\n");
	return;
}
void write(int id)//写文件
{            
	int i,j,n,k=1;
	int kuai; 
	char file[10];
	char sequence;
	printf("\t\t输入文件名:");
	scanf("%s",&file);
	getchar();
	for(n=0;n<20;n++)
	{
		if(strcmp(mfd[id][n].filename,file)==0);
		break;
	}
	for(i=0;i<10;i++)
	{
		if(strcmp(uof[i].filename,file)==0)
		{		
			if(strcmp(uof[i].status,"create")==0)
			{
					printf("\t\t%d\n",uof[i].write);		
					printf("\t\t写文件成功！\n");
					return;				
			}
			else
			{
				if(uof[i].mode=='r')
				{
					printf("\t\t文件操作权限只读不能写！\n");
					return ;
				}
				else
				{
					printf("\t\tmodify?----Y/N:");
					scanf("%c",&sequence);
					if(sequence=='Y')
					{
						printf("\t\t%d\n",uof[i].write);
							printf("\t\t写文件成功！\n");
					return;
					}
					else
					{
						printf("\t\t输入块号:");
						scanf("%D",&kuai);
						printf("\t\t%d\n",kuai);
						printf("\t\t写入成功！\n");
					return;
					}
				}
			}	
		}
	}
	printf("\t\tf文件没打开或没建立！\n");
	return ;	
}
void read(int id)//读文件
{             
	int i,j;
	for(i=0;i<20;i++)
	{
		if(strlen(mfd[id][i].filename)==0);
		else
		{
			printf("\t\t%s\t",mfd[id][i].filename);
			printf("%c\t",mfd[id][i].mode);
			printf("%d\t",mfd[id][i].length);
			for(j=0;j<mfd[id][i].length;j++)
			{
				printf("%d\t",mfd[id][i].address[j]);
			}
			printf("\n");
		}
	}
	for(i=0;i<10;i++)
	{
		if(strlen(uof[i].filename)==0);
		else
		{
			printf("\t\t%s\t",uof[i].filename);
			printf("%c\t",uof[i].mode);
			printf("%d\t",uof[i].length);
			printf("%s\t",uof[i].status);
			printf("%d\t",uof[i].read);
			printf("%d\t",uof[i].write);
			printf("\n");
		}
	}
} 
int main()
{
	int id,n=1,choice;
	printf("\t\t请先登录!\n");
	while((id=login())==-1);
	while(1)
	{
		printf("\t\t1.建立文件\n"); 
		printf("\t\t2.打开文件\n"); 
		printf("\t\t3.写文件\n"); 
		printf("\t\t0.退出\n");
		printf("\t\t请输入选择:"); 
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:create(id);read(id);break;
			case 2:open(id);read(id);break;
			case 3:write(id);read(id);break;
			case 0:exit(0);
	    }
	}				
}
