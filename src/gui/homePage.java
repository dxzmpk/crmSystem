package gui;

import model.Contract;
import model.MyModel;
import sql.SqlExecuter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class homePage {
    private JPanel homePage;
    private JPanel first;
    private JButton insertButton;
    private JButton joinButton;
    private JButton sonButton;
    private JButton groupButton;
    private JButton deleteButton;
    private JComboBox selectBox;
    private JLabel selectTableInstruction;
    private JLabel inputValueInstruction;
    private JButton executeButton;
    private JPanel tablePanel;
    private JScrollPane scrolBoard;
    private JTable resultTable;
    private JLabel resultNameLabel;
    private JTextArea valueTextArea;
    private JPanel bottomPanel;
    private JLabel resultLabel;
    private JComboBox hiddleBox;

    public homePage() {
        insertButton.addActionListener(new InsertBtnClicked());
        deleteButton.addActionListener(new DeleteBtnClicked());
        joinButton.addActionListener(new JoinBtnClicked());
        groupButton.addActionListener(new GroupBtnClicked());
        sonButton.addActionListener(new SonBtnClicked());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("homePage");
        frame.setContentPane(new homePage().bottomPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private class InsertBtnClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectTableInstruction.setText("请选择你要插入的表");
            handleInsert();
        }
    }

    private class DeleteBtnClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectTableInstruction.setText("请选择你要删除的表");
            inputValueInstruction.setText("请输入要删除的id");
            handleDelete();
        }
    }

    private class JoinBtnClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectTableInstruction.setText("请选择你要连接的表1、2");
            hiddleBox.setVisible(true);
            inputValueInstruction.setText("请输入连接条件");
            handleJoin();
        }
    }

    private class GroupBtnClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectTableInstruction.setText("请选择你要分组的表");
            hiddleBox.setVisible(false);
            inputValueInstruction.setText("请输入分组查询条件");
            handleGroup();
        }
    }

    private class SonBtnClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectTableInstruction.setText("请选择你要进行子查询的表");
            hiddleBox.setVisible(false);
            inputValueInstruction.setText("请输入子查询条件");
            handleGroup();
        }
    }

    private void handleDelete(){
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "delete from ";
                String tablename = (String) selectBox.getSelectedItem();
                System.out.println(tablename);
                sql += tablename + " where " + tablename.toLowerCase() + "_id = " + valueTextArea.getText() ;
                System.out.println(sql);
                boolean result = SqlExecuter.executeDelete(sql);
                if(result){
                    resultLabel.setText("删除成功");
                } else {
                    resultLabel.setText("删除失败");
                }
            }
        });
    }

    private void handleInsert(){
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "insert into ";
                String tablename = (String) selectBox.getSelectedItem();
                System.out.println(tablename);

                sql += tablename + " values(" + valueTextArea.getText() + ")" ;
                System.out.println(sql);
                boolean result = SqlExecuter.executeDelete(sql);
                if(result){
                    resultLabel.setText("插入成功");
                } else {
                    resultLabel.setText("插入失败");
                }
            }
        });
    }

    private void handleJoin(){
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from ";
                String tablename1 = (String) selectBox.getSelectedItem();
                String tablename2 = (String) hiddleBox.getSelectedItem();
                sql += tablename1 + ", " + tablename2 ;
                System.out.println(sql);
                List<Contract> contracts = SqlExecuter.executeSelect(sql);
                MyModel myModel = new MyModel();
                resultTable.setModel(myModel);
                Contract contract1 = new Contract("合同id","合同名称",
                        "甲方id","乙方id","合同条目名称",
                        "产品数量","活动id");
                myModel.addContract(contract1);
                for(Contract contract : contracts){
                    myModel.addContract(contract);
                }
            }
        });
    }

    private void handleGroup(){
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from ";
                String tablename = (String) selectBox.getSelectedItem();
                sql += tablename + " group by " + valueTextArea.getText() ;
                System.out.println(sql);
                List<Contract> contracts = SqlExecuter.executeGroup(sql);
                MyModel myModel = new MyModel();
                resultTable.setModel(myModel);
                Contract contract1 = new Contract("合同id","合同名称",
                        "甲方id","乙方id"," ", " ", " ");
                myModel.addContract(contract1);
                for(Contract contract : contracts){
                    myModel.addContract(contract);
                }
            }
        });
    }

    private void handleSon(){
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from ";
                String tablename = (String) selectBox.getSelectedItem();
                sql += tablename + " where " + valueTextArea.getText() ;
                System.out.println(sql);
                List<Contract> contracts = SqlExecuter.executeGroup(sql);
                MyModel myModel = new MyModel();
                resultTable.setModel(myModel);
                Contract contract1 = new Contract("合同id","合同名称",
                        "甲方id","乙方id","  ", " ", " ");
                myModel.addContract(contract1);
                for(Contract contract : contracts){
                    myModel.addContract(contract);
                }
            }
        });
    }

}
