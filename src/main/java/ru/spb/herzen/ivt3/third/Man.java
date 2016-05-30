package ru.spb.herzen.ivt3.third;

import java.util.Random;

public class Man extends Thread{
    public int money;
    private int startMoney;

    private Man friend;

    public Man(String name, int money) {
        super();
        this.setName(name);

        this.money = money;
        this.startMoney = money;
    }

    public int getStartMoney() {
        return startMoney;
    }

    public void setFriend(Man friend) {
        this.friend = friend;
    }

    public void run() {
        Random random = new Random();
        int check = friend.getStartMoney() + this.getStartMoney();
        for (int i = 0; i< 1000; i++) {
            int amount = random.nextInt(money);

            this.money = this.money - amount;
            friend.money = friend.money + amount;

            int tmpf = this.money;
            int tmps = friend.money;
            System.out.println(amount + " " + tmpf + " " + tmps);

            if (tmpf + tmps != check) {
                System.out.println("YOU FACED RACE CONDITION");
            }

            try {
                Thread.sleep(10);
            } catch (Exception exception) {};


        }
    }
}

