import sys
from collections import deque
input=sys.stdin.readline

# N 값
n=int(input()) 
# 숫자
number_list=list(map(int,input().split()))
# 연산자
operator_list=list(map(int,input().split()))

#시작점
start=number_list[0]

#연산 완료된 리스트 넣기
answer=[]

#백트래킹 사용하여 모든 수식 풀기
#numList= 숫자 리스트 operList= 연산자 리스트 count = 연산 횟수 k= count 만큼 연산 했을때의 수
def solve(numList,operList,k,count):
    if count!=n-1:
        num=numList[count+1]
        for i in range(4):
            if operList[i]!=0:
                operList[i]-=1
                count+=1
                if i==0:
                    solve(numList,operList,k+num,count)
                elif i==1:
                    solve(numList,operList,k-num,count)
                elif i==2:
                   solve(numList,operList,k*num,count)
                elif i==3:
                    temp=0
                    # 음수일경우 양수로 변환후 몫 구하고 음수로 바꾸고 넣기
                    if k<0:
                        temp=-k
                        temp=temp//num
                        temp=-temp
                    else:
                        temp=k//num
                    solve(numList,operList,temp,count)
                #백트래킹
                count-=1
                operList[i]+=1
                
    # 연산을 모두 했을 경우
    elif count==(n-1):
        answer.append(k)
        return 


solve(number_list,operator_list,start,0)
print(max(answer))
print(min(answer))