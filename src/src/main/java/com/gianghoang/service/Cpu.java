package com.gianghoang.service;

/**
 * Created by Administrator on 8/18/2016.
 */
public class Cpu implements Runnable{

    int number;

    public Cpu(int number){
        this.number = number;
    }

    public Cpu(){

    }

    void findSnt(int number){
        boolean check = true;
        for(int i = 2; i < number; i++){
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println(i + " ");
            }else {
                check = true;
            }
        }
    }


    @Override
    public void run() {
        findSnt(number);
    }


}
