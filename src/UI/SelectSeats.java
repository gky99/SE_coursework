/*
 * Copyright (c) 2017, Pauli Guan.
 *
 * Licensed under the General Public License, Version 2.0.
 * You may not use this file except in compliance with the Licese.
 * You may obtain a copy of the License at
 *
 *     https://www.gnu.org/licenses/gpl.txt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 */

package UI;

import Model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import javax.swing.*;
/**
 * Created by gky on 2017/5/26.
 */

public class SelectSeats {



    AvailableSeats available;	//存seats的对象
    JFrame frame;				//最外面的框
    JPanel panel,p1;			//panel面板上放的是座位图，p1面板上放的是座位图下面的东西
    JButton[][] button;			//座位的按钮
    JButton confirm = new JButton();//确认按钮
    JLabel[] row1 = new JLabel[5];//座位图左边的ABCDE标识
    JLabel[] row2 = new JLabel[5];//座位图右边的ABCDE标识

    JLabel selected = new JLabel();//这个label写的是已选中的座位
    JLabel note = new JLabel();//explain the color
    ArrayList<String> selectedlist = new ArrayList<String>();

    String selectedstring = "";

    char[] alphabet = {'A','B','C','D','E'};
    int count;
    ArrayList<Integer> rowindex = new ArrayList<Integer>();
    ArrayList<Integer> colindex = new ArrayList<Integer>();

    int[][] duplicate = new int[5][9];//用来防止重复选中座位 固定大小 座位不能超过5排9列

    final double perprice=16.0;
    double totalprice = 0.0;
    JLabel priceAmount = new JLabel();
    //JLabel priceadd = new JLabel();
    //ArrayList<String> pricebelongsto = new ArrayList<String>();
    //ArrayList<Double> pricelist = new ArrayList<Double>();


    JPopupMenu menu=new JPopupMenu();               //choose the type of ticket
    JMenuItem item1 = new JMenuItem("child(2 to 7 years old) 50% discount");
    JMenuItem item2 = new JMenuItem("Adult(18 years and older) no discount");
    JMenuItem item3 = new JMenuItem("Senior(55 years and older) 20% discount");
    JMenuItem item4 = new JMenuItem("Student(18 years and older and in full time education) 25% discount");
    int type=0;                     //the type of ticket
    boolean success;
    static HashMap<JButton, Integer> typerecord = new HashMap<JButton,Integer >();
    int bi,bj;

