package com.example.algoterm;

import android.util.Log;

import java.util.Scanner;

class Subject { //과목이름, 과목별 공부시간, 과목별 중요도
	private String name = new String();
	private int time = 0;
	private int val = 0;

	public void Setname(String name){
		this.name=name;
	}
	public void Settime(int time){
		this.time=time;
	}
	public void Setval(int val){
		this.val=val;
	}
	public String Getname(){
		return name;
	}
	public int Gettime(){
		return time;
	}
	public int Getval(){
		return val;
	}

}

class User{ //오늘 공부할 과목수, 목표 공부 시간
	private int num;
	private int total;

	public User() {
		this.num=0;
		this.total=0;
	}
	public int getnum() {
		return num;
	}
	public void setnum(int num) {
		this.num=num;
	}
	public int gettotal() {
		return total;
	}
	public void settotal(int total) {
		this.total=total;
	}

}

class knapsack{
	//최종결과
	String output = new String();

	public void sort(Subject[] arr,int num){ // (중요도/시간) 를 기준으로 내림차순 정렬
		int len=num;

		Subject tep= new Subject();
		for(int i=0;i<len;i++){ //버블소트로 정렬
			for(int j=0;j<len-i-1;j++){
				if((arr[j].Getval()/arr[j].Gettime())<(arr[j+1].Getval()/arr[j+1].Gettime())){
					//swap
					tep=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tep;
				}
			}
		}
	}

	public void fractional(Subject[] arr,Subject[] sequence,int total,int num){

		int goal=total,i=0,j=0,n=0;
		int[] remain=new int[total]; //남은 공부량 저장하는 배열 객체 생성
		
		while(true){
			if(goal==0) //남은 시간이 0 인 경우
				break;
			//남은 시간이 있는 경우
			else if(goal>=arr[i].Gettime()){
				goal-=arr[i].Gettime();
				sequence[n].Setname(arr[i].Getname()); //공부 순서 배열에 저장
				sequence[n].Settime(arr[i].Gettime());
				sequence[n].Setval(arr[i].Getval());
				n++;
				i++;
			}
			//남은 시간은 있지만 과목 목표 시간보다 적은 경우
			else if(goal<arr[i].Gettime()){
				sequence[n].Setname(arr[i].Getname());
				sequence[n].Settime(goal);
				sequence[n].Setval(arr[i].Getval());
				n++;
				arr[i].Settime(arr[i].Gettime()-goal);
				for(j=0;j<num-i;j++){ //남은 공부량 저장하기
					remain[j]=i;
					i++;
				}
				break;
			}
		}

		String output2 = new String();
		System.out.println("<오늘의 공부순서>"); //공부 순서 출력
		for(int k=0;k<n;k++){
			output = output+(k+1)+". "+sequence[k].Getname()+" : "+sequence[k].Gettime()+"시간"+"\n";
		}
		System.out.println();
		System.out.println("<남은 공부량>"); //남은 공부량 출력
		for(int k=0;k<j;k++){
			output2 = output2 +( k+1)+". "+arr[remain[k]].Getname()+" : "+arr[remain[k]].Gettime()+"시간"+"\n";

		}
		output = output+ "@" + output2;

	}

	String PrintOut(){
		return output;
	}

}

	