    String stuid;
    JPanel inputid=new JPanel();
    JLabel input=new JLabel("please input your student id:");
    JLabel noinput=new JLabel("empty input");
    JTextField f = new JTextField(15);
    JButton idconfirm ;
    JButton cancel ;
    Dialog d=new Dialog(frame, "please input your student id", success);
    public void initiate(){
        //【重要】
        //我拉下来的AvailableSeats像是没有写过的，所以下面这行代码使用了假的availableseats类
        //下面这行代码的作用是初始化AvailableSeats的对象available
        //使得available.seats这个二维vector拥有正确的值

        new ShowTable;
        item1.addActionListener(menuactionListener);
        item2.addActionListener(menuactionListener);
        item3.addActionListener(menuactionListener);
        item4.addActionListener(menuactionListener);
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        available = new AvailableSeats("filepath",2);
        d.setBounds(300, 150, 350, 150);
        f.setBounds(150, 150, 200, 150);
        d.setLayout(new FlowLayout());
        d.add(input);
        d.add(f);
        idconfirm = new JButton("confirm");
        idconfirm.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(f.getText().length()!=0){
                    stuid= f.getText();
                    System.out.println(stuid);
                    d.setVisible(false);
                    f.setText("");
                }
                else{
                    input.setText("No input,please input your student id:");

                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }});
        d.add(idconfirm);
        cancel = new JButton("cancel");
        cancel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                d.setVisible(false);
                f.setText("");

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }});
        d.add(cancel);

        frame = new JFrame("Select Seats");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(null);//frame没有布局 frame中所有panel都应该用setBounds设定x坐标，y坐标，长，高

        panel = new JPanel();
        panel.setBounds(0,0,800,300);//panel上是座位图，panel位于0,0 大小800,300
        panel.setBackground(new Color(255,255,255));
        panel.setLayout(new GridLayout(available.seats.size(), available.seats.get(0).size(),24,24));//panel是表格布局
        frame.add(panel);

        p1 = new JPanel();
        p1.setBounds(0, 300, 800, 300);//p1上是余下信息，p1位于0,300 大小800,300
        p1.setBackground(new Color(255,255,255));
        p1.setLayout(null);//p1没有布局 p1中所有组件都应该用setBounds设定位置和大小
        frame.add(p1);

        selected.setText("The Seats selected: ");
        note.setText("GREEN:Selected    BLUE:Selectable    RED:Unselectable");
        selected.setFont(new Font("serif",Font.BOLD,24));
        selected.setBounds(0,0,800,50);//已选座位的位置位于p1的0,0 大小800,50
        note.setFont(new Font("serif",Font.BOLD,24));
        note.setBounds(0,100,800,50);//已选座位的位置位于p1的0,0 大小800,50
        p1.add(selected);
        note.setForeground(Color.red);
        p1.add(note);

        priceAmount.setText("Total Ticket Price: "+String.format("%.2f",totalprice));
        priceAmount.setFont(new Font("serif",Font.BOLD,24));
        priceAmount.setBounds(0,50,800,50);//价格的位置位于p1的0,50 大小800,50
        p1.add(priceAmount);

        button=new JButton[available.seats.size()][available.seats.get(0).size()];
        for (int i=available.seats.size()-1; i>=0; i--){
            count=1;
            row1[i] = new JLabel();
            row1[i].setText("     "+alphabet[i]);
            row1[i].setFont(new Font("serif",Font.BOLD,18));
            panel.add(row1[i]);
            for (int j=available.seats.get(i).size()-1; j>=0; j--){
                button[i][j] = new JButton();
                button[i][j].setPreferredSize(new Dimension(50, 50));
                button[i][j].setMaximumSize(new Dimension(50, 50));
                panel.add(button[i][j]);
                button[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseReleased(MouseEvent arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mousePressed(MouseEvent arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseExited(MouseEvent arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseEntered(MouseEvent arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // TODO Auto-generated method stub
                        for(int i=0;i<button.length;i++){
                            for(int j=0;j<button[i].length;j++){
                                if(e.getSource()==button[i][j] && button[i][j].getText()!="--"&&duplicate[i][j] != 1){
                                    rowindex.add(i);
                                    colindex.add(j);
                                    duplicate[i][j] = 1;
                                    success=true;
                                    totalprice+=perprice;
                                    button[i][j].setBackground(Color.green);
                                    priceAmount.setText("Total Ticket Price: "+String.format("%.2f",totalprice));
                                    selectedlist.add(alphabet[i]+button[i][j].getText()+"  ");
                                    for (int m=0; m<selectedlist.size();m++){
                                        selectedstring = selectedstring + selectedlist.get(m);
                                    }
                                    selected.setText("The Seats selected: " + selectedstring);
                                    bi=i;
                                    bj=j;
                                    Point p = e.getPoint();
                                    menu.show(e.getComponent(), p.x, p.y);

                                    selectedstring = "";
                                }
                                else if(e.getSource()==button[i][j] && button[i][j].getText()!="--"&&duplicate[i][j] == 1){
                                    for (int search=0; search < rowindex.size(); search++){
                                        if (rowindex.get(search)==i&&colindex.get(search)==j){
                                            rowindex.remove(search);
                                            colindex.remove(search);
                                        }
                                    }
                                    duplicate[i][j] = 0;
                                    button[i][j].setBackground(Color.blue);
                                    Iterator<Entry<JButton, Integer>> iter = typerecord.entrySet().iterator();
                                    while (iter.hasNext()) {
                                        Map.Entry<JButton, Integer> entry = (Map.Entry<JButton, Integer>) iter.next();
                                        JButton key = entry.getKey();
                                        Integer val = entry.getValue();
                                        if(key==button[i][j]){
                                            if(val==1){
                                                totalprice-=perprice*0.5;



                                            }
                                            if(val==2){
                                                totalprice-=perprice;


                                            }
                                            if(val==3){
                                                totalprice-=perprice*0.8;


                                            }
                                            if (val==4){
                                                totalprice-=perprice*0.85;

                                            }
                                            typerecord.remove(button[i][j].getText());/////////
                                        }
                                    }
                                    for (int m=0; m<selectedlist.size(); m++){
                                        if (selectedlist.get(m).equals(alphabet[i]+button[i][j].getText()+"  ")){
                                            selectedlist.remove(m);
                                        }
                                    }
                                    for (int m=0; m<selectedlist.size();m++){
                                        selectedstring = selectedstring + selectedlist.get(m);
                                    }
                                    selected.setText("The Seats selected: " + selectedstring);
                                    selectedstring = "";

                                    //totalprice -= perprice;
                                    if(totalprice <= 0) totalprice = 0.0;
                                    priceAmount.setText("Total Ticket Price: "+String.format("%.2f",totalprice));
                                }
                            }
                        }
                    }


                });
            }
            for(int j=0;j<available.seats.get(i).size();j++){
                if(available.seats.get(i).get(j) == -1)		//-1 无座位
                    button[i][j].setVisible(false);
                else if (available.seats.get(i).get(j) == 1){ //1可选座位
                    button[i][j].setText(count++ + "");
                    button[i][j].setBackground(Color.blue);
                }
                else if (available.seats.get(i).get(j) == 0){ //0不可选座位
                    button[i][j].setText("--");
                    button[i][j].setBackground(Color.red);
                    count++;
                }
            }
            row2[i] = new JLabel();
            row2[i].setText(""+alphabet[i]);
            row2[i].setFont(new Font("serif",Font.BOLD,18));
            panel.add(row2[i]);
        }

        confirm.setText("Confirm");
        confirm.setBounds(0, 150, 100, 50);//确认按钮的位置位于p1的0,100 大小100,50
        confirm.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent arg0) {

                for(int i=0;i<selectedlist.size();i++){
                    try {
                        String path = "ticket";
                        File f = new File(path);
                        if(!f.exists()){
                            f.mkdirs();
                        }
                        String filename="ticket"+i+".txt";
                        File file=new File(f,filename);
                        if(!file.exists()){
                            file.createNewFile();
                        }
                        FileWriter fw=new FileWriter(file);
                        fw.write(generateid());
                        fw.write("\t");
                        fw.write(selectedlist.get(i));
                        fw.write("\t");
                        fw.flush();
                        fw.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            //这个方法的功能是
            //当用户点击confirm 将 【已选中座位】对应的available.seats中的标记从1变为0
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                for(int i=0; i<rowindex.size(); i++){
                    available.seats.get(rowindex.get(i)).setElementAt(0,colindex.get(i));
                }
                System.out.println(available.seats);//用于测试 查看available.seats
            }



        });
        p1.add(confirm);

        frame.setVisible(true);
        frame.repaint();
    }
    public ActionListener menuactionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == item1&&success) {
                type=1;
                totalprice-=perprice;
                totalprice+=perprice*0.5;
                success=false;

            }
            if (e.getSource() == item2&&success) {
                type=2;
                totalprice-=perprice;
                totalprice+=perprice;
                success=false;


            }
            if (e.getSource() == item3&&success) {
                type=3;
                totalprice-=perprice;
                totalprice+=perprice*0.8;
                success=false;


            }
            if (e.getSource() == item4&&success) {
                d.setVisible(true);
                type=4;
                totalprice-=perprice;
                totalprice+=perprice*0.85;
                success=false;

            }

            priceAmount.setText("Total Ticket Price: "+String.format("%.2f",totalprice));
            typerecord.put(button[bi][bj],type);

        }
    };
    public String generateid(){
        int[] id=new int[8];
        for(int i=0;i<=7;i++){
            Random rd = new Random();
            id[i]= rd.nextInt(4)+1;
        }
        String s = "";
        for(int i=0;i<id.length;i++){
            s = s + id[i];//拼接成字符串，最终放在变量s中
        }
        return s;



    }



}